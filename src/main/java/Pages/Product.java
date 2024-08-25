package Pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import Base.Base;

public class Product extends Base {
	@FindBy(xpath="(//*[@class='link'])[1]")
    static WebElement LatestWatch;
 
    @FindBy(xpath="(//*[@class='country-selector'])[3]")
    static WebElement CountryClick;
 
    @FindBy(xpath="//*[@class='border-0 pincode']")
    static WebElement Pincode;
 
    @FindBy(xpath="//button[@class='check-button js-delivery-check-btn btn btn-large tw-btn-tertiary']")
    static WebElement Check;
 
    public static void assert3() {
    		String expttitle=driver.getTitle();
    		String actual="Buy Online Fastrack Stunnerse Quartz Analog Grey Dial Stainless Steel Strap Watch for Guys - 3305sm02 | Titan";
    		AssertString1(expttitle,actual);
    		System.out.println("Not Equal");
    	}
   
    public static void LatestWatch() throws InterruptedException
    {
        Thread.sleep(3000);
        test.log(Status.INFO,"Click on Latest Watch diplayed");
        LatestWatch.click();

    }
    public static void Pincode(String pin) throws InterruptedException
    {
        Thread.sleep(3000);
        test.log(Status.PASS,"Editing Pin Code");
        Pincode.sendKeys(Keys.CONTROL+"A");
        Thread.sleep(3000);
        Pincode.sendKeys(pin);
    }
    public static void  Check() throws InterruptedException
    {  
    	Actions a = new Actions(driver);
        a.moveToElement(Check);
        test.log(Status.INFO,"Clicking Check");
        Thread.sleep(3000);
        Check.click();
    }
}
	
	
	
	
	
	
	
	

