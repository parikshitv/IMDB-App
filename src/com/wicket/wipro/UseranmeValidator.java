package com.wicket.wipro;

import org.apache.wicket.validation.CompoundValidator;
import org.apache.wicket.validation.validator.PatternValidator;

public class UseranmeValidator extends CompoundValidator<String>{
	public UseranmeValidator(){
		add(PatternValidator.exactLength(8));
	}
}
