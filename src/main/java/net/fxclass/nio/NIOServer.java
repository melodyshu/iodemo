package net.fxclass.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    public static void main(String[] args) throws Exception {
        Selector selector = Selector.open();
        final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9090));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        while (true){
            int select=selector.select();
            if(select==0){
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while(iterator.hasNext()){
                SelectionKey key = iterator.next();
                if(key.isAcceptable()){
                   ServerSocketChannel channel= (ServerSocketChannel)key.channel();
                    SocketChannel clientChannel = channel.accept();
                    System.out.println("Connect from "+clientChannel.getRemoteAddress());
                    clientChannel.configureBlocking(false);
                    clientChannel.register(selector, SelectionKey.OP_READ);
                }
                if(key.isReadable()){
                    SocketChannel channel= (SocketChannel)key.channel();
                    channel.read(buffer);
                    String request=new String(buffer.array()).trim();
                    buffer.clear();
                    System.out.println(channel.getRemoteAddress()+":"+request);
                    channel.write(ByteBuffer.wrap(request.getBytes()));
                }
                iterator.remove();
            }

        }
    }
}
