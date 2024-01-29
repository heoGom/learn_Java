import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		File folder = new File("d:\\mydata\\person\\");
//		System.out.println(Arrays.toString(folder.list()));
//		System.out.println(Arrays.toString(folder.listFiles()));
		
		String[] fileNames = folder.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				if(name.startsWith("길동")&& name.endsWith(".txt")) {
					return true;
				}
				return false;
			}
		});
		System.out.println(Arrays.toString(fileNames));

	}
}
