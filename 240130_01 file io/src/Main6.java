import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main6 {
	public static void main(String[] args) {
//		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("datas.ser")))) {
//
//			oos.writeObject("문자열 객체 출력");
//			oos.writeObject(Integer.valueOf(1000));
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("datas.ser")))) {

			String strRef = (String)ois.readObject();
			Integer intRef = (Integer)ois.readObject();
			
			System.out.println(strRef);
			System.out.println(intRef);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
