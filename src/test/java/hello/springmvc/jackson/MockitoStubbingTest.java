package hello.springmvc.jackson;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import hello.springmvc.basic.mockito.Bird;

class MockitoStubbingTest {

	private final Bird bird = mock(Bird.class);

	@Test
	void thenReturn으로_리턴값을_지정할_수_있다() {
		bird.setName("뻐꾸기");
		when(bird.getName()).thenReturn("dummy name");

		assertThat(bird.getName()).isEqualTo("dummy name");
	}

	@Test
	void thenReturn으로_리턴값을_순차적으로_지정할_수_있다() {
		bird.setName("뻐꾸기");
		when(bird.getName())
			.thenReturn("dummy name")
			.thenReturn("false name")
			.thenThrow(new RuntimeException("3번 부르면 예외를 던집니다"));

		assertThat(bird.getName()).isEqualTo("dummy name");
		assertThat(bird.getName()).isEqualTo("false name");
		assertThatThrownBy(bird::getName)
			.isInstanceOf(RuntimeException.class)
			.hasMessage("3번 부르면 예외를 던집니다");
	}

	@Test
	void doReturn으로_리턴값을_지정할_수_있다() {
		bird.setName("뻐꾸기");
		doReturn("false name").when(bird).getName();

		assertThat(bird.getName()).isEqualTo("false name");
	}

	@Test
	void thenThrow로_예외를_던지게_할_수_있다() {
		when(bird.talk(anyString())).thenThrow(RuntimeException.class);

		assertThatThrownBy(() -> bird.talk("dummy sentence"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void doThrow로_예외를_던지게_할_수_있다() {
		doThrow(RuntimeException.class).when(bird).talk(anyString());

		assertThatThrownBy(() -> bird.talk("dummy sentence"))
			.isInstanceOf(RuntimeException.class);
	}
}
