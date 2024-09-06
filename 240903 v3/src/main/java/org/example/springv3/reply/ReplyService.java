package org.example.springv3.reply;

import lombok.RequiredArgsConstructor;
import org.example.springv3.core.error.ex.ExceptionApi403;
import org.example.springv3.core.error.ex.ExceptionApi404;
import org.example.springv3.user.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;

    @Transactional
    public void 댓글삭제(Integer id, User sessionUser){
        Reply replyPS = replyRepository.findById(id).orElseThrow(
                () -> new ExceptionApi404("해당 댓글을 찾을 수 없습니다."));
        if(replyPS.getUser().getId() != sessionUser.getId()){
            throw new ExceptionApi403("댓글 삭제 권한이 없습니다.");
        }

        replyRepository.deleteById(id);

    }
}
