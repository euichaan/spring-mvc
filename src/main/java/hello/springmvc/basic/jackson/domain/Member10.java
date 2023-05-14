package hello.springmvc.basic.jackson.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // null 직렬화 시 제외
public class Member10 {

	public int id;
	public String name;

	public Member10(final int id, final String name) {
		this.id = id;
		this.name = name;
	}
}
