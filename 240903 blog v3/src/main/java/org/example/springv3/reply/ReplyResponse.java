package org.example.springv3.reply;

import lombok.Data;

public class ReplyResponse {
    @Data
    public static class DTO{
        private Integer Id;
        private String comment;
        private String username;


        public DTO(Reply reply) {
            this.Id = reply.getId();
            this.comment = reply.getComment();
            this.username = reply.getUser().getUsername();
        }
    }
}
