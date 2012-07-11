package com.opendroid.helper.validation;

/**
 * Validation result class
 * value holder.
 * this class contains true/false (validation status)
 * and a message.
 * 
 * @author http://nl.linkedin.com/in/marcdekwant
 *
 */
public class ValidationResult {
	
	private boolean _ok = false;
	private String _message = "";
	
	public ValidationResult(boolean ok, String message) {
		_ok = ok;
		_message = message;
	}
	
	public boolean isValid() {
		return _ok;
	}
	
	public String getMessage() {
		return _message;
	}

}
