package org.studyeasy.spring.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.studyeasy.spring.model.User;
import org.studyeasy.spring.service.PasswordEncodingService;

public class AppDAOImple implements AppDAO {
	
	DataSource dataSource;
	

	
	  public AppDAOImple(DataSource datasource) { this.dataSource = datasource; }
	 
//
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}

	@Override
	public List<User> listUsers() {
		String SQL ="select * from users where enabled=1";
		List<User> userList = new ArrayList<User>();
		Connection conn = null;
		try {
			conn= dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				//System.out.println("Connection successfull");
				User temp = new User(
						rs.getInt("User_id"),
						rs.getString("username"),
						rs.getString("Email"));
				userList.add(temp);
			}
			
			rs.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally{
			if(conn!=null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("list size = "+userList.size());
		return userList;
	}
	@Override
	public void addUser(User user) {
		String SQL ="Insert into users (username,email,password) values(?,?,?)";
		
		Connection conn = null;
		try {
			conn= dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, new PasswordEncodingService().passwordEncoder(user.getPassword()));
			System.out.println(ps.execute());
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		finally{
			if(conn!=null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
