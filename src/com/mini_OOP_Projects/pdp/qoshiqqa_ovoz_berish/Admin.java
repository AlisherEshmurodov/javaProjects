package com.mini_OOP_Projects.pdp.qoshiqqa_ovoz_berish;

import java.util.Scanner;

public class Admin {
    String adminLogin = "admin";
    String adminParol = "1";


    @Override
    public String toString() {
        return "Admin{" +
                "adminLogin='" + adminLogin + '\'' +
                ", adminParol='" + adminParol + '\'' +
                '}';
    }

    public static void adminConsole() {
        while (true) {
            System.out.println("1-Add songs,  2-Songs list,  3-Back");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("1")) {
                addSongs();
            } else if (command.equals("2")) {
                songLists();
            } else if (command.equals("3")) {
                Main.mainMenu();
            } else {
                System.out.println("Xato buyruq!!!");
            }
        }
    }


    public static void addSongs() {

            System.out.print("Enter name of Singer: ");
            Scanner scanner = new Scanner(System.in);
            String kiritilganQoshiqchi = scanner.nextLine();
            DataCache.singerNumber++;
        while (true) {
            System.out.println("Enter name of Songs:  ");
            scanner = new Scanner(System.in);
            String kiritilganQoshiq = scanner.nextLine();

            DataCache.songs[DataCache.songsNumber] = new Songs(DataCache.songsNumber+1, kiritilganQoshiq);
            DataCache.singers[DataCache.singerNumber] = new Singer(new Songs[]{DataCache.songs[DataCache.songsNumber]},DataCache.singerNumber+1, kiritilganQoshiqchi);
            DataCache.songsNumber++;

            while (true){
                System.out.print("Continue? [y/n]: ");
                Scanner scanner1 = new Scanner(System.in);
                String command = scanner1.nextLine();
                if (command.equals("y") || command.equals("Y")){
                    break;
                }
                else if (command.equals("n") || command.equals("N")){
                    for (Singer singer : DataCache.singers) {
                        if (singer != null){
                            for (Songs song : DataCache.songs) {
                                if (song != null){
                                    System.out.println(singer);
                                }
                            }
                            System.out.println("************");
                        }
                    }
                    adminConsole();
                }
            }
        }
    }


    public static void songLists(){
        if (DataCache.songsNumber > 0){
            System.out.println("*********  Songs lists  ***********");
            for (Singer singer : DataCache.singers) {
                if (singer != null){
                    System.out.println("Singers ID: " + singer.getSingerId());
                    System.out.println("Singers Name:  " + singer.getSingerName());
                    System.out.println("Song Name: " + singer.getSongs());


                }
            }
        }
        else {
            System.out.println("Xali qoshiqlar yoq!");
            adminConsole();
        }
    }


    //********************************************************//********************************************************
    //********************************************************//********************************************************
    //********************************************************//********************************************************


    public String getAdminLogin () {
            return adminLogin;
        }

        public void setAdminLogin (String adminLogin){
            this.adminLogin = adminLogin;
        }

        public String getAdminParol () {
            return adminParol;
        }

        public void setAdminParol (String adminParol){
            this.adminParol = adminParol;
        }
    }

