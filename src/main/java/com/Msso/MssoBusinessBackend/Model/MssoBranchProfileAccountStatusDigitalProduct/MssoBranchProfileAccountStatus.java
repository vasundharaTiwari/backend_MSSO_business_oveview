package com.Msso.MssoBusinessBackend.Model.MssoBranchProfileAccountStatusDigitalProduct;

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

@Table(name = "msso_profile_account_status", schema = "msso_branch_profile")
public class MssoBranchProfileAccountStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private Date report_date;
    private String branch_code;
    private String branch_name;

    private String region;

    private int sb_ac_count;
    private int ca_ac_count;
    private int casa_count;
    private BigDecimal casa_amount;
}
