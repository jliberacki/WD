package view;

import controller.*;
import exception.*;


import java.util.Scanner;


public class TeacherHomeView extends UserHomeView {

    public TeacherHomeView(WDController wdController, SecurityController securityController) {
        super(wdController,securityController);
    }

    public void viewTeacherHome() throws InvalidDataExcepetion, WrongValueException{
        Scanner in = new Scanner(System.in);
        boolean continueView;
        do {
            System.out.println("Naciśnij o, aby dodać Ocene!");
            System.out.println("Naciśnij q, aby wyjść!");

            String inputChar;
            continueView = true;

            inputChar = in.nextLine();
            if (inputChar.equals("q")) {
                return;
            } else if (inputChar.equals("o")) {
                MarkAddView markAddView = new MarkAddView(wdController,in);
                markAddView.addMark();

            }
            else {
                System.out.println("Podaj odpowiedni znak");
            }

        } while(continueView);

        return;

    }
}
