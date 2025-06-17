package com.Msso.MssoBusinessBackend.Model.MssoDepositModel;

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

@Table(name = "MSSO_deposit")
public class MssoDeposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "DATE")
    private LocalDate report_date;
    private String branch_code;
    private String br_name;

    private BigDecimal sb;
    private BigDecimal ca;
    private BigDecimal td;
    private BigDecimal deposit;
    private String region;
}
