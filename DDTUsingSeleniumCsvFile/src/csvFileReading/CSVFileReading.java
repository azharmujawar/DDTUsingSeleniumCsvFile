package csvFileReading;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Helper;
import au.com.bytecode.opencsv.CSVReader;

public class CSVFileReading {
	
     String CsvPath="D:\\Selenium Workspace\\DDTUsingSeleniumCsvFile\\CSV TestData\\CSVFile1.csv";
	WebDriver driver;

	@BeforeTest
	public void setUp() {

	driver=Helper.startBrowser("Google Chrome");
	driver.manage().window().maximize();

	driver.get("http://only-testing-blog.blogspot.com/2014/05/form.html");
	}

	@Test
	public void locatorsTestingBlog() throws Exception {
	CSVReader reader=new CSVReader(new FileReader(CsvPath));

	String[] csvCell;

	while((csvCell=reader.readNext())!=null) {
	String FName=csvCell[0];
	String LName=csvCell[1];
	String Email=csvCell[2];
	String Mnumber=csvCell[3];
	String CName=csvCell[4];

	driver.findElement(By.name("FirstName")).sendKeys(FName);
	driver.findElement(By.name("LastName")).sendKeys(LName);
	driver.findElement(By.name("EmailID")).sendKeys(Email);
	driver.findElement(By.name("MobNo")).sendKeys(Mnumber);
	driver.findElement(By.name("Company")).sendKeys(CName);

	Thread.sleep(10000);
	driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
	Thread.sleep(10000);
	driver.switchTo().alert().accept();
	}
	reader.close();

	}

	@AfterTest
	public void teardown() {
	driver.close();
	}
	}

	