package net.ud.EMS.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.ud.EMS.dto.DepartmentDTO;
import net.ud.EMS.entity.Department;
import net.ud.EMS.exception.ResourceNotFound;
import net.ud.EMS.mapper.DepartmentMapper;
import net.ud.EMS.repository.DepartmentRepository;
import net.ud.EMS.service.DepartmentService;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = DepartmentMapper.mapToDepartment(departmentDTO);
        Department createdDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDTO(createdDepartment);
    }

    @Override
    public DepartmentDTO getDepartmentById(Long DepartmentId) {
        Department department = departmentRepository.findById(DepartmentId)
                .orElseThrow(() -> new ResourceNotFound("Department with Id:" + DepartmentId + "is Not found"));
        return DepartmentMapper.mapToDepartmentDTO(department);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
            .map(department -> DepartmentMapper.mapToDepartmentDTO(department))
            .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO updateDepartment(Long Id, DepartmentDTO updatesDepartmentInfo) {
        Department department = departmentRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFound("Department with Id:" + Id + "is Not found"));
    
        department.setDepartmentName(updatesDepartmentInfo.getDepartmentName());
        department.setDepartmentDescrepttion(updatesDepartmentInfo.getDepartmentDescrepttion());
    
        Department savedUpdatedDepartment = departmentRepository.save(department);
    
        return DepartmentMapper.mapToDepartmentDTO(savedUpdatedDepartment);
    }

    @Override
    public void deleteDepartmentById(Long Id) {
        Department department = departmentRepository.findById(Id)
        .orElseThrow(() -> new ResourceNotFound("Department with Id:" + Id + "is Not found"));

       departmentRepository.deleteById(Id);
    }

}
