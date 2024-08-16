package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(BoardRepository.class)
@DataJpaTest //h2, em
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;
    
    //테스트 메서드는 매개변수를 사용할수 없다.
    //메서드명_test : 컨벤션
    @Test
    public void save_test(){
        //given (매개변수를 강제로 만들기)
        String title = "제목1";
        String content = "내용1";

        //when
        boardRepository.save(title, content);

        //eye


    }
}
