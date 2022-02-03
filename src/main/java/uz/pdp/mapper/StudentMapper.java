package uz.pdp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import uz.pdp.entity.Address;
import uz.pdp.entity.Student;
import uz.pdp.payload.AddressUpdateDto;
import uz.pdp.payload.StudentCreateDto;
import uz.pdp.payload.StudentRespDto;
import uz.pdp.payload.StudentUpdateDto;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = "spring")
@Component
public interface StudentMapper {

    @Mapping( target = "schoolId",source = "school.id")
    @Mapping( target = "addressId",source = "address.id")
    StudentRespDto toStudentDto(Student student);

    @Mapping( target = "school.id",source = "schoolId")
    @Mapping( target = "address.id",source = "addressId")
    Student toStudent(StudentCreateDto studentCreateDto);

    Student toStudent(@MappingTarget Student student,StudentUpdateDto dto);

}
