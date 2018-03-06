package view;

import controller.*;
import exception.*;

import java.util.Scanner;

public class AdminHomeView extends UserHomeView {


    public AdminHomeView(WDController wdController, SecurityController securityController) {
        super(wdController,securityController);
    }

    public void viewAdminHome() throws InvalidDataExcepetion {
        Scanner in = new Scanner(System.in);
        boolean continueView;
        do {
            System.out.println("Naciśnij p, aby dodać przedmiot!");
            System.out.println("Naciśnij t, aby dodać nauczyciela!");
            System.out.println("Naciśnij d, aby usunac przedmiot!");
            System.out.println("Naciśnij q, aby wyjść!");

            String inputChar;
            continueView = true;

            try {

                inputChar = in.nextLine();
                switch (inputChar) {
                    case "q":
                        return;
                    case "p":
                        SubjectAddView subjectAddView = new SubjectAddView(wdController, in);
                        subjectAddView.addSubject();

                        break;
                    case "t":
                        NewTeacherRegisterView newTeacherRegisterView = new NewTeacherRegisterView(securityController, in);
                        newTeacherRegisterView.registerNewTeacher();
                        break;
                    case "d":
                        SubjectDeleteView subjectDeleteView = new SubjectDeleteView(wdController, in);
                        if (!subjectDeleteView.deleteSubjectView()) return;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Wpisz odpowiedni znak!");
            }

        } while(continueView);

        return;

    }

}
