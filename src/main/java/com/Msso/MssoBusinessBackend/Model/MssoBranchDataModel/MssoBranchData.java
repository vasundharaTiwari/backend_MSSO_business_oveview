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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private int gm_count;
    private int dgm_count;
    private int agm_count;
    private int cm_count;
    private int srmanager_count;
    private int manager_count;
    private int dymanager_count;
    private int clerk_count;
    private int substaff_count;

}
