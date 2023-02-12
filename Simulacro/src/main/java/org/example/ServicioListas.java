package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicioListas {

    public ServicioListas(){}

    public void inserBatch(List<Futbolista> listFutubolist) throws SQLException {
        Connection connection = null;
        PreparedStatement p = null;
        try{
            connection = conectionToBBDD();
            p = connection.prepareStatement("INSERT INTO Futbolistas (Nombre, Club, Media, Ultimo_Partido) VALUES(?, ?, ?, ?)");
            for(Futbolista futbolista: listFutubolist) {

                p.setString(1, futbolista.getNombre());
                p.setString(2, futbolista.getClub());
                p.setDouble(3, futbolista.getMedia());
                p.setTimestamp(4, futbolista.getUltimoPartido());
                p.addBatch();
            }
            p.executeBatch();
        }catch(SQLException e){
            System.out.println("Ha ocurrido un error");
            throw new RuntimeException(e);
        }finally {

        }


    }



    public List<Futbolista> listarTodo() throws SQLException{
        Connection connection = null;
        PreparedStatement p = null;
        try{
            connection = conectionToBBDD();
            p = connection.prepareStatement("SELECT * FROM Futbolistas");
            ResultSet info = p.executeQuery();
            List<Futbolista> listFubolistas = new ArrayList<Futbolista>();
            while(info.next()){

                Futbolista futbolista = new Futbolista( info.getInt("Id"), info.getString("Nombre"), info.getString("Club"), info.getFloat("Media"), info.getTimestamp("Ultimo_Partido"));
                listFubolistas.add(futbolista);
            }
            return listFubolistas;
        }catch(SQLException e){
            System.out.println("Ha ocurrido un error");
            throw new RuntimeException(e);

        }

    }

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
