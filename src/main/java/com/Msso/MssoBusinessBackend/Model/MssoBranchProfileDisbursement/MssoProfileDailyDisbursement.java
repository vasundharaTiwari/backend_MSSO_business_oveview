package com.Msso.MssoBusinessBackend.Model.MssoBranchProfileDisbursement;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    private Double total_advances;
    private Double total_os;
    private int total_count;
    private Double retail;
    private int retail_count;
    private Double housing;
    private int housing_count;
    private Double vehicle;
    private int vehicle_count;
    private Double education;
    private int education_count;
    private Double agriculture;
    private int agriculture_count;
    private Double msme;
    private int msme_count;
    private Double gold;
    private int gold_count;
    private Double shg;
    private int shg_count;
    private Double  pm_suryaghar ;
    private int pm_suryaghar_count ;
    private Double  pmvishvakarma;
    private int pmvishvakarma_count;
}
