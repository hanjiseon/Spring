package com.kwhangan2.config;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Pet {
	
	private int age = 5;
	
	private String name ="happy";

}
