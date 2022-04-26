package stepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import utilities.Base;

public class HomePageFeature extends Base{
	@Given("^User should be on BeCognizant page$")
	public void user_should_be_on_BeCognizant_page() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	   String currentURL=driver.getCurrentUrl();
	   if(currentURL.equalsIgnoreCase("https://be.cognizant.com/")) {
		   System.out.println("\n---------------------------------------------------------");
		   System.out.println("You are on ** "+currentURL+" ** Page"); 
	   }
	   snap("BeCognizant");
	   Logger = reports.createTest("User should be on BeCognizant page");
		Logger.log(Status.INFO, "User should be on BeCognizant page");
		Logger.log(Status.PASS,"BeCognizant page");
	}

	@Given("^user should have logIn successfully$")
	public void user_should_have_logIn_successfully() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	    String user=driver.findElement(By.xpath("//*[@id='userProfileToggleBtn']/div/div[2]")).getText();
	    System.out.println("-----------------------------------------------------------");
	    System.out.println("User is :"+user);
	    System.out.println("-----------------------------------------------------------");
	    try {
			writeExcel(user);
		} catch (Exception e) {
			System.out.println("User data is not updated in excel file ");
			e.printStackTrace();
		}
	    Logger = reports.createTest("user should have logIn successfully");
		Logger.log(Status.INFO, "logIn successfully" + user);
		Logger.log(Status.PASS,"logIn successfully");
	}

	@When("^click on search box$")
	public void click_on_search_box() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	    WebElement searchBox=driver.findElement(By.xpath("//*[@id='searchbox']"));
	    JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", searchBox);
		
		 Logger = reports.createTest("click on search box");
			Logger.log(Status.INFO, "click on search box");
			Logger.log(Status.PASS,"clicked on search box");
	}
	
	@When("^search for timesheet$")
	public void search_for_timesheet() {
		 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		 WebElement searchBox=driver.findElement(By.xpath("//*[@id='searchbox']"));
		 searchBox.sendKeys("ESA Timesheet");
		 searchBox.sendKeys(Keys.ENTER);
		 
		 Logger = reports.createTest("search for timesheet");
			Logger.log(Status.INFO, "searching for timesheet");
			Logger.log(Status.PASS,"search timesheet");
	}
	
	@When("^select ESATimesheet$")
	public void select_ESATimesheet() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("https://compass.esa.cognizant.com/psc/ESA89PRD/EMPLOYEE/ERP/s/WEBLIB_CTS_FLUD.ISCRIPT1.FieldFormula.ISCRIPT_MainPage")));
		snap("search");
		driver.findElement(By.partialLinkText("https://compass.esa.cognizant.com/psc/ESA89PRD/EMPLOYEE/ERP/s/WEBLIB_CTS_FLUD.ISCRIPT1.FieldFormula.ISCRIPT_MainPage")).click();
		
		Logger = reports.createTest("select ESATimesheet");
		Logger.log(Status.INFO, "select ESATimesheet");
		Logger.log(Status.PASS,"select ESATimesheet");
	}


}
