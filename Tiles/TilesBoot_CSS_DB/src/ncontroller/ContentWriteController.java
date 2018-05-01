package ncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentWriteController {
	
	@RequestMapping("/contentWrite.db")
	public String contentWrite() {
		return null;
	}
}
