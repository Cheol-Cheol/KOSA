package kosa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosa.service.HelloService;

@Controller
public class HelloController {

	private final HelloService helloService;

	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}

//	@RequestMapping("/hello.do")
	@GetMapping({ "/", "/hello" })
	public ModelAndView hello() {

		String msg = helloService.getMessage();

		ModelAndView mav = new ModelAndView();
		mav.addObject("message", msg);
		mav.setViewName("hello");

		return mav;
	}

}
