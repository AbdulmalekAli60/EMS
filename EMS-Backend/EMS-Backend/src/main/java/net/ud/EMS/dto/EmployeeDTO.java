package net.ud.EMS.dto;

// import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDTO { // We use DTO class to transfer data between client and server
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Long departmentId;
}
