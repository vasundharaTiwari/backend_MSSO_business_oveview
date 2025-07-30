package com.Msso.MssoBusinessBackend.Model.MssoBranchProfileDisbursement;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data

public class MssoProfileDailyDisburseDto {
    private Date report_date;
    private BigDecimal total_advances;
    private BigDecimal total_os;
    private Long total_count;
    private BigDecimal retail;
    private Long retail_count;
    private BigDecimal housing;
    private Long housing_count;
    private BigDecimal vehicle;
    private Long vehicle_count;
    private BigDecimal education;
    private Long education_count;
    private BigDecimal agriculture;
    private Long agriculture_count;
    private BigDecimal msme;
    private Long msme_count;
    private BigDecimal gold;
    private Long gold_count;
    private BigDecimal shg;
    private Long shg_count;
    private BigDecimal  pm_suryaghar ;
    private Long pm_suryaghar_count ;
    private BigDecimal  pmvishvakarma;
    private Long pmvishvakarma_count;

    public MssoProfileDailyDisburseDto(Date report_date, BigDecimal total_advances, BigDecimal total_os, Long total_count, BigDecimal retail, Long retail_count, BigDecimal housing, Long housing_count, BigDecimal vehicle, Long vehicle_count, BigDecimal education, Long education_count, BigDecimal agriculture, Long agriculture_count, BigDecimal msme, Long msme_count, BigDecimal gold, Long gold_count, BigDecimal shg, Long shg_count, BigDecimal pm_suryaghar, Long pm_suryaghar_count, BigDecimal pmvishvakarma, Long pmvishvakarma_count) {
        this.report_date = report_date;
        this.total_advances = total_advances;
        this.total_os = total_os;
        this.total_count = total_count;
        this.retail = retail;
        this.retail_count = retail_count;
        this.housing = housing;
        this.housing_count = housing_count;
        this.vehicle = vehicle;
        this.vehicle_count = vehicle_count;
        this.education = education;
        this.education_count = education_count;
        this.agriculture = agriculture;
        this.agriculture_count = agriculture_count;
        this.msme = msme;
        this.msme_count = msme_count;
        this.gold = gold;
        this.gold_count = gold_count;
        this.shg = shg;
        this.shg_count = shg_count;
        this.pm_suryaghar = pm_suryaghar;
        this.pm_suryaghar_count = pm_suryaghar_count;
        this.pmvishvakarma = pmvishvakarma;
        this.pmvishvakarma_count = pmvishvakarma_count;
    }

    public BigDecimal getPm_suryaghar() {
        return pm_suryaghar;
    }

    public void setPm_suryaghar(BigDecimal pm_suryaghar) {
        this.pm_suryaghar = pm_suryaghar;
    }

    public Long getPm_suryaghar_count() {
        return pm_suryaghar_count;
    }

    public void setPm_suryaghar_count(Long pm_suryaghar_count) {
        this.pm_suryaghar_count = pm_suryaghar_count;
    }

    public BigDecimal getPmvishvakarma() {
        return pmvishvakarma;
    }

    public void setPmvishvakarma(BigDecimal pmvishvakarma) {
        this.pmvishvakarma = pmvishvakarma;
    }

    public Long getPmvishvakarma_count() {
        return pmvishvakarma_count;
    }

    public void setPmvishvakarma_count(Long pmvishvakarma_count) {
        this.pmvishvakarma_count = pmvishvakarma_count;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public BigDecimal getTotal_advances() {
        return total_advances;
    }

    public void setTotal_advances(BigDecimal total_advances) {
        this.total_advances = total_advances;
    }

    public BigDecimal getTotal_os() {
        return total_os;
    }

    public void setTotal_os(BigDecimal total_os) {
        this.total_os = total_os;
    }

    public Long getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Long total_count) {
        this.total_count = total_count;
    }

    public BigDecimal getRetail() {
        return retail;
    }

    public void setRetail(BigDecimal retail) {
        this.retail = retail;
    }

    public Long getRetail_count() {
        return retail_count;
    }

    public void setRetail_count(Long retail_count) {
        this.retail_count = retail_count;
    }

    public BigDecimal getHousing() {
        return housing;
    }

    public void setHousing(BigDecimal housing) {
        this.housing = housing;
    }

    public Long getHousing_count() {
        return housing_count;
    }

    public void setHousing_count(Long housing_count) {
        this.housing_count = housing_count;
    }

    public BigDecimal getVehicle() {
        return vehicle;
    }

    public void setVehicle(BigDecimal vehicle) {
        this.vehicle = vehicle;
    }

    public Long getVehicle_count() {
        return vehicle_count;
    }

    public void setVehicle_count(Long vehicle_count) {
        this.vehicle_count = vehicle_count;
    }

    public BigDecimal getEducation() {
        return education;
    }

    public void setEducation(BigDecimal education) {
        this.education = education;
    }

    public Long getEducation_count() {
        return education_count;
    }

    public void setEducation_count(Long education_count) {
        this.education_count = education_count;
    }

    public BigDecimal getAgriculture() {
        return agriculture;
    }

    public void setAgriculture(BigDecimal agriculture) {
        this.agriculture = agriculture;
    }

    public Long getAgriculture_count() {
        return agriculture_count;
    }

    public void setAgriculture_count(Long agriculture_count) {
        this.agriculture_count = agriculture_count;
    }

    public BigDecimal getMsme() {
        return msme;
    }

    public void setMsme(BigDecimal msme) {
        this.msme = msme;
    }

    public Long getMsme_count() {
        return msme_count;
    }

    public void setMsme_count(Long msme_count) {
        this.msme_count = msme_count;
    }

    public BigDecimal getGold() {
        return gold;
    }

    public void setGold(BigDecimal gold) {
        this.gold = gold;
    }

    public Long getGold_count() {
        return gold_count;
    }

    public void setGold_count(Long gold_count) {
        this.gold_count = gold_count;
    }

    public BigDecimal getShg() {
        return shg;
    }

    public void setShg(BigDecimal shg) {
        this.shg = shg;
    }

    public Long getShg_count() {
        return shg_count;
    }

    public void setShg_count(Long shg_count) {
        this.shg_count = shg_count;
    }



    public MssoProfileDailyDisburseDto() {
    }
}
