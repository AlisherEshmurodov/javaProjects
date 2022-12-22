package com.mini_OOP_Projects.pdp.coWorking_Booking.com;

import com.mini_OOP_Projects.pdp.coWorking_Booking.com.model.Role;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.model.User;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.services.impls.IMainMenu;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.services.interfaces.MainMenu;

public class Application {
    public static void main(String[] args) {


        Storage.users.add(new User(User.getCurrentId(), "admin", "admin", "1", Role.ADMIN, 0));
        MainMenu instance = IMainMenu.getInstance();
        instance.startMenu();

    }
}
