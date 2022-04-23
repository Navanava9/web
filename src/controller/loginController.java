package controller;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginController", value = "/login.do")
public class loginController extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User a = new User();

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String InputVCode = request.getParameter("VCode");

        String str = "";

        HttpSession session = request.getSession();
        String VCode = (String) session.getAttribute("VCode");

        if (!InputVCode.equals(VCode))
            str ="answer wrong!";
        else {
            if (a.userLogin(userName, password))
                str = "success!";
            else
                str = "failed!";
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(userName);
        out.println(str);
        out.flush();
        out.close();
    }

}
