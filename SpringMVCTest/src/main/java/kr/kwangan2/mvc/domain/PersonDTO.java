package kr.kwangan2.mvc.domain;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;

import lombok.Data;

@Data
public class PersonDTO {

	private String name;
	private int age;
	private ArrayList<PersonDTO> personDTOList;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	
	public PersonDTO() {
		this.personDTOList = new ArrayList<PersonDTO>();
	}


}
