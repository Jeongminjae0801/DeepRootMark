package ncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentEditController {
	
	@RequestMapping("/contentedit.db")
	public String contentEdit() {
		return null;
	}
}
