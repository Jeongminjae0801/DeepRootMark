package ncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentListController {
	
	@RequestMapping("/contentList.db")
	public String contentList() {
		return null;
	}
}
