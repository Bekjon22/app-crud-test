package uz.pdp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import uz.pdp.entity.School;
import uz.pdp.payload.SchoolCreateDto;
import uz.pdp.payload.SchoolRespDto;

import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = "spring")
@Component
public interface SchoolMapper {

    @Mapping(source = "address.id", target = "addressId")
    SchoolRespDto toSchoolRestDto(School school);

    @Mapping(source = "addressId", target = "address.id")
    School toSchool(SchoolCreateDto dto);

    @Mapping(source = "address.id", target = "addressId")
    List<SchoolRespDto>toSchoolRestDtoList(List<School> schools);


}
