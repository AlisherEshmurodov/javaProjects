package com.mini_Cor_Projects.Jarimalar;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AdminConsole {

    static String[][] enteredCarInfo = new String[20][4];  // 1-carsNumber, 2-ownerName,  3-carSpeed,  4-carFines
    static boolean[] isHaveThisCar = new boolean[20];
    static boolean[] isPaidFines = new boolean[20];
    static int numberOfCars = 0;
    static int bhmPrices = 300000;
    static int enteredCarFines;


    public static void openAdminConsole(){
        while (true) {
            System.out.println("1 - Avtomobil raqamini va Tezligini  kiritish,  2 - Avtomobillar Royxati,  3 - Chiqish");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("1")) {
                addCarFines();
            } else if (command.equals("2")) {
                listOfCars();
            } else if (command.equals("3")) {
                MainMenu.EnterMenu();
            } else {
                System.out.println("WRONG!!!" +
                        "\nXato Buyruq Kiritdingiz!!!");
            }
        }
    }


    public static void addCarFines(){
        System.out.println("1 - Jismoniy Shaxs,  2 - Yuridik Shaxs  3 - Ortga");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        if(command.equals("1")){
            physicalPerson();
        }
        else if (command.equals("2")){
            leganEntity();
        }
        else if (command.equals("3")){
            openAdminConsole();
        }
        else {
            System.out.println("WRONG!!!" +
                    "\nXato Buyruq Kiritdingiz!!!");
        }

    }


    public static void physicalPerson(){
        while (true){
            System.out.println("Enter car Number: ");
            Scanner scanner = new Scanner(System.in);
            String  enteredCarNumber = scanner.nextLine();
            boolean case1 = Pattern.matches("[0-9]{1}(0|1|5){1}[A-Z]{1}[0-9]{3}[A-Z]{2}",enteredCarNumber);
            if(case1){
                if(!shuMoshinaKiritilganmi(enteredCarNumber)){
                    System.out.println("Avtomobil Shaxsini kiriting: ");
                    Scanner scanner1 = new Scanner(System.in);
                    String enteredCarPersonality = scanner1.nextLine();
                    System.out.println("Avtomobil tezligini Kiriting: ");
                    scanner1 = new Scanner(System.in);
                    int enteredCarSpeed = scanner1.nextInt();
                    if(enteredCarSpeed > 70 && enteredCarSpeed <= 90){
                        enteredCarFines = bhmPrices;
                    }
                    else if(enteredCarSpeed > 90 && enteredCarSpeed <= 110){
                        enteredCarFines = 5*bhmPrices;
                    }
                    else if(enteredCarSpeed > 110 && enteredCarSpeed <= 130){
                        enteredCarFines = 10*bhmPrices;
                    }
                    else if(enteredCarSpeed > 130){
                        enteredCarFines = 20*bhmPrices;
                    }
                    else {
                        enteredCarFines = 0;
                    }

                    enteredCarInfo[numberOfCars][0] = enteredCarNumber;
                    enteredCarInfo[numberOfCars][1] = enteredCarPersonality;
                    enteredCarInfo[numberOfCars][2] = String.valueOf((int) enteredCarSpeed);
                    enteredCarInfo[numberOfCars][3] = String.valueOf((int) enteredCarFines);
                    numberOfCars++;



                    while (true){
                        System.out.println("Davom etasizmi qoshishni? [h/y]: ");
                        scanner1 = new Scanner(System.in);
                        String command = scanner1.nextLine();
                        if (command.equalsIgnoreCase("h")){
                            break;
                        }
                        else if (command.equalsIgnoreCase("y")){

                            System.out.println("CarsInfo:  " + Arrays.deepToString(enteredCarInfo));  //???????????

                            openAdminConsole();
                        }
                        else {
                            System.out.println("WRONG!!!" +
                                    "\nXato Buyruq Kiritdingiz!!!");
                        }
                    }
                }
                else {
                    System.out.println("Bu avtomobil oldin Kiritilgan!   TRY AGAIN!!!");
                }

            }
            else{
                System.out.println("WRONG!!!" +
                        "\nXato Buyruq Kiritdingiz!!!");
            }
        }
    }


    public static boolean shuMoshinaKiritilganmi(String  enteredCarNumber){
        for (int i = 0; i < numberOfCars; i++) {
            if(enteredCarInfo[i][0].equals(enteredCarNumber)){
                return true;
            }
        }
        return false;
    }



    public static void leganEntity(){
        while (true){
            System.out.println("Enter car Number: ");
            Scanner scanner = new Scanner(System.in);
            String  enteredCarNumber = scanner.nextLine();
            boolean case1 = Pattern.matches("[0-9]{1}(0|1|5){1}[0-9]{3}[A-Z]{3}",enteredCarNumber);
            if(case1){
                if(!shuMoshinaKiritilganmi(enteredCarNumber)){
                    System.out.println("Avtomobil Shaxsini kiriting: ");
                    Scanner scanner1 = new Scanner(System.in);
                    String enteredCarPersonality = scanner1.nextLine();
                    System.out.println("Avtomobil tezligini Kiriting: ");
                    Scanner scanner2 = new Scanner(System.in);
                    int enteredCarSpeed = scanner2.nextInt();
                    if(enteredCarSpeed > 70 && enteredCarSpeed <= 90){
                        enteredCarFines = bhmPrices;
                    }
                    else if(enteredCarSpeed > 90 && enteredCarSpeed <= 110){
                        enteredCarFines = 5*bhmPrices;
                    }
                    else if(enteredCarSpeed > 110 && enteredCarSpeed <= 130){
                        enteredCarFines = 10*bhmPrices;
                    }
                    else if(enteredCarSpeed > 130){
                        enteredCarFines = 20*bhmPrices;
                    }
                    else if(enteredCarSpeed < 70){
                        System.out.println("Bu tezlikka Jarima yoq. Boshqa Car kiriting!!!");
                        addCarFines();
                    }


                    enteredCarInfo[numberOfCars][0] = enteredCarNumber;
                    enteredCarInfo[numberOfCars][1] = enteredCarPersonality;
                    enteredCarInfo[numberOfCars][2] = String.valueOf((int) enteredCarSpeed);
                    enteredCarInfo[numberOfCars][3] = String.valueOf((int) enteredCarFines);
                    numberOfCars++;



                    while (true){
                        System.out.println("Qoshishni davom ettirasizmi? [h/y]: ");
                        scanner1 = new Scanner(System.in);
                        String command = scanner1.nextLine();
                        if (command.equalsIgnoreCase("h")){
                            break;
                        }
                        else if (command.equalsIgnoreCase("y")){

                            System.out.println("CarsInfo:  " + Arrays.deepToString(enteredCarInfo));  //???????????

                            openAdminConsole();
                        }
                        else {
                            System.out.println("WRONG!!!" +
                                    "\nXato Buyruq Kiritdingiz!!!");
                        }
                    }
                }
                else {
                    System.out.println("Bu avtomobil oldin Kiritilgan!   TRY AGAIN!!!");
                }

            }
            else{
                System.err.println("WRONG!!!" +
                        "\nXato Buyruq Kiritdingiz!!!");
            }
        }
    }

    public static void listOfCars(){
        if(numberOfCars > 0){
            System.out.println("********** Avtomobillar royxati **********");
            System.out.println("==========================================");
            for (int i = 0; i < numberOfCars; i++) {

                    System.out.println("Avtomobil ID si:  " + (i+1) +
                            "\nAvtomobil Raqami:  " + enteredCarInfo[i][0] +
                            "\nAvtomobil Egasi:  " + enteredCarInfo[i][1]
                    );
                    if (!enteredCarInfo[i][3].equals("0")){
                        System.out.println("Avtomobil Tezligi:  " + enteredCarInfo[i][2] + " km/s");
                    }
                System.out.println("Avtomobil Jarimasi:  " + enteredCarInfo[i][3] + " som");
                    System.out.println("Jarimasi tolanganmi:  " + (isPaidFines[i] ? "Ha" : "Yoq"));

                if (!enteredCarInfo[i][3].equals("0")){
                    System.out.println();
                    System.out.println("      .---------.      ");
                    System.out.println("   ./             \\.   ");
                    System.out.println("   '_______________'    ");
                    System.out.println("   (_)--__) (__--(_)    ");
                    System.out.println("  (.. |" + enteredCarInfo[i][0] + "|  ..)   ");
                    System.out.println("   | |           | |    ");
                    System.out.println("   `-'           `-'    ");
                    System.out.println();
                    System.out.println("******************************************");
                }
                else {
                    System.out.println("******************************************");
                }
            }
            System.out.println("Avtomobillar soni:  " + numberOfCars);
            int count = 0;
            for (int i = 0; i < numberOfCars; i++) {
                if (enteredCarInfo[i][3].equals("0")){
                    count++;
                }
            }
            System.out.println("Jarimasini tolamay qochib yurganlar:  " + (numberOfCars-count));
        }

        else {
            System.err.println("Xali Avtomobil Kiritilmagan!");
        }
        openAdminConsole();
    }
}
