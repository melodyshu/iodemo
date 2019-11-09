package net.fxclass.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//InputStream、OutputStream 基于字节操作的 IO
public class OutputStreamDemo {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream=new FileOutputStream("d:\\test2.txt",true);
        byte[] bytes="你好,老王".getBytes("utf-8");
        outputStream.write(bytes);
        outputStream.close();

    }
}
