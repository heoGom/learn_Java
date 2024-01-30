import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class StudentJsonRepo implements IStudentRepo {
	private Gson gson;

	public StudentJsonRepo() {
		gson = new Gson();
	}

	@Override
	public void saveList(List<Student> list) {
		String json = gson.toJson(list);
		try (PrintWriter pw = new PrintWriter("students.json")) {
			pw.println(json);
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Student> readList() {
		List<Student> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("students.json"))) {
			String json = br.readLine();

			Student[] arr = gson.fromJson(json, Student[].class);
			list.addAll(Arrays.asList(arr));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

}
