package com.mini_OOP_Projects.pdp.qoshiqqa_ovoz_berish;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Assalamu aleykum");
        System.out.println("Qoshiqlarga ovoz berish platformasiga WELCOME!");
        mainMenu();
    }


    public static void mainMenu(){
        while (true){
            System.out.println("1 - Kirish,  2 - Chiqish");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("1")){
                loginConsole();
            }
            else if(command.equals("2")){
                System.exit(0);
            }
            else {
                System.err.println("Xato buyruq!!!");
            }
        }
    }

    public static void loginConsole() {
        while (true) {
            Admin admin = new Admin();
            System.out.println("Chiqish un [-1]");
            System.out.print("Username: ");
            Scanner scanner = new Scanner(System.in);
            String username = scanner.nextLine();
            if (username.equals(admin.getAdminLogin())) {
                System.out.print("Password: ");
                scanner = new Scanner(System.in);
                String password = scanner.nextLine();
                if (password.equals(admin.getAdminParol())) {
                    Admin.adminConsole();
                }
                else if (username.equals("-1")) {
                    break;
                }
                else {
                    System.out.println("Xato parol!");
                }
            } else if (username.equals("-1")) {
                break;
            } else {
                System.out.println("Xato Username!");
            }
        }
    }



}
