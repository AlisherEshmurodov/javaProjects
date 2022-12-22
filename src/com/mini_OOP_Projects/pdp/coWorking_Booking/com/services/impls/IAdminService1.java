package com.mini_OOP_Projects.pdp.coWorking_Booking.com.services.impls;

import com.mini_OOP_Projects.pdp.coWorking_Booking.com.Storage;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.model.CoWorking;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.model.CoWorkingManager;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.model.Role;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.model.User;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.services.interfaces.AdminService;

import java.util.Scanner;

public class IAdminService1 implements AdminService {

    private static AdminService adminService;

    public static AdminService getInstance(){
        if (adminService == null){
            adminService = new IAdminService1();
        }
        return adminService;
    }

    @Override
    public void openAdminConsole() {
            System.out.println("1 -> Add new Co-Working centre");
            System.out.println("2 -> Add new Manager");
            System.out.println("3 -> Add Manager to Co-Working centre");
            System.out.println("0 -> Exit");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("1")) {
                ICoWorkingService.getInstance().addCoWorking();
            }
            else if (command.equals("2")) {
                addManager();
            }
            else if (command.equals("3")) {
                addManagerToCoWorking();
            }
            else if (command.equals("0")) {
                IMainMenu.getInstance().startMenu();
            }
            else {
                System.out.println("Wrong Command!!!");
                openAdminConsole();
            }
    }


    @Override
    public void addManager() {
        while (true) {
            System.out.println("Do you want to Add Manager");
            System.out.println("1 -> Yes,  0 -> Back");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("1")) {
                System.out.print("Enter Manager Login:  ");
                scanner = new Scanner(System.in);
                String enteredLogin = scanner.nextLine();

                User user = Storage.users.stream()
                        .filter(u -> u.getLogin().equals(enteredLogin))
                        .findFirst().orElse(null);

                if (user == null) {
                    System.out.print("Enter Manager Password:  ");
                    scanner = new Scanner(System.in);
                    String enteredPassword = scanner.nextLine();
                    System.out.print("Enter Manager Name:  ");
                    scanner = new Scanner(System.in);
                    String enteredName = scanner.nextLine();
                    User user1 = new User(User.getCurrentId(), enteredName, enteredLogin, enteredPassword, Role.MANAGER, 0);
                    Storage.users.add(user1);
                } else {
                    System.out.println("This Login already registered");
                }
            }
            else if (command.equals("0")) {
                openAdminConsole();
            }
            else {
                System.out.println("Wrong Command!!!");
            }
        }
    }


    @Override
    public void addManagerToCoWorking() {
            System.out.println("Do you want Add Manager to Co-Working");
            System.out.println("1 -> Yes,  0 -> Back");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("1")) {

                System.out.println("*****************");
                for (User user : Storage.users) {
                    if(user.getRole().equals(Role.MANAGER)){
                        System.out.println(user);
                    }
                }
                System.out.println("*****************");
                System.out.print("Choose Manager ID:  ");
                scanner = new Scanner(System.in);
                int selectedManagerId = scanner.nextInt();

                int checkId = Storage.users.get(selectedManagerId-1).getId();

                User user1 = Storage.users.stream()
                        .filter(m -> m.getId() == selectedManagerId)
                        .findFirst().orElse(null);
                if (user1 != null) {
                    System.out.println("Right Manager Id :)");
                    for (int i = 0; i < Storage.coWorkings.size(); i++) {
                        System.out.println(Storage.coWorkings.get(i) + " ");
                    }
                    System.out.println("*****************");
                    System.out.print("Choose Co-Working ID:  ");
                    scanner = new Scanner(System.in);
                    int selectedCoWorkingId = scanner.nextInt();
                    Storage.coWorkingManagers.forEach(System.out::println);


                    System.out.println("coWorkingManagers size = " + Storage.coWorkingManagers.size());

                    for (int i = 0; i < Storage.coWorkingManagers.size(); i++) {
                        if (Storage.coWorkingManagers.get(i).getUser().getId() == checkId) {
                            if (Storage.coWorkingManagers.get(i).getCoWorking().getId() == selectedCoWorkingId) {
                                System.out.println("Bu Manager Bu co working ga registered qilingan!");
                                addManagerToCoWorking();
                            }
                        }
                    }


                    CoWorking coWorking = Storage.coWorkings.stream()
                            .filter(c -> c.getId() == selectedCoWorkingId)
                            .findFirst().orElse(null);
                    if (coWorking != null) {
                        CoWorkingManager coWorkingManager1 = new CoWorkingManager(CoWorkingManager.getCurrentId(), coWorking, user1);
                        Storage.coWorkingManagers.add(coWorkingManager1);
                        for (int i = 0; i < Storage.coWorkingManagers.size(); i++) {
                            System.out.println(Storage.coWorkingManagers.get(i) + "  ");
                        }
                        System.out.println("Manager Added to Co-working Successfully!");
                        openAdminConsole();
                    }
                    else {
                        System.out.println("Wrong Co-Working ID!!!");
                    }
                }
                else {
                    System.out.println("Wrong Manager ID!!!");
                }
            }

            else if (command.equals("0")) {
                openAdminConsole();
            }
            else {
                System.out.println("Wrong Command!!!");
            }
        }
}
