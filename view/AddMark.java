package view;

import controller.WDController;
import exception.InvalidDataExcepetion;
import model.Mark;
import model.Student;
import model.Subject;

import java.util.Scanner;

public class AddMark {
    private WDController wdController;
    private Scanner in;

    public AddMark(WDController wdController, Scanner in) {
        this.wdController = wdController;
        this.in = in;
    }

    public void addMark() throws InvalidDataExcepetion {
        String studentID;
        String subjectname;
        String date;
        String description;
        String ocena;
        System.out.println("Wpisz wartosc oceny (pamietaj ze musi to byc wartosc z zakresu 2-5 oraz byc wielokrotnoscia 0.5:");
        ocena=in.nextLine();
        float value = Float.parseFloat(ocena);
        System.out.println("Wpisz numer indeksu studenta:");
        studentID = in.nextLine();
        System.out.println("Wpisz nazwe przedmiotu:");
        subjectname=in.nextLine();
        System.out.println("Wpisz date wystawienia oceny:");
        date=in.nextLine();
        System.out.println("Wpisz opis oceny:");
        description=in.nextLine();



        Student student = this.wdController.getWD().getStudentByID(studentID);
        Subject subject = this.wdController.getWD().getSubjectByName(subjectname);

        Mark mark = new Mark (value, student, subject, date, description);


        if (student.getMark(mark)){
            System.out.println("Dodano!");
        }
        else {
            System.out.println("Nie udalo sie!");
        }
    }


}