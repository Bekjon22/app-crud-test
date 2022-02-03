package uz.pdp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.pdp.entity.templete.AbsEntity;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
@Where(clause = "deleted=false")
@SQLDelete(sql = "update students set deleted=true where id=?")
@Entity
public class Student extends AbsEntity {

    @Column(nullable = false)
    private String firstName;

    @Column()
    private String lastName;

    @ManyToOne
    private School school;

    @OneToOne
    private Address address;


}
