package com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal;

import java.math.BigDecimal;
import java.util.Date;

public class MssoProfileReviewRenewalDto {
    public MssoProfileReviewRenewalDto(Date report_date, Long kcc_count, BigDecimal kcc_amount, Long nacc_count, BigDecimal nacc_amount) {
        this.report_date = report_date;
        this.kcc_count = kcc_count;
        this.kcc_amount = kcc_amount;
        this.nacc_count = nacc_count;
        this.nacc_amount = nacc_amount;
    }

    private Date report_date;
    private Long kcc_count;

    public Long getKcc_count() {
        return kcc_count;
    }

    public void setKcc_count(Long kcc_count) {
        this.kcc_count = kcc_count;
    }

    public BigDecimal getKcc_amount() {
        return kcc_amount;
    }

    public void setKcc_amount(BigDecimal kcc_amount) {
        this.kcc_amount = kcc_amount;
    }

    private BigDecimal kcc_amount;

    private Long nacc_count;
    private BigDecimal nacc_amount;

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }



    public Long getNacc_count() {
        return nacc_count;
    }

    public void setNacc_count(Long nacc_count) {
        this.nacc_count = nacc_count;
    }

    public BigDecimal getNacc_amount() {
        return nacc_amount;
    }

    public void setNacc_amount(BigDecimal nacc_amount) {
        this.nacc_amount = nacc_amount;
    }


}
