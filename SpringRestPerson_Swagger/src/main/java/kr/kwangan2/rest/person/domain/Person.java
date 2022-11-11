package kr.kwangan2.rest.person.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private Long pid;
	private String pname;
	private Long page;
	
	public Person(String pname, Long page) {
		this.pname = pname;
		this.page = page;
	}
	
}
