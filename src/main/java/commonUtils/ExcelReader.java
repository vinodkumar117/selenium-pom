package commonUtils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

	static XSSFWorkbook wb=null;
	
	public static Object[][] getDataFromSheet(String sheetName)
	{

		try 
		{
			wb = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/excel/ExcelData.xlsx")));
		} catch (FileNotFoundException e) 
		{
			System.out.println("File not found "+e.getMessage());
		} catch (IOException e) {
			
			System.out.println("Could not read files "+e.getMessage());
		}
		
		int row=wb.getSheet(sheetName).getPhysicalNumberOfRows();
		
		int column=wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
	  
		Object [][]arr=new Object[row-1][column];
		
		for(int i=1;i<row;i++)
		{  
			
			for(int j=0;j<column;j++)
			{
				arr[i-1][j]=getData(sheetName,i,j);
			}

		}
		

		return arr;
		
	}
	
	
	public static String getData(String sheetName,int row,int column)
	{
		
		XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(column);
		
		String data="";
		
		if(cell.getCellType()==CellType.STRING)
		{
			data=cell.getStringCellValue();
		}
		else if(cell.getCellType()==CellType.NUMERIC)
		{
			double dataInDouble=cell.getNumericCellValue();
			
			data=String.valueOf(dataInDouble);
		}
		else if(cell.getCellType()==CellType.BOOLEAN)
		{
			boolean dataInBoolean=cell.getBooleanCellValue();
			
			data=String.valueOf(dataInBoolean);
		}
		else if(cell.getCellType()==CellType.BLANK) {
			data="";
		}
	
		return data;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
