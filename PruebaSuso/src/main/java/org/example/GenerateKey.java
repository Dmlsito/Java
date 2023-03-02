package org.example;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.NoSuchAlgorithmException;

/**
 * Hello world!
 *
 */
public class GenerateKey
{
    public static void main( String[] args )
    {
        try{
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);

            SecretKey key = keyGenerator.generateKey();

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Clave.ken"));
            out.writeObject(key);
            out.close();
            System.out.println("The key has been generated");

        }catch (NoSuchAlgorithmException e) {e .printStackTrace (); }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
    }
}
