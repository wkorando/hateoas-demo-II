package com.hateoas.demo.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hateoas.demo.model.entity.Item;

/**
 * Example {@link Validator} for validating the creation of new Item entities,
 * 
 * @author williamkorando
 * @see com.hateoas.demo.config.RestConfiguration
 */
public class ItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Item.class.equals(clazz);
	}

	@Override
	public void validate(Object item, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "name.empty", "Must enter a name!");
	}

}
