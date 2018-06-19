package com.gitlab.morpion.network.packet.packets;

import com.gitlab.morpion.network.packet.Packet;
import com.gitlab.morpion.network.packet.PacketType;

public class PacketHandshake extends Packet {

    boolean authorisation;

    public PacketHandshake(PacketType type, boolean authorisation) {
        super(type);
        this.authorisation = authorisation;
    }
}
