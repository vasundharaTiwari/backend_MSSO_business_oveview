package com.Msso.MssoBusinessBackend.Model.MssoAdvancesModel;

import java.math.BigDecimal;
import java.util.Date;

public class MssoAdvancesDto {

    private BigDecimal advances;
    private BigDecimal reg_adv;
    private BigDecimal total_npa;
    private BigDecimal freez_npa;
    private Date report_date;

    public BigDecimal getAdvances() {
        return advances;
    }

    public void setAdvances(BigDecimal advances) {
        this.advances = advances;
    }

    public BigDecimal getReg_adv() {
        return reg_adv;
    }

    public void setReg_adv(BigDecimal reg_adv) {
        this.reg_adv = reg_adv;
    }

    public BigDecimal getTotal_npa() {
        return total_npa;
    }

    public void setTotal_npa(BigDecimal total_npa) {
        this.total_npa = total_npa;
    }

    public BigDecimal getFreez_npa() {
        return freez_npa;
    }

    public void setFreez_npa(BigDecimal freez_npa) {
        this.freez_npa = freez_npa;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public MssoAdvancesDto(BigDecimal advances, BigDecimal reg_adv, BigDecimal total_npa, BigDecimal freez_npa, Date report_date) {
        this.advances = advances;
        this.reg_adv = reg_adv;
        this.total_npa = total_npa;
        this.freez_npa = freez_npa;
        this.report_date = report_date;
    }
}
