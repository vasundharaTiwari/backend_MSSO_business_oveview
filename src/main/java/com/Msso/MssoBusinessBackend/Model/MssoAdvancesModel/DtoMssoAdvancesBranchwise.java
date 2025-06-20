package com.Msso.MssoBusinessBackend.Model.MssoAdvancesModel;

import java.math.BigDecimal;
import java.util.Date;

public class DtoMssoAdvancesBranchwise {
    private String branch_code;
    private String branch_name;
    private Date report_date;
    private BigDecimal advances;
    private BigDecimal reg_adv;
    private BigDecimal total_npa;
    private BigDecimal freez_npa;

    public String getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }

    public BigDecimal getFreez_npa() {
        return freez_npa;
    }

    public void setFreez_npa(BigDecimal freez_npa) {
        this.freez_npa = freez_npa;
    }

    public BigDecimal getTotal_npa() {
        return total_npa;
    }

    public void setTotal_npa(BigDecimal total_npa) {
        this.total_npa = total_npa;
    }

    public BigDecimal getReg_adv() {
        return reg_adv;
    }

    public void setReg_adv(BigDecimal reg_adv) {
        this.reg_adv = reg_adv;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public BigDecimal getAdvances() {
        return advances;
    }

    public void setAdvances(BigDecimal advances) {
        this.advances = advances;
    }

    public DtoMssoAdvancesBranchwise(String branch_code, String branchName, Date report_date, BigDecimal advances, BigDecimal reg_adv, BigDecimal total_npa, BigDecimal freez_npa) {
        this.branch_code = branch_code;
        this.branch_name = branchName;
        this.report_date = report_date;
        this.advances = advances;
        this.reg_adv = reg_adv;
        this.total_npa = total_npa;
        this.freez_npa = freez_npa;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }
}
