package office.shareoffice.domain.member.entity;



import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import office.shareoffice.domain.base.BaseEntity;
import office.shareoffice.domain.member.constant.MemberRole;
import office.shareoffice.domain.member.constant.MemberType;
import office.shareoffice.domain.reservation.entity.Reservation;
import office.shareoffice.global.utils.DateTimeUtils;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private MemberType memberType;

    @Column(unique = true, length = 50, nullable = false)
    private String email;

    @Column(length = 200)
    private String password;

    @Column(nullable = false, length = 20)
    private String memberName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private MemberRole memberRole;

    @Column(length = 250)
    private String refreshToken;

    private LocalDateTime tokenExpirationTime;

    @OneToMany(mappedBy = "member")
    List<Reservation> reservations = new ArrayList<>();

    @Builder
    public Member(MemberType memberType, String email, String password, String memberName, MemberRole memberRole, String refreshToken, LocalDateTime tokenExpirationTime) {

        this.memberType = memberType;
        this.email = email;
        this.password = password;
        this.memberName = memberName;
        this.memberRole = memberRole;
        this.refreshToken = refreshToken;
        this.tokenExpirationTime = tokenExpirationTime;
    }

    public static Member createMember(Member member) {
        return Member.builder()
                .memberType(member.getMemberType())
                .email(member.getEmail())
                .password(member.getPassword())
                .memberName(member.getMemberName())
                .memberRole(member.getMemberRole())
                .refreshToken(member.getRefreshToken())
                .tokenExpirationTime(member.getTokenExpirationTime())
                .build();
    }

    public void reRegisterRefreshToken(String refreshToken, Date refreshTokenExpirationTime){
        this.refreshToken = refreshToken;
        this.tokenExpirationTime = DateTimeUtils.convertToLocalDateTime(refreshTokenExpirationTime);
    }

    public void expireRefreshToken(){
        this.tokenExpirationTime = LocalDateTime.now();
    }


}
