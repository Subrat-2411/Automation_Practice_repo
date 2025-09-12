package com.crm.generic.fileUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * @author Subrat Kumar Sahoo
 * This class contains all reusable methods to read the data from Java file.
 */
public class JavaUtility {

	
	/**@author Subrat Kumar Sahoo
	 * This method is used to get random number of int type.
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran=new Random();
		
		return ran.nextInt(200);
		
	}
	
	
	/**@author Subrat Kumar Sahoo
	 * This method is used get random number based on the upper limit.
	 * @param upperLimit
	 * @return int
	 */
	public int getRandomNumber(int upperLimit)
	{
		Random ran=new Random();
		
		return ran.nextInt(upperLimit);
		
	}
	/**@author Subrat Kumar Sahoo
	 * This method is used to get System date in YYYY-MM-DD format.
	 * @return String
	 */
	public String getSystemDateyyyyMMdd()
	{
		Date date=new Date();
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		
		return sim.format(date);
	}
	
	/**@author Subrat Kumar Sahoo
	 * This method is used to get System date in user specified format.
	 * @return String
	 */
	public String getSystemDateyyyyMMdd(String format)
	{
		Date date=new Date();
		
		SimpleDateFormat sim=new SimpleDateFormat(format);
		
		return sim.format(date);
	}
	
	
	/**@author Subrat Kumar Sahoo
	 * This method is used to get the required date in yyyy-mm-dd format.
	 * @param days
	 * @return String
	 */
	public String getRequiredDate(int days)
	{
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = sim.getCalendar();
		
		cal.add(Calendar.DAY_OF_MONTH,days);
		
		String value = sim.format(cal.getTime());
		
		return value;
	}
	
	
}
