package com.crm.organizationTest;

import org.testng.annotations.Test;

import com.crm.Org.OR.CreatingNewOrganization;
import com.crm.Org.OR.HomePage;
import com.crm.Org.OR.OrganizationInformationPage;
import com.crm.Org.OR.OrganizationsPage;
import com.crm.baseTest.BaseClass;
import com.crm.generic.fileUtility.ExcelUtility;
import com.crm.generic.fileUtility.JavaUtility;

public class CreateOrganizationTest extends BaseClass {

	
	@Test(groups = {"SmokeTest"})
	public void createOrganizationTest() throws Throwable
	{
		
		JavaUtility jutil=new JavaUtility();
		
		ExcelUtility eutil=new ExcelUtility();
		
		int ranNum=jutil.getRandomNumber();
		
		String oName=eutil.getDataFromExcel("Organization",1,2)+ranNum;
		
		String website=eutil.getDataFromExcel("Organization",1,3);
		
		HomePage hp=new HomePage(driver);
		
		hp.getOrganizationLink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		
		op.getCreateOrganizationIcon().click();
		
		CreatingNewOrganization co=new CreatingNewOrganization(driver);
		
		co.createOrganization(oName, website);
		
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		
		Thread.sleep(3000);
		
		oip.verifyOrganizationName(oName);
		
	}
	
	@Test(groups = {"RegressionTest"})
	public void createOrganizationWithIndustry() throws Throwable
	{
		
		JavaUtility jutil=new JavaUtility();
		
		ExcelUtility eutil=new ExcelUtility();
		
		int ranNum=jutil.getRandomNumber();
		
		String oName=eutil.getDataFromExcel("Organization",1,2)+ranNum;
		
		String website=eutil.getDataFromExcel("Organization",1,3);
		
		HomePage hp=new HomePage(driver);
		
		hp.getOrganizationLink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		
		op.getCreateOrganizationIcon().click();
		
		CreatingNewOrganization co=new CreatingNewOrganization(driver);
		
		co.createOrganizationWithIndustry(oName, website,"Biotechnology");
		
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		
		Thread.sleep(3000);
		
		oip.verifyOrganizationName(oName);
		
	}
}
