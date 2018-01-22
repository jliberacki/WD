package controller;

import model.*;

public class WDController {
    private WD wd;
    private User loggedUser;

    public WDController(WD wd, User loggedUser) {
        this.wd=wd;
        this.loggedUser = loggedUser;
    }



    public WD getWD() {
        return this.wd;
    }

    public User getLoggedUser() {
        return this.loggedUser;
    }

}
