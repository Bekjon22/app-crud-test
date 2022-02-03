package uz.pdp.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;
@Getter
@Setter
public class SchoolCreateDto {
    @NotBlank(message = "Name can not be empty!")
    private String name;

    @NotNull(message = "AddressId can not be empty!")
    private UUID addressId;
}
