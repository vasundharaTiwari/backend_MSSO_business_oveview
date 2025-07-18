package com.Msso.MssoBusinessBackend.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
//@AllArgsConstructor
public class ParameterDetailsVisit {


    private Date reportDate;
    private BigDecimal sb;
    private BigDecimal ca;
    private BigDecimal td;
    private BigDecimal casa;
    private BigDecimal deposit;
    private BigDecimal advances;
    private BigDecimal totalBusiness;
    private BigDecimal totalRetail;
    private BigDecimal housing;
    private BigDecimal vehicle;
    private BigDecimal education;
    private BigDecimal agri;
    private BigDecimal msme;
    private BigDecimal gold;
    private BigDecimal shg;
    private BigDecimal totalRam;
    private BigDecimal npa;


    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
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

    public BigDecimal getTotalBusiness() {
        return totalBusiness;
    }

    public void setTotalBusiness(BigDecimal totalBusiness) {
        this.totalBusiness = totalBusiness;
    }

    public BigDecimal getTotalRetail() {
        return totalRetail;
    }

    public void setTotalRetail(BigDecimal totalRetail) {
        this.totalRetail = totalRetail;
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

    public BigDecimal getTotalRam() {
        return totalRam;
    }

    public void setTotalRam(BigDecimal totalRam) {
        this.totalRam = totalRam;
    }

    public BigDecimal getNpa() {
        return npa;
    }

    public void setNpa(BigDecimal npa) {
        this.npa = npa;
    }

    public ParameterDetailsVisit(Date reportDate, BigDecimal sb, BigDecimal ca, BigDecimal td, BigDecimal casa, BigDecimal deposit, BigDecimal advances, BigDecimal totalBusiness, BigDecimal totalRetail, BigDecimal housing, BigDecimal vehicle, BigDecimal education, BigDecimal agri, BigDecimal msme, BigDecimal gold, BigDecimal shg, BigDecimal totalRam, BigDecimal npa) {
        this.reportDate = reportDate;
        this.sb = sb;
        this.ca = ca;
        this.td = td;
        this.casa = casa;
        this.deposit = deposit;
        this.advances = advances;
        this.totalBusiness = totalBusiness;
        this.totalRetail = totalRetail;
        this.housing = housing;
        this.vehicle = vehicle;
        this.education = education;
        this.agri = agri;
        this.msme = msme;
        this.gold = gold;
        this.shg = shg;
        this.totalRam = totalRam;
        this.npa = npa;
    }

    public ParameterDetailsVisit() {
    }
}
