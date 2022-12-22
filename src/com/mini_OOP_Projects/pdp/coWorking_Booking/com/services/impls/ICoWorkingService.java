package com.mini_OOP_Projects.pdp.coWorking_Booking.com.services.impls;

import com.mini_OOP_Projects.pdp.coWorking_Booking.com.Storage;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.model.CoWorking;
import com.mini_OOP_Projects.pdp.coWorking_Booking.com.services.interfaces.CoWorkingService;

import java.util.Scanner;

public class ICoWorkingService implements CoWorkingService {

    private static CoWorkingService coWorking;

    public static CoWorkingService getInstance(){
        if (coWorking == null){
            coWorking = new ICoWorkingService();
        }
        return coWorking;
    }

    @Override
    public void addCoWorking() {
        while (true) {
            System.out.println("Do you want to Add Co-Working");
            System.out.println("1 -> Yes,  0 -> Back");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("1")){
                System.out.print("Enter Co-Working name:  ");
                scanner = new Scanner(System.in);
                String enteredCoWorking = scanner.nextLine();

                CoWorking checkCoWorking = Storage.coWorkings.stream()
                        .filter(c -> c.getName().equals(enteredCoWorking))
                        .findFirst().orElse(null);
                if (checkCoWorking == null){
                    System.out.print("Enter Co-Working address:  ");
                    scanner = new Scanner(System.in);
                    String enteredAddress = scanner.nextLine();
                    CoWorking coWorking = new CoWorking(CoWorking.getCurrentId(), enteredCoWorking, enteredAddress);
                    Storage.coWorkings.add(coWorking);
                    System.out.println("Successfully added");
                }
                else {
                    System.out.println("This Co-Working already registered!");
                }
            }
            else if (command.equals("0")){
                for (int i = 0; i < Storage.coWorkings.size(); i++) {
                    System.out.println(Storage.coWorkings.get(i) + "  ");
                }
                break;
            }
            else {
                System.out.println("Wrong Command!!!");
            }
        }
    }
}
