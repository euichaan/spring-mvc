package hello.springmvc.jackson;

import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import hello.springmvc.basic.jackson.domain.Event;
import hello.springmvc.basic.jackson.domain.Event2;
import hello.springmvc.basic.jackson.domain.Member;
import hello.springmvc.basic.jackson.domain.Member10;
import hello.springmvc.basic.jackson.domain.Member11;
import hello.springmvc.basic.jackson.domain.Member12;
import hello.springmvc.basic.jackson.domain.Member2;
import hello.springmvc.basic.jackson.domain.Member3;
import hello.springmvc.basic.jackson.domain.Member4;
import hello.springmvc.basic.jackson.domain.Member5;
import hello.springmvc.basic.jackson.domain.Member6;
import hello.springmvc.basic.jackson.domain.Member7;
import hello.springmvc.basic.jackson.domain.Member8;
import hello.springmvc.basic.jackson.domain.Member9;
import hello.springmvc.basic.jackson.domain.TypeEnumWithValue;

public class JacksonTest {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void json_any_getter() throws JsonProcessingException {
		Member member = new Member("Jay");
		member.add("favorite", "chicken");
		member.add("hobby", "tennis");

		final String result = objectMapper.writeValueAsString(member);
		System.out.println(result);

		assertThat(result).contains("favorite");
		assertThat(result).contains("hobby");
	}

	@Test
	void json_getter() throws JsonProcessingException {
		Member2 member = new Member2(1, "Chan");

		final String result = objectMapper.writeValueAsString(member);
		System.out.println(result);

		assertThat(result).contains("Chan");
		assertThat(result).contains("1");
	}

	@Test
	void json_property_order() throws JsonProcessingException {
		Member3 member3 = new Member3(1, "Chan");

		final String result = objectMapper.writeValueAsString(member3);
		System.out.println(result);

		assertThat(result).contains("Chan");
		assertThat(result).contains("1");
	}

	@Test
	void json_value() throws JsonProcessingException {
		final String result = objectMapper.writeValueAsString(TypeEnumWithValue.TYPE1);
		System.out.println(result);
		assertThat(result).isEqualTo("\"치킨\"");
	}

	@Test
	void json_root_name() throws JsonProcessingException {
		Member4 member4 = new Member4(1, "Chan");

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		final String result = mapper.writeValueAsString(member4);
		System.out.println(result);
		assertThat(result).contains("Chan");
		assertThat(result).contains("1");
	}

	@Test
	void json_serialize() throws JsonProcessingException, ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

		String toParse = "20-12-2020 12:00:00";
		Date date = format.parse(toParse);
		Event event = new Event("party", date);
		final String result = objectMapper.writeValueAsString(event);
		System.out.println(result);
		assertThat(result).contains(toParse);
	}

	@Test
	void json_creator() throws JsonProcessingException {
		String json = "{\n" +
			"    \"id\":1,\n" +
			"    \"theName\":\"Chan\"\n" +
			"}";
		final Member5 member = objectMapper.readerFor(Member5.class).readValue(json);
		assertThat(member.name).isEqualTo("Chan");
	}

	// json 데이터가 아닌 곳에서 값을 주입할 때
	@Test
	void json_jnject() throws JsonProcessingException {
		String json = "{\"name\":\"Jay\"}";

		InjectableValues injectableValues = new InjectableValues.Std().addValue(int.class, 5);
		final Member6 member = objectMapper.reader(injectableValues).forType(Member6.class).readValue(json);
		assertThat(member.id).isEqualTo(5);
	}

	@Test
	void json_any_setter() throws IOException {
		String json = "{\"name\":\"Jay\",\"favorite\":\"chicken\",\"hobby\":\"tennis\"}";
		final Member7 member = objectMapper.readValue(json, Member7.class);
		assertThat(member.properties.get("favorite")).isEqualTo("chicken");
	}

	@Test
	void json_deserializer() throws JsonProcessingException {
		String json = "{\"name\":\"Jay event\",\"eventDate\":\"20-12-2020 01:01:00\"}";

		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		final Event2 event = objectMapper.readerFor(Event2.class)
			.readValue(json);
		assertThat(df.format(event.eventDate)).isEqualTo("20-12-2020 01:01:00");
	}

	@Test
	void json_alias() throws JsonProcessingException {
		String json1 = "{\"name\":\"Jay\",\"hobby\":\"tennis\"}";
		String json2 = "{\"his_name\":\"Jay\",\"hobby\":\"tennis\"}";
		String json3 = "{\"her_name\":\"Jay\",\"hobby\":\"tennis\"}";
		final Member8 member1 = objectMapper.readerFor(Member8.class).readValue(json1);
		final Member8 member2 = objectMapper.readerFor(Member8.class).readValue(json2);
		final Member8 member3 = objectMapper.readerFor(Member8.class).readValue(json3);
		assertThat(member1.name).isEqualTo("Jay");
		assertThat(member2.name).isEqualTo("Jay");
		assertThat(member3.name).isEqualTo("Jay");
	}


	// 직렬화 시 무시할 필드 설정
	@Test
	void json_ignore_properties() throws JsonProcessingException {
		final Member9 member = new Member9(1, "Chan");
		final String result = objectMapper.writeValueAsString(member);
		System.out.println(result);
		assertThat(result).contains("Chan");
		assertThat(result).doesNotContain("1");
	}

	@Test // null 직렬화 시 제외
	void json_include() throws JsonProcessingException {
		final Member10 member = new Member10(1, null);
		final String result = objectMapper.writeValueAsString(member);

		assertThat(result).contains("1");
		assertThat(result).doesNotContain("name");
	}

	@Test
	void json_auto_detect_visibility_any() throws JsonProcessingException {
		final Member11 member = new Member11(1, "Chan");
		final String result = objectMapper.writeValueAsString(member);
		assertThat(result).contains("1");
		assertThat(result).contains("Chan");
	}

	@Test
	void json_property() throws JsonProcessingException {
		final Member12 member12 = new Member12("Chan");
		final String result = objectMapper.writeValueAsString(member12);
		System.out.println(result);
	}
}
