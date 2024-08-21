package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(BoardRepository.class)
@DataJpaTest //h2, em
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void updateById_test() {
        //given
        int id = 1;
        String title = "제목1 변경";
        String content = "내용1 변경";
        //when
        boardRepository.updateById(title, content, id);
        //then
        Board board = boardRepository.findById(id);
        Assertions.assertThat(board.getTitle()).isEqualTo("제목1 변경");

    }

    @Test
    public void deleteById_test() {

        //given
        int id = 1;

        //when
        boardRepository.deleteById(id);

        //eye
        try {
            boardRepository.findById(id);

        } catch (Exception e) {
            Assertions.assertThat(e.getMessage()).isEqualTo("게시글 id를 찾을 수 없습니다.");
        }

    }

    @Test
    public void findById_test() {
        //given
        int id = 1;
        //when
        Board board = boardRepository.findById(id);

        //eye
        System.out.println(board.getId());
        System.out.println(board.getTitle());
        System.out.println(board.getContent());

        //then
        Assertions.assertThat(board.getTitle()).isEqualTo("제목1");
    }

    @Test
    public void findAll_test() {
        //given

        //when
        System.out.println("1. 첫번째 조회");
        List<Board> boardList = boardRepository.findAll();

        System.out.println("userId : " + boardList.get(0).getUser().getId());
        System.out.println("--------------------------------------------------");

        //eye
        System.out.println("2. 레이지 로딩");
        for (int a = 0; a < 5; a++) {

            System.out.println("username : " + boardList.get(a).getUser().getUsername());
        }

    }

    //테스트 메서드는 매개변수를 사용할수 없다.
//메서드명_test : 컨벤션
    @Test
    public void save_test() {
        //given (매개변수를 강제로 만들기)
        String title = "제목1";
        String content = "내용1";

        //when
        boardRepository.save(title, content);

        //eye


    }
}
