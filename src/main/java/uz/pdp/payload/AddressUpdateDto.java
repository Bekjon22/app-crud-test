package uz.pdp.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
public class AddressUpdateDto {

    private String region;

    private String district;

    private String street;

    private String description;
}
