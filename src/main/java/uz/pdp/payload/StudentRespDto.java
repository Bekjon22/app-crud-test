package uz.pdp.payload;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.entity.Address;
import uz.pdp.entity.School;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class StudentRespDto {

    private UUID id;

    private String firstName;

    private String lastName;

    private UUID schoolId;

    private UUID addressId;
}
