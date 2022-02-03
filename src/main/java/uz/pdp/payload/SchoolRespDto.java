package uz.pdp.payload;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.entity.Address;

import javax.persistence.OneToOne;
import java.util.UUID;

@Getter
@Setter
public class SchoolRespDto {
    private UUID id;

    private String name;

    private UUID addressId;

}
