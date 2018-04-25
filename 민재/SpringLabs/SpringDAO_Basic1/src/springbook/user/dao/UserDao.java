package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

//CRUD 함수
public class UserDao {
	//Data Add
	public void add(User user) throws ClassNotFoundException , SQLException {
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Spring","1004");
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();	
	}
	
	//Data Get
	public User get(String id) throws ClassNotFoundException , SQLException {
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Spring","1004");
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement("select * from users where id =?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		return user;
	}
	
	//Oracle -> MySql
	//중복관심에 대한 하나의 관심사로 모았다(DB연결)
	// 똑같은 코드가 반복되는게 싫어! -> 난 이걸 따로 함수로 빼놓을래
	// 이렇게 코드를 빼놔도 결국엔 성능은 똑같다 -> why? 함수 하나하나를 호출할때마다 이 코드를 써야하기 때문에
	private Connection getConnection() throws ClassNotFoundException,SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Spring","1004");
		return c;
	}
}
