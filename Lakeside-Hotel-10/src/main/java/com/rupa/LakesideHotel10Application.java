package com.rupa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.web.multipart.support.MultipartFilter;

@SpringBootApplication
public class LakesideHotel10Application {

	public static void main(String[] args) {
		SpringApplication.run(LakesideHotel10Application.class, args);
	}

	/*
	 * @Bean public CommonsMultipartResolver multipartResolver() {
	 * CommonsMultipartResolver multipart = new CommonsMultipartResolver();
	 * multipart.setMaxUploadSize(3 * 1024 * 1024); return multipart; }
	 */


}
