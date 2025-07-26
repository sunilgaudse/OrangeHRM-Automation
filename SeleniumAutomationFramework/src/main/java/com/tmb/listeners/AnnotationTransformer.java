package com.tmb.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.tmb.utils.DataProviderUtils;
import java.util.Map;

public class AnnotationTransformer implements IAnnotationTransformer{

	public synchronized void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		 if (testMethod != null 
		            && testMethod.getParameterCount() == 1 
		            && Map.class.isAssignableFrom(testMethod.getParameterTypes()[0])) {
		            
		            annotation.setDataProvider("getData");
		            annotation.setDataProviderClass(DataProviderUtils.class);
		        }
		annotation.setRetryAnalyzer(RetryFailedTests.class);
	}

}
