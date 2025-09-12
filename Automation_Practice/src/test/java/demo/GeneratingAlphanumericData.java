package demo;

import org.testng.annotations.Test;

public class GeneratingAlphanumericData {

	
	@Test
	public void generateAlphaNumericData()
	{
		
		int n=10;
		
		String exp="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
		
		StringBuilder sb=new StringBuilder(n);
		
		for(int i=0;i<n;i++)
		{
			int index=(int) (exp.length()*Math.random());
			
			sb.append(exp.charAt(index));
		}
		
		System.out.println(sb);
		
		
	}
}
