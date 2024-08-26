package shop.mtcoding.blog.board;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import shop.mtcoding.blog.user.User;

public class BoardRequest {


    @Data
    public static class UpdateDTO {
        @NotEmpty
        private String title;
        @NotEmpty
        private String content;

    }

    @Data
    public static class SaveDTO {
        @NotEmpty
        private String title;
        @NotEmpty
        private String content;

        public Board toEntity(User sessionUser) {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .user(sessionUser)
                    .build();
        }
    }

    @Data
    public static class DeleteDTO {
        @NotEmpty
        private Integer id;
    }
}
