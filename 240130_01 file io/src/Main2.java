import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main2 {
	public static void main(String[] args) {
		File origin = new File("filename.txt");
		File copy = new File("copy.txt");
		
		try(FileInputStream fis = new FileInputStream(origin);
				FileOutputStream fos = new FileOutputStream(copy)) {
			byte[] b = new byte[(int) origin.length()];
			
			fis.read(b);
			fos.write(b);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
