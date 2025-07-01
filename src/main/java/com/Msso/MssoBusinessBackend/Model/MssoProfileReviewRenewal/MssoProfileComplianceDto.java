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
    private Long total_count1;
    private BigDecimal total_amount1;

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

    public MssoProfileComplianceDto(Long total_count) {
        this.total_count = total_count;
    }
    public MssoProfileComplianceDto(Date report_date, Long total_count, BigDecimal total_amount, Long totalCount1, BigDecimal totalAmount1) {
        this.report_date = report_date;
        this.total_count = total_count;
        this.total_amount = total_amount;
        total_count1 = totalCount1;
        total_amount1 = totalAmount1;
    }

    public Long getTotal_count1() {
        return total_count1;
    }

    public void setTotal_count1(Long total_count1) {
        this.total_count1 = total_count1;
    }

    public BigDecimal getTotal_amount1() {
        return total_amount1;
    }

    public void setTotal_amount1(BigDecimal total_amount1) {
        this.total_amount1 = total_amount1;
    }
}
