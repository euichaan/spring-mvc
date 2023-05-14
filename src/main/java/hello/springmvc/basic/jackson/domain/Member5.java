package hello.springmvc.basic.jackson.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Member5 {
	public int id;
	public String name;

	@JsonCreator
	public Member5(@JsonProperty("id") final int id,@JsonProperty("theName") final String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member5{" +
			"id=" + id +
			", name='" + name + '\'' +
			'}';
	}
}
