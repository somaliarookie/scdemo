package com.sc.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Auth weile
 * @Time 2019/11/30 17:46
 * @Description demo controller
 **/

@Slf4j
@RestController
public class BasicController {

	@RequestMapping("/")
	public String getSth() {

		return "hello world";

	}


	/**
	 *
	 * 'content-type' : application/json
	 *
	 *  使用 @RequestBody注解标识，使用body-json格式传入参数
	 *
	 * curl --location --request POST 'http://localhost:8080/post/json' \
	 * --header 'Content-Type: application/json' \
	 * --data-raw '{
	 *     "name": "xubo",
	 *     "age": 233
	 * }'
	 *
	 */
	@PostMapping(value = {"/post/json/requestbody"})
	public User postJsonWithRequestBody(@RequestBody User u) {

		return  u;
	}


	/**
	 *
	 * 'content-type' : application/json
	 *
	 *
	 * 不使用任何注解的参数 -> x-www-form-urlencoded
	 *
	 * curl --location --request POST 'http://localhost:8080/post/json/withoutann' \
	 * --header 'Content-Type: application/x-www-form-urlencoded' \
	 * --data-urlencode 'name=xubo' \
	 * --data-urlencode 'age=31'
	 *
	 */
	@PostMapping(value = {"/post/json/withoutann"})
	public User postJsonWithoutAnnotations( User u) {

		return  u;
	}

	/**
	 *
	 * 'content-type' : application/json
	 *
	 *
	 * 不使用任何注解的参数，默认和@RequestBody一样的效果
	 * curl --location --request POST 'http://localhost:8080/post/json' \
	 * --header 'Content-Type: application/json' \
	 * --data-raw '{
	 *     "name": "xubo",
	 *     "age": 233
	 * }'
	 *
	 */
	@PostMapping(value = {"/post/json/map"})
	public Map postJsonWithoutAnnotations( @RequestBody Map<String, String> info) {

		return  info;
	}



	@RequestMapping(value = {"/post"}, method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String postTest(Long uid, @RequestParam(value = "ids",required = false) List<Long> ids) {


		return "post response here: id:"+uid+" ids:"+ids;
	}

	/**
	 * process with custom response time {rt}
	 *
	 * @param rt
	 * @return
	 */
	@RequestMapping(value = "/mvc/rt/{rt}")
	public String getWithLantency(@PathVariable Long rt) {


		log.info("response time: {} ", rt);

		try {
			TimeUnit.MILLISECONDS.sleep(rt);   // 1
		} catch (InterruptedException e) {
			return "Error during thread sleep";
		}

		return "mvc response";
	}

}
