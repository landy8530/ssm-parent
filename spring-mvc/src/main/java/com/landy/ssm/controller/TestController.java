package com.landy.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	// 服务对象是提供业务逻辑的，是只读的。是根据输入信息，计算返回输出结果的。
	// 不是用于记录客户端状态的。
	// private XxxService xxxService;
	
	// [静态]常量。一旦赋值不可改变。 只读数据。 无关客户端状态数据。
	// private | public [static] final xxxx;
	
	@RequestMapping("/test")
	public String test(){
		return "/ok.jsp";
	}

}
