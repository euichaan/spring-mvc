package hello.springmvc.basic.jackson.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class Member14 {

	private int id;
	private String name;

	@Override
	public String toString() {
		return "Member14{" +
			"id=" + id +
			", name='" + name + '\'' +
			'}';
	}
}
