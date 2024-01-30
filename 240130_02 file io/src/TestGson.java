import com.google.gson.Gson;

public class TestGson {
	public static void main(String[] args) {
		Gson gson = new Gson();
		
//		Student s =new Student("길동", 80, 70, 60);
//		
//
//		String jsonText = gson.toJson(s);
//		System.out.println(jsonText);
		
		String kil = "{\"name\":\"길동\",\"kor\":80,\"eng\":70,\"math\":60}";
		
		Student s = gson.fromJson(kil, Student.class);
		System.out.println(s.getName());
		System.out.println(s.getKor());
		System.out.println(s.getEng());
		System.out.println(s.getMath());


	}
}
