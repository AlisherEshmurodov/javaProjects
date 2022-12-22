package com.mini_OOP_Projects.pdp.onlineKorzinka.service;

import com.mini_OOP_Projects.pdp.onlineKorzinka.model.User;

import java.util.Scanner;

public class AdminService {
    public static void openAdminConsole(User user){
        System.out.println("Xush kelibsiz " + user.getName());
        while (true){
            System.out.println("1-Magazin qoshish,  2-Mahsulot qoshish, 3-Magazinga mahsulot qoshish, 4-Savdolar tarixi, 0-Chiqish");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("1")){
                ShopService.addShop();
            }
            else if (command.equals("2")){
                ProductService.addProduct();
            }
            else if (command.equals("3")){
                ShopService.addProductsToShop();
            }
            else if (command.equals("4")){
                OrderService.showOrderHistory();
            }
            else if (command.equals("0")){
                break;
            }
            else {
                System.err.println("Xato buyrug!!!");
            }
        }
    }
}
