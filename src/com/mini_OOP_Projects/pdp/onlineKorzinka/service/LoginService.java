package com.mini_OOP_Projects.pdp.onlineKorzinka.service;

import com.mini_OOP_Projects.pdp.onlineKorzinka.model.User;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.function.Predicate;

import static com.mini_OOP_Projects.pdp.onlineKorzinka.Storage.users;

public class LoginService {
    public static User signIn(){
        System.out.println("Loginni kiriting: ");
        Scanner scanner = new Scanner(System.in);
        String kiritilganLogin = scanner.nextLine();
        for (User user : users) {
            if (user.getLogin().equals(kiritilganLogin)){
                return user;
            }

        }
        return null;
    }

    public static void signUp(){
        while (true){
            System.out.print("Ismingizni kiriting: ");
            Scanner scanner = new Scanner(System.in);
            String kiritilganName = scanner.nextLine();
            System.out.print("Loginni kiriting: ");
            Scanner scanner1 = new Scanner(System.in);
            String kiritilganLogin = scanner1.nextLine();
            if (isExist(kiritilganLogin)){
                System.err.println("BU user royxatdan otgan!!!");
            }
            else {
                User newUser = new User(kiritilganName, kiritilganLogin, BigDecimal.valueOf(100000));
                users.add(newUser);
                System.out.println("Muvaffaqqiyatli royxatdan otdingiz!!!");
                break;
            }
        }
    }


    public static boolean isExist(String kiritilganLogin){
        Predicate<User> loginBormi = user -> user.getLogin().equals(kiritilganLogin);
        User user = users.stream().filter(loginBormi).findFirst().orElse(null);
        return user!= null;
    }
}
