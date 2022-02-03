package uz.pdp.payload;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.entity.School;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class StudentCreateDto {

    @NotBlank(message = "firstName can not be empty!")
    private String firstName;

    private String lastName;

    @NotNull(message = "schoolId can not be null!")
    private UUID schoolId;

    @NotNull(message = "addressId can not be null!")
    private UUID addressId;

}
