package com.mini_OOP_Projects.pdp.bookShop_miniProject.services;

import com.mini_OOP_Projects.pdp.bookShop_miniProject.Storage;
import com.mini_OOP_Projects.pdp.bookShop_miniProject.model.Book;
import com.mini_OOP_Projects.pdp.bookShop_miniProject.model.BookList;

import java.util.Scanner;

public class AdminService {
    public static void adminConsole(){
        while (true) {
            System.out.println("1-Add Book,  2-Book List, 3-Sold Book List,  0-Exit");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("1")){
                addBook();
            }
            else if(command.equals("2")){
                BookList.bookList();
            }
            else if(command.equals("3")){


            }
            else if(command.equals("0")){
                MainMenu.mainMenu();
            }
            else {
                System.err.println("Wrong command!  TRY AGAIN!!!");
            }

        }
    }

    public static void addBook(){
        System.out.print("Enter Book Name:  ");
        Scanner scanner = new Scanner(System.in);
        String kiritilganBookName = scanner.nextLine();
        System.out.print("Enter Book Author:  ");
        Scanner scanner1 = new Scanner(System.in);
        String kiritilganBookAuthor = scanner1.nextLine();
        System.out.print("Enter Book Price:  ");
        Scanner scanner2 = new Scanner(System.in);
        double kiritilganBookPrice = scanner2.nextDouble();
        System.out.print("Enter Book Quantity:  ");
        Scanner scanner3 = new Scanner(System.in);
        int kiritilganBookQuantity = scanner3.nextInt();
        Book interedBooks = new Book(kiritilganBookName, kiritilganBookAuthor, kiritilganBookQuantity, kiritilganBookPrice);
        Storage.books.add(interedBooks);
        while (true){
            System.out.println("Do You Want Continue? [y/n]");
            scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("y")){
                addBook();
            }
            else if(command.equalsIgnoreCase("n")){
                System.out.println(Storage.books);
                adminConsole();
            }
        }
    }
}
