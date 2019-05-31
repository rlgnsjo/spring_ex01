package com.spring01.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.spring01.model.dto.ProductDTO;

@Controller
public class MainController {
	private static final Logger Logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET )
	public String main(Model model) { //model.addAttribute를 위한 객체생성.
		Logger.info("page >>>>>>>>> main");
		
		//main.jsp로 데이터 전달
		model.addAttribute("message", "홈페이지 방문을 환영합니다."); // 데이터 전달위해 model.addAttribute를 생성해야한다.
	
		return "main";  // main.jsp의 경로로 이동하게 위해 만듬.
	}
	@RequestMapping(value = "/gugu", method = RequestMethod.GET )
	public String gugu(@RequestParam(defaultValue="2") int dan, Model model) { 
	// int dan을 main에서 값을 받기위해 사용. 
	// defaultValue="2" 를 사용하기 위해선@RequestParam를 사용해야 하나  int dan만 선언할경우 생략가능. 
	
			
	// 단수입력 받고 1~9까지 계산.
	String result = "";
		
	for (int i= 0; i<= 9; i++) {
		result += dan + "x" + i + "="+ dan*i + "<br>";	
		  
	}
		
	model.addAttribute("result", result);
	
		return "test/gugu";
	}
		
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public void test() {
		// 데이터 반환타입이 void면 
		// RequestToViewNameResolver를 통해
		// 이동할 페이지 이름이 정해지는데
		//1.@RequestMapping의 url로 찾고
		//2. 없으면 메서드명으로 찾음 
		
		//-----------------------------------							
		// void 로 설정하면
		// method 이름으로 view단을 설정
		// method 이름 = test
		// => return "test";
		
	}
	@RequestMapping("test/doA") //method = RequestMethod.GET)를 사용하지 않으면 vlaue값을 설정하지 않아도됨!
	public String doA (Model  model) {
		model.addAttribute("message", "테스트 페이지 doA");
		
		return "test/doA";
	}
	@RequestMapping("test/doB") 
	public void doB () {
		// 데이터 반환타입이 void인 경우  @RequestMapping URL 주소로 view단 연결 즉! // return "/test/doB";
	}
	
	
	// Model : 전달할 데이터 
	// ModelAndView: 데이터와 포워딩할 페이지 정보 포함.	
	@RequestMapping("test/doC") 
	public ModelAndView doC() {
		Map<String, Object> map = new HashMap<>();
		map.put("product", new ProductDTO("샤프",1000));
		
		// ModelAndView 방식
		return new ModelAndView("test/doC", "map", map);
		
		// model과 return으로 변경하면
		//	model.addAttribute("map" map);
		// return "test/doC"		
	}
	
	@RequestMapping("/test/doD") 
	public String dod() {		
		
		return "redirect:/test/doE";
	}
	
	@RequestMapping("/test/doE") 
	public void doE() {				
		Logger.info("doE 메서드 실행됨.");
		
		// void기 때문에 return "/test/doE";로 화면이동.
	}
	
	// Ajax( 비동기 데이터 처리방식)
	// : 다른페이지로 이동하지 않고, 원페이지로 돌아감.
	// : 예) return "test/doC"; 와 같은 작업을 통해 페이지 이동이되면 안됨!
	// Ajax일때는 return값이 순수하게 원페이지로 
	// 전달하고 싶은 데이터로 담는 용도로 사용되야 함.
	
	@ResponseBody // return 값을 순수 데이터로 인식 페이지 이동 X
	@RequestMapping("/test/doF") 
	public ProductDTO doF() {				
		Logger.info("doF 메서드 실행됨.");	
		
		return new ProductDTO("냉장고", 500000);
		
	}
	
}
