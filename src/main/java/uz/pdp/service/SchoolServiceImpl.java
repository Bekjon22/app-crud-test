package uz.pdp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.entity.Address;
import uz.pdp.entity.School;
import uz.pdp.exception.RestException;
import uz.pdp.mapper.SchoolMapper;
import uz.pdp.payload.*;
import uz.pdp.repository.AddressRepository;
import uz.pdp.repository.SchoolRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;
    private final AddressRepository addressRepository;

    @Override
    public ApiResult<SchoolRespDto> get(UUID id) {
        School school = schoolRepository.findById(id).orElseThrow(() -> RestException.restThrow("School topilmadi!", HttpStatus.NOT_FOUND));

        return ApiResult.successResponse(schoolMapper.toSchoolRestDto(school));
    }

    @Override
    public ApiResult<List<SchoolRespDto>> getAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.asc("name")));
        Page<School> all = schoolRepository.findAll(pageable);
        return ApiResult.successResponse(schoolMapper.toSchoolRestDtoList(all.getContent()));
    }

    @Override
    public ApiResult<SchoolRespDto> add(SchoolCreateDto dto) {
        addressRepository.findById(dto.getAddressId()).orElseThrow(() -> RestException.restThrow("Address topilmadi!", HttpStatus.NOT_FOUND));
        School save = schoolRepository.save(schoolMapper.toSchool(dto));
        return ApiResult.successResponse(schoolMapper.toSchoolRestDto(save));
    }

    @Override
    public ApiResult<SchoolRespDto> update(UUID id, SchoolCreateDto dto) {
        School school = schoolRepository.findById(id).orElseThrow(() -> RestException.restThrow("School topilmadi!", HttpStatus.NOT_FOUND));
        Address address = addressRepository.findById(dto.getAddressId()).orElseThrow(() -> RestException.restThrow("Address topilmadi!", HttpStatus.NOT_FOUND));
        school.setName(dto.getName());
        school.setAddress(address);
        return ApiResult.successResponse( schoolMapper.toSchoolRestDto(school));
    }

    @Override
    public ApiResult<?> delete(UUID id) {
        School school = schoolRepository.findById(id).orElseThrow(() -> RestException.restThrow("School topilmadi!", HttpStatus.NOT_FOUND));

        schoolRepository.delete(school);
        return ApiResult.successResponse("School deleted");

    }
}
