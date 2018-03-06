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


public class HomeView {
    private SecurityController securityController;

    public HomeView(SecurityController securityController) {
        this.securityController = securityController;
    }

    public boolean viewHome() throws  InvalidDataExcepetion, InvalidLoginOrPasswordException{
        Scanner in = new Scanner(System.in);

        System.out.println("Witaj w Wirtualnym Dziekanacie!");


        do {
            System.out.println("Naciśnij s, aby się zalogować jako student!");
            System.out.println("Naciśnij t, aby się zalogować jako nauczyciel!");
            System.out.println("Naciśnij a, aby się zalogować jako admin!");
            System.out.println("Naciśnij r, aby się zarejestrować (opcja dla studenta) !");
            System.out.println("Naciśnij q, aby wyjść!");

            String inputChar;

            try {

                LogIn login=null;
                inputChar = in.nextLine();
                switch(inputChar) {
                    case "s":
                        login = new LogIn(securityController, in);
                        login.loginStudent();
                        break;

                    case "t":
                        login = new LogIn(securityController, in);
                        login.loginTeacher();
                        break;

                    case "a":
                        login = new LogIn(securityController, in);
                        login.loginAdmin();
                        break;

                    case "r":
                        Register register = new Register(securityController, in);
                        register.register();
                        break;

                    case "q":
                        return false;
                    default:
                        System.out.println("Wpisz odpowiedni znak!");
                        break;
                }
            } catch (InvalidLoginOrPasswordException e) {
                System.out.println(e.getMessage());
            }

        } while(this.securityController.getUser() == null);

        Logged logged = new Logged(securityController, in);
        return logged.logged();
    }





}
