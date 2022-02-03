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
import uz.pdp.entity.Student;
import uz.pdp.exception.RestException;
import uz.pdp.mapper.SchoolMapper;
import uz.pdp.mapper.StudentMapper;
import uz.pdp.payload.*;
import uz.pdp.repository.AddressRepository;
import uz.pdp.repository.SchoolRepository;
import uz.pdp.repository.StudentRepository;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final SchoolRepository schoolRepository;
    private final AddressRepository addressRepository;

    @Override
    public ApiResult<StudentRespDto> get(UUID id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> RestException.restThrow("Student topilmadi", HttpStatus.NOT_FOUND));

        return ApiResult.successResponse(studentMapper.toStudentDto(student));
    }

    @Override
    public ApiResult<CustomPage<StudentRespDto>> getAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.asc("firstName")));
        Page<Student> all = studentRepository.findAll(pageable);
        return ApiResult.successResponse(makeCustomPage(all));
    }

    @Override
    public ApiResult<StudentRespDto> add(StudentCreateDto dto) {
        schoolRepository.findById(dto.getSchoolId()).orElseThrow(() -> RestException.restThrow("School topilmadi",HttpStatus.NOT_FOUND));
        addressRepository.findById(dto.getAddressId()).orElseThrow(() -> RestException.restThrow("Address topilmadi",HttpStatus.NOT_FOUND));
        Student save = studentRepository.save(studentMapper.toStudent(dto));
        return ApiResult.successResponse(studentMapper.toStudentDto(save));
    }

    @Override
    public ApiResult<StudentRespDto> update(UUID id, StudentUpdateDto dto) {
        School school = schoolRepository.findById(dto.getSchoolId()).orElseThrow(() -> RestException.restThrow("School topilmadi", HttpStatus.NOT_FOUND));
        Address address = addressRepository.findById(dto.getAddressId()).orElseThrow(() -> RestException.restThrow("Address topilmadi", HttpStatus.NOT_FOUND));

        Student student = studentRepository.findById(id).orElseThrow(() -> RestException.restThrow("Student topilmadi", HttpStatus.NOT_FOUND));
        student.setAddress(address);
        student.setSchool(school);

        Student student1 = studentMapper.toStudent(student, dto);
        return ApiResult.successResponse(studentMapper.toStudentDto(studentRepository.save(student1)));
    }

    @Override
    public ApiResult<?> delete(UUID id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> RestException.restThrow("Student topilmadi!", HttpStatus.NOT_FOUND));

        studentRepository.delete(student);
        return ApiResult.successResponse("Address deleted");
    }

    @Override
    public CustomPage<StudentRespDto> makeCustomPage(Page<Student> page) {
        return new CustomPage<>(
                page.getContent().stream().map(studentMapper::toStudentDto).collect(Collectors.toList()),
                page.getNumberOfElements(),
                page.getNumber(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.getSize()
        );
    }
}
