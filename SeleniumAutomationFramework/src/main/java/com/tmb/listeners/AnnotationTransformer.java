package com.tmb.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.tmb.utils.DataProviderUtils;

public class AnnotationTransformer implements IAnnotationTransformer{

	public synchronized void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		System.out.println("Transforming method: " + (testMethod != null ? testMethod.getName() : "null"));
		 if (testMethod != null 
		            && testMethod.getParameterCount() == 1 
		            && Map.class.isAssignableFrom(testMethod.getParameterTypes()[0])) {
		            
		            annotation.setDataProvider("getData");
		            annotation.setDataProviderClass(DataProviderUtils.class);
		        }
		annotation.setRetryAnalyzer(RetryFailedTests.class);
	}

}
