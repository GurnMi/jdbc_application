package kr.or.dgit.jdbc_application.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBCon {
	
	private static final DBCon instance = new DBCon();
	private Connection connection;
	
	
	public static DBCon getInstance() {
		return instance;
	}
	
	private DBCon(){
		//내부에서 생성, 외부에서 생성 못하도록 생성자 만들어줌
		Properties properties = getProperties("conf.properties");
		try {
			
			connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"), properties.getProperty("pwd"));
		} catch (SQLException e) {
			System.out.printf("%s -%s%n",e.getErrorCode(), e.getMessage());
			e.printStackTrace();
		}
		
/*		System.out.println(properties.getProperty("user"));
		System.out.println(properties.getProperty("pwd"));
		System.out.println(properties.getProperty("url"));*/
	}
	
	private Properties getProperties(String propertiesPath) {
		Properties properties =  new Properties();
		InputStream is = ClassLoader.getSystemResourceAsStream(propertiesPath);
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public Connection getConnection() {
		return connection;
	}
	
	
	
}
