package uz.pdp.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.payload.*;
import uz.pdp.utils.AppConstant;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static uz.pdp.utils.AppConstant.DEFAULT_PAGE_NUMBER;
import static uz.pdp.utils.AppConstant.DEFAULT_PAGE_SIZE;

@RequestMapping(SchoolController.SCHOOL_CONTROLLER)
public interface SchoolController {
    String SCHOOL_CONTROLLER= AppConstant.BASE_PATH+"/school";


    /**
     * Berilgan id ga mos School qaytarish
     * @param id -
     * @return SchoolRespDto
     */
    @GetMapping("{id}")
    ApiResult<SchoolRespDto> get(@PathVariable(name = "id") UUID id);

    /**
     * Barcha School larni olish
     * @param page sahifa raqami
     * @param size sig'imi
     * @return SchoolRespDto
     */
    @GetMapping()
    ApiResult<List<SchoolRespDto>> getAll(@RequestParam(name = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) Integer page,
                                          @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE, required = false) Integer size);

    /**
     * School qo'shish uchun
     * @param dto-
     * @return SchoolRespDto
     */
    @PostMapping
    ApiResult<SchoolRespDto> add(@RequestBody @Valid SchoolCreateDto dto);


    /**
     * Berilgan id ga mos School tahrirlash
     * @param id
     * @param dto
     * @return - SchoolRespDto
     */
    @PutMapping(value = "{id}")
    ApiResult<SchoolRespDto> update(@PathVariable UUID id,
                                          @RequestBody @Valid SchoolCreateDto dto);

    /**
     * Berilgan id ga mos School o'chirish
     * @param id-
     * @return ?
     */
    @DeleteMapping("{id}")
    ApiResult<?> delete(@PathVariable UUID id);

}
