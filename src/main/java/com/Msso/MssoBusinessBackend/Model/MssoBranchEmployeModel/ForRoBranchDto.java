package com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel;

public class ForRoBranchDto {

    private String region;

    private String branch_code;
    private String branch_name;
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

    public ForRoBranchDto(String region, String branch_code, String branchName) {
        this.region = region;
        this.branch_code = branch_code;
        this.branch_name = branchName;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }
}
