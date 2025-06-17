package com.Msso.MssoBusinessBackend.Model.MssoAdvancesModel;

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

@Table(name = "MSSO_ADVANCES")
public class MssoAdvances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "DATE")
    private LocalDate report_date;
    private String branch_code;
    private String branch_name;
    private String region;
    private BigDecimal advances;
    private BigDecimal reg_adv;
    private BigDecimal total_npa;
    private BigDecimal freez_npa;

}
