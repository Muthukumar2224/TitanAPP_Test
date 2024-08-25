package Base;

import java.awt.AWTException;
import java.io.FileInputStream;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.function.Function;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {
	public static ExtentReports report1 = new ExtentReports();
	protected static ExtentSparkReporter extend;
	protected static ExtentTest test;
	public static WebDriver driver;
	static WebElement element;
	public static List<String> testData = new ArrayList<String>();
	ExtentReports report;
	protected static JavascriptExecutor js = (JavascriptExecutor) driver;
	public String readProp(String key) {
		String filepath = System.getProperty("user.dir") + "\\src\\TestData\\config.properties";
		String value=null;
		try {
			FileInputStream file=new FileInputStream(filepath);
			 Properties prop = new Properties();
		     prop.load(file);
		     value=prop.getProperty(key);
		     System.out.println(key+" fetched successful");
			
		}catch(Exception e) {
			System.out.println(e);
			System.out.println(key+" not fetched successful");
		}
		return value;
	}

	public static void SendKeys(WebElement element, Object a) {
		try {
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
			w.until(ExpectedConditions.visibilityOf(element));
			element.click();
			element.sendKeys((String) a);
			System.out.println("");
		} catch (Exception e) {
			System.out.println(e);

		}
	}

	public static void Click(final WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		try {
			wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return element;
				}

			});
			element.click();
		} catch (Exception e) {	
			System.out.println(e);
			
		}
	}

	public static void AssertString(String req, String res) {

		Assert.assertEquals(req, res);
		System.out.println("Assert two String Equal : " + res);
	}
	public static void AssertString1(String req, String res) {

		Assert.assertNotEquals(req, res);
		System.out.println("Assert two String Not Equal : " + res);
	}

	public static void Alert() throws AWTException {
		driver.switchTo().alert().dismiss();

	}

	@DataProvider
	public static String[][] getdata() {
		String[][] aa = null;
		try {
			int columncount = 0;
			int rowcount = 0;
			String filepath = System.getProperty("user.dir") + "\\Data.xlsx";
			FileInputStream fis = new FileInputStream(filepath);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			Row row = sheet.getRow(0);
			rowcount = sheet.getPhysicalNumberOfRows();
			columncount = row.getPhysicalNumberOfCells();
			System.out.print(rowcount + " " + columncount);
			aa = new String[rowcount][columncount];
			for (int i = 0; i < rowcount; i++) {
				for (int j = 0; j < columncount; j++) {
					Row row1 = sheet.getRow(i);
					row1.getCell(j);
					Cell cell = row1.getCell(j);
					if (cell.getCellType() == CellType.STRING) {
						String data = cell.getStringCellValue();
						aa[i][j] = data;
					} else if (cell.getCellType() == CellType.NUMERIC) {
						String data = String.valueOf(cell.getNumericCellValue());
						aa[i][j] = data;
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aa;
	}

	public static String name() {

		String pattern = "dd.MM.yyyy-hh.mm";
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat(pattern);
		return f.format(d);
	}
}
