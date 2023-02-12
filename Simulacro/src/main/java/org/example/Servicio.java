package org.example;

import com.sun.org.apache.xpath.internal.functions.FuncBoolean;

import java.sql.*;

public class Servicio {

    public Servicio() {
    }

    public int insertar(Futbolista futbolista) throws SQLException {

        Connection connection = null;
        PreparedStatement p = null;
        try {
            connection = conectionToBBDD();
            p = connection.prepareStatement("INSERT INTO Futbolistas (Nombre, Club, Media, Ultimo_partido) VALUES (?, ?, ?, ?)");
            p.setString(1, futbolista.getNombre());
            p.setString(2, futbolista.getClub());
            p.setFloat(3, futbolista.getMedia());
            p.setTimestamp(4, futbolista.getUltimoPartido());
            p.executeUpdate();
            //Devolvemos el id del futbolista que insertamos
            return futbolista.getId();
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error en la insercion");

        }finally{ if (connection != null) connection.close();
            if (p != null) p.close();}
        return 0;
    }




    public Futbolista consultar(int id) throws SQLException {

        Connection connection = null;
        PreparedStatement p = null;
        try{
            connection = conectionToBBDD();
            p = connection.prepareStatement("SELECT * FROM Futbolistas WHERE id = ?");
            p.setInt(1, id);
            ResultSet info = p.executeQuery();
            Futbolista futbolista = new Futbolista();
            while(info.next()){
                futbolista.setId(info.getInt("Id"));
               futbolista.setNombre(info.getString("Nombre"));
               futbolista.setClub(info.getString("Club"));
               futbolista.setMedia(info.getFloat("Media"));
               futbolista.setUltimoPartido(info.getTimestamp("Ultimo_partido"));

            }
            return futbolista;
        }catch(SQLException e){
            System.out.println("Ha ocurrido un error");
            throw new RuntimeException(e);
        }finally {
            if(connection != null) connection.close();
            if(p != null) p.close();
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

    public void actualizar(Futbolista futbolista) throws SQLException{
        Connection connection = null;
        PreparedStatement p = null;
        try{
            connection = conectionToBBDD();
            p = connection.prepareStatement("UPDATE Futbolistas SET Nombre = ?");
            p.setString(1, futbolista.getNombre());
            p.executeUpdate();
        }catch(SQLException e){
            System.out.println("Ha ocurrido un error");
            throw new RuntimeException(e);
        }finally {
            if(connection != null) connection.close();
            if(p != null) p.close();
        }
    }
    public void eliminar(int id) throws SQLException{
        Connection connection = null;
        PreparedStatement p = null;
        try{
            connection = conectionToBBDD();
            p = connection.prepareStatement("DELETE FROM Futbolistas WHERE id = ?");
            p.setInt(1, id);
            p.executeUpdate();
        }catch(SQLException e){
            System.out.println("Ha ocurrido un error");
            throw new RuntimeException(e);
        }finally{
            if(connection != null) connection.close();
            if(p != null) p.close();
        }
    }

}


