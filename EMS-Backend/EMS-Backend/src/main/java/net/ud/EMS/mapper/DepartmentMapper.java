package net.ud.EMS.mapper;

import net.ud.EMS.dto.DepartmentDTO;
import net.ud.EMS.entity.Department;
import net.ud.EMS.repository.DepartmentRepository;

public class DepartmentMapper {

    // convert department jpa entity into departemnt dto
    public static DepartmentDTO mapToDepartmentDTO(Department department) {
        return new DepartmentDTO(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescrepttion());

    }

    // convert department Dto into departemnt jpa entity

    public static Department mapToDepartment(DepartmentDTO departmentDTO) { // jpa ENTITY
        return new Department(
                departmentDTO.getId(),
                departmentDTO.getDepartmentName(),
                departmentDTO.getDepartmentDescrepttion());
    }
}
