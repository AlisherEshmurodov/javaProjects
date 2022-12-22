package com.mini_OOP_Projects.pdp.bookShop_miniProject;

import com.mini_OOP_Projects.pdp.bookShop_miniProject.model.Book;
import com.mini_OOP_Projects.pdp.bookShop_miniProject.model.BoughtBooks;
import com.mini_OOP_Projects.pdp.bookShop_miniProject.model.SoldBooks;
import com.mini_OOP_Projects.pdp.bookShop_miniProject.model.UsersName;

import java.util.ArrayList;
import java.util.List;

public class Storage {


    public static String  adminLogin = "admin";
    public static String  adminParol = "1";

    public static String  userLogin = "user";
    public static String  userParol = "2";
    public static double totalCost = 0;
    public static List<Double> soldPrices = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();
    public static List<SoldBooks> soldBookss = new ArrayList<>();
    public static List<BoughtBooks> boughtBooks = new ArrayList<>();
    public static List<UsersName> usersNames = new ArrayList<>();
}
