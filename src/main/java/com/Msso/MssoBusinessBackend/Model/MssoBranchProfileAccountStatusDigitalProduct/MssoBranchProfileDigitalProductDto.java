package com.Msso.MssoBusinessBackend.Model.MssoBranchProfileAccountStatusDigitalProduct;

import java.util.Date;

public class MssoBranchProfileDigitalProductDto {
    private Date report_date;

    private int internet_banking ;
    private int mobile_banking ;
    private int  atm_card ;

    public MssoBranchProfileDigitalProductDto(int internet_banking, Date report_date, int mobile_banking, int atm_card) {
        this.internet_banking = internet_banking;
        this.report_date = report_date;
        this.mobile_banking = mobile_banking;
        this.atm_card = atm_card;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public int getInternet_banking() {
        return internet_banking;
    }

    public void setInternet_banking(int internet_banking) {
        this.internet_banking = internet_banking;
    }

    public int getMobile_banking() {
        return mobile_banking;
    }

    public void setMobile_banking(int mobile_banking) {
        this.mobile_banking = mobile_banking;
    }

    public int getAtm_card() {
        return atm_card;
    }

    public void setAtm_card(int atm_card) {
        this.atm_card = atm_card;
    }
}
