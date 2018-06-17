package com.gitlab.morpion.network.channel;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerChannelHandler extends SimpleChannelInboundHandler<String> {


    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String o) throws Exception {
        System.out.println("Received message: "+o);
    }
}
