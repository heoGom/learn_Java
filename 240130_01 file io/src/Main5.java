import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main5 {
	public static void main(String[] args) {
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("types.bin"))) {
			dos.writeByte(10);
			dos.writeShort(100);
			dos.writeInt(1000);
			dos.writeLong(10000L);
			dos.writeUTF("문자열 정보도 출력가능");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (DataInputStream dis = new DataInputStream(new FileInputStream("types.bin"))) {
			System.out.println(dis.readByte());
			System.out.println(dis.readShort());
			System.out.println(dis.readInt());
			System.out.println(dis.readLong());
			System.out.println(dis.readUTF());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}







