package com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification;

import java.math.BigDecimal;
import java.util.Date;

public class AmountwiseNpaDto {
    private Date report_date;
    private Long total_count;
    private BigDecimal total_os_amt;
    private Long count_below_1lakh;
    private BigDecimal below_1lakh_amt ;
    private Long count_below_3lakh;
    private BigDecimal below_3lakh_amt;
    private Long count_below_24lakh;
    private BigDecimal below_24lakh_amt;
    private Long count_above_25lakh;
    private BigDecimal above_25lakh_amt;

    public AmountwiseNpaDto(Date report_date, Long total_count, BigDecimal total_os_amt, Long count_below_1lakh, BigDecimal below_1lakh_amt, Long count_below_3lakh, BigDecimal below_3lakh_amt, Long count_below_24lakh, BigDecimal below_24lakh_amt, Long count_above_25lakh, BigDecimal above_25lakh_amt) {
        this.report_date = report_date;
        this.total_count = total_count;
        this.total_os_amt = total_os_amt;
        this.count_below_1lakh = count_below_1lakh;
        this.below_1lakh_amt = below_1lakh_amt;
        this.count_below_3lakh = count_below_3lakh;
        this.below_3lakh_amt = below_3lakh_amt;
        this.count_below_24lakh = count_below_24lakh;
        this.below_24lakh_amt = below_24lakh_amt;
        this.count_above_25lakh = count_above_25lakh;
        this.above_25lakh_amt = above_25lakh_amt;
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

    public BigDecimal getTotal_os_amt() {
        return total_os_amt;
    }

    public void setTotal_os_amt(BigDecimal total_os_amt) {
        this.total_os_amt = total_os_amt;
    }

    public Long getCount_below_1lakh() {
        return count_below_1lakh;
    }

    public void setCount_below_1lakh(Long count_below_1lakh) {
        this.count_below_1lakh = count_below_1lakh;
    }

    public BigDecimal getBelow_1lakh_amt() {
        return below_1lakh_amt;
    }

    public void setBelow_1lakh_amt(BigDecimal below_1lakh_amt) {
        this.below_1lakh_amt = below_1lakh_amt;
    }

    public Long getCount_below_3lakh() {
        return count_below_3lakh;
    }

    public void setCount_below_3lakh(Long count_below_3lakh) {
        this.count_below_3lakh = count_below_3lakh;
    }

    public BigDecimal getBelow_3lakh_amt() {
        return below_3lakh_amt;
    }

    public void setBelow_3lakh_amt(BigDecimal below_3lakh_amt) {
        this.below_3lakh_amt = below_3lakh_amt;
    }

    public Long getCount_below_24lakh() {
        return count_below_24lakh;
    }

    public void setCount_below_24lakh(Long count_below_24lakh) {
        this.count_below_24lakh = count_below_24lakh;
    }

    public BigDecimal getBelow_24lakh_amt() {
        return below_24lakh_amt;
    }

    public void setBelow_24lakh_amt(BigDecimal below_24lakh_amt) {
        this.below_24lakh_amt = below_24lakh_amt;
    }

    public Long getCount_above_25lakh() {
        return count_above_25lakh;
    }

    public void setCount_above_25lakh(Long count_above_25lakh) {
        this.count_above_25lakh = count_above_25lakh;
    }

    public BigDecimal getAbove_25lakh_amt() {
        return above_25lakh_amt;
    }

    public void setAbove_25lakh_amt(BigDecimal above_25lakh_amt) {
        this.above_25lakh_amt = above_25lakh_amt;
    }
}
