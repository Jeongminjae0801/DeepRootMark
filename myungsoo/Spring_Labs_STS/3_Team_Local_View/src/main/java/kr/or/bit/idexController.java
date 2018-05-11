/* 
    파일명: idexController.java
    설명: 
    작성일: 2018. 5. 5.
    작성자: 전나영
*/
package kr.or.bit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class idexController {

	@RequestMapping("index")
	public String index() {
		
		return "redirect:/index.jsp";
	}
	
}
