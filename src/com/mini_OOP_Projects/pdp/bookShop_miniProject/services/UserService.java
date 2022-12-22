package com.mini_OOP_Projects.pdp.bookShop_miniProject.services;

import com.mini_OOP_Projects.pdp.bookShop_miniProject.Storage;
import com.mini_OOP_Projects.pdp.bookShop_miniProject.model.Book;
import com.mini_OOP_Projects.pdp.bookShop_miniProject.model.BoughtBooks;
import com.mini_OOP_Projects.pdp.bookShop_miniProject.model.SoldBooks;
import com.mini_OOP_Projects.pdp.onlineKorzinka.model.User;


import java.util.Scanner;
import java.util.function.Predicate;

public class UserService {
    public static User currentUser;
    public static double currentPrice = 0;
    public static void userConsole(){
        String oxirgiUserIsmi = String.valueOf(Storage.usersNames.get(Storage.usersNames.size()-1).name());
        System.out.println("Welcome  " + oxirgiUserIsmi.toUpperCase());
        System.out.println("1-Buy Books,  2-Bought book List,  0-Exit");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        if (command.equals("1")){
            buyBook();
        }
        else if(command.equals("2")){
            showBoughtBooks();
        }
        else if(command.equals("0")){
            MainMenu.mainMenu();
        }
        else {
            System.out.println("Wrong command!  TRY AGAIN!!!");
        }
    }


    public static void buyBook(){
        if (Storage.books.size()>0) {
            while (true) {
                System.out.println("***********  Book Menu  ***********");
                for (int i = 0; i < Storage.books.size(); i++) {
                    System.out.print("Book ID: " + (i + 1));
                    System.out.print("   |   Book Name: " + Storage.books.get(i).getName().toUpperCase());
                    System.out.println("   |   Author: " + Storage.books.get(i).getAuthor());
                    System.out.print("Price: " + Storage.books.get(i).getPrice() + " som");
                    System.out.println("   |   Quantity: " + Storage.books.get(i).getQuantity() + " ta");
                    System.out.println("****************************");
                }

                System.out.println("Exit  ->  -1");
                System.out.print("Choose ID of Book: ");
                Scanner scanner = new Scanner(System.in);
                int kiritilganBookId = scanner.nextInt();
                if (kiritilganBookId == -1){
                    userConsole();
                }
                String tanlanganKitob = Storage.books.get(kiritilganBookId - 1).getName();
                if (isExist(tanlanganKitob)) {
                    System.out.print("Enter quantity: ");
                    scanner = new Scanner(System.in);
                    int tanlanganQuantity = scanner.nextInt();
                    if (kitobSoniYetadimi(kiritilganBookId, tanlanganQuantity)) {
                        SoldBooks soldBooks = new SoldBooks(Storage.books.get(kiritilganBookId-1).getName(), Storage.books.get(kiritilganBookId-1).getAuthor(),
                                Storage.books.get(kiritilganBookId-1).getQuantity(),Storage.books.get(kiritilganBookId-1).getPrice());
                        Storage.soldBookss.add(soldBooks);
                        Storage.books.get(kiritilganBookId-1).setQuantity(Storage.books.get(kiritilganBookId-1).getQuantity() - tanlanganQuantity);
                        System.out.print("Book ID: " + kiritilganBookId);
                        System.out.print("   |   Book Name: " + Storage.books.get(kiritilganBookId - 1).getName().toUpperCase());
                        System.out.println("   |   Author: " + Storage.books.get(kiritilganBookId - 1).getAuthor());
                        System.out.print("Price: " + Storage.books.get(kiritilganBookId - 1).getPrice());
                        System.out.println("   |   Quantity: " + tanlanganQuantity);
                        currentPrice = tanlanganQuantity * Storage.books.get(kiritilganBookId-1).getPrice();
                        Storage.soldPrices.add(currentPrice);
                        BoughtBooks boughtBookes = new BoughtBooks(kiritilganBookId, Storage.books.get(kiritilganBookId-1).getName(),
                                Storage.books.get(kiritilganBookId-1).getAuthor(), tanlanganQuantity, currentPrice);
                        Storage.boughtBooks.add(boughtBookes);
                        System.out.print("Current Price: " + currentPrice);
                        Storage.totalCost += currentPrice;
                        System.out.println("   |   Total Price: " + Storage.totalCost);
                        while (true){
                            System.out.println("Do You Want Continue? [y/n]");
                            scanner = new Scanner(System.in);
                            String command = scanner.nextLine();
                            if (command.equalsIgnoreCase("y")){
                                buyBook();
                            }
                            else if(command.equalsIgnoreCase("n")){
                                System.out.println(Storage.books);
                                userConsole();
                            }
                        }
                    }
                    else {
                        System.out.println("Sorry, We have no such amount books!");
                    }
                }
                else {
                    System.out.println("Wrong Choice ID!  TRY AGAIN!!!");
                }

            }
        }
        else {
            System.out.println("Sorry! There are no books at the moment.  " +
                    "\nTry later :) ");
            userConsole();
        }

    }

    public static boolean isExist(String  tanlanganKitob){
        Predicate<Book> kitobBormi = kitob -> kitob.getName().equals(tanlanganKitob);
        Book book = Storage.books.stream().filter(kitobBormi).findFirst().orElse(null);
        System.out.println(book);
        return book!= null;
    }

    public static boolean kitobSoniYetadimi(int kiritilganBookId, int tanlanganQuantity){
        if (Storage.books.get(kiritilganBookId-1).getQuantity() >= tanlanganQuantity){
            return true;
        }
        else {
            return false;
        }
    }


    // ********************************************************************************

    public static void showBoughtBooks(){
        if (Storage.boughtBooks.size() > 0) {
            System.out.println("***********  Bought Book Menu  ***********");
            for (int i = 0; i < Storage.books.size(); i++) {
                System.out.print("Book ID: " + (Storage.boughtBooks.get(i).bookdId()));
                System.out.print("   |   Book Name: " + Storage.boughtBooks.get(i).name().toUpperCase());
                System.out.println("   |   Author: " + Storage.boughtBooks.get(i).author());
                System.out.print("Price: " + Storage.boughtBooks.get(i).price() + " som");
                System.out.println("   |   Quantity: " + Storage.boughtBooks.get(i).quantity() + " ta");
                System.out.println("****************************");
            }
            System.out.println("Total Cost:  " + Storage.totalCost);
        }
        else {
            System.out.println("Sorry! You did not buy any books!!! ");
            userConsole();
        }

    }

}
