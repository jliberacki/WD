package view;

import exception.*;
import model.*;
import controller.SecurityController;

import java.io.BufferedReader;
import java.io.IOException;

import static java.lang.System.*;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.util.*;


public class WdHome {
    private SecurityController securityController;

    public WdHome(SecurityController securityController) {
        this.securityController = securityController;
    }

    public Boolean wdHomeView() throws  InvalidDataExcepetion, InvalidLoginOrPasswordException{
        Scanner in = new Scanner(System.in);

        System.out.println("Witaj w Wirtualnym Dziekanacie!");


        do {
            System.out.println("Naciśnij S, aby się zalogować jako student!");
            System.out.println("Naciśnij T, aby się zalogować jako nauczyciel!");
            System.out.println("Naciśnij A, aby się zalogować jako admin!");
            System.out.println("Naciśnij R, aby się zarejestrować (opcja dla studenta) !");
            System.out.println("Naciśnij Q, aby wyjść!");

            String inputChar;

            try {

                inputChar = in.nextLine();
                if (inputChar.equals("S") || inputChar.equals("s")) {
                    LogIn login = new LogIn(securityController, in);
                    login.loginStudent();

                }else if (inputChar.equals("T") || inputChar.equals("t")) {
                    LogIn login = new LogIn(securityController, in);
                    login.loginTeacher();

                }else if (inputChar.equals("A") || inputChar.equals("a")) {
                    LogIn login = new LogIn(securityController, in);
                    login.loginAdmin();

                } else if (inputChar.equals("R") || inputChar.equals("r")) {
                    Register register = new Register(securityController, in);
                    register.register();
                } else if (inputChar.equals("Q") || inputChar.equals("q")) {
                    return false;
                } else {
                    System.out.println("Wpisz odpowiedni znak!");
                }
            } catch (InvalidLoginOrPasswordException e) {
                System.out.println(e.getMessage());
            }

        } while(this.securityController.getUser() == null);

        Logged logged = new Logged(securityController, in);
        return logged.logged();
    }





}
