package view;

import controller.SecurityController;
import controller.WDController;

public class UserHomeView {
    protected WDController wdController;
    protected SecurityController securityController;


    public UserHomeView(WDController wdController, SecurityController securityController) {
        this.wdController=wdController;
        this.securityController=securityController;
    }
}
