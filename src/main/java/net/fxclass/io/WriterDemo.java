package net.fxclass.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterDemo {
    public static void main(String[] args) throws IOException {
        Writer writer=new FileWriter("d:\\writer.txt",true);
        writer.append("你好，老王");
        writer.close();
    }
}
