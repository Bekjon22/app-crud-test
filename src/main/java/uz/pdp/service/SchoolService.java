package uz.pdp.service;

import uz.pdp.payload.*;

import java.util.List;
import java.util.UUID;

public interface SchoolService {

    ApiResult<SchoolRespDto> get(UUID id);

    ApiResult<List<SchoolRespDto>> getAll(Integer page, Integer size);

    ApiResult<SchoolRespDto> add(SchoolCreateDto dto);

    ApiResult<SchoolRespDto> update(UUID id, SchoolCreateDto dto);

    ApiResult<?> delete(UUID id);
}
