package kr.co.greenart.json;

import org.springframework.http.HttpStatus;

public class NotFoundException extends JsonAPIException {
	public NotFoundException(HttpStatus status, String message) {
		super(status, message);
	}
}
