package com.github.librarian.service.common;

import com.github.pagehelper.PageInfo;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Created by zack.wu on 2017/4/28.
 */
public interface IGeneralService {
    <T> T selectByPrimaryKey(Class mapperClass, Object id) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    <T> T selectByPrimaryKey(Class mapperClass, Object id, Class<T> returnDtoBeanClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    <T> T selectByPrimaryKey(Class mapperClass, Object id, Class<T> returnDtoBeanClass, Class convertClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;


    List<?> selectByExample(Class mapperClass, Class exampleClass, Map arguments) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    List<?> selectByExample(Class mapperClass, Class exampleClass, Object argumentsDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    List<?> selectByExample(Class mapperClass, Class exampleClass, String argumentsJson) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    List<?> selectByExample(Class mapperClass, Class exampleClass, Map arguments, Class returnDtoBeanClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    List<?> selectByExample(Class mapperClass, Class exampleClass, Object argumentsDto, Class returnDtoBeanClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    List<?> selectByExample(Class mapperClass, Class exampleClass, String argumentsJson, Class returnDtoBeanClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    List<?> selectByExample(Class mapperClass, Class exampleClass, Map arguments, Class returnDtoBeanClass, Class convertClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    List<?> selectByExample(Class mapperClass, Class exampleClass, Object argumentsDto, Class returnDtoBeanClass, Class convertClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    List<?> selectByExample(Class mapperClass, Class exampleClass, String argumentsJson, Class returnDtoBeanClass, Class convertClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    PageInfo<?> selectByExampleWithPaging(Class mapperClass, Class exampleClass, Map arguments) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    PageInfo<?> selectByExampleWithPaging(Class mapperClass, Class exampleClass, Object argumentsDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    PageInfo<?> selectByExampleWithPaging(Class mapperClass, Class exampleClass, String argumentsJson) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    PageInfo<?> selectByExampleWithPaging(Class mapperClass, Class exampleClass, Map arguments, Class returnDtoBeanClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    PageInfo<?> selectByExampleWithPaging(Class mapperClass, Class exampleClass, Object argumentsDto, Class returnDtoBeanClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    PageInfo<?> selectByExampleWithPaging(Class mapperClass, Class exampleClass, String argumentsJson, Class returnDtoBeanClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    PageInfo<?> selectByExampleWithPaging(Class mapperClass, Class exampleClass, Map arguments, Class returnDtoBeanClass, Class convertClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    PageInfo<?> selectByExampleWithPaging(Class mapperClass, Class exampleClass, Object argumentsDto, Class returnDtoBeanClass, Class convertClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    PageInfo<?> selectByExampleWithPaging(Class mapperClass, Class exampleClass, String argumentsJson, Class returnDtoBeanClass, Class convertClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;


    Integer insert(Class mapperClass, Object dto, Class convertClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    Integer insert(Class mapperClass, Object databaseEntity) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    Integer updateByPrimaryKey(Class mapperClass, Object dto, Class convertClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    Integer updateByPrimaryKey(Class mapperClass, Object databaseEntity) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    Long countByExample(Class mapperClass, Class exampleClass, Map arguments) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    Long countByExample(Class mapperClass, Class exampleClass, Object argumentsDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    Long countByExample(Class mapperClass, Class exampleClass, String argumentsJson) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    Integer deleteByExample(Class mapperClass, Class exampleClass, Map arguments) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    Integer deleteByExample(Class mapperClass, Class exampleClass, Object argumentsDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    Integer deleteByExample(Class mapperClass, Class exampleClass, String argumentsJson) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    Integer deleteByPrimaryKey(Class mapperClass, Object id) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
}
