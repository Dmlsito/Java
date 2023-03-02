package org.example;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //De esta forma obtenemos un objeto de la clase SSLServerSocketFactory
        SSLServerSocketFactory serverfactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        //De esta forma obtenemos un objeto de la clase SSLSocketFactory
        SSLSocketFactory socketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        //Una vez tengamos estas clases ya podemos crear las clases sockets y serverSocket para tener una conexion segura
        


    }
}
