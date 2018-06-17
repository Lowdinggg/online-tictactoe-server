package com.gitlab.morpion;

import com.gitlab.morpion.network.NetworkManager;

/**
 * Created by Lowdingg on 17/06/2018.
 *
 * @link http://lowding.ga/
 */
public class Main {

    public static NetworkManager networkManager;

    public static void main(String[] args) {
        networkManager = new NetworkManager();
        networkManager.start(6699);
    }

}
