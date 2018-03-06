package view;


import controller.WDController;
import model.Subject;

import java.util.LinkedList;
import java.util.Scanner;

public class SubjectDeleteView {
    private WDController wdController;
    private Scanner in;

    public SubjectDeleteView(WDController wdController, Scanner in) {
        this.wdController = wdController;
        this.in = in;
    }

    public boolean deleteSubjectView() {
        do {
            LinkedList<Subject> subjects  = this.wdController.getWD().getSubjects();
            int i=0;
            for (Subject subject : subjects) {
                System.out.println("Naciśnij " + i  +", aby usunąć przedmiot o nazwie: " + subject.getName());
                i++;
            }
            System.out.println("Naciśnij b, aby się cofnąć!");
            System.out.println("Naciśnij q, aby wyjść!");

            String inputChar;
            int numberOfSubject;

            try {

                inputChar = in.nextLine();
                if (inputChar.equals("q")) {
                    return false;
                } else if (inputChar.equals("b")) {
                    return true;
                }  else {
                    numberOfSubject = Integer.parseInt(inputChar);
                    this.wdController.getWD().deleteSubject(numberOfSubject);
                    System.out.println("Przedmiot usunięto!");
                    return true;

                }
            } catch (NumberFormatException e) {
                System.out.println("Wpisz odpowiedni znak!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Nie ma przedmiotu przyporzadkowanego do tego numeru!");
            }

        } while(true);
    }
}
