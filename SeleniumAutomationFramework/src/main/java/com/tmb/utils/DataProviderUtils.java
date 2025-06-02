package com.tmb.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.tmb.constants.FrameworkConstants;

public final class DataProviderUtils {
	private static List<Map<String, String>> list =new ArrayList<>();
	@DataProvider(parallel= true)
	public static Object[] getData(Method m) {
		String testname = m.getName();
		if(list.isEmpty()) {
			list=ExcelUtils.getTestDetails(FrameworkConstants.getIterationdatasheet());
		}
		List<Map<String, String>> smallList = new ArrayList<>();
		for(int i=0; i<list.size();i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(testname) && 
					list.get(i).get("execute").equalsIgnoreCase("yes")) {
					 smallList.add(list.get(i));
				}
			
		}
		return smallList.toArray();
	}

}
