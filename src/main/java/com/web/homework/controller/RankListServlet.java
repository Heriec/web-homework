package com.web.homework.controller;

import com.web.homework.model.RankList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@WebServlet("/rankList")
public class RankListServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext application = request.getServletContext();
        RankList rankList = (RankList) application.getAttribute("rankList");
        if (rankList == null) {
            rankList = new RankList();
        }
        List<RankList.Rank> listBySort = rankList.getRankListBySort();
        request.setAttribute("rank", listBySort);

        Utils.jumpTo(request, response, "rankList.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
