package office.shareoffice.domain.question.entity;


import lombok.Getter;
import office.shareoffice.domain.answer.entity.Answer;
import office.shareoffice.domain.base.BaseEntity;
import office.shareoffice.domain.company.entity.Company;
import office.shareoffice.domain.member.entity.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "question")
@Getter
public class Question extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "com_id")
    private Company company;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "ans_id")
    private Answer answer;

    private LocalDateTime date;
    private String title;
    private String content;

}
