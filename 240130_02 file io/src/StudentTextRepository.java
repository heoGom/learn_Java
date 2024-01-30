import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class StudentTextRepository implements IStudentRepo {
	public void saveList(List<Student> list) {
		try (PrintWriter pw = new PrintWriter("students.txt")) {
			for (Student s : list) {
				pw.println(s.getName());
				pw.println(s.getKor());
				pw.println(s.getEng());
				pw.println(s.getMath());
			}
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public List<Student> readList() {
		List<Student> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader("student.txt"))) {
			while (true) {
				String name = br.readLine();
				if (name == null) {
					break;
				}
				int kor = Integer.parseInt(br.readLine());
				int eng = Integer.parseInt(br.readLine());
				int math = Integer.parseInt(br.readLine());
				list.add(new Student(name, kor, eng, math));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;

	}

}
