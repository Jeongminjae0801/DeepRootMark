package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class KConnectionMaker implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		
		return null;
	}

}
