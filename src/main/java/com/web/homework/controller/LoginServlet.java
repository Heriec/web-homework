package com.web.homework.controller;

import com.web.homework.model.RankList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        // 未登录
        if (user == null) {
            String username = request.getParameter("user");
            if (username == null) {
               Utils.jumpTo(request, response, "login.jsp");
               return;
            }
            session.setAttribute("user", username);
        }
        Utils.jumpTo(request, response, "guess.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
