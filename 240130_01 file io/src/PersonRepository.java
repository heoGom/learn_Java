import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
	public void insertRow(Person p) {
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("persons.bin"), true))) {
			dos.writeUTF(p.getName());
			dos.writeInt(p.getHeight());
			dos.writeDouble(p.getWeight());
			dos.writeBoolean(p.isMarried());
			dos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<Person> getAllPersons() {
		List<Person> list = new ArrayList<>();
		try (DataInputStream dis = new DataInputStream(new FileInputStream("persons.bin"))) {
			while (true) {
				Person p = new Person(dis.readUTF(), dis.readInt(), dis.readDouble(), dis.readBoolean());
				list.add(p);
			}
		} catch (EOFException e) {
			System.out.println("인간 추가 완료");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;

	}

}
