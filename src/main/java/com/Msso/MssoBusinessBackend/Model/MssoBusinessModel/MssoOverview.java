package com.Msso.MssoBusinessBackend.Model.MssoBusinessModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "MSSO_OVERVIEW")
public class MssoOverview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Date report_date;
    private String BRANCH_CODE;
    private String branch_name;
    private String REGION;
    private Double SB;
    private Double CA;
    private Double TD;
    private Double DEPOSIT;
    private Double ADVANCES;
    private Double TOTAL_BUSINESS;
    private Double CASA;


}
