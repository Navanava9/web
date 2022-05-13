package model;

import slimModel.SQLInfo;

import java.sql.*;

public class User {
    private String id;
    private String name;
    private String password;
    private String gender;
    private String email;
    private String phone_num;
    private String province;
    private String city;
    private String birthday;


    public User() {
        super();
    }

    public User(String id, String name, String password, String gender, String email, String phone_num, String province, String city, String birthday) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.phone_num = phone_num;
        this.province = province;
        this.city = city;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean haveSamePhone(String arg) {
        boolean ret = false;

        SQLInfo s = new SQLInfo();
        Connection con = null;
        try {
            con = s.connectSQL();

            String sql = "select * from web.user where phone_num = ?;";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, arg);

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

    public boolean haveSameEmail(String arg) {
        boolean ret = false;

        SQLInfo s = new SQLInfo();
        Connection con = null;
        try {
            con = s.connectSQL();

            String sql = "select * from web.user where email = ?;";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, arg);

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

    public boolean haveSameID(String arg) {
        boolean ret = false;

        SQLInfo s = new SQLInfo();
        Connection con = null;
        try {
            con = s.connectSQL();

            String sql = "select * from web.user where ID = ?;";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, arg);

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
    public boolean userLogin(String arg1, String arg2) {
        boolean ret = false;

        SQLInfo s = new SQLInfo();
        Connection con = null;
        try {
            con = s.connectSQL();

            String sql = "select * from web.user where (id = ? or  phone_num = ?) AND password = ?;";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, arg1);
            pst.setString(2, arg1);
            pst.setString(3, arg2);

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

    public boolean userRegister() {
        boolean ret = false;

        SQLInfo s = new SQLInfo();
        Connection con = null;
        try {
            con = s.connectSQL();

            String sql = "INSERT INTO web.user (ID, name, password, gender, email, phone_num, province, city, birthday) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, password);
            pst.setString(4, gender);
            pst.setString(5, email);
            pst.setString(6, phone_num);
            pst.setString(7, province);
            pst.setString(8, city);
            pst.setString(9, birthday);

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
}
