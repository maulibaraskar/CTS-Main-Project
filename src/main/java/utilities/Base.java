package utilities;
/**
 * This class is defined to implement basic utilities like browser selection,screenshot
 * @author Coding Titans
 * Date:01/12/2020 
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Base {
	public static Properties prop = new Properties();
	public static ExtentReports reports = ExtentReport.getReportInstance(); 
	public static WebDriver driver;
	public static ExtentTest Logger;
	public static String browse;
	public static String path = System.getProperty("user.dir") + "\\Input-output-files\\Book1.xlsx";		//Fetching excel file from directory
	public static File file;
	public static FileInputStream fin;

	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static FileOutputStream fout;
	static XSSFRow row = null;
	/*
	 * Creating constructor to initialize properties file
	 */
	
	public Base() {

		try 
		{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\input-output-files\\input.properties"); 	//Property file location
		prop.load(file); 					//Loading property file
		} 
	catch (Exception e)
		{
			e.printStackTrace();			//Printing actual error message
		}
	}

	/*
	 * Method to open browser
	 */
	public static WebDriver getDriver(String browser) {
		
		System.out.println("Browser selected: " + browser);
		browse=browser;
		// open chrome browser
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			Logger = reports.createTest("Chrome Initiated Successfully");
			Logger.log(Status.PASS,"Chrome Initiated");
			reports.flush();
		}

		// open firefox browser
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
			Logger = reports.createTest("Firefox Initiated Successfully");
			Logger.log(Status.PASS,"Firefox Initiated");
			 driver=new FirefoxDriver();
		} 

		// Maximize window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//Invoking implicit wait
		return driver;
	}
	   
	public void openUrl() {
		driver.get(prop.getProperty("Url"));
	}
//
//	public void waitElementClickable(String elementXpath) {
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
//	}
//
	/*
	 * Take Screenshot
	 */
	public String snap(String fileName) {

		// Creating a screenshot driver and storing in scrFile temporarily.
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/Screenshots/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String destination = System.getProperty("user.dir") + "/Screenshots/" + fileName;
		return destination;
	}

	public String currentWeek() {
		// Get calendar set to current date and time
				Calendar c = GregorianCalendar.getInstance();

				c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
				//System.out.println("Current week = " + Calendar.DAY_OF_WEEK);

				// Print dates of the current week starting on Monday
				DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
				String startDate = "", endDate = "";

				startDate = df.format(c.getTime());
				c.add(Calendar.DATE, -7);
				String dummy=df.format(c.getTime());
				c.add(Calendar.DATE, 6);
				String dummy1=df.format(c.getTime());
				String date=dummy+" TO "+dummy1;
				return date;
				//System.out.println(date);
	}
	public String previousWeek() {
		// Get calendar set to current date and time
				Calendar c = GregorianCalendar.getInstance();

				c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
				//System.out.println("Current week = " + Calendar.DAY_OF_WEEK);

				// Print dates of the current week starting on Monday
				DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
				String startDate = "", endDate = "";

				startDate = df.format(c.getTime());
				c.add(Calendar.DATE, -14);
				String dummy=df.format(c.getTime());
				c.add(Calendar.DATE, 6);
				String dummy1=df.format(c.getTime());
				String date=dummy+" TO "+dummy1;
				return date;
	}
	public String weekBeforePreviousWeek() {
		// Get calendar set to current date and time
				Calendar c = GregorianCalendar.getInstance();

				c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
				//System.out.println("Current week = " + Calendar.DAY_OF_WEEK);

				// Print dates of the current week starting on Monday
				DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
				String startDate = "", endDate = "";

				startDate = df.format(c.getTime());
				c.add(Calendar.DATE, -21);
				String dummy=df.format(c.getTime());
				c.add(Calendar.DATE, 6);
				String dummy1=df.format(c.getTime());
				String date=dummy+" TO "+dummy1;
				return date;
	}
	
	

	//Passing values to excel sheet to save it
	public static void writeExcel(String week1,String week2, String week3) throws Exception {
		//Fetching excel file from directory
		String path1 = System.getProperty("user.dir") + "\\Input-output-files\\Book1.xlsx";	
		file = new File(path1);
		fin = new FileInputStream(file);
		wb = new XSSFWorkbook(fin);
		sh = wb.getSheet("Output");
		
		for (int i = 2; i < 5; i++)										//Loop for storing manual input values to excel
		{
			row = sh.createRow(i);			
			row.createCell(1).setCellValue("Current Week");			//Manual value stored in excel
			row.createCell(2).setCellValue("Previous Week");	
			row.createCell(3).setCellValue("Week before Previous Week");	//Manual value stored in excel
		}
		for (int i = 3; i < 6; i++) 										//Loop for storing extracted values to excel
		{
			row = sh.createRow(i);
			row.createCell(1).setCellValue(week1);		//Storing extracted data in excel
			row.createCell(2).setCellValue(week2);
			row.createCell(3).setCellValue(week3);   	 //Storing extracted data in excel
		}	
											
		sh.autoSizeColumn(1);											//Resizing the columns
		sh.autoSizeColumn(2);											//Resizing the columns
		sh.autoSizeColumn(3);
		fout = new FileOutputStream(path1);								//Writing the output to Excel file using FileOutputStream
		wb.write(fout);
		fout.close();													//Closing the excel sheet
		
	}
	public static void writeExcel(String user) throws Exception {
		//Fetching excel file from directory
		String path1 = System.getProperty("user.dir") + "\\Input-output-files\\Book1.xlsx";	
		file = new File(path1);
		fin = new FileInputStream(file);
		wb = new XSSFWorkbook(fin);
		sh = wb.getSheet("Output");

			row = sh.createRow(0);
			row.createCell(1).setCellValue("User is");			//Manual value stored in excel

			row = sh.createRow(1);
			row.createCell(1).setCellValue(user);		//Storing extracted data in excel
		
			
		sh.autoSizeColumn(0);											//Resizing the columns
		sh.autoSizeColumn(1);											//Resizing the columns
		
		fout = new FileOutputStream(path1);								//Writing the output to Excel file using FileOutputStream
		wb.write(fout);
		fout.close();													//Closing the excel sheet
		
	}
	/*
	 * Closing browser
	 */
	public void quitBrowser() {
		reports.flush();
		Logger = reports.createTest("closing browser");
		Logger.log(Status.INFO, "closing browser");
		Logger.log(Status.PASS,"closing browser");
		System.out.println("\n closing web browser");
		driver.quit();
	}
}