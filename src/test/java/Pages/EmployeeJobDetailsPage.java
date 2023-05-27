package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class EmployeeJobDetailsPage extends CommonMethods {
    public EmployeeJobDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="menu_pim_viewPimModule")   // WebElement pimOpt = driver.findElement(By.id("menu_pim_viewPimModule"));
    public WebElement pimOpt;


    @FindBy(xpath="//input[id='idmenu_pim_viewEmployeeList']")
    public WebElement empList;


    @FindBy(xpath="//input[@type='text' and @id='empsearch_id']")    //WebElement searchId = driver.findElement(By.id("empsearch_id"));
    public WebElement empId;


    @FindBy(id="searchBtn")        //WebElement searchId = driver.findElement(By.id("searchBtn"));
    public WebElement searchButton;


    @FindBy(xpath="//table[@class='table hover']/tbody/tr/td[1]")
    public WebElement empID;


    @FindBy(linkText="Job")
    public WebElement jobOpt;


    @FindBy(id="btnSave")            // WebElement edit = driver.findElement(By.id("btnSave"));
    public WebElement edit;


    @FindBy(xpath="job_job_title")
    // WebElement jobDD = driver.findElement(By.xpath("//select[@id='job_job_title']"));
    public WebElement jobDD;


    @FindBy(id="job_emp_status")
    // WebElement empStatusDD = driver.findElement(By.xpath("//select[@id='job_emp_status']"));
    public WebElement empStatusDD;


    @FindBy(id="job_eeo_category")      // WebElement jobCatDD = driver.findElement(By.id("job_eeo_category"));
    public WebElement jobCatDD;


    @FindBy(id="job_joined_date")     //WebElement calander = driver.findElement(By.id("job_joined_date"));
    public WebElement calander;

    @FindBy(xpath="//select[@class='ui-datepicker-year']")
    // WebElement yearDD = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
    public WebElement yearDD;

    @FindBy(xpath="select[@class='ui-datepicker-month']")
// WebElement monthDD = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
    public WebElement monthDD;

    @FindBy(xpath="//table[@class='ui-datepicker-calendar']/tbody//tr//td")
    // List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//tr//td"));
    public WebElement days;


    @FindBy(id="job_sub_unit")   // WebElement subUnitDD = driver.findElement(By.id("job_sub_unit"));
    public WebElement subUnitDD;


    @FindBy(id="job_location")  // WebElement locationDD = driver.findElement(By.id("job_location"));
    public WebElement locationDD;



    @FindBy(id="job_contract_start_date")
    //WebElement calender = driver.findElement(By.xpath("//input[@id='job_contract_start_date']"));
    public WebElement calenderStartDate;

    @FindBy(xpath="select[@class='ui-datepicker-year']")
    public WebElement jobStartDateDD;

    @FindBy(xpath="select[@class='ui-datepicker-month']")
    // WebElement monthDD = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
    public WebElement monthDD1;

    @FindBy(xpath="table[@class='ui-datepicker-calendar']/tbody//tr//td")
    // List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
    public WebElement day;



    @FindBy(id="job_contract_end_date")
    //WebElement calendar = driver.findElement(By.xpath("//input[@id='job_contract_end_date']"));
    public WebElement calendarEndDate;

    @FindBy(xpath="select[@class='ui-datepicker-year']")
    public WebElement jobEndDateDD;

    @FindBy(xpath="select[@class='ui-datepicker-month']")
    // WebElement monthDD = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
    public WebElement monthDD2;

    @FindBy(xpath="table[@class='ui-datepicker-calendar']/tbody//tr//td")
    // List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
    public WebElement day2;


    @FindBy(id="job_contract_file")  //  WebElement chooseFile = driver.findElement(By.id("job_contract_file"));
    public WebElement chooseFile;


    @FindBy(id="btnSave")   // WebElement saveBtn = driver.findElement(By.id("btnSave"));
    public WebElement saveBtn;



    public WebElement chooseEmployee (String employeeName) {
        WebElement employee = driver.findElement(By.linkText(employeeName));
        return employee;
    }


}
