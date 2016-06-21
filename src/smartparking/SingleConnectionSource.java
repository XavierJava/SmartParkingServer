package smartparking;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class SingleConnectionSource {
    static String databaseUrl = "jdbc:mysql://localhost:3306/smartparking";
    static private ConnectionSource connectionSource;

    private SingleConnectionSource() {
    }

    public static ConnectionSource getConnectionSource() {
        if (connectionSource == null) {
            try {
                connectionSource = new JdbcConnectionSource(databaseUrl, "root", "chenhuan");
            } catch (SQLException e) {
                System.out.println("创建链接源失败!!!");
                System.out.println(e.getMessage());
            }
        }
        return connectionSource;
    }
}
