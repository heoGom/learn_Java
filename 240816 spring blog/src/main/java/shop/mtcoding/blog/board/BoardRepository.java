package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.blog.core.error.ex.Exception404;

import java.util.List;

@RequiredArgsConstructor
@Repository //@Repository를 붙이면 스프링이 new를 해서 IoC(컬렉션 List자료형 같은) 에 저장한다
public class BoardRepository {

    private final EntityManager em;

    @Transactional
    public void updateById(String title, String content, int id) {
        Query query = em.createNativeQuery("update board_tb set title=?, content=? where id=?");
        query.setParameter(1, title);
        query.setParameter(2, content);
        query.setParameter(3, id);

        query.executeUpdate();

    }

    @Transactional
    public void deleteById(int id) {
        Query query = em.createNativeQuery("delete from board_tb where id = ?");
        query.setParameter(1, id);
        query.executeUpdate();


    }

    public Board findById(int id) {

        // select * from board_tb bt inner join user_tb ut on bt.user_id = ut.id where bt.id = ?
        Query query = em.createQuery("select b from Board b join fetch b.user where b.id = : id", Board.class);
        query.setParameter("id", id);
        try {
            Board board = (Board) query.getSingleResult();
            return board;
        } catch (Exception e) {
            return null;
        }
    }

    public List findAll() {
        Query query = em.createQuery("select b from Board b order by id desc", Board.class);
        List resultList = query.getResultList();

        return resultList;
    }

    @Transactional
    public void save(Board board) {
        System.out.println("들어가기전 타이틀좀 보자 :"+board.getTitle());
       em.persist(board);
    }
}
