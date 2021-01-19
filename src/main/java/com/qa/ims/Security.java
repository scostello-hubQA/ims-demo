package com.qa.ims;

import org.apache.log4j.Logger;


import com.qa.ims.utils.Utils;

public enum Security {

	ADMIN("full functionality"),
	VIEW("read only");
	
	public static final Logger LOGGER = Logger.getLogger(Security.class);

	private String description;
	
	private Security(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.name() + ": " +this.description;
	}

	public static void printDomains() {
		for (Security sec : Security.values()) {
			LOGGER.info(sec.getDescription());
		}
	}
	
	public static Security getDomain() {
		Security sec;
		while (true) {
			try {
				sec = Security.valueOf(Utils.getInput().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return sec;
	}
	
}

	

