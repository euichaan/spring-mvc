package hello.springmvc.basic.deserialize;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class DeserializeController {

	@PostMapping( "/social")
	public ResponseEntity<GenericResponse<SocialAccountResponse>> createSocialResponse(
		@RequestBody GenericResponse<SocialAccountResponse> socialAccountResponse)   {

		log.info("socialAccountResponse={}", socialAccountResponse);
		return ResponseEntity.status(HttpStatus.CREATED).body(socialAccountResponse);
	}
}
