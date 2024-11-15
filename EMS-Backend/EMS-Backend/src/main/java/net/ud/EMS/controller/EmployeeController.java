package net.ud.EMS.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.ud.EMS.dto.EmployeeDTO;
import net.ud.EMS.service.EmployeeService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin("*") // all clients can call the rest API's from different ports flor local
                  // development
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    // public EmployeeController(EmployeeService employeeService) {

    // }

    // Add Employee
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Get employee with id
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeWithId(@PathVariable("id") Long EmployeeId) {
        EmployeeDTO employeeWithId = employeeService.getEmployeeById(EmployeeId);

        return ResponseEntity.ok(employeeWithId);
    }

    // Get All Employees
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getMethodName() {
        List<EmployeeDTO> getAllEmplyees = employeeService.getAllEmployess(); // get All employees function returns a
                                                                              // list
        return ResponseEntity.ok(getAllEmplyees);
    }

    // Update Existing Employees
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> UpdateEmployeeInfo(@PathVariable("id") Long EmployeeId,
            @RequestBody EmployeeDTO updataEmployeeDetails) {
        EmployeeDTO employeeDTO = employeeService.updateEmployee(EmployeeId, updataEmployeeDetails);

        return ResponseEntity.ok(employeeDTO);
    }

    // Delete Employee by id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee with id: " + employeeId + " Has been deleted");
    }

}
