package com.copyProjects.pdp.onlineFastFood_evos.com.services.imples;

import com.copyProjects.pdp.onlineFastFood_evos.com.model.User;
import com.copyProjects.pdp.onlineFastFood_evos.com.services.interfacess.MainMenu;
import com.copyProjects.pdp.onlineFastFood_evos.com.services.interfacess.SignInSignUp;

import java.util.Scanner;

public class IMainMenu implements MainMenu {

    private static MainMenu mainMenu;

    public static MainMenu getInstance(){
        if (mainMenu == null){
            mainMenu = new IMainMenu();
        }
        return mainMenu;
    }

    @Override
    public void startMenu() {
        System.out.println("Welcome to Evos!");
        while (true) {
            System.out.println("1-Enter,  2-Sign Up,  0-Finish");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
//            SignInSignUp signInSignUp = new ISignInSignUp();
            SignInSignUp signInSignUp = ISignInSignUp.getInstance();
            if (command.equals("1")){
                User user = signInSignUp.signIn();
                if (user == null){
                    System.out.println("No registered");
                }
                else {
                    if (user.getPhoneNumber().equals("admin")){

                    }
//                    else if(admin chief usernamenini kiritgamdan ken wu username ga teng bolgandan ken chief kiradi)
                    else {
                        // openUserConsole
                    }
                    //admin or User console ga otw
                }
            }
            else if (command.equals("2")){
                signInSignUp.signUp();
            }
            else if(command.equals("3")){
                System.exit(0);
            }
            else {
                System.out.println("Wrong command!!  TRY AGAIN!!!");
            }
        }
    }
}
