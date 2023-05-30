package hello.springmvc.basic.mockito;

import static org.mockito.BDDMockito.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest
class OrderServiceSpringTest {

	@SpyBean
	private OrderRepository orderRepository;

	@SpyBean
	private NotificationClient notificationClient;

	@Autowired
	private OrderService orderService;

	@Test
	void createOrderTest() {
		willAnswer(invocation -> {
			System.out.println("I'm spy orderRepository");
			return Collections.emptyList();
		}).given(orderRepository).findOrderList();

		willAnswer(invocation -> {
			System.out.println("I'm spy notificationClient");
			return null;
		}).given(notificationClient).notifyToMobile();

		orderService.createOrder(true);

		then(orderRepository).should(times(1)).createOrder();
		then(notificationClient).should(times(1)).notifyToMobile();
	}
}
