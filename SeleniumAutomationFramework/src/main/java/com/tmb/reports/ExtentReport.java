package com.tmb.reports;

import java.awt.Desktop;
import java.io.File;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.constants.FrameworkConstants;

public final class ExtentReport {
	private ExtentReport() {
	}

	private static ExtentReports extent=new ExtentReports();;
	

	public static void initReports() throws Exception {
		if (Objects.nonNull(extent)) {
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Report");
			spark.config().setReportName("HRMTestReport");
		}
	}

	public static void flushReport() throws Exception {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
	}

	public static void createTests(String testcasename) {
		ExtentTest test = extent.createTest(testcasename);
		ExtentManager.setTest(test);
	}
}
