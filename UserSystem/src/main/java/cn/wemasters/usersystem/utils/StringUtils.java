package cn.wemasters.usersystem.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static boolean isNotEmpty(String str) {
		return null != str && !str.equals("");
	}
	
	public static boolean isEmpty(String str) {
		return null == str || str.equals("");
	}
	
	public static boolean isEmailAddress(String str) {
		Pattern pattern = Pattern.compile("\\w+(\\.\\w+)*@\\w+(\\.\\w+)+");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	public static boolean isMobilePhoneNumber(String str) {
		Pattern pattern = Pattern.compile("[1-9][0-9]{11}");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

}
