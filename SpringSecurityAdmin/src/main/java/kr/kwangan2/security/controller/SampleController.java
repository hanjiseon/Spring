package kr.kwangan2.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin/*")
public class SampleController {

	@GetMapping("/adminMain")
	public void doAdmin() {
		log.info("관리자 접근");
	}
	
	@GetMapping("/memberManagement")
	public void doMember() {
		log.info("멤버 접근");
	}
	
	
	@GetMapping("/boardManagement")
	public void board() {
		log.info("게시물 접근");
	}
	
}	// class
