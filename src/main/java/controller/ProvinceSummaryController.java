package controller;

import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import slimModel.ProvinceSummary;

@WebServlet(name = "ProvinceSummaryController", value = "/ProvinceSummary.do")
public class ProvinceSummaryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User dao = new User();
        String str ="";

        ArrayList<ProvinceSummary> list = dao.getProvinceSummary();

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
