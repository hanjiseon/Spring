package kr.kwangan2.rest.person.mapper;

import java.util.List;

import kr.kwangan2.rest.person.domain.Person;

public interface PersonMapper {

	public List<Person> listPerson();

	public Person selectPerson(Long pid);

	public void insertPerson(Person person);

	public void updatePerson(Person person);

	public void deletePerson(Long pid);

}
