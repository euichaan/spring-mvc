package hello.springmvc.basic.jackson.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeEnumWithValue {
	TYPE1(1, "치킨"), TYPE2(2, "피자");

	private Integer id;
	private String name;

	TypeEnumWithValue(final Integer id, final String name) {
		this.id = id;
		this.name = name;
	}

	@JsonValue
	public String getName() {
		return name;
	}
}
