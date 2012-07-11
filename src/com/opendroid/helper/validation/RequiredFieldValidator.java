/**
 * @author Rishi Kolvekar
 * 
 */
package com.opendroid.helper.validation;

import java.util.List;

import android.view.View;
import android.widget.EditText;

/**
 * @author rishi
 *
 */
public class RequiredFieldValidator implements Validator {
	
	List<EditText> objects;
	
	public RequiredFieldValidator(List<EditText> objects)
	{
		this.objects = objects;
	}

	/* (non-Javadoc)
	 * @see com.app.helper.validation.Validator#validate()
	 */
	@Override
	public boolean validate() {
		boolean valid = false;
		for(EditText obj : objects)
		{
			
				if(obj.getText().toString().trim().length()==0)
				{
					valid = false;
					break;
				}
			
		}
		return valid;
	}

	/* (non-Javadoc)
	 * @see com.app.helper.validation.Validator#setFailureMessage(java.lang.String)
	 */
	@Override
	public void setFailureMessage(String message) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.app.helper.validation.Validator#setType(int)
	 */
	@Override
	public void setType(int type) {
		// TODO Auto-generated method stub

	}

}
