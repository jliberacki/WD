package view;

import controller.*;
import exception.*;


import java.util.LinkedList;
import java.util.Scanner;


public class HomeTeacher {
    private WDController wdController;
    private SecurityController securityController;


    public HomeTeacher(WDController wdController, SecurityController securityController) {
        this.wdController=wdController;
        this.securityController=securityController;
    }

    public Boolean homeTeacherView() throws InvalidDataExcepetion{
        Scanner in = new Scanner(System.in);
        boolean continueView;
        do {
            System.out.println("Naciśnij O, aby dodać Ocene!");
            System.out.println("Naciśnij Q, aby wyjść!");

            String inputChar;
            continueView = true;

            inputChar = in.nextLine();
            if (inputChar.equals("Q") || inputChar.equals("q")) {
                return false;
            } else if (inputChar.equals("O") || inputChar.equals("o")) {
                AddMark addMark = new AddMark(wdController,in);
                addMark.addMark();

            }
            else {
                System.out.println("Podaj odpowiedni znak");
            }

        } while(continueView);

        return false;

    }
}
