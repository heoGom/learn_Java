import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main5 {
	public static void main(String[] args) {
		String multiline = "동해물과\n백두산이\n마르고\n닳도록\n하느님이\n";

		PrintWriter bw = null;

		try {
			bw = new PrintWriter(new FileWriter(new File("d:\\mydata\\lyrics.txt")));
			bw.write(multiline);
			bw.println("문자열값");
			bw.println(100);
			bw.println(true);
			bw.println(3.14);
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				bw.close();
			}

		}
	}
}
