package com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel;

import java.math.BigDecimal;
import java.util.Date;

public class MssoBranchProfileActualDataDto {
    private Date report_date;

    private BigDecimal sb;
    private BigDecimal ca;
    private BigDecimal td;
    private BigDecimal casa;
    private BigDecimal deposit;
    private BigDecimal advances;
    private BigDecimal total_business;

    private BigDecimal total_retail ;
    private BigDecimal housing ;
    private BigDecimal vehicle ;
    private BigDecimal education ;
    private BigDecimal agri ;
    private BigDecimal msme ;
    private BigDecimal gold ;
    private BigDecimal shg ;
    private BigDecimal total_ram ;
    private BigDecimal npa ;

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

    public BigDecimal getCasa() {
        return casa;
    }

    public void setCasa(BigDecimal casa) {
        this.casa = casa;
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

    public MssoBranchProfileActualDataDto(Date report_date, BigDecimal sb, BigDecimal ca, BigDecimal td, BigDecimal casa, BigDecimal deposit, BigDecimal advances, BigDecimal total_business, BigDecimal total_retail, BigDecimal housing, BigDecimal vehicle, BigDecimal education, BigDecimal agri, BigDecimal msme, BigDecimal gold, BigDecimal shg, BigDecimal total_ram, BigDecimal npa) {
        this.report_date = report_date;
        this.sb = sb;
        this.ca = ca;
        this.td = td;
        this.deposit = deposit;
        this.advances = advances;
        this.total_business = total_business;
        this.casa = casa;
        this.total_retail = total_retail;
        this.housing = housing;
        this.vehicle = vehicle;
        this.education = education;
        this.agri = agri;
        this.msme = msme;
        this.gold = gold;
        this.shg = shg;
        this.total_ram = total_ram;
        this.npa = npa;
    }
}
