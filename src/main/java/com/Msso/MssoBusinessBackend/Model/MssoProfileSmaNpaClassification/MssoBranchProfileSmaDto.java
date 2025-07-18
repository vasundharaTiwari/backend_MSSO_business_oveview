package com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification;

import java.math.BigDecimal;
import java.util.Date;

public class MssoBranchProfileSmaDto {
    private Date report_date;

    private Long total_count;
    private BigDecimal total_amount;
    private Long sma0_count;
    private BigDecimal sma0_amount;
    private Long sma1_count;
    private BigDecimal sma1_amount;
    private Long sma2_count;
    private BigDecimal sma2_amount;

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

    public Long getSma0_count() {
        return sma0_count;
    }

    public void setSma0_count(Long sma0_count) {
        this.sma0_count = sma0_count;
    }

    public BigDecimal getSma0_amount() {
        return sma0_amount;
    }

    public void setSma0_amount(BigDecimal sma0_amount) {
        this.sma0_amount = sma0_amount;
    }

    public Long getSma1_count() {
        return sma1_count;
    }

    public void setSma1_count(Long sma1_count) {
        this.sma1_count = sma1_count;
    }

    public BigDecimal getSma1_amount() {
        return sma1_amount;
    }

    public void setSma1_amount(BigDecimal sma1_amount) {
        this.sma1_amount = sma1_amount;
    }

    public Long getSma2_count() {
        return sma2_count;
    }

    public void setSma2_count(Long sma2_count) {
        this.sma2_count = sma2_count;
    }

    public BigDecimal getSma2_amount() {
        return sma2_amount;
    }

    public void setSma2_amount(BigDecimal sma2_amount) {
        this.sma2_amount = sma2_amount;
    }

    public MssoBranchProfileSmaDto(Date report_date, Long total_count, BigDecimal total_amount, Long sma0_count, BigDecimal sma0_amount, Long sma1_count, BigDecimal sma1_amount, Long sma2_count, BigDecimal sma2_amount) {
        this.report_date = report_date;
        this.total_count = total_count;
        this.total_amount = total_amount;
        this.sma0_count = sma0_count;
        this.sma0_amount = sma0_amount;
        this.sma1_count = sma1_count;
        this.sma1_amount = sma1_amount;
        this.sma2_count = sma2_count;
        this.sma2_amount = sma2_amount;
    }

    public MssoBranchProfileSmaDto() {
    }
}
