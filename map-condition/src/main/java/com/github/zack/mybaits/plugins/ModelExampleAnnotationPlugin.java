package com.github.zack.mybaits.plugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * Created by zack.wu on 2017/4/26.
 */
public class ModelExampleAnnotationPlugin extends PluginAdapter {
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        super.modelExampleClassGenerated(topLevelClass, introspectedTable);
        topLevelClass.addAnnotation("@Component");
        topLevelClass.addAnnotation("@Scope(\"prototype\")");
        topLevelClass.addImportedType("org.springframework.context.annotation.Scope" );
        topLevelClass.addImportedType("org.springframework.stereotype.Component");
        return true;
    }
}
