package com.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * @author Subrat Kumar Sahoo
 * This class contains all reusable methods to read the data from property file.
 */
public class FileUtility {

	/**@author Subrat Kumar Sahoo
	 * This method is used to get data from property file based on the key.
	 * @param upperLimit
	 * @return String
	 */
	public String getDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/commondata.properties");
		
		Properties pro=new Properties();
		
		pro.load(fis);
		
		String value=pro.getProperty(key);
		
		return value;
		
	}
	
}
