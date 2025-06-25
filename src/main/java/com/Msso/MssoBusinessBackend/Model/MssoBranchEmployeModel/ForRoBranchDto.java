package com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel;

public class ForRoBranchDto {

    private String region;

    private String branch_code;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }

    public ForRoBranchDto(String region, String branch_code) {
        this.region = region;
        this.branch_code = branch_code;
    }
}
