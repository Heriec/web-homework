package com.web.homework.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Utils {
    public static void jumpTo(HttpServletRequest request,
                        HttpServletResponse response,
                        String s)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(response.encodeURL(s));
        view.forward(request, response);
    }
}
