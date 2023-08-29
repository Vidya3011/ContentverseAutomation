package Pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class ToDoListTab {
	@FindBy(xpath = ("//a[@id='myTaskMenu']"))
	private WebElement TodolistTab;
	
	@FindBy(xpath = ("//a[@id='newItems']"))
	private WebElement NewItems;
	
//	@FindBy(xpath = ("//*[@id=\"todoListTable\"]/tbody/tr[1]/td[1]"))
//	private WebElement TodolistDoc;
	
	@FindBy(xpath = ("//td[contains(@class,'details-control')]"))
	private WebElement TodolistDoc;
	
	@FindBy(xpath = ("//a[@id='accept']"))
	private WebElement AcceptButton;
;
	
	@FindBy(xpath = ("//a[@id='reject']"))
	private WebElement RejectButton;
	
	@FindBy(xpath = ("//a[@id='endwf']"))
	private WebElement EndWfButton;
	
	@FindBy(xpath = ("//a[@id='summary1']"))
	private WebElement SummaryButton;
	
	@FindBy(xpath = ("//textarea[@id='wfcomments']"))
	private WebElement WorkflowComments;
	
	@FindBy(xpath = ("//button[@id='wfactionOk']"))
	private WebElement WorkflowCommentsOKButton;
	
	public WebDriver driver;
	
	Actions action;
	public ToDoListTab(WebDriver driver) {
		PageFactory.initElements(driver, this);
}
	
	public void SetNewItemsAccept() {
		TodolistTab.click();
		Reporter.log("To-do list tab is clicked ", true);
//		action.moveToElement(NewItems).build().perform();
//		Reporter.log("New Items is clicked ", true);
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(TodolistDoc)); 
//		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		action.click(TodolistDoc).build().perform();
		//AcceptButton.click();
//		WorkflowComments.sendKeys(arg0);
//		WorkflowCommentsOKButton.click();
	}

}
