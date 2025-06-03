package com.Msso.MssoBusinessBackend.Model.MssoBusinessModel;

import java.math.BigDecimal;
import java.util.Date;

public class DtoMssoBusinessRegionwise {
    private Date report_date;
    private String region;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    public DtoMssoBusinessRegionwise(Date report_date, String region, BigDecimal deposit, BigDecimal advances, BigDecimal totalBusiness, BigDecimal casaPercent) {
        this.report_date = report_date;
        this.region = region;
        this.deposit = deposit;
        this.advances = advances;
        this.totalBusiness = totalBusiness;
        this.casaPercent = casaPercent;
    }
}
