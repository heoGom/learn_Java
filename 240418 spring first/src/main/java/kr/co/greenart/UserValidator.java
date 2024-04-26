package kr.co.greenart;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User u = (User) target;
		
		if (ObjectUtils.isEmpty(u.getName())) {
			errors.rejectValue("name", "name.empty", "이름을 입력하세요");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty", "이메일을 입력하세요");
		
		if (u.getAge() == null || u.getAge() <= 0) {
			errors.rejectValue("age", "age.invalid", "나이는 1이상의 값이여야 합니다");
		}
		
		// ...
	}
}
