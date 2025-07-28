package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tmb.constants.FrameworkConstants;

public final class ExcelUtils {
	private ExcelUtils() {

	}

	public static List<Map<String, String>> getTestDetails(String sheetName) {
		
		List<Map<String,String>> list = null;
		try (FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelpath());){
			
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Map<String, String> map = null;
			list = new ArrayList();
			int lastRowNum = sheet.getLastRowNum();
			int lastColumnNum = sheet.getRow(0).getLastCellNum();
			
			for(int i=1; i<=lastRowNum;i++) {
				map =new HashMap();
				for(int j=0;j<lastColumnNum;j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();

//					System.out.println(key);
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
//					System.out.println(value);
					map.put(key, value);
				}
				list.add(map);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;

	}

}
