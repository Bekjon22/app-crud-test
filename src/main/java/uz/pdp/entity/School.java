package uz.pdp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.pdp.entity.templete.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schools")
@Where(clause = "deleted=false")
@SQLDelete(sql = "update schools set deleted=true where id=?")
@Entity
public class School extends AbsEntity {

    @Column(name = "name",nullable = false)
    private String name;

    @OneToOne
    private Address address;


}
