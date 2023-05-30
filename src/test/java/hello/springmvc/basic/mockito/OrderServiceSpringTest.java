package hello.springmvc.basic.mockito;

import static org.mockito.BDDMockito.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class OrderServiceSpringTest {

	@MockBean // MockBean으로 mock 객체를 스프링 컨텍스트에 등록
	private OrderRepository orderRepository;

	@MockBean
	private NotificationClient notificationClient;

	@Autowired // @MockBean으로 등록한 mock 객체를 주입받아서 의존성 해결
	private OrderService orderService;

	@Test
	void createOrderTest() {
		willAnswer(invocation -> {
			System.out.println("I'm mockBean orderRepository");
			return Collections.emptyList();
		}).given(orderRepository).createOrder();

		willAnswer(invocation -> {
			System.out.println("I'm mockBean notificationClient");
			return null;
		}).given(notificationClient).notifyToMobile();

		orderService.createOrder(true);

		then(orderRepository).should(times(1)).createOrder();
		then(notificationClient).should(times(1)).notifyToMobile();
	}
}
