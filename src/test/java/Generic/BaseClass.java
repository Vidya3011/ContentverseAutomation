package Generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;


import io.github.bonigarcia.wdm.WebDriverManager;

//NishaR codes

public class BaseClass {

	public static WebDriver driver;
	public static Alert a;
	public static Actions a1;
	public static Robot r;
	public static JavascriptExecutor js;
	public static Select sl;
	public static TakesScreenshot ts;
	

	// 1.

	public static void StartTime() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime = sdf.format(d);
		System.out.println("Test Execution Start Time :" + currentDateTime);
	}

	public static void loadBrowser(String browserName) {

		if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			
			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * "C:\\Users\\nisha.r\\Downloads\\chromedriver-win64\\chromedriver.exe"); //
			 * driver = new ChromeDriver();
			 */
			  ChromeOptions options = new ChromeOptions();
			// options.addArguments("--headless");
			// options.addArguments("--disable-extensions");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-infobars");
			options.setExperimentalOption("useAutomationExtension", false);

			driver = new ChromeDriver(options);
			Reporter.log("Chrome driver launched successfull");

		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			Reporter.log("Edge driver launched successfull");

		} else if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else {
			Reporter.log("we do not support this browser", true);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	// 2.
	public static void launchUrl() {
		driver.get("http://10.4.10.60:8080/CVWeb/cvLgn");
		Reporter.log("EWA URL launched successfull");
	}

	public static void launch47Url() {
		driver.get("http://10.4.10.21:8080/CVWeb/cvLgn");
		Reporter.log("EWA URL launched successfull");
	}

	// 3.
	public static void launchLocalUrl() {
		driver.get("http://10.4.8.10:8080/CVWeb/cvLgn");
		Reporter.log("Browser launch with local URL", true);
	}

	public static void launchLocalUrlRnisha() {
		driver.get("http://10.4.8.14:8080/CVWeb/cvLgn");
		Reporter.log("Browser launch with local URL", true);
	}

	// 4.
	public static void launchCreatedocUrl() {
		driver.get("http://10.4.8.18:8080/CVWeb/cvLgn");
		Reporter.log("Browser launch with Testing Create document URL", true);
	}

	//////////////////////////////////// ====================================================NishaR

	public static void loginRNISHA47() throws Exception {
		Thread.sleep(4000);

		WebElement UserName = driver.findElement(By.xpath("//input[@id='userName']"));
		Reporter.log("Scenario 01: Log into EWA");
		Reporter.log("Enter valid user name into username field");

		UserName.sendKeys("nisha");
		Thread.sleep(3000);
		driver.findElement(By.id("loginPassword")).sendKeys("syntax@10");
		Reporter.log("Enter valid password into password field", true);
		WebElement room = driver.findElement(By.xpath("//select[@id='rooms']"));
		Select sel = new Select(room);
		sel.selectByIndex(1);

		// sel.selectByVisibleText(ExcelLogin(1, 2));
		Thread.sleep(4000);
		Reporter.log("Select a Room", true);
		try {
			WebElement Captch = driver.findElement(By.xpath("//*[@id='image']"));
			WebElement enterCaptch = driver.findElement(By.xpath("//*[@id='captchaInput']"));
			enterCaptch.sendKeys(Captch.getText());
		} catch (Exception e) {
			System.out.println("Captcha is not there");
		}
		Reporter.log("Click Login button");
		WebElement LoginBTN = driver.findElement(By.id("submitid"));
		jsclick(LoginBTN);
		Thread.sleep(3000);
		try {

			WebElement sessiomsg = driver.findElement(By.cssSelector("#cvModelLoginValidationMessage"));
			WebElement sessiomsgOK = driver.findElement(By.id("cvModelLoginValidationOk"));
			if (sessiomsg.isDisplayed()) {
				Reporter.log(
						"Session for user is already active.Do you want to create new session? dialog box displayed User click on OK button,");
				jsclick(sessiomsgOK);
			}
		} catch (NoSuchElementException e) {
			Reporter.log("Session message not appeared");
		}
	}

	public static void loginCVS() throws Exception {
		Thread.sleep(4000);

		WebElement UserName = driver.findElement(By.xpath("//input[@id='userName']"));
		Reporter.log("Scenario 01: Log into EWA");
		Reporter.log("Enter valid user name into username field");

		UserName.sendKeys(readFromExLogin(2, 0));
		Thread.sleep(3000);
		driver.findElement(By.id("loginPassword")).sendKeys(readFromExLogin(2, 1));
		Reporter.log("Enter valid password into password field", true);
		WebElement room = driver.findElement(By.xpath("//select[@id='rooms']"));
		Select sel = new Select(room);
		sel.selectByVisibleText(ExcelLogin(1, 2));
		Thread.sleep(4000);
		Reporter.log("Select a Room", true);
		try {
			WebElement Captch = driver.findElement(By.xpath("//*[@id='image']"));
			WebElement enterCaptch = driver.findElement(By.xpath("//*[@id='captchaInput']"));
			enterCaptch.sendKeys(Captch.getText());
		} catch (Exception e) {
			System.out.println("Captcha is not there");
		}
		Reporter.log("Click Login button");
		WebElement LoginBTN = driver.findElement(By.id("submitid"));
		jsclick(LoginBTN);
		Thread.sleep(3000);
		try {

			WebElement sessiomsg = driver.findElement(By.cssSelector("#cvModelLoginValidationMessage"));
			WebElement sessiomsgOK = driver.findElement(By.id("cvModelLoginValidationOk"));
			if (sessiomsg.isDisplayed()) {
				Reporter.log(
						"Session for user is already active.Do you want to create new session? dialog box displayed User click on OK button,");
				jsclick(sessiomsgOK);
			}
		} catch (NoSuchElementException e) {
			Reporter.log("Session message not appeared");
		}
	}

	public static void loginSQL2022() throws Exception {

		WebElement UserName = driver.findElement(By.xpath("//input[@id='userName']"));
		Thread.sleep(3000);
		UserName.sendKeys(readFromExLogin(2, 0));
		driver.findElement(By.id("loginPassword")).sendKeys(readFromExLogin(2, 1));
		WebElement room = driver.findElement(By.xpath("//select[@id='rooms']"));
		Select sel = new Select(room);
		sel.selectByVisibleText(readFromExLogin(3, 2));// SQLroom 3,2
		Thread.sleep(3000);

		WebElement LoginBTN = driver.findElement(By.id("submitid"));
		jsclick(LoginBTN);
		Thread.sleep(3000);

		try {
			WebElement sessiomsg = driver.findElement(By.cssSelector("#cvModelLoginValidationMessage"));
			WebElement sessiomsgOK = driver.findElement(By.id("cvModelLoginValidationOk"));
			if (sessiomsg.isDisplayed()) {
				Reporter.log(
						"Session for user is already active.Do you want to create new session? dialog box displayed User click on OK button,");
				jsclick(sessiomsgOK);
			}
		} catch (NoSuchElementException e) {
			Reporter.log("Session message not appeared");
		}
	}

	public static void loginSQL2022RAM() throws Exception {

		WebElement UserName = driver.findElement(By.xpath("//input[@id='userName']"));
		Thread.sleep(4000);
		UserName.sendKeys("rnisha");
		Thread.sleep(4000);
		driver.findElement(By.id("loginPassword")).sendKeys(readFromExLogin(2, 1));
		WebElement room = driver.findElement(By.xpath("//select[@id='rooms']"));
		Select sel = new Select(room);
		sel.selectByVisibleText(readFromExLogin(3, 2));// SQLroom 3,2
		Thread.sleep(3000);
		WebElement LoginBTN = driver.findElement(By.id("submitid"));
		jsclick(LoginBTN);
		Thread.sleep(3000);
		try {
			WebElement sessiomsg = driver.findElement(By.cssSelector("#cvModelLoginValidationMessage"));
			WebElement sessiomsgOK = driver.findElement(By.id("cvModelLoginValidationOk"));
			if (sessiomsg.isDisplayed()) {
				Reporter.log(
						"Session for user is already active.Do you want to create new session? dialog box displayed User click on OK button,");
				jsclick(sessiomsgOK);
			}
		} catch (NoSuchElementException e) {
			Reporter.log("Session message not appeared");
		}
	}

	public static void loginCaseSensitiveRoom() throws Exception {

		WebElement UserName = driver.findElement(By.xpath("//input[@id='userName']"));
		Thread.sleep(3000);
		UserName.sendKeys("vwadmin");
		driver.findElement(By.id("loginPassword")).sendKeys("vw");
		WebElement room = driver.findElement(By.xpath("//select[@id='rooms']"));
		a1 = new Actions(driver);
		a1.moveToElement(room).click().build().perform();
		WebElement roomCV = driver.findElement(By.xpath("//*[@id=\"rooms\"]/option[5]"));
		roomCV.click();
		Thread.sleep(4000);
		Reporter.log("Select a Room", true);
		WebElement LoginBTN = driver.findElement(By.id("submitid"));
		jsclick(LoginBTN);
		Thread.sleep(3000);
		try {
			WebElement sessiomsg = driver.findElement(By.cssSelector("#cvModelLoginValidationMessage"));
			WebElement sessiomsgOK = driver.findElement(By.id("cvModelLoginValidationOk"));
			if (sessiomsg.isDisplayed()) {
				Reporter.log(
						"Session for user is already active.Do you want to create new session? dialog box displayed User click on OK button,");
				jsclick(sessiomsgOK);
			}
		} catch (NoSuchElementException e) {

			Reporter.log("Session message not appeared");
		}
	}

	public static void LogRamUser() throws Exception {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("ram");
		driver.findElement(By.id("loginPassword")).sendKeys(TodoListExcel(2, 3));
		Reporter.log("Enter valid password into password field", true);
		WebElement room = driver.findElement(By.xpath("//select[@id='rooms']"));
		Select sel = new Select(room);
		sel.selectByVisibleText(ExcelLogin(1, 2));
		Thread.sleep(4000);
		Reporter.log("Select a Room", true);
		WebElement Login = driver.findElement(By.id("submitid"));
		jsclick(Login);
		Thread.sleep(3000);
		try {
			WebElement sessiomsg = driver.findElement(By.cssSelector("#cvModelLoginValidationMessage"));
			WebElement sessiomsgOK = driver.findElement(By.id("cvModelLoginValidationOk"));
			if (sessiomsg.isDisplayed()) {
				jsclick(sessiomsgOK);
			}
		} catch (NoSuchElementException e) {
			Reporter.log("Login without msg");
		}
	}

	public static void LogInAdmin() throws Exception {
		Reporter.log("Log into EWA");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("cvadmin");//
		Reporter.log("Enter valid username into username text box");
		Thread.sleep(3000);
		driver.findElement(By.id("loginPassword")).sendKeys("vw");//readFromExLogin(3, 1)
		Reporter.log("Enter valid password into password text box");
		Thread.sleep(2000);

		WebElement room = driver.findElement(By.xpath("//select[@id='rooms']"));
		Select sel = new Select(room);
		sel.selectByIndex(3);
		
		//sel.selectByVisibleText(ExcelLogin(1, 2));
		Thread.sleep(4000);
		Reporter.log("Select a Room", true);

		Reporter.log("Click on Login button");
		try {
			WebElement Captch = driver.findElement(By.xpath("//*[@id=\"image\"]"));
			WebElement enterCaptch = driver.findElement(By.xpath("//*[@id=\"captchaInput\"]"));
			enterCaptch.sendKeys(Captch.getText());
		} catch (Exception e) {
			System.out.println("Captcha is not there");
		}
		Thread.sleep(3000);
		WebElement LoginBTN = driver.findElement(By.id("submitid"));
		jsclick(LoginBTN);

		Thread.sleep(3000);
		try {
			WebElement sessiomsg = driver.findElement(By.cssSelector("#cvModelLoginValidationMessage"));
			WebElement sessiomsgOK = driver.findElement(By.id("cvModelLoginValidationOk"));
			if (sessiomsg.isDisplayed()) {
				Reporter.log(
						"Session for user is already active.Do you want to create new session? dialog box displayed User click on OK button,");
				jsclick(sessiomsgOK);
			}
		} catch (NoSuchElementException e) {
			Reporter.log("Session already activate message not appeared");
		}
		Reporter.log("User logged in successfully...");
	}

	public static void loginLocalCVS() throws Exception {
		Reporter.log("Enter valid user name into user name field");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(readFromExLogin(4, 0));
		Reporter.log("Enter valid password into password field");
		driver.findElement(By.id("loginPassword")).sendKeys(readFromExLogin(4, 1));
		Reporter.log("Selects Local server NishaRoom");
		WebElement room = driver.findElement(By.xpath("//select[@id='rooms']"));
		a1 = new Actions(driver);
		Reporter.log("Click on Login button");
		a1.moveToElement(room).click().build().perform();
		// WebElement roomCV =
		// driver.findElement(By.xpath("//option[text()='NishaRoom.NishaRoom']"));
		WebElement roomCV = driver.findElement(By.xpath("//option[text()='NishaRoom.NishaRoom']"));
		roomCV.click();
		Reporter.log("User logged into EWA successfully...");
		WebElement LoginBTN = driver.findElement(By.id("submitid"));
		jsclick(LoginBTN);
		Thread.sleep(3000);
		try {
			WebElement sessiomsg = driver.findElement(By.cssSelector("#cvModelLoginValidationMessage"));
			WebElement sessiomsgOK = driver.findElement(By.id("cvModelLoginValidationOk"));
			if (sessiomsg.isDisplayed()) {
				jsclick(sessiomsgOK);
			}
		} catch (NoSuchElementException e) {
			Reporter.log("Login without Session message");
		}
	}

	/////////////////////////////////////////////////////////////////////////////////// NishaR//////////////////////////////

	// Dipak EWA Baseclass *************//

	// 2.
	/*
	 * public static void launchUrl() throws Exception { driver.get(ExcelLogin(1,
	 * 3)); Reporter.log("Browser launch with Testing URL", true); }
	 */

	// 3.
	// Dipak EWA Baseclass *************//

	// 3. User Login Credential

	public static void LogDipakUser() throws Exception {

		driver.findElement(By.xpath("//input[@id='userName']")).clear();
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(ExcelLogin(1, 0));
		Thread.sleep(1000);
		driver.findElement(By.id("loginPassword")).clear();
		Reporter.log("Enter valid username into username field", true);
		driver.findElement(By.id("loginPassword")).sendKeys(ExcelLogin(1, 1));
		Thread.sleep(1000);
		Reporter.log("Enter valid password into password field", true);
		WebElement room = driver.findElement(By.xpath("//select[@id='rooms']"));
		Select sel = new Select(room);
		sel.selectByVisibleText(ExcelLogin(1, 2));// Here you can chage
													// driver.findElement(By.xpath("//select[@id='rooms']")) name from
													// Excel sheet
		Reporter.log("Select a room", true);
		Thread.sleep(1000);
		try {
			WebElement Captch = driver.findElement(By.xpath("//*[@id=\"image\"]"));
			WebElement enterCaptch = driver.findElement(By.xpath("//*[@id=\"captchaInput\"]"));
			enterCaptch.sendKeys(Captch.getText());
		} catch (Exception e) {
			// Session message is not displayed
		}
		driver.findElement(By.id("submitid")).click();
		Reporter.log("Click on the Login button", true);
		try {
			WebElement sessionmsg = driver.findElement(By.xpath("//*[@id=\"cvModelLoginValidationMessage\"]"));
			WebElement sessionmsgYes = driver.findElement(By.xpath(" //button[@id='cvModelLoginValidationOk']"));
			Reporter.log(sessionmsg.getText() + "this message is displayed", true);
			sessionmsgYes.click();
			Thread.sleep(2000);
			Reporter.log("Click on the Yes button", true);

		} catch (Exception e1) {
			// Session message is not displayed
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.alertIsPresent());
			acceptAlert();
		} catch (Exception e) {
			// Database alert is not present
		}
	}

	public static void Already_Logged_User() throws Exception {

		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(ExcelLogin(1, 0));
		Reporter.log("Enter valid username into username field", true);
		driver.findElement(By.id("loginPassword")).sendKeys(ExcelLogin(1, 1));
		Reporter.log("Enter valid password into password field", true);
		WebElement room = driver.findElement(By.xpath("//select[@id='rooms']"));
		Select sel = new Select(room);
		sel.selectByVisibleText(ExcelLogin(1, 2));
		Reporter.log("Select a room", true);
		Thread.sleep(2000);
		try {
			WebElement Captch = driver.findElement(By.xpath("//*[@id=\"image\"]"));
			WebElement enterCaptch = driver.findElement(By.xpath("//*[@id=\"captchaInput\"]"));
			enterCaptch.sendKeys(Captch.getText());
		} catch (Exception e) {
			// Session message is not displayed
		}
		driver.findElement(By.id("submitid")).click();
		Reporter.log("Click on the Login button", true);
		try {
			WebElement sessionmsg = driver.findElement(By.xpath("//*[@id=\"cvModelLoginValidationMessage\"]"));
			WebElement sessionmsgNO = driver.findElement(By.xpath("//*[@id=\"cvModelLoginValidationCancel\"]"));
			Reporter.log(sessionmsg.getText() + "this message is displayed", true);
			sessionmsgNO.click();
			Thread.sleep(2000);
			Reporter.log("Click on the No button", true);

		} catch (Exception e1) {
			// Session message is not displayed
		}
	}

	public static void LoginAdminUser() throws Exception {

		driver.findElement(By.xpath("//input[@id='userName']")).clear();
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(ExcelLogin(3, 0));
		driver.findElement(By.id("loginPassword")).clear();
		Reporter.log("Enter valid username into username field", true);
		driver.findElement(By.id("loginPassword")).sendKeys(ExcelLogin(1, 1));
		Reporter.log("Enter valid password into password field", true);
		WebElement room = driver.findElement(By.xpath("//select[@id='rooms']"));
		Select sel = new Select(room);
		sel.selectByVisibleText(ExcelLogin(1, 2));// Here you can chage
													// driver.findElement(By.xpath("//select[@id='rooms']")) name from
													// Excel sheet
		Reporter.log("Select a room", true);
		Thread.sleep(2000);
		try {
			WebElement Captch = driver.findElement(By.xpath("//*[@id=\"image\"]"));
			WebElement enterCaptch = driver.findElement(By.xpath("//*[@id=\"captchaInput\"]"));
			enterCaptch.sendKeys(Captch.getText());
		} catch (Exception e) {
			// Session message is not displayed
		}
		driver.findElement(By.id("submitid")).click();
		Reporter.log("Click on the Login button", true);
		try {
			WebElement sessionmsg = driver.findElement(By.xpath("//*[@id=\"cvModelLoginValidationMessage\"]"));
			WebElement sessionmsgYes = driver.findElement(By.xpath(" //button[@id='cvModelLoginValidationOk']"));
			Reporter.log(sessionmsg.getText() + "this message is displayed", true);
			sessionmsgYes.click();
			Thread.sleep(2000);
			Reporter.log("Click on the Yes button", true);

		} catch (Exception e1) {
			// Session message is not displayed
		}
	}

	public static void Login_Workflow_User() throws Exception {

		driver.findElement(By.xpath("//input[@id='userName']")).clear();
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(ExcelLogin(2, 0));
		driver.findElement(By.id("loginPassword")).clear();
		Reporter.log("Enter valid username into username field", true);
		driver.findElement(By.id("loginPassword")).sendKeys(ExcelLogin(1, 1));
		Reporter.log("Enter valid password into password field", true);
		WebElement room = driver.findElement(By.xpath("//select[@id='rooms']"));
		Select sel = new Select(room);
		sel.selectByVisibleText(ExcelLogin(1, 2));// Here you can chage
													// driver.findElement(By.xpath("//select[@id='rooms']")) name from
													// Excel sheet
		Reporter.log("Select a room", true);
		Thread.sleep(2000);
		try {
			WebElement Captch = driver.findElement(By.xpath("//*[@id=\"image\"]"));
			WebElement enterCaptch = driver.findElement(By.xpath("//*[@id=\"captchaInput\"]"));
			enterCaptch.sendKeys(Captch.getText());
		} catch (Exception e) {
			// Session message is not displayed
		}
		driver.findElement(By.id("submitid")).click();
		Reporter.log("Click on the Login button", true);
		try {
			WebElement sessionmsg = driver.findElement(By.xpath("//*[@id=\"cvModelLoginValidationMessage\"]"));
			WebElement sessionmsgYes = driver.findElement(By.xpath(" //button[@id='cvModelLoginValidationOk']"));
			Reporter.log(sessionmsg.getText() + "this message is displayed", true);
			sessionmsgYes.click();
			Thread.sleep(2000);
			Reporter.log("Click on the Yes button", true);

		} catch (Exception e1) {
			// Session message is not displayed
		}
	}

	// 4. All POM datadriven

	public static String ExcelLogin(int rowNo, int cellNo) throws Exception {
		File src = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
			XSSFSheet s = wb.getSheet("Login");
			XSSFRow row = s.getRow(rowNo);
			XSSFCell cll = row.getCell(cellNo);
			String cellType = cll.getStringCellValue();
			return cellType;
		}
	}

	public static String CountexcelRead(int rowNo, int cellNo) throws IOException {
		File f = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
			XSSFSheet mySht = wb.getSheet("Login");
			XSSFRow row = mySht.getRow(rowNo);
			XSSFCell cell = row.getCell(cellNo);
			CellType cellType = cell.getCellType();
			String text = "";
			double d = cell.getNumericCellValue();
			long l = (long) d;
			return text = String.valueOf(l);
		}
	}

	// BatchIndexing datadriven

	public static String BatchIndexing_excelRead(int rowNo, int cellNo) throws Exception {

		File src = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
			XSSFSheet s = wb.getSheet("BatchIndexing");
			XSSFRow row = s.getRow(rowNo);
			XSSFCell cll = row.getCell(cellNo);
			String cellType = cll.getStringCellValue();
			return cellType;
		}
	}

	// Datadriven CustomColumns

	public static String CustomColumns_excelRead(int rowNo, int cellNo) throws Exception {
		File src = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
			XSSFSheet s = wb.getSheet("Custom Columns");
			XSSFRow row = s.getRow(rowNo);
			XSSFCell cll = row.getCell(cellNo);
			String cellType = cll.getStringCellValue();
			return cellType;
		}

	}

	// Datadriven Document Context

	public static String DocumentsContext_excelRead(int rowNo, int cellNo) throws Exception {
		File src = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
			XSSFSheet s = wb.getSheet("DocumentsContext");
			XSSFRow row = s.getRow(rowNo);
			XSSFCell cll = row.getCell(cellNo);
			String cellType = cll.getStringCellValue();
			return cellType;
		}

	}

	// Language datadriven

	public String Language_excelRead(int rowNo, int cellNo) throws Exception {

		File src = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
			XSSFSheet s = wb.getSheet("Language");
			XSSFRow row = s.getRow(rowNo);
			XSSFCell cll = row.getCell(cellNo);
			String cellType = cll.getStringCellValue();
			return cellType;
		}
	}

	// Datadriven My preference

	public static String MyPreferences_excelRead(int rowNo, int cellNo) throws Exception {
		File src = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
			XSSFSheet s = wb.getSheet("MyPreferences");
			XSSFRow row = s.getRow(rowNo);
			XSSFCell cll = row.getCell(cellNo);
			String cellType = cll.getStringCellValue();
			return cellType;
		}
	}

	// Datadriven Security
	public static String Security_excelRead(int rowNo, int cellNo) throws Exception {
		File src = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
			XSSFSheet s = wb.getSheet("Security");
			XSSFRow row = s.getRow(rowNo);
			XSSFCell cll = row.getCell(cellNo);
			String cellType = cll.getStringCellValue();
			return cellType;
		}
	}

	// Special characters datadriven

	public String Specialchar_excelRead(int rowNo, int cellNo) throws Exception {

		File src = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
			XSSFSheet s = wb.getSheet("SpecialCharFiles");
			XSSFRow row = s.getRow(rowNo);
			XSSFCell cll = row.getCell(cellNo);
			String cellType = cll.getStringCellValue();
			return cellType;
		}
	}

	// Template characters datadriven

	public String Templates_excelRead(int rowNo, int cellNo) throws Exception {

		File src = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
			XSSFSheet s = wb.getSheet("Templates");
			XSSFRow row = s.getRow(rowNo);
			XSSFCell cll = row.getCell(cellNo);
			String cellType = cll.getStringCellValue();
			return cellType;
		}
	}
	// Document version datadriven

	public String DocumentVersion_excelRead(int rowNo, int cellNo) throws Exception {

		File src = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
			XSSFSheet s = wb.getSheet("DocumentVersion");
			XSSFRow row = s.getRow(rowNo);
			XSSFCell cll = row.getCell(cellNo);
			String cellType = cll.getStringCellValue();
			return cellType;
		}
	}

	// 5. Main Short Element

	// 1.

	public static void Refresh_Button() throws InterruptedException {
		Thread.sleep(4000);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"homeMenuBtn\"]/img"));
		movingclkElement(element);
		try {
			WebElement element1 = driver.findElement(By.xpath("//*[@id=\"messageButtonNo27\"]"));
			movingclkElement(element1);
		} catch (Exception e) {
			// Error not present
		}
	}

	public static void LogInAdminSQL() throws Exception {

		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(readFromExLogin(3, 0));
		driver.findElement(By.id("loginPassword")).sendKeys(readFromExLogin(3, 1));
		WebElement room = driver.findElement(By.xpath("//select[@id='rooms']"));
		a1 = new Actions(driver);
		a1.moveToElement(room).click().build().perform();
		WebElement roomCV = driver.findElement(By.xpath("//*[@id=\"rooms\"]/option[4]"));
		roomCV.click();
		WebElement LoginBTN = driver.findElement(By.id("submitid"));
		jsclick(LoginBTN);
		Thread.sleep(3000);
		try {
			WebElement sessiomsg = driver.findElement(By.cssSelector("#cvModelLoginValidationMessage"));
			WebElement sessiomsgOK = driver.findElement(By.id("cvModelLoginValidationOk"));
			if (sessiomsg.isDisplayed()) {
				jsclick(sessiomsgOK);
			}
		} catch (NoSuchElementException e) {
			Reporter.log("Login without msg");
		}

	}

	// 4.
	public static void VerifyloginCVS() throws Exception {

		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(ExcelLogin(1, 0));
		Reporter.log("Enter valid username into username field", true);
		driver.findElement(By.id("loginPassword")).sendKeys(ExcelLogin(1, 1));
		Reporter.log("Enter valid password into password field", true);
		WebElement room = driver.findElement(By.xpath("//select[@id='rooms']"));
		Select sel = new Select(room);
		sel.selectByVisibleText(ExcelLogin(1, 2));
		Reporter.log("Select a room", true);
		try {
			WebElement Captch = driver.findElement(By.xpath("//*[@id=\"image\"]"));
			WebElement enterCaptch = driver.findElement(By.xpath("//*[@id=\"captchaInput\"]"));
			enterCaptch.sendKeys(Captch.getText());
		} catch (Exception e) {
			// Session message is not displayed
		}
		driver.findElement(By.id("submitid")).click();
		Reporter.log("Click on the Login button", true);
		try {
			WebElement session_message = driver.findElement(By.xpath("//*[@id=\"cvModelLoginValidationMessage\"]"));
			WebElement sessionmsgYes = driver.findElement(By.xpath(" //button[@id='cvModelLoginValidationOk']"));
			Reporter.log(session_message.getText() + "this message is displayed", true);
			sessionmsgYes.click();
			Thread.sleep(4000);
			Reporter.log("Click on the Yes button", true);

		} catch (Exception e1) {
			// Session message is not displayed
		}
	}

	// 5.
	public static void loginCVSTest() throws Exception {

		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(ExcelLogin(1, 0));
		Reporter.log("Enter valid username into username field", true);
		driver.findElement(By.id("loginPassword")).sendKeys(ExcelLogin(1, 1));
		Reporter.log("Enter valid password into password field", true);
		WebElement room = driver.findElement(By.xpath("//select[@id='rooms']"));
		Select sel = new Select(room);
		sel.selectByVisibleText(ExcelLogin(2, 2));
		Reporter.log("Select a room", true);
		try {
			WebElement Captch = driver.findElement(By.xpath("//*[@id=\"image\"]"));
			WebElement enterCaptch = driver.findElement(By.xpath("//*[@id=\"captchaInput\"]"));
			enterCaptch.sendKeys(Captch.getText());
		} catch (Exception e) {
			// Session message is not displayed
		}
		driver.findElement(By.id("submitid")).click();
		Reporter.log("Click on the Login button", true);
		try {
			WebElement session_message = driver.findElement(By.xpath("//*[@id=\"cvModelLoginValidationMessage\"]"));
			WebElement sessionmsgYes = driver.findElement(By.xpath(" //button[@id='cvModelLoginValidationOk']"));
			Reporter.log(session_message.getText() + "this message is displayed", true);
			sessionmsgYes.click();
			Thread.sleep(4000);
			Reporter.log("Click on the Yes button", true);

		} catch (Exception e1) {
			// Session message is not displayed
		}
	}
	// 6. Login admin

	public static void loginadminuser() throws Exception {

		driver.findElement(By.xpath("//input[@id='userName']")).clear();
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(ExcelLogin(3, 0));
		driver.findElement(By.id("loginPassword")).clear();
		Reporter.log("Enter valid username into username field", true);
		driver.findElement(By.id("loginPassword")).sendKeys(ExcelLogin(1, 1));
		Reporter.log("Enter valid password into password field", true);
		WebElement room = driver.findElement(By.xpath("//select[@id='rooms']"));
		Select sel = new Select(room);
		sel.selectByVisibleText(ExcelLogin(1, 2));// Here you can chage Room name from Excel sheet
		Reporter.log("Select a room", true);
		try {
			WebElement Captch = driver.findElement(By.xpath("//*[@id=\"image\"]"));
			WebElement enterCaptch = driver.findElement(By.xpath("//*[@id=\"captchaInput\"]"));
			enterCaptch.sendKeys(Captch.getText());
		} catch (Exception e) {
			// Session message is not displayed
		}
		driver.findElement(By.id("submitid")).click();
		Reporter.log("Click on the Login button", true);
		try {
			WebElement session_message = driver.findElement(By.xpath("//*[@id=\"cvModelLoginValidationMessage\"]"));
			WebElement sessionmsgYes = driver.findElement(By.xpath(" //button[@id='cvModelLoginValidationOk']"));
			Reporter.log(session_message.getText() + "this message is displayed", true);
			sessionmsgYes.click();
			Thread.sleep(4000);
			Reporter.log("Click on the Yes button", true);

		} catch (Exception e1) {
			// Session message is not displayed
		}
	}

	public static void DiffrentUser() {

		String credential = getCreddential().get("Nisha.r");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(credential.split(":")[0]);
		driver.findElement(By.id("loginPassword")).sendKeys(credential.split(":")[1]);

	}

	public static HashMap<String, String> getCreddential() {
		HashMap<String, String> user = new HashMap<String, String>();
		user.put("Nisha.r", "Rnisha:syntax@10");
		user.put("vidya", "vidya:syntax@10");
		user.put("dipak", "dipak:syntax@10");
		return user;
	}

	public static String readFromExSearch(int rw, int cl) throws IOException {
		File f = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mySht = wb.getSheet("SearchTab");
		Row row = mySht.getRow(rw);
		Cell cell = row.getCell(cl);
		String name = cell.getStringCellValue();
		return name;
	}

	public static String readFromExMail(int rw, int cl) throws IOException {
		File f = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mySht = wb.getSheet("Mail");
		Row row = mySht.getRow(rw);
		Cell cell = row.getCell(cl);
		String name = cell.getStringCellValue();
		return name;
	}

	public static String readFrmXLNEgative(int rw, int cl) throws IOException {
		File f = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mySht = wb.getSheet("NegativeScrpt");
		Row row = mySht.getRow(rw);
		Cell cell = row.getCell(cl);
		String name = cell.getStringCellValue();
		return name;
	}

	public static CharSequence[] getNoOfRows() throws IOException {
		File f = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);

		int data = (int) wb.getSheet("SearchTab").getRow(5).getCell(0).getNumericCellValue();

		System.out.println("150");
		return null;

	}

	public static String TodoListExcel(int rw, int cl) throws IOException {
		File f = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mySht = wb.getSheet("To-dolist");
		Row row = mySht.getRow(rw);
		Cell cell = row.getCell(cl);
		String name = cell.getStringCellValue();
		return name;
	}

	public static String readFromExLogin(int rw, int cl) throws IOException {
		File f = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mySht = wb.getSheet("ValidLogin");
		Row row = mySht.getRow(rw);
		Cell cell = row.getCell(cl);
		String name = cell.getStringCellValue();
		return name;
	}

	public static String readFromRoomCntxt(int rw, int cl) throws IOException {
		File f = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mySht = wb.getSheet("RoomContext");
		Row row = mySht.getRow(rw);
		Cell cell = row.getCell(cl);
		String name = cell.getStringCellValue();
		return name;
	}

	public static String readFromExAdvancedView(int rw, int cl) throws IOException {
		File f = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mySht = wb.getSheet("AdvancedView");
		Row row = mySht.getRow(rw);
		Cell cell = row.getCell(cl);
		String name = cell.getStringCellValue();
		return name;
	}

	public static WebElement Refresh_Button(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"homeMenuBtn\"]/img"));
		return element;
	}

	// 2.

	public static void LogoutPage() throws Exception {

		WebElement logout = driver.findElement(By.xpath("(//span[@id='logedinusername'])[1]"));
		Thread.sleep(1000);
		Reporter.log("Click on Username option", true);
		jsclick(logout);
		Thread.sleep(2000);
		WebElement logoutOKBTN = driver.findElement(By.xpath("//*[@id=\"idSidenav\"]/ul/li[1]/a"));
		jsclick(logoutOKBTN);
		Reporter.log("Click on Logout option", true);

		try {
			WebDriverWait wait1 = new WebDriverWait(driver,  Duration.ofSeconds(20));
			wait1.until(ExpectedConditions.alertIsPresent());
			Alert alt = driver.switchTo().alert();
			alt.accept();
		} catch (Exception e) {
			System.out.println("Alert is not present...");
		}
	}

	/*
	 * @FindBy(xpath = "//*[@id=\"rubberBandInteractiveMode_shortcut\"]/span")
	 * private WebElement ClickOCR;
	 * 
	 * public WebElement getClickOCR() throws Exception { return ClickOCR; }
	 * 
	 * @FindBy(css = "#imageViewerDiv .lt-imageviewer-eventcanvas") private
	 * WebElement setOCR;
	 * 
	 * public WebElement getSet_OCR_ToDocument() throws Exception {
	 * 
	 * Actions action = new Actions(driver); WebElement element = setOCR;
	 * action.dragAndDropBy(element, 65, 15).build().perform(); jsclick(setOCR);
	 * return element;
	 * 
	 * }
	 * 
	 */

	/*
	 * ChromeOptions options = new ChromeOptions();
	 * options.setPageLoadStrategy(PageLoadStrategy.EAGER); // Options: NONE, EAGER,
	 * NORMAL WebDriver driver = new ChromeDriver(options);
	 */

	// 3.
	public static void browserMax() {
		driver.manage().window().maximize();
	}

	// 4.
	public static String pageTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 5.
	public static String pageUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	// 6.
	public static void enterText(WebElement element, String value) {
		element.sendKeys(value);
	}

	// 7.
	public static void clickElement(WebElement element) {
		element.click();
	}

	// 8.
	public static void gettingText(WebElement element) {
		element.getText();
	}

	// 9.
	public static void gettingAttribute(WebElement element, String value) {
		element.getAttribute(value);
	}

	// 10.
	public static void pauseExecution(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 11.
	public static void closeBrowser() {
		driver.close();
	}

	public static void sendvalue(WebElement ele, String value) {

		ele.sendKeys(value);

	}

	// 12.
	public static void applyWaitsForAll() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// 13.
	public static void movingElement(WebElement element) {
		a1 = new Actions(driver);
		a1.moveToElement(element).perform();
	}

	public static void movingDoublecli(WebElement element, WebElement ele) {
		a1 = new Actions(driver);
		a1.moveToElement(element).doubleClick(ele).build().perform();
	}

	public static void movingclkElement(WebElement element) {
		a1 = new Actions(driver);
		a1.moveToElement(element).click().build().perform();
	}

	// 14.
	public static void dragAndDropElement(WebElement element1, WebElement element2) {
		a1 = new Actions(driver);
		a1.dragAndDrop(element1, element2).perform();
	}

	// 15.
	public static void selectElement(WebElement element) {
		a1 = new Actions(driver);
		a1.doubleClick(element).perform();
	}

	// 16.
	public static void rightClick(WebElement element) {
		a1 = new Actions(driver);
		a1.contextClick(element).perform();
	}

	// 17.
	public static void acceptAlert() {
		a = driver.switchTo().alert();

		a.accept();
	}

	// 18.
	public static void dismissAlert() {
		a = driver.switchTo().alert();
		a.dismiss();
	}

	public static String excelRead(int rowNo, int cellNo) throws IOException {
		File f = new File("./data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mySht = wb.getSheet("SearchTab");
		Row row = mySht.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		CellType cellType = cell.getCellType();
		String text = "";
		double d = cell.getNumericCellValue();
		long l = (long) d;
		return text = String.valueOf(l);
	}

	// 19.
	public static String getTextFromAlert() {
		a = driver.switchTo().alert();
		String text = a.getText();
		return text;
	}

	// 20.
	public static void sendTextToAlert(String value) {
		a = driver.switchTo().alert();
		a.sendKeys(value);
	}

	// 21.
	public static void scrollDown(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	// 22.
	public static void scrollUp(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public static void scroll() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)");
	}

	public static void jsclick(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public static void jssend(String val, WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].sendKeys(val)", element);
	}

	// 23.
	public static void pageRefresh() {
		driver.navigate().refresh();
	}

	// 24.
	public static void pageForward() {
		driver.navigate().forward();
	}

	// 25.
	public static void pageBack() {
		driver.navigate().back();
	}

	// 26.
	public static void goToPage(String url) {
		driver.navigate().to(url);
	}

	// 27.
	public static boolean elementDisplayed(WebElement element) {
		boolean d = element.isDisplayed();
		return d;
	}

	// 28.
	public static boolean elementEnabled(WebElement element) {
		boolean e = element.isEnabled();
		return e;
	}

	// 29.
	public static boolean elementSelected(WebElement element) {
		boolean s = element.isSelected();
		return s;
	}

	public static void SoftAssertEqalValidation(WebElement expected, String actual) {
		SoftAssert so = new SoftAssert();
		so.assertEquals(expected, actual);
	}

	public static void Softall() {
		SoftAssert so = new SoftAssert();
		so.assertAll();
	}

	// 30.
	public static void frameByIdOrName(String value) {
		driver.switchTo().frame(value);
	}

	// 31.
	public static void frameByWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	// 32.
	public static void frameByIndex(int value) {
		driver.switchTo().frame(value);
	}

	// 33.
	public static void windowByUrl(String url) {
		driver.switchTo().window(url);
	}

	// 34.
	public static void windowByTitle(String title) {
		driver.switchTo().window(title);
	}

	// 35.
	public static void windowById(String windowId) {
		driver.switchTo().window(windowId);
	}

	// 36.
	public static String getParentId() {
		String parentId = driver.getWindowHandle();
		return parentId;
	}

	// 37.
	public static Set<String> allId() {
		Set<String> allId = driver.getWindowHandles();
		return allId;
	}

	// 38.
	public static void goToChildtab(String parentId, Set<String> allId) {
		for (String s : allId) {
			if (!s.equals(parentId)) {
				driver.switchTo().window(s);
			}
		}
	}

	// 39.
	public static void goToChildTabByIndex(Set<String> allId, int index) {
		List<String> l = new ArrayList<String>();
		l.addAll(allId);
		driver.switchTo().window(l.get(index));
	}

	public static void expandCabinets() throws Exception {
		Actions actions = new Actions(driver);

		// Loop through each cabinet and double-click to expand
		int cabinetCount = driver.findElements(By.xpath("//div[@id='viewDocumentnavigator']/ul/li")).size();
		for (int i = 1; i <= cabinetCount; i++) {

			WebElement cabinet = driver.findElement(By.xpath("//div[@id='viewDocumentnavigator']/ul/li[" + i + "]/a"));
			Thread.sleep(3000);
			actions.doubleClick(cabinet).perform();
			Reporter.log("Expand a cabinet " + i, true);

			// Check if the current cabinet is the one we want to fully expand
			if (i == 2) {
				// Find the list of drawer elements within the current cabinet
				int drawerCount = driver
						.findElements(By.xpath("//div[@id='viewDocumentnavigator']/ul/li[" + i + "]/ul/li")).size();

				// Loop through each drawer and double-click to expand
				for (int j = 1; j <= drawerCount; j++) {
					WebElement drawer = driver.findElement(
							By.xpath("//div[@id='viewDocumentnavigator']/ul/li[" + i + "]/ul/li[" + j + "]/a"));
					Thread.sleep(3000);
					actions.doubleClick(drawer).perform();
					Reporter.log("Expand a drawer " + j, true);

					// Check if the current drawer is the one we want to fully expand
					if (j == 1) {
						// Find the list of folder elements within the current drawer
						int folderCount = driver
								.findElements(By.xpath(
										"//div[@id='viewDocumentnavigator']/ul/li[" + i + "]/ul/li[" + j + "]/ul/li"))
								.size();

						// Double-click on the first folder only
						if (folderCount > 0) {
							WebElement folder = driver.findElement(By.xpath(
									"//div[@id='viewDocumentnavigator']/ul/li[" + i + "]/ul/li[" + j + "]/ul/li[1]/a"));
							Thread.sleep(3000);
							actions.doubleClick(folder).perform();
							Reporter.log("Expand a folder " + folder, true);

							// Perform any additional actions on the expanded folder here

							// Break after expanding the first folder
							break;
						}
					}
				}
				// Break after expanding the specific cabinet and drawer
				break;
			}
		}
	}

	// 40.
	public static void selectDropDownByValue(WebElement element, String text) {
		sl = new Select(element);
		sl.selectByValue(text);

	}

	// 41.
	public static void selectDropDownByVisibleText(WebElement element, String text) {
		sl = new Select(element);
		sl.selectByVisibleText(text);

	}

	public static void EndTime() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime = sdf.format(d);
		System.out.println("Test Execution End Time :" + currentDateTime);
	}

	// 42.
	public static void selectDropDownByIndex(WebElement element, int index) {
		sl = new Select(element);
		sl.selectByIndex(index);

	}

	// 43.
	public static void deselectDropDownByValue(WebElement element, String text) {
		sl = new Select(element);
		sl.deselectByValue(text);

	}

	// 44.
	public static void deselectDropDownByVisibleText(WebElement element, String text) {
		sl = new Select(element);
		sl.deselectByVisibleText(text);

	}

	// 45.
	public static void deselectDropDownByIndex(WebElement element, int index) {
		sl = new Select(element);
		sl.deselectByIndex(index);

	}

	// 46.
	public static void deselectDropDown(WebElement element) {
		sl = new Select(element);
		sl.deselectAll();
	}

	// 47.
	public static boolean multiselectDropDown(WebElement element) {
		sl = new Select(element);
		boolean multiple = sl.isMultiple();
		return multiple;
	}

	// 48.
	public static List<WebElement> options(WebElement element) {
		sl = new Select(element);
		List<WebElement> options = sl.getOptions();
		return options;

	}

	// 49.
	public static List<WebElement> selectedOptions(WebElement element) {
		sl = new Select(element);
		List<WebElement> option = sl.getAllSelectedOptions();
		return option;

	}

	// 50.
	public static WebElement firstSelectedOptions(WebElement element) {
		sl = new Select(element);
		WebElement option = sl.getFirstSelectedOption();
		return option;

	}

	// 51.
	public static String selectAllOption(WebElement element) {
		String text = "";
		sl = new Select(element);
		List<WebElement> options = sl.getOptions();
		for (WebElement w : options) {
			text = w.getText();
			System.out.println(text);
		}
		return text;
	}

	// 52.

	public static void snap(String name) throws IOException {
		TakesScreenshot sp = (TakesScreenshot) driver;
		File temp = sp.getScreenshotAs(OutputType.FILE);
		File Source = new File(
				"C:\\Users\\nisha.r\\Documents\\Downloads\\CVS_Auto\\DefectFunctionalitySnaps" + name + ".png");
		FileUtils.copyFile(temp, Source);
	}

	public static void VisiblityOf(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	public static void alertIsPresent() {
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());

	}

	public static void ElementToBeClickable(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ele));

	}

}

