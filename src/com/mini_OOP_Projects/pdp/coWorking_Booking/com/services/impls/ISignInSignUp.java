package com.mini_OOP_Projects.pdp.coWorking_Booking.com.services.impls;

import com.mini_OOP_Projects.pdp.coWorking_Booking.com.Storage;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.model.Role;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.model.User;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.services.interfaces.SignInSignUp;

import java.util.Scanner;

public class ISignInSignUp implements SignInSignUp {

    private static SignInSignUp signInSignUp;

    public static SignInSignUp getInstance(){
        if (signInSignUp == null){
            signInSignUp = new ISignInSignUp();
        }
        return signInSignUp;
    }


    @Override
    public void signIn() {
        System.out.print("Enter your login:  ");
        Scanner scanner = new Scanner(System.in);
        String enteredLogin = scanner.nextLine();
        System.out.print("Enter your passsword:  ");
        scanner = new Scanner(System.in);
        String enteredPassword = scanner.nextLine();
        User checkUser =  Storage.users.stream()
                .filter(u -> u.getLogin().equals(enteredLogin) && u.getPassword().equals(enteredPassword))
                .findFirst()
                .orElse(null);


        if (checkUser == null){
            System.out.println("You have not Registered!");
        }
        else {
            if (checkUser.getRole().equals(Role.ADMIN)) {
                IAdminService1.getInstance().openAdminConsole();
            }
            if (checkUser.getRole().equals(Role.USER)) {
                //user console(checkUser)
            }
            if (checkUser.getRole().equals(Role.MANAGER)) {
                IManagerService.getInstance().openManagerConsole(checkUser);
            }
        }
    }

    @Override
    public void signUp() {
        System.out.print("Enter your Login:  ");
        Scanner scanner = new Scanner(System.in);
        String enteredLogin = scanner.nextLine();

        if (!isExist(enteredLogin)){
            System.out.print("Enter your passsword:  ");
            scanner = new Scanner(System.in);
            String enteredPassword = scanner.nextLine();
            System.out.print("Enter your Name:  ");
            scanner = new Scanner(System.in);
            String enteredName = scanner.nextLine();
            User user = new User(User.getCurrentId(), enteredName, enteredLogin, enteredPassword, Role.USER, 0);
            Storage.users.add(user);
            System.out.println("You have Successfully added!");
            IMainMenu.getInstance().startMenu();
        }
        else {
            System.out.println("This login already registered!");
            IMainMenu.getInstance().startMenu();
        }
    }

    public static boolean isExist(String enteredLogin){
        User user = Storage.users.stream()
                .filter(u -> u.getLogin().equals(enteredLogin))
                .findFirst()
                .orElse(null);
        return user!=null;
    }
}
