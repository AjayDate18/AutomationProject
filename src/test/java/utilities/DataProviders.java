package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	//DataProvider1
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		//Taking Excel File from TestData
		String path=".\\testData\\LoginExcel.xlsx";
		//Creating Object of of ExcelUtil
		ExcelUtility excelutil=new ExcelUtility(path);
		
		int totalrows=excelutil.getRowCount("Sheet1");
		int totalcols=excelutil.getCellCount("Sheet1",1);
		
		//created 2 Dimensional array which store data from excel sheet
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=excelutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
		//returning two Dimensional Array
		
	}
}
