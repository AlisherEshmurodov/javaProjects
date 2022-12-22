package com.copyProjects.pdp.onlineFastFood_evos.com;

import com.copyProjects.pdp.onlineFastFood_evos.com.services.interfacess.MainMenu;
import com.copyProjects.pdp.onlineFastFood_evos.com.services.imples.IMainMenu;


public class Application {
    public static void main(String[] args) {
        MainMenu instance = IMainMenu.getInstance();
        instance.startMenu();
    }
}
