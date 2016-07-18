package com.sdcj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sdcj.biz.UsersBIZ;
import com.sdcj.domain.Users;
import com.sdcj.util.FileNameUtil;
import com.sdcj.util.MD5_Encoding;
import com.sdcj.util.UUIDUtil;
import com.sdcj.util.UsersUtil;

/**
 * Servlet implementation class RegController
 */
@WebServlet("/reg.do")
@MultipartConfig//文件上传必须加的注解
public class RegController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//1 接收用户请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Part part = request.getPart("userImg");
		//获得一个随机文件名。
		String uuidfilename = UUIDUtil.getUUID(); 
		//获得上传文件的真实名称
		String head = part.getHeader("Content-Disposition");
		//form-data; name="userImg"; filename="personal-com-01.png"
		String realfilename = FileNameUtil.getRealFileName(head);
		//personal-com-01.png
		//通过计算获得一个要上传的文件名称
		String savefilename = uuidfilename+FileNameUtil.getFileType(realfilename);
		//获取文件保存的位置
		String path = this.getServletContext().getRealPath("/images");
		//文件上传动作
		part.write(path+"/"+savefilename);
		//2 调用业务逻辑
		MD5_Encoding md5 = new MD5_Encoding();
		Users users = new Users();
		users.setUserName(username);
		users.setUserPass(md5.getMD5ofStr(password));
		users.setUserImg(savefilename);
		UsersBIZ usersBIZ = new UsersBIZ();
		int i = usersBIZ.save(users);
		//3 页面导航
		switch(i){
		case UsersUtil.USER_SUCCESS:
			response.sendRedirect("login.jsp");
			return;
		case UsersUtil.USER_ERROR:
			String errorInfo = "未知错误！请重新注册！";
			request.setAttribute("errorInfo", errorInfo);
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		case UsersUtil.USER_USERNAME_NOT_EMPTY:
			String usernameNotEmptyInfo = "用户名已存在，请重新输入！";
			request.setAttribute("errorInfo", usernameNotEmptyInfo);
			request.getRequestDispatcher("register.jsp").forward(request, response);
			response.sendRedirect("register.jsp");
		
			return;
		}
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}
}
