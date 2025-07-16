package com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit;

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

@Table(name = "msso_profile_visit_report", schema = "msso_branch_profile")
public class ExecutiveVisitingData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private Date visit_date;
    private String branch_code;
    private String branch_name;

    private String region;

    private Date report_date;
    private Double sb;
    private Double ca;
    private Double td;
    private Double casa;
    private Double deposit;
    private Double advances;
    private Double total_business;

    private Double total_retail;
    private Double housing;
    private Double vehicle;
    private Double education;
    private Double agri;
    private Double msme;
    private Double gold;
    private Double shg;
    private Double total_ram;
    private Double npa;

    //*******************************************last march1 *******************************************
    private Date report_dateMarch1;
    private Double sbMarch1;
    private Double caMarch1;
    private Double tdMarch1;
    private Double casaMarch1;
    private Double depositMarch1;
    private Double advancesMarch1;
    private Double total_businessMarch1;

    private Double total_retailMarch1;
    private Double housingMarch1;
    private Double vehicleMarch1;
    private Double educationMarch1;
    private Double agriMarch1;
    private Double msmeMarch1;
    private Double goldMarch1;
    private Double shgMarch1;
    private Double total_ramMarch1;
    private Double npaMarch1;


    //*********************************************last march2*****************************
    private Date report_dateMarch2;
    private Double sbMarch2;
    private Double caMarch2;
    private Double tdMarch2;
    private Double casaMarch2;
    private Double depositMarch2;
    private Double advancesMarch2;
    private Double total_businessMarch2;

    private Double total_retailMarch2;
    private Double housingMarch2;
    private Double vehicleMarch2;
    private Double educationMarch2;
    private Double agriMarch2;
    private Double msmeMarch2;
    private Double goldMarch2;
    private Double shgMarch2;
    private Double total_ramMarch2;
    private Double npaMarch2;
    //********************************************last march3********************
    private Date report_dateMarch3;

    private Double sbMarch3;
    private Double caMarch3;
    private Double tdMarch3;
    private Double casaMarch3;
    private Double depositMarch3;
    private Double advancesMarch3;
    private Double total_businessMarch3;

    private Double total_retailMarch3;
    private Double housingMarch3;
    private Double vehicleMarch3;
    private Double educationMarch3;
    private Double agriMarch3;
    private Double msmeMarch3;
    private Double goldMarch3;
    private Double shgMarch3;
    private Double total_ramMarch3;
    private Double npaMarch3;
//*******************************************target data**********************************************

    private Date report_dateTarget;

    private Double sbTarget;
    private Double caTarget;
    private Double tdTarget;
    private Double casaTarget;
    private Double depositTarget;
    private Double advancesTarget;
    private Double total_businessTarget;

    private Double total_retailTarget;
    private Double housingTarget;
    private Double vehicleTarget;
    private Double educationTarget;
    private Double agriTarget;
    private Double msmeTarget;
    private Double goldTarget;
    private Double shgTarget;
    private Double total_ramTarget;
    private Double npaTarget;
    //********************************************gap target*******************************************
    private Date report_dateTargetgap;

    private Double sbTargetgap;
    private Double caTargetgap;
    private Double tdTargetgap;
    private Double casaTargetgap;
    private Double depositTargetgap;
    private Double advancesTargetgap;
    private Double total_businessTargetgap;

    private Double total_retailTargetgap;
    private Double housingTargetgap;
    private Double vehicleTargetgap;
    private Double educationTargetgap;
    private Double agriTargetgap;
    private Double msmeTargetgap;
    private Double goldTargetgap;
    private Double shgTargetgap;
    private Double total_ramTargetgap;
    private Double npaTargetgap;

    //*************************************************march gap******************************************************

    private Date report_dateMarchGap;

    private Double sbMarchGap;
    private Double caMarchGap;
    private Double tdMarchGap;
    private Double casaMarchGap;
    private Double depositMarchGap;
    private Double advancesMarchGap;
    private Double total_businessMarchGap;

    private Double total_retailMarchGap;
    private Double housingMarchGap;
    private Double vehicleMarchGap;
    private Double educationMarchGap;
    private Double agriMarchGap;
    private Double msmeMarchGap;
    private Double goldMarchGap;
    private Double shgMarchGap;
    private Double total_ramMarchGap;
    private Double npaMarchGap;

    //***************************************************march percent***************************************************

    private Date report_dateMarchPercent;

    private Double sbMarchPercent;
    private Double caMarchPercent;
    private Double tdMarchPercent;
    private Double casaMarchPercent;
    private Double depositMarchPercent;
    private Double advancesMarchPercent;
    private Double total_businessMarchPercent;

    private Double total_retailMarchPercent;
    private Double housingMarchPercent;
    private Double vehicleMarchPercent;
    private Double educationMarchPercent;
    private Double agriMarchPercent;
    private Double msmeMarchPercent;
    private Double goldMarchPercent;
    private Double shgMarchPercent;
    private Double total_ramMarchPercent;
    private Double npaMarchPercent;

    //*************************************************Coming march*************************************************

    private Date report_dateComingMarch;

    private Double sbComingMarch;
    private Double caComingMarch;
    private Double tdComingMarch;
    private Double casaComingMarch;
    private Double depositComingMarch;
    private Double advancesComingMarch;
    private Double total_businessComingMarch;

    private Double total_retailComingMarch;
    private Double housingComingMarch;
    private Double vehicleComingMarch;
    private Double educationComingMarch;
    private Double agriComingMarch;
    private Double msmeComingMarch;
    private Double goldComingMarch;
    private Double shgComingMarch;
    private Double total_ramComingMarch;
    private Double npaComingMarch;
