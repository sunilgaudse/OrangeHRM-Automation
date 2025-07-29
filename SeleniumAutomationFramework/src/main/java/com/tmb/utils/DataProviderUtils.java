package com.tmb.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.tmb.annotations.*;
import org.testng.annotations.DataProvider;

import com.tmb.constants.FrameworkConstants;

public final class DataProviderUtils {
	private static List<Map<String, String>> list =new ArrayList<>();
	@DataProvider(parallel= true)
	public static Object[] getData(Method m) {
		String testname = m.getName();
		String sheetName = FrameworkConstants.getIterationdatasheet(); // default

		if (m.isAnnotationPresent(Sheet.class)) {
		    sheetName = m.getAnnotation(Sheet.class).value();
		} else if (m.getDeclaringClass().isAnnotationPresent(Sheet.class)) {
		    sheetName = m.getDeclaringClass().getAnnotation(Sheet.class).value();
		}
		
		if(list.isEmpty()) {
			list=ExcelUtils.getTestDetails(sheetName);
		}
		List<Map<String, String>> smallList = new ArrayList<>();
		for(int i=0; i<list.size();i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(testname) && 
					list.get(i).get("execute").equalsIgnoreCase("yes")) {
				System.out.println(list.get(i));
					 smallList.add(list.get(i));
				}
			
		}
		return smallList.toArray();
	}

}
