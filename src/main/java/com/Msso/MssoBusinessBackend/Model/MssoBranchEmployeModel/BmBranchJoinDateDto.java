package com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel;

import java.util.Date;

public class BmBranchJoinDateDto {

    private String branch_code;
    private String region;
    private Date bmBranchJoinDate;

    public String getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }



    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getBmBranchJoinDate() {
        return bmBranchJoinDate;
    }

    public void setBmBranchJoinDate(Date bmBranchJoinDate) {
        this.bmBranchJoinDate = bmBranchJoinDate;
    }

    public BmBranchJoinDateDto(String branch_code,  String region, Date bmBranchJoinDate) {
        this.branch_code = branch_code;
        this.region = region;
        this.bmBranchJoinDate = bmBranchJoinDate;
    }
}
