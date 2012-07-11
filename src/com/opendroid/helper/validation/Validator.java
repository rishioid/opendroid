package com.opendroid.helper.validation;

/**
 * Generic interface for validation of 
 * Android input fields
 * 
 * @author http://nl.linkedin.com/in/marcdekwant
 *
 */
public interface Validator {
	/*
	 * method returns true if all validation tests are successful
	 */
	boolean validate();
	/*
	 * Set message on validation failure
	 */
	void setFailureMessage(String message);
	/*
	 * set type of validation
	 */
	void setType(int type);

}
