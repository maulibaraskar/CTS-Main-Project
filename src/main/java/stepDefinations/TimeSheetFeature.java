package stepDefinations;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.Base;

public class TimeSheetFeature extends Base{
	String []weeks = new String[5];
	String week1,week2,week3;
	@Given("^User should land on Timesheet page$")
	public void user_should_land_on_Timesheet_page() {
		String currentHandle= driver.getWindowHandle();
		Set<String> handle1=driver.getWindowHandles();
		for(String actual: handle1) {
			if(!actual.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(actual);
			}
		}
		String title=driver.getTitle();
		if(title.equalsIgnoreCase("Timesheet Landing Component")) {

			System.out.println("\n You are navigated on : \"Timesheet Landing Component page\" ");
		}
		 Logger = reports.createTest("Time sheet page");
			Logger.log(Status.INFO, "landed on Time sheet page");
			Logger.log(Status.PASS,"landed on Time sheet page");
	}

	@Given("^print latest three weeks$")
	public void print_latest_three_weeks() {
		WebElement element;
		String temp;
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"win0div$ICField44$0\"]/div[1]")));
		snap("timeSheet");
		for (int i=1;i<=5;i++) {
			element=driver.findElement(By.xpath("//*[@id=\"win0div$ICField44$0\"]/div"+"["+i+"]"+"/div/div/div/span/a"));
			temp=element.getText();
			
			if(i==1) {
				weeks[i]=temp;
				week1=temp;
				 System.out.println("---------------------------------------------------------");
				System.out.println("Current week is           : "+temp);
				
					Logger = reports.createTest("printing first week from "+temp);
					Logger.log(Status.INFO, "printing first week from "+temp);
					Logger.log(Status.PASS,"first week");
	
			}else if(i==2){
				weeks[i]=temp;
				week2=temp;
			
				System.out.println("last week was             : "+temp);
				 
				Logger = reports.createTest("printing second week from "+temp);
				Logger.log(Status.INFO, "printing second week from "+temp);
				Logger.log(Status.PASS,"second week");
			}else if(i==3){
				weeks[i]=temp;
				week3=temp;
				 
				System.out.println("week before last week was : "+temp);
				Logger = reports.createTest("printing third week from "+temp);
				Logger.log(Status.INFO, "printing third week from "+temp);
				Logger.log(Status.PASS,"third week"); 
			}	
			
		}
		try {
			writeExcel(week1, week2, week3);
			Logger = reports.createTest("writing excel ");
			Logger.log(Status.INFO, "writing excel");
			Logger.log(Status.PASS,"writing excel");
		} catch (Exception e) {
			System.out.println("Weeks are not updated in excel");
			e.printStackTrace();
		}
	}

	@When("^validate current week$")
	public void validate_current_week() {
		String check=currentWeek();
		if(weeks[1].equalsIgnoreCase(check)) {
			//logger
			Logger = reports.createTest("comparing current week with system date");
			Logger.log(Status.INFO, "current week");
			Logger.log(Status.PASS,"current week");
		}
	}

	@When("^validate previous week$")
	public void validate_previous_week() {
		String check=previousWeek();
		if(weeks[2].equalsIgnoreCase(check)) {
			//logger
			Logger = reports.createTest("comparing previous week with system date");
			Logger.log(Status.INFO, "previous week");
			Logger.log(Status.PASS,"previous week");
		}
	}

	@When("^validate week before previous week$")
	public void validate_week_before_previous_week() {
		String check=weekBeforePreviousWeek();
		if(weeks[3].equalsIgnoreCase(check)) {
			//logger
			Logger = reports.createTest("comparing week before previous week with system date");
			Logger.log(Status.INFO, "week before previous week");
			Logger.log(Status.PASS,"week before previous week");
		}
	}

	@Then("^close browser$")
	public void close_browser() {
		quitBrowser();
	}

}
