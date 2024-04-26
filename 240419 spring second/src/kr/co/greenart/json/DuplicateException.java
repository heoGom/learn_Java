package kr.co.greenart.json;

import org.springframework.http.HttpStatus;

public class DuplicateException extends JsonAPIException {

	public DuplicateException(HttpStatus status, String message) {
		super(status, message);
	}
	
}
