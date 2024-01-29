import java.io.File;

public class Main3 {
	public static void main(String[] args) {
		File file = new File("d:\\mydata\\first.txt");
//		System.out.println(file.exists());
//		
//		File file2 = new File("d:\\mydata\\","first.txt");
//		System.out.println(file2.exists());

		File fileDirectory = new File("d:\\mydata\\");
//		System.out.println(fileDirectory.exists());
//		System.out.println(fileDirectory.isDirectory());
//		
//		File file3 = new File(fileDirectory, "first.txt");
//		System.out.println(file3.exists());

		File fileSubDir = new File(fileDirectory, "sub\\");
		fileSubDir.mkdir();
		file.renameTo(new File(fileSubDir, file.getName()));
	}

}
