package com.tmb.utils;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;

public final class PropertyUtils {
	
	private PropertyUtils() {
		
	}
	
	public static String get(ConfigProperties key) throws Exception {
//		String value ="";
		Properties property = new Properties();
		FileInputStream  fis = new FileInputStream(FrameworkConstants.getConfigfilepath());
		property.load(fis);
//		value = property.getProperty(key);
		if(Objects.isNull(key.name())|| Objects.isNull(property.getProperty(key.name().toLowerCase()))) {
			throw new Exception("Property name " + key + " not found. Please check config file.");
		}
		return property.getProperty(key.name().toLowerCase());
	}

}
