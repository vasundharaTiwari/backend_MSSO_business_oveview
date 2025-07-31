package com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Visit_Data_Staff_Compliance", schema = "msso_branch_profile")
public class VisitDataStaffCompliance {
    //*********************************************compliance********************************************
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "DATE")
    private LocalDate visit_date;
    private String branch_code;
    private Long pmjjby;
    private Long pmsby;
    private Long apy;
    private Long pmjdy;
    private Long pmjjbyTarget;
    private Long pmsbyTarget;
    private Long apyTarget;


    @Column(columnDefinition = "DATE")
    private Date socialSecurityReportDate;
    @Column(columnDefinition = "DATE")
    private Date branchOpenDate;
    private Long pmjdyTarget;

    private Long internet_banking;
    private Long mobile_banking;
    private Long atm_card;
    private Long internet_bankingTarget;
    private Long mobile_bankingTarget;
    private Long atm_cardTarget;

    private Long casa_count;
    private BigDecimal casa_amount;
    private Long ckyc;
    private Long multiple_cif;

    private Long sb_ac_count;
    private Long ca_ac_count;
    private Long sb_ac_countMarch;
    private Long ca_ac_countMarch;
    private Long sb_ac_countTarget;
    private Long ca_ac_countTarget;


    //********************************branch category *************************************
    private Long totalBranchCount;

    private Long urban;
    private Long rural;
    private Long metropolitan;
    private Long semiUrban;


    private String main_region;

    private String population_group_name;
    private String u_loc;
    private String grade_code;
    private String employee_name;
    private String emp_number;
    private String u_id;
    private String designation_code;
    private String u_type;
    private String branch_name;
    private String branch_category;
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
    @Column(columnDefinition = "TEXT")
    private String employeeDataRemark;
    private String visitor_userid;


    private String visitor_name;
    private String visitor_designation;
    private String visitor_branch_code;
    private String visitor_region;

    private BigDecimal total_staff_branch;
    private BigDecimal perEmployeeBusiness;
    private Long bcCount;
    private String region;

    private BigDecimal total_staff_region;

    private BigDecimal sma0Percentage;
    private BigDecimal sma1Percentage;
    private BigDecimal sma2Percentage;
    private BigDecimal smaTotalPercentage;

    private Date report_date;
    private BigDecimal total_os_amt;
    private Long total_housing;
    private BigDecimal housing_amt;
    private Long total_natl;
    private BigDecimal natl_amt;
    private Long total_shg;
    private BigDecimal shg_amt;
    private Long kcc_atl;
    private BigDecimal kcc_atl_amt;
    private Long other;
    private BigDecimal other_amt;
    private Long nacc;
    private BigDecimal nacc_amt;

    private Long total_count;

    private Long count_below_1lakh;
    private BigDecimal below_1lakh_amt;
    private Long count_below_3lakh;
    private BigDecimal below_3lakh_amt;
    private Long count_below_24lakh;
    private BigDecimal below_24lakh_amt;
    private Long count_above_25lakh;
    private BigDecimal above_25lakh_amt;


    private BigDecimal addition_os_amt;

    private BigDecimal upgrade_os_amt;

    private BigDecimal recovered_os_amt;

    private BigDecimal addition_os_amtMarch;

    private BigDecimal upgrade_os_amtMarch;

    private BigDecimal recovered_os_amtMarch;

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public BigDecimal getTotal_os_amt() {
        return total_os_amt;
    }

    public void setTotal_os_amt(BigDecimal total_os_amt) {
        this.total_os_amt = total_os_amt;
    }

    public Long getTotal_housing() {
        return total_housing;
    }

    public void setTotal_housing(Long total_housing) {
        this.total_housing = total_housing;
    }

    public BigDecimal getHousing_amt() {
        return housing_amt;
    }

    public void setHousing_amt(BigDecimal housing_amt) {
        this.housing_amt = housing_amt;
    }

    public Long getTotal_natl() {
        return total_natl;
    }

    public void setTotal_natl(Long total_natl) {
        this.total_natl = total_natl;
    }

    public BigDecimal getNatl_amt() {
        return natl_amt;
    }

    public void setNatl_amt(BigDecimal natl_amt) {
        this.natl_amt = natl_amt;
    }

    public Long getTotal_shg() {
        return total_shg;
    }

    public void setTotal_shg(Long total_shg) {
        this.total_shg = total_shg;
    }

    public BigDecimal getShg_amt() {
        return shg_amt;
    }

    public void setShg_amt(BigDecimal shg_amt) {
        this.shg_amt = shg_amt;
    }

    public Long getKcc_atl() {
        return kcc_atl;
    }

    public void setKcc_atl(Long kcc_atl) {
        this.kcc_atl = kcc_atl;
    }

    public BigDecimal getKcc_atl_amt() {
        return kcc_atl_amt;
    }

    public void setKcc_atl_amt(BigDecimal kcc_atl_amt) {
        this.kcc_atl_amt = kcc_atl_amt;
    }

    public Long getOther() {
        return other;
    }

    public void setOther(Long other) {
        this.other = other;
    }

    public BigDecimal getOther_amt() {
        return other_amt;
    }

    public void setOther_amt(BigDecimal other_amt) {
        this.other_amt = other_amt;
    }

    public Long getNacc() {
        return nacc;
    }

    public void setNacc(Long nacc) {
        this.nacc = nacc;
    }

    public BigDecimal getNacc_amt() {
        return nacc_amt;
    }

    public void setNacc_amt(BigDecimal nacc_amt) {
        this.nacc_amt = nacc_amt;
    }

    public Long getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Long total_count) {
        this.total_count = total_count;
    }

    public Long getCount_below_1lakh() {
        return count_below_1lakh;
    }

    public void setCount_below_1lakh(Long count_below_1lakh) {
        this.count_below_1lakh = count_below_1lakh;
    }

    public BigDecimal getBelow_1lakh_amt() {
        return below_1lakh_amt;
    }

    public void setBelow_1lakh_amt(BigDecimal below_1lakh_amt) {
        this.below_1lakh_amt = below_1lakh_amt;
    }

    public Long getCount_below_3lakh() {
        return count_below_3lakh;
    }

    public void setCount_below_3lakh(Long count_below_3lakh) {
        this.count_below_3lakh = count_below_3lakh;
    }

    public BigDecimal getBelow_3lakh_amt() {
        return below_3lakh_amt;
    }

    public void setBelow_3lakh_amt(BigDecimal below_3lakh_amt) {
        this.below_3lakh_amt = below_3lakh_amt;
    }

    public Long getCount_below_24lakh() {
        return count_below_24lakh;
    }

    public void setCount_below_24lakh(Long count_below_24lakh) {
        this.count_below_24lakh = count_below_24lakh;
    }

    public BigDecimal getBelow_24lakh_amt() {
        return below_24lakh_amt;
    }

    public void setBelow_24lakh_amt(BigDecimal below_24lakh_amt) {
        this.below_24lakh_amt = below_24lakh_amt;
    }

    public Long getCount_above_25lakh() {
        return count_above_25lakh;
    }

    public void setCount_above_25lakh(Long count_above_25lakh) {
        this.count_above_25lakh = count_above_25lakh;
    }

    public BigDecimal getAbove_25lakh_amt() {
        return above_25lakh_amt;
    }

    public void setAbove_25lakh_amt(BigDecimal above_25lakh_amt) {
        this.above_25lakh_amt = above_25lakh_amt;
    }


    public BigDecimal getAddition_os_amt() {
        return addition_os_amt;
    }

    public void setAddition_os_amt(BigDecimal addition_os_amt) {
        this.addition_os_amt = addition_os_amt;
    }


    public BigDecimal getUpgrade_os_amt() {
        return upgrade_os_amt;
    }

    public void setUpgrade_os_amt(BigDecimal upgrade_os_amt) {
        this.upgrade_os_amt = upgrade_os_amt;
    }


    public BigDecimal getRecovered_os_amt() {
        return recovered_os_amt;
    }

    public void setRecovered_os_amt(BigDecimal recovered_os_amt) {
        this.recovered_os_amt = recovered_os_amt;
    }


    public BigDecimal getAddition_os_amtMarch() {
        return addition_os_amtMarch;
    }

    public void setAddition_os_amtMarch(BigDecimal addition_os_amtMarch) {
        this.addition_os_amtMarch = addition_os_amtMarch;
    }


    public BigDecimal getUpgrade_os_amtMarch() {
        return upgrade_os_amtMarch;
    }

    public void setUpgrade_os_amtMarch(BigDecimal upgrade_os_amtMarch) {
        this.upgrade_os_amtMarch = upgrade_os_amtMarch;
    }


    public BigDecimal getRecovered_os_amtMarch() {
        return recovered_os_amtMarch;
    }

    public void setRecovered_os_amtMarch(BigDecimal recovered_os_amtMarch) {
        this.recovered_os_amtMarch = recovered_os_amtMarch;
    }

    public BigDecimal getSma0Percentage() {
        return sma0Percentage;
    }

    public void setSma0Percentage(BigDecimal sma0Percentage) {
        this.sma0Percentage = sma0Percentage;
    }

    public BigDecimal getSma1Percentage() {
        return sma1Percentage;
    }

    public void setSma1Percentage(BigDecimal sma1Percentage) {
        this.sma1Percentage = sma1Percentage;
    }

    public BigDecimal getSma2Percentage() {
        return sma2Percentage;
    }

    public void setSma2Percentage(BigDecimal sma2Percentage) {
        this.sma2Percentage = sma2Percentage;
    }

    public BigDecimal getSmaTotalPercentage() {
        return smaTotalPercentage;
    }

    public void setSmaTotalPercentage(BigDecimal smaTotalPercentage) {
        this.smaTotalPercentage = smaTotalPercentage;
    }

    public BigDecimal getTotal_staff_branch() {
        return total_staff_branch;
    }

    public void setTotal_staff_branch(BigDecimal total_staff_branch) {
        this.total_staff_branch = total_staff_branch;
    }

    public BigDecimal getTotal_staff_region() {
        return total_staff_region;
    }

    public void setTotal_staff_region(BigDecimal total_staff_region) {
        this.total_staff_region = total_staff_region;
    }

    public Date getSocialSecurityReportDate() {
        return socialSecurityReportDate;
    }

    public void setSocialSecurityReportDate(Date socialSecurityReportDate) {
        this.socialSecurityReportDate = socialSecurityReportDate;
    }

    public Date getBranchOpenDate() {
        return branchOpenDate;
    }

    public void setBranchOpenDate(Date branchOpenDate) {
        this.branchOpenDate = branchOpenDate;
    }

    public String getEmployeeDataRemark() {
        return employeeDataRemark;
    }

    public void setEmployeeDataRemark(String employeeDataRemark) {
        this.employeeDataRemark = employeeDataRemark;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Long getBcCount() {
        return bcCount;
    }

    public void setBcCount(Long bcCount) {
        this.bcCount = bcCount;
    }

    public LocalDate getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(LocalDate visit_date) {
        this.visit_date = visit_date;
    }

    public String getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getBranch_category() {
        return branch_category;
    }

    public void setBranch_category(String branch_category) {
        this.branch_category = branch_category;
    }

    public Long getPmjjby() {
        return pmjjby;
    }

    public void setPmjjby(Long pmjjby) {
        this.pmjjby = pmjjby;
    }

    public Long getPmsby() {
        return pmsby;
    }

    public void setPmsby(Long pmsby) {
        this.pmsby = pmsby;
    }

    public Long getApy() {
        return apy;
    }

    public void setApy(Long apy) {
        this.apy = apy;
    }

    public Long getPmjdy() {
        return pmjdy;
    }

    public void setPmjdy(Long pmjdy) {
        this.pmjdy = pmjdy;
    }

    public Long getPmjjbyTarget() {
        return pmjjbyTarget;
    }

    public void setPmjjbyTarget(Long pmjjbyTarget) {
        this.pmjjbyTarget = pmjjbyTarget;
    }

    public Long getPmsbyTarget() {
        return pmsbyTarget;
    }

    public void setPmsbyTarget(Long pmsbyTarget) {
        this.pmsbyTarget = pmsbyTarget;
    }

    public Long getApyTarget() {
        return apyTarget;
    }

    public void setApyTarget(Long apyTarget) {
        this.apyTarget = apyTarget;
    }

    public Long getPmjdyTarget() {
        return pmjdyTarget;
    }

    public void setPmjdyTarget(Long pmjdyTarget) {
        this.pmjdyTarget = pmjdyTarget;
    }

    public Long getInternet_banking() {
        return internet_banking;
    }

    public void setInternet_banking(Long internet_banking) {
        this.internet_banking = internet_banking;
    }

    public Long getMobile_banking() {
        return mobile_banking;
    }

    public void setMobile_banking(Long mobile_banking) {
        this.mobile_banking = mobile_banking;
    }

    public Long getAtm_card() {
        return atm_card;
    }

    public void setAtm_card(Long atm_card) {
        this.atm_card = atm_card;
    }

    public Long getInternet_bankingTarget() {
        return internet_bankingTarget;
    }

    public void setInternet_bankingTarget(Long internet_bankingTarget) {
        this.internet_bankingTarget = internet_bankingTarget;
    }

    public Long getMobile_bankingTarget() {
        return mobile_bankingTarget;
    }

    public void setMobile_bankingTarget(Long mobile_bankingTarget) {
        this.mobile_bankingTarget = mobile_bankingTarget;
    }

    public Long getAtm_cardTarget() {
        return atm_cardTarget;
    }

    public void setAtm_cardTarget(Long atm_cardTarget) {
        this.atm_cardTarget = atm_cardTarget;
    }

    public Long getCasa_count() {
        return casa_count;
    }

    public void setCasa_count(Long casa_count) {
        this.casa_count = casa_count;
    }

    public BigDecimal getCasa_amount() {
        return casa_amount;
    }

    public void setCasa_amount(BigDecimal casa_amount) {
        this.casa_amount = casa_amount;
    }

    public Long getCkyc() {
        return ckyc;
    }

    public void setCkyc(Long ckyc) {
        this.ckyc = ckyc;
    }

    public Long getMultiple_cif() {
        return multiple_cif;
    }

    public void setMultiple_cif(Long multiple_cif) {
        this.multiple_cif = multiple_cif;
    }

    public Long getSb_ac_count() {
        return sb_ac_count;
    }

    public void setSb_ac_count(Long sb_ac_count) {
        this.sb_ac_count = sb_ac_count;
    }

    public Long getCa_ac_count() {
        return ca_ac_count;
    }

    public void setCa_ac_count(Long ca_ac_count) {
        this.ca_ac_count = ca_ac_count;
    }

    public Long getSb_ac_countMarch() {
        return sb_ac_countMarch;
    }

    public void setSb_ac_countMarch(Long sb_ac_countMarch) {
        this.sb_ac_countMarch = sb_ac_countMarch;
    }

    public Long getCa_ac_countMarch() {
        return ca_ac_countMarch;
    }

    public void setCa_ac_countMarch(Long ca_ac_countMarch) {
        this.ca_ac_countMarch = ca_ac_countMarch;
    }

    public Long getSb_ac_countTarget() {
        return sb_ac_countTarget;
    }

    public void setSb_ac_countTarget(Long sb_ac_countTarget) {
        this.sb_ac_countTarget = sb_ac_countTarget;
    }

    public Long getCa_ac_countTarget() {
        return ca_ac_countTarget;
    }

    public void setCa_ac_countTarget(Long ca_ac_countTarget) {
        this.ca_ac_countTarget = ca_ac_countTarget;
    }

    public Long getTotalBranchCount() {
        return totalBranchCount;
    }

    public void setTotalBranchCount(Long totalBranchCount) {
        this.totalBranchCount = totalBranchCount;
    }

    public Long getUrban() {
        return urban;
    }

    public void setUrban(Long urban) {
        this.urban = urban;
    }

    public Long getRural() {
        return rural;
    }

    public void setRural(Long rural) {
        this.rural = rural;
    }

    public Long getMetropolitan() {
        return metropolitan;
    }

    public void setMetropolitan(Long metropolitan) {
        this.metropolitan = metropolitan;
    }

    public Long getSemiUrban() {
        return semiUrban;
    }

    public void setSemiUrban(Long semiUrban) {
        this.semiUrban = semiUrban;
    }


    public String getMain_region() {
        return main_region;
    }

    public void setMain_region(String main_region) {
        this.main_region = main_region;
    }

    public String getPopulation_group_name() {
        return population_group_name;
    }

    public void setPopulation_group_name(String population_group_name) {
        this.population_group_name = population_group_name;
    }

    public String getU_loc() {
        return u_loc;
    }

    public void setU_loc(String u_loc) {
        this.u_loc = u_loc;
    }

    public String getGrade_code() {
        return grade_code;
    }

    public void setGrade_code(String grade_code) {
        this.grade_code = grade_code;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmp_number() {
        return emp_number;
    }

    public void setEmp_number(String emp_number) {
        this.emp_number = emp_number;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getDesignation_code() {
        return designation_code;
    }

    public void setDesignation_code(String designation_code) {
        this.designation_code = designation_code;
    }

    public String getU_type() {
        return u_type;
    }

    public void setU_type(String u_type) {
        this.u_type = u_type;
    }

    public int getDesg_gm() {
        return desg_gm;
    }

    public void setDesg_gm(int desg_gm) {
        this.desg_gm = desg_gm;
    }

    public int getDesg_dgm() {
        return desg_dgm;
    }

    public void setDesg_dgm(int desg_dgm) {
        this.desg_dgm = desg_dgm;
    }

    public int getDesg_agm() {
        return desg_agm;
    }

    public void setDesg_agm(int desg_agm) {
        this.desg_agm = desg_agm;
    }

    public int getDesg_cm() {
        return desg_cm;
    }

    public void setDesg_cm(int desg_cm) {
        this.desg_cm = desg_cm;
    }

    public int getDesg_srmanager() {
        return desg_srmanager;
    }

    public void setDesg_srmanager(int desg_srmanager) {
        this.desg_srmanager = desg_srmanager;
    }

    public int getDesg_manager() {
        return desg_manager;
    }

    public void setDesg_manager(int desg_manager) {
        this.desg_manager = desg_manager;
    }

    public int getDesg_dymanager() {
        return desg_dymanager;
    }

    public void setDesg_dymanager(int desg_dymanager) {
        this.desg_dymanager = desg_dymanager;
    }

    public int getDesg_clerk() {
        return desg_clerk;
    }

    public void setDesg_clerk(int desg_clerk) {
        this.desg_clerk = desg_clerk;
    }

    public int getSubstaff() {
        return substaff;
    }

    public void setSubstaff(int substaff) {
        this.substaff = substaff;
    }

    public int getDesg_agmTotalStaff() {
        return desg_agmTotalStaff;
    }

    public void setDesg_agmTotalStaff(int desg_agmTotalStaff) {
        this.desg_agmTotalStaff = desg_agmTotalStaff;
    }

    public int getDesg_cmTotalStaff() {
        return desg_cmTotalStaff;
    }

    public void setDesg_cmTotalStaff(int desg_cmTotalStaff) {
        this.desg_cmTotalStaff = desg_cmTotalStaff;
    }

    public int getDesg_srmanagerTotalStaff() {
        return desg_srmanagerTotalStaff;
    }

    public void setDesg_srmanagerTotalStaff(int desg_srmanagerTotalStaff) {
        this.desg_srmanagerTotalStaff = desg_srmanagerTotalStaff;
    }

    public int getDesg_managerTotalStaff() {
        return desg_managerTotalStaff;
    }

    public void setDesg_managerTotalStaff(int desg_managerTotalStaff) {
        this.desg_managerTotalStaff = desg_managerTotalStaff;
    }

    public int getDesg_dymanagerTotalStaff() {
        return desg_dymanagerTotalStaff;
    }

    public void setDesg_dymanagerTotalStaff(int desg_dymanagerTotalStaff) {
        this.desg_dymanagerTotalStaff = desg_dymanagerTotalStaff;
    }

    public int getDesg_clerkTotalStaff() {
        return desg_clerkTotalStaff;
    }

    public void setDesg_clerkTotalStaff(int desg_clerkTotalStaff) {
        this.desg_clerkTotalStaff = desg_clerkTotalStaff;
    }

    public int getSubstaffTotalStaff() {
        return substaffTotalStaff;
    }

    public void setSubstaffTotalStaff(int substaffTotalStaff) {
        this.substaffTotalStaff = substaffTotalStaff;
    }

    public String getParameterDetailRemark() {
        return parameterDetailRemark;
    }

    public void setParameterDetailRemark(String parameterDetailRemark) {
        this.parameterDetailRemark = parameterDetailRemark;
    }

    public String getSanctionDisbursedRemark() {
        return sanctionDisbursedRemark;
    }

    public void setSanctionDisbursedRemark(String sanctionDisbursedRemark) {
        this.sanctionDisbursedRemark = sanctionDisbursedRemark;
    }

    public String getSmaRemark() {
        return smaRemark;
    }

    public void setSmaRemark(String smaRemark) {
        this.smaRemark = smaRemark;
    }

    public String getNpaClassificationRemark() {
        return npaClassificationRemark;
    }

    public void setNpaClassificationRemark(String npaClassificationRemark) {
        this.npaClassificationRemark = npaClassificationRemark;
    }

    public String getComplianceRemark() {
        return complianceRemark;
    }

    public void setComplianceRemark(String complianceRemark) {
        this.complianceRemark = complianceRemark;
    }

    public String getAccountAndDigitalStatusRemark() {
        return accountAndDigitalStatusRemark;
    }

    public void setAccountAndDigitalStatusRemark(String accountAndDigitalStatusRemark) {
        this.accountAndDigitalStatusRemark = accountAndDigitalStatusRemark;
    }

    public String getSocialSecurityRemark() {
        return socialSecurityRemark;
    }

    public void setSocialSecurityRemark(String socialSecurityRemark) {
        this.socialSecurityRemark = socialSecurityRemark;
    }

    public String getOtherRemark() {
        return otherRemark;
    }

    public void setOtherRemark(String otherRemark) {
        this.otherRemark = otherRemark;
    }

    public String getVisitor_userid() {
        return visitor_userid;
    }

    public void setVisitor_userid(String visitor_userid) {
        this.visitor_userid = visitor_userid;
    }

    public String getVisitor_name() {
        return visitor_name;
    }

    public void setVisitor_name(String visitor_name) {
        this.visitor_name = visitor_name;
    }

    public String getVisitor_designation() {
        return visitor_designation;
    }

    public void setVisitor_designation(String visitor_designation) {
        this.visitor_designation = visitor_designation;
    }

    public String getVisitor_branch_code() {
        return visitor_branch_code;
    }

    public void setVisitor_branch_code(String visitor_branch_code) {
        this.visitor_branch_code = visitor_branch_code;
    }

    public String getVisitor_region() {
        return visitor_region;
    }

    public void setVisitor_region(String visitor_region) {
        this.visitor_region = visitor_region;
    }


    public BigDecimal getPerEmployeeBusiness() {
        return perEmployeeBusiness;
    }

    public void setPerEmployeeBusiness(BigDecimal perEmployeeBusiness) {
        this.perEmployeeBusiness = perEmployeeBusiness;
    }
}
