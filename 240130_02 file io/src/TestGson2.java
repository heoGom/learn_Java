import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class TestGson2 {
	public static void main(String[] args) {
		JsonObject obj = new JsonObject();
		obj.addProperty("속성이론", "속성값");
		obj.addProperty("name", "grant");
		obj.addProperty("age", 77);
		obj.addProperty("marry", "true");
		
		System.out.println(obj.toString());
		
		JsonObject obj2 = new JsonObject();
		obj2.addProperty("name", "jane");
		obj2.addProperty("age", 66);
		
		System.out.println(obj2.toString());
		
		JsonArray arr = new JsonArray();
		arr.add(obj);
		arr.add(obj2);
		
		System.out.println(arr.toString());
	}

}
