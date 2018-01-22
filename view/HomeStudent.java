package view;

import controller.SecurityController;
import controller.WDController;
import exception.InvalidDataExcepetion;

import java.util.Scanner;

public class HomeStudent {
    private WDController wdController;
    private SecurityController securityController;


    public HomeStudent(WDController wdController, SecurityController securityController) {
        this.wdController=wdController;
        this.securityController=securityController;
    }

    public Boolean homeStudentView() throws InvalidDataExcepetion {
        Scanner in = new Scanner(System.in);
        boolean continueView;
        do {
            System.out.println("Naciśnij O, aby wyswietlic Oceny!");
            System.out.println("Naciśnij Q, aby wyjść!");

            String inputChar;
            continueView = true;

            inputChar = in.nextLine();
            if (inputChar.equals("Q") || inputChar.equals("q")) {
                return false;
            } else if (inputChar.equals("O") || inputChar.equals("o")) {
                CheckMark checkMark = new CheckMark(wdController,in);
                checkMark.checkMark();

            }

        } while(continueView);

        return false;

    }
}
