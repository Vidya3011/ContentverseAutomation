package Script;

import org.apache.logging.log4j.LogManager;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Generic.BaseClass;
import Pom.AdvancedViewer;

public class Creating_More_Document extends BaseClass {
	private static org.apache.logging.log4j.Logger log = LogManager.getLogger(Creating_More_Document.class);

	@BeforeClass
	public void ladBrowser() {
		loadBrowser("Chrome");

		log.info("Chrome Browser Launched");
		Reporter.log("Chrome Browser launched Successfully...");
		launch47Url();
		// launchLocalUrl();
		Reporter.log("Contentverse URL launched successfully...");
		log.info("Contentverse URL launched successfully...");
	}

	@Test(priority = 1)
	public void Login() throws Exception {
	
		//LogoutPage();
		loginRNISHA47();
		
		Reporter.log("User logged in successfully... ");
		log.info("Rnisha user logged in 'CVWin19Server.Win2019_TestRoom'successfully... ");
	}

	
	@Test(priority = 2,invocationCount=100)
	public void TC_1_ShowThumbnail() throws Exception {

		AdvancedViewer adv = new AdvancedViewer();
		adv.CreateDocumentMore();

	}

}
