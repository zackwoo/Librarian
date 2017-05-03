package com.github.librarian.service.common;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.MethodUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * Created by zack.wu on 2017/4/28.
 */

@Component
public class GeneralServiceImpl implements IGeneralService {
    public Object selectByPrimaryKey(Class mapperClass, Object id) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object mapperObject = SpringContextUtils.getBeanByClass(mapperClass);
        return MethodUtils.invokeMethod(mapperObject, "selectByPrimaryKey", id);
    }

    public Object selectByPrimaryKey(Class mapperClass, Object id, Class returnDtoBeanClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object convertObject = SpringContextUtils.getBeanById("generalBeanConvert");
        return selectByPrimaryKey(mapperClass,id,returnDtoBeanClass,convertObject.getClass());
    }

    public Object selectByPrimaryKey(Class mapperClass, Object id, Class returnDtoBeanClass, Class convertClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object entity = selectByPrimaryKey(mapperClass, id);
        return convertData(returnDtoBeanClass, convertClass, entity);
    }

    public List<?> selectByExample(Class mapperClass, Class exampleClass, Map arguments) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object mapper = SpringContextUtils.getBeanByClass(mapperClass);
        Object example = getExampleObject(exampleClass, arguments);
        return  queryList(arguments, mapper, example);
    }

    public List<?> selectByExample(Class mapperClass, Class exampleClass, Object argumentsDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return  selectByExample(exampleClass,exampleClass,new BeanMap(argumentsDto));
    }

    public List<?> selectByExample(Class mapperClass, Class exampleClass, String argumentsJson) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return  selectByExample(exampleClass,exampleClass, JSON.parseObject(argumentsJson,Map.class));
    }

    private Object getExampleObject(Class exampleClass, Map arguments) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object example = SpringContextUtils.getBeanByClass(exampleClass);
        Object criteria = MethodUtils.invokeMethod(example, "or", null);
        MethodUtils.invokeMethod(criteria, "andMap", arguments);
        return example;
    }

    public List<?> selectByExample(Class mapperClass, Class exampleClass, Map arguments, Class returnDtoBeanClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object convertObject = SpringContextUtils.getBeanById("generalBeanConvert");
        return selectByExample(mapperClass,exampleClass,arguments,returnDtoBeanClass,convertObject.getClass());
    }

    public List<?> selectByExample(Class mapperClass, Class exampleClass, Object argumentsDto, Class returnDtoBeanClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Map map = new BeanMap(argumentsDto);
        return selectByExample(mapperClass,exampleClass,map,returnDtoBeanClass);
    }

    public List<?> selectByExample(Class mapperClass, Class exampleClass, String argumentsJson, Class returnDtoBeanClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return selectByExample(mapperClass,exampleClass,JSON.parseObject(argumentsJson,Map.class),returnDtoBeanClass);
    }

    public List<?> selectByExample(Class mapperClass, Class exampleClass, Map arguments, Class returnDtoBeanClass, Class convertClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<?> list = selectByExample(mapperClass, exampleClass, arguments);
        return (List<?>) convertData(returnDtoBeanClass,convertClass,list);
    }

    public List<?> selectByExample(Class mapperClass, Class exampleClass, Object argumentsDto, Class returnDtoBeanClass, Class convertClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return selectByExample(mapperClass,exampleClass,new BeanMap(argumentsDto),returnDtoBeanClass,convertClass);
    }

    public List<?> selectByExample(Class mapperClass, Class exampleClass, String argumentsJson, Class returnDtoBeanClass, Class convertClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return selectByExample(mapperClass,exampleClass,JSON.parseObject(argumentsJson,Map.class),returnDtoBeanClass,convertClass);
    }

    public PageInfo<?> selectByExampleWithPaging(Class mapperClass, Class exampleClass, Map arguments) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<?> objects = selectByExample(mapperClass, exampleClass, arguments);
        return new PageInfo(objects);
    }

    public PageInfo<?> selectByExampleWithPaging(Class mapperClass, Class exampleClass, Object argumentsDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return selectByExampleWithPaging(mapperClass,exampleClass,new BeanMap(argumentsDto));
    }

    public PageInfo<?> selectByExampleWithPaging(Class mapperClass, Class exampleClass, String argumentsJson) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return selectByExampleWithPaging(mapperClass,exampleClass,JSON.parseObject(argumentsJson,Map.class));
    }

    public PageInfo<?> selectByExampleWithPaging(Class mapperClass, Class exampleClass, Map arguments, Class returnDtoBeanClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object convertObject = SpringContextUtils.getBeanById("generalBeanConvert");
        return selectByExampleWithPaging(mapperClass,exampleClass,arguments,returnDtoBeanClass,convertObject.getClass());
    }

    public PageInfo<?> selectByExampleWithPaging(Class mapperClass, Class exampleClass, Object argumentsDto, Class returnDtoBeanClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Map map = new BeanMap(argumentsDto);
        return  selectByExampleWithPaging(mapperClass,exampleClass,map,returnDtoBeanClass);
    }

    public PageInfo<?> selectByExampleWithPaging(Class mapperClass, Class exampleClass, String argumentsJson, Class returnDtoBeanClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return selectByExampleWithPaging(mapperClass,exampleClass,JSON.parseObject(argumentsJson,Map.class),returnDtoBeanClass);
    }

    public PageInfo<?> selectByExampleWithPaging(Class mapperClass, Class exampleClass, Map arguments, Class returnDtoBeanClass, Class convertClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PageInfo<?> pageInfo = selectByExampleWithPaging(mapperClass, exampleClass, arguments);
        List<?> entityList = pageInfo.getList();
        pageInfo.setList((List)convertData(returnDtoBeanClass, convertClass, entityList));
        return pageInfo;
    }

    public PageInfo<?> selectByExampleWithPaging(Class mapperClass, Class exampleClass, Object argumentsDto, Class returnDtoBeanClass, Class convertClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return  selectByExampleWithPaging(mapperClass,exampleClass,new BeanMap(argumentsDto),returnDtoBeanClass,convertClass);
    }

    public PageInfo<?> selectByExampleWithPaging(Class mapperClass, Class exampleClass, String argumentsJson, Class returnDtoBeanClass, Class convertClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return  selectByExampleWithPaging(mapperClass,exampleClass,JSON.parseObject(argumentsJson,Map.class),returnDtoBeanClass,convertClass);
    }

    public Integer insert(Class mapperClass, Object dto, Class convertClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object mapper = SpringContextUtils.getBeanByClass(mapperClass);
        Object databaseEntity = convertData(getDatabaseEntityClass(mapper), convertClass, dto);
        return insert(mapperClass,databaseEntity);
    }

    public Integer insert(Class mapperClass, Object databaseEntity) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object mapper = SpringContextUtils.getBeanByClass(mapperClass);
        return (Integer) MethodUtils.invokeMethod(mapper,"insert",databaseEntity);
    }

    public Integer updateByPrimaryKey(Class mapperClass, Object dto, Class convertClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object mapper = SpringContextUtils.getBeanByClass(mapperClass);
        Object databaseEntity = convertData(getDatabaseEntityClass(mapper), convertClass, dto);
        return updateByPrimaryKey(mapperClass,databaseEntity);
    }

    public Integer updateByPrimaryKey(Class mapperClass, Object databaseEntity) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object mapper = SpringContextUtils.getBeanByClass(mapperClass);
        return (Integer) MethodUtils.invokeMethod(mapper,"updateByPrimaryKey",databaseEntity);
    }

    public Long countByExample(Class mapperClass, Class exampleClass, Map arguments) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object mapper = SpringContextUtils.getBeanByClass(mapperClass);
        Object exampleObject = getExampleObject(exampleClass, arguments);
        return (Long) MethodUtils.invokeMethod(mapper,"countByExample",exampleObject);
    }

    public Long countByExample(Class mapperClass, Class exampleClass, Object argumentsDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return  countByExample(mapperClass,exampleClass,new BeanMap(argumentsDto));
    }

    public Long countByExample(Class mapperClass, Class exampleClass, String argumentsJson) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return countByExample(mapperClass,exampleClass,JSON.parseObject(argumentsJson,Map.class));
    }

    public Integer deleteByExample(Class mapperClass, Class exampleClass, Map arguments) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object mapper = SpringContextUtils.getBeanByClass(mapperClass);
        Object exampleObject = getExampleObject(exampleClass, arguments);
        return (Integer) MethodUtils.invokeMethod(mapper,"deleteByExample",exampleObject);
    }

    public Integer deleteByExample(Class mapperClass, Class exampleClass, Object argumentsDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return  deleteByExample(mapperClass,exampleClass,new BeanMap(argumentsDto));
    }

    public Integer deleteByExample(Class mapperClass, Class exampleClass, String argumentsJson) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return deleteByExample(mapperClass,exampleClass,JSON.parseObject(argumentsJson,Map.class));
    }

    public Integer deleteByPrimaryKey(Class mapperClass, Object id) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object mapperObject = SpringContextUtils.getBeanByClass(mapperClass);
        return (Integer) MethodUtils.invokeMethod(mapperObject, "deleteByPrimaryKey", id);
    }

    /**
     * 转换对象
     * @param returnBeanClass 转换后的返回对象
     * @param convertClass 转换类
     * @param source 原对象
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private Object convertData(Class returnBeanClass, Class convertClass, Object source) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object convertObject = SpringContextUtils.getBeanByClass(convertClass);
        return MethodUtils.invokeMethod(convertObject, "Convert", new Object[]{source, returnBeanClass});
    }

    /**
     * 是否需要分页
     * @param params
     * @return
     */
    private boolean isPaging(Map params){
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

    private List queryList(Map map, Object mapper, Object example) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if(isPaging(map)){
            PageHelper.startPage(getPageNumber(map),getPageSize(map));
        }
        Object selectByExample = MethodUtils.invokeMethod(mapper, "selectByExample", example);
        return  (List) selectByExample;
    }

    //返回数据库实体对象类型
    private Class<?> getDatabaseEntityClass(Object mapper) throws NoSuchMethodException {
        Class<?> entityClass =null;
        for (Method method:mapper.getClass().getMethods()){
            if(method.getName().equals("selectByPrimaryKey")){
                entityClass = method.getReturnType();
                break;
            }
        }
        if (null==entityClass){
            throw new NoSuchMethodException("selectByPrimaryKey method not find");
        }
        return entityClass;
    }
}
