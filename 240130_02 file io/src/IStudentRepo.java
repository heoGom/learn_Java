import java.util.List;

public interface IStudentRepo {
	
	public void saveList(List<Student> list);
	
	public List<Student> readList();

}
