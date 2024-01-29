import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main2 {
	public static void main(String[] args) {
		ClassLoader classLoader = Main2.class.getClassLoader();
		InputStreamReader input;
		input = new InputStreamReader(classLoader.getResourceAsStream("text.txt"));
		
		try {
			int b;
			while ((b = input.read()) != -1) {
				System.out.print((char) b);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
