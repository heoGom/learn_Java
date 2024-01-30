import java.util.Arrays;

import com.google.gson.Gson;

class MyClass { 
	private int[] practice;

	public MyClass(int[] practice) {
		super();
		this.practice = practice;
	}

	@Override
	public String toString() {
		return "MyClass [practice=" + Arrays.toString(practice) + "]";
	}
	
}

public class Main {
	public static void main(String[] args) {
		Gson gson = new Gson();
		String text = "{\"practice\" : [4,5,6]}";
		
		MyClass m = gson.fromJson(text, MyClass.class);
		System.out.println(m);
	}

}
