package net.ud.EMS.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.ud.EMS.dto.EmployeeDTO;
import net.ud.EMS.entity.Department;
import net.ud.EMS.entity.Employee;
import net.ud.EMS.exception.ResourceNotFound;
import net.ud.EMS.mapper.EmployeeMapper;
import net.ud.EMS.repository.DepartmentRepository;
import net.ud.EMS.repository.EmployeeRepository;
import net.ud.EMS.service.EmployeeService;

@Service // tell spring container to create spring bean for this class
@AllArgsConstructor
public class EmplyeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository; // This is a dependency that we will inject in the constructor
    private DepartmentRepository departmentRepository;
    // @Autowired
    // public EmplyeeServiceImpl(EmployeeRepository employeeRepository ){
    // this.employeeRepository = employeeRepository;
    // }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        // Add validation for departmentId
        if (employeeDTO.getDepartmentId() == null) {
            throw new IllegalArgumentException("Department ID must not be null");
        }
    
        // First check if department exists
        Department department = departmentRepository.findById(employeeDTO.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFound(
                        "Department does not exist with id: " + employeeDTO.getDepartmentId()));
    
        // Then map and set the employee details
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        employee.setDepartment(department);
    
        // Save the employee
        Employee createdEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(createdEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long emploeyyId) {
        Employee employee = employeeRepository.findById(emploeyyId)
                .orElseThrow(() -> new ResourceNotFound("Employee with Id:" + emploeyyId + "is Not found"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployess() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long empoyeeId, EmployeeDTO UpdatedEmployeeDeatils) {
        Employee employee = employeeRepository.findById(empoyeeId)
                .orElseThrow(() -> new ResourceNotFound("Employee with Id:" + empoyeeId + "is Not found"));

        employee.setFirstName(UpdatedEmployeeDeatils.getFirstName());
        employee.setLastName(UpdatedEmployeeDeatils.getLastName());
        employee.setEmail(UpdatedEmployeeDeatils.getEmail());

        Department department = departmentRepository.findById(UpdatedEmployeeDeatils.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFound(
                        "Department dose not exisit with id: " + UpdatedEmployeeDeatils.getDepartmentId()));

        employee.setDepartment(department);

        Employee updatedEmplyee = employeeRepository.save(employee); // save method perform both save and update
                                                                     // operation
        return EmployeeMapper.mapToEmployeeDto(updatedEmplyee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFound("Employee with Id:" + employeeId + "is Not found"));

        employeeRepository.deleteById(employeeId);
    }

}
