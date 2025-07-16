package com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "msso_profile_visit_report", schema = "msso_branch_profile")
public class ExecutiveVisitingData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public LocalDate getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(LocalDate visit_date) {
        this.visit_date = visit_date;
    }

    public String getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public BigDecimal getSb() {
        return sb;
    }

    public void setSb(BigDecimal sb) {
        this.sb = sb;
    }

    public BigDecimal getCa() {
        return ca;
    }

    public void setCa(BigDecimal ca) {
        this.ca = ca;
    }

    public BigDecimal getTd() {
        return td;
    }

    public void setTd(BigDecimal td) {
        this.td = td;
    }

    public BigDecimal getCasa() {
        return casa;
    }

    public void setCasa(BigDecimal casa) {
        this.casa = casa;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getAdvances() {
        return advances;
    }

    public void setAdvances(BigDecimal advances) {
        this.advances = advances;
    }

    public BigDecimal getTotal_business() {
        return total_business;
    }

    public void setTotal_business(BigDecimal total_business) {
        this.total_business = total_business;
    }

    public BigDecimal getTotal_retail() {
        return total_retail;
    }

    public void setTotal_retail(BigDecimal total_retail) {
        this.total_retail = total_retail;
    }

    public BigDecimal getHousing() {
        return housing;
    }

    public void setHousing(BigDecimal housing) {
        this.housing = housing;
    }

    public BigDecimal getVehicle() {
        return vehicle;
    }

    public void setVehicle(BigDecimal vehicle) {
        this.vehicle = vehicle;
    }

    public BigDecimal getEducation() {
        return education;
    }

    public void setEducation(BigDecimal education) {
        this.education = education;
    }

    public BigDecimal getAgri() {
        return agri;
    }

    public void setAgri(BigDecimal agri) {
        this.agri = agri;
    }

    public BigDecimal getMsme() {
        return msme;
    }

    public void setMsme(BigDecimal msme) {
        this.msme = msme;
    }

    public BigDecimal getGold() {
        return gold;
    }

    public void setGold(BigDecimal gold) {
        this.gold = gold;
    }

    public BigDecimal getShg() {
        return shg;
    }

    public void setShg(BigDecimal shg) {
        this.shg = shg;
    }

    public BigDecimal getTotal_ram() {
        return total_ram;
    }

    public void setTotal_ram(BigDecimal total_ram) {
        this.total_ram = total_ram;
    }

    public BigDecimal getNpa() {
        return npa;
    }

    public void setNpa(BigDecimal npa) {
        this.npa = npa;
    }

    public Date getReport_dateMarch1() {
        return report_dateMarch1;
    }

    public void setReport_dateMarch1(Date report_dateMarch1) {
        this.report_dateMarch1 = report_dateMarch1;
    }

    public BigDecimal getSbMarch1() {
        return sbMarch1;
    }

    public void setSbMarch1(BigDecimal sbMarch1) {
        this.sbMarch1 = sbMarch1;
    }

    public BigDecimal getCaMarch1() {
        return caMarch1;
    }

    public void setCaMarch1(BigDecimal caMarch1) {
        this.caMarch1 = caMarch1;
    }

    public BigDecimal getTdMarch1() {
        return tdMarch1;
    }

    public void setTdMarch1(BigDecimal tdMarch1) {
        this.tdMarch1 = tdMarch1;
    }

    public BigDecimal getCasaMarch1() {
        return casaMarch1;
    }

    public void setCasaMarch1(BigDecimal casaMarch1) {
        this.casaMarch1 = casaMarch1;
    }

    public BigDecimal getDepositMarch1() {
        return depositMarch1;
    }

    public void setDepositMarch1(BigDecimal depositMarch1) {
        this.depositMarch1 = depositMarch1;
    }

    public BigDecimal getAdvancesMarch1() {
        return advancesMarch1;
    }

    public void setAdvancesMarch1(BigDecimal advancesMarch1) {
        this.advancesMarch1 = advancesMarch1;
    }

    public BigDecimal getTotal_businessMarch1() {
        return total_businessMarch1;
    }

    public void setTotal_businessMarch1(BigDecimal total_businessMarch1) {
        this.total_businessMarch1 = total_businessMarch1;
    }

    public BigDecimal getTotal_retailMarch1() {
        return total_retailMarch1;
    }

    public void setTotal_retailMarch1(BigDecimal total_retailMarch1) {
        this.total_retailMarch1 = total_retailMarch1;
    }

    public BigDecimal getHousingMarch1() {
        return housingMarch1;
    }

    public void setHousingMarch1(BigDecimal housingMarch1) {
        this.housingMarch1 = housingMarch1;
    }

    public BigDecimal getVehicleMarch1() {
        return vehicleMarch1;
    }

    public void setVehicleMarch1(BigDecimal vehicleMarch1) {
        this.vehicleMarch1 = vehicleMarch1;
    }

    public BigDecimal getEducationMarch1() {
        return educationMarch1;
    }

    public void setEducationMarch1(BigDecimal educationMarch1) {
        this.educationMarch1 = educationMarch1;
    }

    public BigDecimal getAgriMarch1() {
        return agriMarch1;
    }

    public void setAgriMarch1(BigDecimal agriMarch1) {
        this.agriMarch1 = agriMarch1;
    }

    public BigDecimal getMsmeMarch1() {
        return msmeMarch1;
    }

    public void setMsmeMarch1(BigDecimal msmeMarch1) {
        this.msmeMarch1 = msmeMarch1;
    }

    public BigDecimal getGoldMarch1() {
        return goldMarch1;
    }

    public void setGoldMarch1(BigDecimal goldMarch1) {
        this.goldMarch1 = goldMarch1;
    }

    public BigDecimal getShgMarch1() {
        return shgMarch1;
    }

    public void setShgMarch1(BigDecimal shgMarch1) {
        this.shgMarch1 = shgMarch1;
    }

    public BigDecimal getTotal_ramMarch1() {
        return total_ramMarch1;
    }

    public void setTotal_ramMarch1(BigDecimal total_ramMarch1) {
        this.total_ramMarch1 = total_ramMarch1;
    }

    public BigDecimal getNpaMarch1() {
        return npaMarch1;
    }

    public void setNpaMarch1(BigDecimal npaMarch1) {
        this.npaMarch1 = npaMarch1;
    }

    public Date getReport_dateMarch2() {
        return report_dateMarch2;
    }

    public void setReport_dateMarch2(Date report_dateMarch2) {
        this.report_dateMarch2 = report_dateMarch2;
    }

    public BigDecimal getSbMarch2() {
        return sbMarch2;
    }

    public void setSbMarch2(BigDecimal sbMarch2) {
        this.sbMarch2 = sbMarch2;
    }

    public BigDecimal getCaMarch2() {
        return caMarch2;
    }

    public void setCaMarch2(BigDecimal caMarch2) {
        this.caMarch2 = caMarch2;
    }

    public BigDecimal getTdMarch2() {
        return tdMarch2;
    }

    public void setTdMarch2(BigDecimal tdMarch2) {
        this.tdMarch2 = tdMarch2;
    }

    public BigDecimal getCasaMarch2() {
        return casaMarch2;
    }

    public void setCasaMarch2(BigDecimal casaMarch2) {
        this.casaMarch2 = casaMarch2;
    }

    public BigDecimal getDepositMarch2() {
        return depositMarch2;
    }

    public void setDepositMarch2(BigDecimal depositMarch2) {
        this.depositMarch2 = depositMarch2;
    }

    public BigDecimal getAdvancesMarch2() {
        return advancesMarch2;
    }

    public void setAdvancesMarch2(BigDecimal advancesMarch2) {
        this.advancesMarch2 = advancesMarch2;
    }

    public BigDecimal getTotal_businessMarch2() {
        return total_businessMarch2;
    }

    public void setTotal_businessMarch2(BigDecimal total_businessMarch2) {
        this.total_businessMarch2 = total_businessMarch2;
    }

    public BigDecimal getTotal_retailMarch2() {
        return total_retailMarch2;
    }

    public void setTotal_retailMarch2(BigDecimal total_retailMarch2) {
        this.total_retailMarch2 = total_retailMarch2;
    }

    public BigDecimal getHousingMarch2() {
        return housingMarch2;
    }

    public void setHousingMarch2(BigDecimal housingMarch2) {
        this.housingMarch2 = housingMarch2;
    }

    public BigDecimal getVehicleMarch2() {
        return vehicleMarch2;
    }

    public void setVehicleMarch2(BigDecimal vehicleMarch2) {
        this.vehicleMarch2 = vehicleMarch2;
    }

    public BigDecimal getEducationMarch2() {
        return educationMarch2;
    }

    public void setEducationMarch2(BigDecimal educationMarch2) {
        this.educationMarch2 = educationMarch2;
    }

    public BigDecimal getAgriMarch2() {
        return agriMarch2;
    }

    public void setAgriMarch2(BigDecimal agriMarch2) {
        this.agriMarch2 = agriMarch2;
    }

    public BigDecimal getMsmeMarch2() {
        return msmeMarch2;
    }

    public void setMsmeMarch2(BigDecimal msmeMarch2) {
        this.msmeMarch2 = msmeMarch2;
    }

    public BigDecimal getGoldMarch2() {
        return goldMarch2;
    }

    public void setGoldMarch2(BigDecimal goldMarch2) {
        this.goldMarch2 = goldMarch2;
    }

    public BigDecimal getShgMarch2() {
        return shgMarch2;
    }

    public void setShgMarch2(BigDecimal shgMarch2) {
        this.shgMarch2 = shgMarch2;
    }

    public BigDecimal getTotal_ramMarch2() {
        return total_ramMarch2;
    }

    public void setTotal_ramMarch2(BigDecimal total_ramMarch2) {
        this.total_ramMarch2 = total_ramMarch2;
    }

    public BigDecimal getNpaMarch2() {
        return npaMarch2;
    }

    public void setNpaMarch2(BigDecimal npaMarch2) {
        this.npaMarch2 = npaMarch2;
    }

    public Date getReport_dateMarch3() {
        return report_dateMarch3;
    }

    public void setReport_dateMarch3(Date report_dateMarch3) {
        this.report_dateMarch3 = report_dateMarch3;
    }

    public BigDecimal getSbMarch3() {
        return sbMarch3;
    }

    public void setSbMarch3(BigDecimal sbMarch3) {
        this.sbMarch3 = sbMarch3;
    }

    public BigDecimal getCaMarch3() {
        return caMarch3;
    }

    public void setCaMarch3(BigDecimal caMarch3) {
        this.caMarch3 = caMarch3;
    }

    public BigDecimal getTdMarch3() {
        return tdMarch3;
    }

    public void setTdMarch3(BigDecimal tdMarch3) {
        this.tdMarch3 = tdMarch3;
    }

    public BigDecimal getCasaMarch3() {
        return casaMarch3;
    }

    public void setCasaMarch3(BigDecimal casaMarch3) {
        this.casaMarch3 = casaMarch3;
    }

    public BigDecimal getDepositMarch3() {
        return depositMarch3;
    }

    public void setDepositMarch3(BigDecimal depositMarch3) {
        this.depositMarch3 = depositMarch3;
    }

    public BigDecimal getAdvancesMarch3() {
        return advancesMarch3;
    }

    public void setAdvancesMarch3(BigDecimal advancesMarch3) {
        this.advancesMarch3 = advancesMarch3;
    }

    public BigDecimal getTotal_businessMarch3() {
        return total_businessMarch3;
    }

    public void setTotal_businessMarch3(BigDecimal total_businessMarch3) {
        this.total_businessMarch3 = total_businessMarch3;
    }

    public BigDecimal getTotal_retailMarch3() {
        return total_retailMarch3;
    }

    public void setTotal_retailMarch3(BigDecimal total_retailMarch3) {
        this.total_retailMarch3 = total_retailMarch3;
    }

    public BigDecimal getHousingMarch3() {
        return housingMarch3;
    }

    public void setHousingMarch3(BigDecimal housingMarch3) {
        this.housingMarch3 = housingMarch3;
    }

    public BigDecimal getVehicleMarch3() {
        return vehicleMarch3;
    }

    public void setVehicleMarch3(BigDecimal vehicleMarch3) {
        this.vehicleMarch3 = vehicleMarch3;
    }

    public BigDecimal getEducationMarch3() {
        return educationMarch3;
    }

    public void setEducationMarch3(BigDecimal educationMarch3) {
        this.educationMarch3 = educationMarch3;
    }

    public BigDecimal getAgriMarch3() {
        return agriMarch3;
    }

    public void setAgriMarch3(BigDecimal agriMarch3) {
        this.agriMarch3 = agriMarch3;
    }

    public BigDecimal getMsmeMarch3() {
        return msmeMarch3;
    }

    public void setMsmeMarch3(BigDecimal msmeMarch3) {
        this.msmeMarch3 = msmeMarch3;
    }

    public BigDecimal getGoldMarch3() {
        return goldMarch3;
    }

    public void setGoldMarch3(BigDecimal goldMarch3) {
        this.goldMarch3 = goldMarch3;
    }

    public BigDecimal getShgMarch3() {
        return shgMarch3;
    }

    public void setShgMarch3(BigDecimal shgMarch3) {
        this.shgMarch3 = shgMarch3;
    }

    public BigDecimal getTotal_ramMarch3() {
        return total_ramMarch3;
    }

    public void setTotal_ramMarch3(BigDecimal total_ramMarch3) {
        this.total_ramMarch3 = total_ramMarch3;
    }

    public BigDecimal getNpaMarch3() {
        return npaMarch3;
    }

    public void setNpaMarch3(BigDecimal npaMarch3) {
        this.npaMarch3 = npaMarch3;
    }

    public Date getReport_dateTarget() {
        return report_dateTarget;
    }

    public void setReport_dateTarget(Date report_dateTarget) {
        this.report_dateTarget = report_dateTarget;
    }

    public BigDecimal getSbTarget() {
        return sbTarget;
    }

    public void setSbTarget(BigDecimal sbTarget) {
        this.sbTarget = sbTarget;
    }

    public BigDecimal getCaTarget() {
        return caTarget;
    }

    public void setCaTarget(BigDecimal caTarget) {
        this.caTarget = caTarget;
    }

    public BigDecimal getTdTarget() {
        return tdTarget;
    }

    public void setTdTarget(BigDecimal tdTarget) {
        this.tdTarget = tdTarget;
    }

    public BigDecimal getCasaTarget() {
        return casaTarget;
    }

    public void setCasaTarget(BigDecimal casaTarget) {
        this.casaTarget = casaTarget;
    }

    public BigDecimal getDepositTarget() {
        return depositTarget;
    }

    public void setDepositTarget(BigDecimal depositTarget) {
        this.depositTarget = depositTarget;
    }

    public BigDecimal getAdvancesTarget() {
        return advancesTarget;
    }

    public void setAdvancesTarget(BigDecimal advancesTarget) {
        this.advancesTarget = advancesTarget;
    }

    public BigDecimal getTotal_businessTarget() {
        return total_businessTarget;
    }

    public void setTotal_businessTarget(BigDecimal total_businessTarget) {
        this.total_businessTarget = total_businessTarget;
    }

    public BigDecimal getTotal_retailTarget() {
        return total_retailTarget;
    }

    public void setTotal_retailTarget(BigDecimal total_retailTarget) {
        this.total_retailTarget = total_retailTarget;
    }

    public BigDecimal getHousingTarget() {
        return housingTarget;
    }

    public void setHousingTarget(BigDecimal housingTarget) {
        this.housingTarget = housingTarget;
    }

    public BigDecimal getVehicleTarget() {
        return vehicleTarget;
    }

    public void setVehicleTarget(BigDecimal vehicleTarget) {
        this.vehicleTarget = vehicleTarget;
    }

    public BigDecimal getEducationTarget() {
        return educationTarget;
    }

    public void setEducationTarget(BigDecimal educationTarget) {
        this.educationTarget = educationTarget;
    }

    public BigDecimal getAgriTarget() {
        return agriTarget;
    }

    public void setAgriTarget(BigDecimal agriTarget) {
        this.agriTarget = agriTarget;
    }

    public BigDecimal getMsmeTarget() {
        return msmeTarget;
    }

    public void setMsmeTarget(BigDecimal msmeTarget) {
        this.msmeTarget = msmeTarget;
    }

    public BigDecimal getGoldTarget() {
        return goldTarget;
    }

    public void setGoldTarget(BigDecimal goldTarget) {
        this.goldTarget = goldTarget;
    }

    public BigDecimal getShgTarget() {
        return shgTarget;
    }

    public void setShgTarget(BigDecimal shgTarget) {
        this.shgTarget = shgTarget;
    }

    public BigDecimal getTotal_ramTarget() {
        return total_ramTarget;
    }

    public void setTotal_ramTarget(BigDecimal total_ramTarget) {
        this.total_ramTarget = total_ramTarget;
    }

    public BigDecimal getNpaTarget() {
        return npaTarget;
    }

    public void setNpaTarget(BigDecimal npaTarget) {
        this.npaTarget = npaTarget;
    }

    public Date getReport_dateTargetgap() {
        return report_dateTargetgap;
    }

    public void setReport_dateTargetgap(Date report_dateTargetgap) {
        this.report_dateTargetgap = report_dateTargetgap;
    }

    public BigDecimal getSbTargetgap() {
        return sbTargetgap;
    }

    public void setSbTargetgap(BigDecimal sbTargetgap) {
        this.sbTargetgap = sbTargetgap;
    }

    public BigDecimal getCaTargetgap() {
        return caTargetgap;
    }

    public void setCaTargetgap(BigDecimal caTargetgap) {
        this.caTargetgap = caTargetgap;
    }

    public BigDecimal getTdTargetgap() {
        return tdTargetgap;
    }

    public void setTdTargetgap(BigDecimal tdTargetgap) {
        this.tdTargetgap = tdTargetgap;
    }

    public BigDecimal getCasaTargetgap() {
        return casaTargetgap;
    }

    public void setCasaTargetgap(BigDecimal casaTargetgap) {
        this.casaTargetgap = casaTargetgap;
    }

    public BigDecimal getDepositTargetgap() {
        return depositTargetgap;
    }

    public void setDepositTargetgap(BigDecimal depositTargetgap) {
        this.depositTargetgap = depositTargetgap;
    }

    public BigDecimal getAdvancesTargetgap() {
        return advancesTargetgap;
    }

    public void setAdvancesTargetgap(BigDecimal advancesTargetgap) {
        this.advancesTargetgap = advancesTargetgap;
    }

    public BigDecimal getTotal_businessTargetgap() {
        return total_businessTargetgap;
    }

    public void setTotal_businessTargetgap(BigDecimal total_businessTargetgap) {
        this.total_businessTargetgap = total_businessTargetgap;
    }

    public BigDecimal getTotal_retailTargetgap() {
        return total_retailTargetgap;
    }

    public void setTotal_retailTargetgap(BigDecimal total_retailTargetgap) {
        this.total_retailTargetgap = total_retailTargetgap;
    }

    public BigDecimal getHousingTargetgap() {
        return housingTargetgap;
    }

    public void setHousingTargetgap(BigDecimal housingTargetgap) {
        this.housingTargetgap = housingTargetgap;
    }

    public BigDecimal getVehicleTargetgap() {
        return vehicleTargetgap;
    }

    public void setVehicleTargetgap(BigDecimal vehicleTargetgap) {
        this.vehicleTargetgap = vehicleTargetgap;
    }

    public BigDecimal getEducationTargetgap() {
        return educationTargetgap;
    }

    public void setEducationTargetgap(BigDecimal educationTargetgap) {
        this.educationTargetgap = educationTargetgap;
    }

    public BigDecimal getAgriTargetgap() {
        return agriTargetgap;
    }

    public void setAgriTargetgap(BigDecimal agriTargetgap) {
        this.agriTargetgap = agriTargetgap;
    }

    public BigDecimal getMsmeTargetgap() {
        return msmeTargetgap;
    }

    public void setMsmeTargetgap(BigDecimal msmeTargetgap) {
        this.msmeTargetgap = msmeTargetgap;
    }

    public BigDecimal getGoldTargetgap() {
        return goldTargetgap;
    }

    public void setGoldTargetgap(BigDecimal goldTargetgap) {
        this.goldTargetgap = goldTargetgap;
    }

    public BigDecimal getShgTargetgap() {
        return shgTargetgap;
    }

    public void setShgTargetgap(BigDecimal shgTargetgap) {
        this.shgTargetgap = shgTargetgap;
    }

    public BigDecimal getTotal_ramTargetgap() {
        return total_ramTargetgap;
    }

    public void setTotal_ramTargetgap(BigDecimal total_ramTargetgap) {
        this.total_ramTargetgap = total_ramTargetgap;
    }

    public BigDecimal getNpaTargetgap() {
        return npaTargetgap;
    }

    public void setNpaTargetgap(BigDecimal npaTargetgap) {
        this.npaTargetgap = npaTargetgap;
    }

    public Date getReport_dateMarchGap() {
        return report_dateMarchGap;
    }

    public void setReport_dateMarchGap(Date report_dateMarchGap) {
        this.report_dateMarchGap = report_dateMarchGap;
    }

    public BigDecimal getSbMarchGap() {
        return sbMarchGap;
    }

    public void setSbMarchGap(BigDecimal sbMarchGap) {
        this.sbMarchGap = sbMarchGap;
    }

    public BigDecimal getCaMarchGap() {
        return caMarchGap;
    }

    public void setCaMarchGap(BigDecimal caMarchGap) {
        this.caMarchGap = caMarchGap;
    }

    public BigDecimal getTdMarchGap() {
        return tdMarchGap;
    }

    public void setTdMarchGap(BigDecimal tdMarchGap) {
        this.tdMarchGap = tdMarchGap;
    }

    public BigDecimal getCasaMarchGap() {
        return casaMarchGap;
    }

    public void setCasaMarchGap(BigDecimal casaMarchGap) {
        this.casaMarchGap = casaMarchGap;
    }

    public BigDecimal getDepositMarchGap() {
        return depositMarchGap;
    }

    public void setDepositMarchGap(BigDecimal depositMarchGap) {
        this.depositMarchGap = depositMarchGap;
    }

    public BigDecimal getAdvancesMarchGap() {
        return advancesMarchGap;
    }

    public void setAdvancesMarchGap(BigDecimal advancesMarchGap) {
        this.advancesMarchGap = advancesMarchGap;
    }

    public BigDecimal getTotal_businessMarchGap() {
        return total_businessMarchGap;
    }

    public void setTotal_businessMarchGap(BigDecimal total_businessMarchGap) {
        this.total_businessMarchGap = total_businessMarchGap;
    }

    public BigDecimal getTotal_retailMarchGap() {
        return total_retailMarchGap;
    }

    public void setTotal_retailMarchGap(BigDecimal total_retailMarchGap) {
        this.total_retailMarchGap = total_retailMarchGap;
    }

    public BigDecimal getHousingMarchGap() {
        return housingMarchGap;
    }

    public void setHousingMarchGap(BigDecimal housingMarchGap) {
        this.housingMarchGap = housingMarchGap;
    }

    public BigDecimal getVehicleMarchGap() {
        return vehicleMarchGap;
    }

    public void setVehicleMarchGap(BigDecimal vehicleMarchGap) {
        this.vehicleMarchGap = vehicleMarchGap;
    }

    public BigDecimal getEducationMarchGap() {
        return educationMarchGap;
    }

    public void setEducationMarchGap(BigDecimal educationMarchGap) {
        this.educationMarchGap = educationMarchGap;
    }

    public BigDecimal getAgriMarchGap() {
        return agriMarchGap;
    }

    public void setAgriMarchGap(BigDecimal agriMarchGap) {
        this.agriMarchGap = agriMarchGap;
    }

    public BigDecimal getMsmeMarchGap() {
        return msmeMarchGap;
    }

    public void setMsmeMarchGap(BigDecimal msmeMarchGap) {
        this.msmeMarchGap = msmeMarchGap;
    }

    public BigDecimal getGoldMarchGap() {
        return goldMarchGap;
    }

    public void setGoldMarchGap(BigDecimal goldMarchGap) {
        this.goldMarchGap = goldMarchGap;
    }

    public BigDecimal getShgMarchGap() {
        return shgMarchGap;
    }

    public void setShgMarchGap(BigDecimal shgMarchGap) {
        this.shgMarchGap = shgMarchGap;
    }

    public BigDecimal getTotal_ramMarchGap() {
        return total_ramMarchGap;
    }

    public void setTotal_ramMarchGap(BigDecimal total_ramMarchGap) {
        this.total_ramMarchGap = total_ramMarchGap;
    }

    public BigDecimal getNpaMarchGap() {
        return npaMarchGap;
    }

    public void setNpaMarchGap(BigDecimal npaMarchGap) {
        this.npaMarchGap = npaMarchGap;
    }

    public Date getReport_dateMarchPercent() {
        return report_dateMarchPercent;
    }

    public void setReport_dateMarchPercent(Date report_dateMarchPercent) {
        this.report_dateMarchPercent = report_dateMarchPercent;
    }

    public BigDecimal getSbMarchPercent() {
        return sbMarchPercent;
    }

    public void setSbMarchPercent(BigDecimal sbMarchPercent) {
        this.sbMarchPercent = sbMarchPercent;
    }

    public BigDecimal getCaMarchPercent() {
        return caMarchPercent;
    }

    public void setCaMarchPercent(BigDecimal caMarchPercent) {
        this.caMarchPercent = caMarchPercent;
    }

    public BigDecimal getTdMarchPercent() {
        return tdMarchPercent;
    }

    public void setTdMarchPercent(BigDecimal tdMarchPercent) {
        this.tdMarchPercent = tdMarchPercent;
    }

    public BigDecimal getCasaMarchPercent() {
        return casaMarchPercent;
    }

    public void setCasaMarchPercent(BigDecimal casaMarchPercent) {
        this.casaMarchPercent = casaMarchPercent;
    }

    public BigDecimal getDepositMarchPercent() {
        return depositMarchPercent;
    }

    public void setDepositMarchPercent(BigDecimal depositMarchPercent) {
        this.depositMarchPercent = depositMarchPercent;
    }

    public BigDecimal getAdvancesMarchPercent() {
        return advancesMarchPercent;
    }

    public void setAdvancesMarchPercent(BigDecimal advancesMarchPercent) {
        this.advancesMarchPercent = advancesMarchPercent;
    }

    public BigDecimal getTotal_businessMarchPercent() {
        return total_businessMarchPercent;
    }

    public void setTotal_businessMarchPercent(BigDecimal total_businessMarchPercent) {
        this.total_businessMarchPercent = total_businessMarchPercent;
    }

    public BigDecimal getTotal_retailMarchPercent() {
        return total_retailMarchPercent;
    }

    public void setTotal_retailMarchPercent(BigDecimal total_retailMarchPercent) {
        this.total_retailMarchPercent = total_retailMarchPercent;
    }

    public BigDecimal getHousingMarchPercent() {
        return housingMarchPercent;
    }

    public void setHousingMarchPercent(BigDecimal housingMarchPercent) {
        this.housingMarchPercent = housingMarchPercent;
    }

    public BigDecimal getVehicleMarchPercent() {
        return vehicleMarchPercent;
    }

    public void setVehicleMarchPercent(BigDecimal vehicleMarchPercent) {
        this.vehicleMarchPercent = vehicleMarchPercent;
    }

    public BigDecimal getEducationMarchPercent() {
        return educationMarchPercent;
    }

    public void setEducationMarchPercent(BigDecimal educationMarchPercent) {
        this.educationMarchPercent = educationMarchPercent;
    }

    public BigDecimal getAgriMarchPercent() {
        return agriMarchPercent;
    }

    public void setAgriMarchPercent(BigDecimal agriMarchPercent) {
        this.agriMarchPercent = agriMarchPercent;
    }

    public BigDecimal getMsmeMarchPercent() {
        return msmeMarchPercent;
    }

    public void setMsmeMarchPercent(BigDecimal msmeMarchPercent) {
        this.msmeMarchPercent = msmeMarchPercent;
    }

    public BigDecimal getGoldMarchPercent() {
        return goldMarchPercent;
    }

    public void setGoldMarchPercent(BigDecimal goldMarchPercent) {
        this.goldMarchPercent = goldMarchPercent;
    }

    public BigDecimal getShgMarchPercent() {
        return shgMarchPercent;
    }

    public void setShgMarchPercent(BigDecimal shgMarchPercent) {
        this.shgMarchPercent = shgMarchPercent;
    }

    public BigDecimal getTotal_ramMarchPercent() {
        return total_ramMarchPercent;
    }

    public void setTotal_ramMarchPercent(BigDecimal total_ramMarchPercent) {
        this.total_ramMarchPercent = total_ramMarchPercent;
    }

    public BigDecimal getNpaMarchPercent() {
        return npaMarchPercent;
    }

    public void setNpaMarchPercent(BigDecimal npaMarchPercent) {
        this.npaMarchPercent = npaMarchPercent;
    }

    public Date getReport_dateComingMarch() {
        return report_dateComingMarch;
    }

    public void setReport_dateComingMarch(Date report_dateComingMarch) {
        this.report_dateComingMarch = report_dateComingMarch;
    }

    public BigDecimal getSbComingMarch() {
        return sbComingMarch;
    }

    public void setSbComingMarch(BigDecimal sbComingMarch) {
        this.sbComingMarch = sbComingMarch;
    }

    public BigDecimal getCaComingMarch() {
        return caComingMarch;
    }

    public void setCaComingMarch(BigDecimal caComingMarch) {
        this.caComingMarch = caComingMarch;
    }

    public BigDecimal getTdComingMarch() {
        return tdComingMarch;
    }

    public void setTdComingMarch(BigDecimal tdComingMarch) {
        this.tdComingMarch = tdComingMarch;
    }

    public BigDecimal getCasaComingMarch() {
        return casaComingMarch;
    }

    public void setCasaComingMarch(BigDecimal casaComingMarch) {
        this.casaComingMarch = casaComingMarch;
    }

    public BigDecimal getDepositComingMarch() {
        return depositComingMarch;
    }

    public void setDepositComingMarch(BigDecimal depositComingMarch) {
        this.depositComingMarch = depositComingMarch;
    }

    public BigDecimal getAdvancesComingMarch() {
        return advancesComingMarch;
    }

    public void setAdvancesComingMarch(BigDecimal advancesComingMarch) {
        this.advancesComingMarch = advancesComingMarch;
    }

    public BigDecimal getTotal_businessComingMarch() {
        return total_businessComingMarch;
    }

    public void setTotal_businessComingMarch(BigDecimal total_businessComingMarch) {
        this.total_businessComingMarch = total_businessComingMarch;
    }

    public BigDecimal getTotal_retailComingMarch() {
        return total_retailComingMarch;
    }

    public void setTotal_retailComingMarch(BigDecimal total_retailComingMarch) {
        this.total_retailComingMarch = total_retailComingMarch;
    }

    public BigDecimal getHousingComingMarch() {
        return housingComingMarch;
    }

    public void setHousingComingMarch(BigDecimal housingComingMarch) {
        this.housingComingMarch = housingComingMarch;
    }

    public BigDecimal getVehicleComingMarch() {
        return vehicleComingMarch;
    }

    public void setVehicleComingMarch(BigDecimal vehicleComingMarch) {
        this.vehicleComingMarch = vehicleComingMarch;
    }

    public BigDecimal getEducationComingMarch() {
        return educationComingMarch;
    }

    public void setEducationComingMarch(BigDecimal educationComingMarch) {
        this.educationComingMarch = educationComingMarch;
    }

    public BigDecimal getAgriComingMarch() {
        return agriComingMarch;
    }

    public void setAgriComingMarch(BigDecimal agriComingMarch) {
        this.agriComingMarch = agriComingMarch;
    }

    public BigDecimal getMsmeComingMarch() {
        return msmeComingMarch;
    }

    public void setMsmeComingMarch(BigDecimal msmeComingMarch) {
        this.msmeComingMarch = msmeComingMarch;
    }

    public BigDecimal getGoldComingMarch() {
        return goldComingMarch;
    }

    public void setGoldComingMarch(BigDecimal goldComingMarch) {
        this.goldComingMarch = goldComingMarch;
    }

    public BigDecimal getShgComingMarch() {
        return shgComingMarch;
    }

    public void setShgComingMarch(BigDecimal shgComingMarch) {
        this.shgComingMarch = shgComingMarch;
    }

    public BigDecimal getTotal_ramComingMarch() {
        return total_ramComingMarch;
    }

    public void setTotal_ramComingMarch(BigDecimal total_ramComingMarch) {
        this.total_ramComingMarch = total_ramComingMarch;
    }

    public BigDecimal getNpaComingMarch() {
        return npaComingMarch;
    }

    public void setNpaComingMarch(BigDecimal npaComingMarch) {
        this.npaComingMarch = npaComingMarch;
    }

    public BigDecimal getTotal_businessSuperMarch() {
        return total_businessSuperMarch;
    }

    public void setTotal_businessSuperMarch(BigDecimal total_businessSuperMarch) {
        this.total_businessSuperMarch = total_businessSuperMarch;
    }

    public BigDecimal getNpaSuperMarch() {
        return npaSuperMarch;
    }

    public void setNpaSuperMarch(BigDecimal npaSuperMarch) {
        this.npaSuperMarch = npaSuperMarch;
    }

    public BigDecimal getTotal_advancesDisb() {
        return total_advancesDisb;
    }

    public void setTotal_advancesDisb(BigDecimal total_advancesDisb) {
        this.total_advancesDisb = total_advancesDisb;
    }

    public BigDecimal getTotal_osDisb() {
        return total_osDisb;
    }

    public void setTotal_osDisb(BigDecimal total_osDisb) {
        this.total_osDisb = total_osDisb;
    }

    public int getTotal_countDisb() {
        return total_countDisb;
    }

    public void setTotal_countDisb(int total_countDisb) {
        this.total_countDisb = total_countDisb;
    }

    public BigDecimal getRetailDisb() {
        return retailDisb;
    }

    public void setRetailDisb(BigDecimal retailDisb) {
        this.retailDisb = retailDisb;
    }

    public int getRetail_countDisb() {
        return retail_countDisb;
    }

    public void setRetail_countDisb(int retail_countDisb) {
        this.retail_countDisb = retail_countDisb;
    }

    public BigDecimal getHousingDisb() {
        return housingDisb;
    }

    public void setHousingDisb(BigDecimal housingDisb) {
        this.housingDisb = housingDisb;
    }

    public int getHousing_countDisb() {
        return housing_countDisb;
    }

    public void setHousing_countDisb(int housing_countDisb) {
        this.housing_countDisb = housing_countDisb;
    }

    public BigDecimal getVehicleDisb() {
        return vehicleDisb;
    }

    public void setVehicleDisb(BigDecimal vehicleDisb) {
        this.vehicleDisb = vehicleDisb;
    }

    public int getVehicle_countDisb() {
        return vehicle_countDisb;
    }

    public void setVehicle_countDisb(int vehicle_countDisb) {
        this.vehicle_countDisb = vehicle_countDisb;
    }

    public BigDecimal getEducationDisb() {
        return educationDisb;
    }

    public void setEducationDisb(BigDecimal educationDisb) {
        this.educationDisb = educationDisb;
    }

    public int getEducation_countDisb() {
        return education_countDisb;
    }

    public void setEducation_countDisb(int education_countDisb) {
        this.education_countDisb = education_countDisb;
    }

    public BigDecimal getAgricultureDisb() {
        return agricultureDisb;
    }

    public void setAgricultureDisb(BigDecimal agricultureDisb) {
        this.agricultureDisb = agricultureDisb;
    }

    public int getAgriculture_countDisb() {
        return agriculture_countDisb;
    }

    public void setAgriculture_countDisb(int agriculture_countDisb) {
        this.agriculture_countDisb = agriculture_countDisb;
    }

    public BigDecimal getMsmeDisb() {
        return msmeDisb;
    }

    public void setMsmeDisb(BigDecimal msmeDisb) {
        this.msmeDisb = msmeDisb;
    }

    public int getMsme_countDisb() {
        return msme_countDisb;
    }

    public void setMsme_countDisb(int msme_countDisb) {
        this.msme_countDisb = msme_countDisb;
    }

    public BigDecimal getGoldDisb() {
        return goldDisb;
    }

    public void setGoldDisb(BigDecimal goldDisb) {
        this.goldDisb = goldDisb;
    }

    public int getGold_countDisb() {
        return gold_countDisb;
    }

    public void setGold_countDisb(int gold_countDisb) {
        this.gold_countDisb = gold_countDisb;
    }

    public BigDecimal getShgDisb() {
        return shgDisb;
    }

    public void setShgDisb(BigDecimal shgDisb) {
        this.shgDisb = shgDisb;
    }

    public int getShg_countDisb() {
        return shg_countDisb;
    }

    public void setShg_countDisb(int shg_countDisb) {
        this.shg_countDisb = shg_countDisb;
    }

    public BigDecimal getTotal_advancesDisbTarget() {
        return total_advancesDisbTarget;
    }

    public void setTotal_advancesDisbTarget(BigDecimal total_advancesDisbTarget) {
        this.total_advancesDisbTarget = total_advancesDisbTarget;
    }

    public BigDecimal getTotal_osDisbTarget() {
        return total_osDisbTarget;
    }

    public void setTotal_osDisbTarget(BigDecimal total_osDisbTarget) {
        this.total_osDisbTarget = total_osDisbTarget;
    }

    public int getTotal_countDisbTarget() {
        return total_countDisbTarget;
    }

    public void setTotal_countDisbTarget(int total_countDisbTarget) {
        this.total_countDisbTarget = total_countDisbTarget;
    }

    public BigDecimal getRetailDisbTarget() {
        return retailDisbTarget;
    }

    public void setRetailDisbTarget(BigDecimal retailDisbTarget) {
        this.retailDisbTarget = retailDisbTarget;
    }

    public int getRetail_countDisbTarget() {
        return retail_countDisbTarget;
    }

    public void setRetail_countDisbTarget(int retail_countDisbTarget) {
        this.retail_countDisbTarget = retail_countDisbTarget;
    }

    public BigDecimal getHousingDisbTarget() {
        return housingDisbTarget;
    }

    public void setHousingDisbTarget(BigDecimal housingDisbTarget) {
        this.housingDisbTarget = housingDisbTarget;
    }

    public int getHousing_countDisbTarget() {
        return housing_countDisbTarget;
    }

    public void setHousing_countDisbTarget(int housing_countDisbTarget) {
        this.housing_countDisbTarget = housing_countDisbTarget;
    }

    public BigDecimal getVehicleDisbTarget() {
        return vehicleDisbTarget;
    }

    public void setVehicleDisbTarget(BigDecimal vehicleDisbTarget) {
        this.vehicleDisbTarget = vehicleDisbTarget;
    }

    public int getVehicle_countDisbTarget() {
        return vehicle_countDisbTarget;
    }

    public void setVehicle_countDisbTarget(int vehicle_countDisbTarget) {
        this.vehicle_countDisbTarget = vehicle_countDisbTarget;
    }

    public BigDecimal getEducationDisbTarget() {
        return educationDisbTarget;
    }

    public void setEducationDisbTarget(BigDecimal educationDisbTarget) {
        this.educationDisbTarget = educationDisbTarget;
    }

    public int getEducation_countDisbTarget() {
        return education_countDisbTarget;
    }

    public void setEducation_countDisbTarget(int education_countDisbTarget) {
        this.education_countDisbTarget = education_countDisbTarget;
    }

    public BigDecimal getAgricultureDisbTarget() {
        return agricultureDisbTarget;
    }

    public void setAgricultureDisbTarget(BigDecimal agricultureDisbTarget) {
        this.agricultureDisbTarget = agricultureDisbTarget;
    }

    public int getAgriculture_countDisbTarget() {
        return agriculture_countDisbTarget;
    }

    public void setAgriculture_countDisbTarget(int agriculture_countDisbTarget) {
        this.agriculture_countDisbTarget = agriculture_countDisbTarget;
    }

    public BigDecimal getMsmeDisbTarget() {
        return msmeDisbTarget;
    }

    public void setMsmeDisbTarget(BigDecimal msmeDisbTarget) {
        this.msmeDisbTarget = msmeDisbTarget;
    }

    public int getMsme_countDisbTarget() {
        return msme_countDisbTarget;
    }

    public void setMsme_countDisbTarget(int msme_countDisbTarget) {
        this.msme_countDisbTarget = msme_countDisbTarget;
    }

    public BigDecimal getGoldDisbTarget() {
        return goldDisbTarget;
    }

    public void setGoldDisbTarget(BigDecimal goldDisbTarget) {
        this.goldDisbTarget = goldDisbTarget;
    }

    public int getGold_countDisbTarget() {
        return gold_countDisbTarget;
    }

    public void setGold_countDisbTarget(int gold_countDisbTarget) {
        this.gold_countDisbTarget = gold_countDisbTarget;
    }

    public BigDecimal getShgDisbTarget() {
        return shgDisbTarget;
    }

    public void setShgDisbTarget(BigDecimal shgDisbTarget) {
        this.shgDisbTarget = shgDisbTarget;
    }

    public int getShg_countDisbTarget() {
        return shg_countDisbTarget;
    }

    public void setShg_countDisbTarget(int shg_countDisbTarget) {
        this.shg_countDisbTarget = shg_countDisbTarget;
    }

    public Date getReport_dateSma() {
        return report_dateSma;
    }

    public void setReport_dateSma(Date report_dateSma) {
        this.report_dateSma = report_dateSma;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public int getSma0_count() {
        return sma0_count;
    }

    public void setSma0_count(int sma0_count) {
        this.sma0_count = sma0_count;
    }

    public BigDecimal getSma0_amount() {
        return sma0_amount;
    }

    public void setSma0_amount(BigDecimal sma0_amount) {
        this.sma0_amount = sma0_amount;
    }

    public int getSma1_count() {
        return sma1_count;
    }

    public void setSma1_count(int sma1_count) {
        this.sma1_count = sma1_count;
    }

    public BigDecimal getSma1_amount() {
        return sma1_amount;
    }

    public void setSma1_amount(BigDecimal sma1_amount) {
        this.sma1_amount = sma1_amount;
    }

    public int getSma2_count() {
        return sma2_count;
    }

    public void setSma2_count(int sma2_count) {
        this.sma2_count = sma2_count;
    }

    public BigDecimal getSma2_amount() {
        return sma2_amount;
    }

    public void setSma2_amount(BigDecimal sma2_amount) {
        this.sma2_amount = sma2_amount;
    }

    public Long getTotal_countTimeBarred() {
        return total_countTimeBarred;
    }

    public void setTotal_countTimeBarred(Long total_countTimeBarred) {
        this.total_countTimeBarred = total_countTimeBarred;
    }

    public BigDecimal getTotal_amountTimeBarred() {
        return total_amountTimeBarred;
    }

    public void setTotal_amountTimeBarred(BigDecimal total_amountTimeBarred) {
        this.total_amountTimeBarred = total_amountTimeBarred;
    }

    public Long getTotal_countNpa() {
        return total_countNpa;
    }

    public void setTotal_countNpa(Long total_countNpa) {
        this.total_countNpa = total_countNpa;
    }

    public BigDecimal getTotal_amountNpa() {
        return total_amountNpa;
    }

    public void setTotal_amountNpa(BigDecimal total_amountNpa) {
        this.total_amountNpa = total_amountNpa;
    }

    public Long getSubStandard_countNpa() {
        return subStandard_countNpa;
    }

    public void setSubStandard_countNpa(Long subStandard_countNpa) {
        this.subStandard_countNpa = subStandard_countNpa;
    }

    public BigDecimal getSubStandard_amountNpa() {
        return subStandard_amountNpa;
    }

    public void setSubStandard_amountNpa(BigDecimal subStandard_amountNpa) {
        this.subStandard_amountNpa = subStandard_amountNpa;
    }

    public Long getD0_countNpa() {
        return d0_countNpa;
    }

    public void setD0_countNpa(Long d0_countNpa) {
        this.d0_countNpa = d0_countNpa;
    }

    public BigDecimal getD0_amountNpa() {
        return d0_amountNpa;
    }

    public void setD0_amountNpa(BigDecimal d0_amountNpa) {
        this.d0_amountNpa = d0_amountNpa;
    }

    public Long getD1_countNpa() {
        return d1_countNpa;
    }

    public void setD1_countNpa(Long d1_countNpa) {
        this.d1_countNpa = d1_countNpa;
    }

    public BigDecimal getD1_amountNpa() {
        return d1_amountNpa;
    }

    public void setD1_amountNpa(BigDecimal d1_amountNpa) {
        this.d1_amountNpa = d1_amountNpa;
    }

    public Long getD2_countNpa() {
        return d2_countNpa;
    }

    public void setD2_countNpa(Long d2_countNpa) {
        this.d2_countNpa = d2_countNpa;
    }

    public BigDecimal getD2_amountNpa() {
        return d2_amountNpa;
    }

    public void setD2_amountNpa(BigDecimal d2_amountNpa) {
        this.d2_amountNpa = d2_amountNpa;
    }

    public Long getLoss_countNpa() {
        return loss_countNpa;
    }

    public void setLoss_countNpa(Long loss_countNpa) {
        this.loss_countNpa = loss_countNpa;
    }

    public BigDecimal getLoss_amountNpa() {
        return loss_amountNpa;
    }

    public void setLoss_amountNpa(BigDecimal loss_amountNpa) {
        this.loss_amountNpa = loss_amountNpa;
    }

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

    public Long getPmjjby() {
        return pmjjby;
    }

    public void setPmjjby(Long pmjjby) {
        this.pmjjby = pmjjby;
    }

    public Long getPmsby() {
        return pmsby;
    }

    public void setPmsby(Long pmsby) {
        this.pmsby = pmsby;
    }

    public Long getApy() {
        return apy;
    }

    public void setApy(Long apy) {
        this.apy = apy;
    }

    public Long getPmjdy() {
        return pmjdy;
    }

    public void setPmjdy(Long pmjdy) {
        this.pmjdy = pmjdy;
    }

    public Long getInternet_banking() {
        return internet_banking;
    }

    public void setInternet_banking(Long internet_banking) {
        this.internet_banking = internet_banking;
    }

    public Long getMobile_banking() {
        return mobile_banking;
    }

    public void setMobile_banking(Long mobile_banking) {
        this.mobile_banking = mobile_banking;
    }

    public Long getAtm_card() {
        return atm_card;
    }

    public void setAtm_card(Long atm_card) {
        this.atm_card = atm_card;
    }

    public Long getCkyc() {
        return ckyc;
    }

    public void setCkyc(Long ckyc) {
        this.ckyc = ckyc;
    }

    public Long getMultiple_cif() {
        return multiple_cif;
    }

    public void setMultiple_cif(Long multiple_cif) {
        this.multiple_cif = multiple_cif;
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

    public Long getTotalBranchCount() {
        return totalBranchCount;
    }

    public void setTotalBranchCount(Long totalBranchCount) {
        this.totalBranchCount = totalBranchCount;
    }

    public Long getUrban() {
        return urban;
    }

    public void setUrban(Long urban) {
        this.urban = urban;
    }

    public Long getRural() {
        return rural;
    }

    public void setRural(Long rural) {
        this.rural = rural;
    }

    public Long getMetropolitan() {
        return metropolitan;
    }

    public void setMetropolitan(Long metropolitan) {
        this.metropolitan = metropolitan;
    }

    public Long getSemiUrban() {
        return semiUrban;
    }

    public void setSemiUrban(Long semiUrban) {
        this.semiUrban = semiUrban;
    }

    public Date getBranchopendate() {
        return branchopendate;
    }

    public void setBranchopendate(Date branchopendate) {
        this.branchopendate = branchopendate;
    }

    public String getMain_region() {
        return main_region;
    }

    public void setMain_region(String main_region) {
        this.main_region = main_region;
    }

    public String getPopulation_group_name() {
        return population_group_name;
    }

    public void setPopulation_group_name(String population_group_name) {
        this.population_group_name = population_group_name;
    }

    public String getU_loc() {
        return u_loc;
    }

    public void setU_loc(String u_loc) {
        this.u_loc = u_loc;
    }

    public String getGrade_code() {
        return grade_code;
    }

    public void setGrade_code(String grade_code) {
        this.grade_code = grade_code;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmp_number() {
        return emp_number;
    }

    public void setEmp_number(String emp_number) {
        this.emp_number = emp_number;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getDesignation_code() {
        return designation_code;
    }

    public void setDesignation_code(String designation_code) {
        this.designation_code = designation_code;
    }

    public String getU_type() {
        return u_type;
    }

    public void setU_type(String u_type) {
        this.u_type = u_type;
    }

    public int getDesg_gm() {
        return desg_gm;
    }

    public void setDesg_gm(int desg_gm) {
        this.desg_gm = desg_gm;
    }

    public int getDesg_dgm() {
        return desg_dgm;
    }

    public void setDesg_dgm(int desg_dgm) {
        this.desg_dgm = desg_dgm;
    }

    public int getDesg_agm() {
        return desg_agm;
    }

    public void setDesg_agm(int desg_agm) {
        this.desg_agm = desg_agm;
    }

    public int getDesg_cm() {
        return desg_cm;
    }

    public void setDesg_cm(int desg_cm) {
        this.desg_cm = desg_cm;
    }

    public int getDesg_srmanager() {
        return desg_srmanager;
    }

    public void setDesg_srmanager(int desg_srmanager) {
        this.desg_srmanager = desg_srmanager;
    }

    public int getDesg_manager() {
        return desg_manager;
    }

    public void setDesg_manager(int desg_manager) {
        this.desg_manager = desg_manager;
    }

    public int getDesg_dymanager() {
        return desg_dymanager;
    }

    public void setDesg_dymanager(int desg_dymanager) {
        this.desg_dymanager = desg_dymanager;
    }

    public int getDesg_clerk() {
        return desg_clerk;
    }

    public void setDesg_clerk(int desg_clerk) {
        this.desg_clerk = desg_clerk;
    }

    public int getSubstaff() {
        return substaff;
    }

    public void setSubstaff(int substaff) {
        this.substaff = substaff;
    }

    public int getDesg_agmTotalStaff() {
        return desg_agmTotalStaff;
    }

    public void setDesg_agmTotalStaff(int desg_agmTotalStaff) {
        this.desg_agmTotalStaff = desg_agmTotalStaff;
    }

    public int getDesg_cmTotalStaff() {
        return desg_cmTotalStaff;
    }

    public void setDesg_cmTotalStaff(int desg_cmTotalStaff) {
        this.desg_cmTotalStaff = desg_cmTotalStaff;
    }

    public int getDesg_srmanagerTotalStaff() {
        return desg_srmanagerTotalStaff;
    }

    public void setDesg_srmanagerTotalStaff(int desg_srmanagerTotalStaff) {
        this.desg_srmanagerTotalStaff = desg_srmanagerTotalStaff;
    }

    public int getDesg_managerTotalStaff() {
        return desg_managerTotalStaff;
    }

    public void setDesg_managerTotalStaff(int desg_managerTotalStaff) {
        this.desg_managerTotalStaff = desg_managerTotalStaff;
    }

    public int getDesg_dymanagerTotalStaff() {
        return desg_dymanagerTotalStaff;
    }

    public void setDesg_dymanagerTotalStaff(int desg_dymanagerTotalStaff) {
        this.desg_dymanagerTotalStaff = desg_dymanagerTotalStaff;
    }

    public int getDesg_clerkTotalStaff() {
        return desg_clerkTotalStaff;
    }

    public void setDesg_clerkTotalStaff(int desg_clerkTotalStaff) {
        this.desg_clerkTotalStaff = desg_clerkTotalStaff;
    }

    public int getSubstaffTotalStaff() {
        return substaffTotalStaff;
    }

    public void setSubstaffTotalStaff(int substaffTotalStaff) {
        this.substaffTotalStaff = substaffTotalStaff;
    }

    public String getParameterDetailRemark() {
        return parameterDetailRemark;
    }

    public void setParameterDetailRemark(String parameterDetailRemark) {
        this.parameterDetailRemark = parameterDetailRemark;
    }

    public String getSanctionDisbursedRemark() {
        return sanctionDisbursedRemark;
    }

    public void setSanctionDisbursedRemark(String sanctionDisbursedRemark) {
        this.sanctionDisbursedRemark = sanctionDisbursedRemark;
    }

    public String getSmaRemark() {
        return smaRemark;
    }

    public void setSmaRemark(String smaRemark) {
        this.smaRemark = smaRemark;
    }

    public String getNpaClassificationRemark() {
        return npaClassificationRemark;
    }

    public void setNpaClassificationRemark(String npaClassificationRemark) {
        this.npaClassificationRemark = npaClassificationRemark;
    }

    public String getComplianceRemark() {
        return complianceRemark;
    }

    public void setComplianceRemark(String complianceRemark) {
        this.complianceRemark = complianceRemark;
    }

    public String getAccountAndDigitalStatusRemark() {
        return accountAndDigitalStatusRemark;
    }

    public void setAccountAndDigitalStatusRemark(String accountAndDigitalStatusRemark) {
        this.accountAndDigitalStatusRemark = accountAndDigitalStatusRemark;
    }

    public String getSocialSecurityRemark() {
        return socialSecurityRemark;
    }

    public void setSocialSecurityRemark(String socialSecurityRemark) {
        this.socialSecurityRemark = socialSecurityRemark;
    }

    public String getOtherRemark() {
        return otherRemark;
    }

    public void setOtherRemark(String otherRemark) {
        this.otherRemark = otherRemark;
    }

    @Column(columnDefinition = "DATE")
    private LocalDate visit_date;
    private String branch_code;
    private String branch_name;

    private String region;
    @Column(columnDefinition = "DATE")
    private Date report_date;
    private BigDecimal sb;
    private BigDecimal ca;
    private BigDecimal td;
    private BigDecimal casa;
    private BigDecimal deposit;
    private BigDecimal advances;
    private BigDecimal total_business;

    private BigDecimal total_retail;
    private BigDecimal housing;
    private BigDecimal vehicle;
    private BigDecimal education;
    private BigDecimal agri;
    private BigDecimal msme;
    private BigDecimal gold;
    private BigDecimal shg;
    private BigDecimal total_ram;
    private BigDecimal npa;

    //*******************************************last march1 *******************************************
    @Column(columnDefinition = "DATE")
    private Date report_dateMarch1;
    private BigDecimal sbMarch1;
    private BigDecimal caMarch1;
    private BigDecimal tdMarch1;
    private BigDecimal casaMarch1;
    private BigDecimal depositMarch1;
    private BigDecimal advancesMarch1;
    private BigDecimal total_businessMarch1;

    private BigDecimal total_retailMarch1;
    private BigDecimal housingMarch1;
    private BigDecimal vehicleMarch1;
    private BigDecimal educationMarch1;
    private BigDecimal agriMarch1;
    private BigDecimal msmeMarch1;
    private BigDecimal goldMarch1;
    private BigDecimal shgMarch1;
    private BigDecimal total_ramMarch1;
    private BigDecimal npaMarch1;


    //*********************************************last march2*****************************

    @Column(columnDefinition = "DATE")
    private Date report_dateMarch2;
    private BigDecimal sbMarch2;
    private BigDecimal caMarch2;
    private BigDecimal tdMarch2;
    private BigDecimal casaMarch2;
    private BigDecimal depositMarch2;
    private BigDecimal advancesMarch2;
    private BigDecimal total_businessMarch2;

    private BigDecimal total_retailMarch2;
    private BigDecimal housingMarch2;
    private BigDecimal vehicleMarch2;
    private BigDecimal educationMarch2;
    private BigDecimal agriMarch2;
    private BigDecimal msmeMarch2;
    private BigDecimal goldMarch2;
    private BigDecimal shgMarch2;
    private BigDecimal total_ramMarch2;
    private BigDecimal npaMarch2;
    //********************************************last march3********************
    @Column(columnDefinition = "DATE")
    private Date report_dateMarch3;

    private BigDecimal sbMarch3;
    private BigDecimal caMarch3;
    private BigDecimal tdMarch3;
    private BigDecimal casaMarch3;
    private BigDecimal depositMarch3;
    private BigDecimal advancesMarch3;
    private BigDecimal total_businessMarch3;

    private BigDecimal total_retailMarch3;
    private BigDecimal housingMarch3;
    private BigDecimal vehicleMarch3;
    private BigDecimal educationMarch3;
    private BigDecimal agriMarch3;
    private BigDecimal msmeMarch3;
    private BigDecimal goldMarch3;
    private BigDecimal shgMarch3;
    private BigDecimal total_ramMarch3;
    private BigDecimal npaMarch3;
//*******************************************target data**********************************************
@Column(columnDefinition = "DATE")
    private Date report_dateTarget;

    private BigDecimal sbTarget;
    private BigDecimal caTarget;
    private BigDecimal tdTarget;
    private BigDecimal casaTarget;
    private BigDecimal depositTarget;
    private BigDecimal advancesTarget;
    private BigDecimal total_businessTarget;

    private BigDecimal total_retailTarget;
    private BigDecimal housingTarget;
    private BigDecimal vehicleTarget;
    private BigDecimal educationTarget;
    private BigDecimal agriTarget;
    private BigDecimal msmeTarget;
    private BigDecimal goldTarget;
    private BigDecimal shgTarget;
    private BigDecimal total_ramTarget;
    private BigDecimal npaTarget;
    //********************************************gap target*******************************************
    @Column(columnDefinition = "DATE")
    private Date report_dateTargetgap;

    private BigDecimal sbTargetgap;
    private BigDecimal caTargetgap;
    private BigDecimal tdTargetgap;
    private BigDecimal casaTargetgap;
    private BigDecimal depositTargetgap;
    private BigDecimal advancesTargetgap;
    private BigDecimal total_businessTargetgap;

    private BigDecimal total_retailTargetgap;
    private BigDecimal housingTargetgap;
    private BigDecimal vehicleTargetgap;
    private BigDecimal educationTargetgap;
    private BigDecimal agriTargetgap;
    private BigDecimal msmeTargetgap;
    private BigDecimal goldTargetgap;
    private BigDecimal shgTargetgap;
    private BigDecimal total_ramTargetgap;
    private BigDecimal npaTargetgap;

    //*************************************************march gap******************************************************
    @Column(columnDefinition = "DATE")
    private Date report_dateMarchGap;

    private BigDecimal sbMarchGap;
    private BigDecimal caMarchGap;
    private BigDecimal tdMarchGap;
    private BigDecimal casaMarchGap;
    private BigDecimal depositMarchGap;
    private BigDecimal advancesMarchGap;
    private BigDecimal total_businessMarchGap;

    private BigDecimal total_retailMarchGap;
    private BigDecimal housingMarchGap;
    private BigDecimal vehicleMarchGap;
    private BigDecimal educationMarchGap;
    private BigDecimal agriMarchGap;
    private BigDecimal msmeMarchGap;
    private BigDecimal goldMarchGap;
    private BigDecimal shgMarchGap;
    private BigDecimal total_ramMarchGap;
    private BigDecimal npaMarchGap;

    //***************************************************march percent***************************************************
    @Column(columnDefinition = "DATE")
    private Date report_dateMarchPercent;

    private BigDecimal sbMarchPercent;
    private BigDecimal caMarchPercent;
    private BigDecimal tdMarchPercent;
    private BigDecimal casaMarchPercent;
    private BigDecimal depositMarchPercent;
    private BigDecimal advancesMarchPercent;
    private BigDecimal total_businessMarchPercent;

    private BigDecimal total_retailMarchPercent;
    private BigDecimal housingMarchPercent;
    private BigDecimal vehicleMarchPercent;
    private BigDecimal educationMarchPercent;
    private BigDecimal agriMarchPercent;
    private BigDecimal msmeMarchPercent;
    private BigDecimal goldMarchPercent;
    private BigDecimal shgMarchPercent;
    private BigDecimal total_ramMarchPercent;
    private BigDecimal npaMarchPercent;

    //*************************************************Coming march*************************************************
    @Column(columnDefinition = "DATE")
    private Date report_dateComingMarch;

    private BigDecimal sbComingMarch;
    private BigDecimal caComingMarch;
    private BigDecimal tdComingMarch;
    private BigDecimal casaComingMarch;
    private BigDecimal depositComingMarch;
    private BigDecimal advancesComingMarch;
    private BigDecimal total_businessComingMarch;

    private BigDecimal total_retailComingMarch;
    private BigDecimal housingComingMarch;
    private BigDecimal vehicleComingMarch;
    private BigDecimal educationComingMarch;
    private BigDecimal agriComingMarch;
    private BigDecimal msmeComingMarch;
    private BigDecimal goldComingMarch;
    private BigDecimal shgComingMarch;
    private BigDecimal total_ramComingMarch;
    private BigDecimal npaComingMarch;
//**********************************************************super march*****************************************************************
    private BigDecimal total_businessSuperMarch;
    private BigDecimal npaSuperMarch;

    //*********************************************disbursement*****************************


    private BigDecimal total_advancesDisb;
    private BigDecimal total_osDisb;
    private int total_countDisb;
    private BigDecimal retailDisb;
    private int retail_countDisb;
    private BigDecimal housingDisb;
    private int housing_countDisb;
    private BigDecimal vehicleDisb;
    private int vehicle_countDisb;
    private BigDecimal educationDisb;
    private int education_countDisb;
    private BigDecimal agricultureDisb;
    private int agriculture_countDisb;
    private BigDecimal msmeDisb;
    private int msme_countDisb;
    private BigDecimal goldDisb;
    private int gold_countDisb;
    private BigDecimal shgDisb;
    private int shg_countDisb;

    //************************************************disb target**********************************************


    private BigDecimal total_advancesDisbTarget;
    private BigDecimal total_osDisbTarget;
    private int total_countDisbTarget;
    private BigDecimal retailDisbTarget;
    private int retail_countDisbTarget;
    private BigDecimal housingDisbTarget;
    private int housing_countDisbTarget;
    private BigDecimal vehicleDisbTarget;
    private int vehicle_countDisbTarget;
    private BigDecimal educationDisbTarget;
    private int education_countDisbTarget;
    private BigDecimal agricultureDisbTarget;
    private int agriculture_countDisbTarget;
    private BigDecimal msmeDisbTarget;
    private int msme_countDisbTarget;
    private BigDecimal goldDisbTarget;
    private int gold_countDisbTarget;
    private BigDecimal shgDisbTarget;
    private int shg_countDisbTarget;


    //***************************************************sma data****************************************************************
    @Column(columnDefinition = "DATE")
    private Date report_dateSma;

    private int total_count;
    private BigDecimal total_amount;
    private int sma0_count;
    private BigDecimal sma0_amount;
    private int sma1_count;
    private BigDecimal sma1_amount;
    private int sma2_count;
    private BigDecimal sma2_amount;
//***************************************************TimeBarred****************************************************************

    private Long total_countTimeBarred;
    private BigDecimal total_amountTimeBarred;

    public Date getReport_dateNpa() {
        return report_dateNpa;
    }

    public void setReport_dateNpa(Date report_dateNpa) {
        this.report_dateNpa = report_dateNpa;
    }

    //************************************npa classification********************************************
    @Column(columnDefinition = "DATE")
    private Date report_dateNpa;
    private Long total_countNpa;
    private BigDecimal total_amountNpa;
    private Long subStandard_countNpa;
    private BigDecimal subStandard_amountNpa;
    private Long d0_countNpa;
    private BigDecimal d0_amountNpa;
    private Long d1_countNpa;
    private BigDecimal d1_amountNpa;
    private Long d2_countNpa;
    private BigDecimal d2_amountNpa;
    private Long loss_countNpa;
    private BigDecimal loss_amountNpa;

    //******************************************kcc nacc****************************************
    private Long kcc_count;
    private BigDecimal kcc_amount;

    private Long nacc_count;
    private BigDecimal nacc_amount;

    //*********************************************compliance********************************************

    private Long pmjjby;
    private Long pmsby;
    private Long apy ;
    private Long pmjdy ;
    private Long internet_banking ;
    private Long mobile_banking ;
    private Long  atm_card ;
    private Long ckyc ;
    private Long multiple_cif ;

    private Long sb_ac_count;
    private Long ca_ac_count;
    private Long casa_count;

    private BigDecimal casa_amount;

    //********************************branch category *************************************
    private Long totalBranchCount;

    private Long urban;
    private Long rural;
    private Long metropolitan;
    private Long semiUrban;
    private Date branchopendate;


    private String main_region;

    private String population_group_name;
    private String u_loc;
    private String grade_code;
    private String employee_name;
    private String emp_number;
    private String u_id;
    private String designation_code;
    private String u_type;
    private int desg_gm;
    private int desg_dgm;
    private int desg_agm;

    private int desg_cm;
    private int desg_srmanager;
    private int desg_manager;
    private int desg_dymanager;
    private int desg_clerk;
    private int substaff;
    private int desg_agmTotalStaff;
    private int desg_cmTotalStaff;
    private int desg_srmanagerTotalStaff;
    private int desg_managerTotalStaff;
    private int desg_dymanagerTotalStaff;
    private int desg_clerkTotalStaff;
    private int substaffTotalStaff;

    //****************************************comment ***********************************************

    @Column(columnDefinition = "TEXT")
    private String parameterDetailRemark;
    @Column(columnDefinition = "TEXT")
    private String sanctionDisbursedRemark;
    @Column(columnDefinition = "TEXT")
    private String smaRemark;
    @Column(columnDefinition = "TEXT")
    private String npaClassificationRemark;
    @Column(columnDefinition = "TEXT")
    private String complianceRemark;
    @Column(columnDefinition = "TEXT")
    private String accountAndDigitalStatusRemark;
    @Column(columnDefinition = "TEXT")
    private String socialSecurityRemark;
    @Column(columnDefinition = "TEXT")
    private String otherRemark;

}
