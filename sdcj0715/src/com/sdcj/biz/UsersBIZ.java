package com.sdcj.biz;

import com.sdcj.dao.UsersDAO;
import com.sdcj.domain.Users;
import com.sdcj.util.JDBCUtil;
import com.sdcj.util.MD5_Encoding;
import com.sdcj.util.UsersUtil;

public class UsersBIZ {
	public int save(Users users) {
		try {
			UsersDAO usersDAO = new UsersDAO();
			Users usersTemp = usersDAO.findByUserName(users.getUserName());
			if (usersTemp == null) {
				usersDAO.save(users);
				return UsersUtil.USER_SUCCESS;
			} else {
				return UsersUtil.USER_USERNAME_NOT_EMPTY;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return UsersUtil.USER_ERROR;
		} finally {
			JDBCUtil.closeConnection();
		}

	}

	public Users isLogin(String userName, String userPass) {
		try {
			UsersDAO usersDAO = new UsersDAO();
			Users users = usersDAO.findByUserName(userName);
			if (users != null) {
				MD5_Encoding md5 = new MD5_Encoding();
				String md5UserPass = md5.getMD5ofStr(userPass);
				if (md5UserPass.equals(users.getUserPass())) {
					return users;
				} else {
					throw new Exception("密码错误！");
				}
			} else {
				throw new Exception("用户名不存在！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
}
