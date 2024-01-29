import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Main6 {
	private Random ran = new Random();
	
	private Set<Integer> randomSet() {
		Set<Integer> set = new TreeSet<>();
		while (set.size() < 6) {
			set.add(ran.nextInt(45) + 1);
		}
		return set;
	}
	
	public static void main(String[] args) {
		Main6 m = new Main6();
		Set<Integer> set = m.randomSet();
		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("d:\\mydata\\lottonum.txt"));
			
			for(Integer i :set) {
				pw.println(i);
			}
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










