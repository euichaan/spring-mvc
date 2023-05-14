package hello.springmvc.basic.jackson.domain;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "member")
public class Member4 {

	public int id;
	public String name;

	public Member4(final int id, final String name) {
		this.id = id;
		this.name = name;
	}
}
