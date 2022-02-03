package uz.pdp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.entity.Address;
import uz.pdp.exception.RestException;
import uz.pdp.mapper.AddressMapper;
import uz.pdp.payload.*;
import uz.pdp.repository.AddressRepository;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public ApiResult<CustomPage<AddressRespDto>> getAllAddress(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.asc("name")));
        Page<Address> all = addressRepository.findAll(pageable);
        return ApiResult.successResponse(makeCustomPage(all));
    }


    @Override
    public ApiResult<AddressRespDto> getAddress(UUID id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> RestException.restThrow("Address topilmadi!", HttpStatus.NOT_FOUND));

        return ApiResult.successResponse(addressMapper.toAddressRespDto(address));
    }

    @Override
    public ApiResult<AddressRespDto> addAddress(AddressCreateDto dto) {
        Optional<Address> byRegionAndDeleted = addressRepository.findByRegionAndDeleted(dto.getRegion(), false);
        if (byRegionAndDeleted.isPresent()) {
            throw new RestException(("Region name already exist"), HttpStatus.BAD_REQUEST);
        }

        Address save = addressRepository.save(addressMapper.toAddress(dto));

        return ApiResult.successResponse(addressMapper.toAddressRespDto(save));
    }

    @Override
    public ApiResult<AddressRespDto> updateAddress(UUID id, AddressUpdateDto dto) {
        Address address = addressRepository.findById(id).orElseThrow(() -> RestException.restThrow("Address topilmadi!", HttpStatus.NOT_FOUND));
        Optional<Address> byRegionAndDeleted = addressRepository.findByRegionAndDeletedAndIdNot(dto.getRegion(), false,id);
        if (byRegionAndDeleted.isPresent()) {
            throw new RestException(("Region name already exist"), HttpStatus.BAD_REQUEST);
        }
        Address save = addressRepository.save(addressMapper.toAddress(address, dto));

        return ApiResult.successResponse(addressMapper.toAddressRespDto(save));
    }

    @Override
    public ApiResult<?> delete(UUID id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> RestException.restThrow("Address topilmadi!", HttpStatus.NOT_FOUND));

        addressRepository.delete(address);
        return ApiResult.successResponse("Address deleted");
    }

    @Override
    public CustomPage<AddressRespDto> makeCustomPage(Page<Address> page) {
        return new CustomPage<>(
                page.getContent().stream().map(addressMapper::toAddressRespDto).collect(Collectors.toList()),
                page.getNumberOfElements(),
                page.getNumber(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.getSize()
        );

    }
}
