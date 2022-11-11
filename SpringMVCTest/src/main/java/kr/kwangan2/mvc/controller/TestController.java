package kr.kwangan2.mvc.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.text.View;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.kwangan2.mvc.domain.PersonDTO;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value = "/test/*", method = { RequestMethod.GET, RequestMethod.POST })
@Log4j
public class TestController { // http://localhost:8080/test/test1

	// http://localhost:8080/test/test1(GET)
	@RequestMapping(value = "/test1", method = { RequestMethod.GET })
	public void test1() {
		log.info("test1() 호출!");
	}

	// http://localhost:8080/test/test2(POST)
	@RequestMapping(value = "/test2", method = { RequestMethod.POST })
	public void test2() {
		log.info("test2() 호출!");
	}

//	requestparam -> parameter이름 지정
	@RequestMapping(value = "/personParam")
	public void testPersonDTO(@RequestParam("name") String n, @RequestParam("age") int a) {
		log.info(n + " : " + a);
	}

	@RequestMapping(value = "/personDTO")
	public void testPersonDTO(PersonDTO personDTO) {
		log.info(personDTO);
	}

	@RequestMapping(value = "/fileupload")
	public void testFileupload(@RequestParam("uploadFile") ArrayList<String> listUploadFiles) {
		log.info(listUploadFiles);
	}

	@RequestMapping(value = "/personDTOList")
	public void testPersonDTOList(PersonDTO personDTO) {
		log.info(personDTO);
	}

	@GetMapping("/getJson")
	public @ResponseBody PersonDTO getJson() {

		PersonDTO personDTO2 = new PersonDTO();
		personDTO2.setName("한지선");
		personDTO2.setAge(23);
		personDTO2.setBirth(new Date());

		PersonDTO personDTO3 = new PersonDTO();
		personDTO3.setName("한지선");
		personDTO3.setAge(23);
		personDTO3.setBirth(new Date());

		PersonDTO personDTO = new PersonDTO();
		personDTO.setName("한지선");
		personDTO.setAge(23);
		personDTO.setBirth(new Date());

		ArrayList<PersonDTO> personDTOList = new ArrayList<PersonDTO>();
		personDTOList.add(personDTO2);
		personDTOList.add(personDTO3);
		personDTO.setPersonDTOList(personDTOList);
		return personDTO;
	}

	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) { SimpleDateFormat
	 * dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 * binder.registerCustomEditor(java.util.Date.class, new
	 * CustomDateEditor(dateFormat, false)); }
	 */

	@GetMapping("/initBinder")
	public void Binder(PersonDTO personDTO) {
		log.info(personDTO);
	}

	@GetMapping("/getModelInfo")
	public String getModelInfo(Model model, @ModelAttribute("addr") String addr) {
		model.addAttribute("name", "한지선");
		model.addAttribute("age", "23");
		log.info(addr);
		return "getModelInfo";
	}

	@GetMapping("/getInfo")
	public String getInfo(Model model, String name, int age) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "redirect:/";
	}

	@GetMapping("/modelAndView")
	public ModelAndView modelAndView(Model model) {
		model.addAttribute("name", "한지선");
		model.addAttribute("age", 23);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("modelAndView");
		return mav;
	}

	@GetMapping("/realUploadForm")
	public String realUploadForm() {
		return "realUploadForm";
	}

	@PostMapping("/realfileupload")
	public void realfileupload(ArrayList<MultipartFile> uploadFile) {
		uploadFile.forEach(file -> {
			log.info("업로드 할 때의 파일명:" + file.getOriginalFilename());
			log.info("업로드 할 때의 파일명:" + file.getSize());
		});
	}

} // class
