package com.Msso.MssoBusinessBackend.Model.MssoAdvancesModel;

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

@Table(name = "MSSO_ADVANCES")
public class MssoAdvances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date REPORT_DATE;
    private String BRANCH_CODE;
    private String BRANCH_NAME;
    private String REGION;
    private BigDecimal ADVANCES;
    private BigDecimal REG_ADV;
    private BigDecimal TOTAL_NPA;
    private BigDecimal FREEZ_NPA;
}
