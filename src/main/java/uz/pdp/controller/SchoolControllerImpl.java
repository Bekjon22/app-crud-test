package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.payload.*;
import uz.pdp.service.SchoolService;

import java.util.List;
import java.util.UUID;
@RestController
@RequiredArgsConstructor
public class SchoolControllerImpl implements SchoolController{

    private final SchoolService schoolService;

    @Override
    public ApiResult<SchoolRespDto> get(UUID id) {
        return schoolService.get(id);
    }

    @Override
    public ApiResult<List<SchoolRespDto>> getAll(Integer page, Integer size) {
        return schoolService.getAll(page,size);
    }

    @Override
    public ApiResult<SchoolRespDto> add(SchoolCreateDto dto) {
        return schoolService.add(dto);
    }

    @Override
    public ApiResult<SchoolRespDto> update(UUID id, SchoolCreateDto dto) {
        return schoolService.update(id,dto);
    }

    @Override
    public ApiResult<?> delete(UUID id) {
        return schoolService.delete(id);
    }
}
