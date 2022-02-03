package uz.pdp.payload;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.UUID;
@Getter
@Setter
public class AddressRespDto {

    private UUID id;

    private String region;

    private String district;

    private String street;

    private String description;
}
