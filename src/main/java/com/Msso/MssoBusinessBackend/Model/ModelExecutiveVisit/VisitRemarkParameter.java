package com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit;

import java.math.BigDecimal;

public class VisitRemarkParameter {

    private  String parameterDetailRemark;
    private  String sanctionDisbursedRemark;
    private  String smaRemark;
    private  String npaClassificationRemark;
    private  String complianceRemark;
    private  String accountAndDigitalStatusRemark;
    private  String socialSecurityRemark;
    private  String otherRemark;

    private  String visitor_userid;
    private  String visitor_name;
    private  String visitor_designation;
    private  String visitor_branch_code;
    private  String visitor_region;
    private  String region;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    private  String branch_code;
    private BigDecimal perEmployeeBusiness;
    private BigDecimal total_staff;

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

    public BigDecimal getTotal_staff() {
        return total_staff;
    }

    public void setTotal_staff(BigDecimal total_staff) {
        this.total_staff = total_staff;
    }
}
