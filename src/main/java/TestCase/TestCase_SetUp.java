package TestCase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Base.Base;
import Pages.Filter;
import Pages.Home;
import Pages.Product;


public class TestCase_SetUp extends Base {
	@BeforeTest
	public void initialize() throws IOException, InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
		extend = new ExtentSparkReporter(System.getProperty("user.dir")+"////Report////"+name());
		System.out.println(System.getProperty("user.dir")+"////Report////"+name());
		report1 = new ExtentReports();
		report1.attachReporter(extend);
		report1.setSystemInfo("Environment", "QA");
		report1.setSystemInfo("OS", "Win11");
	}
	@Test(dataProvider="getdata")
	public void Availability(String material, String brand, String price, String pincode) throws Exception
	{
		String url=readProp("url");
		driver.get(url);
		//driver.get("https://www.titan.co.in/");
		test = report1.createTest("Validation of Product Availability");
		PageFactory.initElements(driver, Home.class);
    	Home.closeIcon();
		Home.MensWear();
		Home.NewArrival();
		Home.assertion();
		PageFactory.initElements(driver, Filter.class);
		Filter.Filters();
		Filter.Material(material);
		Filter.Brand(brand);
		PageFactory.initElements(driver, Product.class);
		Product.LatestWatch();
		Product.Pincode(pincode);
		Product.Check();
		Product.assert3();
 
	}

	@AfterTest
	public void terminate() throws InterruptedException{
		report1.flush();
		driver.quit();
	}
}
