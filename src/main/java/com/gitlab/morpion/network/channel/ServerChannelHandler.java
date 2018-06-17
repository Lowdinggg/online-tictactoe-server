package com.gitlab.morpion.network.channel;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerChannelHandler extends SimpleChannelInboundHandler<String> {


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        // Someone joined
        // TODO: Handle connections
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // Someone left
        // TODO: Handle disconnections
    }

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String o) throws Exception {
        System.out.println("Received message: " + o);
    }
}
