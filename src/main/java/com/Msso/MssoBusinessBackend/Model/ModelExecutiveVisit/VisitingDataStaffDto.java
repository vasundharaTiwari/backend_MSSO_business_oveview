package com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit;

import java.util.Date;

public class VisitingDataStaffDto {
    private Date visit_date;
    private String branch_code;
    private String branch_name;
    private String region;
    private String visitor_name;
    private String visitor_region;
    private String visitor_branch_code;
    private String visitor_designation;
    private Long count;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public VisitingDataStaffDto(String region, Long count) {
        this.region = region;
        this.count = count;
    }

  

    public Date getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(Date visit_date) {
        this.visit_date = visit_date;
    }

    public String getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getVisitor_name() {
        return visitor_name;
    }

    public void setVisitor_name(String visitor_name) {
        this.visitor_name = visitor_name;
    }

    public String getVisitor_region() {
        return visitor_region;
    }

    public void setVisitor_region(String visitor_region) {
        this.visitor_region = visitor_region;
    }

    public String getVisitor_branch_code() {
        return visitor_branch_code;
    }

    public void setVisitor_branch_code(String visitor_branch_code) {
        this.visitor_branch_code = visitor_branch_code;
    }

    public String getVisitor_designation() {
        return visitor_designation;
    }

    public void setVisitor_designation(String visitor_designation) {
        this.visitor_designation = visitor_designation;
    }

    public VisitingDataStaffDto(Date visit_date, String branch_code, String branch_name, String region, String visitor_name, String visitor_region, String visitor_branch_code, String visitor_designation) {
        this.visit_date = visit_date;
        this.branch_code = branch_code;
        this.branch_name = branch_name;
        this.region = region;
        this.visitor_name = visitor_name;
        this.visitor_region = visitor_region;
        this.visitor_branch_code = visitor_branch_code;
        this.visitor_designation = visitor_designation;
    }
}
