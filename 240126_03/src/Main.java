import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
	public static void main(String[] args) {
		ClassLoader classLoader = Main.class.getClassLoader();
		URL url = classLoader.getResource("text.txt");
		File file;
		FileReader reader = null;;
		try {
			file = new File(url.toURI());
			reader = new FileReader(file);
			
			int ch;
			while((ch = reader.read()) !=-1) {
				System.out.print((char)ch);
			}
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
