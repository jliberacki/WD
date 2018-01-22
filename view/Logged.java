package view;


import controller.SecurityController;
import exception.*;

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
        if (this.securityController.getUser().isItAdmin()) System.out.println("Jesteś administratorem!");
        boolean skip;
        do {
            System.out.println("Naciśnij C, aby zmienić hasło!");
            System.out.println("Naciśnij S, aby przejść dalej!");
            System.out.println("Naciśnij Q, aby wyjść!");


            String inputChar;
            //String nick;
            //String password;
            //String newPassword;
            //String oldPassword;
            skip = false;




            inputChar = in.nextLine();
            if (inputChar.equals("S") || inputChar.equals("s")) {
                skip = true;
            } else if (inputChar.equals("C") || inputChar.equals("c")) {
                ChangePassword change = new ChangePassword(securityController, in);
                change.changeYourPassword();
            } else if (inputChar.equals("Q") || inputChar.equals("q")) {
                return false;
            } else {
                System.out.println("Wpisz odpowiedni znak!");
            }



        } while(!skip);

        return true;
    }



}
