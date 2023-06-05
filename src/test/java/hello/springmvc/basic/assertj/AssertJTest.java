package hello.springmvc.basic.assertj;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class AssertJTest {

	List<String> list = Arrays.asList("1", "2", "3");

	@Test
	void 참_거짓을_검증한다() {
		assertThat("".isEmpty()).isTrue();
	}

	@Test
	void 특정_요소가_존재하는지_확인한다() {
		assertThat(list).contains("1");
	}

	@Test
	void 리스트가_비어있지_않음을_확인한다() {
		assertThat(list).isNotEmpty();
	}

	@Test
	void 리스트가_주어진_문자로_시작하는것을_확인한다() {
		assertThat(list).startsWith("1");
	}

	@Test
	void 체이닝을_통해_하나이상의_assertion을_생성한다() {
		assertThat(list)
			.isNotEmpty()
			.contains("1")
			.doesNotContainNull()
			.containsSequence("2", "3");
	}

	@Test
	void 인터페이스인지_확인한다() {
		assertThat(Runnable.class).isInterface();
	}

	@Test
	void 클래스가_다른클래스에_할당가능한지_확인한다() {
		assertThat(Exception.class).isAssignableFrom(NoSuchElementException.class);
	}

	@Test
	void 예외를_확인한다() {
		final RuntimeException e = new RuntimeException("error");
		assertThat(e).hasNoCause()
			.hasMessageEndingWith("r");
	}

	@Test
	void 특정_위치의_문자를_가져온다_has() {
		String name = "Fortune";
		int index = 10;
		assertThatThrownBy(() -> name.charAt(index))
			.isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessageContaining("%d", index);
	}

	@Test
	void 특정_위치의_문자를_가져온다_with() {
		String name = "Fortune";
		int index = 10;
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
			.isThrownBy(() -> name.charAt(index))
			.withMessageContaining("%d", index);
	}


}
