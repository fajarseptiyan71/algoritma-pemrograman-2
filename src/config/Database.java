package config;

import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class Database {
    public static java.sql.Connection Connection() throws SQLException {
        Dotenv env = Dotenv.configure().ignoreIfMissing().load();

        String user = env.get("POSTGRES_USER", "postgresql");
        String pass = env.get("POSTGRES_PASSWORD", "");
        String db = env.get("POSTGRES_DB", "");
        String host = env.get("POSTGRES_HOST", "localhost");
        String port = env.get("POSTGRES_PORT", "5432");

        String url = "jdbc:postgresql://" + host + ":" + port + "/" + db;

        return DriverManager.getConnection(url, user, pass);
    }
}
