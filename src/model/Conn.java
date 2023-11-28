package model;

import java.sql.*;

public class Conn {

	private String host;
	private String user;
	private String password;
	private String database;

	public Conn() {
		this.host = "da_java.mysql.dbaas.com.br";
		this.database = "da_java";
		this.user = "da_java";
		this.password = "Tecnicas*2023@";
	}

	public Connection getConnection() {
		String url="jdbc:mysql://" + this.host + ":3306/" + this.database + "?enabledTLSProtocols=TLSv1.2&verifyServerCertificate=false&useSSL=true";
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException ex) {
			System.out.println("Connection failed");
			ex.printStackTrace();
		}
		return null;
	}
}
