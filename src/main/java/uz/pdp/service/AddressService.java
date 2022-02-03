package uz.pdp.service;

import org.springframework.data.domain.Page;
import uz.pdp.entity.Address;
import uz.pdp.payload.*;

import java.util.UUID;

public interface AddressService {
    ApiResult<CustomPage<AddressRespDto>> getAllAddress(Integer page, Integer size);

    CustomPage<AddressRespDto> makeCustomPage(Page<Address> page);

    ApiResult<AddressRespDto> getAddress(UUID id);

    ApiResult<AddressRespDto> addAddress(AddressCreateDto dto);

    ApiResult<AddressRespDto> updateAddress(UUID id, AddressUpdateDto dto);

    ApiResult<?> delete(UUID id);
}
