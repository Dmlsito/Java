package org.example;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {

        Scanner teclado = new Scanner(System.in);
        Socket client = null;
        OutputStream out = null;
        DataOutputStream flujoOut = null;
        int clientsNumber = 0;
       try{
           client = new Socket("localhost", 9996);
           out = client.getOutputStream();
           flujoOut = new DataOutputStream(out);
           System.out.println(client.getPort());
           System.out.println(client.getLocalPort());
           System.out.println("A cuantos clientes debera atender el servidor ?");
           clientsNumber = teclado.nextInt();
           flujoOut.writeUTF(Integer.toString(clientsNumber));

           startClient(clientsNumber);

       }catch(SocketException e){
           e.printStackTrace();
       }finally{
           client.close();
           out.close();
           flujoOut.close();
       }
    }
    public static void startClient(int clientsNumber) throws IOException{
        Socket client = null;
        InputStream in = null;
        DataInputStream flujoIn = null;

        try{
            client = new Socket("localhost", 9997);
            in = client.getInputStream();
            flujoIn = new DataInputStream(in);
            for (int i = 1; i <= clientsNumber; i++){
                System.out.println("El servidor le dice al cliente " + i + " " +  flujoIn.readUTF());
            }
        }catch(SocketException e){
            e.printStackTrace();
        }finally{
            client.close();
            in.close();
            flujoIn.close();
        }
    }
}
