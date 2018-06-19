package com.gitlab.morpion.network.channel;


import com.gitlab.morpion.network.packet.Packet;
import com.gitlab.morpion.network.packet.PacketProcessor;
import com.gitlab.morpion.network.packet.PacketType;
import com.gitlab.morpion.network.packet.packets.PacketHandshake;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.logging.Logger;

public class ServerChannelHandler extends SimpleChannelInboundHandler<Object> {


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        boolean authorisation = true;         // TODO: Check if game started

        PacketHandshake packetHandshake = new PacketHandshake(PacketType.SERVER, authorisation);
        packetHandshake.send(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // TODO: Send packet to remaining player
    }

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        if(!(o instanceof Packet)) {
            Logger.getLogger("CONSOLE").warning("Received unknown object. " + o.getClass().getCanonicalName());
            return;
        }
        final Packet packet = (Packet) o;
        PacketProcessor.processPacket(packet);
    }
}
