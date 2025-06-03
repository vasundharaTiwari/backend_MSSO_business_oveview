package com.Msso.MssoBusinessBackend.Model.MssoBusinessModel;

import java.math.BigDecimal;
import java.util.Date;

public class DtoMssoBusinessBranchwise {
    private Date report_date;
    private String branch_code;
    private String branch_name;
    private BigDecimal deposit;
    private BigDecimal advances;

    private BigDecimal totalBusiness;
    private BigDecimal casaPercent;

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
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

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getAdvances() {
        return advances;
    }

    public void setAdvances(BigDecimal advances) {
        this.advances = advances;
    }

    public BigDecimal getTotalBusiness() {
        return totalBusiness;
    }

    public void setTotalBusiness(BigDecimal totalBusiness) {
        this.totalBusiness = totalBusiness;
    }

    public BigDecimal getCasaPercent() {
        return casaPercent;
    }

    public void setCasaPercent(BigDecimal casaPercent) {
        this.casaPercent = casaPercent;
    }

    public DtoMssoBusinessBranchwise(Date report_date, String branch_code, String branch_name, BigDecimal deposit, BigDecimal advances, BigDecimal totalBusiness, BigDecimal casaPercent) {
        this.report_date = report_date;
        this.branch_code = branch_code;
        this.branch_name = branch_name;
        this.deposit = deposit;
        this.advances = advances;
        this.totalBusiness = totalBusiness;
        this.casaPercent = casaPercent;
    }
}
