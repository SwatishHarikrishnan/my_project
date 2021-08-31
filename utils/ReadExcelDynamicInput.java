package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDynamicInput {

	public static String[][] Excelinput(String filename) throws IOException {

		XSSFWorkbook excel = new XSSFWorkbook("D:\\SWAT_DOCUMENTS\\SELF_LEARN\\imp\\softwares\\eclipse_64bit\\Selenium\\Data\\"+filename+".xlsx");
		
		XSSFSheet sheet = excel.getSheet("Sheet1");
		
		int numofrows = sheet.getLastRowNum();
		int numofcolumns = sheet.getRow(0).getLastCellNum();
		String Data[][]=new String[numofrows][numofcolumns];
		for(int i=1;i<=numofrows;i++)
		{
			for(int j=0;j<numofcolumns;j++)
			{
				String text = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(text);
				Data[i-1][j]=text;
			}
		}
		excel.close();
		return Data;
	}

}
