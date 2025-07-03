package com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification;

import java.math.BigDecimal;
import java.util.Date;

public class MssoProfileNpaClassificationDto {
    private Date report_date;

    private Long total_count;
    private BigDecimal total_amount;
    private Long subStandard_count;
    private BigDecimal subStandard_amount;
    private Long d0_count;
    private BigDecimal d0_amount;
    private Long d1_count;
    private BigDecimal d1_amount;
    private Long d2_count;
    private BigDecimal d2_amount;
    private Long lost_count;
    private BigDecimal lost_amount;

    public MssoProfileNpaClassificationDto(Date report_date, Long total_count, BigDecimal total_amount, Long subStandard_count, BigDecimal subStandard_amount, Long d0_count, BigDecimal d0_amount, Long d1_count, BigDecimal d1_amount, Long d2_count, BigDecimal d2_amount, Long lost_count, BigDecimal lost_amount) {
        this.report_date = report_date;
        this.total_count = total_count;
        this.total_amount = total_amount;
        this.subStandard_count = subStandard_count;
        this.subStandard_amount = subStandard_amount;
        this.d0_count = d0_count;
        this.d0_amount = d0_amount;
        this.d1_count = d1_count;
        this.d1_amount = d1_amount;
        this.d2_count = d2_count;
        this.d2_amount = d2_amount;
        this.lost_count = lost_count;
        this.lost_amount = lost_amount;
    }

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

    public Long getSubStandard_count() {
        return subStandard_count;
    }

    public void setSubStandard_count(Long subStandard_count) {
        this.subStandard_count = subStandard_count;
    }

    public BigDecimal getSubStandard_amount() {
        return subStandard_amount;
    }

    public void setSubStandard_amount(BigDecimal subStandard_amount) {
        this.subStandard_amount = subStandard_amount;
    }

    public Long getD0_count() {
        return d0_count;
    }

    public void setD0_count(Long d0_count) {
        this.d0_count = d0_count;
    }

    public BigDecimal getD0_amount() {
        return d0_amount;
    }

    public void setD0_amount(BigDecimal d0_amount) {
        this.d0_amount = d0_amount;
    }

    public Long getD1_count() {
        return d1_count;
    }

    public void setD1_count(Long d1_count) {
        this.d1_count = d1_count;
    }

    public BigDecimal getD1_amount() {
        return d1_amount;
    }

    public void setD1_amount(BigDecimal d1_amount) {
        this.d1_amount = d1_amount;
    }

    public Long getD2_count() {
        return d2_count;
    }

    public void setD2_count(Long d2_count) {
        this.d2_count = d2_count;
    }

    public BigDecimal getD2_amount() {
        return d2_amount;
    }

    public void setD2_amount(BigDecimal d2_amount) {
        this.d2_amount = d2_amount;
    }

    public Long getLost_count() {
        return lost_count;
    }

    public void setLost_count(Long lost_count) {
        this.lost_count = lost_count;
    }

    public BigDecimal getLost_amount() {
        return lost_amount;
    }

    public void setLost_amount(BigDecimal lost_amount) {
        this.lost_amount = lost_amount;
    }
}
