package hello.springmvc.basic.mockito;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;
	private final NotificationClient notificationClient;

	/*
	 * orderRepository.findOrderList()의 결과가 존재할 때 OrderDuplicationException이 발생하는지
	 * -> orderRepository.findOrderList()가 빈 list를 리턴하는 상황
	 * orderRepository.createOrder()가 1번 실행됐는지
	 * -> orderRepository.createOrder()가 1번 실행될 때는 아무 동작 없이 성공했다고 가정하는 상황
	 * isNotify에 따라서 notificationClient.notifyToMobile()가 실행됐는지
	 * -> notificationClient.notifyToMobile()가 실행될 때는 아무 동작 없이 성공했다고 가정하는 상황
	 */
	public void createOrder(Boolean isNotify) {
		final List<Order> orderList = orderRepository.findOrderList();
		if (orderList.size() > 0) {
			throw new OrderDuplicationException();
		}
		orderRepository.createOrder(); // 주문서 생성
		if (isNotify) {
			notificationClient.notifyToMobile();
		}
	}
}
