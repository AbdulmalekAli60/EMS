package net.ud.EMS.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//This is a JPA entity

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity // we use it to specify a class aa a JPA entity
@Table(name = "employees") // use to specify the table detailes
public class Employee {

    @Id // indicates primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_Name") // configure the column name in the database to these feilds
    private String firstName;
    @Column(name = "last_Name")
    private String LastName;
    @Column(name = "email_id", nullable = false, unique = true)
    private String email;

    //many to one relationship 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id") // foring key
    private Department department;
}
