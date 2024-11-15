package net.ud.EMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ud.EMS.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
