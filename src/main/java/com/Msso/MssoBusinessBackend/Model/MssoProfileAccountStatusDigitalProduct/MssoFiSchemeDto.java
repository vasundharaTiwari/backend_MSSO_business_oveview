package com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct;

import java.util.Date;

public class MssoFiSchemeDto {
    private Date report_date;

    private Long pmjjby;
    private Long pmsby;
    private Long apy ;
    private Long pmjdy ;

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
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

    public MssoFiSchemeDto(Date report_date, Long pmjjby, Long pmsby, Long apy, Long pmjdy) {
        this.report_date = report_date;
        this.pmjjby = pmjjby;
        this.pmsby = pmsby;
        this.apy = apy;
        this.pmjdy = pmjdy;
    }
}
