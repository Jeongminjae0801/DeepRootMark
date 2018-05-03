package ncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
		@RequestMapping("/index.htm")
		public String index() {
			//return "index.jsp"; 기존방법 (리졸버 없이)
			
			return "home.index"; //Tiles 적용하기 <definition name="home.*"
		}
}
