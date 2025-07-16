package com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal;

import java.math.BigDecimal;
import java.util.Date;

public class MssoProfileReviewRenewalDto {

    private Date report_date;
    private Long total_count;
    private BigDecimal total_amount;

    private Long nacc_count;
    private BigDecimal nacc_amount;

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public Long getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Long total_count) {
        this.total_count = total_count;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
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

    public MssoProfileReviewRenewalDto(Date report_date, Long total_count, BigDecimal total_amount, Long nacc_count, BigDecimal nacc_amount) {
        this.report_date = report_date;
        this.total_count = total_count;
        this.total_amount = total_amount;
        this.nacc_count = nacc_count;
        this.nacc_amount = nacc_amount;
    }
}
