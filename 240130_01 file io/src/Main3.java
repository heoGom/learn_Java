import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main3 {
	public static void main(String[] args) {
		// 단순 int 값 10000, 20000, 30000, 40000 파일 기록
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("numbers.bin")));) {
			dos.writeInt(10000);
			dos.writeInt(20000);
			dos.writeInt(30000);
			dos.writeInt(40000);
			dos.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
