package com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "msso_branches_actual_position", schema="msso_branch_profile")
public class MssoBranchProfileActualData {
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
    private Double casa;
    private Double deposit;
    private Double advances;
    private Double total_business;

    private Double total_retail ;
    private Double housing ;
    private Double vehicle ;
    private Double education ;
    private Double agri ;
    private Double msme ;
    private Double gold ;
    private Double shg ;
    private Double total_ram ;
    private Double npa ;
}
