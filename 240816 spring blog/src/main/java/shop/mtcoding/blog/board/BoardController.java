package shop.mtcoding.blog.board;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.blog.user.User;

import java.util.List;

// 식별자 요청 받기, 응답 하기
@RequiredArgsConstructor
@Controller // 식별자 요청을 받을 수 있다.
public class BoardController {

    private final BoardService boardService;
    private final HttpSession session;


    // url : http://localhost:8080/board/1/update
    // body : title=제목1변경&content=내용1변경
    // content-type : x-www-form-urlencoded
    @PostMapping("/api/board/{id}/update")
    public String update(@PathVariable("id") int id, @Valid BoardRequest.UpdateDTO updateDTO, Errors errors) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        boardService.게시글수정(id, updateDTO, sessionUser);
        return "redirect:/board/" + id;
    }


    @PostMapping("/api/board/{id}/delete")
    public String delete(@Valid BoardRequest.DeleteDTO deleteDTO, Errors errors) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        boardService.게시글삭제(deleteDTO, sessionUser);
        return "redirect:/";
    }


    // subtitle=제목1&postContent=내용1
    @PostMapping("/api/board/save")
    public String save(@Valid BoardRequest.SaveDTO saveDTO, Errors errors) { // 스프링 기본전략 = x-www-form-urlencoded 파싱
        User sessionUser = (User) session.getAttribute("sessionUser");

        boardService.게시글쓰기(saveDTO, sessionUser);
        return "redirect:/";
    }


    // get, post
    @GetMapping("/")
    public String list(HttpServletRequest request) {
        List<Board> boardList = boardService.게시글목록보기();
        request.setAttribute("models", boardList);

        return "board/list";
    }

    // 1. 메서드 : Get
    // 2. 주소 : /board/1
    // 3. 응답 : board/detail
    @GetMapping("/board/{id}")
    public String detail(@PathVariable("id") Integer id, HttpServletRequest request) {

        User sessionUser = (User) session.getAttribute("sessionUser");

        BoardResponse.DetailDTOV2 detailDTOV2 = boardService.상세보기(id, sessionUser);
        request.setAttribute("model", detailDTOV2);

        return "board/detail";
    }


    // 1. 메서드 : Get
    // 2. 주소 : /board/save-form
    // 3. 응답 : board/save-form
    @GetMapping("/api/board/save-form")
    public String saveForm() {
        return "board/save-form";
    }

    // 1. 메서드 : Get
    // 2. 주소 : /board/1/update-form
    // 3. 응답 : board/update-form
    @GetMapping("/api/board/{id}/update-form")
    public String updateForm(@PathVariable("id") int id, HttpServletRequest request) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        Board board = boardService.게시글수정화면가기(id, sessionUser);
        request.setAttribute("model", board);

        return "board/update-form";
    }
}