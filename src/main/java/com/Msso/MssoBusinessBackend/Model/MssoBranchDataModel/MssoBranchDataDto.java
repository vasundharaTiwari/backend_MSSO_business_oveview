package com.Msso.MssoBusinessBackend.Model.MssoBranchDataModel;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MssoBranchDataDto {

    @Column(name="region")
    private String region;
    @Column(name="branch_code")
    private String branchCode;
    @Column(name="branch_name")
    private String branchName;
    @Column(name="population_group_name")
    private String populationGroupName;
    @Column(name="u_loc")
    private String uLoc;
    @Column(name="grade_code")
    private String gradeCode;
    @Column(name="employee_name")
    private String employeeName;
    @Column(name="emp_number")
    private String empNumber;
    @Column(name="u_id")
    private String uId;
    @Column(name="designation_code")
    private String designationCode;
    @Column(name="u_type")
    private String uType;
    @Column(name="desg_gm")
    private Long desgGm;
    @Column(name="desg_dgm")
    private Long desgDgm;
    @Column(name="desg_agm")
    private Long desgAgm;
    @Column(name="desg_cm")
    private Long desgCm;
    @Column(name="desg_srmanager")
    private Long desgSrmanager;
    @Column(name="desg_manager")
    private Long desgManager;
    @Column(name="desg_dymanager")
    private Long desgDymanager;
    @Column(name="desg_clerk")
    private Long desgClerk;
    @Column(name="substaff")
    private Long substaff;


public MssoBranchDataDto(String region, String branchCode, String branchName,
                             String populationGroupName, String uLoc, String gradeCode,
                             String employeeName, String empNumber, String uId,
                             String designationCode, String uType, Long desgGm, Long desgDgm,
                         Long desgAgm, Long desgCm, Long desgSrmanager, Long desgManager,
                         Long desgDymanager, Long desgClerk, Long substaff) {

    this.region = region;
    this.branchCode = branchCode;
    this.branchName = branchName;
    this.populationGroupName = populationGroupName;
    this.uLoc = uLoc;
    this.gradeCode = gradeCode;
    this.employeeName = employeeName;
    this.empNumber = empNumber;
    this.uId = uId;
    this.designationCode = designationCode;
    this.uType = uType;
    this.desgGm = desgGm;
    this.desgDgm = desgDgm;
    this.desgAgm = desgAgm;
    this.desgCm = desgCm;
    this.desgSrmanager = desgSrmanager;
    this.desgManager = desgManager;
    this.desgDymanager = desgDymanager;
    this.desgClerk = desgClerk;
    this.substaff = substaff;
}

    public String getRegion() { return region; }
    public String getBranchCode() { return branchCode; }
    public String getBranchName() { return branchName; }
    public String getPopulationGroupName() { return populationGroupName; }
    public String getULoc() { return uLoc; }
    public String getGradeCode() { return gradeCode; }
    public String getEmployeeName() { return employeeName; }
    public String getEmpNumber() { return empNumber; }
    public String getUId() { return uId; }
    public String getDesignationCode() { return designationCode; }
    public String getUType() { return uType; }
    public Long getDesgGm() { return desgGm; }
    public Long getDesgDgm() { return desgDgm; }

    public Long getDesgAgm() { return desgAgm; }

    public Long getDesgCm() { return desgCm; }

    public Long getDesgSrmanager() { return desgSrmanager; }

    public Long getDesgManager() { return desgManager; }

    public Long getDesgDymanager() { return desgDymanager; }

    public Long getDesgClerk() { return desgClerk; }

    public Long getSubstaff() { return substaff; }


    // Setters
    public void setRegion(String region) { this.region = region; }
    public void setBranchCode(String branchCode) { this.branchCode = branchCode; }
    public void setBranchName(String branchName) { this.branchName = branchName; }
    public void setPopulationGroupName(String populationGroupName) { this.populationGroupName = populationGroupName; }
    public void setULoc(String uLoc) { this.uLoc = uLoc; }
    public void setGradeCode(String gradeCode) { this.gradeCode = gradeCode; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }
    public void setEmpNumber(String empNumber) { this.empNumber = empNumber; }
    public void setUId(String uId) { this.uId = uId; }
    public void setDesignationCode(String designationCode) { this.designationCode = designationCode; }
    public void setUType(String uType) { this.uType = uType; }
    public void setDesgCm(Long desgCm) { this.desgGm = desgCm; }
    public void setDesgDgm(Long desgDgm) { this.desgGm = desgDgm; }
    public void setDesgAgm(Long desgAgm) { this.desgAgm = desgAgm; }
    public void setDesgSrmanager(Long desgSrmanager) { this.desgSrmanager = desgSrmanager; }
    public void setDesgManager(Long desgManager) { this.desgManager = desgManager; }
    public void setDesgDymanager(Long desgDymanager) { this.desgDymanager = desgDymanager; }
    public void setDesgClerk(Long desgClerk) { this.desgClerk = desgClerk; }
    public void setSubstaff(Long substaff) { this.substaff = substaff; }

}

