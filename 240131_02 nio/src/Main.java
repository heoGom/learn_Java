import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {
		File f = new File("file.txt");

		Path p = Paths.get("file.txt");

		File directory = new File(".\\");
		File sub = new File(directory, "sub\\test.txt");

		Path current = Paths.get(".\\");
		Path sub2 = current.resolve("sub\\test.txt");

		System.out.println(sub.getAbsolutePath());
		System.out.println(sub2.toAbsolutePath());
		
		try {
			System.out.println(sub.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(sub2.toAbsolutePath().normalize());

	}

}
