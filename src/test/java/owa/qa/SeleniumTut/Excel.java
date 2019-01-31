package owa.qa.SeleniumTut;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Excel {

	public WebDriver driver = null;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void loginTest() throws Exception {
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Downloads\\DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		//Reading
		
		
		for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
			driver.get("http://thedemosite.co.uk/addauser.php");
	
			driver.findElement(By.name("username")).sendKeys(sheet.getRow(rowNum).getCell(0).getStringCellValue());
			driver.findElement(By.name("password")).sendKeys(sheet.getRow(rowNum).getCell(0).getStringCellValue());
			driver.findElement(By.name("FormsButton2")).click();
			
			driver.get("http://thedemosite.co.uk/login.php");
			
			driver.findElement(By.name("username")).sendKeys(sheet.getRow(rowNum).getCell(0).getStringCellValue());
			driver.findElement(By.name("password")).sendKeys(sheet.getRow(rowNum).getCell(0).getStringCellValue());
			driver.findElement(By.name("FormsButton2")).click();
			
			XSSFRow row = sheet.getRow(rowNum);
			XSSFCell cell = row.getCell(3);
			
			
			if (cell == null) {
				cell = row.createCell(3);
				cell.setCellValue(driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText());
			}
			
			
		}
			
		
		
		FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Admin\\Downloads\\DemoSiteDDT.xlsx");

		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();
		
		file.close();		
		
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}