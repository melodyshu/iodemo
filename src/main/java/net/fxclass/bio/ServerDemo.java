package net.fxclass.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket=new ServerSocket(9090);
        //获取一个客户端socket
        while (true){
            Socket client= serverSocket.accept();//阻塞
            System.out.println("客户端:"+client.getInetAddress().getLocalHost()+"已连接到服务器");
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String msg=br.readLine();
            System.out.println("客户端："+msg);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bw.write(msg+"\n");
            bw.flush();
        }

    }
}
