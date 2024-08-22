package shop.mtcoding.blog.core.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//rest는 데이터
//없는건 파일
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public String ex(Exception e) {
        String errMsg = """
                <script>
                    alert('$msg');
                    history.back();
                </script>
                """.replace("$msg", e.getMessage());

        return errMsg;

    }
}
