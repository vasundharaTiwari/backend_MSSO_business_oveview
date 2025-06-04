package com.Msso.MssoBusinessBackend.Model.MssoDepositModel;

import java.math.BigDecimal;
import java.util.Date;

public class DtoMssoDepositBranchwise {
private String branch_code;
    private Date report_date;
    private BigDecimal sb;
    private java.math.BigDecimal ca;
    private BigDecimal td;
    private BigDecimal deposit;

    public String getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public BigDecimal getSb() {
        return sb;
    }

    public void setSb(BigDecimal sb) {
        this.sb = sb;
    }

    public BigDecimal getCa() {
        return ca;
    }

    public void setCa(BigDecimal ca) {
        this.ca = ca;
    }

    public BigDecimal getTd() {
        return td;
    }

    public void setTd(BigDecimal td) {
        this.td = td;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public DtoMssoDepositBranchwise(String branch_code, Date report_date, BigDecimal sb, BigDecimal ca, BigDecimal td, BigDecimal deposit) {
        this.branch_code = branch_code;
        this.report_date = report_date;
        this.sb = sb;
        this.ca = ca;
        this.td = td;
        this.deposit = deposit;
    }
}
