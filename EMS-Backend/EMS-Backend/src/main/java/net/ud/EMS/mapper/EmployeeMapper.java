package net.ud.EMS.mapper;

import net.ud.EMS.dto.EmployeeDTO;
import net.ud.EMS.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDTO mapToEmployeeDto(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment().getId());

    }

    public static Employee mapToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(); // create emplyee object and setting its values
        // employee.setId(employeeDTO.getId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());

        return employee;
    }
}
