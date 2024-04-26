package kr.co.greenart.json;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "kr.co.greenart.json")
public class JsonAPIAdvice {
	@ExceptionHandler(JsonAPIException.class)
	public ResponseEntity<?> conflict(JsonAPIException e) {
		ErrorMessageDTO dto = new ErrorMessageDTO();
		dto.setStatus(e.getStatus());
		dto.setMessage(e.getMessage());
		
		if (e instanceof InvalidPersonException) {
			dto.setErrors(((InvalidPersonException) e).getErrors().getAllErrors());
		}
		
		return ResponseEntity.status(e.getStatus())
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(dto);
	}
}
