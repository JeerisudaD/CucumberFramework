package steps;

import pages.*;

public class PageInitializers {
    public static LoginPage login;
    public static EmploySearchPage employSearchPage;
    public static AddEmployeePage addEmployeePage;
    public static DashboardPage dash;
    public static AdminPage adminPage;

    public static void initializePageObjects(){
        login = new LoginPage();
        employSearchPage = new EmploySearchPage();
        addEmployeePage = new AddEmployeePage();
        dash=new DashboardPage();
        adminPage=new AdminPage();
    }
}
