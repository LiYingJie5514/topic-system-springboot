package com.system.yyn.topicsystem.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class DemoController {

	// 从 application.properties 中读取配置，如取不到默认值为HelloShanhy
	@Value("${application.hello:Hello Angel}")
	private String hello;

	
	@RequestMapping("/")
	public String helloJsp(Map<String, Object> map) {
		System.out.println("HelloController.helloJsp().hello=" + hello);
		map.put("hello", hello);
		return "index";
	}

	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	/**
	 * 注册
	 * @return
	 */
	@RequestMapping("/register")
	public String register(){
		return "register";
	}

	/**
	 * 后台登录
	 * @return
	 */
	@RequestMapping("/adminlogin")
	public String adminlogin(){
		return "admin/adminlogin";
	}

	/**
	 * 后台主页面
	 * @return
	 */
	@RequestMapping("/adminHome")
	public String adminHome(){
		return "admin/admin";
	}

	/**
	 * 教师添加课题
	 * @return
	 */
	@RequestMapping("/adminAddTopic")
	public String addTopic(){
		return "admin/adminAddTopic";
	}
}
