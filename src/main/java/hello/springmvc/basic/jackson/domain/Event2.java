package hello.springmvc.basic.jackson.domain;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import hello.springmvc.basic.jackson.CustomDateDeserializer;

public class Event2 {

	public String name;

	@JsonDeserialize(using = CustomDateDeserializer.class)
	public Date eventDate;
}
