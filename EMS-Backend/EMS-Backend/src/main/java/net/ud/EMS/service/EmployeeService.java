package net.ud.EMS.service;

import java.util.List;

import net.ud.EMS.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long Id);

    List<EmployeeDTO> getAllEmployess();

    EmployeeDTO updateEmployee(Long empoyeeId, EmployeeDTO UpdatedEmployeeDeatils);

    void deleteEmployee(Long Id);
}
