package com.ccitsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * <p>Description: [测试例子]</p>
 * Created on 2018年5月10日
 * @author  <a href="mailto: lichao8941188@163.com">李超</a>
 * @version 1.0  
 * @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用
 * 如果只是使用@RestController注解Controller,则Controller中的方法无法返回jsp页面，或者html
 * 配置的视图解析器 InternalResourceViewResolver不起作用,返回的内容就是Return 里的内容.
 * ------------------------
 * 如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
 * 如果需要返回JSON,XML或自定义mediaType内容到页面,则需要在对应的方法上加上@ResponseBody注解。
 * Copyright (c) 2018
 */
@Controller
public class IndexController {
	
	@RequestMapping(value="/index",method =  RequestMethod.GET)
	public String index(){
		// 返回Jsp页面
		return "index";
	}
}
