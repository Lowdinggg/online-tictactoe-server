package com.gitlab.morpion;

import com.gitlab.morpion.network.NetworkManager;

public class Main {

    public static NetworkManager networkManager;

    public static void main(String[] args) {
        try {
            networkManager = new NetworkManager(6699);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        networkManager.run();
    }

}
