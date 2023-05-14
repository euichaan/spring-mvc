package hello.springmvc.basic.jackson.domain;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import hello.springmvc.basic.jackson.CustomDateSerializer;

public class Event {

	public String name;

	@JsonSerialize(using = CustomDateSerializer.class)
	public Date eventDate;

	public Event(final String name, final Date eventDate) {
		this.name = name;
		this.eventDate = eventDate;
	}
}
