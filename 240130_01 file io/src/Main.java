import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) {
		// try-resource
		try (PrintWriter pw = new PrintWriter("filename.txt")) {
			pw.println("문자열 출력");
			pw.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			System.out.println("필요하면 finally블럭을 쓰세요.");
		}
	}

}
