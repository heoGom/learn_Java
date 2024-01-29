import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class MyMessageLogger {
	private final File logFile;

	public MyMessageLogger(String filename) {
		logFile = new File(filename);

	}

	public MyMessageLogger(File logFile) {
		this.logFile = logFile;

	}

	public void saveLog(String message) {

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(logFile, true));
			pw.printf("%s - %s\n", LocalDateTime.now(), message);
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
}
