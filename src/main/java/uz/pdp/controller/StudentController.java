package uz.pdp.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.payload.*;
import uz.pdp.utils.AppConstant;

import javax.validation.Valid;
import java.util.UUID;

import static uz.pdp.utils.AppConstant.DEFAULT_PAGE_NUMBER;
import static uz.pdp.utils.AppConstant.DEFAULT_PAGE_SIZE;

@RequestMapping(StudentController.STUDENT_CONTROLLER)
public interface StudentController {
    String STUDENT_CONTROLLER= AppConstant.BASE_PATH+"/student";


    /**
     * Berilgan id ga mos Student qaytarish
     * @param id -
     * @return StudentRespDto
     */
    @GetMapping("{id}")
    ApiResult<StudentRespDto> get(@PathVariable(name = "id") UUID id);

    /**
     * Barcha Student larni olish
     * @param page sahifa raqami
     * @param size sig'imi
     * @return StudentRespDto
     */
    @GetMapping()
    ApiResult<CustomPage<StudentRespDto>> getAll(@RequestParam(name = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) Integer page,
                                                        @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE, required = false) Integer size);

    /**
     * Student qo'shish uchun
     * @param dto-
     * @return StudentRespDto
     */
    @PostMapping
    ApiResult<StudentRespDto> add(@RequestBody @Valid StudentCreateDto dto);


    /**
     * Berilgan id ga mos Student tahrirlash
     * @param id
     * @param dto
     * @return - StudentRespDto
     */
    @PutMapping(value = "{id}")
    ApiResult<StudentRespDto> update(@PathVariable UUID id,
                                          @RequestBody @Valid StudentUpdateDto dto);

    /**
     * Berilgan id ga mos Student o'chirish
     * @param id-
     * @return ?
     */
    @DeleteMapping("{id}")
    ApiResult<?> delete(@PathVariable UUID id);

}
