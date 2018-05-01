package ncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentEditController {
	
	@RequestMapping("/contentEdit.htm")
	public String contentEdit() {
		return "content.contentEdit";
	}
}
