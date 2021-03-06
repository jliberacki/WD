package view;

import controller.WDController;
import exception.InvalidDataExcepetion;
import model.Mark;
import model.Student;
import model.Subject;

import java.util.Scanner;

public class MarkCheckView {
    private WDController wdController;
    private Scanner in;

    public MarkCheckView(WDController wdController, Scanner in) {
        this.wdController = wdController;
        this.in = in;
    }

    public void checkMark() throws InvalidDataExcepetion {
        String subjectname;
        System.out.println("Wpisz nazwe przedmiotu");
        subjectname = in.nextLine();
        Subject subject=this.wdController.getWD().getSubjectByName(subjectname);
        Student student=this.wdController.getWD().getStudentByNick(this.wdController.getLoggedUser().getNick());
        if(this.wdController.getWD().printMarks(student, subject)){
            System.out.println("To Twoje wszystkie oceny");
        }
        else {
            System.out.println("Nie posiadasz ocen z tego przedmiotu");
        }
    }

}
