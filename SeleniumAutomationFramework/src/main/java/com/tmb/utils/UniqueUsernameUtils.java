package com.tmb.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UniqueUsernameUtils {

	public static String getuniqueUsername(String username) {
		String uniqueUsername = username + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		return uniqueUsername;
	}
}
