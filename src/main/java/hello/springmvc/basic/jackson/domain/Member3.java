package hello.springmvc.basic.jackson.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "name", "id" })
public class Member3 {

	public int id;
	public String name;

	public Member3(final int id, final String name) {
		this.id = id;
		this.name = name;
	}
}
