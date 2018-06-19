package com.gitlab.morpion.network.packet.packets;

import com.gitlab.morpion.network.packet.Packet;
import com.gitlab.morpion.network.packet.PacketType;

public class PacketChat extends Packet {

    Object sender;
    String message;

    public Object getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public PacketChat(PacketType type, Object sender, String message) {
        super(type);
        this.sender = sender;
        this.message = message;
    }

}
