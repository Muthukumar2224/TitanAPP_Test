package Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import Base.Base;

public class Home extends Base{
	

@FindBy(xpath="(//*[@class='default-img pl-0'])[1]")
static WebElement tab;

@FindBy(xpath="//*[@id=\"watches-for-men\"]")
static WebElement MensWear;

@FindBy(xpath="(//*[@id='men-watches-new-arrivals'])[2]")
static WebElement NewArrival;

@FindBy(xpath="//*[@id=\"refinement-content-brands\"]/ul/li[1]/button")
static WebElement Brand;

@FindBy(xpath="//*[@id=\"loginModal\"]/div/div/button[2]/span")
static WebElement closeIcon;

public static void assertion()
{
	  String exp=driver.getTitle();
	  String actual="Buy Watches for Men Online at the Best Price | Titan";
	  AssertString(exp,actual);
	  System.out.println("Title Validated");
}

public static void closeIcon() {
	Base.Click(closeIcon);
}
public static void MensWear()
{
	test.log(Status.INFO,"Click on MEN Tab");
	Base.Click(MensWear);
}
public static void NewArrival()
{
	test.log(Status.PASS,"Click on 'New Arrivals'");
	Base.Click(NewArrival);
}
}
