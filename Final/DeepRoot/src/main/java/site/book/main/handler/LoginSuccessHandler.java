package site.book.main.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @Class : AdminController.java
 * @Date : 2018. 6. 12.
 * @Author : 김태웅
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
    private SqlSession sqlsession;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		
	}
	
}
