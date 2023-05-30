package hello.springmvc.basic.mockito;

import static org.mockito.BDDMockito.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

	@Spy // 선택적으로 stub 할 수 있다
	private OrderRepository orderRepository;

	@Spy
	private NotificationClient notificationClient;

	@InjectMocks
	private OrderService orderService;

	@Test
	void createOrderTest() {
		willAnswer(invocation -> {
			System.out.println("I'm spy orderRepository createOrder");
			return Collections.emptyList();
		}).given(orderRepository).createOrder();

		willAnswer(invocation -> {
			System.out.println("I'm mock notificationClient");
			return null;
		}).given(notificationClient).notifyToMobile();

		orderService.createOrder(true);

		then(orderRepository).should(times(1)).createOrder();
		then(notificationClient).should(times(1)).notifyToMobile();
	}
}