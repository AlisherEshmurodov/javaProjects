package com.mini_OOP_Projects.pdp.coWorking_Booking.com.services.impls;

import com.mini_OOP_Projects.pdp.coWorking_Booking.com.Storage;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.model.CoWorkingManager;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.model.Room;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.model.User;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.services.interfaces.ManagerService;

import java.util.Scanner;

public class IManagerService implements ManagerService {

    private static ManagerService managerService;

    public static ManagerService getInstance(){
        if (managerService == null){
            managerService = new IManagerService();
        }
        return managerService;
    }


    @Override
    public void openManagerConsole(User currentManager) {
        while (true) {
            System.out.println("1 -> Show My Co-Workings,  2 -> Add Room,  3 ->      ,  0 -> Exit");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            System.out.println(currentManager);
            if (command.equals("1")) {
                showMyCoWorkings(currentManager);
            }
            else if (command.equals("2")) {
                addRoom(currentManager);
            }
            else if (command.equals("3")) {
                //show
            }
            else if (command.equals("0")) {
                break;
            }
            else {
                System.out.println("Wrong Command!");
            }
        }
    }

    @Override
    public void showMyCoWorkings(User currentManager) {
        System.out.println("********  Co-Working List  ********");
        Storage.coWorkingManagers.forEach(System.out::println);
        System.out.println("****************");
        Storage.coWorkings.forEach(System.out::println);
        System.out.println("****************");
        for (int i = 0; i < Storage.users.size(); i++) {
            if (Storage.users.get(i).getId() == currentManager.getId()){
                for (int j = 0; j < Storage.coWorkingManagers.size(); j++) {
                    if (Storage.coWorkingManagers.get(j).getUser().getId() == currentManager.getId()) {
                        System.out.println("Co-Working ID: " + Storage.coWorkingManagers.get(j).getCoWorking().getId());
                        System.out.println("Co-Working Name: " + Storage.coWorkingManagers.get(j).getCoWorking().getName());
                        System.out.println("Co-Working Address: " + Storage.coWorkingManagers.get(j).getCoWorking().getAddress());
                        System.out.println("------------------------------------");
                    }
                }
            }
        }
    }

    @Override
    public void addRoom(User currentManager) {
        while (true) {
            System.out.println("Do you want to Add Room");
            System.out.println("1 -> Yes,  0 -> Back");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("1")) {
                for (int i = 0; i < Storage.users.size(); i++) {
                    if (Storage.users.get(i).getId() == currentManager.getId()) {
                        for (int j = 0; j < Storage.coWorkingManagers.size(); j++) {
                            if (Storage.coWorkingManagers.get(j).getUser().getId() == currentManager.getId()) {
                                System.out.println("Co-Working ID: " + Storage.coWorkingManagers.get(j).getCoWorking().getId());
                                System.out.println("Co-Working Name: " + Storage.coWorkingManagers.get(j).getCoWorking().getName());
                                System.out.println("Co-Working Address: " + Storage.coWorkingManagers.get(j).getCoWorking().getAddress());
                                System.out.println("------------------------------------");
                            }
                        }
                    }
                }
                System.out.println("*******************");
                System.out.print("Select Co-Working ID for Add Room:  ");
                scanner = new Scanner(System.in);
                int selectedCoWorkingId = scanner.nextInt();
                CoWorkingManager checkCoWorkingManager = Storage.coWorkingManagers.stream()
                        .filter(u -> u.getId() == selectedCoWorkingId)
                        .findFirst()
                        .orElse(null);
                if (checkCoWorkingManager != null){
//                    CoWorkingManager takeCoWorking = Storage.coWorkingManagers.stream()
//                                    .filter(u -> u.getId() == selectedCoWorkingId)
//                                            .filter(v -> v.)
                    System.out.print("Enter Room Name:  ");
                    scanner = new Scanner(System.in);
                    String enteredRoomName = scanner.nextLine();
                    System.out.print("Enter Floor Number:  ");
                    scanner = new Scanner(System.in);
                    int enteredFloorNumber = scanner.nextInt();
                    System.out.print("Enter Floor Number:  ");
                    scanner = new Scanner(System.in);
                    int enteredNumbersOfPlaces = scanner.nextInt();


                    Room room = new Room(Room.getCurrentId(), enteredRoomName, Storage.coWorkingManagers.);
                }
                else {
                    System.out.println("Wrong Co-Working ID!");
                }

            }
            else if(command.equals("0")){
                openManagerConsole(currentManager);
            }
            else {
                System.out.println("Wrong Command");
            }
        }
    }
}
