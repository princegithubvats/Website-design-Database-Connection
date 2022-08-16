package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User
{
  private String userid, name, email, address, password;

public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

   public int addUser() throws SQLException
   {
	//Register Driver
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			//Connection 
			String url = "jdbc:mysql://localhost:3306/userdb";
			String user = "root";
			String pass = "";
			
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			//SQL
			String sql = "insert into user values(?, ?, ?, ?, ?)";
			
			//Prepare & Execute
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, address);
			ps.setString(5, password);
			
			int response = ps.executeUpdate();
			
			//close connection
			conn.close();
			return response;
      }
}
