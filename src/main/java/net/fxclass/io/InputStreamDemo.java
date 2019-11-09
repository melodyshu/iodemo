package net.fxclass.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

//InputStream、OutputStream 基于字节操作的 IO
public class InputStreamDemo {
    public static void main(String[] args) throws Exception {
        InputStream inputStream=new FileInputStream("c:\\test.txt");
        byte[] bytes=new byte[inputStream.available()];
        inputStream.read(bytes);
        String str=new String(bytes,"UTF-8");
        System.out.println(str);
        inputStream.close();

    }
}
