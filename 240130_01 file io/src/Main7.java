import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Main7 {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(100, "일백");
		map.put(200, "이백");
		map.put(300, "삼백");

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("map.ser")))) {
			oos.writeObject(map);
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("map.ser")))){
			Map<Integer, String> readFromFile = (Map<Integer,String>) ois.readObject();
			
			System.out.println(readFromFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
