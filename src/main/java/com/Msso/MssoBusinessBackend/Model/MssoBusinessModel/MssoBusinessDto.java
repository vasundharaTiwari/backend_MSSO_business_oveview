package com.Msso.MssoBusinessBackend.Model.MssoBusinessModel;

import java.math.BigDecimal;
import java.util.Date;


public class MssoBusinessDto {
    public BigDecimal getDeposit() {
        return deposit;
    }

    public MssoBusinessDto() {

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

    private BigDecimal deposit;
    private BigDecimal  advances;

    public MssoBusinessDto(BigDecimal deposit, BigDecimal advances, BigDecimal totalBusiness, BigDecimal casaPercent, Date report_date) {
        this.deposit = deposit;
        this.advances = advances;
        this.totalBusiness = totalBusiness;
        this.casaPercent = casaPercent;
        this.report_date = report_date;
    }

    private BigDecimal  totalBusiness;
    private BigDecimal  casaPercent;
    private Date report_date;


    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }
}

