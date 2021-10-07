package com.wen.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    private static final DataSourceConfig.Builder DARA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://localhost:3306/NaTata?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", "wen", "12345678");


    public static void main(String[] args) {
        FastAutoGenerator.create(DARA_SOURCE_CONFIG)
                //全局配置
                .globalConfig(builder -> {
                    builder.author("wen") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("/Users/wen/Documents/Projects/IdeaProjects/NaTata_back_Api/Natata-server/src/main/java"); // 指定输出目录
                })
                //包配置
                .packageConfig(builder -> {
                    builder.parent("com.wen.server") // 设置父包名
                            // .moduleName("system") // 设置父包模块名
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .xml("mapper.xml")
                            .controller("controller")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "/Users/wen/Documents/Projects/IdeaProjects/NaTata_back_Api/Natata-server/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                //策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("t_admin", "t_admin_role",
                                    "t_appraise", "t_department",
                                    "t_employee", "t_employee_ec",
                                    "t_employee_remove", "t_employee_train",
                                    "t_joblevel", "t_mail_log",
                                    "t_menu", "t_menu_role",
                                    "t_nation", "t_oplog",
                                    "t_politics_status", "t_position",
                                    "t_role", "t_salary",
                                    "t_salary_adjust", "t_sys_msg", "t_sys_msg_content") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_") // 设置过滤表前缀
                            .entityBuilder()  //实体类配置
                            .enableLombok()   //开启lombok注解
                            .enableTableFieldAnnotation()  //实体类字段注解
                            .controllerBuilder()  //controller配置
                            .enableRestStyle()  //开启RestController
                            .mapperBuilder()
                            .enableBaseResultMap()  //开启BaseResultMap生成
                            .enableMapperAnnotation(); //开启mapper注解
                })
                /*
                 * 模板引擎配置
                 * */
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
