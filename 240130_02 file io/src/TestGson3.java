import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class TestGson3 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>(Arrays.asList(
				new Student("a", 100, 100, 100)
				,new Student("b", 90, 90, 90)
				,new Student("c", 80, 80, 80)
				));
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		System.out.println(json);
		
		List<Student> copy = new ArrayList<>(Arrays.asList(gson.fromJson(json, Student[].class)));
		System.out.println(copy);
		
		
	}

}
