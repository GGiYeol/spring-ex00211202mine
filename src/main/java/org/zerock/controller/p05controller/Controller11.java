package org.zerock.controller.p05controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.mapper.p05mapper.Mapper02;

import lombok.Setter;

@Controller
@RequestMapping("/cont11")
public class Controller11 {

	@Setter(onMethod_ = @Autowired)
	private Mapper02 mapper;
	
	@RequestMapping("/met01")
	public void method01(Integer id) {
		String name = mapper.getLastNameById(id);
		System.out.println(name);
	}
	
	@RequestMapping("/met02")
	public void mehod02(Integer id) {
		String customerName = mapper.getCustomerNameById(id);
		
		System.out.println(customerName);
	}
	
	@RequestMapping("/met03")
	public void method03(String category) {
		List<String> productNames = mapper.getProductNamesByCategory(category);
		
		for(String p : productNames) {
			System.out.println(p);
		}
	}
	//여러 파라미터가 있으면 파라미터명을 바꾼다.
	//컴파일 할 때 파라미터 이름을 유지하고 싶다면?? param이라는 어노테이션을 쓰면 된다. 
	@RequestMapping("/met04")
	public void method04(String category, Double price) {
		List<String> productNames = mapper.getProductNamesByCategoryAndPrice(category, price);
		
		for(String p : productNames) {
			System.out.println(p);
		}
	}
	// /cont11/met05?city=Berlin&country=Germany
	@RequestMapping("/met05")
	public void method05(String city, String country) {
		List<String> supplierNames = mapper.getSuppierNamesByCityAndCountry(city, country);
		
		for(String s : supplierNames) {
			System.out.println(s);
		}
	}
}
