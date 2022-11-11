package kr.kwangan2.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/sample/*")
public class SampleController {

	@GetMapping("/all")
	public void doAll() {
		log.info("모두 접근 허용~!");
	}
	
	@GetMapping("/member")
	public void doMember() {
		log.info("멤버 접근 허용~!");
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("관리자 접근 허용~!");
	}
	
}	// class
