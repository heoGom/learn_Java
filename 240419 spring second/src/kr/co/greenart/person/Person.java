package kr.co.greenart.person;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	@NotBlank(message = "required name")
	@Size(max = 15, message = "name is too long. max length is 15.")
	private String name;
	@PositiveOrZero(message = "age must be positive or zero.")
	@Max(value = 150, message = "age must be under 150.")
	private int age;
}
