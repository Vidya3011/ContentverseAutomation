package Pom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import Generic.BaseClass;

//NishaR codes

//~~~~~~~~~~~~~~~~~~~~~~~~~~~NishaR codes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
public class AdvancedViewer extends BaseClass {

	public AdvancedViewer() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "imgSettings")
	private WebElement Setting_Icon;

	@FindBy(css = "#myPreferencesSettingsNav > p")
	private WebElement My_Preferencesetting;

	@FindBy(xpath = "//button[@id='myPreferencesSubmit']")
	private WebElement Apply_button;

	@FindBy(xpath = "//select[@id='defaultOfficeDocViewListNo']")
	private WebElement Select_Office_document_Advancedviewing;

	public void getSelect_Office_document_Advancedviewing() {
		Select sel = new Select(Select_Office_document_Advancedviewing);
		sel.selectByVisibleText("Advanced viewing");

	}

	@FindBy(id = "defaultPdfDocViewListNo")
	private WebElement Select_PDF_document_Advancedviewing;

	public void getSelect_PDF_document_Advancedviewing() {
		Select sel = new Select(Select_PDF_document_Advancedviewing);
		sel.selectByVisibleText("Advanced viewing");

	}

	public void getSelect_PDF_document_Defviewing() {
		Select sel = new Select(Select_PDF_document_Advancedviewing);
		sel.selectByVisibleText("Default viewing");

	}

	public void DefaultView() throws Exception {

		jsclick(Refresh_Button(driver));

		Thread.sleep(5000);
		jsclick(Setting_Icon);
		Reporter.log("User click on setting icon");
		Thread.sleep(5000);
		jsclick(My_Preferencesetting);
		Reporter.log("User click on the my preference tab");
		Thread.sleep(5000);
		getSelect_PDF_document_Defviewing();
		Reporter.log("User changes pdf document as default viewing");
		Thread.sleep(4000);
		jsclick(Apply_button);
		Reporter.log("User click on Apply button and the default view successfully applied...");
		Thread.sleep(5000);

	}

	@FindBy(xpath = "//a[@id='createDocument']")
	private WebElement Click_New_Document;

	@FindBy(xpath = "//input[@id='createDocuemtnLocation']")
	private WebElement Destination_Folder_Textbox;

	@FindBy(xpath = ("//div[@id='createDocuemntNavigator']/ul/li[2]/a"))
	private WebElement Cabinet;

	@FindBy(xpath = ("//div[@id='createDocuemntNavigator']/ul/li[2]/ul/li[1]/a"))
	private WebElement Drawer;

	@FindBy(xpath = ("//div[@id='createDocuemntNavigator']/ul/li[2]/ul/li[1]/ul/li[1]/a"))
	private WebElement Folder;

	@FindBy(xpath = "//*[@id=\"3\"]/a")
	private WebElement CaseSensitiveRoomFolder;

	@FindBy(xpath = "//*[@id=\"sendToDocuSign\"]/span")
	private WebElement DocuSign;

	@FindBy(xpath = "//div[@id='viewDocumentnavigator']/ul/li[1]/ins") // cabinet bill
	private WebElement FirstCabinet;

	@FindBy(xpath = "//div[@id='viewDocumentnavigator']/ul/li[1]/ul/li/ins") // drawer bill
	private WebElement FirstDrawer;

	@FindBy(xpath = "//div[@id='viewDocumentnavigator']/ul/li[1]/ul/li[1]/ul/li[1]/a") // folderbill
	private WebElement FirstFolder;

	@FindBy(xpath = "//*[@id=\"documentListTable\"]//tr[1]/td[3]") // change tr number to select 2 or 4 docs tr[5]
	private WebElement FirstDocument;

	@FindBy(xpath = "//*[@id=\"createDocument\"]")
	private static WebElement NewDocument;

	@FindBy(xpath = "//*[@id=\"376\"]/a")
	private WebElement SQLRoomFolder;

	@FindBy(xpath = "//button[@id='navigatorTreeOk']")
	private WebElement OK_Button_BrowseforFolder;

	@FindBy(id = "docTypeList")
	private WebElement Click_Document_Type_Dropdown;

	public void getSelect_Document_Type_Dropdown() {
		Select drop = new Select(Click_Document_Type_Dropdown);
		drop.selectByVisibleText("CVReports");

	}

	@FindBy(xpath = "//*[@id=\"docTypeIndicesTable\"]/tbody/tr/td[2]")
	private WebElement DocumentCVRep;

	@FindBy(xpath = "//*[@id=\"docTypeIndicesTable_wrapper\"]/table/tbody/tr/td[2]/input")
	private WebElement Enter_ReportName;

	@FindBy(xpath = "//*[@id=\"addPagesDropDown\"]/span")
	private WebElement Move_To_PlusIcon;

	@FindBy(xpath = "//*[@id='viewDocumentAddPages']")
	private WebElement Browse_Option;

	@FindBy(xpath = "//*[@id=\"djvuViewerDiv_toolbar_image\"]")
	private WebElement WordDocImageOpt;

	@FindBy(xpath = "//*[@id=\"djvuViewerDiv_toolbar_image_local\"]")
	private WebElement UploadFromCmpOpt;

	@FindBy(xpath = "//*[@id=\"djvuViewerDiv_toolbar_table\"]/span[2]")
	private WebElement CreateTableopt;

	@FindBy(xpath = "(//button[@class='e-control e-btn e-lib e-flat e-table-ok e-primary'])[1]")
	private WebElement TableDialogOKBTN;

	@FindBy(xpath = "//*[@id=\"djvuViewerDiv_toolbar_link\"]")
	private WebElement LinkOpt;

	@FindBy(xpath = "//*[@id=\"textbox_41\"]")
	private WebElement LinkAddress;

	@FindBy(xpath = "//a[text()='New Pdf Document']")
	private WebElement NewPDfDoc;

	@FindBy(xpath = "//*[@id=\"newTemplateFileName\"]")
	private WebElement EnterFileNAmePDF;

	@FindBy(xpath = "(//button[@id='templateOK'])[1]")
	private WebElement EnterFileNameOKBTN;

	@FindBy(xpath = "(//span[@id='pdfViewerDiv_signatureIcon'])[1]")
	private WebElement SignaturePDFDoc;

	@FindBy(xpath = ("(//div[@id='pdfViewerDiv_textLayer_0'])[1]"))
	private WebElement Page;

	// *[@id="pdfViewerDiv_textLayer_0"]

	@FindBy(xpath = ("//*[@id=\"pdfViewerDiv_annotation\"]"))
	private WebElement AdvancedTool;

	@FindBy(xpath = ("//*[@id=\"pdfViewerDiv_annotation_freeTextEditIcon\"]"))
	private WebElement AdvancedToolTextIcon;

	@FindBy(xpath = ("//*[@id=\"pdfViewerDiv_textLayer_0\"]"))
	private WebElement page2;

	@FindBy(xpath = ("//*[@id=\"pdfViewerDiv_comment\"]"))
	private WebElement AddComment;

	@FindBy(xpath = ("(//div[@id='djvuViewerDiv_editor_viewerContainer'])[1]"))
	private WebElement WordDocPage;

	@FindBy(xpath = ("//*[@id=\"messageContent\"]"))
	private WebElement FileMessage;

	@FindBy(xpath = ("//div[@id='saveAddedPages']//span[1]"))
	private WebElement SaveTab;

	@FindBy(xpath = ("(//button[@id='messageButtonOK42'])[1]"))
	private WebElement SaveTabOKBTN;

	@FindBy(xpath = ("//*[@id=\"cvDocumentClose\"]/span"))
	private WebElement CloseIcon;

	@FindBy(xpath = ("//*[@id=\"documentListTable\"]/tbody/tr[1]/td[3]"))
	private WebElement ReopenTheDocument;

	@FindBy(xpath = ("//*[@id=\"addWordFile\"]"))
	private WebElement WordDocument;

	@FindBy(xpath = ("//*[@id=\"djvuViewerDiv_main_content\"]/div[1]/table/tbody/tr[6]/td[7]"))
	private WebElement ExcelSheetFirstRow;

	@FindBy(xpath = ("//*[@id=\"djvuViewerDiv_main_content\"]/div[1]/table/tbody/tr[4]/td[2]"))
	private WebElement ExcelSheetFourthRow;

	@FindBy(xpath = ("//*[@id=\"pdfViewerDiv_annotation_ink\"]"))
	private WebElement DrawLinkAnnotation;

	// *[@id="addExcelFileMobile"]
	@FindBy(xpath = ("//*[@id=\"addExcelFileMobile\"]"))
	private WebElement ExcelSheet;

	@FindBy(xpath = ("//*[@id=\"AutomationTestingPDFDOc.pdf\"]/div/img"))
	private WebElement PDFDocumentPage;

	@FindBy(xpath = ("//*[@id=\"fabButton\"]"))
	private WebElement FAbBTN;

	@FindBy(xpath = ("/html/body/div[19]/div/div[3]/button"))
	private WebElement DeleteOKBTN;

	@FindBy(xpath = ("//*[@id=\"messageButtonOK\"]"))
	private WebElement InvalidDilogOKBTN;

	@FindBy(xpath = ("//*[@id=\"modelHome\"]"))
	private WebElement NavigateBTN;

	@FindBy(xpath = ("//*[@id=\"documentListTable\"]/tbody/tr[1]/td[3]"))
	private WebElement NavigateDocOpen;

	@FindBy(xpath = ("//*[@id=\"launchInNative\"]/span"))
	private WebElement MicroSoftOfficeICON;

	@FindBy(xpath = ("//*[@id=\"showHideThumbnail\"]/span"))
	private WebElement ShowThumbnail;

	@FindBy(css = ("#saveFabButton"))
	private WebElement FabSaveBTN;

	@FindBy(xpath = ("//*[@id=\"deleteFabButton\"]"))
	private WebElement FabDeleteBTN;

	@FindBy(xpath = ("//*[@id=\"uploadFabButton\"]"))
	private WebElement UploadeFabBTN;

	@FindBy(xpath = ("//*[@id=\"fullScreenFabButton\"]"))
	private WebElement viewFullScrnBTN;

	@FindBy(xpath = ("//*[@id=\"docViewerMetaData\"]/div[2]/div/input"))
	private WebElement SecondPageCheckBox;

	@FindBy(xpath = ("//*[@id='progressUploaModal']"))
	private WebElement FileDetailsDialog;

	@FindBy(xpath = ("//*[@id=\"deleteMessageOk19\"]"))
	private WebElement DeleteDialogYes;

	@FindBy(xpath = ("//*[@id=\"createDocumentSubmit\"]"))
	private WebElement CreateBTN;

	@FindBy(xpath = ("//*[@id=\"viewCreatedDocument\"]"))
	private WebElement viewOption;

	@FindBy(xpath = ("//*[@id=\"docCreatorSpan1\"]"))
	private WebElement SelectUSer;

	@FindBy(xpath = ("//*[@id=\"messageButtonOK\"]"))
	private WebElement DocSignOKBTN;

	@FindBy(xpath = ("/html/body/div[49]/div/div[4]/input"))
	private WebElement EmailTextBox;

	@FindBy(xpath = ("/html/body/div[49]/div/div[5]/button[1]"))
	private WebElement EmailTextBoxOKBTN;
	
	
	

	
		public void CreateDocumentMore() throws Exception {
		    WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(20)); // Explicit wait
		    jsclick(Refresh_Button(driver));
		    Thread.sleep(2000);
		    Reporter.log("Scenario 01: Document Thumbnail view");
		    Reporter.log("Expand the cabinet");
		    jsclick(FirstCabinet);
		    Reporter.log("Expand the drawer");
		    wait.until(ExpectedConditions.elementToBeClickable(FirstDrawer));
		    Thread.sleep(2000); // Adding sleep to ensure stability
		    jsclick(FirstDrawer);
		    Reporter.log("Select the folder");
		    wait.until(ExpectedConditions.elementToBeClickable(FirstFolder));
		    Thread.sleep(2000); // Adding sleep for stability
		    selectElement(FirstFolder);

		    Reporter.log("Click on new document");
		    wait.until(ExpectedConditions.elementToBeClickable(Click_New_Document));
		    Thread.sleep(2000); // Adding sleep for stability
		    
				 for (int i = 0; i <= 100; i++) {
				      jsclick(Click_New_Document);
				      getSelect_Document_Type_Dropdown();
				      Thread.sleep(2000); // Adding sleep for stability
				      Reporter.log("Select document type");
				
				      Actions act = new Actions(driver);
				      act.click(DocumentCVRep).sendKeys(readFrmXLNEgative(6, 0)).build().perform();
				      Reporter.log("Enter document name");
				
				      wait.until(ExpectedConditions.elementToBeClickable(CreateBTN));
				      Thread.sleep(2000); // Adding sleep for stability
				      jsclick(CreateBTN);
				      Reporter.log("Click on create document");
				
				      wait.until(ExpectedConditions.elementToBeClickable(viewOption));
				      Thread.sleep(2000); // Adding sleep for stability
				      jsclick(viewOption);
				      Reporter.log("Click on view button");
				
				      movingElement(Move_To_PlusIcon);
				      Reporter.log("Click on add icon");
				      Thread.sleep(4000); 
				//        wait.until(ExpectedConditions.elementToBeClickable(WordDocument));
				      Thread.sleep(2000); // Adding sleep for stability
				      jsclick(WordDocument);
				
				      EnterFileNAmePDF.sendKeys(readFromExAdvancedView(3, 1));
				      Reporter.log("Enter word document name");
				
				      jsclick(EnterFileNameOKBTN);
				      Reporter.log("Click on enter file name OK button");
				
				      wait.until(ExpectedConditions.elementToBeClickable(SaveTab));
				      Thread.sleep(2000); // Adding sleep for stability
				      jsclick(SaveTab);
				      wait.until(ExpectedConditions.visibilityOf(SaveTabOKBTN));
				      Thread.sleep(2000); // Adding sleep for stability
				      Reporter.log("Click on save dialog OK button");
				      jsclick(SaveTabOKBTN);
				  }
				
	/*	    for (int i = 0; i <= 100; i++) {
		        jsclick(Click_New_Document);
		      getSelect_Document_Type_Dropdown();
		        Thread.sleep(2000); // Adding sleep for stability
		        Reporter.log("Select document type");

		        Actions act = new Actions(driver);
		        act.click(DocumentCVRep).sendKeys(readFrmXLNEgative(6, 0)).build().perform();
		        Reporter.log("Enter document name");

		        wait.until(ExpectedConditions.elementToBeClickable(CreateBTN));
		        Thread.sleep(2000); // Adding sleep for stability
		        jsclick(CreateBTN);
		        Reporter.log("Click on create document");

		        wait.until(ExpectedConditions.elementToBeClickable(viewOption));
		        Thread.sleep(2000); // Adding sleep for stability
		        jsclick(viewOption);
		        Reporter.log("Click on view button");
		        Thread.sleep(2000);
		        movingElement(Move_To_PlusIcon);
		        Reporter.log("Click on add icon");

		        try {
		            act.moveToElement(Browse_OptionNish).click().build().perform();
		            Reporter.log("Select browse option");
		        } catch (JavascriptException e) {
		            System.out.println("JavascriptException encountered");
		        }

		        Thread.sleep(5000); // Adding sleep for stability
		        Reporter.log("Add a Large TIFF file from folder by using Auto IT script");
		        Runtime.getRuntime().exec("D:\\RNishaAutoIt\\NishaRScript.exe");

		        try {
		            wait.until(ExpectedConditions.alertIsPresent());
		            Alert alt = driver.switchTo().alert();
		            alt.accept();
		        } catch (Exception e) {
		            System.out.println("Alert not present");
		        }*/
		        wait.until(ExpectedConditions.elementToBeClickable(SaveTab));
		        Thread.sleep(2000); // Adding sleep for stability
		        jsclick(SaveTab);
		        wait.until(ExpectedConditions.visibilityOf(SaveTabOKBTN));
		        Thread.sleep(2000); // Adding sleep for stability
		        Reporter.log("Click on save dialog OK button");
		        jsclick(SaveTabOKBTN);
		    
		  
		    Thread.sleep(5000);
		    Reporter.log("100 document created success");

		
}



	@FindBy(xpath = "//*[@id='viewDocumentAddPages']")
	private WebElement Browse_OptionNish;
	
	public void CreateDocumentAndShowThumbnail() throws Exception {
		Thread.sleep(3000);
		Reporter.log("Scenario 01: Document Thumbnail view");
		Reporter.log("Expand the cabinet");
		jsclick(FirstCabinet);
		Reporter.log("Expand the drawer");
		Thread.sleep(2000);
		jsclick(FirstDrawer);
		Reporter.log("Select the folder");
		Thread.sleep(2000);
		selectElement(FirstFolder);
		Thread.sleep(3000);
		// jsclick(FirstDocument);
		Reporter.log("Click on new document");
		Thread.sleep(3000);
		jsclick(Click_New_Document);
		Thread.sleep(2000);
		// jsclick(Destination_Folder_Textbox);

		Thread.sleep(5000);

		// jsclick(OK_Button_BrowseforFolder);
		Thread.sleep(3000);
		getSelect_Document_Type_Dropdown();
		Reporter.log("Select document type");
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.click(DocumentCVRep).sendKeys(readFrmXLNEgative(6, 0)).build().perform();
		Reporter.log("Enter document name");
		Thread.sleep(5000);

		jsclick(CreateBTN);
		Reporter.log("Click on create document");
		Thread.sleep(10000);

		jsclick(viewOption);
		Reporter.log("Click on view button");
		movingElement(Move_To_PlusIcon);
		Thread.sleep(2000);
		Reporter.log("Click on add icon");
		jsclick(WordDocument);
		EnterFileNAmePDF.sendKeys(readFromExAdvancedView(3, 1));
		Thread.sleep(8000);
		Reporter.log("Enter word document name");
		jsclick(EnterFileNameOKBTN);
		Reporter.log("Click on enter file name OK button");
		Thread.sleep(3000);
		Reporter.log("User click on Show/Hide thumbnail view");
		jsclick(ShowThumbnail);
		Thread.sleep(8000);
		Reporter.log("It will hide the thumbnail page, verified successfully...");
		jsclick(ShowThumbnail);

	}
	
	
	
	
	
	
	
	

	public void DocuSignCreateDoc() throws Exception {
		Thread.sleep(5000);
		Reporter.log("Scenario 01: Verify 'Docusign' Option");
		Reporter.log("Expand the cabinet");
		jsclick(FirstCabinet);
		Thread.sleep(5000);
		Reporter.log("Expand the drawer");

		jsclick(FirstDrawer);
		Thread.sleep(4000);
		ElementToBeClickable(FirstFolder);
		jsclick(FirstFolder);
		Reporter.log("Click on the folder");
		Thread.sleep(3000);
		// jsclick(FirstDocument);
		Thread.sleep(3000);
		jsclick(Click_New_Document);
		Reporter.log("Click on new document tab");

		// jsclick(Destination_Folder_Textbox);

		Thread.sleep(8000);

		// jsclick(OK_Button_BrowseforFolder);

		getSelect_Document_Type_Dropdown();
		Reporter.log("Select a document type");
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.click(DocumentCVRep).sendKeys("Docu sign Document").build().perform();
		Reporter.log("Enter the document name");
		Thread.sleep(5000);

		jsclick(CreateBTN);
		Reporter.log("Click on create button");
		Thread.sleep(10000);

		jsclick(viewOption);
		Reporter.log("Click on view button");
		movingElement(Move_To_PlusIcon);
		Thread.sleep(2000);
		Reporter.log("Mouse hover on browse icon");
		jsclick(WordDocument);
		Reporter.log("Select a word document from the dropdown");
		EnterFileNAmePDF.sendKeys(readFromExAdvancedView(3, 1));
		Thread.sleep(8000);
		Reporter.log("Enter a file name");
		jsclick(EnterFileNameOKBTN);
		Reporter.log("Click enter file name dialog OK BUTTON");
		Thread.sleep(3000);
		try {
			WebDriverWait wait1 = new WebDriverWait(driver,  Duration.ofSeconds(20));
			wait1.until(ExpectedConditions.alertIsPresent());
			Alert alt = driver.switchTo().alert();
			alt.accept();
		} catch (Exception e) {
			System.out.println("Alert not present");
		}

		Thread.sleep(8000);
		Reporter.log("Click on save button");
		jsclick(SaveTab);
		Thread.sleep(8000);
		VisiblityOf(SaveTabOKBTN);
		Reporter.log("Click on save dialog OK button");
		jsclick(SaveTabOKBTN);
		Thread.sleep(3000);
		jsclick(DocuSign);
		Reporter.log("Click on viewer menu docusign tool icon");
		Thread.sleep(4000);
		jsclick(EmailTextBox);
		Reporter.log("Enter valid mail in text box");
		EmailTextBox.sendKeys(readFromExMail(2, 0));
		Thread.sleep(3000);
		jsclick(EmailTextBoxOKBTN);
		Reporter.log("Click on docusign dialog OK button");
		Thread.sleep(4000);
		jsclick(DocSignOKBTN);
		Reporter.log("Click on 'Document sent for signing successsfully' message dialog OK button");
		Thread.sleep(3000);
		Reporter.log("Document sent to docusign successfully...");
		Reporter.log("Click on refresh button");
		jsclick(Refresh_Button(driver));

	}

	public void CreateDocumentAnd_SaveFromDocument_Fabbtn() throws Exception {
		Thread.sleep(6000);
		Actions act = new Actions(driver);
		Reporter.log("Scenario 02: Create document and save document by using floating button Save icon");
		act.click(WordDocPage).sendKeys(readFromExAdvancedView(2, 1)).sendKeys(Keys.ENTER)
				.sendKeys(readFromExAdvancedView(0, 0)).build().perform();
		Thread.sleep(8000);
		Reporter.log("Enter file name and click on Floating button");
		jsclick(FAbBTN);
		Thread.sleep(3000);
		Reporter.log("Click on Save icon");
		VisiblityOf(FabSaveBTN);
		jsclick(FabSaveBTN);
		Thread.sleep(7000);
		Reporter.log("Document saved successfull...");
		jsclick(SaveTabOKBTN);
	}

	public void CreateDocumentAnd_Upload_NewDocument_From_FabBrowseOption() throws Exception {

		Thread.sleep(4000);
		// jsclick(FAbBTN);
		/*
		 * Thread.sleep(3000); ElementToBeClickable(UploadeFabBTN);
		 * jsclick(UploadeFabBTN);
		 */
		Actions act = new Actions(driver);
		Reporter.log("Scenario 03: Floating tab 'browse button'");

		Reporter.log("Add file by using floating button Browse icon");
		act.moveToElement(UploadeFabBTN).click().build().perform();
		// Thread.sleep(3000);
		Reporter.log("Mousehover on floating button");
		Thread.sleep(10000);
		Reporter.log("Click browse icon");
		Reporter.log("Add file by using AutoIT script");
		Runtime.getRuntime().exec("D:\\RNishaAutoIt\\FlowerOrCurlyBracket.exe");
		Thread.sleep(8000);
		try {
			alertIsPresent();
			acceptAlert();
		} catch (Exception e) {
			System.out.println("Alert is not present");
		}
		Thread.sleep(3000);
		// jsclick(FAbBTN);
		Thread.sleep(3000);
		VisiblityOf(FabSaveBTN);
		jsclick(FabSaveBTN);
		Reporter.log("Click on floating button save icon...");
		Thread.sleep(7000);
		Reporter.log("Document updated successfull");
		jsclick(SaveTabOKBTN);
	}

	public void CreateDocumentAnd_ViewFullScreen() throws Exception {
		jsclick(FAbBTN);
		Reporter.log("Scenario 04: Floating button - view full screen");
		Reporter.log("Mouse hover on floating button");
		Thread.sleep(3000);
		Reporter.log("Click on full screen view icon");
		jsclick(viewFullScrnBTN);
		Thread.sleep(7000);
		Reporter.log("It display the document full screen mode");
		jsclick(viewFullScrnBTN);
		Thread.sleep(3000);
	}

	public void CreateDocumentAnd_DeleteFabBTN_option() throws Exception {
		Thread.sleep(3000);
		jsclick(FAbBTN);
		Reporter.log("Scenario 05: Floating button - delete icon");
		Reporter.log("Mouse hover on floating button");
		Thread.sleep(3000);
		Reporter.log("Select thumbnail page check box");
		jsclick(SecondPageCheckBox);
		Thread.sleep(3000);
		Reporter.log("Mousehover on floating button");
		jsclick(FabDeleteBTN);
		Thread.sleep(5000);
		Reporter.log("Click floating button delete icon");
		jsclick(DeleteDialogYes);
		Thread.sleep(3000);
		Reporter.log("Delete confirm dialog Yes button");
		ElementToBeClickable(DeleteOKBTN);
		jsclick(DeleteOKBTN);
		Thread.sleep(3000);
		Reporter.log("Click on floating button save icon");
		jsclick(Refresh_Button(driver));
		Thread.sleep(5000);
		jsclick(SaveChange);
		Thread.sleep(3000);
		jsclick(Refresh_Button(driver));
		Thread.sleep(5000);
	}

	@FindBy(xpath = "//*[@id=\"messageButtonNo27\"]")
	private WebElement SaveChange;

	public void CreateDocumentAdvancedViewWordDocument_Hindi() throws Exception {

		jsclick(Click_New_Document);
		Thread.sleep(2000);
		jsclick(Destination_Folder_Textbox);
		Thread.sleep(3000);
		jsclick(Cabinet);
		Thread.sleep(3000);
		jsclick(Drawer);
		Thread.sleep(5000);
		jsclick(Folder);
		Thread.sleep(5000);

		jsclick(OK_Button_BrowseforFolder);
		Thread.sleep(3000);
		getSelect_Document_Type_Dropdown();
		Thread.sleep(3000);
		movingclkElement(Enter_ReportName);
		sendvalue(Enter_ReportName, readFromExAdvancedView(3, 1));
		Thread.sleep(5000);

		jsclick(CreateBTN);
		Thread.sleep(8000);

		jsclick(viewOption);
		movingElement(Move_To_PlusIcon);
		Thread.sleep(2000);

		jsclick(WordDocument);
		EnterFileNAmePDF.sendKeys(readFromExAdvancedView(3, 1));
		Thread.sleep(8000);

		jsclick(EnterFileNameOKBTN);
		Thread.sleep(3000);

		Actions act = new Actions(driver);
		act.click(WordDocPage).sendKeys(readFromExAdvancedView(2, 1)).sendKeys(Keys.ENTER)
				.sendKeys(readFromExAdvancedView(0, 0)).build().perform();
		Thread.sleep(8000);
		jsclick(SaveTab);
		Thread.sleep(8000);
		VisiblityOf(SaveTabOKBTN);
		jsclick(SaveTabOKBTN);
		Thread.sleep(10000);
		jsclick(WordDocImageOpt);
		Thread.sleep(2000);
		movingclkElement(UploadFromCmpOpt);
		Thread.sleep(5000);
		Runtime.getRuntime().exec("D:\\RNishaAutoIt\\FlowerOrCurlyBracket.exe");
		Thread.sleep(10000);
		jsclick(CreateTableopt);
		Thread.sleep(5000);
		jsclick(TableDialogOKBTN);
		Thread.sleep(5000);
		/*
		 * jsclick(LinkOpt);
		 * LinkAddress.sendKeys("https://github.com/Vidya3011/CV_Automation.git");
		 * Thread.sleep(3000); jsclick(TableDialogOKBTN);
		 */
		Thread.sleep(3000);
		act.click(WordDocPage).sendKeys(readFromExAdvancedView(1, 1)).build().perform();

		Thread.sleep(5000);
		jsclick(SaveTab);
		Thread.sleep(3000);
		VisiblityOf(SaveTabOKBTN);
		jsclick(SaveTabOKBTN);
		Thread.sleep(8000);
		jsclick(CloseIcon);
		Thread.sleep(3000);
		VisiblityOf(ReopenTheDocument);
		jsclick(ReopenTheDocument);
		Thread.sleep(10000);
		jsclick(Refresh_Button(driver));
	}

	public void CreateDocumentScriptDynamicWFType() throws Exception {

		Thread.sleep(4000);
		jsclick(Click_New_Document);
		Thread.sleep(2000);
		jsclick(Destination_Folder_Textbox);
		Thread.sleep(3000);
		jsclick(Cabinet);
		Thread.sleep(3000);
		jsclick(Drawer);
		Thread.sleep(3000);
		jsclick(Folder);
		Thread.sleep(3000);

		jsclick(OK_Button_BrowseforFolder);
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		Reporter.log("Create document and add files");

		Reporter.log("Add file by using floating button Browse icon");
		act.moveToElement(UploadeFabBTN).click().build().perform();
		// Thread.sleep(3000);
		Reporter.log("Mousehover on floating button");
		Thread.sleep(7000);
		Reporter.log("Click browse icon");
		Reporter.log("Add file by using AutoIT script");
		Runtime.getRuntime().exec("D:\\RNishaAutoIt\\NishaRScript.exe");
		Thread.sleep(8000);
		try {
			alertIsPresent();
			acceptAlert();
		} catch (Exception e) {
			System.out.println("Alert is not present");
		}
		Thread.sleep(3000);
		// jsclick(FAbBTN);
		Thread.sleep(3000);
		VisiblityOf(FabSaveBTN);
		jsclick(FabSaveBTN);
		Reporter.log("Click on floating button save icon...");
		Thread.sleep(7000);
		Reporter.log("Document updated successfull");
		jsclick(SaveTabOKBTN);
	}

	public void AdvancedViewerOption() throws Exception {
		Reporter.log("Scenario 1:Go to My Preference,Change the Default viewing as Advanced viewer");
		jsclick(Setting_Icon);
		Reporter.log("Click on Setting icon");
		jsclick(My_Preferencesetting);
		Reporter.log("Go to Mypreference");
		getSelect_Office_document_Advancedviewing();
		Reporter.log("Set the office document to advanced viewing");
		Thread.sleep(3000);
		getSelect_PDF_document_Advancedviewing();
		Reporter.log("Set the PDF document to advanced viewing");
		Thread.sleep(6000);
		jsclick(Apply_button);
		Reporter.log("Click on Apply button");
		Reporter.log("Advanced viewer mode has been set successfully...");

	}

	public void CaseSensitiveRoomAdvancedViewWordDocument() throws Exception {

		jsclick(Click_New_Document);
		Thread.sleep(2000);
		jsclick(Destination_Folder_Textbox);
		Thread.sleep(3000);
		jsclick(Cabinet);
		Thread.sleep(3000);
		jsclick(Drawer);
		Thread.sleep(5000);
		jsclick(CaseSensitiveRoomFolder);
		Thread.sleep(5000);

		jsclick(OK_Button_BrowseforFolder);
		Thread.sleep(3000);
		getSelect_Document_Type_Dropdown();
		Thread.sleep(3000);
		/*
		 * jsclick(DocumentCVRep);
		 * 
		 * DocumentCVRep.sendKeys("CaseSenstiveWordDocument");
		 */
		Actions act = new Actions(driver);
		act.click(DocumentCVRep).sendKeys("CaseSenstiveWordDocument").build().perform();
		Thread.sleep(5000);

		movingElement(Move_To_PlusIcon);
		Thread.sleep(5000);

		jsclick(WordDocument);
		EnterFileNAmePDF.sendKeys(readFromExAdvancedView(3, 1));
		Thread.sleep(5000);
		ElementToBeClickable(EnterFileNameOKBTN);
		jsclick(EnterFileNameOKBTN);
		Thread.sleep(8000);

		jsclick(CreateBTN);
		Thread.sleep(8000);

		jsclick(viewOption);
		Thread.sleep(10000);
		// Actions act=new Actions(driver);
		ElementToBeClickable(WordDocPage);
		act.click(WordDocPage).sendKeys(readFromExAdvancedView(2, 1)).sendKeys(Keys.ENTER)
				.sendKeys(readFromExAdvancedView(0, 0)).build().perform();
		Thread.sleep(8000);
		jsclick(SaveTab);
		Thread.sleep(8000);
		VisiblityOf(SaveTabOKBTN);
		jsclick(SaveTabOKBTN);
		Thread.sleep(8000);
		jsclick(WordDocImageOpt);
		Thread.sleep(2000);
		movingclkElement(UploadFromCmpOpt);
		Thread.sleep(5000);
		Runtime.getRuntime().exec("D:\\RNishaAutoIt\\FlowerOrCurlyBracket.exe");
		Thread.sleep(10000);
		jsclick(CreateTableopt);
		Thread.sleep(5000);
		jsclick(TableDialogOKBTN);
		Thread.sleep(5000);
		/*
		 * jsclick(LinkOpt);
		 * LinkAddress.sendKeys("https://github.com/Vidya3011/CV_Automation.git");
		 * Thread.sleep(3000); jsclick(TableDialogOKBTN);
		 */
		Thread.sleep(3000);
		act.click(WordDocPage).sendKeys(readFromExAdvancedView(1, 1)).build().perform();

		Thread.sleep(5000);
		jsclick(SaveTab);
		Thread.sleep(3000);
		VisiblityOf(SaveTabOKBTN);
		jsclick(SaveTabOKBTN);
		Thread.sleep(8000);
		jsclick(CloseIcon);
		Thread.sleep(3000);
		VisiblityOf(ReopenTheDocument);
		jsclick(ReopenTheDocument);
		Thread.sleep(10000);
		jsclick(Refresh_Button(driver));
	}

	public void AdvancedViewPDFDocumentCaseSensitive() throws Exception {

		jsclick(Click_New_Document);
		Thread.sleep(2000);
		jsclick(Destination_Folder_Textbox);
		Thread.sleep(3000);
		selectElement(Cabinet);
		Thread.sleep(3000);
		selectElement(Drawer);
		Thread.sleep(5000);
		selectElement(CaseSensitiveRoomFolder);
		Thread.sleep(5000);
		jsclick(OK_Button_BrowseforFolder);
		Thread.sleep(3000);
		getSelect_Document_Type_Dropdown();
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.click(DocumentCVRep).sendKeys("CaseSenstiveWordDocument").build().perform();

		Thread.sleep(5000);
		movingElement(Move_To_PlusIcon);
		Thread.sleep(4000);
		jsclick(NewPDfDoc);
		Thread.sleep(4000);
		EnterFileNAmePDF.sendKeys(readFromExAdvancedView(2, 1));
		Thread.sleep(6000);

		jsclick(EnterFileNameOKBTN);
		Thread.sleep(5000);
		// jsclick(PDFDocumentPage);
		jsclick(CreateBTN);
		Thread.sleep(8000);
		jsclick(viewOption);
		Thread.sleep(8000);
		jsclick(AdvancedTool);
		Thread.sleep(4000);
		// Actions act=new Actions(driver);
		// act.click(AdvancedToolTextIcon).moveToElement(Page).click().sendKeys("ContentverseAutomationTestingTeam").sendKeys(Keys.ENTER).sendKeys("Nisha").build().perform();
		/*
		 * act.click(AdvancedToolTextIcon).moveToElement(Page).click().sendKeys(
		 * readFromExAdvancedView(1, 0)).build().perform(); Thread.sleep(8000);
		 * 
		 * Thread.sleep(15000);
		 */
		act.click(AddComment).moveToElement(Page).click().build().perform();
		Thread.sleep(5000);
		jsclick(SaveTab);
		Thread.sleep(7000);
		VisiblityOf(SaveTabOKBTN);
		jsclick(SaveTabOKBTN);
		Thread.sleep(8000);
		/*
		 * jsclick(CloseIcon); Thread.sleep(3000); VisiblityOf(ReopenTheDocument);
		 * jsclick(ReopenTheDocument);
		 * 
		 * Thread.sleep(8000);
		 */
		ElementToBeClickable(AdvancedToolTextIcon);
		act.click(AdvancedToolTextIcon).moveToElement(Page).click().sendKeys(readFromExAdvancedView(0, 1))
				.sendKeys(Keys.ENTER).sendKeys(readFromExAdvancedView(1, 1)).build().perform();
		// act.click(AdvancedToolTextIcon).moveToElement(Page).click().sendKeys("ContentverseAutomationTestingTeamPDFDocument").build().perform();
		Thread.sleep(8000);
		act.click(AddComment).moveToElement(Page).click().build().perform();
		Thread.sleep(5000);
		jsclick(SaveTab);
		Thread.sleep(3000);
		VisiblityOf(SaveTabOKBTN);
		jsclick(SaveTabOKBTN);
		Thread.sleep(8000);
		jsclick(CloseIcon);
		Thread.sleep(3000);
		VisiblityOf(ReopenTheDocument);
		jsclick(ReopenTheDocument);
		Thread.sleep(8000);
		jsclick(Refresh_Button(driver));
		Thread.sleep(4000);
	}

	public void AdvancedViewExcelDocumenttCaseSensitive() throws Exception {

		jsclick(Click_New_Document);
		Thread.sleep(2000);
		jsclick(Destination_Folder_Textbox);
		Thread.sleep(3000);
		jsclick(Cabinet);
		Thread.sleep(3000);
		jsclick(Drawer);
		Thread.sleep(5000);
		jsclick(CaseSensitiveRoomFolder);
		Thread.sleep(5000);
		jsclick(OK_Button_BrowseforFolder);
		Thread.sleep(3000);
		getSelect_Document_Type_Dropdown();
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.click(DocumentCVRep).sendKeys("CaseSenstiveWordDocument").build().perform();

		Thread.sleep(5000);

		jsclick(CreateBTN);
		Thread.sleep(10000);

		jsclick(viewOption);
		Thread.sleep(10000);
		movingElement(Move_To_PlusIcon);
		Thread.sleep(2000);
		jsclick(ExcelSheet);
		Thread.sleep(3000);
		EnterFileNAmePDF.sendKeys(readFromExAdvancedView(4, 1));
		Thread.sleep(4000);

		jsclick(EnterFileNameOKBTN);
		// Actions act=new Actions(driver);
		Thread.sleep(3000);
		act.click(ExcelSheetFirstRow).sendKeys(readFromExAdvancedView(2, 0)).build().perform();
		Thread.sleep(3000);
		act.click(ExcelSheetFourthRow).sendKeys(readFromExAdvancedView(3, 0)).build().perform();
		Thread.sleep(5000);
		jsclick(SaveTab);
		Thread.sleep(7000);
		VisiblityOf(SaveTabOKBTN);
		jsclick(SaveTabOKBTN);
		Thread.sleep(8000);
		jsclick(CloseIcon);
		Thread.sleep(3000);
		VisiblityOf(ReopenTheDocument);
		jsclick(ReopenTheDocument);
		Thread.sleep(8000);
		jsclick(Refresh_Button(driver));
		Thread.sleep(7000);
	}

	/*
	 * public void AdvancedViewPDFDocument() throws Exception {
	 * Reporter.log("Scenario 4: Create new PDF document ");
	 * jsclick(Click_New_Document); Reporter.log("Click on New Document tab");
	 * Thread.sleep(2000); jsclick(Destination_Folder_Textbox);
	 * Reporter.log("Click the 'Select destination folder location' text box.");
	 * Thread.sleep(3000);
	 * Reporter.log("'Brower for folder' dialog should be open.");
	 * selectElement(Cabinet); Reporter.log("Expand the cabinet");
	 * Thread.sleep(4000); ElementToBeClickable(Drawer); selectElement(Drawer);
	 * Reporter.log("Expand drawer"); Thread.sleep(5000); selectElement(Folder);
	 * Reporter.log("Select a folder");
	 * 
	 * Reporter.log("Select a folder"); Thread.sleep(5000);
	 * 
	 * jsclick(OK_Button_BrowseforFolder);
	 * Reporter.log("Folder selected successfully..."); Thread.sleep(3000);
	 * jsclick(getSelect_Document_Type_Dropdown()); Reporter.
	 * log("Click the 'Select document type' dropdown and select the document type."
	 * ); Thread.sleep(3000); movingclkElement(Enter_ReportName);
	 * Reporter.log("Enter the value into index field"); sendvalue(Enter_ReportName,
	 * readFromExAdvancedView(2, 1)); Thread.sleep(5000);
	 * 
	 * movingElement(Move_To_PlusIcon);
	 * Reporter.log("Mouse hover on the browse icon"); Thread.sleep(4000);
	 * jsclick(NewPDfDoc); Reporter.log("Select New PDF document");
	 * Thread.sleep(4000); EnterFileNAmePDF.sendKeys(readFromExAdvancedView(2, 1));
	 * Thread.sleep(6000);
	 * 
	 * jsclick(EnterFileNameOKBTN); Reporter.log("Enter the file name");
	 * Thread.sleep(5000); jsclick(CreateBTN);
	 * Reporter.log("Click on the create button"); Thread.sleep(10000);
	 * jsclick(viewOption); Reporter.log("click on the view option");
	 * Thread.sleep(8000); jsclick(AdvancedTool);
	 * Reporter.log("Click on advanced tool icon"); Thread.sleep(4000); Actions
	 * act=new Actions(driver);
	 * //act.click(AdvancedToolTextIcon).moveToElement(Page).click().sendKeys(
	 * "ContentverseAutomationTestingTeam").sendKeys(Keys.ENTER).sendKeys("Nisha").
	 * build().perform();
	 * act.click(AdvancedToolTextIcon).moveToElement(Page).click().sendKeys(
	 * readFromExAdvancedView(1, 0)).build().perform(); Thread.sleep(8000);
	 * Reporter.log("Click on free text icon.");
	 * Reporter.log("Enter data into -free text box"); Thread.sleep(10000);
	 * act.click(AddComment).moveToElement(Page).click().build().perform();
	 * Reporter.log("Click on comment icon, add a comment");
	 * 
	 * Thread.sleep(5000); jsclick(SaveTab);
	 * Reporter.log("Comment added successfully"); Thread.sleep(7000);
	 * VisiblityOf(SaveTabOKBTN);
	 * Reporter.log("Click on save icon from viewer menu tab");
	 * jsclick(SaveTabOKBTN); Reporter.log("Document saved successfully");
	 * Thread.sleep(8000); jsclick(CloseIcon); Thread.sleep(3000);
	 * VisiblityOf(ReopenTheDocument); jsclick(ReopenTheDocument);
	 * 
	 * Thread.sleep(8000); ElementToBeClickable(AdvancedToolTextIcon);
	 * act.click(AdvancedToolTextIcon).moveToElement(Page).click().sendKeys(
	 * readFromExAdvancedView(0,
	 * 1)).sendKeys(Keys.ENTER).sendKeys(readFromExAdvancedView(1,
	 * 1)).build().perform();
	 * //act.click(AdvancedToolTextIcon).moveToElement(Page).click().sendKeys(
	 * "ContentverseAutomationTestingTeamPDFDocument").build().perform();
	 * Thread.sleep(8000);
	 * act.click(AddComment).moveToElement(Page).click().build().perform();
	 * Thread.sleep(5000); jsclick(SaveTab); Thread.sleep(3000);
	 * VisiblityOf(SaveTabOKBTN); jsclick(SaveTabOKBTN); Thread.sleep(8000);
	 * jsclick(CloseIcon); Reporter.log("Click on the Close icon");
	 * Thread.sleep(3000); VisiblityOf(ReopenTheDocument);
	 * Reporter.log("Reopen the Created pdf file document");
	 * jsclick(ReopenTheDocument); Thread.sleep(10000);
	 * 
	 * jsclick(Refresh_Button(driver));
	 * Reporter.log("All saved data should be display successfully...");
	 * Thread.sleep(4000); }
	 * 
	 * public void AdvancedViewExcelDocumentt() throws Exception {
	 * 
	 * Reporter.log("Scenario 3: Create New Excel Document "); Thread.sleep(3000);
	 * jsclick(Click_New_Document); Reporter.log("Click the New Document tab");
	 * Thread.sleep(2000); jsclick(Destination_Folder_Textbox);
	 * Reporter.log("Click the 'Select destination folder location' text box.");
	 * Thread.sleep(3000); selectElement(Cabinet);
	 * Reporter.log("Expand the cabinet"); Thread.sleep(3000);
	 * selectElement(Drawer); Reporter.log("Expand the drawer"); Thread.sleep(5000);
	 * selectElement(Folder); Reporter.log("Select a folder"); Thread.sleep(5000);
	 * 
	 * jsclick(OK_Button_BrowseforFolder);
	 * Reporter.log("Folder selected successfully..."); Thread.sleep(3000);
	 * jsclick(getSelect_Document_Type_Dropdown()); Reporter.
	 * log("Click the 'Select document type' dropdown and select the document type."
	 * ); Thread.sleep(3000); movingclkElement(Enter_ReportName);
	 * Reporter.log("Enter the value into index field"); sendvalue(Enter_ReportName,
	 * readFromExAdvancedView(4, 1)); Thread.sleep(5000);
	 * 
	 * 
	 * jsclick(CreateBTN); Reporter.log("Click on the create button");
	 * Thread.sleep(10000);
	 * 
	 * jsclick(viewOption); Reporter.log("Click on View option");
	 * Thread.sleep(10000); movingElement(Move_To_PlusIcon);
	 * Reporter.log("Mouse hover on browse icon"); Thread.sleep(2000);
	 * jsclick(ExcelSheet); Reporter.log("Select New ExcelSpread sheet");
	 * Thread.sleep(3000); EnterFileNAmePDF.sendKeys(readFromExAdvancedView(4, 1));
	 * Reporter.log("Enter file name dialog should be open"); Thread.sleep(4000);
	 * 
	 * jsclick(EnterFileNameOKBTN);
	 * Reporter.log("Enter file name and click OK button"); Actions act=new
	 * Actions(driver); Thread.sleep(3000);
	 * Reporter.log("'Enter file name' dialog should be closed successfully...");
	 * act.click(ExcelSheetFirstRow).sendKeys(readFromExAdvancedView(2,
	 * 0)).build().perform(); Thread.sleep(3000);
	 * Reporter.log("Enter data into the first row");
	 * act.click(ExcelSheetFourthRow).sendKeys(readFromExAdvancedView(3,
	 * 0)).build().perform(); Reporter.log("Enter data into the second row");
	 * Thread.sleep(5000); jsclick(SaveTab);
	 * Reporter.log("Click on save icon from viewer tool bar"); Thread.sleep(7000);
	 * VisiblityOf(SaveTabOKBTN); jsclick(SaveTabOKBTN);
	 * Reporter.log("Click on save successfull dialog box OK button");
	 * Thread.sleep(8000); jsclick(CloseIcon); Reporter.log("Click on Close icon");
	 * Thread.sleep(3000); VisiblityOf(ReopenTheDocument);
	 * jsclick(ReopenTheDocument); Reporter.log("Document closed successfully...");
	 * Reporter.log("Reopen the created document"); Thread.sleep(8000);
	 * Reporter.log("All saved data should be displayed successfully...");
	 * jsclick(Refresh_Button(driver)); Thread.sleep(3000); }
	 */

	public void AdvancedViewPDFDocument_WithSpcialCharacterFileName() throws Exception {
		Thread.sleep(2000);
		jsclick(Click_New_Document);
		Reporter.log("Scenario : Advanced viewer negative script");
		Reporter.log("Click on new document tab");
		Thread.sleep(2000);
		jsclick(Destination_Folder_Textbox);
		Reporter.log("Click on destination folder text box");
		Thread.sleep(3000);
		selectElement(Cabinet);
		Reporter.log("Expand the cabinet");
		Thread.sleep(5000);
		ElementToBeClickable(Drawer);
		selectElement(Drawer);
		Reporter.log("Expand the drawer");
		Thread.sleep(5000);
		selectElement(Folder);
		Reporter.log("Click select the folder");
		Thread.sleep(5000);
		Reporter.log("Click on Browse folder OK button");
		jsclick(OK_Button_BrowseforFolder);
		Thread.sleep(3000);
		Reporter.log("Select a document type");
		getSelect_Document_Type_Dropdown();
		Thread.sleep(3000);
		movingclkElement(Enter_ReportName);
		Reporter.log("Enter document name");
		sendvalue(Enter_ReportName, readFrmXLNEgative(2, 1));
		Thread.sleep(5000);
		movingElement(Move_To_PlusIcon);
		Reporter.log("Mouse hover on browse icon");
		Thread.sleep(4000);
		jsclick(NewPDfDoc);
		Reporter.log("User select new pdfdocument from dropdown");
		Thread.sleep(4000);
		jsclick(EnterFileNameOKBTN);
		Reporter.log("User click on file name dialog OK button");
		Thread.sleep(5000);
		Reporter.log(
				"It will show please enter file name warning message, warning message displayed successfull...Negative scenario passed");
		SoftAssertEqalValidation(FileMessage, "Please enter file name ");
		Thread.sleep(3000);
		System.out.println("Validation message:" + FileMessage.getText());
		jsclick(InvalidDilogOKBTN);
		Reporter.log("Click on invalid dialog OK button");
		Thread.sleep(4000);
		EnterFileNAmePDF.sendKeys(readFrmXLNEgative(3, 1));
		Thread.sleep(6000);

		jsclick(EnterFileNameOKBTN);
		Thread.sleep(3000);
		// jsclick(PDFDocumentPage);
		Thread.sleep(3000);
		/*
		 * WebElement viewOption =
		 * driver.findElement(By.xpath("(//button[normalize-space()='View'])[1]"));
		 * jsclick(viewOption); Thread.sleep(7000); jsclick(Refresh_Button(driver));
		 */
		jsclick(NavigateBTN);
		Thread.sleep(12000);
		jsclick(NavigateDocOpen);

	}

	public void CreateDocumentAdvancedViewWordDocument_SQL() throws Exception {
		Thread.sleep(3000);
		jsclick(Click_New_Document);
		Thread.sleep(2000);
		jsclick(Destination_Folder_Textbox);
		Thread.sleep(4000);
		/*
		 * jsclick(Cabinet); Thread.sleep(3000); jsclick(Drawer); Thread.sleep(5000);
		 * jsclick(SQLRoomFolder); Thread.sleep(5000);
		 */
		Thread.sleep(8000);

		WebElement AutomationCab = driver.findElement(By.xpath("//*[@id=\"createDocuemntNavigator\"]/ul/li[1]/ins"));
		jsclick(AutomationCab);
		Thread.sleep(5000);
		WebElement AutomationDrawer = driver
				.findElement(By.xpath("//*[@id=\"createDocuemntNavigator\"]/ul/li[1]/ul/li/ins"));
		jsclick(AutomationDrawer);
		Thread.sleep(4000);
		WebElement AutomationFolder = driver
				.findElement(By.xpath("//*[@id=\"createDocuemntNavigator\"]/ul/li[1]/ul/li/ul/li[3]/a"));
		jsclick(AutomationFolder);

		Thread.sleep(4000);
		jsclick(OK_Button_BrowseforFolder);
		Thread.sleep(4000);
		getSelect_Document_Type_Dropdown();
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.click(DocumentCVRep).sendKeys(readFrmXLNEgative(4, 1)).build().perform();
		Thread.sleep(2000);

		movingElement(Move_To_PlusIcon);
		Thread.sleep(3000);

		jsclick(WordDocument);
		EnterFileNAmePDF.sendKeys(readFromExAdvancedView(3, 1));
		Thread.sleep(3000);
		ElementToBeClickable(EnterFileNameOKBTN);
		jsclick(EnterFileNameOKBTN);
		Thread.sleep(2000);

		movingElement(Move_To_PlusIcon);
		Thread.sleep(3000);

		jsclick(WordDocument);
		EnterFileNAmePDF.sendKeys(readFromExAdvancedView(3, 1));
		Thread.sleep(3000);
		ElementToBeClickable(EnterFileNameOKBTN);
		jsclick(EnterFileNameOKBTN);
		Thread.sleep(3000);
		movingElement(Move_To_PlusIcon);
		Thread.sleep(2000);

		jsclick(WordDocument);
		EnterFileNAmePDF.sendKeys(readFromExAdvancedView(3, 1));
		Thread.sleep(2000);
		ElementToBeClickable(EnterFileNameOKBTN);
		jsclick(EnterFileNameOKBTN);
		Thread.sleep(3000);
		// Thread.sleep(15000);
		// Actions act=new Actions(driver);
		/*
		 * ElementToBeClickable(WordDocPage);
		 * act.click(WordDocPage).sendKeys(readFromExAdvancedView(2,
		 * 1)).sendKeys(Keys.ENTER).sendKeys(readFromExAdvancedView(0,
		 * 0)).build().perform(); Thread.sleep(10000); jsclick(SaveTab);
		 * Thread.sleep(8000); VisiblityOf(SaveTabOKBTN); jsclick(SaveTabOKBTN);
		 * Thread.sleep(10000); jsclick(WordDocImageOpt); Thread.sleep(2000);
		 * movingclkElement(UploadFromCmpOpt); Thread.sleep(5000);
		 * Runtime.getRuntime().exec("D:\\RNishaAutoIt\\FlowerOrCurlyBracket.exe");
		 * Thread.sleep(15000); jsclick(CreateTableopt); Thread.sleep(5000);
		 * jsclick(TableDialogOKBTN); Thread.sleep(5000); jsclick(LinkOpt);
		 * LinkAddress.sendKeys("https://github.com/Vidya3011/CV_Automation.git");
		 * Thread.sleep(3000); jsclick(TableDialogOKBTN); Thread.sleep(3000);
		 * act.click(WordDocPage).sendKeys(readFromExAdvancedView(1,
		 * 1)).build().perform();
		 * 
		 * Thread.sleep(5000); jsclick(SaveTab); Thread.sleep(3000);
		 * VisiblityOf(SaveTabOKBTN); jsclick(SaveTabOKBTN); Thread.sleep(8000);
		 * jsclick(CloseIcon); Thread.sleep(3000); VisiblityOf(ReopenTheDocument);
		 * jsclick(ReopenTheDocument); jsclick(SaveTab); Thread.sleep(3000);
		 * VisiblityOf(SaveTabOKBTN); jsclick(SaveTabOKBTN);
		 */
		WebElement CreateBTN = driver.findElement(By.xpath("//*[@id=\"createDocumentSubmit\"]"));
		jsclick(CreateBTN);
		Thread.sleep(5000);
		WebElement viewOption = driver.findElement(By.xpath("//*[@id=\"modelHome\"]"));
		jsclick(viewOption);
		Thread.sleep(3000);
		// jsclick(Refresh_Button(driver));
	}

	public void AdvancedViewPDFDocument_SQL() throws Exception {
		Thread.sleep(2000);
		jsclick(Click_New_Document);
		Thread.sleep(2000);
		jsclick(Destination_Folder_Textbox);

		Thread.sleep(3000);
		WebElement AutomationCab = driver.findElement(By.xpath("//*[@id='createDocuemntNavigator']/ul/li[1]/a"));
		selectElement(AutomationCab);
		Thread.sleep(3000);
		WebElement AutomationDrawer = driver
				.findElement(By.xpath("//*[@id='createDocuemntNavigator']/ul/li[1]/ul/li/a"));
		selectElement(AutomationDrawer);
		Thread.sleep(3000);
		WebElement AutomationFolder = driver
				.findElement(By.xpath("//*[@id='createDocuemntNavigator']/ul/li[1]/ul/li/ul/li[1]/a"));
		selectElement(AutomationFolder);
		Thread.sleep(3000);

		jsclick(OK_Button_BrowseforFolder);
		Thread.sleep(3000);
		getSelect_Document_Type_Dropdown();
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.click(DocumentCVRep).sendKeys(readFrmXLNEgative(5, 1)).build().perform();

		Thread.sleep(3000);
		movingElement(Move_To_PlusIcon);
		Thread.sleep(4000);
		jsclick(NewPDfDoc);
		Thread.sleep(3000);
		EnterFileNAmePDF.sendKeys(readFromExAdvancedView(2, 1));
		Thread.sleep(4000);

		jsclick(EnterFileNameOKBTN);
		Thread.sleep(3000);
		try {
			WebDriverWait wait1 = new WebDriverWait(driver,  Duration.ofSeconds(20));
			wait1.until(ExpectedConditions.alertIsPresent());
			Alert alt = driver.switchTo().alert();
			alt.accept();
		} catch (Exception e) {
			System.out.println("Alert not present");
		}
		// jsclick(PDFDocumentPage);
		WebElement CreateBTN = driver.findElement(By.xpath("//*[@id=\"createDocumentSubmit\"]"));
		jsclick(CreateBTN);
		Thread.sleep(4000);
		WebElement viewOption = driver.findElement(By.xpath("//*[@id=\"viewCreatedDocument\"]"));
		jsclick(viewOption);
		try {
			WebDriverWait wait1 = new WebDriverWait(driver,  Duration.ofSeconds(20));
			wait1.until(ExpectedConditions.alertIsPresent());
			Alert alt = driver.switchTo().alert();
			alt.accept();
		} catch (Exception e) {
			System.out.println("Alert not present");
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"general\"]/div/div[1]/span")).click();
		movingElement(Move_To_PlusIcon);
		Thread.sleep(4000);
		jsclick(Browse_Option);
		Thread.sleep(3000);

		Thread.sleep(3000);
		Process proc = Runtime.getRuntime().exec("D:\\RNishaAutoIt\\NishaRScript.exe");
		InputStream is = proc.getInputStream();

		int ret = 0;
		while (ret != -1) {
			ret = is.read();

		}

		try {
			WebDriverWait wait1 = new WebDriverWait(driver,  Duration.ofSeconds(20));
			wait1.until(ExpectedConditions.alertIsPresent());
			Alert alt = driver.switchTo().alert();
			alt.accept();
		} catch (Exception e) {
			System.out.println("Alert not present");
		}
		Thread.sleep(2000);
		

		movingElement(SaveTab);
		jsclick(SaveTabOKBTN);
		Thread.sleep(5000);
		jsclick(SaveTabOKBTN);
		jsclick(Refresh_Button(driver));
		Thread.sleep(4000);

	}

	public void AdvancedViewExcelDocumentt_SQL() throws Exception {

		jsclick(Click_New_Document);
		Thread.sleep(2000);
		jsclick(Destination_Folder_Textbox);
		Thread.sleep(3000);
		jsclick(Cabinet);
		Thread.sleep(3000);
		jsclick(Drawer);
		Thread.sleep(5000);
		jsclick(SQLRoomFolder);
		Thread.sleep(5000);
		jsclick(OK_Button_BrowseforFolder);
		Thread.sleep(3000);
		getSelect_Document_Type_Dropdown();
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.click(DocumentCVRep).sendKeys(readFrmXLNEgative(3, 1)).build().perform();

		Thread.sleep(5000);

		jsclick(CreateBTN);
		Thread.sleep(8000);

		jsclick(viewOption);
		Thread.sleep(8000);
		movingElement(Move_To_PlusIcon);
		Thread.sleep(2000);
		jsclick(ExcelSheet);
		Thread.sleep(3000);
		EnterFileNAmePDF.sendKeys(readFromExAdvancedView(4, 1));
		Thread.sleep(4000);

		jsclick(EnterFileNameOKBTN);
		// Actions act=new Actions(driver);
		Thread.sleep(3000);
		act.click(ExcelSheetFirstRow).sendKeys(readFromExAdvancedView(2, 0)).build().perform();
		Thread.sleep(3000);
		act.click(ExcelSheetFourthRow).sendKeys(readFromExAdvancedView(3, 0)).build().perform();
		Thread.sleep(5000);
		jsclick(SaveTab);
		Thread.sleep(7000);
		VisiblityOf(SaveTabOKBTN);
		jsclick(SaveTabOKBTN);
		Thread.sleep(8000);
		jsclick(CloseIcon);
		Thread.sleep(3000);
		VisiblityOf(ReopenTheDocument);
		jsclick(ReopenTheDocument);
		Thread.sleep(8000);
		jsclick(Refresh_Button(driver));
		Thread.sleep(3000);
	}

	public void ExpandNodes() throws Exception {
		Thread.sleep(1000);
		// jsclick(Refresh_Button(driver));
		/*
		 * Thread.sleep(2000); jsclick(Click_New_Document); Thread.sleep(2000);
		 * jsclick(Destination_Folder_Textbox);
		 */

		Thread.sleep(3000);
		WebElement AutomationCab = driver.findElement(By.xpath("//*[@id='viewDocumentnavigator']/ul/li[4]/a"));
		selectElement(AutomationCab);
		Thread.sleep(4000);
		WebElement AutomationDrawer = driver.findElement(By.xpath("//*[@id='viewDocumentnavigator']/ul/li[4]/ul/li/a"));
		selectElement(AutomationDrawer);
		Thread.sleep(2000);
		WebElement AutomationFolder = driver
				.findElement(By.xpath("//*[@id='viewDocumentnavigator']/ul/li[4]/ul/li/ul/li/a"));
		selectElement(AutomationFolder);
		Thread.sleep(2000);

	}

	public void CerateDocPDF() throws Exception {
		/*
		 * Thread.sleep(1000); jsclick(Refresh_Button(driver)); Thread.sleep(2000);
		 * jsclick(Click_New_Document); Thread.sleep(2000);
		 * jsclick(Destination_Folder_Textbox);
		 * 
		 * Thread.sleep(3000); WebElement AutomationCab =
		 * driver.findElement(By.xpath("//*[@id='createDocuemntNavigator']/ul/li[1]/a"))
		 * ; selectElement(AutomationCab); Thread.sleep(2000); WebElement
		 * AutomationDrawer = driver.findElement(By.xpath(
		 * "//*[@id='createDocuemntNavigator']/ul/li[1]/ul/li/a"));
		 * selectElement(AutomationDrawer); Thread.sleep(2000); WebElement
		 * AutomationFolder = driver.findElement(By.xpath(
		 * "//*[@id='createDocuemntNavigator']/ul/li[1]/ul/li/ul/li[1]/a"));
		 * selectElement(AutomationFolder); Thread.sleep(2000);
		 * 
		 * jsclick(OK_Button_BrowseforFolder);
		 */
		Thread.sleep(2000);
		jsclick(Click_New_Document);
		Thread.sleep(2000);

		Thread.sleep(3000);
		getSelect_Document_Type_Dropdown();
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		try {

			act.click(DocumentCVRep).sendKeys(readFrmXLNEgative(5, 1)).build().perform();
		} catch (Exception e) {
			System.out.println("Document name not enter failed");
		}
		Thread.sleep(3000);
		// driver.findElement(By.xpath("//*[@id=\"general\"]/div/div[1]/span")).click();
		// movingElement(Move_To_PlusIcon);
		movingElement(Move_To_PlusIcon);
		Thread.sleep(4000);
		jsclick(NewPDfDoc);
		Thread.sleep(5000);
		EnterFileNAmePDF.sendKeys(readFromExAdvancedView(2, 1));
		Thread.sleep(3000);

		jsclick(EnterFileNameOKBTN);
		Thread.sleep(3000);
		try {
			WebDriverWait wait1 = new WebDriverWait(driver,  Duration.ofSeconds(20));
			wait1.until(ExpectedConditions.alertIsPresent());
			Alert alt = driver.switchTo().alert();
			alt.accept();
		} catch (Exception e) {
			System.out.println("Alert not present");
		}
		/*
		 * Thread.sleep(2000); movingElement(Move_To_PlusIcon);
		 * 
		 * try {
		 * 
		 * act.moveToElement(Browse_Option).click().build().perform(); }
		 * catch(JavascriptException e) { System.out.println("Exception there"); }
		 * 
		 * 
		 * Thread.sleep(5000); try { Process
		 * proc=Runtime.getRuntime().exec("D:\\RNishaAutoIt\\SIDBIAuto.exe");
		 * InputStream is= proc.getInputStream(); int ret=0; while(ret != -1) {
		 * ret=is.read();
		 * 
		 * } } catch(Exception e) {
		 * System.out.println("Creating document without page"); }
		 * 
		 * 
		 * 
		 * try { alertIsPresent(); acceptAlert(); } catch(Exception e) {
		 * System.out.println("Alert not present"); }
		 */
		Thread.sleep(2000);
		WebElement CreateBTN = driver.findElement(By.xpath("//*[@id=\"createDocumentSubmit\"]"));
		jsclick(CreateBTN);
		try {

			// *[@id='messageContent']
			WebElement Repname = driver.findElement(By.xpath("//*[@id='messageButtonOK']"));
			WebElement Repnamedialog = driver.findElement(By.xpath("//*[@id='messageContent']"));
			if (Repnamedialog.isDisplayed()) {
				jsclick(Repname);
			}
		} catch (Exception e) {
			System.out.println("Document created successfully...");
		}

		Thread.sleep(2000);
		WebElement viewOption = driver.findElement(By.xpath("//*[@id=\"viewCreatedDocument\"]"));
		jsclick(viewOption);
		try {
			WebDriverWait wait1 = new WebDriverWait(driver,  Duration.ofSeconds(20));
			wait1.until(ExpectedConditions.alertIsPresent());
			Alert alt = driver.switchTo().alert();
			alt.accept();
		} catch (Exception e) {
			System.out.println("Alert not present");
		}

	}

	public void UpdateDocument() throws Exception {
		Actions act = new Actions(driver);
		driver.findElement(By.xpath("//*[@id=\"general\"]/div/div[1]/span")).click();
		Thread.sleep(2000);

		movingElement(Move_To_PlusIcon);

		try {

			act.moveToElement(Browse_Option).click().build().perform();
		} catch (JavascriptException e) {
			System.out.println("Exception there");
		}

		Thread.sleep(5000);
		try {
			Process proc = Runtime.getRuntime().exec("D:\\RNishaAutoIt\\SIDBIAuto.exe");
			InputStream is = proc.getInputStream();
			int ret = 0;
			while (ret != -1) {
				ret = is.read();

			}
		} catch (Exception e) {
			System.out.println("Creating document without page");
		}

		try {
			alertIsPresent();
			acceptAlert();
		} catch (Exception e) {
			System.out.println("Alert not present");
		}
		Thread.sleep(4000);
		jsclick(SaveTab);
		Thread.sleep(5000);
		try {
			VisiblityOf(SaveTabOKBTN);
			jsclick(SaveTabOKBTN);
		} catch (Exception e) {
			System.out.println("Save OK Button Clicked");
		}
		Thread.sleep(8000);
	}

	public void create_document_Auto() throws Exception {

		Thread.sleep(2000);
		jsclick(Click_New_Document);
		Thread.sleep(2000);

		Thread.sleep(3000);
		getSelect_Document_Type_Dropdown();
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		try {

			act.click(DocumentCVRep).sendKeys(readFrmXLNEgative(5, 1)).build().perform();
		} catch (Exception e) {
			System.out.println("Document name not enter failed");
		}
		Thread.sleep(3000);
		movingElement(Move_To_PlusIcon);

		try {

			act.moveToElement(Browse_Option).click().build().perform();
		} catch (JavascriptException e) {
			System.out.println("Exception there");
		}

		Thread.sleep(25000);
		try {
			Process proc = Runtime.getRuntime().exec("D:\\RNishaAutoIt\\NishaRScript.exe");
			InputStream is = proc.getInputStream();
			int ret = 0;
			while (ret != -1) {
				ret = is.read();

			}
		} catch (Exception e) {
			System.out.println("Creating document without page");
		}

		Thread.sleep(6000);
		try {
			alertIsPresent();
			acceptAlert();
		} catch (Exception e) {
			System.out.println("Alert not present");
		}
		Thread.sleep(5000);
		WebElement CreateBTN = driver.findElement(By.xpath("//*[@id=\"createDocumentSubmit\"]"));
		jsclick(CreateBTN);
		Thread.sleep(7000);

		try {

			WebElement Repname = driver.findElement(By.xpath("//*[@id='messageButtonOK']"));

			WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(Repname));

			jsclick(Repname);

		} catch (Exception e) {
			System.out.println("Document created successfully...");
		}

		Thread.sleep(4000);
		WebElement viewOption = driver.findElement(By.xpath("//*[@id=\"viewCreatedDocument\"]"));
		jsclick(viewOption);
		try {
			WebDriverWait wait1 = new WebDriverWait(driver,  Duration.ofSeconds(20));
			wait1.until(ExpectedConditions.alertIsPresent());
			Alert alt = driver.switchTo().alert();
			alt.accept();
		} catch (Exception e) {
			System.out.println("Alert not present");
		}

	}

	public void CreateDocumentAdvancedViewWordDocument() throws Exception {
		Reporter.log("Scenario 2: Create a document with Advanced viewer -  new word document.");
		jsclick(Click_New_Document);
		Reporter.log("Click the New Document tab.");
		Thread.sleep(2000);
		jsclick(Destination_Folder_Textbox);

		Reporter.log("Click the 'Select destination folder location' text box.");
		Thread.sleep(3000);
		Reporter.log("'Brower for folder' dialog should be open.");
		selectElement(Cabinet);
		Reporter.log("Expand the cabinet");
		Thread.sleep(4000);
		VisiblityOf(Drawer);
		selectElement(Drawer);
		Reporter.log("Expand drawer");
		Thread.sleep(5000);
		selectElement(Folder);
		Reporter.log("Select a folder");
		Thread.sleep(5000);

		jsclick(OK_Button_BrowseforFolder);
		Reporter.log("Folder selected successful...");
		Thread.sleep(3000);
		getSelect_Document_Type_Dropdown();
		Reporter.log("Click on 'Select document type' dropdown and select the document type.");
		Reporter.log("Document type selected successful...");
		Thread.sleep(3000);
		movingclkElement(Enter_ReportName);
		Reporter.log("Enter the value into index field");
		sendvalue(Enter_ReportName, readFromExAdvancedView(3, 1));
		Thread.sleep(5000);

		movingElement(Move_To_PlusIcon);
		Reporter.log("Mouse hover on the browse icon");
		Thread.sleep(5000);
		jsclick(WordDocument);
		Reporter.log("Select a 'New Word Document'");
		EnterFileNAmePDF.sendKeys(readFromExAdvancedView(3, 1));
		Thread.sleep(5000);
		Reporter.log("Enter file name dialog should be open.");
		ElementToBeClickable(EnterFileNameOKBTN);
		Reporter.log("Enter the file name.");
		jsclick(EnterFileNameOKBTN);
		Reporter.log("Click on OK button.");
		Reporter.log("'Enter file name' dialog should be closed successful...");
		Thread.sleep(8000);

		jsclick(CreateBTN);
		Reporter.log("Click on Create button");
		Thread.sleep(10000);

		jsclick(viewOption);
		Reporter.log("'Document Created Successfully' dialog should be displayed");
		Reporter.log("Click on View option");
		Thread.sleep(15000);
		Actions act = new Actions(driver);
		ElementToBeClickable(WordDocPage);
		act.click(WordDocPage).sendKeys(readFromExAdvancedView(2, 1)).sendKeys(Keys.ENTER)
				.sendKeys(readFromExAdvancedView(0, 0)).build().perform();
		Reporter.log("Enter data into the page");
		Thread.sleep(10000);
		jsclick(SaveTab);

		Reporter.log("Click on the Save icon from viewer tool bar.");
		Thread.sleep(8000);
		VisiblityOf(SaveTabOKBTN);
		jsclick(SaveTabOKBTN);
		Reporter.log("Click on save successfull dialog OK button.");
		Thread.sleep(10000);
		jsclick(WordDocImageOpt);
		Reporter.log("Click on image icon,it will show 'upload from computer' option.");
		Thread.sleep(2000);
		movingclkElement(UploadFromCmpOpt);
		Reporter.log("Select the 'upload from computer' option.");
		Thread.sleep(10000);
		Runtime.getRuntime().exec("D:\\RNishaAutoIt\\FlowerOrCurlyBracket.exe");
		Thread.sleep(10000);
		Reporter.log("Using Auto IT add the image from folder successful.");
		jsclick(CreateTableopt);
		Reporter.log("Click on Table icon.");
		Thread.sleep(5000);
		jsclick(TableDialogOKBTN);
		Reporter.log("Add the table into the page.");
		Thread.sleep(5000);
		/*
		 * jsclick(LinkOpt);
		 * LinkAddress.sendKeys("https://github.com/Vidya3011/CV_Automation.git");
		 * Thread.sleep(3000); jsclick(TableDialogOKBTN);
		 */
		Thread.sleep(3000);
		act.click(WordDocPage).sendKeys(readFromExAdvancedView(1, 1)).build().perform();
		Reporter.log("Enter the data inside the table");
		Thread.sleep(5000);
		jsclick(SaveTab);
		Reporter.log("Click on the save icon from viewer tool bar");
		Thread.sleep(3000);
		VisiblityOf(SaveTabOKBTN);
		jsclick(SaveTabOKBTN);
		Reporter.log("The added data has been saved successfully...");
		Thread.sleep(8000);
		jsclick(CloseIcon);
		Reporter.log("Click on the close icon");
		Thread.sleep(3000);

		VisiblityOf(ReopenTheDocument);
		Reporter.log("Document closed successfully...");
		jsclick(ReopenTheDocument);
		Reporter.log("Reopen the created word file document...");
		Thread.sleep(10000);
		Reporter.log("All saved data should be display successfully...");
		// jsclick(Refresh_Button(driver));
	}

	public void AdvancedViewPDFDocument() throws Exception {
		Reporter.log("Scenario 4:Create a document with Advanced viewer -  new PDF document ");
		jsclick(Click_New_Document);
		Reporter.log("Click on New Document tab");

		Thread.sleep(3000);
		getSelect_Document_Type_Dropdown();
		Reporter.log("Click the 'Select document type' dropdown and select the document type.");
		Thread.sleep(3000);
		movingclkElement(Enter_ReportName);
		Reporter.log("Enter the value into index field");
		sendvalue(Enter_ReportName, readFromExAdvancedView(2, 1));
		Thread.sleep(5000);

		movingElement(Move_To_PlusIcon);
		Reporter.log("Mouse hover on the browse icon");
		Thread.sleep(4000);
		jsclick(NewPDfDoc);
		Reporter.log("Select New PDF document");
		Thread.sleep(4000);
		EnterFileNAmePDF.sendKeys(readFromExAdvancedView(2, 1));
		Thread.sleep(6000);

		jsclick(EnterFileNameOKBTN);
		Reporter.log("Enter the file name");
		Thread.sleep(5000);
		jsclick(CreateBTN);
		Reporter.log("Click on the create button");
		Thread.sleep(10000);
		jsclick(viewOption);
		Reporter.log("click on the view option");
		Thread.sleep(8000);
		jsclick(AdvancedTool);
		Reporter.log("Click on advanced tool icon");
		Thread.sleep(4000);
		Actions act = new Actions(driver);
		// act.click(AdvancedToolTextIcon).moveToElement(Page).click().sendKeys("ContentverseAutomationTestingTeam").sendKeys(Keys.ENTER).sendKeys("Nisha").build().perform();
		act.click(AdvancedToolTextIcon).moveToElement(Page).click().sendKeys(readFromExAdvancedView(1, 0)).build()
				.perform();
		Thread.sleep(8000);
		Reporter.log("Click on free text icon.");
		Reporter.log("Enter data into -free text box");
		Thread.sleep(10000);
		act.click(AddComment).moveToElement(Page).click().build().perform();
		Reporter.log("Click on comment icon, add a comment");

		Thread.sleep(5000);
		jsclick(SaveTab);
		Reporter.log("Comment added successfully");
		Thread.sleep(7000);
		VisiblityOf(SaveTabOKBTN);
		Reporter.log("Click on save icon from viewer menu tab");
		jsclick(SaveTabOKBTN);
		Reporter.log("Document saved successfully");
		Thread.sleep(8000);
		/*
		 * jsclick(CloseIcon); Thread.sleep(3000); VisiblityOf(ReopenTheDocument);
		 * jsclick(ReopenTheDocument);
		 * 
		 * Thread.sleep(8000);
		 */
		ElementToBeClickable(AdvancedToolTextIcon);
		act.click(AdvancedToolTextIcon).moveToElement(Page).click().sendKeys(readFromExAdvancedView(0, 1))
				.sendKeys(Keys.ENTER).sendKeys(readFromExAdvancedView(1, 1)).build().perform();
		// act.click(AdvancedToolTextIcon).moveToElement(Page).click().sendKeys("ContentverseAutomationTestingTeamPDFDocument").build().perform();
		Thread.sleep(8000);
		act.click(AddComment).moveToElement(Page).click().build().perform();
		Thread.sleep(5000);
		jsclick(SaveTab);
		Thread.sleep(3000);
		VisiblityOf(SaveTabOKBTN);
		jsclick(SaveTabOKBTN);
		Thread.sleep(8000);
		jsclick(CloseIcon);
		Reporter.log("Click on the Close icon");
		Thread.sleep(3000);
		VisiblityOf(ReopenTheDocument);
		Reporter.log("Reopen the Created pdf file document");
		jsclick(ReopenTheDocument);
		Thread.sleep(10000);

		// jsclick(Refresh_Button(driver));
		Reporter.log("All saved data should be display successfully...");
		Thread.sleep(4000);
	}

	public void AdvancedViewExcelDocumentt() throws Exception {

		Reporter.log("Scenario 3: Create a document with Advanced viewer - 'New Excel Document' ");
		Thread.sleep(3000);
		jsclick(Click_New_Document);
		Reporter.log("Click on the New Document tab");

		Thread.sleep(3000);
		getSelect_Document_Type_Dropdown();
		Reporter.log("Click on the 'Select document type' dropdown and select the document type.");
		Thread.sleep(3000);
		movingclkElement(Enter_ReportName);
		Reporter.log("Enter the value into index field");
		sendvalue(Enter_ReportName, readFromExAdvancedView(4, 1));
		Thread.sleep(5000);

		jsclick(CreateBTN);
		Reporter.log("Click on the create button");
		Thread.sleep(10000);

		jsclick(viewOption);
		Reporter.log("Click on View option");
		Thread.sleep(10000);
		movingElement(Move_To_PlusIcon);
		Reporter.log("Mouse hover on browse icon");
		Thread.sleep(2000);
		jsclick(ExcelSheet);
		Reporter.log("Select New Excel sheet");
		Thread.sleep(3000);
		EnterFileNAmePDF.sendKeys(readFromExAdvancedView(4, 1));
		Reporter.log("Enter file name dialog should be open");
		Thread.sleep(4000);

		jsclick(EnterFileNameOKBTN);
		Reporter.log("Enter file name and click OK button");
		Actions act = new Actions(driver);
		Thread.sleep(8000);
		Reporter.log("'Enter file name' dialog should be closed successfully...");
		act.click(ExcelSheetFirstRow).sendKeys(readFromExAdvancedView(2, 0)).build().perform();
		Thread.sleep(3000);
		Reporter.log("Enter data into the first row");
		act.click(ExcelSheetFourthRow).sendKeys(readFromExAdvancedView(3, 0)).build().perform();
		Reporter.log("Enter data into the second row");
		Thread.sleep(5000);
		jsclick(SaveTab);
		Reporter.log("Click on save icon from viewer tool bar");
		Thread.sleep(7000);
		VisiblityOf(SaveTabOKBTN);
		jsclick(SaveTabOKBTN);
		Reporter.log("Click on 'Save successful' dialog box OK button");
		Thread.sleep(8000);
		jsclick(CloseIcon);
		Reporter.log("Click on Close icon");
		Thread.sleep(3000);
		VisiblityOf(ReopenTheDocument);
		jsclick(ReopenTheDocument);
		Reporter.log("Document closed successfully...");
		Reporter.log("Reopen the created document");
		Thread.sleep(8000);
		Reporter.log("All saved data should be displayed successfully...");
		jsclick(Refresh_Button(driver));
		Thread.sleep(5000);
	}

}
