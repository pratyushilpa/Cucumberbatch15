package StepDefinitions;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;



public class EmployeeJobDetails extends CommonMethods {

    LocalDate joinedDate;

    /* @Given("open browser and launch HRMS website")
    public void open_browser_and_launch_hrms_website() {
        openBrowserAndLaunchApplication();
    }*/


   /* @When("user enters valid username and valid password combination")
    public void user_enters_valid_username_and_valid_password_combination() {
        adminLogin.userNameTextBox.sendKeys("Admin");
        adminLogin.passwordTextBox.sendKeys("Hum@nhrm123");

        // WebElement usernameTextBox = driver.findElement(By.id("txtUsername"));
        //  usernameTextBox.sendKeys("Admin");
        // WebElement passwordTextBox = driver.findElement(By.id("txtPassword"));
        // passwordTextBox.sendKeys("Hum@nhrm123");
    }

    @When("user clicks on log in button")
    public void user_clicks_on_log_in_button() {
        adminLogin.logInBtn.click();

        // WebElement LogInButton = driver.findElement(By.id("btnLogin"));
        //LogInButton.click();
    }

    @Then("user is logged in successfully on correct dashboard")
    public void user_is_logged_in_successfully_on_correct_dashboard() throws InterruptedException {
        boolean userLoggedIn = adminLogin.welcomeText.isDisplayed();
        if (userLoggedIn) {
            System.out.println("Admin user has been logged in successfully");
        }
    }*/

        /* WebElement welcomeText = driver.findElement(By.id("welcome"));
        // if (welcomeText.isDisplayed()) {
        //   System.out.println("Admin user has been logged in successfully");
        // }
    }*/

   /* @When("user clicks on PIM option")
    public void user_clicks_on_PIM_option() {
        doClick(employeeJobDetailsPage.pimOpt);
    }*/


