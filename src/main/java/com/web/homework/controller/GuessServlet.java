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
import java.util.Random;

@WebServlet("/guess")
public class GuessServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        if (user == null) {
            Utils.jumpTo(request, response, "login.jsp");
        }

        Integer targetNum = (Integer) session.getAttribute("targetNum");
        if (targetNum == null) {
            targetNum = new Random().nextInt(100);
            session.setAttribute("targetNum", targetNum);
            session.setAttribute("guessCount", 0);
        }
        // 猜了
        String parameter = request.getParameter("guessNum");
        Integer guessCount = (Integer) session.getAttribute("guessCount");
        if (parameter != null && parameter != "") {
            Integer guessNum = Integer.parseInt(parameter);
            guessCount++;
            String message = guess(request, user, targetNum, guessNum, guessCount);
            session.setAttribute("message", message);
        }
        session.setAttribute("guessCount", guessCount);
        // 重定向防止手动刷新时重复上传上一次的表单猜测数字
        response.sendRedirect("guess.jsp");
    }

    private String guess(HttpServletRequest request,
                         String user,
                         Integer targetNum, Integer guessNum, Integer guessCount) {
        if (guessNum > targetNum) {
            return "大于";
        } else if (guessNum < targetNum) {
            return "小于";
        } else {
            ServletContext application = request.getServletContext();
            RankList rankList = (RankList) application.getAttribute("rankList");
            if (rankList == null) {
                rankList = new RankList();
                application.setAttribute("rankList", rankList);
            }
            rankList.set(user, Math.max(rankList.get(user), guessCount));
            return "猜对了";
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
