package view;


import controller.SecurityController;

import java.util.Scanner;


public class Logged {
    private SecurityController securityController;
    private Scanner in;

    public Logged(SecurityController securityController, Scanner in) {
        this.securityController = securityController;
        this.in = in;
    }

    public boolean logged(){
        System.out.println("Zalogowano!");
        boolean skip;
        do {
            System.out.println("Naciśnij c, aby zmienić hasło!");
            System.out.println("Naciśnij s, aby przejść dalej!");
            System.out.println("Naciśnij q, aby wyjść!");


            String inputChar;
            skip = false;




            inputChar = in.nextLine();
            switch (inputChar) {
                case "s":
                    skip = true;
                    break;
                case "c":
                    PasswordChangeView change = new PasswordChangeView(securityController, in);
                    change.changeYourPassword();
                    break;
                case "q":
                    return false;
                default:
                    System.out.println("Wpisz odpowiedni znak!");
                    break;
            }



        } while(!skip);

        return true;
    }



}
