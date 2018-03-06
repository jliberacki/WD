package view;

import controller.SecurityController;

import java.util.Scanner;

public class NewTeacherRegisterView {
    private SecurityController securityController;
    private Scanner in;

    public NewTeacherRegisterView(SecurityController securityController, Scanner in) {
        this.securityController = securityController;
        this.in = in;
    }

    public void registerNewTeacher() {
        String nick;
        String password;
        String firstname;
        String lastname;
        System.out.println("Wpisz nick!");
        nick = in.nextLine();
        System.out.println("Wpisz hasło!");
        password = in.nextLine();
        System.out.println("Wpisz Imie!");
        firstname = in.nextLine();
        System.out.println("Wpisz Nazwisko!");
        lastname = in.nextLine();
        if (this.securityController.registerTeacher(nick, password,firstname,lastname)) {
            System.out.println("Zarejestrowano!");
        } else {
            System.out.println("Nick zajęty!");
        }
    }
}
