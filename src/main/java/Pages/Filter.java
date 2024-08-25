package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import Base.Base;

public class Filter  extends Base{
	@FindBy(xpath="//*[@class='filter-hide-options filter-show']")
    static WebElement Filters;
 
    @FindBy(xpath="//*[@class='price-input price-input-max w-100']")
    static WebElement MaxValue;
 
    @FindBy(xpath="(//*[@class='filter-more-options filter-more'])[1]")
    static WebElement Material;
 
    @FindBy(xpath="//*[@class='refinement-list']//li//*[@data-filter-value='Titan']")
    static WebElement Brand;
    public static void Filters()
    {
        test.log(Status.INFO,"Click on Filter button");
        Base.Click(Filters);
    }
   
 
    public static void Material(String material)
    {
        WebElement e = driver.findElement(By.xpath("//*[@id='refinement-content-strap-material']//li//*[@data-filter-value='"+material+"']"));
        Actions a = new Actions(driver);
        a.moveToElement(e);
        test.log(Status.PASS,"Selecting Material Type");
        Material.click();
        e.click();
    }
    public static void Brand(String material) throws InterruptedException
    {
        Thread.sleep(3000);
        WebElement e = driver.findElement(By.xpath("//*[@class='refinement-list']//li//*[@data-filter-value='"+material+"']"));
        Actions a = new Actions(driver);
        a.moveToElement(e);
       
        test.log(Status.PASS,"Selecting Brand");
        e.click();
    }
}
	
	
	
	
	
	
	
	
	
	
