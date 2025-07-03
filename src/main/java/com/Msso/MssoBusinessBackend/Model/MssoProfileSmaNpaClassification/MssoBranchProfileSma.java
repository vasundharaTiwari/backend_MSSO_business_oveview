package com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "msso_profile_sma_data", schema = "msso_branch_profile")
public class MssoBranchProfileSma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "DATE")
    private Date report_date;
    private String branch_code;
    private String branch_name;
    private String region;
    private int total_count;
    private BigDecimal total_amount;
    private int sma0_count;
    private BigDecimal sma0_amount;
    private int sma1_count;
    private BigDecimal sma1_amount;
    private int sma2_count;
    private BigDecimal sma2_amount;

}
