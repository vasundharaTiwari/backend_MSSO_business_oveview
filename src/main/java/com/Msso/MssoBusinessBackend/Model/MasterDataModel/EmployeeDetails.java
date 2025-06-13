package com.Msso.MssoBusinessBackend.Model.MasterDataModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(schema="hrms",  name = "employee_details")
public class EmployeeDetails {
    @Id
    private String  emp_id;
    private String emp_number;
    private String salary_code;
    private String employee_name;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String seniority_number;
    private LocalDate last_promotion_date;
    private String grade_code;
    private String gender;
    private String branch_code;
    private String branch_name;
    private String subdistrict;
    private String district;
    private String region;
    private String designation_code;
    private String ex_service_man;
    private String email;
    private String phoneno;
    private String mobileno;
    private LocalDate date_of_birth;
    private LocalDate date_of_joining;
    private LocalDate  confirm_date;
    private LocalDate super_annuation_date;
    private String emp_status;
    private String status;
    private LocalDate status_date;
}
