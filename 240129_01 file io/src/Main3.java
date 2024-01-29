import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Main3 {
	public static void main(String[] args) {
		File rollFile = new File("d:\\mydata\\roll.txt");

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(rollFile, true));
			pw.println("Hello World!");
			pw.println(LocalDateTime.now());
			pw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
}
