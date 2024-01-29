import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//콘솔창에서 사람의 이름, 나이를 입력받아
//person.txt파일에 출력
class Machine {
	BufferedWriter bw = null;

	Machine(String name, String age, int count) {
		try {
			String fileName = "d:\\mydata\\person" + count + ".txt";
			File file = new File(fileName);
			bw = new BufferedWriter(new FileWriter(file));
			bw.write("개발자" + name + "\n");
			bw.write("나이" + age + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

	}

	Machine(String name, String age) {
		try {
			bw = new BufferedWriter(new FileWriter(new File("d:\\mydata\\person.txt"), true));
			bw.write(name + "\n");
			bw.write(age + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}

public class Main8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		boolean go = true;
		while (go) {
			System.out.println("이름은?");
			String name = sc.nextLine();
			if (name.equals("1")) {
				go = false;

			} else {
				System.out.println("나이는?");
				String age = sc.nextLine();
				System.out.println("추가하시겠습니까? =1 \n 텍스트파일을 만드시겠습니까? =2");
				String how = sc.nextLine();
				if (how.equals("1")) {
					new Machine(name, age);
				} else if (how.equals("2")) {
					new Machine(name, age, count);
					count++;
				} else {
					System.out.println("입력값이 틀렸다 이놈아");
				}
			}
		}
	}
}
