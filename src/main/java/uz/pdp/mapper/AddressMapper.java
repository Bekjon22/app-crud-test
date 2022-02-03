package uz.pdp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import uz.pdp.entity.Address;
import uz.pdp.payload.AddressCreateDto;
import uz.pdp.payload.AddressRespDto;
import uz.pdp.payload.AddressUpdateDto;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = "spring")
@Component
public interface AddressMapper {

    AddressRespDto toAddressRespDto (Address address);


    Address toAddress(AddressCreateDto dto);

    Address toAddress(@MappingTarget Address address, AddressUpdateDto dto);

}
