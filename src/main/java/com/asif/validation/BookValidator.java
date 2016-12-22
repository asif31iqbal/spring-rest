package com.asif.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.asif.model.Book;

@Component
public class BookValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Book.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Book book = (Book)target;
		System.out.println(book.getAuthor());
		if(book.getAuthor() != null && book.getAuthor().length() > 20) {
			errors.rejectValue("author", "101", "Author name is too long");
		}
	}

}
