package org.example;
import java.net.*;
import java.io.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.rmi.ServerError;

public class Servidor {

    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        InputStream in = null;
        DataInputStream flujoIn = null;
        Socket client = null;
        int clientes = 0;

         try{
             server = new ServerSocket(9996);
             client = server.accept();
             in = client.getInputStream();
             flujoIn = new DataInputStream(in);
             clientes = Integer.parseInt(flujoIn.readUTF());

             startServer(clientes);

         }catch(ServerError e){
             e.printStackTrace();
         }finally{
             server.close();
             client.close();
             in.close();
             flujoIn.close();
         }
    }
    public static void startServer(int clientes) throws IOException{

        ServerSocket server = null;
        Socket clientConnected = null;
        OutputStream out = null;
        DataOutputStream flujoOut = null;

        try{
            server = new ServerSocket(9997);
            clientConnected = server.accept();
            out = clientConnected.getOutputStream();
            flujoOut = new DataOutputStream(out);

            for(int i = 1; i <= clientes; i++){
                flujoOut.writeUTF("Hola, cliente " + i);
            }

        }catch(ServerError e){
            e.printStackTrace();
        }finally{
            server.close();
            clientConnected.close();
            out.close();
            flujoOut.close();
        }
    }




}
