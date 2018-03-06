package view;

import controller.SecurityController;
import controller.WDController;
import exception.InvalidDataExcepetion;

import java.util.Scanner;

public class StudentHomeView extends UserHomeView{



    public StudentHomeView(WDController wdController, SecurityController securityController) {
        super(wdController,securityController);
    }

    public void viewStudentHome() throws InvalidDataExcepetion {
        Scanner in = new Scanner(System.in);
        boolean continueView;
        do {
            System.out.println("Naciśnij o, aby wyswietlic Oceny!");
            System.out.println("Naciśnij q, aby wyjść!");

            String inputChar;
            continueView = true;

            inputChar = in.nextLine();
            if (inputChar.equals("q")) {
                return;
            } else if (inputChar.equals("o")) {
                MarkCheckView markCheckView = new MarkCheckView(wdController,in);
                markCheckView.checkMark();

            }

        } while(continueView);

        return;

    }
}
