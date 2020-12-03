package com.sc.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auth weile
 * @Time 2020/12/3 15:16
 * @Description TODO
 **/

@RestController
public class ConfigController {


	@Value("${demo.config:defaultconfig}")
	private String config;


	@GetMapping("/config")
	public String getConfig() {


		return config;
	}

}
