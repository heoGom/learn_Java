package org.example.springv3.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    @Query("select b from Board b order by b.id desc")
    List<Board> mFindAll();

//    @Query(value = "select * from board_tb bt inner join user_tb on bt.user_id = ut.id where bt.id=?", nativeQuery = true)
    @Query("select b from Board b join fetch b.user u where b.id=:id")
    Optional<Board> mFindById(int id);
}

