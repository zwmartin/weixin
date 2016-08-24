package com.zw.weixin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.zw.weixin.bean.User;
import com.zw.weixin.service.UserService;
import com.zw.weixin.util.SpringContextHolder;

@Controller
@RequestMapping("/user")
public class TestController {

	@Resource(name = "userServiceImpl")
	UserService userService;

	@RequestMapping("/test")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("TestController.test()");
		//WebApplicationContext a1 = ContextLoader.getCurrentWebApplicationContext();
		WebApplicationContext a2 = (WebApplicationContext) request.getServletContext()
				.getAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.springMVC");
		//UserService service = (UserService) a1.getBean("userServiceImpl");
		
		a2.getBean("userServiceImpl");
		
		WebApplicationContext a3 = (WebApplicationContext) SpringContextHolder.getApplicationContext();
		
		a3.getBean("userServiceImpl");
		
		User user = userService.getById(123L);
		ModelAndView mv = new ModelAndView("test");
		return mv.addObject("user", user);

	}

}
