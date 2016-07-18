package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sdcj.domain.Users;
import com.sdcj.util.JDBCUtil;


public class UsersDAO {
	public void save(Users users) throws Exception {
		String sql = "insert into users(user_name,user_pass,user_img) values(?,?,?)";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,users.getUserName() );
		pstat.setString(2, users.getUserPass());
		pstat.setString(3, users.getUserImg());
		pstat.executeUpdate();
		
	}
	public Users findByUserName(String userName) throws Exception{
		String sql = "select * from users where user_name = ?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, userName);
		ResultSet rs = pstat.executeQuery();
		if(rs.next()){
			Users users = new Users();
			users.setUserName(rs.getString("USER_NAME"));
			users.setUserPass(rs.getString("USER_PASS"));
			users.setUserImg(rs.getString("USER_IMG"));
			return users;
		}else{
			return null;
		}
	}
}
