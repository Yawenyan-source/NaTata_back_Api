package com.wen.server.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 验证码配置类
 */
@Configuration
public class CaptchaConfig {
    @Bean
    public DefaultKaptcha defaultKaptcha() {
        DefaultKaptcha dk = new DefaultKaptcha();
        Properties properties = new Properties();
        //验证码是否带边框
        properties.put("kaptcha.border", "yes");
        //设置边框颜色
        properties.put("kaptcha.border.color", "105,179,90");
        //验证码字体颜色
        properties.put("kaptcha.textproducer.font.color", "blue");
        //验证码整体宽度
        properties.put("kaptcha.image.width", "100");
        //验证码整体高度
        properties.put("kaptcha.image.height", "40");
        //文字大小
        properties.put("kaptcha.textproducer.font.size", "30");
        //验证码
        properties.put("kaptcha.session.key", "code");
        //字符长度,默认是5
        properties.put("kaptcha.textproducer.char.length", "4");
        //字体样式
        properties.put("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        Config config = new Config(properties);
        dk.setConfig(config);
        return dk;
    }


}
