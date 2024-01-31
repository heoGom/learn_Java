import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main3 {
	public static void main(String[] args) {
//		String line = "Hello World!!!!!!\n";
//
//		try {
//			Files.write(Paths.get("hello.txt"), line.getBytes(),StandardOpenOption.APPEND);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		try {
			List<String> lines = Files.readAllLines(Paths.get("hello.txt"));
			for(String l : lines) {
				System.out.println(l);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
