import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main5 {
	public static void main(String[] args) {
		try (BufferedReader br = Files.newBufferedReader(Paths.get("copy.txt"))) {
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
