package com.physics.quesbank.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName VirtualPathConfig
 * @Description TODO
 * @Author aron
 * @Date 2020/8/30 16:51
 **/
@Configuration
public class VirtualPathConfig extends WebMvcConfigurerAdapter {

    protected final static Logger logger = LoggerFactory.getLogger(VirtualPathConfig.class);

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    //文件磁盘图片url 映射
    //配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
        registry.addResourceHandler("/image/**").addResourceLocations("file:D:/");
        super.addResourceHandlers(registry);
    }

}
