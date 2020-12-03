package com.sc.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @Auth weile
 * @Time 2020/12/3 15:16
 * @Description TODO
 **/

@RestController
@RefreshScope
public class ConfigController {


	@Value("${demo.config}")
	private String config;


	@GetMapping("/config")
	public String getConfig() {


		return config;
	}

}
