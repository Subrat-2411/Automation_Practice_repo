package testNGExamples;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.Org.OR.CreatingNewOrganization;
import com.crm.Org.OR.HomePage;
import com.crm.Org.OR.OrganizationInformationPage;
import com.crm.Org.OR.OrganizationsPage;
import com.crm.baseTest.BaseClass;
import com.crm.generic.fileUtility.ExcelUtility;
import com.crm.generic.fileUtility.JavaUtility;
import com.crm.generic.listenerUtility.ListenerUtility;
import com.crm.generic.objectUtility.UtilityClassObject;

@Listeners(ListenerUtility.class)
public class CreateOrganizationTest extends BaseClass {

	/*If you are passing parameter before running the test script but forgot to provide parameter in suite file, then below error message will be displayed.
	 * Basically you get org.testng.TestNGException 
	 * 
	 * In order to avoid that we go for @optional in method parameter.
	 * 
	 * Parameter 'browser' is required by @Test on method createOrganizationTest but has not been marked @Optional or defined
*/
	@Test(groups = {"SmokeTest"})
	public void createOrganizationTest() throws Throwable
	{
		
		JavaUtility jutil=new JavaUtility();
		
		ExcelUtility eutil=new ExcelUtility();
		
		UtilityClassObject.getTest().log(Status.INFO,"Getting random number");

		int ranNum=jutil.getRandomNumber(1000);
		
		UtilityClassObject.getTest().log(Status.INFO,"Read data from excel");
		String oName=eutil.getDataFromExcel("Organization",1,2)+ranNum;
		
		String website=eutil.getDataFromExcel("Organization",1,3);
		
		HomePage hp=new HomePage(driver);
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to the Organizations Page");

		hp.getOrganizationLink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to Create Organization Page");

		op.getCreateOrganizationIcon().click();
		
		CreatingNewOrganization co=new CreatingNewOrganization(driver);
		
		UtilityClassObject.getTest().log(Status.INFO,"Creating an Organization");

		co.createOrganization(oName, website);
		
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		UtilityClassObject.getTest().log(Status.INFO,"Verifying Organization Name");

		
		oip.verifyOrganizationNameAndDelete(oName);
		
		
		
	}
	
	@Test(groups = {"RegressionTest"})
	public void createOrganizationWithIndustry() throws Throwable
	{
		
		JavaUtility jutil=new JavaUtility();
		
		ExcelUtility eutil=new ExcelUtility();
		UtilityClassObject.getTest().log(Status.INFO,"Getting random number");
		int ranNum=jutil.getRandomNumber();
		UtilityClassObject.getTest().log(Status.INFO,"Read data from excel");

		String oName=eutil.getDataFromExcel("Organization",1,2)+ranNum;
		
		String website=eutil.getDataFromExcel("Organization",1,3);
		
		HomePage hp=new HomePage(driver);
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to the Organizations Page");

		hp.getOrganizationLink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		
		op.getCreateOrganizationIcon().click();
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to Create Organization Page");

		CreatingNewOrganization co=new CreatingNewOrganization(driver);
		UtilityClassObject.getTest().log(Status.INFO,"Creating an Organization with the help of Industry");

		co.createOrganizationWithIndustry(oName, website,"Biotechnology");
		
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		
		
		UtilityClassObject.getTest().log(Status.INFO,"Verifying Organization Name");

		oip.verifyOrganizationName(oName);
		
	}
}
