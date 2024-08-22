package shop.mtcoding.blog.board;

// C -> S -> R

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.mtcoding.blog.user.User;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardResponse.DetailDTOV2 상세보기(int id, User sessionUser) {
        Board board = boardRepository.findById(id); // 조인 (Board - User)
        return new BoardResponse.DetailDTOV2(board, sessionUser);
    }
}