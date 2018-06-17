package com.gitlab.morpion.network.channel;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


public class ServerChannelInitialzer extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipe = socketChannel.pipeline();

        pipe.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        pipe.addLast("encoder", new StringEncoder());
        pipe.addLast("decoder", new StringDecoder());

        pipe.addLast("handler", new ServerChannelHandler());

        System.out.println("Initialized main channel");
    }
}
