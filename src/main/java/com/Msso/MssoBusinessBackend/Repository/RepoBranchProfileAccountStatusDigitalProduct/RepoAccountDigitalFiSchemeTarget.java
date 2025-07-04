package com.Msso.MssoBusinessBackend.Repository.RepoBranchProfileAccountStatusDigitalProduct;

import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoAccountStatusDigitalTarget;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoAccountStatusDigitalTargetDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoFiSchemeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepoAccountDigitalFiSchemeTarget extends JpaRepository<MssoAccountStatusDigitalTarget, Long> {
   //************************************************************digital target**********************************

    @Query(value = """
            SELECT report_date,sum( sb_ac_count)as sb_ac_count ,sum(ca_ac_count)as ca_ac_count,sum( internet_banking)as internet_banking ,sum(mobile_banking)as mobile_banking,
                                   sum(atm_card)as atm_card
                                   FROM msso_branch_profile.msso_profile_account_digital_target
                                   where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_account_digital_target ) group by report_date;
                                   """, nativeQuery = true)
    public MssoAccountStatusDigitalTargetDto getAccountDigitalTargetHo();


    @Query(value = """
            SELECT report_date,sum( sb_ac_count)as sb_ac_count ,sum(ca_ac_count)as ca_ac_count,sum( internet_banking)as internet_banking ,sum(mobile_banking)as mobile_banking,
                                   sum(atm_card)as atm_card
                                   FROM msso_branch_profile.msso_profile_account_digital_target
                                   where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_account_digital_target ) and branch_code=:branchCode  group by report_date;\s
                """, nativeQuery = true)
    public MssoAccountStatusDigitalTargetDto getAccountDigitalTargetBranch(@Param("branchCode") String branchCode);

    @Query(value = """
             SELECT report_date,sum( sb_ac_count)as sb_ac_count ,sum(ca_ac_count)as ca_ac_count,sum( internet_banking)as internet_banking ,sum(mobile_banking)as mobile_banking,
                                   sum(atm_card)as atm_card
                                   FROM msso_branch_profile.msso_profile_account_digital_target
                                   where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_account_digital_target )and REGION=:roname  group by report_date;\s
                """, nativeQuery = true)


    public MssoAccountStatusDigitalTargetDto getAccountDigitalTargetRO(@Param("roname") String roname);
    //************************************************************fi scheme target**********************************
    @Query(value = """
            SELECT report_date,sum( pmjjby)as pmjjby ,sum(pmsby)as pmsby,sum( apy)as apy ,sum(pmjdy)as pmjdy
                                   FROM msso_branch_profile.msso_profile_fi_scheme_target
                                   where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_fi_scheme_target )  group by report_date; """, nativeQuery = true)
    public MssoFiSchemeDto getFiSchemeTargetHo();


    @Query(value = """
             SELECT report_date,sum( pmjjby)as pmjjby ,sum(pmsby)as pmsby,sum( apy)as apy ,sum(pmjdy)as pmjdy
                                   FROM msso_branch_profile.msso_profile_fi_scheme_target
                                   where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_fi_scheme_target ) and branch_code=:branchCode  group by report_date;\s
                """, nativeQuery = true)
    public MssoFiSchemeDto getFiSchemeTargetBranch(@Param("branchCode") String branchCode);

    @Query(value = """
              SELECT report_date,sum( pmjjby)as pmjjby ,sum(pmsby)as pmsby,sum( apy)as apy ,sum(pmjdy)as pmjdy
                                   FROM msso_branch_profile.msso_profile_fi_scheme_target
                                   where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_fi_scheme_target )and REGION=:roname  group by report_date;\s
                """, nativeQuery = true)


    public MssoFiSchemeDto getFiSchemeTargetRO(@Param("roname") String roname);

}
