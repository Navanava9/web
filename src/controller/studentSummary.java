package controller;

import model.Student;
import slimModel.ProvinceSurvey;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;

@WebServlet(name = "studentSummary", value = "/studentSummary.do")
public class studentSummary extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student dao = new Student();
        String str ="";

        ArrayList<ProvinceSurvey> list = dao.getProvinceSummary();

        response.setContentType("text/html;charset=utf-8");
        Gson gson = new Gson();
        str = gson.toJson(list);

        System.out.println(str);

        PrintWriter out = response.getWriter();
        out.println(str);
        out.flush();
        out.close();
    }
}
