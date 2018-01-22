package view;

import controller.*;
import exception.*;
import model.*;

import java.util.LinkedList;
import java.util.Scanner;

public class HomeAdmin {

    private WDController wdController;
    private SecurityController securityController;


    public HomeAdmin(WDController wdController, SecurityController securityController) {
        this.wdController=wdController;
        this.securityController=securityController;
    }

    public Boolean homeAdminView() throws InvalidDataExcepetion {
        Scanner in = new Scanner(System.in);
        boolean continueView;
        do {
            System.out.println("Naciśnij P, aby dodać przedmiot!");
            System.out.println("Naciśnij T, aby dodać nauczyciela!");
            System.out.println("Naciśnij D, aby usunac przedmiot!");
            System.out.println("Naciśnij Q, aby wyjść!");

            String inputChar;
            continueView = true;

            try {

                inputChar = in.nextLine();
                if (inputChar.equals("Q") || inputChar.equals("q")) {
                    return false;
                } else if (inputChar.equals("P") || inputChar.equals("p")) {
                    AddSubject addSubject = new AddSubject(wdController,in);
                    addSubject.addSubject();

                }else if (inputChar.equals("T") || inputChar.equals("t")){
                    RegisterNewTeacher registerNewTeacher = new RegisterNewTeacher(securityController, in);
                    registerNewTeacher.registerNewTeacher();
                } else if (inputChar.equals("D") || inputChar.equals("d")) {
                    DeleteSubjectView deleteSubjectView = new DeleteSubjectView(wdController, in);
                    if (!deleteSubjectView.deleteSubjectView()) return false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Wpisz odpowiedni znak!");
            }

        } while(continueView);

        return false;

    }

}
