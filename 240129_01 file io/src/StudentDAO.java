import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// DAO : Data Access Object
// 추가
// 목록
// 변경 or 삭제 or 검색!?!?!?
public class StudentDAO {
	private final File file = new File("d:\\mydata\\student.csv");
	private final String SEPARATOR = ",";
	

	public StudentDAO() {
		if (!file.exists()) {
			createFile();
		}
	}

	private void createFile() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			pw.println("이름, 국어, 영어, 수학");
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}

	}

	public void appendRow(Student student) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(file, true));
			pw.print(student.getName());
			pw.print(SEPARATOR);
			pw.print(student.getKor());
			pw.print(SEPARATOR);
			pw.print(student.getEng());	
			pw.print(SEPARATOR);
			pw.println(student.getMath());
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
	public List<Student> getAll() {
		List<Student> list = new ArrayList<>();
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			br.readLine();
			String line;
			while((line = br.readLine()) != null) {
				Student s = mapRow(line);
				list.add(s);
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
		
		
	}

	private Student mapRow(String line) {
		String[] split = line.split(SEPARATOR);
		
		return new Student(split[0], Integer.valueOf(split[1]), Integer.valueOf(split[2]), Integer.valueOf(split[3]));
	}


}
