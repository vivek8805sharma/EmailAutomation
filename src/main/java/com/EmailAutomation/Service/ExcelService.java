package com.EmailAutomation.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.EmailAutomation.Entity.User;

@Component
public class ExcelService {
	
	public List<User> readExcel() throws IOException {
		File excelFile = new File("C:\\Users\\Vivek_Sharma\\Documents\\RD_workspace\\EmailAutomation\\src\\main\\java\\com\\EmailAutomation\\EmailDetails.xlsx");
	    FileInputStream fis = new FileInputStream(excelFile);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    Iterator<Row> rowIt = sheet.iterator();
	    rowIt.next();
	    List<User> allUsers=new ArrayList<>();
	    
	    while(rowIt.hasNext()) {
	      Row row = rowIt.next();
	      User user =new User(row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue(),row.getCell(2).getStringCellValue());
	      
	      allUsers.add(user);
	    }

	    workbook.close();
	    fis.close();
	    return allUsers;
	}

}
