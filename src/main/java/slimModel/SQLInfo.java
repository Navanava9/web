package slimModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLInfo {
    private String DriverPath = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/web?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
    private String user = "root";
    private String password = "wWW714086602";

    public String getDriverPath() {
        return DriverPath;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public final Connection connectSQL() throws ClassNotFoundException, SQLException {
        Class.forName(this.DriverPath);
        return DriverManager.getConnection(this.url, this.user, this.password);
    }
}