/*
 * //53. public static String excelRead(String fileName, String sheetName, int
 * rowNo, int cellNo) throws IOException { f=new File(""+fileName+".xlsx"); fin=
 * new FileInputStream(f); w = new XSSFWorkbook(fin); s = w.getSheet(sheetName);
 * row =s.getRow(rowNo); cell = row.getCell(cellNo); int cellType =
 * cell.getCellType(); String text=""; if (cellType==1) {
 * text=cell.getStringCellValue(); } else if
 * (DateUtil.isCellDateFormatted(cell)) { Date d = cell.getDateCellValue();
 * System.out.println(d); SimpleDateFormat sim = new
 * SimpleDateFormat("dd-MM-yyyy"); text = sim.format(d); } else { double d =
 * cell.getNumericCellValue(); long l = (long)d; text = String.valueOf(l); }
 * return text; }
 * 
 * //54. public static void excelWrite(String fileName, String sheetName, int
 * rowNo, int cellNo, String value) throws IOException { f=new
 * File(""+fileName+".xlsx"); w = new XSSFWorkbook(); s =
 * w.createSheet(sheetName); row= s.createRow(rowNo); cell =
 * row.createCell(cellNo); cell.setCellValue(value); fout = new
 * FileOutputStream(f); w.write(fout); System.out.println("Done"); }
 * 
 * //55. public static void excelUpdate(String fileName, String sheetName, int
 * rowNo, int cellNo, String oldValue, String newValue) throws IOException {
 * f=new File(""+fileName+".xlsx"); fin = new FileInputStream(f); w = new
 * XSSFWorkbook(fin); s = w.getSheet(sheetName); row= s.getRow(rowNo); cell =
 * row.getCell(cellNo); String text = cell.getStringCellValue(); if
 * (text.equals(oldValue)) { cell.setCellValue(newValue); } fout = new
 * FileOutputStream(f); w.write(fout); System.out.println("Done"); } public
 * static void excelUpdates(String fileName, String sheetName, int rowNo, int
 * cellNo, String value) throws IOException { f=new File(""+fileName+".xlsx");
 * fin = new FileInputStream(f); w = new XSSFWorkbook(fin); s =
 * w.getSheet(sheetName); row= s.getRow(rowNo); cell = row.getCell(cellNo);
 * cell.setCellValue(value); fout = new FileOutputStream(f); w.write(fout);
 * System.out.println("Done");
 * 
 * } //56. public static void excelAddNewRow(String fileName, String sheetName,
 * int rowNo, int cellNo, String value) throws IOException{ f=new
 * File(""+fileName+".xlsx"); fin = new FileInputStream(f); w = new
 * XSSFWorkbook(fin); s = w.getSheet(sheetName); row= s.createRow(rowNo); cell =
 * row.createCell(cellNo); cell.setCellValue(value); fout = new
 * FileOutputStream(f); w.write(fout); System.out.println("Done"); } //57.
 * public static void createExcel(String fileName, String sheetName) throws
 * IOException { f=new File("" + fileName + ".xlsx"); w = new XSSFWorkbook(); s=
 * w.createSheet(sheetName); fout=new FileOutputStream(f); w.write(fout); }
 * //58. public static void createRow(String fileName, String sheetName, int
 * rowNo) throws IOException { f=new File(""+fileName+".xlsx"); fin = new
 * FileInputStream(f); w = new XSSFWorkbook(fin); s= w.getSheet(sheetName);
 * s.createRow(rowNo); fout=new FileOutputStream(f); w.write(fout); } //59.
 * public static void createCell(String fileName, String sheetName, int rowNo,
 * int cellNo, String value) throws IOException { f=new
 * File(""+fileName+".xlsx"); fin = new FileInputStream(f); w = new
 * XSSFWorkbook(fin); s= w.getSheet(sheetName); row= s.getRow(rowNo); cell =
 * row.createCell(cellNo); cell.setCellValue(value); fout=new
 * FileOutputStream(f); w.write(fout);
 * 
 * } //60. public static int getNoOfRows(String fileName, String sheetName)
 * throws IOException { f=new File(""+fileName+".xlsx"); fin = new
 * FileInputStream(f); w = new XSSFWorkbook(fin); s= w.getSheet(sheetName); int
 * NumberOfRows = s.getPhysicalNumberOfRows(); return NumberOfRows;
 * 
 * } //61. public static int getNoOFColumn(String fileName, String sheetName)
 * throws IOException { int NumberOfCells=0; f=new File(""+fileName+".xlsx");
 * fin = new FileInputStream(f); w = new XSSFWorkbook(fin); s=
 * w.getSheet(sheetName); for (int i = 0; i < getNoOfRows(fileName, sheetName);
 * i++) { Row r = s.getRow(i); NumberOfCells = r.getPhysicalNumberOfCells();
 * return NumberOfCells; }
 * 
 * } //62. public static int getTotalNoOfCells(String fileName, String
 * sheetName) throws IOException { int rows = getNoOfRows(fileName, sheetName);
 * int column = getNoOFColumn(fileName, sheetName); int Totalcells =rows*column;
 * return Totalcells; } }
 */
