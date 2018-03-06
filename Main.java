

import model.WD;
import model.User;
import view.*;
import exception.*;
import controller.*;

public class Main {

    public static void main(String[] args) throws InvalidDataExcepetion, InvalidLoginOrPasswordException, WrongValueException {
            WD wd = StorageController.loadWD();
            SecurityController securityController = new SecurityController(wd);
            HomeView homeView = new HomeView(securityController);
            wd.printall();
            try {
                if (!homeView.viewHome()) Main.quit(wd);
                else {
                    WDController wdController = new WDController(wd, securityController.getUser());
                    User.UserTypes u = User.UserType(securityController.getUser());
                    switch(u){
                        case ADMIN:
                            AdminHomeView adminHomeView = new AdminHomeView(wdController, securityController);
                            adminHomeView.viewAdminHome();
                            Main.quit(wd);
                            break;
                        case TEACHER:
                            TeacherHomeView teacherHomeView = new TeacherHomeView(wdController, securityController);
                            teacherHomeView.viewTeacherHome();
                            Main.quit(wd);
                            break;
                        case STUDENT:
                            StudentHomeView studentHomeView = new StudentHomeView(wdController, securityController);
                            studentHomeView.viewStudentHome();
                            Main.quit(wd);
                            break;
                    }



                    /*
                    if (securityController.getUser().isItAdmin()) {
                        AdminHomeView adminHomeView = new AdminHomeView(wdController, securityController);
                        adminHomeView.viewAdminHome();
                        Main.quit(wd);
                    }
                    if (securityController.getUser().isItTeacher()) {
                        TeacherHomeView teacherHomeView = new TeacherHomeView(wdController, securityController);
                        teacherHomeView.viewTeacherHome();
                        Main.quit(wd);
                    }
                    if (securityController.getUser().isItStudent()) {
                        StudentHomeView studentHomeView = new StudentHomeView(wdController, securityController);
                        studentHomeView.viewStudentHome();
                        Main.quit(wd);
                    }
                    */
                }
            } catch(InvalidDataExcepetion e){
                System.out.println(e.getMessage());
                Main.quit(wd);
            } catch (InvalidLoginOrPasswordException e){
                System.out.println(e.getMessage());
                Main.quit(wd);
            } catch (WrongValueException e){
                System.out.println(e.getMessage());
                Main.quit(wd);
            }


    }

    public static void quit (WD wd) {
            if(StorageController.saveWD(wd)) System.out.println("zapisalem");
            else System.out.println("nie udalo sie zapisac");
        }



}

