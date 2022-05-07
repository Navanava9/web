package model;

import slimModel.SQLInfo;

import java.sql.*;

public class User {

    private String id;
    private String password;

    public User() {
        super();
    }

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean userRegister() {
        boolean ret = false;

        SQLInfo s = new SQLInfo();
        Connection con = null;
        try {
            con = s.connectSQL();

            String sql = "INSERT INTO user VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, id);
            pst.setString(2, password);

            int rs = pst.executeUpdate();

            if (rs == 1)
                ret = true;

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

    public boolean userLogin() {
        boolean ret = false;

        SQLInfo s = new SQLInfo();
        Connection con = null;
        try {
            con = s.connectSQL();

            String sql = "select * from user where userName = ? and password = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, id);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next())
                ret = true;

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