    @When("user accesses employee profile")
    public void user_accesses_employees_profile() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        doClick(employeeJobDetailsPage.empList);
    }

    @And("user enters Id")
    public void user_enters_Id() throws InterruptedException {

        Thread.sleep(10000);
        sendText(employeeJobDetailsPage.empId, ConfigReader.getPropertyValue("employeeID"));
    }

    @Then("user clicks on search button")
    public void user_clicks_on_search_button(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        doClick(employeeJobDetailsPage.searchButton);
    }


    @When("select a specified employee Id from the list")
    public void select_a_specified_employee_Id_from_the_list() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        doClick(employeeJobDetailsPage.chooseEmployee("77077A"));
    }


    @When("navigate to the employee's job page")
    public void navigate_to_the_employee_s_job_page() {    // WebElement jobOpt = driver.findElement(By.linkText("Job"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        doClick(employeeJobDetailsPage.jobOpt);
    }


    @When("user clicks on edit button")
    public void user_clicks_on_edit_button() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        doClick(employeeJobDetailsPage.edit);
    }


    @When("user selects Job TiTle")
    public void user_selects_job_title() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement jobDD = driver.findElement(By.xpath("//select[@id='job_job_title']"));
        selectByOptions(jobDD, "QA Automation Engineer");
    }


    @When("user selects Employment Status")
    public void user_selects_employment_status() throws InterruptedException {
        WebElement empStatusDD = driver.findElement(By.xpath("//select[@id='job_emp_status']"));
        Select sel = new Select(empStatusDD);
        sel.selectByVisibleText("Full time");
    }


    @And("user selects Job Category")
    public void user_Selects_Job_Category() throws InterruptedException {
        WebElement jobCatDD = driver.findElement(By.id("job_eeo_category"));
        selectByOptions(jobCatDD, "Technical Department");
    }


    @When("user selects Joined Date")
    public void user_selects_joined_date() throws InterruptedException {    // //job_sub_unit
        doClick(employeeJobDetailsPage.calander);
       joinedDate = java.time.LocalDate.now();

        //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/mm/dd");
        //joinedDate = LocalDate.now();
        sendText(employeeJobDetailsPage.calander, String.valueOf(joinedDate));
        doClick(driver.findElement(By.xpath("//div[@class='head']//h1[text()='Job']")));

// year's dropdown
        // WebElement yearDD = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        //selectByOptions(employeeJobDetailsPage.yearDD, "2023");


// month's dropdown
        Thread.sleep(5000);
        //WebElement monthDD = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        //doClick(employeeJobDetailsPage.monthDD);
        //selectByOptions(employeeJobDetailsPage.monthDD, "Apr");

// select the day
        /*List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//tr//td"));
        for (WebElement day :days) {
            String day_text = day.getText();
            System.out.println("print all days" + day_text);
            if (day_text.equalsIgnoreCase("22")) {
                System.out.println("print all days 22 " + day_text);
                doClick(day);
            }
        }*/
    }


    @When("user selects Sub Unit")
    public void user_selects_sub_unit() throws InterruptedException {
        WebElement subUnitDD = driver.findElement(By.xpath("//select[@id='job_sub_unit']"));   //job_sub_unit
        selectByOptions(subUnitDD, "IT Support");
    }

    @And("user selects Location")
    public void userSelectsLocation() throws InterruptedException {
        WebElement locationDD = driver.findElement(By.id("job_location"));
        selectByOptions(locationDD, "New Office");
    }


    @When("user selects Start Date")
    public void user_selects_start_date() throws InterruptedException {
        doClick(employeeJobDetailsPage.calenderStartDate);
        sendText(employeeJobDetailsPage.calenderStartDate, String.valueOf(joinedDate));
        doClick(driver.findElement(By.xpath("//div[@class='head']//h1[text()='Job']")));

       /* WebElement jobStartDateDD = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        selectByOptions(jobStartDateDD, "2023");
        // dd month
        WebElement monthDD = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        selectByOptions(monthDD, "May");

// select the day
        List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//tr//td"));
        for (WebElement day : days) {
            String day_text = day.getText();
            System.out.println("print all days"+day_text);
            if (day_text.equalsIgnoreCase("5")) {
                System.out.println("print all days 5 "+day_text);
                doClick(day);
            }
        }*/
    }


    @When("user selects End Date")
    public void user_selects_end_date() throws InterruptedException {
        doClick(employeeJobDetailsPage.calendarEndDate);
        sendText(employeeJobDetailsPage.calendarEndDate, String.valueOf(joinedDate));
        doClick(driver.findElement(By.xpath("//div[@class='head']//h1[text()='Job']")));
        // WebElement calendar = driver.findElement(By.xpath("//input[@id='job_contract_end_date']"));
        // calender.click();
        //year DD
       /* WebElement jobEndDateDD = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        selectByOptions(jobEndDateDD, "2025");

        //month DD
        WebElement monthDD = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        selectByOptions(employeeJobDetailsPage.monthDD2, "May");

// select the day
        List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//tr//td"));
        for (WebElement day : days) {
            String day_text = day.getText();
            System.out.println("print all days"+day_text);
            if (day_text.equalsIgnoreCase("15")) {
                System.out.println("print all days 15 "+day_text);
                doClick(day);
            }
        }*/
    }

    @Then("user uploads Contract Details")
    public void user_Uploads_Contract_Details() throws InterruptedException {
        WebElement chooseFile = driver.findElement(By.id("job_contract_file"));
        //chooseFile.sendKeys("C:\\Users\\shira\\OneDrive\\Desktop\\Clone_Project.docx");
    }


    /*@And("user clicks on save button")
    public void user_clicks_on_save_button() {
        doClick(employeeJobDetailsPage.saveBtn);   // WebElement saveBtn = driver.findElement(By.id("btnSave"));
    }*/

    @And("specified employee's job added")
    public void specified_employee_s_job_added() {
        String edit = employeeJobDetailsPage.edit.getText();
    }

    // Added by Pratyush

    @When("user accesses the list of employees in the system.")
    public void searchEmployee(){
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//input[@id='empsearch_id']")).click();

    }
}

