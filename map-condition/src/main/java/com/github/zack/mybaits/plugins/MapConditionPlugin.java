package com.github.zack.mybaits.plugins;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;

import java.util.List;

/**
 * Created by zack.wu on 2017/4/19.
 */
public class MapConditionPlugin extends PluginAdapter {

    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
         super.modelExampleClassGenerated(topLevelClass, introspectedTable);

        InnerClass criteria = null;
        // first, find the Criteria inner class
        for (InnerClass innerClass : topLevelClass.getInnerClasses()) {
            if ("Criteria".equals(innerClass.getType().getShortName())) {
                criteria = innerClass;
                break;
            }
        }
        Method method = new Method();
        method.setName("andMap");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
        FullyQualifiedJavaType newMapInstance = FullyQualifiedJavaType.getNewMapInstance();
        newMapInstance.addTypeArgument(FullyQualifiedJavaType.getStringInstance());
        newMapInstance.addTypeArgument(FullyQualifiedJavaType.getObjectInstance());
        Parameter parameter = new Parameter(newMapInstance, "map");
        method.addParameter(parameter);

        //"Between","NotBetween" -- 方法不生成，采用GreaterThanOrEqualTo等方法替代变通
        String[] methods = new String[]{"EqualTo","NotEqualTo","GreaterThan","GreaterThanOrEqualTo","LessThan","LessThanOrEqualTo"};
        for (IntrospectedColumn column : introspectedTable.getAllColumns()) {
            String upperCasePropertyName = StringUtils.capitalize(column.getJavaProperty());
            String columnJavaTypeShortName = column.getFullyQualifiedJavaType().getShortName();

            for (int i = 0; i < methods.length; i++) {
                createMethodBody(method, upperCasePropertyName + methods[i], columnJavaTypeShortName);
            }
            //"Like","NotLike"
            if ("String".equals(columnJavaTypeShortName)){
                createMethodBody(method,upperCasePropertyName+"Like",columnJavaTypeShortName);
                createMethodBody(method,upperCasePropertyName+"NotLike",columnJavaTypeShortName);
            }
            //"In","NotIn"
            createMethodBody(method,upperCasePropertyName+"In","List<"+columnJavaTypeShortName+">");
            createMethodBody(method,upperCasePropertyName+"NotIn","List<"+columnJavaTypeShortName+">");
        }

        method.addBodyLine("return this;");
        criteria.addMethod(method);

        context.getCommentGenerator()
                .addGeneralMethodComment(method, introspectedTable);

        return true;
    }

    private void createMethodBody(Method method, String propertyName, String columnJavaTypeShortName) {
        method.addBodyLine("if (map.containsKey(\"" +propertyName + "\")){");
        method.addBodyLine(" and" + propertyName+ "((" + columnJavaTypeShortName + ") map.get(\"" + propertyName+ "\"));");
        method.addBodyLine("}");
    }


}



