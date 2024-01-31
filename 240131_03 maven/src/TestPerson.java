import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestPerson {
//	private static Logger logger = LoggerFactory.getLogger(TestPerson.class);

	public static void main(String[] args) {
		Person p = new Person();
		Person p2 = new Person("길동", 22);

		log.info(p.getName());
		log.error("에러가 발생했어요!");
		log.warn("경고!");
		p.setName("둘리");

//		System.out.println(p.toString());
		log.info(p.toString());

//		System.out.println(p.equals(p2));
		log.info(String.valueOf(p.equals(p2)));
	}

}
