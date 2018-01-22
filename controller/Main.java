package controller;

import model.WD;
import view.*;
import exception.*;

public class Main {

    public static void main(String[] args) throws InvalidDataExcepetion, InvalidLoginOrPasswordException {
            WD wd = StorageController.loadWD();
            if (wd == null) wd = new WD();
            SecurityController securityController = new SecurityController(wd);
            WdHome wdHome = new WdHome(securityController);
            wd.printall();
            if (!wdHome.wdHomeView()) Main.quit(wd);
            else {
                WDController wdController = new WDController(wd, securityController.getUser());
                if (securityController.getUser().isItAdmin()) {
                    HomeAdmin homeAdmin = new HomeAdmin(wdController, securityController);
                    if (!homeAdmin.homeAdminView()) Main.quit(wd);
                }
                if (securityController.getUser().isItTeacher()) {
                    HomeTeacher homeTeacher = new HomeTeacher(wdController, securityController);
                    if (!homeTeacher.homeTeacherView()) Main.quit(wd);
                }
                if (securityController.getUser().isItStudent()) {
                    HomeStudent homeStudent = new HomeStudent(wdController, securityController);
                    if (!homeStudent.homeStudentView()) Main.quit(wd);
                }
            }
        }

        public static void quit (WD wd) {
            StorageController.saveWD(wd);
        }



}

