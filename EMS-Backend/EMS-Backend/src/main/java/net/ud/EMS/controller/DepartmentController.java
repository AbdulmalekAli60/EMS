package net.ud.EMS.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.ud.EMS.dto.DepartmentDTO;
import net.ud.EMS.service.DepartmentService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {
    private DepartmentService departmentService;

    // add department api
    @PostMapping()
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO) {

        DepartmentDTO department = departmentService.createDepartment(departmentDTO);

        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    // get department by id
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("id") Long DepartmentId) {
        DepartmentDTO departmentDTO = departmentService.getDepartmentById(DepartmentId);
        return ResponseEntity.ok(departmentDTO);
    }

    // get all departments
    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {

        List<DepartmentDTO> allDepartments = departmentService.getAllDepartments();

        return ResponseEntity.ok(allDepartments);
    }

    // Update an existing department
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable("id") Long departmentId,
            @RequestBody DepartmentDTO updatedDepartment) {

        DepartmentDTO updatedDepartmentDto = departmentService.updateDepartment(departmentId, updatedDepartment);

        return ResponseEntity.ok(updatedDepartmentDto);
    }

    // delete department by id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartmentbyId(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);

        return ResponseEntity.ok("Deparemtn with id: " + departmentId + " Has been deleted");
    }

}
