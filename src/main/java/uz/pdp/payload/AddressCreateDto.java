package uz.pdp.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class AddressCreateDto {
    @NotBlank(message = "Region can not be empty!")
    private String region;

    @NotBlank(message = "District can not be empty!")
    private String district;

    @NotBlank(message = "Street can not be empty!")
    private String street;

    private String description;
}
