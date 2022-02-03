package uz.pdp.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.payload.*;
import uz.pdp.utils.AppConstant;

import javax.validation.Valid;
import java.util.UUID;

import static uz.pdp.utils.AppConstant.DEFAULT_PAGE_NUMBER;
import static uz.pdp.utils.AppConstant.DEFAULT_PAGE_SIZE;

@RequestMapping(AddressController.ADDRESS_CONTROLLER)
public interface AddressController {
    String ADDRESS_CONTROLLER= AppConstant.BASE_PATH+"/address";


    /**
     * Berilgan id ga mos Addressni qaytarish
     * @param id -
     * @return AddressRespDto
     */
    @GetMapping("{id}")
    ApiResult<AddressRespDto> getAddress(@PathVariable(name = "id") UUID id);

    /**
     * Barcha Adddress larni olish
     * @param page sahifa raqami
     * @param size sig'imi
     * @return AddressRespDto
     */
    @GetMapping()
    ApiResult<CustomPage<AddressRespDto>> getAllAddress(@RequestParam(name = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) Integer page,
                                                        @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE, required = false) Integer size);

    /**
     * ADDRESS qo'shish uchun
     * @param dto-
     * @return AddressRespDto
     */
    @PostMapping
    ApiResult<AddressRespDto> addAddress(@RequestBody @Valid AddressCreateDto dto);


    /**
     * Berilgan id ga mos Addressni tahrirlash
     * @param id
     * @param dto
     * @return - AddressRespDto
     */
    @PutMapping(value = "{id}")
    ApiResult<AddressRespDto> updateAddress(@PathVariable UUID id,
                                          @RequestBody @Valid AddressUpdateDto dto);

    /**
     * Berilgan id ga mos Addressni o'chirish
     * @param id-
     * @return ?
     */
    @DeleteMapping("{id}")
    ApiResult<?> deleteAddress(@PathVariable UUID id);

}
