package com.mini_Cor_Projects.Jarimalar;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserConsole {

static int index;
static String[][] userDanKiritilganMOshina = new String[50][];
    // 1-kiritilgan moshina soni,  2-moshina nomi,  3-moshina tezligi,  4-moshina jarimasi
    public static void openUserConsole() {
        while (true) {
            System.out.println("                                  " + LoginParol.registratedAccount[LoginParol.index][0]);
            System.out.println("1 - Moshina qoshish,  2 - Moshinalaringiz Royxati,  3 - Chiqish");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("1")) {
                moshinaRaqaminiKiritish();
            } else if (command.equals("2")) {
                userMoshinalarRoyxati();
            } else if (command.equals("3")) {
                MainMenu.EnterMenu();
            } else {
                System.err.println("WRONG!!!" +
                        "\nXato Buyruq Kiritdingiz!!!");
            }
        }
    }


    public static void moshinaRaqaminiKiritish(){
        while (true) {
            System.out.println("Moshina raqamini kiriting [exit -1]:  ");
            Scanner scanner = new Scanner(System.in);
            String userdankiritlganCarNomer = scanner.nextLine();
            if (userdankiritlganCarNomer.equals("-1")) {
                MainMenu.EnterMenu();
            }
            boolean case1 = Pattern.matches("[0-9]{1}(0|1|5){1}[0-9]{3}[A-Z]{3}", userdankiritlganCarNomer);
            boolean case2 = Pattern.matches("[0-9]{1}(0|1|5){1}[A-Z]{1}[0-9]{3}[A-Z]{2}", userdankiritlganCarNomer);
            if (case1 || case2) {
                if (buMoshinaBormi(userdankiritlganCarNomer)) {
                    showFines();
                } else {
                    System.out.println("Sizning BU Moshinangiz jarimasi yoq!!!");
                    openUserConsole();
                }
            } else {
                System.err.println("WRONG!!!" +
                        "\nXato Buyruq Kiritdingiz!!!");
            }
        }
    }


    public static boolean buMoshinaBormi(String userdankiritlganCarNomer){
        for (int i = 0; i < AdminConsole.numberOfCars; i++) {
            if(AdminConsole.enteredCarInfo[i][0].equals(userdankiritlganCarNomer)){
                index = i;
                return true;
            }
        }
        return false;
    }



    public static void showFines() {
        System.out.println("                                  " + LoginParol.registratedAccount[LoginParol.index][0]);
        System.out.println();
        System.out.println("Avtomobil ID:  " + (index + 1));
        System.out.println("Avtomobil Raqami:  " + AdminConsole.enteredCarInfo[index][0]);
        System.out.println("Avtomobil Egasi:  " + AdminConsole.enteredCarInfo[index][1]);

        if (!AdminConsole.enteredCarInfo[index][3].equals("0")){
            System.out.println("Avtomobil Tezligi:  " + AdminConsole.enteredCarInfo[index][2] + "km/s");
        }
        if(!AdminConsole.enteredCarInfo[index][3].equals("0")){
            System.out.println("Avtomobil Jarimasi:  " + AdminConsole.enteredCarInfo[index][3] + " som");
        }
        else {
            System.out.println("Tabrik!  Sizning Jarimangiz Yoq!");
        }
        System.out.println("Jarimasi tolanganmi:  " + (AdminConsole.isPaidFines[index] ? "Ha" : "Yoq"));

        if (!AdminConsole.enteredCarInfo[index][3].equals("0")){
            System.out.println();
            System.out.println("        " + AdminConsole.enteredCarInfo[index][2] + " km/s        ");
            System.out.println("      .---------.      ");
            System.out.println("   ./            \\.   ");
            System.out.println("   '_______________'    ");
            System.out.println("   (_)--__) (__--(_)    ");
            System.out.println("  (.. |" + AdminConsole.enteredCarInfo[index][0] + "|  ..)   ");
            System.out.println("   | |           | |    ");
            System.out.println("   `-'           `-'    ");
            System.out.println();
            System.out.println("******************************************");


        }



        tolovQilishniTanlash();
    }

    public static void tolovQilishniTanlash() {
        while (true) {
            System.out.println("1 - Avtomobil jarimasini Tolash,  2 - Chiqish");
            Scanner scanner = new Scanner(System.in);
            String commnand = scanner.nextLine();
            if (commnand.equals("1")) {
                payFines();
            } else if (commnand.equals("2")) {
                openUserConsole();
            } else {
                System.err.println("WRONG!!!" +
                        "\nXato Buyruq Kiritdingiz!!!");
            }
        }
    }




    public static void payFines(){
        System.out.println("Sizning Jarimangiz:  " + AdminConsole.enteredCarInfo[index][3] + " som");
        System.out.print("Tolov turini tanlang:  ");
        while (true){
            System.out.println("1 - Payme,  2 - Click,  3 - Apelsin");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if(command.equals("1") || command.equals("2") || command.equals("3") ){
                System.out.println("Necha pul tolaysiz:  ");
                scanner = new Scanner(System.in);
                int kiritilganPul = scanner.nextInt();
                if(kiritilganPul > Integer.parseInt(AdminConsole.enteredCarInfo[index][3]) ){
                    System.err.println("Wrong!!! " +
                            "\nSiz kop pul kiritdingiz!" +
                            "\nBizga birovni haqqi kerak emas!");
                }
                else if(kiritilganPul <= Integer.parseInt(AdminConsole.enteredCarInfo[index][3]) ){
                    AdminConsole.enteredCarInfo[index][3] = String.valueOf(Integer.parseInt(AdminConsole.enteredCarInfo[index][3]) - kiritilganPul);
                    if(AdminConsole.enteredCarInfo[index][3].equals("0")){
                        System.out.println("Tabrik! Sizning Jarimangiz qolmadi");
                        AdminConsole.isPaidFines[index] = true;
                        openUserConsole();
                    }
                    else if(Integer.parseInt(AdminConsole.enteredCarInfo[index][3]) > 0){
                        System.out.println("Sizning tolanmagan Jarimangiz:  " + AdminConsole.enteredCarInfo[index][3] + " som");
                        tolovQilishniTanlash();
                    }
                    else {
                        System.err.println("WRONG!!!" +
                                "\nXato Buyruq Kiritdingiz!!!");
                    }
                }

                break;
            }
            else {
                System.err.println("WRONG!!!" +
                        "\nXato Buyruq Kiritdingiz!!!");
            }
        }
    }


    public static void userMoshinalarRoyxati(){
        System.out.println("*************  Moshinalar Royxati  *************");
    }
}
