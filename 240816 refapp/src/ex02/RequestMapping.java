package ex02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 어디에
@Retention(RetentionPolicy.RUNTIME)// 언제
public @interface RequestMapping {
    String uri();


}
