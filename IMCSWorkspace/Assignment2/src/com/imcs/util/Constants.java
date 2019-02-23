package com.imcs.util;

import java.util.ResourceBundle;

public final class Constants {
	public static final String EMP_FILE_PATH = ResourceBundle.getBundle("com.imcs.resources.database").getString("EmpPath");
	public static final String EMP_ADD_FILE_PATH = ResourceBundle.getBundle("com.imcs.resources.database").getString("EmpAddPath");
	public static final String RESULT_NOT_FOUND_MESSAGE = "No Results Found";
}
