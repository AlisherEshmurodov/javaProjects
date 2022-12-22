package com.mini_OOP_Projects.pdp.coWorking_Booking.com.services.interfaces;

import com.mini_OOP_Projects.pdp.coWorking_Booking.com.model.User;

public interface ManagerService {

    void openManagerConsole(User checkUser);
    void showMyCoWorkings(User currentManager);
    void addRoom(User currentManager);

}
