package hello.springmvc.basic.jackson.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"id"})
public class Member9 {

	public int id;
	public String name;

	public Member9(final int id, final String name) {
		this.id = id;
		this.name = name;
	}
}
