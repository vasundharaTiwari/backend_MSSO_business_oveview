package com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileTargetDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileTargetData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface RepoMssoBranchProfileTargetData extends JpaRepository<MssoBranchProfileTargetData, Long> {
    //*********************************************March target********************************
    @Query(value = """
             SELECT report_date, ROUND(SUM( sb)::numeric, 2) as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2) td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit , ROUND(SUM( advances)::numeric, 2)as advances , ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail, ROUND(SUM(
            housing)::numeric, 2)as housing , ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education, ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme, ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2)as npa
            FROM msso_branch_profile.msso_branches_target where 
            report_date=:quarterEndDate  GROUP BY report_date ; """, nativeQuery = true)
    public MssoBranchProfileTargetDataDto getBranchTargetHo(LocalDate quarterEndDate);


    @Query(value = """
            SELECT report_date, ROUND(SUM( sb*100)::numeric, 2), ROUND(SUM( ca*100)::numeric, 2), ROUND(SUM( td*100)::numeric, 2), ROUND(SUM( casa*100)::numeric, 2), ROUND(SUM( deposit*100)::numeric, 2), ROUND(SUM( advances*100)::numeric, 2), ROUND(SUM( total_business*100)::numeric, 2), ROUND(SUM( total_retail*100)::numeric, 2), ROUND(SUM(
            housing*100)::numeric, 2), ROUND(SUM( vehicle*100)::numeric, 2), ROUND(SUM( education*100)::numeric, 2), ROUND(SUM( agri*100)::numeric, 2), ROUND(SUM( msme*100)::numeric, 2), ROUND(SUM( gold*100)::numeric, 2), ROUND(SUM( shg*100)::numeric, 2), ROUND(SUM( total_ram*100)::numeric, 2), ROUND(SUM( npa*100)::numeric, 2)
            FROM msso_branch_profile.msso_branches_target where  branch_code=:branchCode AND
            report_date=:quarterEndDate  GROUP BY report_date ;
             """, nativeQuery = true)
    public MssoBranchProfileTargetDataDto getBranchTargetBranch(@Param("branchCode") String branchCode, @Param("quarterEndDate") LocalDate quarterEndDate);

    @Query(value = """
            SELECT report_date, ROUND(SUM( sb)::numeric, 2), ROUND(SUM( ca)::numeric, 2), ROUND(SUM( td)::numeric, 2), ROUND(SUM( casa)::numeric, 2), ROUND(SUM( deposit)::numeric, 2), ROUND(SUM( advances)::numeric, 2), ROUND(SUM( total_business)::numeric, 2), ROUND(SUM( total_retail)::numeric, 2), ROUND(SUM(
            housing)::numeric, 2), ROUND(SUM( vehicle)::numeric, 2), ROUND(SUM( education)::numeric, 2), ROUND(SUM( agri)::numeric, 2), ROUND(SUM( msme)::numeric, 2), ROUND(SUM( gold)::numeric, 2), ROUND(SUM( shg)::numeric, 2), ROUND(SUM( total_ram)::numeric, 2), ROUND(SUM( npa)::numeric, 2)
            FROM msso_branch_profile.msso_branches_target where  REGION=:roname AND
            report_date=:quarterEndDate GROUP BY report_date ;  """, nativeQuery = true)
    public MssoBranchProfileTargetDataDto getBranchTargetRO(@Param("roname") String roname, @Param("quarterEndDate") LocalDate quarterEndDate);

    //************************************************super achiever targer march*****************
    @Query(value = """
             SELECT report_date, ROUND(SUM( sb)::numeric, 2) as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2) td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit , ROUND(SUM( advances)::numeric, 2)as advances , ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail, ROUND(SUM(
            housing)::numeric, 2)as housing , ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education, ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme, ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2)as npa
            FROM msso_branch_profile.msso_target_superachievermarch where 
            report_date=:quarterEndDate  GROUP BY report_date ; """, nativeQuery = true)
    public MssoBranchProfileTargetDataDto getSuperAchieverHo(LocalDate quarterEndDate);


    @Query(value = """
            SELECT report_date, ROUND(SUM( sb*100)::numeric, 2), ROUND(SUM( ca*100)::numeric, 2), ROUND(SUM( td*100)::numeric, 2), ROUND(SUM( casa*100)::numeric, 2), ROUND(SUM( deposit*100)::numeric, 2), ROUND(SUM( advances*100)::numeric, 2), ROUND(SUM( total_business*100)::numeric, 2), ROUND(SUM( total_retail*100)::numeric, 2), ROUND(SUM(
            housing*100)::numeric, 2), ROUND(SUM( vehicle*100)::numeric, 2), ROUND(SUM( education*100)::numeric, 2), ROUND(SUM( agri*100)::numeric, 2), ROUND(SUM( msme*100)::numeric, 2), ROUND(SUM( gold*100)::numeric, 2), ROUND(SUM( shg*100)::numeric, 2), ROUND(SUM( total_ram*100)::numeric, 2), ROUND(SUM( npa*100)::numeric, 2)
            FROM msso_branch_profile.msso_target_superachievermarch where  branch_code=:branchCode AND
            report_date=:quarterEndDate  GROUP BY report_date ;
             """, nativeQuery = true)
    public MssoBranchProfileTargetDataDto getSuperAchieverBranch(@Param("branchCode") String branchCode, @Param("quarterEndDate") LocalDate quarterEndDate);

    @Query(value = """
            SELECT report_date, ROUND(SUM( sb)::numeric, 2), ROUND(SUM( ca)::numeric, 2), ROUND(SUM( td)::numeric, 2), ROUND(SUM( casa)::numeric, 2), ROUND(SUM( deposit)::numeric, 2), ROUND(SUM( advances)::numeric, 2), ROUND(SUM( total_business)::numeric, 2), ROUND(SUM( total_retail)::numeric, 2), ROUND(SUM(
            housing)::numeric, 2), ROUND(SUM( vehicle)::numeric, 2), ROUND(SUM( education)::numeric, 2), ROUND(SUM( agri)::numeric, 2), ROUND(SUM( msme)::numeric, 2), ROUND(SUM( gold)::numeric, 2), ROUND(SUM( shg)::numeric, 2), ROUND(SUM( total_ram)::numeric, 2), ROUND(SUM( npa)::numeric, 2)
            FROM msso_branch_profile.msso_target_superachievermarch where  REGION=:roname AND
            report_date=:quarterEndDate GROUP BY report_date ;  """, nativeQuery = true)
    public MssoBranchProfileTargetDataDto getSuperAchieverRO(@Param("roname") String roname, @Param("quarterEndDate") LocalDate quarterEndDate);

    //*******************************************************gap between actual and CURRENT QUARTER data******************************************************
    @Query(value = """
            with actual_data as
            (SELECT report_date, ROUND(SUM( sb)::numeric, 2) as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2) td,
             ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit ,
             ROUND(SUM( advances)::numeric, 2)as advances , ROUND(SUM( total_business)::numeric, 2)as total_business,
             ROUND(SUM( total_retail)::numeric, 2)as total_retail, ROUND(SUM(
             housing)::numeric, 2)as housing , ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education,
             ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme, ROUND(SUM( gold)::numeric, 2)as gold,
             ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2)as npa
             FROM msso_branch_profile.msso_branches_actual_position where
             report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position ) 
             GROUP BY report_date),
                        
             last_march_data as
             (SELECT report_date, ROUND(SUM( sb)::numeric, 2) as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2) td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit , ROUND(SUM( advances)::numeric, 2)as advances , ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail, ROUND(SUM(
             housing)::numeric, 2)as housing , ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education, ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme, ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2)as npa
             FROM msso_branch_profile.msso_branches_target where
             report_date= :quarterEndDate  
             GROUP BY report_date)
             
              select lm.report_date,(0::numeric) as sb,(0::numeric) as ca,(0::numeric) as td,(ad.casa-lm.casa) as casa,\s
             ad.deposit-lm.deposit as deposit,ad.advances-lm.advances as advances,ad.total_business-lm.total_business as total_business,
             (0::numeric) as total_retail,(0::numeric) as housing,(0::numeric) as vehicle,
             (0::numeric) as education,(0::numeric) as agri,(0::numeric) as msme,(0::numeric) as gold,(0::numeric) as shg,
             (0::numeric) as total_ram,ad.npa-lm.npa
             from actual_data ad,last_march_data lm """, nativeQuery = true)
    public MssoBranchProfileTargetDataDto getBranchProfileHoGap(@Param("quarterEndDate") LocalDate quarterEndDate);

    @Query(value = """
            with actual_data as(SELECT report_date, ROUND(SUM( sb*100)::numeric, 2)as sb, ROUND(SUM( ca*100)::numeric, 2)as ca, ROUND(SUM( td*100)::numeric, 2)as td, ROUND(SUM( casa*100)::numeric, 2)as casa, ROUND(SUM( deposit*100)::numeric, 2)as deposit, ROUND(SUM( advances*100)::numeric, 2)as advances, ROUND(SUM( total_business*100)::numeric, 2)as total_business, ROUND(SUM( total_retail*100)::numeric, 2)as total_retail , ROUND(SUM(
   housing*100)::numeric, 2)as housing, ROUND(SUM( vehicle*100)::numeric, 2) as vehicle, ROUND(SUM( education*100)::numeric, 2)as education , ROUND(SUM( agri*100)::numeric, 2)as agri, ROUND(SUM( msme*100)::numeric, 2)as msme , ROUND(SUM( gold*100)::numeric, 2)as gold, ROUND(SUM( shg*100)::numeric, 2)as shg, ROUND(SUM( total_ram*100)::numeric, 2)as total_ram , ROUND(SUM( npa*100)::numeric, 2) as npa
   FROM msso_branch_profile.msso_branches_actual_position where  branch_code=:branchCode AND
   report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position )  GROUP BY report_date
  ),
                                        
  last_march_data as(SELECT report_date, ROUND(SUM( sb*100)::numeric, 2)as sb, ROUND(SUM( ca*100)::numeric, 2)as ca, ROUND(SUM( td*100)::numeric, 2)as td, ROUND(SUM( casa*100)::numeric, 2)as casa, ROUND(SUM( deposit*100)::numeric, 2)as deposit, ROUND(SUM( advances*100)::numeric, 2)as advances, ROUND(SUM( total_business*100)::numeric, 2)as total_business, ROUND(SUM( total_retail*100)::numeric, 2)as total_retail , ROUND(SUM(
   housing*100)::numeric, 2)as housing, ROUND(SUM( vehicle*100)::numeric, 2) as vehicle, ROUND(SUM( education*100)::numeric, 2)as education , ROUND(SUM( agri*100)::numeric, 2)as agri, ROUND(SUM( msme*100)::numeric, 2)as msme , ROUND(SUM( gold*100)::numeric, 2)as gold, ROUND(SUM( shg*100)::numeric, 2)as shg, ROUND(SUM( total_ram*100)::numeric, 2)as total_ram , ROUND(SUM( npa*100)::numeric, 2) as npa  FROM msso_branch_profile.msso_branches_target where  branch_code=:branchCode AND
  report_date= :quarterEndDate 
  GROUP BY report_date)
                                        
   select lm.report_date,(0::numeric) as sb,(0::numeric) as ca,(0::numeric) as td,(ad.casa-lm.casa) as casa,\s
                       ad.deposit-lm.deposit as deposit,ad.advances-lm.advances as advances,ad.total_business-lm.total_business as total_business,
                       (0::numeric) as total_retail,(0::numeric) as housing,(0::numeric) as vehicle,
                       (0::numeric) as education,(0::numeric) as agri,(0::numeric) as msme,(0::numeric) as gold,(0::numeric) as shg,
                       (0::numeric) as total_ram,ad.npa-lm.npa
                       from actual_data ad,last_march_data lm """, nativeQuery = true)
    public MssoBranchProfileTargetDataDto getBranchProfileBranchGap(@Param("branchCode") String branchCode, @Param("quarterEndDate") LocalDate quarterEndDate);

    @Query(value = """
                        with actual_data as(SELECT report_date, ROUND(SUM( sb)::numeric, 2)as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2)as td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit, ROUND(SUM( advances)::numeric, 2)as advances, ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail , ROUND(SUM(
                        housing)::numeric, 2)as housing, ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education , ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme , ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2) as npa
                        FROM msso_branch_profile.msso_branches_actual_position where  region=:roname AND
                        report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position )  GROUP BY report_date 
                       ),

            last_march_data as(SELECT report_date, ROUND(SUM( sb)::numeric, 2)as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2)as td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit, ROUND(SUM( advances)::numeric, 2)as advances, ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail , ROUND(SUM(
                        housing)::numeric, 2)as housing, ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education , ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme , ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2) as npa  FROM msso_branch_profile.msso_branches_target where  region=:roname AND
            report_date= :quarterEndDate 
            GROUP BY report_date)

             select lm.report_date,(0::numeric) as sb,(0::numeric) as ca,(0::numeric) as td,(ad.casa-lm.casa) as casa,\s
             ad.deposit-lm.deposit as deposit,ad.advances-lm.advances as advances,ad.total_business-lm.total_business as total_business,
             (0::numeric) as total_retail,(0::numeric) as housing,(0::numeric) as vehicle,
             (0::numeric) as education,(0::numeric) as agri,(0::numeric) as msme,(0::numeric) as gold,(0::numeric) as shg,
             (0::numeric) as total_ram,ad.npa-lm.npa
             from actual_data ad,last_march_data lm """, nativeQuery = true)
    public MssoBranchProfileTargetDataDto getBranchProfileRoGap(@Param("roname") String roname, @Param("quarterEndDate") LocalDate quarterEndDate);


}
