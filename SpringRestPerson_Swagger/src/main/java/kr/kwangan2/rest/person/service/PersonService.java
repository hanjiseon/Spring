package kr.kwangan2.rest.person.service;

import java.util.List;

import kr.kwangan2.rest.person.domain.Person;

public interface PersonService {

	public List<Person> listPerson();

	public Person selectPerson(Long pid);

	public void insertPerson(Person person);

	public void updatePerson(Long pid, Person person);

	public void deletePerson(Long pid);

}
