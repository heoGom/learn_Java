import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class Main7 {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("d:\\mydata\\lottonum.txt")));

			String line;
			while ((line = br.readLine()) != null) {
				set.add(Integer.valueOf(line));

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		System.out.println(set.toString());

	}

}
