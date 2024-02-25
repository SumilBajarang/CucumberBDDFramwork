package StepDefinition;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;

/*Parent Class*/
public class BaseClass {
	public WebDriver driver;
	public LoginPage loginPg;
	public SearchCustomerPage SearchCustPg;
	public AddNewCustomerPage addNewCustPg;
	public Logger log;
	
	//generate unique email id
	public String generateEmailId()
	{
		return(RandomStringUtils.randomAlphabetic(5));
	}
	
	//hard wait
	public void hardWait(int wait) {
		try {
			Thread.sleep(wait*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
