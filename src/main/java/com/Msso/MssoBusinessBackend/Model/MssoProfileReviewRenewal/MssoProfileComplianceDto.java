package com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal;

import java.math.BigDecimal;
import java.util.Date;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//
//@Table(name = "msso_profile_pending_review_renewal", schema = "msso_branch_profile")
public class MssoProfileComplianceDto {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

  //  @Column(columnDefinition = "DATE")
    private Date report_date;
//    private String branch_code;
//    private String branch_name;
//
//    private String region;
    private Long total_count;
    private BigDecimal total_amount;

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public Long getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Long total_count) {
        this.total_count = total_count;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public MssoProfileComplianceDto(Date report_date, Long total_count, BigDecimal total_amount) {
        this.report_date = report_date;
        this.total_count = total_count;
        this.total_amount = total_amount;
    }
}
