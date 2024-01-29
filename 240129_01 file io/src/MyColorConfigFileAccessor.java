import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MyColorConfigFileAccessor {
	private final File colorFile = new File("d:\\mydata\\color.cfg");

	public Color readConfig() {
		Color defaultColor = Color.WHITE;
		if (!colorFile.exists()) {
			return defaultColor;
		}

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(colorFile));
			int r = Integer.valueOf(br.readLine());
			int g = Integer.valueOf(br.readLine());
			int b = Integer.valueOf(br.readLine());

			return new Color(r, g, b);

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			return defaultColor;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void saveColor(Color color) {
		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(colorFile);
			pw.println(r);
			pw.println(g);
			pw.println(b);
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}

	}

}
