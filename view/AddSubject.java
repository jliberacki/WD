package view;

import controller.WDController;
import exception.InvalidDataExcepetion;
import model.Subject;
import model.Teacher;

import java.util.LinkedList;
import java.util.Scanner;

public class AddSubject {
    private WDController wdController;
    private Scanner in;

    public AddSubject(WDController wdController, Scanner in) {
        this.wdController = wdController;
        this.in = in;
    }

    public void addSubject() throws InvalidDataExcepetion {
        LinkedList<Subject> subjects  = this.wdController.getWD().getSubjects();
        String subjectname;
        String teachernick;
        System.out.println("Wpisz nazwe przedmiotu:");
        subjectname = in.nextLine();
        System.out.println("Wpisz nick nauczyciela:");
        teachernick=in.nextLine();
        Teacher teacher = this.wdController.getWD().getTeacherByNick(teachernick);
        Subject newSubject = new Subject(subjectname, teacher);
        if (this.wdController.getWD().addSubject(newSubject)){
            System.out.println("Dodano!");
        }
        else {
            System.out.println("Nie udalo sie!");
        }
    }


}

