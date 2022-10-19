package office.shareoffice.domain.answer.entity;


import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "answer")
@Getter
public class Answer {

    @Id @GeneratedValue
    private Long id;

    private LocalDateTime date;

    private String title;
    private String content;
}
