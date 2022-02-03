package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.payload.*;
import uz.pdp.service.StudentService;

import java.util.UUID;
@RestController
@RequiredArgsConstructor
public class StudentControllerImpl implements StudentController{

    private final StudentService studentService;

    @Override
    public ApiResult<StudentRespDto> get(UUID id) {
        return studentService.get(id);
    }

    @Override
    public ApiResult<CustomPage<StudentRespDto>> getAll(Integer page, Integer size) {
        return studentService.getAll(page,size);
    }

    @Override
    public ApiResult<StudentRespDto> add(StudentCreateDto dto) {
        return studentService.add(dto);
    }

    @Override
    public ApiResult<StudentRespDto> update(UUID id, StudentUpdateDto dto) {
        return studentService.update(id,dto);
    }

    @Override
    public ApiResult<?> delete(UUID id) {
        return studentService.delete(id);
    }
}
