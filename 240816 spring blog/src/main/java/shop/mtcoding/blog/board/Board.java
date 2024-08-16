package shop.mtcoding.blog.board;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "board_tb")
@Entity //DB에서 조회하면 자동 매핑이됨
public class Board {

    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto_increment 설정.
    @Id //pk
    private Integer id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    private Timestamp createdAt;

    @Builder
    public Board(Integer id, String title, String content, Timestamp createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }
}
