package controller;

import com.google.gson.Gson;
import model.User;
import slimModel.GenderSummary;
import slimModel.ProvinceSummary;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "GenderSummaryController", value = "/GenderSummary.do")
public class GenderSummaryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User dao = new User();
        String str ="";

        ArrayList<GenderSummary> list = dao.getGenderSummary();

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
