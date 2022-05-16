package controller;

import slimModel.SQLInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "getProvinceController", value = "/getProvince.do")
public class getProvinceController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = "";

        SQLInfo s = new SQLInfo();
        Connection con = null;
        try {
            con = s.connectSQL();

            String sql = "select name from web.province;";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next())
                str += (rs.getString(1) + " ");

            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(str);
        out.flush();
        out.close();
    }
}
