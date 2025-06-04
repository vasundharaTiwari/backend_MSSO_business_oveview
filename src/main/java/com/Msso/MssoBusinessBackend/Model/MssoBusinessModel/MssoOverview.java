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
    private String branch_code;
    private String branch_name;
    private String region;
    private Double sb;
    private Double ca;
    private Double td;
    private Double deposit;
    private Double advances;
    private Double total_business;
    private Double casa;


}
