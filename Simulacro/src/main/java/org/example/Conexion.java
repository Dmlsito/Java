package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Conexion(){}

    public static Connection conectionToBBDD(){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "database = Prueba;"
                + "user = sa;"
                + "password = instiagra;"
                + "encrypt=true;"
                + "trustServerCertificate = true;"
                + "loginTimeout = 30;";
        try{
            Connection connection = DriverManager.getConnection(connectionUrl);

            return connection;
        }catch(SQLException e){
            System.out.println("Error de conexion");
            throw new RuntimeException(e);
        }
    }




}
