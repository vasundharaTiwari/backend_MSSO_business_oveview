package com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct;

import java.util.Date;

public class MssoAccountStatusDigitalTargetDto {
    private Date report_date;

    private Long sb_ac_count;
    private Long ca_ac_count;
    private Long internet_banking ;
    private Long mobile_banking ;
    private Long  atm_card ;

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
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

    public Long getinternet_banking() {
        return internet_banking;
    }

    public void setinternet_banking(Long internet_banking) {
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

    public MssoAccountStatusDigitalTargetDto(Date report_date, Long sb_ac_count, Long ca_ac_count, Long internet_banking, Long mobile_banking, Long atm_card) {
        this.report_date = report_date;
        this.sb_ac_count = sb_ac_count;
        this.ca_ac_count = ca_ac_count;
        this.internet_banking = internet_banking;
        this.mobile_banking = mobile_banking;
        this.atm_card = atm_card;
    }
}
