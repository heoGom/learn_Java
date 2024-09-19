package org.example.springv3.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(BoardQueryRepository.class)
@DataJpaTest
public class BoardQueryRepositoryTest {
    @Autowired
    private BoardQueryRepository boardQueryRepository;

    @Test
    public void select_test(){

        List<BoardResponse.ListDTO> boardList = boardQueryRepository.selectV1();

        System.out.println(boardList);
    }
}
