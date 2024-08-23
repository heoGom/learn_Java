package shop.mtcoding.blog.board;

// C -> S -> R

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.blog.core.error.ex.Exception403;
import shop.mtcoding.blog.core.error.ex.Exception404;
import shop.mtcoding.blog.user.User;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> 게시글목록보기(){
        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }

    @Transactional
    public void 게시글삭제(BoardRequest.DeleteDTO deleteDTO, User sessionUser) {
        // 1. 컨트롤러에서 게시글 id를 받기

        // 2. 게시글 존재 여부 확인(404)
        Board board = boardRepository.findById(deleteDTO.getId());
       if (board == null) {
           throw new Exception404("없는 게시글이다 이놈아");
       }
        // 3. 내가 쓴글인지 확인하기(403)
        if(!board.getUser().equals(sessionUser)) {
            throw new Exception403("니놈은 지울수 없는놈이네");
        }

        // 4. 게시글 삭제
        boardRepository.deleteById(deleteDTO.getId());

    }

    @Transactional
    public void 게시글쓰기(BoardRequest.SaveDTO saveDTO, User sessionUser) {
        boardRepository.save(saveDTO.toEntity(sessionUser));

    }

    public BoardResponse.DetailDTOV2 상세보기(int id, User sessionUser) {
        Board board = boardRepository.findById(id); // 조인 (Board - User)
        return new BoardResponse.DetailDTOV2(board, sessionUser);
    }


}