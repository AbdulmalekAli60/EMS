package net.ud.EMS.service;

import java.util.List;

import net.ud.EMS.dto.DepartmentDTO;

public interface DepartmentService {
   public DepartmentDTO  createDepartment(DepartmentDTO departmentDTO);

   public DepartmentDTO getDepartmentById(Long Id);

   public List<DepartmentDTO> getAllDepartments();

   public DepartmentDTO updateDepartment(Long Id,DepartmentDTO departmentDTO);

   public void deleteDepartmentById(Long Id);
}
