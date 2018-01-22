package view;

import controller.SecurityController;
import exception.*;
import model.*;

import java.util.Scanner;

public class LogIn {
    private SecurityController securityController;
    private Scanner in;

    public LogIn(SecurityController securityController, Scanner in) {
        this.securityController = securityController;
        this.in = in;
    }

    public void loginStudent() throws InvalidDataExcepetion,InvalidLoginOrPasswordException {
        String nick;
        String password;
        System.out.println("Wpisz nick!");
        nick = in.nextLine();
        System.out.println("Wpisz hasło!");
        password = in.nextLine();
        this.securityController.logInAsStudent(nick, password);
    }

    public void loginTeacher() throws InvalidDataExcepetion,InvalidLoginOrPasswordException {
        String nick;
        String password;
        System.out.println("Wpisz nick!");
        nick = in.nextLine();
        System.out.println("Wpisz hasło!");
        password = in.nextLine();
        this.securityController.logInAsTeacher(nick, password);
    }

    public void loginAdmin() throws InvalidDataExcepetion,InvalidLoginOrPasswordException {
        String nick;
        String password;
        System.out.println("Wpisz nick!");
        nick = in.nextLine();
        System.out.println("Wpisz hasło!");
        password = in.nextLine();
        this.securityController.logInAsAdmin(nick, password);
    }
}
