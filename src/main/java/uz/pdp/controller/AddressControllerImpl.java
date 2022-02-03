package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.payload.*;
import uz.pdp.service.AddressService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AddressControllerImpl implements AddressController{

    private final AddressService addressService;

    @Override
    public ApiResult<AddressRespDto> getAddress(UUID id) {
        return addressService.getAddress(id);
    }

    @Override
    public ApiResult<CustomPage<AddressRespDto>> getAllAddress(Integer page, Integer size) {
        return addressService.getAllAddress(page,size);
    }

    @Override
    public ApiResult<AddressRespDto> addAddress(AddressCreateDto dto) {
        return addressService.addAddress(dto);
    }

    @Override
    public ApiResult<AddressRespDto> updateAddress(UUID id, AddressUpdateDto dto) {
        return addressService.updateAddress(id,dto);
    }

    @Override
    public ApiResult<?> deleteAddress(UUID id) {
        return addressService.delete(id);
    }
}
