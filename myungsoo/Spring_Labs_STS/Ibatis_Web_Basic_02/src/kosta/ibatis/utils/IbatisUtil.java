package kosta.ibatis.utils;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;


public class IbatisUtil {
	
	//Singleton 만든 것이다.
	// sqlmapclient.getsqlmapcliend() 를 해서 sqlmapper의 주소를 받는다.
	private static SqlMapClient sqlMapper; 
	//ibatis SqlMapClient (핵심객체 : 전역)
	
	static{
		try {
			
		    Reader reader = Resources.getResourceAsReader("kosta/ibatis/sqlmap/sqlMapConfig.xml");
		    sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlMapClient getSqlMapClient(){
		return sqlMapper;
	}
	
}
