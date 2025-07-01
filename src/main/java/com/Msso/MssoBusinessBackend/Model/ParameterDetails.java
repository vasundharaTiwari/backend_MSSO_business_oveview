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
    public ParameterDetails(String parameter, BigDecimal year1, BigDecimal year2, BigDecimal year3, BigDecimal currentDate, BigDecimal quarterTarget, BigDecimal ytdGrowthAmount, BigDecimal gapTarget, BigDecimal ytdGrowthAmountPer, BigDecimal targetYear, BigDecimal targetYearSuperAchiever) {
        this.parameter = parameter;
        this.year1 = year1;
        this.year2 = year2;
        this.year3 = year3;
        this.currentDate = currentDate;
        this.quarterTarget = quarterTarget;
        this.ytdGrowthAmount = ytdGrowthAmount;
        this.gapTarget = gapTarget;
        this.ytdGrowthAmountPer = ytdGrowthAmountPer;
        this.targetYear = targetYear;
        this.targetYearSuperAchiever = targetYearSuperAchiever;
    }

    private String parameter;
    private BigDecimal year1;

    public String getParameter() {
        return parameter;
    }

    public BigDecimal getYear1() {
        return year1;
    }

    public BigDecimal getYear2() {
        return year2;
    }

    public BigDecimal getYear3() {
        return year3;
    }

    public BigDecimal getCurrentDate() {
        return currentDate;
    }

    public BigDecimal getQuarterTarget() {
        return quarterTarget;
    }

    public BigDecimal getYtdGrowthAmount() {
        return ytdGrowthAmount;
    }

    public BigDecimal getGapTarget() {
        return gapTarget;
    }

    public BigDecimal getYtdGrowthAmountPer() {
        return ytdGrowthAmountPer;
    }

    public BigDecimal getTargetYear() {
        return targetYear;
    }

    public BigDecimal getTargetYearSuperAchiever() {
        return targetYearSuperAchiever;
    }

    private BigDecimal year2;
    private BigDecimal year3;
    private BigDecimal currentDate;
    private BigDecimal quarterTarget;
    private BigDecimal ytdGrowthAmount;
    private BigDecimal gapTarget;
    private BigDecimal ytdGrowthAmountPer;
    private BigDecimal targetYear;
    private BigDecimal targetYearSuperAchiever;

}
