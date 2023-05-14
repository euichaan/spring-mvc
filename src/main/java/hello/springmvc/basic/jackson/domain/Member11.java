package hello.springmvc.basic.jackson.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Member11 {

	private int id;
	private String name;

	public Member11(final int id, final String name) {
		this.id = id;
		this.name = name;
	}
}
