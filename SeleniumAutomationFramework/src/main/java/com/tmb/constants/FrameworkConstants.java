package com.tmb.constants;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;

public final class FrameworkConstants {
	
	private FrameworkConstants() {
		
	}
	private static final String RESOURCEPATH = System.getProperty("user.dir")+ "/src/test/resources/";
	private static final  String CHROMEDRIVERPATH = RESOURCEPATH + "executables/chromedriver.exe";
	private static final  String GECKODRIVERPATH = RESOURCEPATH + "executables/geckodriver.exe";
	private static final  String CONFIGFILEPATH = RESOURCEPATH + "/config/config.properties";
	private static final String EXCELPATH = RESOURCEPATH + "/excel/testdata.xlsx";
	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	private static final String ITERATIONDATASHEET = "DATA";
	
	public static String getRunmanagersheet() {
		return RUNMANAGERSHEET;
	}

	public static String getIterationdatasheet() {
		return ITERATIONDATASHEET;
	}
	private static final String EXTENTREPORTPATH =System.getProperty("user.dir")+"/extent-test-output";
	private static String extentReportFilePath = "";
	
	public static String getExcelpath() {
		return EXCELPATH;
	}

	public static String getExtentReportFilePath() throws Exception {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	public static String createReportPath() throws Exception {
		if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTPATH + "/"+System.currentTimeMillis()+"_index.html";
		}
		else {
			return EXTENTREPORTPATH + "/"+"_index.html";
		}
		
	}

	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}
	public static String getGeckoDriverPath() {
		return GECKODRIVERPATH;
	}

	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}
}
