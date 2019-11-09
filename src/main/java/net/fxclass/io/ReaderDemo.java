package net.fxclass.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class ReaderDemo {
    public static void main(String[] args) throws Exception {
        Reader reader=new FileReader("d:\\writer.txt");
        BufferedReader bufferedReader=new BufferedReader(reader);
        StringBuffer sb = new StringBuffer();
        String str;
        while ((str=bufferedReader.readLine())!=null){
            sb.append(str+"\n");
        }
        bufferedReader.close();
        reader.close();
        System.out.println(sb.toString());
    }
}
