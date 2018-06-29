/*
 * @Project : DeepRoot
 * @FileName : G_AlarmService.java
 * @Date : 2018. 6. 5.
 * @Author : 김희준
*/


package site.book.team.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.book.team.dao.G_AlarmDAO;
import site.book.team.dto.G_AlarmDTO;

@Service
public class G_AlarmService {
	//태웅
	@Autowired
	private SqlSession sqlsession;
	
	
	//태웅
	//중복 초대/강퇴/완료 쪽지 처리하기
	public boolean alreadySend(G_AlarmDTO alarm, String alarm_kind){
		G_AlarmDAO g_alarmDAO = sqlsession.getMapper(G_AlarmDAO.class);
		boolean already_invite = false;
		String kind = alarm_kind.toUpperCase();
		
		if(kind.equals("FIRE")) { alarm.setGaid(3); } 
		else if(kind.equals("COMPLETE")){ alarm.setGaid(2); } 
		else { alarm.setGaid(1); }
		
		try {
			if( g_alarmDAO.alreadySend(alarm) > 0) {
				already_invite = true;
			}
			
		} catch (Exception e) {
			/*e.printStackTrace();*/
		}
		
		return already_invite;
	}
}
