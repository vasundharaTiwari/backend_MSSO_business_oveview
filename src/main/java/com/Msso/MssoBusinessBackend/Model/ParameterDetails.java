package com.Msso.MssoBusinessBackend.Model;

import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileTargetDataDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class ParameterDetails {


    private String parameter;

    public ParameterDetails(String parameter, BigDecimal year1, BigDecimal year2, BigDecimal year3, BigDecimal currentDate, BigDecimal quarterTarget, BigDecimal gapTarget, BigDecimal ytdGrowthAmount, BigDecimal ytdGrowthAmountPer, BigDecimal targetYear, BigDecimal targetYearSuperAchiever) {
        this.parameter = parameter;
        this.year1 = year1;
        this.year2 = year2;
        this.year3 = year3;
        this.currentDate = currentDate;
        this.quarterTarget = quarterTarget;
        this.gapTarget = gapTarget;
        this.ytdGrowthAmount = ytdGrowthAmount;
        this.ytdGrowthAmountPer = ytdGrowthAmountPer;
        this.targetYear = targetYear;
        this.targetYearSuperAchiever = targetYearSuperAchiever;
    }

    private BigDecimal year1;
       private BigDecimal year2;
    private BigDecimal year3;
    private BigDecimal currentDate;

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public BigDecimal getYear1() {
        return year1;
    }

    public void setYear1(BigDecimal year1) {
        this.year1 = year1;
    }

    public BigDecimal getYear2() {
        return year2;
    }

    public void setYear2(BigDecimal year2) {
        this.year2 = year2;
    }

    public BigDecimal getYear3() {
        return year3;
    }

    public void setYear3(BigDecimal year3) {
        this.year3 = year3;
    }

    public BigDecimal getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(BigDecimal currentDate) {
        this.currentDate = currentDate;
    }

    public BigDecimal getQuarterTarget() {
        return quarterTarget;
    }

    public void setQuarterTarget(BigDecimal quarterTarget) {
        this.quarterTarget = quarterTarget;
    }

    public BigDecimal getGapTarget() {
        return gapTarget;
    }

    public void setGapTarget(BigDecimal gapTarget) {
        this.gapTarget = gapTarget;
    }

    public BigDecimal getYtdGrowthAmount() {
        return ytdGrowthAmount;
    }

    public void setYtdGrowthAmount(BigDecimal ytdGrowthAmount) {
        this.ytdGrowthAmount = ytdGrowthAmount;
    }

    public BigDecimal getYtdGrowthAmountPer() {
        return ytdGrowthAmountPer;
    }

    public void setYtdGrowthAmountPer(BigDecimal ytdGrowthAmountPer) {
        this.ytdGrowthAmountPer = ytdGrowthAmountPer;
    }

    public BigDecimal getTargetYear() {
        return targetYear;
    }

    public void setTargetYear(BigDecimal targetYear) {
        this.targetYear = targetYear;
    }

    public BigDecimal getTargetYearSuperAchiever() {
        return targetYearSuperAchiever;
    }

    public void setTargetYearSuperAchiever(BigDecimal targetYearSuperAchiever) {
        this.targetYearSuperAchiever = targetYearSuperAchiever;
    }

    private BigDecimal quarterTarget;
    private BigDecimal gapTarget;
    private BigDecimal ytdGrowthAmount;
    private BigDecimal ytdGrowthAmountPer;
    private BigDecimal targetYear;
    private BigDecimal targetYearSuperAchiever;

}
