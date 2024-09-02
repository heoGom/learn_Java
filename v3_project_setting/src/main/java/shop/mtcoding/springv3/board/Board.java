package shop.mtcoding.springv3.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.springv3.user.User;

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

    @CreationTimestamp
    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Board(Integer id, String title, String content, Timestamp createdAt, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.user = user;
    }
}
