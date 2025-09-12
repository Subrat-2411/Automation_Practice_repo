package testNGExamples;

import org.testng.annotations.Test;

public class DataProviderImplementation {

	@Test(dataProviderClass = Dataprovider.class,dataProvider = "getData")
	public void implementDataProvider(String firstName,String lastName)
	{
		System.out.println("FirstName:- "+firstName+" , LastName:- "+lastName);
	}
}
