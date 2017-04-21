package com.github.librarian.service.common;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.MethodUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Created by zack.wu on 2017/4/20.
 * 通用服务类
 */
@Component
public class GeneralService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Object selectByExample(String mapperClass, Map map)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
       return selectByExample(mapperClass,map,"","");
    }

    public Object selectByExample(String mapperClass,Map map,String convertClassId,String dtoClassId)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        logger.info("传入参数:"+ JSON.toJSONString(map));

        List listEntity; //原始dataobject
        List convertListEntity; //转化厚的对象
        try{
            Object mapper = getMapperObject(mapperClass);
            Object example = getExampleObject(mapperClass);
            Object criteria = MethodUtils.invokeMethod(example,"or",null);
            MethodUtils.invokeMethod(criteria,"andMap",map);
            listEntity = queryList(map, mapper, example);
        }catch (NoSuchBeanDefinitionException exception){
            logger.error(exception.getMessage());
            throw exception;
        }

        Class dtoBeanClass = getDtoBeanClass(mapperClass, dtoClassId);
        if (dtoBeanClass != null){
            //需要转化
            Object convertObject = getConvertObject(convertClassId);
            convertListEntity = (List) MethodUtils.invokeMethod(convertObject,"Convert",new Object[]{listEntity,dtoBeanClass});
        }else{
            convertListEntity = listEntity;
        }
        if(isPaging(map)){
            PageInfo pageInfo = new PageInfo(listEntity);
            pageInfo.setList(convertListEntity);
            return  pageInfo;
        }
        return listEntity;
    }

    private Class getDtoBeanClass(String mapperClass,String dtoClassId){
        if (StringUtils.isEmpty(dtoClassId)){
            dtoClassId = mapperClass+"Dto"; // 默认dto对象
        }
        try{
            Object bean = SpringContextUtils.getBeanById(dtoClassId);
            return  bean.getClass();
        }catch (NoSuchBeanDefinitionException exception){
            //不做转换
           return null;
        }
    }

    private List queryList(Map map, Object mapper, Object example) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if(isPaging(map)){
            PageHelper.startPage(getPageNumber(map),getPageSize(map));
        }
        return  (List) MethodUtils.invokeMethod(mapper, "selectByExample", example);
    }

    private Object getExampleObject(String mapperClass) {
        String exampleClassName = mapperClass+"Example";
        return SpringContextUtils.getBeanById(exampleClassName);
    }

    public int insert(String mapperClass,Object dto,String convertClassId) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        try{
            Object mapper = getMapperObject(mapperClass);
            Object convertObject = getConvertObject(convertClassId);
            Object entityObject = SpringContextUtils.getBeanById(mapperClass);
            Object entity = MethodUtils.invokeMethod(convertObject, "Convert", new Object[]{dto, entityObject.getClass()});
            return (Integer) MethodUtils.invokeMethod(mapper,"insert",entity);
        }catch (NoSuchBeanDefinitionException exception){
            logger.error(exception.getMessage());
            throw exception;
        }
    }
    public int updateByPrimaryKey(String mapperClass,Object dto,String convertClassId) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        try{
            Object mapper = getMapperObject(mapperClass);
            Object convertObject = getConvertObject(convertClassId);
            Object entityObject = SpringContextUtils.getBeanById(mapperClass);
            Object entity = MethodUtils.invokeMethod(convertObject, "Convert", new Object[]{dto, entityObject.getClass()});
            return (Integer) MethodUtils.invokeMethod(mapper,"updateByPrimaryKey",entity);
        }catch (NoSuchBeanDefinitionException exception){
            logger.error(exception.getMessage());
            throw exception;
        }
    }


    /**
     * 是否需要分页
     * @param params
     * @return
     */
    private boolean isPaging(Map params){
        logger.info("是否启用分页："+params.containsKey("pageNumber"));
        return  params.containsKey("pageNumber");

    }

    private Integer getPageNumber(Map params){
        String pageNumber = "pageNumber";
        if (params.containsKey(pageNumber)){
            return (Integer) params.get(pageNumber);
        }
        return  -1;
    }
    private Integer getPageSize(Map params){
        String pageSize = "pageSize";
        if (params.containsKey(pageSize)){
            return (Integer) params.get(pageSize);
        }
        return  10;
    }

    private Object getConvertObject(String convertClassId) {
        if (StringUtils.isEmpty(convertClassId)){
            convertClassId = "GeneralConvert";//启用默认转换规则
        }
        return SpringContextUtils.getBeanById(convertClassId);
    }
    private Object getMapperObject(String mapperClass) {
        String mapperClassName = mapperClass+"Mapper";
        return SpringContextUtils.getBeanById(mapperClassName);
    }
}
