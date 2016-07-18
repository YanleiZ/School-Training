package com.sdcj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdcj.biz.InfoBIZ;
import com.sdcj.domain.Info;

@WebServlet("/infofindbyid.do")
public class InfoFindByIdController extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//1 接收用户请求
		int id = Integer.parseInt(request.getParameter("id"));
		//2 调用业务
		InfoBIZ infoBIZ = new InfoBIZ();
		Info info = infoBIZ.findById(id);
		//3 页面导航
		request.setAttribute("info", info);
		request.getRequestDispatcher("information.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
