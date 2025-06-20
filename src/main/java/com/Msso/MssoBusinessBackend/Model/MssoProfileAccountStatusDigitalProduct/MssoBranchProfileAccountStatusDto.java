package com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct;

import java.math.BigDecimal;
import java.util.Date;

public class MssoBranchProfileAccountStatusDto {
    private Date report_date;


    private Long sb_ac_count;
    private Long ca_ac_count;
    private Long casa_count;
    private BigDecimal casa_amount;

    public MssoBranchProfileAccountStatusDto(Date report_date, Long sb_ac_count, Long ca_ac_count, Long casa_count, BigDecimal casa_amount) {
        this.report_date = report_date;
        this.sb_ac_count = sb_ac_count;
        this.ca_ac_count = ca_ac_count;
        this.casa_count = casa_count;
        this.casa_amount = casa_amount;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public Long getSb_ac_count() {
        return sb_ac_count;
    }

    public void setSb_ac_count(Long sb_ac_count) {
        this.sb_ac_count = sb_ac_count;
    }

    public Long getCa_ac_count() {
        return ca_ac_count;
    }

    public void setCa_ac_count(Long ca_ac_count) {
        this.ca_ac_count = ca_ac_count;
    }

    public Long getCasa_count() {
        return casa_count;
    }

    public void setCasa_count(Long casa_count) {
        this.casa_count = casa_count;
    }

    public BigDecimal getCasa_amount() {
        return casa_amount;
    }

    public void setCasa_amount(BigDecimal casa_amount) {
        this.casa_amount = casa_amount;
    }
}
