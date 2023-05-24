package Assignment_Facebook_DDT;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Helper;
import au.com.bytecode.opencsv.CSVReader;

public class Assignment_facebook_DDT {
	
	
	 String CsvPath="D:\\Selenium Workspace\\DDTUsingSeleniumCsvFile\\CSV TestData\\FaceBook1.csv";
	WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {

	driver=Helper.startBrowser("Google Chrome");
	driver.manage().window().maximize();

	driver.get("https://www.facebook.com/");
	driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
	
	
	
	
	 Thread.sleep(3000);
	}
	@Test
	public void locatorsTestingBlog() throws Exception {
	CSVReader reader=new CSVReader(new FileReader(CsvPath));

	String[] csvCell;

	while((csvCell= reader.readNext())!=null) {
	String FName=csvCell[0];
	
	String LName=csvCell[1];
	
	
	String Email=csvCell[2];
	String pass=csvCell[3];

	WebElement fn=driver.findElement(By.name("firstname"));
	fn.sendKeys(FName);
	
	WebElement ln=driver.findElement(By.name("lastname"));
	ln.sendKeys(LName);
	
	WebElement em=driver.findElement(By.name("reg_email__"));
	em.sendKeys(Email);
	
	WebElement pas=driver.findElement(By.name("reg_passwd__"));
	pas.sendKeys(pass);
	
	driver.findElement(By.xpath("//*[contains(text(),'Male')]")).click();
	
	driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[11]/button[1]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[11]/button[1]")).click();
	
	
	WebElement age =driver.findElement(By.xpath("//*[@name='birthday_age']"));
	age.sendKeys("37");
	Thread.sleep(3000);
	driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[11]/button[1]")).click();
	Thread.sleep(10000);
	
	
	WebElement message=driver.findElement(By.xpath("//div[text()='No one else will see your date of birth. You can change this on your profile later.']"));
	
	String actual=message.getText();
	
	System.out.println("Actual message : "+actual);
	
	driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
	
	  fn.clear(); ln.clear(); em.clear(); pas.clear(); age.clear();
	 
	
	
	
	
	}
	reader.close();

	}

	@AfterTest
	public void teardown() {
	driver.close();
	}
	}

	