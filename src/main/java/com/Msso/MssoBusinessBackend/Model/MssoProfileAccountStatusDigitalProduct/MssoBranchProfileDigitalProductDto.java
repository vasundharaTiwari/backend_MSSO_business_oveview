package com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct;

import java.util.Date;

public class MssoBranchProfileDigitalProductDto {
    private Date report_date;

    private Long internet_banking ;
    private Long mobile_banking ;
    private Long  atm_card ;
    private Long ckyc ;
    private Long multiple_cif ;

    public MssoBranchProfileDigitalProductDto(Date report_date, Long internet_banking, Long mobile_banking, Long atm_card, Long ckyc, Long multipleCif) {
        this.report_date = report_date;
        this.internet_banking = internet_banking;

        this.mobile_banking = mobile_banking;
        this.atm_card = atm_card;
        this.ckyc = ckyc;
        this.multiple_cif = multipleCif;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
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
}
