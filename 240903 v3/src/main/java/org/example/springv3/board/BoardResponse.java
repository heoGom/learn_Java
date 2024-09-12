package org.example.springv3.board;

import lombok.Data;
import org.example.springv3.reply.Reply;
import org.example.springv3.user.User;
import org.springframework.data.domain.Page;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BoardResponse {

    @Data
    public static class PageDTO {
        private Integer number;
        private Integer totalPage;
        private Integer size;
        private Boolean first;
        private Boolean last;
        private Integer prev;
        private Integer next;
        private List<Content> contents = new ArrayList<>();

        public PageDTO(Page<Board> boardPS) {
            this.number = boardPS.getNumber();
            this.totalPage = boardPS.getTotalPages();
            this.size = boardPS.getSize();
            this.prev = boardPS.getNumber()-1;
            this.next = boardPS.getNumber()+1;
            this.first = true;
            this.last = true;
            if(boardPS.getNumber()> boardPS.getTotalPages()){
                this.prev = boardPS.getTotalPages()-1;
            }
            if (boardPS.hasPrevious()){
                this.first = false;
            }
            if (boardPS.hasNext()){
                this.last = false;
            }
            for(Board board : boardPS){
                this.contents.add(new Content(board));
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
