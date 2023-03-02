package org.example;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.security.Key;

public class Encrypt {
    public static void main(String[] args) {
        try{
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream("Clave.ken"));
            Key secretKey = (Key) oin.readObject();
            oin.close();

            Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, secretKey);
            FileInputStream fileIn = new FileInputStream("PruebaPdf.pdf");

            CipherOutputStream out = new CipherOutputStream(new FileOutputStream("FicheroPDF.Cifrado"), c);
            int blockSize = c.getBlockSize();
            byte[] bytes = new byte[blockSize];

            int i = fileIn.read(bytes);
            while (i != -1) {
                out.write(bytes, 0, i);
                i = fileIn.read(bytes);
            }
            out.flush();
            out.close();
            fileIn.close();
            System.out.println("The file has been encrypted");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
