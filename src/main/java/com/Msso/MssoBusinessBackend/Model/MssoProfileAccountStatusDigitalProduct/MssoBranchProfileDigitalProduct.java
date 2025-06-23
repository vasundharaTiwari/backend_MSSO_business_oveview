package com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "msso_profile_digital_product", schema = "msso_branch_profile")
public class MssoBranchProfileDigitalProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private Date report_date;
    private String branch_code;
    private String branch_name;

    private String region;
    private int internet_banking ;
    private int mobile_banking ;
    private int  atm_card ;
    private int ckyc ;
    private int multiple_cif ;
}
