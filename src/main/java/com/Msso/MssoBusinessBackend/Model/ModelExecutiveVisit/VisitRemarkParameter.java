package com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit;

import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.util.Date;

public class VisitRemarkParameter {

    private String parameterDetailRemark;
    private String sanctionDisbursedRemark;
    private String smaRemark;
    private String npaClassificationRemark;
    private String complianceRemark;
    private String accountAndDigitalStatusRemark;
    private String socialSecurityRemark;
    private String otherRemark;
    private String employeeDataRemark;
    private String visitor_userid;
    private String visitor_name;
    private String visitor_designation;
    private String visitor_branch_code;
    private String visitor_region;
    private String region;
    private String u_loc;

    private Date bmBranchJoinDate;
    private Date branchOpeningDate;
    private String branch_code;
    private BigDecimal perEmployeeBusiness;
    private BigDecimal sma0Percentage;
    private BigDecimal sma1Percentage;
    private BigDecimal sma2Percentage;
    private BigDecimal smaTotalPercentage;
    private Date agreement_end_date;
    private String  governmentRemark;

    public Date getAgreement_end_date() {
        return agreement_end_date;
    }

    public void setAgreement_end_date(Date agreement_end_date) {
        this.agreement_end_date = agreement_end_date;
    }

    public String getGovernmentRemark() {
        return governmentRemark;
    }

    public void setGovernmentRemark(String governmentRemark) {
        this.governmentRemark = governmentRemark;
    }

    public BigDecimal getSma0Percentage() {
        return sma0Percentage;
    }

    public void setSma0Percentage(BigDecimal sma0Percentage) {
        this.sma0Percentage = sma0Percentage;
    }

    public BigDecimal getSma1Percentage() {
        return sma1Percentage;
    }

    public void setSma1Percentage(BigDecimal sma1Percentage) {
        this.sma1Percentage = sma1Percentage;
    }

    public BigDecimal getSma2Percentage() {
        return sma2Percentage;
    }

    public void setSma2Percentage(BigDecimal sma2Percentage) {
        this.sma2Percentage = sma2Percentage;
    }

    public BigDecimal getSmaTotalPercentage() {
        return smaTotalPercentage;
    }

    public void setSmaTotalPercentage(BigDecimal smaTotalPercentage) {
        this.smaTotalPercentage = smaTotalPercentage;
    }

    public BigDecimal getTotal_staff_branch() {
        return total_staff_branch;
    }

    public void setTotal_staff_branch(BigDecimal total_staff_branch) {
        this.total_staff_branch = total_staff_branch;
    }

    public BigDecimal getTotal_staff_region() {
        return total_staff_region;
    }

    public void setTotal_staff_region(BigDecimal total_staff_region) {
        this.total_staff_region = total_staff_region;
    }

    private BigDecimal total_staff_branch;
    private BigDecimal total_staff_region;

    public Date getBranchOpeningDate() {
        return branchOpeningDate;
    }

    public void setBranchOpeningDate(Date branchOpeningDate) {
        this.branchOpeningDate = branchOpeningDate;
    }

    public String getEmployeeDataRemark() {
        return employeeDataRemark;
    }

    public void setEmployeeDataRemark(String employeeDataRemark) {
        this.employeeDataRemark = employeeDataRemark;
    }

    public String getParameterDetailRemark() {
        return parameterDetailRemark;
    }

    public void setParameterDetailRemark(String parameterDetailRemark) {
        this.parameterDetailRemark = parameterDetailRemark;
    }

    public String getSanctionDisbursedRemark() {
        return sanctionDisbursedRemark;
    }

    public void setSanctionDisbursedRemark(String sanctionDisbursedRemark) {
        this.sanctionDisbursedRemark = sanctionDisbursedRemark;
    }

    public String getSmaRemark() {
        return smaRemark;
    }

    public void setSmaRemark(String smaRemark) {
        this.smaRemark = smaRemark;
    }

    public String getNpaClassificationRemark() {
        return npaClassificationRemark;
    }

    public void setNpaClassificationRemark(String npaClassificationRemark) {
        this.npaClassificationRemark = npaClassificationRemark;
    }

    public String getComplianceRemark() {
        return complianceRemark;
    }

    public void setComplianceRemark(String complianceRemark) {
        this.complianceRemark = complianceRemark;
    }

    public String getAccountAndDigitalStatusRemark() {
        return accountAndDigitalStatusRemark;
    }

    public void setAccountAndDigitalStatusRemark(String accountAndDigitalStatusRemark) {
        this.accountAndDigitalStatusRemark = accountAndDigitalStatusRemark;
    }

    public String getSocialSecurityRemark() {
        return socialSecurityRemark;
    }

    public void setSocialSecurityRemark(String socialSecurityRemark) {
        this.socialSecurityRemark = socialSecurityRemark;
    }

    public String getOtherRemark() {
        return otherRemark;
    }

    public void setOtherRemark(String otherRemark) {
        this.otherRemark = otherRemark;
    }

    public String getVisitor_userid() {
        return visitor_userid;
    }

    public void setVisitor_userid(String visitor_userid) {
        this.visitor_userid = visitor_userid;
    }

    public String getVisitor_name() {
        return visitor_name;
    }

    public void setVisitor_name(String visitor_name) {
        this.visitor_name = visitor_name;
    }

    public String getVisitor_designation() {
        return visitor_designation;
    }

    public void setVisitor_designation(String visitor_designation) {
        this.visitor_designation = visitor_designation;
    }

    public String getVisitor_branch_code() {
        return visitor_branch_code;
    }

    public void setVisitor_branch_code(String visitor_branch_code) {
        this.visitor_branch_code = visitor_branch_code;
    }

    public String getVisitor_region() {
        return visitor_region;
    }

    public void setVisitor_region(String visitor_region) {
        this.visitor_region = visitor_region;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getU_loc() {
        return u_loc;
    }

    public void setU_loc(String u_loc) {
        this.u_loc = u_loc;
    }

    public Date getBmBranchJoinDate() {
        return bmBranchJoinDate;
    }

    public void setBmBranchJoinDate(Date bmBranchJoinDate) {
        this.bmBranchJoinDate = bmBranchJoinDate;
    }

    public String getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }

    public BigDecimal getPerEmployeeBusiness() {
        return perEmployeeBusiness;
    }

    public void setPerEmployeeBusiness(BigDecimal perEmployeeBusiness) {
        this.perEmployeeBusiness = perEmployeeBusiness;
    }


}
