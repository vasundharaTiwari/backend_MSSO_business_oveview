package com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification;

import java.math.BigDecimal;
import java.util.Date;

public class SectorwiseNpaDto {
    private Date report_date;
    private BigDecimal total_os_amt;
    private Long total_housing;
    private BigDecimal housing_amt ;
    private Long total_natl;
    private BigDecimal natl_amt;
    private Long total_shg;
    private BigDecimal shg_amt;
    private Long kcc_atl;
    private BigDecimal kcc_atl_amt;
    private Long other;
    private BigDecimal other_amt;
    private Long nacc;
    private BigDecimal nacc_amt;

    public SectorwiseNpaDto(Date report_date, BigDecimal total_os_amt, Long total_housing, BigDecimal housing_amt, Long total_natl, BigDecimal natl_amt, Long total_shg, BigDecimal shg_amt, Long kcc_atl, BigDecimal kcc_atl_amt, Long other, BigDecimal other_amt, Long nacc, BigDecimal nacc_amt) {
        this.report_date = report_date;
        this.total_os_amt = total_os_amt;
        this.total_housing = total_housing;
        this.housing_amt = housing_amt;
        this.total_natl = total_natl;
        this.natl_amt = natl_amt;
        this.total_shg = total_shg;
        this.shg_amt = shg_amt;
        this.kcc_atl = kcc_atl;
        this.kcc_atl_amt = kcc_atl_amt;
        this.other = other;
        this.other_amt = other_amt;
        this.nacc = nacc;
        this.nacc_amt = nacc_amt;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public BigDecimal getTotal_os_amt() {
        return total_os_amt;
    }

    public void setTotal_os_amt(BigDecimal total_os_amt) {
        this.total_os_amt = total_os_amt;
    }

    public Long getTotal_housing() {
        return total_housing;
    }

    public void setTotal_housing(Long total_housing) {
        this.total_housing = total_housing;
    }

    public BigDecimal getHousing_amt() {
        return housing_amt;
    }

    public void setHousing_amt(BigDecimal housing_amt) {
        this.housing_amt = housing_amt;
    }

    public Long getTotal_natl() {
        return total_natl;
    }

    public void setTotal_natl(Long total_natl) {
        this.total_natl = total_natl;
    }

    public BigDecimal getNatl_amt() {
        return natl_amt;
    }

    public void setNatl_amt(BigDecimal natl_amt) {
        this.natl_amt = natl_amt;
    }

    public Long getTotal_shg() {
        return total_shg;
    }

    public void setTotal_shg(Long total_shg) {
        this.total_shg = total_shg;
    }

    public BigDecimal getShg_amt() {
        return shg_amt;
    }

    public void setShg_amt(BigDecimal shg_amt) {
        this.shg_amt = shg_amt;
    }

    public Long getKcc_atl() {
        return kcc_atl;
    }

    public void setKcc_atl(Long kcc_atl) {
        this.kcc_atl = kcc_atl;
    }

    public BigDecimal getKcc_atl_amt() {
        return kcc_atl_amt;
    }

    public void setKcc_atl_amt(BigDecimal kcc_atl_amt) {
        this.kcc_atl_amt = kcc_atl_amt;
    }

    public Long getOther() {
        return other;
    }

    public void setOther(Long other) {
        this.other = other;
    }

    public BigDecimal getOther_amt() {
        return other_amt;
    }

    public void setOther_amt(BigDecimal other_amt) {
        this.other_amt = other_amt;
    }

    public Long getNacc() {
        return nacc;
    }

    public void setNacc(Long nacc) {
        this.nacc = nacc;
    }

    public BigDecimal getNacc_amt() {
        return nacc_amt;
    }

    public void setNacc_amt(BigDecimal nacc_amt) {
        this.nacc_amt = nacc_amt;
    }
}
