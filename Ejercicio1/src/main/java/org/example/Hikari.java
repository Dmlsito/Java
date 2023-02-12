package org.example;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Hikari {

        private static final HikariConfig config = new HikariConfig();
        private static final HikariDataSource ds;

        static{
            config.setJdbcUrl("jdbc:sqlserver://localhost:1433");
            config.setUsername("sa");
            config.setPassword("instiagra");
            config.addDataSourceProperty("database", "Ciudades");
            config.addDataSourceProperty("encrypt", "true");
            config.addDataSourceProperty("trustServerCertificate", "true");
            config.addDataSourceProperty("loginTimeout", "30");
            ds = new HikariDataSource(config);

        }

        public static Connection getConnection() throws SQLException {
            return ds.getConnection();
        }
    }


