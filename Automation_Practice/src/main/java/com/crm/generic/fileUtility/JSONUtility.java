package com.crm.generic.fileUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author Subrat Kumar Sahoo
 * This class contains all reusable methods to read the data from JSON file.
 */
public class JSONUtility {

	
	/**@author Subrat Kumar Sahoo
	 * This method is used to get data from json file based on the key.
	 * @param upperLimit
	 * @return String
	 */
	public String getDatafromJSONFile(String key) throws IOException, Throwable
	{
		FileReader fr=new FileReader("C:\\Users\\Rutusmita prusty\\OneDrive\\Desktop\\CommonData\\VTigerCRMData.json");
		
		
		JSONParser jp=new JSONParser();
		
		Object obj=jp.parse(fr);
		
		JSONObject jo=(JSONObject) obj;
		
		String value=jo.get(key).toString();
		
		return value;
	}
}
