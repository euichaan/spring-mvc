package hello.springmvc.basic.mockito;

import org.springframework.stereotype.Component;

@Component
public class NotificationClient {

	public void notifyToMobile() {
		System.out.println("notify to mobile success");
	}
}
