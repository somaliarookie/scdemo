package com.sc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auth weile
 * @Time 2020/12/3 15:16
 * @Description TODO
 **/

@RestController
public class RedisController {


	@Autowired
	private RedisTemplate redisTemplate;

	@GetMapping("/redis/get")
	public String multiSet() {


		redisTemplate.opsForValue().set("infokey","infovalue");

		return (String) redisTemplate.opsForValue().get("infokey");


	}

	@GetMapping("/redis/multiset/{number}")
	public int multiSet(@PathVariable("number") int number) {


		for (int i = 0; i <number ; i++) {

			redisTemplate.opsForValue().set("testkey"+i,"value-"+i);
		}

		return number;


	}

}
