package com.cropbox.demo.uploadHead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class UploadHeadApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(UploadHeadApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(UploadHeadApplication.class, args);
	}
}
