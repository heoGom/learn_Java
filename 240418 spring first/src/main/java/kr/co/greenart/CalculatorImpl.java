package kr.co.greenart;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements Calculator {
	@Override
	public int sum(int a, int b) {
		return a + b;
	}
}
