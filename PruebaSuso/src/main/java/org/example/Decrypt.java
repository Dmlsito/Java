package org.example;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.security.Key;

public class Decrypt {
    public static void main(String[] args) {
        try{
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream("Clave.ken"));
            Key secretKey = (Key) oin.readObject();
            oin.close();

            Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, secretKey);

            CipherInputStream in = new CipherInputStream(new FileInputStream("FicheroPDF.Cifrado"), c);
            int blockSize = c.getBlockSize();
            byte[] bytes = new byte[blockSize];

            FileOutputStream fileout = new
                    FileOutputStream("FICHEROdescifrado.pdf");

            int i = in.read(bytes);
            while (i != -1) {
                fileout.write(bytes, 0, i);
                i = in.read(bytes);
            }
            fileout.close();
            in.close();
            System.out.println("The file has been decrypted");

        }catch(Exception e){
            e.printStackTrace();
        }}
}
