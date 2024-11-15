package net.ud.EMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ud.EMS.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
