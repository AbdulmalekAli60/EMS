package net.ud.EMS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
// @AllArgsConstructor
public class DepartmentDTO {

    private Long id;
    private String departmentName;
    private String departmentDescrepttion;

    public DepartmentDTO(Long Id,String Department_name,String Department_Descreption){
     this.id = Id;
     this.departmentName = Department_name;
     this.departmentDescrepttion = Department_Descreption;

    }
}
