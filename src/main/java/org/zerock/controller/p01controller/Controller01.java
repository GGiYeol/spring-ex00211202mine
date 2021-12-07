package org.zerock.controller.p01controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/cont01")
public class Controller01 {

	
	
	@RequestMapping("/met01")
	public void method01() {
		 
		System.out.println("메소드 01 일함");
	}
}
