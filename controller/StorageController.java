package controller;

import model.WD;
import java.io.*;

public class StorageController {
    protected final static String fileName = "src/model/save.ser";

    public static WD loadWD() {
        try (FileInputStream istream = new FileInputStream(fileName)) {
            ObjectInputStream i = new ObjectInputStream(istream);
            WD wd = (WD)i.readObject();

            return wd;

        } catch (Exception e) {
            return null;
        }
    }


    public static boolean saveWD(WD wd) {
        try (FileOutputStream ostream = new FileOutputStream(fileName)) {
            ObjectOutputStream o = new ObjectOutputStream(ostream);
            o.writeObject(wd);
            o.flush();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

}
