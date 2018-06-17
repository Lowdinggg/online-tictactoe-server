package com.gitlab.morpion;

import com.gitlab.morpion.network.NetworkManager;

public class Main {

    public static NetworkManager networkManager;

    public static void main(String[] args) {
        networkManager = new NetworkManager();
        networkManager.start(6699);
    }

}
