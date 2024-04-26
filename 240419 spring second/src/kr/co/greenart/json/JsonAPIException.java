package kr.co.greenart.json;

import org.springframework.http.HttpStatus;

public class JsonAPIException extends RuntimeException {
	private HttpStatus status;
	
	public JsonAPIException(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
