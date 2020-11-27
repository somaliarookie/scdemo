package com.springcloud.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author weile
 * @Auth weile
 * @Time 2020/11/27 18:11
 * @Description TODO
 **/

@RestController
public class TestController {




	@RequestMapping(path = "test" ,method= RequestMethod.GET)
	public String test(HttpServletRequest request, HttpServletResponse response) {

		return "test";

	}
}

