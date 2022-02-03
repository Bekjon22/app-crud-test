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
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses")
@Where(clause = "deleted=false")
@SQLDelete(sql = "update addresses set deleted=true where id=?")
@Entity
public class Address extends AbsEntity {

    @Column(name = "region",nullable = false,unique = true)
    private String region;

    @Column(name = "district",nullable = false)
    private String district;

    @Column(name = "street",nullable = false)
    private String street;

    @Column(name = "description")
    private String description;

}

