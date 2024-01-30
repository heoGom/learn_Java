import java.util.List;

public class StudentManager {
	private List<Student> list;
	private StudentRepository repo;
	
	public StudentManager() {
		repo = new StudentRepository();
		list = repo.readList();
	}
	
	// 추가
	public void add(Student s) {
		list.add(s);
	}
	// 변경
	public void update(int index, Student s) {
		list.set(index, s);
	}
	// 삭제
	public void delete(int index) {
		list.remove(index);
	}
	// 전체 목록
	public List<Student> getList() {
		return list;
	}
	public void saveList() {
		repo.saveList(list);
	}
}




