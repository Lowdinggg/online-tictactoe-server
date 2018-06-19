package com.gitlab.morpion.network.channel;

import com.gitlab.morpion.network.packet.Packet;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;


public class ServerChannelInitialzer extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel socketChannel) throws Exception {

        ChannelPipeline pipe = socketChannel.pipeline();

        pipe.addLast("encoder", new ObjectEncoder());
        pipe.addLast("decoder", new ObjectDecoder(ClassResolvers.weakCachingResolver(Packet.class.getClassLoader())));

        pipe.addLast("handler", new ServerChannelHandler());

        System.out.println("Initialized main channel");
    }
}
