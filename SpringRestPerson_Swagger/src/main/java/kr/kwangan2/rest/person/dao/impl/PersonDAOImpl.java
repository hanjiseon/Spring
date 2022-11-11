package kr.kwangan2.rest.person.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kwangan2.rest.person.domain.Person;
import kr.kwangan2.rest.person.mapper.PersonMapper;
import kr.kwangan2.rest.person.service.PersonService;
import lombok.Setter;

@Service
public class PersonDAOImpl implements PersonService {
	
	@Setter(onMethod_=@Autowired)
	private PersonMapper mapper;

	@Override
	public List<Person> listPerson() {
		return mapper.listPerson();
	}

	@Override
	public Person selectPerson(Long pid) {
		return mapper.selectPerson(pid);
	}

	@Override
	public void insertPerson(Person person) {
		mapper.insertPerson(person);
	}

	@Override
	public void updatePerson(Long pid, Person person) {
		person.setPid(pid);
		mapper.updatePerson(person);
	}

	@Override
	public void deletePerson(Long pid) {
		mapper.deletePerson(pid);
	}

}
