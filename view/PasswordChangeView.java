package view;

import controller.SecurityController;
import exception.*;

import java.util.Scanner;

public class PasswordChangeView {
    private SecurityController securityController;
    private Scanner in;

    public PasswordChangeView(SecurityController securityController, Scanner in) {
        this.securityController = securityController;
        this.in = in;
    }

    public void changeYourPassword() {
        String oldPassword;
        String newPassword;
        System.out.println("Wpisz stare hasło!");
        oldPassword = in.nextLine();
        System.out.println("Wpisz nowe hasło!");
        newPassword = in.nextLine();
        if (this.securityController.getUser().changePassword(oldPassword, newPassword)) {
            System.out.println("Hasło zmienione!");
        } else {
            System.out.println("Złe stare hasło!");
        }
    }

}
