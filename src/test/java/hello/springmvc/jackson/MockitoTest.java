package hello.springmvc.jackson;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import hello.springmvc.basic.mockito.Bird;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MockitoTest {

	private final Bird bird = mock(Bird.class);
	private final InOrder order = inOrder(bird);

	@Nested
	class Describe_verify {

		@Test
		void 메서드_호출이_있었다는_것을_검증한다() {
			bird.fly();

			verify(bird).fly();
		}

		@Test
		void never와_함께_쓰면_메소드_호출이_없었다는_것을_검증한다() {
			bird.walk();

			verify(bird, never()).fly();
		}

		@Test
		void times와_함께_사용하면_메서드_호출_횟수를_검증한다() {
			for (int i = 0; i < 3; i++) {
				bird.fly();
			}

			verify(bird, times(3)).fly();
		}

		@Test
		void atLeast_atMost와_함께_사용하면_메서드_호출_최소_최대_횟수를_검증한다() {
			for (int i = 0; i < 3; i++) {
				bird.fly();
			}
			verify(bird, atLeast(2)).fly();
			verify(bird, atMost(4)).fly();
		}

		@Test
		void argument를_제공하면_argument를_검증한다() {
			bird.setName("뻐꾸기");

			verify(bird).setName("뻐꾸기");
			verify(bird).setName(anyString());
		}

		@Test
		void verify_이후_다른인터랙션이_없었다는_것을_검증한다() {
			bird.fly();

			verify(bird).fly();
			verifyNoMoreInteractions(bird);
		}

		@Test
		void 아무런_인터랙션이_없었다는_것을_검증한다() {
			verifyNoInteractions(bird);
		}

		@Test
		void 메서드_호출_순서를_검증한다() {
			bird.fly();
			bird.walk();
			bird.fly();

			order.verify(bird).fly();
			order.verify(bird).walk();
			order.verify(bird).fly();
		}
	}
}
