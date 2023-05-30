package hello.springmvc.basic.mockito;

import static org.mockito.BDDMockito.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

	private OrderService orderService;

	@Mock
	private OrderRepository orderRepository;

	@Mock
	private NotificationClient notificationClient;

	@Test
	void createOrderTest() {
		orderService = new OrderService(orderRepository, notificationClient);

		given(orderRepository.findOrderList()).will(invocation -> {
			System.out.println("I'm mock orderRepository");
			return Collections.emptyList();
		});

		willAnswer(invocation -> {
			System.out.println("I'm mock notificationClient");
			return null;
		}).given(notificationClient).notifyToMobile();

		orderService.createOrder(true);

		then(orderRepository).should(times(1)).createOrder();
		then(notificationClient).should(times(1)).notifyToMobile();
	}
}