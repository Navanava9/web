package model;

import slimModel.ProvinceSurvey;
import slimModel.SQLInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Student {
    private String id;
    private String name;
    private String phone_number;
    private String e_mail;
    private String gender;
    private String province;

    public Student(String id, String name, String phone_number, String e_mail, String gender, String province) {
        this.id = id;
        this.name = name;
        this.phone_number = phone_number;
        this.e_mail = e_mail;
        this.gender = gender;
        this.province = province;
    }

    public Student() {
        super();
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public ArrayList<Student> query(String info) {
        ArrayList<Student> list = new ArrayList<Student>();

        if (info.equals("男")) info = "male";
        if (info.equals("女")) info = "female";

        SQLInfo s = new SQLInfo();
        Connection con = null;
        try {
            con = s.connectSQL();

            String sql = "SELECT *\n" +
                    "FROM student\n" +
                    "WHERE id = ?\n" +
                    "OR name LIKE ?\n" +
                    "OR gender = ?\n;";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, info);
            pst.setString(2, '%' + info + '%');
            pst.setString(3, info);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Student stu = new Student();
                stu.setId(rs.getString(1));
                stu.setName(rs.getString(2));
                stu.setGender(rs.getString(3));
                stu.setPhone_number(rs.getString(4));
                stu.setE_mail(rs.getString(5));
                list.add(stu);
            }
            pst.close();
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
        return list;
    }

    public ArrayList<ProvinceSurvey> getProvinceSummary() {
        ArrayList<ProvinceSurvey> list = new ArrayList<ProvinceSurvey>();

        SQLInfo s = new SQLInfo();
        Connection con = null;
        try {
            con = s.connectSQL();

            String sql = "select COUNT(province),province from test.student group by province;";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                ProvinceSurvey pro = new ProvinceSurvey();
                pro.setValue(rs.getInt(1));
                pro.setName(rs.getString(2));
                list.add(pro);
            }
            pst.close();
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
        return list;
    }
}
