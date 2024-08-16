package shop.mtcoding.blog.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//식별자 요청 받기, 응답하기
@Controller
public class BoardController {

    @Autowired
    BoardRepository boardRepository;

    @PostMapping("/board/save")
    public String save(String title, String content) {  //스프링 기본전략 = "application/x-www-form-urlencoded" 파싱
        boardRepository.save(title, content);
        return "redirect:/board";
    }
    //get, post
    @GetMapping("/board")
    public String list() {
        return "board/list";
    }

    @GetMapping("/board/1")
    public String detail() {
        return "board/detail";
    }

    @GetMapping("/board/1/update-form")
    public String updateForm() {
        return "board/update-form";
    }

    @GetMapping("/board/save-form")
    public String saveForm() {
        return "board/save-form";
    }

}
