package com.mini_Cor_Projects.Jarimalar;

import java.util.Arrays;
import java.util.Scanner;
public class LoginParol {

    static String[][] registratedAccount = new String[30][2];   // 1-login,   2-parol
    static int numberOfAccounts = 0;
    static int index;

    static String adminLogin = "admin";
    static String adminParol = "1";
    static String userLogin;
    static String userParol;

    public static void loginParol(){
        while (true) {
            System.out.println("Chiqish uchun [-1] :");
            System.out.print("Login: ");
            Scanner scanner = new Scanner(System.in);
            String enteredLogin = scanner.nextLine();
            if (enteredLogin.equals("-1")) {
                MainMenu.EnterMenu();
            }
//            String enteredLogin = scanner.next("[A-Z]{2}[0-9]{2}");
            System.out.print("Parol: ");
            scanner = new Scanner(System.in);
            String enteredParol = scanner.nextLine();


                //Account registratsiyadan otgan otmaganalgini tekshiriw
                for (int i = 0; i < numberOfAccounts; i++) {
                    if (registratedAccount[i][0].equals(enteredLogin) && registratedAccount[i][1].equals(enteredParol)) {
                        index = i;
                    }
                }
                if (enteredLogin.equals(adminLogin) && enteredParol.equals(adminParol)) {
                    AdminConsole.openAdminConsole();
                } else if (enteredLogin.equals(registratedAccount[index][0]) && enteredParol.equals(registratedAccount[index][1])) {
                    System.out.println("Registrated Accounts:  " + Arrays.deepToString(registratedAccount));
                    UserConsole.openUserConsole();
                } else {
                    System.out.println("WRONG!!!" +
                            "\nBunaqa Login registatsiyadan otmagan!!!");
                }

        }
    }


    public static void signUp(){
        while (true){
            System.out.print("Login:  ");
            Scanner scanner = new Scanner(System.in);
            String newLogin = scanner.nextLine();
            for (int i = 0; i < numberOfAccounts; i++) {
                if (registratedAccount[i][0].equalsIgnoreCase(newLogin)){
                    System.out.println("Bu Login Registratsiyadan otgan" +
                            "\nBoshqa Login kiriting!!!");
                }
            }
            System.out.print("Parol:  ");
            scanner = new Scanner(System.in);
            String newParol = scanner.nextLine();
            System.out.print("Tasdiqlash uchun yana Bir bor Parolingizni kiriting:  ");
            scanner = new Scanner(System.in);
            String newParol1 = scanner.nextLine();
            if (newParol1.equals(newParol)){
                System.out.println("Registratsiyadan Muvaffaqqiyatli otdingiz!");
                registratedAccount[numberOfAccounts][0] = newLogin;
                registratedAccount[numberOfAccounts][1] = newParol;
                numberOfAccounts++;
                break;
            }
            else {
                System.out.println("ERROR!!!  TRY AGAIN!!!");
            }
        }

    }
}
