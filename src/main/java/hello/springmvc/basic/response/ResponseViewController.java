package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

	@GetMapping("/response-view-v1")
	public ModelAndView responseViewV1() {
		ModelAndView view = new ModelAndView("response/hello")
			.addObject("data", "hello!");

		return view;
	}

	@GetMapping("/response-view-v2")
	public String responseViewV2(Model model) {
		model.addAttribute("data", "hello!");
		return "response/hello"; // 뷰의 논리 이름을 반환
	}

	@GetMapping("/response/hello")
	public void responseViewV3(Model model) {
		model.addAttribute("data", "hello!");
	}
}
