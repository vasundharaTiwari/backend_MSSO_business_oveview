package com.Msso.MssoBusinessBackend.Model.MssoBranchDataModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "msso_branch_profile", name = "branch_data")
public class MssoBranchEmployeeData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String region;
    private String main_region;
    private String branch_code;
    private String branch_name;
    private String population_group_name;
    private String u_loc;
    private String grade_code;
    private String employee_name;
    private String emp_number;
    private String u_id;
    private String designation_code;
    private String u_type;
    private int desg_gm;
    private int desg_agm;
    private int desg_dgm;

    private int desg_cm;
    private int desg_srmanager;
    private int desg_manager;
    private int desg_dymanager;
    private int desg_clerk;
    private int substaff;





}
