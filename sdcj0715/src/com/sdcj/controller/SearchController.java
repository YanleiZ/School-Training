package com.sdcj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdcj.biz.IndustryBIZ;
import com.sdcj.biz.StageBIZ;
import com.sdcj.domain.Industry;
import com.sdcj.domain.Stage;

@WebServlet("/search.do")
public class SearchController extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		IndustryBIZ industryBIZ = new IndustryBIZ();
		List<Industry> industryList = industryBIZ.findAll();

		StageBIZ stageBIZ = new StageBIZ();
		List<Stage> stageList = stageBIZ.findAll();

		request.setAttribute("industryList", industryList);
		request.setAttribute("stageList", stageList);
		request.getRequestDispatcher("search.jsp").forward(request, response);
		;
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
