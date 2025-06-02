package com.Msso.MssoBusinessBackend.Model.MssoDepositModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

public class MssoDepositDto {

    private BigDecimal sb;
    private BigDecimal ca;
    private BigDecimal td;

    public MssoDepositDto(BigDecimal sb, BigDecimal ca, BigDecimal td, BigDecimal deposit, Date report_date) {
        this.sb = sb;
        this.ca = ca;
        this.td = td;
        this.deposit = deposit;
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

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    private BigDecimal deposit;
    private Date report_date;

}
