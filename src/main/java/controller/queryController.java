package controller;

import com.google.gson.Gson;
import model.User;
import slimModel.UserQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "queryController", value = "/query.do")
public class queryController extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String Info = request.getParameter("info");

        User dao = new User();

        ArrayList<UserQuery> list = dao.query(Info);
        String str = "";
        Gson gson = new Gson();
        str = gson.toJson(list);

        PrintWriter out = response.getWriter();
        out.println(str);
        out.flush();
        out.close();
    }
}
