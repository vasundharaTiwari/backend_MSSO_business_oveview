package com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel;

public class MssoBranchEmployeeDataDto {

    private String region;
    private String main_region;
    private String branch_code;
    private String branch_name;
    private String population_group_name;
    private String u_loc;
    private String grade_code;
    private String employee_name;
    private String emp_number;
    private String u_id;
    private String designation_code;
    private String u_type;
    private int desg_gm;
    private int desg_dgm;
    private int desg_agm;

    private int desg_cm;
    private int desg_srmanager;
    private int desg_manager;
    private int desg_dymanager;
    private int desg_clerk;
    private int substaff;

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

    public String getPopulation_group_name() {
        return population_group_name;
    }

    public void setPopulation_group_name(String population_group_name) {
        this.population_group_name = population_group_name;
    }

    public String getU_loc() {
        return u_loc;
    }

    public void setU_loc(String u_loc) {
        this.u_loc = u_loc;
    }

    public String getGrade_code() {
        return grade_code;
    }

    public void setGrade_code(String grade_code) {
        this.grade_code = grade_code;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmp_number() {
        return emp_number;
    }

    public void setEmp_number(String emp_number) {
        this.emp_number = emp_number;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }



    public String getU_type() {
        return u_type;
    }

    public void setU_type(String u_type) {
        this.u_type = u_type;
    }

    public int getDesg_gm() {
        return desg_gm;
    }

    public void setDesg_gm(int desg_gm) {
        this.desg_gm = desg_gm;
    }

    public int getDesg_agm() {
        return desg_agm;
    }

    public void setDesg_agm(int desg_agm) {
        this.desg_agm = desg_agm;
    }

    public int getDesg_cm() {
        return desg_cm;
    }

    public void setDesg_cm(int desg_cm) {
        this.desg_cm = desg_cm;
    }

    public int getDesg_srmanager() {
        return desg_srmanager;
    }

    public void setDesg_srmanager(int desg_srmanager) {
        this.desg_srmanager = desg_srmanager;
    }

    public int getDesg_manager() {
        return desg_manager;
    }

    public void setDesg_manager(int desg_manager) {
        this.desg_manager = desg_manager;
    }

    public int getDesg_dymanager() {
        return desg_dymanager;
    }

    public void setDesg_dymanager(int desg_dymanager) {
        this.desg_dymanager = desg_dymanager;
    }

    public int getDesg_clerk() {
        return desg_clerk;
    }

    public void setDesg_clerk(int desg_clerk) {
        this.desg_clerk = desg_clerk;
    }

    public int getSubstaff() {
        return substaff;
    }

    public void setSubstaff(int substaff) {
        this.substaff = substaff;
    }




    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getMain_region() {
        return main_region;
    }

    public void setMain_region(String main_region) {
        this.main_region = main_region;
    }



    public int getDesg_dgm() {
        return desg_dgm;
    }

    public void setDesg_dgm(int desg_dgm) {
        this.desg_dgm = desg_dgm;
    }

    public String getDesignation_code() {
        return designation_code;
    }

    public void setDesignation_code(String designation_code) {
        this.designation_code = designation_code;
    }

    public MssoBranchEmployeeDataDto(String main_region, String region, String branch_code, String branch_name, String population_group_name, String u_loc, String grade_code, String employee_name, String emp_number, String u_id, String designation_code, String u_type, int desg_gm, int desg_dgm, int desg_agm, int desg_cm, int desg_srmanager, int desg_manager, int desg_dymanager, int desg_clerk, int substaff) {
        this.main_region = main_region;
        this.region = region;
        this.branch_code = branch_code;
        this.branch_name = branch_name;
        this.population_group_name = population_group_name;
        this.u_loc = u_loc;
        this.grade_code = grade_code;
        this.employee_name = employee_name;
        this.emp_number = emp_number;
        this.u_id = u_id;
        this.designation_code = designation_code;
        this.u_type = u_type;
        this.desg_gm = desg_gm;
        this.desg_dgm = desg_dgm;
        this.desg_agm = desg_agm;
        this.desg_cm = desg_cm;
        this.desg_srmanager = desg_srmanager;
        this.desg_manager = desg_manager;
        this.desg_dymanager = desg_dymanager;
        this.desg_clerk = desg_clerk;
        this.substaff = substaff;
    }

    public MssoBranchEmployeeDataDto() {
    }
}

