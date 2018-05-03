package ncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogInController {
	
	@RequestMapping("/login.db")
	public String login() {
		return null;
	}
}
