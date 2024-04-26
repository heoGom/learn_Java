package kr.co.greenart.httpentity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/resp")
public class HttpEntityController {
	
	@GetMapping("/text")
	public ResponseEntity<?> textResp() {
		String body = "plain text contents";
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
		
		return new ResponseEntity<String>(body, headers, HttpStatus.OK);
	}
	
	@GetMapping("/text2")
	public ResponseEntity<?> textResp2() {
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
				.body("plain text contents 2");
	}
	
	@GetMapping(value = "/text3", produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String textResp3() {
		return "plain text body";
	}
}





