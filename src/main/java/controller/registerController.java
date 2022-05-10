package controller;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "registerController", value = "/register.do")
public class registerController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String re_password = request.getParameter("re_password");

        User a = new User(userName, password);
        String str = "";

        if (!re_password.equals(password))
            str = "Different passwords";
        else {
            if (a.userRegister())
                str = "success!";
            else
                str = "failed!";
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(str);
        out.flush();
        out.close();
    }
}
