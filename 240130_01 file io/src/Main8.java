import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main8 {
	public static void main(String[] args) {
		Person p = new Person("이름", 170, 77.77, true);

//		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("p.ser")))) {
//			oos.writeObject(p);
//			oos.flush();
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("p.ser")))){
			Person read = (Person) ois.readObject();
			System.out.println(read);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
