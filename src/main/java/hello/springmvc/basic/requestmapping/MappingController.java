package hello.springmvc.basic.requestmapping;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MappingController {

	@RequestMapping(value = "/hello-basic", method = RequestMethod.GET)
	public String helloBasic() {
		log.info("helloBasic");
		return "ok";
	}

	@GetMapping("/mapping-get-v2")
	public String mappingGetV2() {
		log.info("mappingGetV2");
		return "ok";
	}

	@GetMapping("/mapping/{userId}")
	public String mappingPath(@PathVariable("userId") String data) {
		log.info("mappingPath userId={}", data);
		return "ok";
	}

	@GetMapping("/mapping/users/{userId}/orders/{orderId}")
	public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
		log.info("mappingPath userId={}, orderId={}", userId, orderId);
		return "ok";
	}

	/**
	 * 특정 파라미터 조건 매핑
	 */
	@GetMapping(value = "/mapping-param", params = "mode=debug")
	public String mappingParam() {
		log.info("mappingParam");
		return "ok";
	}

	@GetMapping(value = "/mapping-header", headers = "mode=debug")
	public String mappingHeader() {
		log.info("mappingHeader");
		return "ok";
	}

	/**
	 * 미디어 타입 조건 매핑
	 * Header의 Content-Type이 application/json 일 때만 호출
	 */
	@PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String mappingConsumes() {
		log.info("mappingConsumes");
		return "ok";
	}

	@PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_PLAIN_VALUE)
	public String mappingProduces() {
		log.info("mappingProduces");
		return "ok";
	}
}
