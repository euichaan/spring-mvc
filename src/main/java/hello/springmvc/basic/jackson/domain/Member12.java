package hello.springmvc.basic.jackson.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Member12 {

	@JsonProperty("name") // 직렬화 시 설정할 수 있는 이름을 지정
	private String username;

	public Member12(final String username) {
		this.username = username;
	}
}
