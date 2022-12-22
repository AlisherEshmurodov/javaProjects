package com.mini_OOP_Projects.pdp.onlineKorzinka.service;

import com.mini_OOP_Projects.pdp.onlineKorzinka.Storage;
import com.mini_OOP_Projects.pdp.onlineKorzinka.model.User;

import java.math.BigDecimal;
import java.util.Scanner;

import static com.mini_OOP_Projects.pdp.onlineKorzinka.Storage.users;

public class MainMenu {

    public static void start(){
        System.out.println("Welcome to Shop!!!");
        User admin = new User("Ali", "admin", BigDecimal.ZERO);
        users.add(admin);
        while (true){
            System.out.println("1 - Kirish,  2 - Royxatdan Otish,  3 - Dasturni Yakunlash");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("1")){
                //login method
                User user = LoginService.signIn();
                if(user == null){
                    //agar null kelsa user xato
                    System.out.println("Login xato!");
                }
                else {
                    //null bolmasa u yoki admin yoki oddiy user boladi
                    if (user.getLogin().equals("admin")){
                        //admin part
                        AdminService.openAdminConsole(user);
                    }
                    else {
                        // user part

                    }
                }

            }
            else if(command.equals("2")){
                LoginService.signUp();
            }
            else if(command.equals("3")){
                System.exit(0);
            }
            else {
                System.err.println("Xato buyrug!!!");
            }
        }

    }
}
