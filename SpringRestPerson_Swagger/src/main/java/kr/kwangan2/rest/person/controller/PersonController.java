package kr.kwangan2.rest.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.kwangan2.rest.person.domain.Person;
import kr.kwangan2.rest.person.service.PersonService;
import lombok.Setter;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Setter(onMethod_ = @Autowired)
	private PersonService service;

	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public List<Person> listPerson() {
		return service.listPerson();
	}

	@GetMapping(value = "/{pid}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Person selectPerson(@PathVariable Long pid) {
		return service.selectPerson(pid);
	}

	@PostMapping(value = "/insert")
	public void insertPerson(@RequestBody Person person) {
		service.insertPerson(person);
	}

	@PutMapping(value = "/{pid}")
	public void updatePerson(@PathVariable Long pid, @RequestBody Person person) {
		service.updatePerson(pid, person);
	}

	@DeleteMapping(value = "/{pid}")
	public void deletePerson(@PathVariable Long pid) {
		service.deletePerson(pid);
	}

} // class
