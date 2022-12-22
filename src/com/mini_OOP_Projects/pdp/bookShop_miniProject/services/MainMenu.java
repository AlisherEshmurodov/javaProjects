package com.mini_OOP_Projects.pdp.bookShop_miniProject.services;



import com.mini_OOP_Projects.pdp.bookShop_miniProject.Storage;
import com.mini_OOP_Projects.pdp.bookShop_miniProject.model.UsersName;

import java.util.Scanner;

import static com.mini_OOP_Projects.pdp.bookShop_miniProject.Storage.*;

public class MainMenu {
    public static void mainMenu() {
        System.out.println("Welcome To Book Shop of AliSheyx");
        while (true){

            System.out.println("      ,————————————————,-\\     ");
            System.out.println("      |                |  \\   ");
            System.out.println("      |     BOOKS      |  |    ");
            System.out.println("      |                |  |    ");
            System.out.println("      |     JAVA       |  |    ");
//            System.out.println("      |                |  |    ");
            System.out.println("      |                |  |    ");
            System.out.println("      |          2017  |  |    ");
            System.out.println("      \\————————————————\\  |      ");
            System.out.println("       \\________________`,|      ");
            System.out.println("                                  ");

            System.out.println("1-Enter,  2-Finish Progress");


            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("1")){
                usernameParolInterface();
            }
            else if (command.equals("2")){
                System.exit(0);
            }
            else {
                System.err.println("Wrong command!  TRY AGAIN!!!");
            }
        }
    }


    public static void usernameParolInterface(){
        while (true){
            System.out.print("Login  [exit  -1] :  ");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("-1")){
                mainMenu();
            }
            if (command.equals(adminLogin)){
                System.out.print("Parol:  ");
                scanner = new Scanner(System.in);
                String command2 = scanner.nextLine();
                if (command2.equals(adminParol)){
                    AdminService.adminConsole();
                }
                else {
                    System.out.println("Wrong command!  TRY AGAIN!!!");
                }
            }
            else if(command.equals(userLogin)){
                System.out.print("Ismingizni kiriting:  ");
                scanner = new Scanner(System.in);
                String kiritilganUsername = scanner.nextLine();
                System.out.print("Parol:  ");
                scanner = new Scanner(System.in);
                String command2 = scanner.nextLine();
                if (command2.equals(userParol)){
                    UsersName usersName = new UsersName(kiritilganUsername);
                    usersNames.add(usersName);
                    Storage.totalCost = 0;
                    UserService.userConsole();
                }
                else {
                    System.out.println("Wrong command!  TRY AGAIN!!!");
                }
            }
            else {
                System.out.println("Wrong command!  TRY AGAIN!!!");
            }
        }

    }

}
