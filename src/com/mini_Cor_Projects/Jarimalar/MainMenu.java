package com.mini_Cor_Projects.Jarimalar;

import java.util.Scanner;

public class MainMenu {
    public static void EnterMenu(){
        while (true){
            System.out.println("1 - Kirish,  2 - Royxatdan Otish,   3 - Dasturni Yakunlash");

            /*
            System.out.println("      .---------.      ");
            System.out.println("   ./             \\.   ");
            System.out.println("   '_______________'    ");
            System.out.println("   (_)--__) (__--(_)    ");
            System.out.println("  (.. |01H003CB|  ..)   ");
            System.out.println("   | |           | |    ");
            System.out.println("   `-'           `-'    ");

             */

            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if(command.equals("1")){
                LoginParol.loginParol();
            }
            else if (command.equals("2")){
                LoginParol.signUp();
            }
            else if(command.equals("3")){
                System.exit(0);
            }
            else {
                System.out.println();
                System.out.println("WRONG!!!" +
                        "\nXato Buyruq Kiritdingiz!!!");
            }
        }
    }
}
