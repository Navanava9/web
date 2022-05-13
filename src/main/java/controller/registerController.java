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
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String phone_num = request.getParameter("phone_num");
        String province = request.getParameter("province");
        String city = request.getParameter("city");
        String birthday = request.getParameter("birthday");

        User a = new User(userName, name, password, gender, email, phone_num, province, city, birthday);
        String str = "";

        if (a.haveSameEmail(email))
            str = "该邮箱已被使用！";
        else if (a.haveSameID(userName))
            str = "该用户名已被使用！";
        else if (a.haveSamePhone(phone_num))
            str = "该手机号已被使用！";
        else {
            if (a.userRegister())
                str = "注册成功！";
            else
                str = "注册失败!";
        }


        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(str);
        out.flush();
        out.close();
    }
}
