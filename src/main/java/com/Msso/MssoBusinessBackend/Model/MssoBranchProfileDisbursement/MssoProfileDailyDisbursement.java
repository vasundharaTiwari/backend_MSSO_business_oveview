package com.Msso.MssoBusinessBackend.Model.MssoBranchProfileDisbursement;

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

@Table(name = "msso_profile_daily_disbursement", schema = "msso_branch_profile")
public class MssoProfileDailyDisbursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private Date report_date;
    private String branch_code;
    private String branch_name;

    private String region;
    private BigDecimal total_advances;
    private BigDecimal total_os;
    private int total_count;
    private BigDecimal retail;
    private int retail_count;
    private BigDecimal housing;
    private int housing_count;
    private BigDecimal vehicle;
    private int vehicle_count;
    private BigDecimal education;
    private int education_count;
    private BigDecimal agriculture;
    private int agriculture_count;
    private BigDecimal msme;
    private int msme_count;
    private BigDecimal gold;
    private int gold_count;
    private BigDecimal shg;
    private int shg_count;

}
