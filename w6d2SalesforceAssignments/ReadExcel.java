package w6d2SalesforceAssignments;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
public static String[][] readExcel(String filename, String Sheet) throws IOException {
	
		
		XSSFWorkbook book=new XSSFWorkbook("./data1/"+filename+".xlsx");
		XSSFSheet sheet = book.getSheet(Sheet);
		
		int rowCount= sheet.getLastRowNum();	
		int columCount = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][columCount];
		
		  for(int i=1;i<=rowCount;i++) {
			  XSSFRow row = sheet.getRow(i);
			  for(int j=0;j<columCount;j++) {
		  
			  String stringCellValue = row.getCell(j).getStringCellValue();
		
			  data[i-1][j] = stringCellValue;
		  }
		  }
		 
		book.close();
		return data;
}
}

