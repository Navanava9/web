package model;

import java.sql.*;
import java.util.ArrayList;

public class Student {
    private String id;
    private String name;
    private String phone_number;
    private String e_mail;
    private String gender;

    public Student(String id, String name, String phone_number, String e_mail, String gender) {
        this.id = id;
        this.name = name;
        this.phone_number = phone_number;
        this.e_mail = e_mail;
        this.gender = gender;
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

    public ArrayList<Student> query(String info) {
        ArrayList<Student> list = new ArrayList<Student>();

        if (info.equals("男")) info = "male";
        if (info.equals("女")) info = "female";

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC",
                    "root", "wWW714086602");

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
}
