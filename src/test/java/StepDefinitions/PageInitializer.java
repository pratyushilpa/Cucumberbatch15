package StepDefinitions;

import Pages.AddEmployeePage;
import Pages.EmployeeJobDetailsPage;
import Pages.LoginPage;

public class PageInitializer {
    public static LoginPage login;
    public static AddEmployeePage addEmployeePage;

    public static EmployeeJobDetailsPage employeeJobDetailsPage;
    public static void initializePageObjects(){
         login = new LoginPage();
        addEmployeePage = new AddEmployeePage();
        employeeJobDetailsPage = new EmployeeJobDetailsPage();
    }
}
