package kr.kwangan2.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/*")
public class CommonController {

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied : " + auth);
		model.addAttribute("msg", "권한이 없습니다!");
	}
	
	@GetMapping("/adminLogin")
	public void longinInput(String error, String logout, Model model) {
		
		log.info("error: " + error);
		log.info("logout: " + logout);
		
		if(error != null){
			model.addAttribute("error", "계정을 확인하세요~!");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "😺로그아웃😺");
		}
	}
	
	@GetMapping("/adminLogout")
	public void logoutGET() {
	}
	
}
