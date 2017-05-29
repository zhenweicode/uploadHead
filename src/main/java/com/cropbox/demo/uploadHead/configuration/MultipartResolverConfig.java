package com.cropbox.demo.uploadHead.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.IOException;

/**
 * 配置@Configuration("multipartResolver")的id属性不可缺少，否则会出现400错误
 *
 * @author xie
 * @version 1.0
 * @Date 2017/5/29
 */
@Configuration("multipartResolver")
public class MultipartResolverConfig {
    @Bean
    public MultipartResolver multipartResolver() throws IOException {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        //临时文件位置
        multipartResolver.setUploadTempDir(new FileSystemResource("/tmp/myblog/uploads"));
        //最大上传文件大小设置为2MB
        multipartResolver.setMaxUploadSize(2097152);
        //最大内存大小设置为0字节
        multipartResolver.setMaxInMemorySize(0);
        return multipartResolver;
    }

}
