import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main4 {

	public static void main(String[] args) {
		try (DataInputStream dis = new DataInputStream(new FileInputStream(new File("numbers.bin")))) {
			while (true) {
				System.out.println(dis.readInt());
			}
		} catch (EOFException e) {
			System.out.println("파일의 EOF에 도달함");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
