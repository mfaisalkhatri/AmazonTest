package com.mfaisalkhatri.testassignment;

import java.io.IOException;

/**
 * This is Data Getter from config file.
 * @author Faisal Khatri
 *
 */
public class ConfigProperties {

	PropertiesReader prop = new PropertiesReader();

	/**
	 * @return browser
	 * @throws IOException
	 */
	public String getBrowser() throws IOException {
		return prop.getKey("browser");
	}

	/**
	 * @return website
	 * @throws IOException
	 */
	public String getWebsite() throws IOException {
		return prop.getKey("website");
	}
	
	/**
	 * @return pincode
	 * @throws IOException
	 */
	public String getPincode() throws IOException {
		return prop.getKey("pincode");
	}
	
}
