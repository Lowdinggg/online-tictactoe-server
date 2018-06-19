package com.gitlab.morpion.network.packet;

import io.netty.channel.Channel;

import java.io.Serializable;

public class Packet implements Serializable {

    private PacketType type;

    public Packet(PacketType type) {
        this.type = type;
    }

    public PacketType getType() {
        return type;
    }

    public void send(Channel channel) {
        channel.write(this);
    }
}
