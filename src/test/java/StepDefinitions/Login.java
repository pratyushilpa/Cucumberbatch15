package StepDefinitions;

import Pages.LoginPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class Login extends CommonMethods {
    //LoginPage loginPage = new LoginPage();

    @Given("open the browser and launch HRMS application")
    public void open_the_browser_and_launch_hrms_application() {
        openBrowserAndLaunchApplication();
    }
    @When("user enters valid email and valid password")
    public void user_enters_valid_email_and_valid_password() {

        //driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(ConfigReader.getPropertyValue("username"));
        //driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(ConfigReader.getPropertyValue("password"));
        //WebElement usernameTextBox = driver.findElement(By.xpath("//input[@id='txtUsername']"));
            sendText(login.userNameTextbox,ConfigReader.getPropertyValue("username"));

       // WebElement passwordTextBox= driver.findElement(By.xpath("//input[@id='txtPassword']"));
        sendText(login.passwordTextbox,ConfigReader.getPropertyValue("password"));
    }
    @When("click on login button")
    public void click_on_login_button() {

        //WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        doClick(login.loginBtn);
    }
    @Then("user is logged in successfully into the application")
    public void user_is_logged_in_successfully() {
        boolean userLoggedIn = driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).isDisplayed();
        if(userLoggedIn){
            System.out.println("User is logged in Successfully");
        }
    }
    @And("Close the browser")
    public void close(){
        closeBrowser();
    }

    @When("user enters valid {string} and valid {st" +
            "ring}")
    public void user_enters_valid_and_valid(String username, String password) {
       // WebElement usernameTextBox = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        sendText(login.userNameTextbox,username);

        //WebElement passwordTextBox= driver.findElement(By.xpath("//input[@id='txtPassword']"));
        sendText(login.passwordTextbox,password);
    }

    @When("user enters username and password  and verifies login")
    public void user_enters_username_and_password_and_verifies_login(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<Map<String,String>> userCredentials = dataTable.asMaps();
        for(Map<String,String> userCreds : userCredentials){
            String username = userCreds.get("username");
           String password =  userCreds.get("password");

           //WebElement  userNameTextbox = driver.findElement(By.id("txtUsername"));
           sendText(login.userNameTextbox,username);

           // WebElement  passwordTextbox = driver.findElement(By.id("txtPassword"));
            sendText(login.passwordTextbox,password);

            //WebElement loginBtn = driver.findElement(By.id("btnLogin"));
            doClick(login.loginBtn);

           // WebElement welcomeIcon = driver.findElement(By.id("welcome"));
            doClick(login.welcomeIcon);

            //WebElement logoutLink = driver.findElement(By.xpath("//a[text()='Logout']"));
            doClick(login.logoutLink);
        }
    }

}
