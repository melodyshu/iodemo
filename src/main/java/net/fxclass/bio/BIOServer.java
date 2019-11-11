package net.fxclass.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class BIOServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket=new ServerSocket(9090);
        System.out.println("监听:"+serverSocket.getLocalSocketAddress());
        while(true){
            Socket client = serverSocket.accept();
            System.out.println("客户端连接:"+client.getRemoteSocketAddress());
            Scanner scanner= new Scanner(client.getInputStream());
            while (true){
                String str = scanner.nextLine();
                if("quit".equals(str)){
                    break;
                }
                System.out.println(client.getRemoteSocketAddress()+":"+str);
                String response="from server:"+str+"\n";
                client.getOutputStream().write(response.getBytes());
            }
        }
    }
}
