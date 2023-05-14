package hello.springmvc.basic.jackson.domain;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

public class Member7 {

	public String name;
	public Map<String, String> properties = new HashMap<>();

	@JsonAnySetter // 역직렬화할 때 사용
	public void add(String key, String value) {
		properties.put(key, value);
	}
}
