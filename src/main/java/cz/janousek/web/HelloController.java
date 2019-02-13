package cz.janousek.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HelloController {

	@RequestMapping(value = "/hello", method = GET)
	public String hello() {
		return "hello";
	}
}


