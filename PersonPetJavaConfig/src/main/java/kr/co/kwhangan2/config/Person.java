package kr.co.kwhangan2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Person {
	
	private String name = "홍길동";
	private int age = 20;
	
	@Setter(onMethod_=@Autowired)
	private Pet pet;

}


