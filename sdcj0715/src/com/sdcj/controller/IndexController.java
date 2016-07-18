package com.sdcj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdcj.biz.InfoBIZ;
import com.sdcj.biz.ItemBIZ;
import com.sdcj.biz.NewsBIZ;
import com.sdcj.domain.Info;
import com.sdcj.domain.Item;
import com.sdcj.domain.News;

@WebServlet("/index.do")
public class IndexController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewsBIZ newsBIZ = new NewsBIZ();
		List<News> newsList = newsBIZ.findAll();

		InfoBIZ infoBIZ = new InfoBIZ();
		List<Info> infoList = infoBIZ.findAll();

		ItemBIZ itemBIZ = new ItemBIZ();
		List<Item> itemList = itemBIZ.findAll();

		request.setAttribute("itemList", itemList);
		request.setAttribute("newsList", newsList);
		request.setAttribute("infoList", infoList);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
