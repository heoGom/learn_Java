package org.example.springv3.board;

import lombok.Data;
import org.example.springv3.reply.Reply;
import org.example.springv3.user.User;
import org.springframework.data.domain.Page;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BoardResponse {

    @Data // getter, setter, toString
    public static class ListDTO {
        private Integer id;
        private String title;
        private Long count;

        public ListDTO(Integer id, String title, Long count) {
            this.id = id;
            this.title = title;
            this.count = count;
        }
    }

    @Data
    public static class PageDTO {
        private Integer number; // 현재페이지
        private Integer totalPage; // 전체페이지 개수
        private Integer size; // 한페이지에 아이템 개수
        private Boolean first;
        private Boolean last;
        private Integer prev; // 현재페이지 -1
        private Integer next; // 현재페이지 +1
        private List<Integer> numbers = new ArrayList<>();
        private List<Content> contents = new ArrayList<>();
        private String keyword;

        public PageDTO(Page<Board> boardPG, String title) {
            this.keyword = title;
            this.number = boardPG.getNumber();
            this.totalPage = boardPG.getTotalPages();
            this.size = boardPG.getSize();
            this.first = boardPG.isFirst();
            this.last = boardPG.isLast();
            this.prev = boardPG.getNumber()-1;
            this.next = boardPG.getNumber()+1;
            int temp = (number / 3)*3; // 0 -> 0, 3 -> 3, 6 -> 6

            for(int i=temp; i<temp+3; i++){ // 0
                this.numbers.add(i);
            }
            for (Board board : boardPG.getContent()){
                contents.add(new Content(board));
            }
        }

        @Data
        class Content {
            private Integer id;
            private String title;

            public Content(Board board) {
                this.id = board.getId();
                this.title = board.getTitle();
            }
        }
    }

    @Data
    public static class DetailDTO {

        private Integer id;
        private String title;
        private String content;
        private Boolean isOwner;
        private Integer userId;
        private String username;

        private List<ReplyDTO> replies = new ArrayList<>();

        public DetailDTO(Board board, User sessionUser) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.isOwner = false;

            if (sessionUser != null) {
                if (board.getUser().getId() == sessionUser.getId()) {
                    isOwner = true; // 권한체크

                }
            }
            this.userId = board.getUser().getId();
            this.username = board.getUser().getUsername();
            for (Reply reply : board.getReplies()) {
                replies.add(new ReplyDTO(reply, sessionUser));
            }
        }

        @Data
        public class ReplyDTO {
            private Integer id;
            private String comment;
            private String username;
            private Boolean isOwner;
            private Timestamp createdAt;

            public ReplyDTO(Reply reply, User sessionUser) {
                this.id = reply.getId();
                this.comment = reply.getComment();
                this.username = reply.getUser().getUsername();
                this.isOwner = false;
                this.createdAt = reply.getCreatedAt();

                if (sessionUser != null) {
                    if (reply.getUser().getId() == sessionUser.getId()) {
                        isOwner = true;
                    }
                }
            }
        }
    }
}
