package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository //@Repository를 붙이면 스프링이 new를 해서 IoC(컬렉션 List자료형 같은) 에 저장한다
public class BoardRepository {

    @Autowired //IoC에 있는 객체를 찾아온다.
    private EntityManager em;

    public BoardRepository() {
        System.out.println("BoardRepository 생성자");
    }
    @Transactional
    public void save(String title, String content) {
        Query query = em.createNativeQuery("insert into board_tb (title, content, created_at) values (?, ?, now())");
        query.setParameter(1, title);
        query.setParameter(2, content);
        query.executeUpdate();

    }
}
