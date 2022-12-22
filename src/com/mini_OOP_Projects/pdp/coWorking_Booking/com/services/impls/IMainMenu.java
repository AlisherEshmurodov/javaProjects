package com.mini_OOP_Projects.pdp.coWorking_Booking.com.services.impls;


import com.mini_OOP_Projects.pdp.coWorking_Booking.com.Storage;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.model.Role;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.model.User;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.services.interfaces.MainMenu;


import java.util.Scanner;

public class IMainMenu implements MainMenu {

    private static MainMenu mainMenu;

    public static MainMenu getInstance(){
        if (mainMenu == null){
            mainMenu = new IMainMenu();
        }
        return mainMenu;
    }


    @Override
    public void startMenu() {
        System.out.println("Welcome To Co-Working Center!");
        while (true) {
            System.out.println("1-Enter,  2-Sign Up,  3-Finish");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("1")) {
                ISignInSignUp.getInstance().signIn();
//                if (user == null){
//                    System.out.println("You have not Registered!");
//                }
//                else {
//                    if (user.getRole().equals(Role.ADMIN)) {
//                        IAdminService1.getInstance().openAdminConsole();
//                    }
//                    if (user.getRole().equals(Role.USER)) {
//                    }
//                    if (user.getRole().equals(Role.MANAGER)) {
//                        IManagerService.getInstance().openManagerConsole();
//                    }
//                }
            }
            else if (command.equals("2")) {
                ISignInSignUp.getInstance().signUp();
            }
            else if (command.equals("3")) {
                System.exit(0);
//                break;
            }
            else {
                System.out.println("Wrong Command!!!");
            }
        }
    }
}
