package com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification;

import java.math.BigDecimal;
import java.util.Date;

public class NpaRecoveryProgressDto {
    private Date report_date;
    private Long addition_count;
    private BigDecimal addition_os_amt;
    private Long upgrade_count;
    private BigDecimal upgrade_os_amt ;
    private Long recovered_count;
    private BigDecimal recovered_os_amt;

    public NpaRecoveryProgressDto(Date report_date, Long addition_count, BigDecimal addition_os_amt, Long upgrade_count, BigDecimal upgrade_os_amt, Long recovered_count, BigDecimal recovered_os_amt) {
        this.report_date = report_date;
        this.addition_count = addition_count;
        this.addition_os_amt = addition_os_amt;
        this.upgrade_count = upgrade_count;
        this.upgrade_os_amt = upgrade_os_amt;
        this.recovered_count = recovered_count;
        this.recovered_os_amt = recovered_os_amt;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public Long getAddition_count() {
        return addition_count;
    }

    public void setAddition_count(Long addition_count) {
        this.addition_count = addition_count;
    }

    public BigDecimal getAddition_os_amt() {
        return addition_os_amt;
    }

    public void setAddition_os_amt(BigDecimal addition_os_amt) {
        this.addition_os_amt = addition_os_amt;
    }

    public Long getUpgrade_count() {
        return upgrade_count;
    }

    public void setUpgrade_count(Long upgrade_count) {
        this.upgrade_count = upgrade_count;
    }

    public BigDecimal getUpgrade_os_amt() {
        return upgrade_os_amt;
    }

    public void setUpgrade_os_amt(BigDecimal upgrade_os_amt) {
        this.upgrade_os_amt = upgrade_os_amt;
    }

    public Long getRecovered_count() {
        return recovered_count;
    }

    public void setRecovered_count(Long recovered_count) {
        this.recovered_count = recovered_count;
    }

    public BigDecimal getRecovered_os_amt() {
        return recovered_os_amt;
    }

    public void setRecovered_os_amt(BigDecimal recovered_os_amt) {
        this.recovered_os_amt = recovered_os_amt;
    }
}
