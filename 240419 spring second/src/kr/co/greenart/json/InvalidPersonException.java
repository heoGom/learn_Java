package kr.co.greenart.json;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;

public class InvalidPersonException extends JsonAPIException {
	private Errors errors;
	
	public InvalidPersonException(HttpStatus status, String message, Errors errors) {
		super(status, message);
		this.errors = errors;
	}

	public Errors getErrors() {
		return errors;
	}
}
