package com.qa.ims.controller;

import org.apache.log4j.Logger;

import com.qa.ims.utils.Utils;

public enum ReadOnly {
	
	READ("to read from database"),
	RETURN("return to domain selection");
	
	public static  final Logger LOGGER = Logger.getLogger(ReadOnly.class);
	
	private String description;
	
	private ReadOnly() {
		
	}
	
	ReadOnly(String description){
		this.description = description;
		
	}
	
	public String getDescription() {
		return this.name() + ": " + this.description;
		
	}
	
	public static void printActions() {
		for(ReadOnly read : ReadOnly.values()) {
			LOGGER.info(read.getDescription());
			
		}
	}
	
	public static ReadOnly getAction () {
		ReadOnly read;
		while(true) {
			try {
				read = ReadOnly.valueOf(Utils.getInput().toUpperCase());
				break;
				
			}catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return read;
	}

}
