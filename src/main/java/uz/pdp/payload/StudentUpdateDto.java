package uz.pdp.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;
@Getter
@Setter
public class StudentUpdateDto {
    private String firstName;

    private String lastName;

    private UUID schoolId;

    private UUID addressId;
}
