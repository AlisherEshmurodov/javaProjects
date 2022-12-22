package com.mini_OOP_Projects.pdp.bookShop_miniProject.model;

import com.mini_OOP_Projects.pdp.bookShop_miniProject.Storage;

public class BookList {
    public  static void bookList(){
        if (Storage.books.size()>0){
            System.out.println("*********  Book List  *********");
            for (int i = 0; i < Storage.books.size(); i++) {
                System.out.print("Book ID: " + (i+1));
                System.out.print("  |  Book name: " + Storage.books.get(i).getName());
                System.out.println("  |   Author: " + Storage.books.get(i).getAuthor());
                System.out.print("Price: " + Storage.books.get(i).getPrice());
                System.out.println("  |   Quantity: " + Storage.books.get(i).getQuantity());
                System.out.println("*****************************");
            }

//            for (int i = 0; i < Storage.books.size(); i++) {
//                System.out.println("*********  ID: " + (i+1) + "  *********");
//                System.out.print("Price: " + Storage.books.get(i).price());
//                System.out.println("  |   Quantity: " + Storage.books.get(i).quantity());
//                System.out.println();
//                System.out.println("      ,————————————————,-,     ");
//                System.out.println("      |                |  \\   ");
//                System.out.println("      | " + Storage.books.get(i).name()                        );
//                System.out.println("      |                |  |    ");
//                System.out.println("      |                |  |    ");
//                System.out.println("      |                |  |    ");
//                System.out.println("      |                |  |    ");
//                System.out.println("      | " + Storage.books.get(i).author()                        );
//                System.out.println("      \\————————————————\\  |      ");
//                System.out.println("       \\________________`,|      ");
//                System.out.println("                                  ");
//            }


        }
        else {
            System.err.println("No Book!  Please, add books");
        }
    }
}
