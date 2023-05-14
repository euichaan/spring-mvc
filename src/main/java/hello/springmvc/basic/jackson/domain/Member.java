package hello.springmvc.basic.jackson.domain;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

public class Member {

	public String name;
	private Map<String, String> properties = new HashMap<>();

	public Member(final String name) {
		this.name = name;
	}

	@JsonAnyGetter
	public Map<String, String> getProperties() {
		return properties;
	}

	public void add(String attr, String val) {
		this.properties.put(attr, val);
	}
}
