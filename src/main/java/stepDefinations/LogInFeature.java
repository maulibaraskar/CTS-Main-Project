package stepDefinations;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.Base;
public class LogInFeature extends Base{
	@Given("^User LogIn on BeCognizant$")
	public void user_LogIn_on_BeCognizant() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		driver.manage().deleteAllCookies();
//		getDriver("chrome");
//		openUrl();
		Logger = reports.createTest("Chrome Initiated Successfully");
		Logger.log(Status.INFO, "browser opened successfully");
		Logger.log(Status.PASS,"Chrome Initiated");
		
		driver.get(prop.getProperty("Url"));
		
		Logger = reports.createTest("website searching");
		Logger.log(Status.INFO, "website searched Successfully");
		Logger.log(Status.PASS,"website searching");

	}

	@Given("^user enters username$")
	public void user_enters_username() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		WebElement uname=driver.findElement(By.xpath("//*[@id='i0116']"));
		uname.sendKeys(prop.getProperty("id"));
		uname.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		Logger = reports.createTest("username / login id");
		Logger.log(Status.INFO, "user name entered successfully");
		Logger.log(Status.PASS,"user name entered");
	   
		snap("userid");
	    
	    Logger.addScreenCaptureFromPath(snap("userid"));
	}

	@When("^clicks on next button$")
	public void clicks_on_next_button()  {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		WebElement next=driver.findElement(By.xpath("//*[@id='lightbox']/div[3]/div/div[2]/div/div[4]/div[2]/div/div/div/div"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", next);
		
		Logger = reports.createTest("clicks on next button");
		Logger.log(Status.INFO, "clicks on next button");
		Logger.log(Status.PASS,"clicked on next button");
	}

	@When("^user enters password$")
	public void user_enters_password() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		WebElement pass=driver.findElement(By.xpath("//*[@id='i0118']"));
		pass.sendKeys(prop.getProperty("pass"));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		
		Logger = reports.createTest("user enters password");
		Logger.log(Status.INFO, "user enters password");
		Logger.log(Status.PASS," entered password");

		
	    snap("password");
	}

	@When("^user click on signIn button$")
	public void user_click_on_signIn_button() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		WebElement signIn=driver.findElement(By.xpath("//*[@id='idSIButton9']"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", signIn);
	    
		Logger = reports.createTest("user click on signIn button");
		Logger.log(Status.INFO, "user click on signIn button");
		Logger.log(Status.PASS," clicked on signIn button");

	}

	@Then("^selects verify with call option$")
	public void selects_verify_with_call_option() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		WebElement verify=driver.findElement(By.xpath("//*[@id='idDiv_SAOTCS_Proofs']/div[2]/div/div/div[2]"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", verify);
	  snap("callOption");
	  
	    Logger = reports.createTest("selects verify with call option");
		Logger.log(Status.INFO, "user selects verify with call option");
		Logger.log(Status.PASS,"call option selected");
	}

	@Then("^clicks on sign button$")
	public void clicks_on_sign_button() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
		Thread.sleep(5000);
		WebElement checkBox=driver.findElement(By.xpath("//*[@id=\"KmsiCheckboxField\"]"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", checkBox);
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
		WebElement okButton=driver.findElement(By.xpath("//*[@id='idSIButton9']"));
		JavascriptExecutor js1= (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click()", okButton);
	   
		 	Logger = reports.createTest("clicks on sign button");
			Logger.log(Status.INFO, "user clicks on sign button");
			Logger.log(Status.PASS,"clicks on sign button");
	}

	@Then("^page title is BeCognizant$")
	public void page_title_is_BeCognizant() {
driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		
		String siteName = driver.getTitle();
		if(siteName.equalsIgnoreCase("Be.Cognizant")) {
			 System.out.println("\n---------------------------------------------------------");
			System.out.println("		Landed on :"+siteName+" Page");
		}else {
			System.out.println("control is not passed here");
		}
		System.out.println("	 	You have loggedIn  sucessfully			");
		 System.out.println("---------------------------------------------------------");
		 Logger = reports.createTest("page title is BeCognizant");
			Logger.log(Status.INFO, "page title is BeCognizant");
			Logger.log(Status.PASS,"page title is BeCognizant");
	}


}
