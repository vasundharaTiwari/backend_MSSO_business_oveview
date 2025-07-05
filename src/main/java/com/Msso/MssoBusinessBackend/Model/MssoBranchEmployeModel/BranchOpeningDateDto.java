package com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel;

import java.util.Date;

public class BranchOpeningDateDto {

    private String branch_code;
    private String branch_name;
    private String region;
    private Date branchopendate;

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

    public Date getBranchopendate() {
        return branchopendate;
    }

    public void setBranchopendate(Date branchopendate) {
        this.branchopendate = branchopendate;
    }

    public BranchOpeningDateDto(String branch_code, String branch_name, String region, Date branchopendate) {
        this.branch_code = branch_code;
        this.branch_name = branch_name;
        this.region = region;
        this.branchopendate = branchopendate;
    }
}
