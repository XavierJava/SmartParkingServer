package smartparking.dao;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by chenhuanhuan on 16-5-24.
 */
public class SingleConnectionSource {
    static String databaseUrl = "jdbc:mysql://localhost:3306/smartparking";
    static ConnectionSource connectionSource;

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
