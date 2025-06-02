package com.Msso.MssoBusinessBackend.Model.MssoAdvancesModel;

import java.math.BigDecimal;
import java.util.Date;

public class MssoAdvancesDto {
    public BigDecimal getADVANCES() {
        return ADVANCES;
    }

    public MssoAdvancesDto(BigDecimal ADVANCES, BigDecimal REG_ADV, BigDecimal TOTAL_NPA, BigDecimal FREEZ_NPA, Date REPORT_DATE) {
        this.ADVANCES = ADVANCES;
        this.REG_ADV = REG_ADV;
        this.TOTAL_NPA = TOTAL_NPA;
        this.FREEZ_NPA = FREEZ_NPA;
        this.REPORT_DATE = REPORT_DATE;
    }

    public void setADVANCES(BigDecimal ADVANCES) {
        this.ADVANCES = ADVANCES;
    }

    public BigDecimal getREG_ADV() {
        return REG_ADV;
    }

    public void setREG_ADV(BigDecimal REG_ADV) {
        this.REG_ADV = REG_ADV;
    }

    public BigDecimal getTOTAL_NPA() {
        return TOTAL_NPA;
    }

    public void setTOTAL_NPA(BigDecimal TOTAL_NPA) {
        this.TOTAL_NPA = TOTAL_NPA;
    }

    public BigDecimal getFREEZ_NPA() {
        return FREEZ_NPA;
    }

    public void setFREEZ_NPA(BigDecimal FREEZ_NPA) {
        this.FREEZ_NPA = FREEZ_NPA;
    }

    public Date getREPORT_DATE() {
        return REPORT_DATE;
    }

    public void setREPORT_DATE(Date REPORT_DATE) {
        this.REPORT_DATE = REPORT_DATE;
    }

    private BigDecimal ADVANCES;
    private BigDecimal REG_ADV;
    private BigDecimal TOTAL_NPA;
    private BigDecimal FREEZ_NPA;
    private Date REPORT_DATE;

}
