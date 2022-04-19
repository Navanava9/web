package model;

import java.sql.*;

public class User {

    public boolean userRegister(String userName, String pwd) {
        boolean ret = false;

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager
                    .getConnection(
                            "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC",
                            "root", "wWW714086602");

            String sql = "INSERT INTO user VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, userName);
            pst.setString(2, pwd);

            int rs = pst.executeUpdate();

            if (rs == 1) {
                ret = true;
            }

            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return ret;
    }

    public boolean userLogin(String userName, String password) {
        boolean ret = false;

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager
                    .getConnection(
                            "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC",
                            "root", "wWW714086602");

            String sql = "select * from user where userName = ? and password = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, userName);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                ret = true;
            }

            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return ret;
    }
}
