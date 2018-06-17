package com.gitlab.morpion.network;

import com.gitlab.morpion.network.channel.ServerChannelInitialzer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NetworkManager {

    private int port;

    public NetworkManager(int port) throws IllegalArgumentException {
        if (port > 65535)
            throw new IllegalArgumentException("Port must be in range 0-65535");
        this.port = port;
    }

    public void start() {
        // TODO: Create server on port #port
    }

    public void run() {
        final EventLoopGroup baseGroup = new NioEventLoopGroup();
        final EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap()
             .group(baseGroup, workerGroup)
             .channel(NioServerSocketChannel.class)
             .childHandler(new ServerChannelInitialzer());

            serverBootstrap.bind(port).sync().channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            baseGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

}
