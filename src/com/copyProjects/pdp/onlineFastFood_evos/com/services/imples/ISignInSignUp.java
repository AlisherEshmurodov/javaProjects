package com.copyProjects.pdp.onlineFastFood_evos.com.services.imples;

import com.copyProjects.pdp.onlineFastFood_evos.com.Storage;
import com.copyProjects.pdp.onlineFastFood_evos.com.model.Role;
import com.copyProjects.pdp.onlineFastFood_evos.com.model.User;
import com.copyProjects.pdp.onlineFastFood_evos.com.services.interfacess.SignInSignUp;

import java.util.List;
import java.util.Scanner;

public class ISignInSignUp implements SignInSignUp {

    private static SignInSignUp signInSignUp;

    public static SignInSignUp getInstance(){
        if (signInSignUp==null){
            signInSignUp = new ISignInSignUp();
        }
        return signInSignUp;
    }


    @Override
    public User signIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your phone Number:  ");
        String enteredPhoneNumber = scanner.nextLine();
        return Storage.users.stream()
                .filter(user -> user.getPhoneNumber().equals(enteredPhoneNumber))
                .findFirst().orElse(null);
    }

    @Override
    public void signUp() {
        System.out.print("Enter your phone number:  ");
        Scanner scanner = new Scanner(System.in);
        String enteredPhoneNumber = scanner.nextLine();
        User user = new User();
        if(!isExist(Storage.users, enteredPhoneNumber)){
            System.out.print("Enter your name:  ");
            scanner = new Scanner(System.in);
            String enteredName = scanner.nextLine();
            user.setPhoneNumber(enteredPhoneNumber);
            user.setName(enteredName);
            user.setId(User.getCurrentId());
            user.setRole(Role.USER);
            Storage.users.add(user);
            System.out.println("You have successfully registered :) ");
            IMainMenu.getInstance().startMenu();

        }
        else {
            System.out.println("This phone Already registered!");
            IMainMenu.getInstance().startMenu();
        }
    }

    private boolean isExist(List<User> listUsers, String enteredPhoneNumber) {
        User checkUser = listUsers.stream()
                .filter(user -> user.getPhoneNumber().equals(enteredPhoneNumber))
                .findFirst().orElse(null);
        return checkUser!=null;
    }

}
