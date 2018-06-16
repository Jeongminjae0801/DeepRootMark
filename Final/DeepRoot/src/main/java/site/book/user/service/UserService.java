package site.book.user.service;

import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import site.book.main.handler.RollinMailHandler;
import site.book.main.handler.RollinTempKey;
import site.book.team.dao.G_AlarmDAO;
import site.book.team.dao.G_BookDAO;
import site.book.team.dao.G_MemberDAO;
import site.book.user.dao.UserDAO;
import site.book.user.dto.EmailAuthDTO;
import site.book.user.dto.UserDTO;

@Service
public class UserService {
	
	// 변수 Start
	
	// 태웅
	@Autowired
	private JavaMailSender mailSender;
	
	// 희준
	@Autowired
	private SqlSession sqlsession;
	
	// 명수
	
	
	// 변수 End
	
	// 함수 Start
	
	// 태웅
	// Roll in ID check
	public int checkUserID(String uid) {
		UserDAO userDAO = sqlsession.getMapper(UserDAO.class);
		int row = 0;
		
		try {
			row = userDAO.checkUserID(uid);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	
	// Roll in Nickname check
	public int checkUserNickname(String nname) {
		UserDAO userDAO = sqlsession.getMapper(UserDAO.class);
		int row = 0;
		
		try {
			row = userDAO.checkUserNickname(nname);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	
	// Roll in New User
	public int rollinUser(UserDTO user) {
		int row = 0;
		UserDAO userDAO = sqlsession.getMapper(UserDAO.class);
		ObjectMapper oMapper = new ObjectMapper();
		
		try {
			Map<String, String> convert_user = oMapper.convertValue(user, Map.class);
			row = userDAO.insertNewUser(convert_user);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	
	// Send authcode to User's email
	public int confirmEmail(EmailAuthDTO authcode) {
		UserDAO userDAO = sqlsession.getMapper(UserDAO.class);
		String key = new RollinTempKey().getKey(10, false);
		int row = 0;
		
		// Auth Mail Form $ Send email
		try {
			RollinMailHandler sendMail = new RollinMailHandler(mailSender);
			sendMail.setSubject("[뿌리깊은마크 이메일 인증]");
			sendMail.setText(
					new StringBuffer().append("<h1>메일인증</h1>")
									  .append("<h3>사용자님의 인증키입니다.</h3>")
									  .append("<h3>[Auth Key]: " + key + "</h3>")
									  .append("<h5 style='color:red'>※주의: 5분 안에 인증이 안될 시 회원가입이 취소됩니다.</h5>")
									  .toString()
			);
			sendMail.setFrom("bitcamp104@gmail.com", "뿌리깊은마크 관리자");
			sendMail.setTo(authcode.getUid());
			sendMail.send();
			// save user's authcode
			authcode.setAuthcode(key);
			row = userDAO.insertAuthCode(authcode);
		}catch (Exception e) {
			e.getMessage();
		}
		
		return row;
	}
	
	// Check Authcode
	public int checkAuthcode(EmailAuthDTO authcode) {
		UserDAO userDAO = sqlsession.getMapper(UserDAO.class);
		int row = 0;

		try {
			row = userDAO.checkAuthCode(authcode);
		}catch (Exception e) {
			System.out.println("Authcode error");
		}
		
		return row;
	}
	
	// 한명의 회원정보 가져오기
	public UserDTO getMember(UserDTO user) {
		UserDAO userDAO = sqlsession.getMapper(UserDAO.class);
		UserDTO editedUser = null;

		try {
			editedUser = userDAO.getUser(user);
		}catch (Exception e) {
			System.out.println("Get User Info Error");
		}
		
		return editedUser;
	}
	
	// 한명의 회원정보 수정하기
	public String editMember(HttpServletRequest request, UserDTO user, MultipartFile file) {
		UserDAO userDAO = sqlsession.getMapper(UserDAO.class);
		int result = 0;
		String changed_file_name = "";
		
		//업로드한 파일이 있다면,
		if (file != null) {
			String filename = file.getOriginalFilename();
			String path = request.getServletContext().getRealPath("/");
			String[] temp = filename.split("\\.");
			changed_file_name = user.getNname() + "." + temp[temp.length-1];
			
			String fpath = path + "images\\profile\\" + changed_file_name;
			//System.out.println(filename + " , " + fpath);

			// 서버에 파일 업로드 (write)
			FileOutputStream fs = null;
			try {
				fs = new FileOutputStream(fpath);
				fs.write(file.getBytes());
			} catch (Exception e) {
				System.out.println("이미지 쓰기 실패");
			} finally {
				try {
					fs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		try {
			user.setProfile(changed_file_name);
			result = userDAO.editUser(user);
		}catch (Exception e) {
			System.out.println("Edit User Info Error");
		}
				
		return changed_file_name;
	}
	
	// 회원 탈퇴 서비스
	public int deleteMember(String uid) {
		UserDAO userDAO = sqlsession.getMapper(UserDAO.class);
		int result = 0;

		try {
			result = userDAO.deleteUser(uid);
		}catch (Exception e) {
			System.out.println("Get User Info Error");
		}
		
		return result;
	}
	
	// 희준
	
	// 전체 회원수 가져오기
	public int getAllUser() {
		UserDAO userDAO = sqlsession.getMapper(UserDAO.class);
		int row = 0;
		
		try {
			row = userDAO.allUser();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	
	// 신규 가입자수 가져오기
	public List<HashMap<String, String>> getNewUser() {
		UserDAO userDAO = sqlsession.getMapper(UserDAO.class);
		List<HashMap<String, String>> list = null;
		
		try {
			list = userDAO.newUser();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	// 블랙리스트 추가하기
	@Transactional
	public int blacklist(String uid) {
		UserDAO userdao = sqlsession.getMapper(UserDAO.class);
		G_BookDAO gbookdao = sqlsession.getMapper(G_BookDAO.class);
		G_MemberDAO gmemberdao = sqlsession.getMapper(G_MemberDAO.class);
		G_AlarmDAO galarmdao = sqlsession.getMapper(G_AlarmDAO.class);

		int row = 0;
		
		try {
			userdao.blacklist(uid);
			userdao.deleteUserBook(uid);
			gbookdao.deleteGroupBook(uid);
			gmemberdao.leaveAllGroup(uid);
			galarmdao.deleteAllGroupAlarm(uid);
			row = 1;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	
	// 블랙리스트가 아닌 회원 리스트 가져오기 
	public List<UserDTO> getUserList() {
		UserDAO userDAO = sqlsession.getMapper(UserDAO.class);
		List<UserDTO> list = null;
		
		try {
			list = userDAO.getUserList();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	// 명수
	
	
	// 함수 End
}
