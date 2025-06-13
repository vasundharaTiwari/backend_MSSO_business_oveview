package com.Msso.MssoBusinessBackend.Model.MssoBranchDataModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="msso_branch_profile",  name = "branch_data")
public class MssoBranchData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String region;
    private String branchCode;
    private String populationGroupName;
    private String uLoc;
    private String gradeCode;
    private String employeeName;
    private String empNumber;
    private String uId;
    private String designationCode;
    private String uType;
    private int gmCount;
    private int dgmCount;
    private int agmCount;
    private int cmCount;
    private int srmanagerCount;
    private int managerCount;
    private int dymanagerCount;
    private int clerkCount;
    private int substaffCount;

}
