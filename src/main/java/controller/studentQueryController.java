package controller;

import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "studentQueryController", value = "/studentQuery.do")
public class studentQueryController extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String studentName = request.getParameter("studentInfo");

        Student dao = new Student();

        ArrayList<Student> list = dao.query(studentName);

        request.setAttribute("result", list);
        request.getRequestDispatcher("./jsp/queryResult.jsp").forward(request, response);
    }
}
