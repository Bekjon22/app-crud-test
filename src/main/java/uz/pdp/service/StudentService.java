package uz.pdp.service;

import org.springframework.data.domain.Page;
import uz.pdp.entity.Address;
import uz.pdp.entity.Student;
import uz.pdp.payload.*;

import java.util.UUID;

public interface StudentService {

    ApiResult<StudentRespDto> get(UUID id);

    ApiResult<CustomPage<StudentRespDto>> getAll(Integer page, Integer size);

    ApiResult<StudentRespDto> add(StudentCreateDto dto);

    ApiResult<StudentRespDto> update(UUID id, StudentUpdateDto dto);

    ApiResult<?> delete(UUID id);

    CustomPage<StudentRespDto> makeCustomPage(Page<Student> page);
}
