package view;

import controller.SecurityController;
import exception.*;

import java.util.Scanner;

public class Register {
    private SecurityController securityController;
    private Scanner in;

    public Register(SecurityController securityController, Scanner in) {
        this.securityController = securityController;
        this.in = in;
    }

    public void register() throws InvalidLoginOrPasswordException, InvalidDataExcepetion {
        String nick;
        String password;
        String firstname;
        String lastname;
        String id;
        System.out.println("Wpisz nick!");
        nick = in.nextLine();
        System.out.println("Wpisz hasło!");
        password = in.nextLine();
        System.out.println("Podaj Imie!");
        firstname= in.nextLine();
        System.out.println("Podaj Nazwisko!");
        lastname = in.nextLine();
        System.out.println("Podaj numer Indeksu!");
        id = in.nextLine();
        if (this.securityController.registerAsStudent(nick, password,firstname, lastname, id)) {
            this.securityController.logInAsStudent(nick, password);
        } else {
            System.out.println("Nick zajęty!");
        }
    }
}

