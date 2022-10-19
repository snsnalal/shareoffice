package office.shareoffice.domain.office.entity;


import lombok.Getter;
import office.shareoffice.domain.base.BaseEntity;
import office.shareoffice.domain.company.entity.Company;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "office")
@Getter
public class Office extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "office_id")
    private String id;
    private String name;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "com_id")
    private Company company;

    private String position;
    private int price;

}
