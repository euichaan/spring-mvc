package hello.springmvc.basic.mockito;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

	public List<Order> findOrderList() {
		System.out.println("real OrderRepository findOrderList");
		return Collections.emptyList();
	}

	public void createOrder() {
		System.out.println("createOrder success");
	}
}
