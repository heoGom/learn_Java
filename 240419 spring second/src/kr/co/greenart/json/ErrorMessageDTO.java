package kr.co.greenart.json;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessageDTO {
	private HttpStatus status;
	private String message;
	private List<ObjectError> errors;
}
