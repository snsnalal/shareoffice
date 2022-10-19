package office.shareoffice.domain.company.entity;


import lombok.Getter;
import office.shareoffice.domain.base.BaseEntity;
import office.shareoffice.domain.office.entity.Office;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
@Getter
public class Company extends BaseEntity {

    @Id
    @Column(name = "com_id")
    private String id;
    private String password;

    private String name;
    private String email;
    private String com_name;
    private String phone;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Office> office = new ArrayList<>();
}