//**********************************************************super march*****************************************************************
    private Double total_businessSuperMarch;
    private Double npaSuperMarch;

    //*********************************************disbursement*****************************


    private Double total_advancesDisb;
    private Double total_osDisb;
    private int total_countDisb;
    private Double retailDisb;
    private int retail_countDisb;
    private Double housingDisb;
    private int housing_countDisb;
    private Double vehicleDisb;
    private int vehicle_countDisb;
    private Double educationDisb;
    private int education_countDisb;
    private Double agricultureDisb;
    private int agriculture_countDisb;
    private Double msmeDisb;
    private int msme_countDisb;
    private Double goldDisb;
    private int gold_countDisb;
    private Double shgDisb;
    private int shg_countDisb;

    //************************************************disb target**********************************************


    private Double total_advancesDisbTarget;
    private Double total_osDisbTarget;
    private int total_countDisbTarget;
    private Double retailDisbTarget;
    private int retail_countDisbTarget;
    private Double housingDisbTarget;
    private int housing_countDisbTarget;
    private Double vehicleDisbTarget;
    private int vehicle_countDisbTarget;
    private Double educationDisbTarget;
    private int education_countDisbTarget;
    private Double agricultureDisbTarget;
    private int agriculture_countDisbTarget;
    private Double msmeDisbTarget;
    private int msme_countDisbTarget;
    private Double goldDisbTarget;
    private int gold_countDisbTarget;
    private Double shgDisbTarget;
    private int shg_countDisbTarget;


    //***************************************************sma data****************************************************************

    private Date report_dateSma;

    private int total_count;
    private Double total_amount;
    private int sma0_count;
    private Double sma0_amount;
    private int sma1_count;
    private Double sma1_amount;
    private int sma2_count;
    private Double sma2_amount;
//***************************************************TimeBarred****************************************************************

    private Long total_countTimeBarred;
    private BigDecimal total_amountTimeBarred;

    //************************************npa classification********************************************

    private Long total_countNpa;
    private BigDecimal total_amountNpa;
    private Long subStandard_countNpa;
    private BigDecimal subStandard_amountNpa;
    private Long d0_countNpa;
    private BigDecimal d0_amountNpa;
    private Long d1_countNpa;
    private BigDecimal d1_amountNpa;
    private Long d2_countNpa;
    private BigDecimal d2_amountNpa;
    private Long loss_countNpa;
    private BigDecimal loss_amountNpa;

    //******************************************kcc nacc****************************************
    private Long kcc_count;
    private BigDecimal kcc_amount;

    private Long nacc_count;
    private BigDecimal nacc_amount;

    //*********************************************compliance********************************************

    private Long pmjjby;
    private Long pmsby;
    private Long apy ;
    private Long pmjdy ;
    private Long internet_banking ;
    private Long mobile_banking ;
    private Long  atm_card ;
    private Long ckyc ;
    private Long multiple_cif ;

    private Long sb_ac_count;
    private Long ca_ac_count;
    private Long casa_count;

    private BigDecimal casa_amount;

    //********************************branch category *************************************
    private Long totalBranchCount;

    private Long urban;
    private Long rural;
    private Long metropolitan;
    private Long semiUrban;
    private Date branchopendate;


    private String main_region;

    private String population_group_name;
    private String u_loc;
    private String grade_code;
    private String employee_name;
    private String emp_number;
    private String u_id;
    private String designation_code;
    private String u_type;
    private int desg_gm;
    private int desg_dgm;
    private int desg_agm;

    private int desg_cm;
    private int desg_srmanager;
    private int desg_manager;
    private int desg_dymanager;
    private int desg_clerk;
    private int substaff;
    private int desg_agmTotalStaff;
    private int desg_cmTotalStaff;
    private int desg_srmanagerTotalStaff;
    private int desg_managerTotalStaff;
    private int desg_dymanagerTotalStaff;
    private int desg_clerkTotalStaff;
    private int substaffTotalStaff;

    //****************************************comment ***********************************************

    @Column(columnDefinition = "TEXT")
    private String parameterDetailRemark;
    @Column(columnDefinition = "TEXT")
    private String sanctionDisbursedRemark;
    @Column(columnDefinition = "TEXT")
    private String smaRemark;
    @Column(columnDefinition = "TEXT")
    private String npaClassificationRemark;
    @Column(columnDefinition = "TEXT")
    private String complianceRemark;
    @Column(columnDefinition = "TEXT")
    private String accountAndDigitalStatusRemark;
    @Column(columnDefinition = "TEXT")
    private String socialSecurityRemark;
    @Column(columnDefinition = "TEXT")
    private String otherRemark;

}
