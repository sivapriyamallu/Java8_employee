package com.example.Employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalLogger {
	
	public static Logger getLogger(Class classname) {
		return  LoggerFactory.getLogger(classname);
	}

}
