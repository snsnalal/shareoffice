package office.shareoffice.domain.reservation.entity;


import lombok.Getter;
import office.shareoffice.domain.base.BaseEntity;
import office.shareoffice.domain.member.entity.Member;
import office.shareoffice.domain.office.entity.Office;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "reservation")
@Getter
public class Reservation extends BaseEntity {

    @Id
    private String id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "office_id")
    private Office office;


    private LocalDateTime date;
    private String period;
    private int pay;
}
