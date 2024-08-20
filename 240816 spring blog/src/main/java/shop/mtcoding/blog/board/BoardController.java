package shop.mtcoding.blog.board;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//식별자 요청 받기, 응답하기
@Controller
public class BoardController {

    @Autowired
    BoardRepository boardRepository;

    //url = http://localhost:8080/board/1/update
    //body : title=제목1변경&content=내용1변경
    //content-type : x-www-form-urlencoded
    @PostMapping("/board/{id}/update")
    public String updateBoard(@PathVariable("id") int id, @RequestParam("title") String title, @RequestParam("content") String content) {
        boardRepository.updateById(title, content, id);
        return "redirect:/board/" + id;

    }

    @PostMapping("/board/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        boardRepository.deleteById(id);
        return "redirect:/board";
    }

    @PostMapping("/board/save")
    public String save(@RequestParam("title") String title, @RequestParam("content") String content) {  //스프링 기본전략 = "application/x-www-form-urlencoded" 파싱
        boardRepository.save(title, content);
        return "redirect:/board";
    }

    //get, post
    @GetMapping("/board")
    public String list(HttpServletRequest request) {
        List<Board> boardList = boardRepository.findAll();
        request.setAttribute("models", boardList);

        HttpSession session = request.getSession();
        session.setAttribute("num", 1);

        return "board/list";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable("id") Integer id, HttpServletRequest request) {
        Board board = boardRepository.findById(id);
        request.setAttribute("model", board);
        return "board/detail";
    }

    @GetMapping("/board/")
    public String detail(String title) {
        return "board/detail";
    }

    @GetMapping("/board/{id}/update-form")
    public String updateForm(@PathVariable("id") int id, HttpServletRequest request) {
        Board board = boardRepository.findById(id);
        request.setAttribute("model", board);

        return "board/update-form";
    }

    @GetMapping("/board/save-form")
    public String saveForm() {
        return "board/save-form";
    }

}
