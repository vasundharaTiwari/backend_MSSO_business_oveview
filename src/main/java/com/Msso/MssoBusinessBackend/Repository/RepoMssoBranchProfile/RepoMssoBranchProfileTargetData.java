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
             SELECT report_date, ROUND(SUM( sb)::numeric, 2) as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2) td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit , ROUND(SUM( advances)::numeric, 2)as advances , ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail, ROUND(SUM(\s
            housing)::numeric, 2)as housing , ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education, ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme, ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2)as npa
            FROM msso_branch_profile.msso_branches_target where \s
            report_date=:quarterEndDate  GROUP BY report_date ; """, nativeQuery = true)
    public MssoBranchProfileTargetDataDto getBranchTargetHo(LocalDate quarterEndDate);


    @Query(value = """
            SELECT report_date, ROUND(SUM( sb)::numeric, 2), ROUND(SUM( ca)::numeric, 2), ROUND(SUM( td)::numeric, 2), ROUND(SUM( casa)::numeric, 2), ROUND(SUM( deposit)::numeric, 2), ROUND(SUM( advances)::numeric, 2), ROUND(SUM( total_business)::numeric, 2), ROUND(SUM( total_retail)::numeric, 2), ROUND(SUM(\s
            housing)::numeric, 2), ROUND(SUM( vehicle)::numeric, 2), ROUND(SUM( education)::numeric, 2), ROUND(SUM( agri)::numeric, 2), ROUND(SUM( msme)::numeric, 2), ROUND(SUM( gold)::numeric, 2), ROUND(SUM( shg)::numeric, 2), ROUND(SUM( total_ram)::numeric, 2), ROUND(SUM( npa)::numeric, 2)
            FROM msso_branch_profile.msso_branches_target where  branch_code=:branchCode AND
            report_date=:quarterEndDate  GROUP BY report_date ;
             """, nativeQuery = true)
    public MssoBranchProfileTargetDataDto getBranchTargetBranch(@Param("branchCode") String branchCode,@Param("quarterEndDate") LocalDate quarterEndDate);

    @Query(value = """
            SELECT report_date, ROUND(SUM( sb)::numeric, 2), ROUND(SUM( ca)::numeric, 2), ROUND(SUM( td)::numeric, 2), ROUND(SUM( casa)::numeric, 2), ROUND(SUM( deposit)::numeric, 2), ROUND(SUM( advances)::numeric, 2), ROUND(SUM( total_business)::numeric, 2), ROUND(SUM( total_retail)::numeric, 2), ROUND(SUM(\s
            housing)::numeric, 2), ROUND(SUM( vehicle)::numeric, 2), ROUND(SUM( education)::numeric, 2), ROUND(SUM( agri)::numeric, 2), ROUND(SUM( msme)::numeric, 2), ROUND(SUM( gold)::numeric, 2), ROUND(SUM( shg)::numeric, 2), ROUND(SUM( total_ram)::numeric, 2), ROUND(SUM( npa)::numeric, 2)
            FROM msso_branch_profile.msso_branches_target where  REGION=:roname AND
            report_date=:quarterEndDate GROUP BY report_date ;  """, nativeQuery = true)
    public MssoBranchProfileTargetDataDto getBranchTargetRO(@Param("roname") String roname,@Param("quarterEndDate") LocalDate quarterEndDate);
//************************************************super achiever targer march*****************
@Query(value = """
             SELECT report_date, ROUND(SUM( sb)::numeric, 2) as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2) td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit , ROUND(SUM( advances)::numeric, 2)as advances , ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail, ROUND(SUM(\s
            housing)::numeric, 2)as housing , ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education, ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme, ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2)as npa
            FROM msso_branch_profile.msso_target_superachievermarch where \s
            report_date=:quarterEndDate  GROUP BY report_date ; """, nativeQuery = true)
public MssoBranchProfileTargetDataDto getSuperAchieverHo(LocalDate quarterEndDate);


    @Query(value = """
            SELECT report_date, ROUND(SUM( sb)::numeric, 2), ROUND(SUM( ca)::numeric, 2), ROUND(SUM( td)::numeric, 2), ROUND(SUM( casa)::numeric, 2), ROUND(SUM( deposit)::numeric, 2), ROUND(SUM( advances)::numeric, 2), ROUND(SUM( total_business)::numeric, 2), ROUND(SUM( total_retail)::numeric, 2), ROUND(SUM(\s
            housing)::numeric, 2), ROUND(SUM( vehicle)::numeric, 2), ROUND(SUM( education)::numeric, 2), ROUND(SUM( agri)::numeric, 2), ROUND(SUM( msme)::numeric, 2), ROUND(SUM( gold)::numeric, 2), ROUND(SUM( shg)::numeric, 2), ROUND(SUM( total_ram)::numeric, 2), ROUND(SUM( npa)::numeric, 2)
            FROM msso_branch_profile.msso_target_superachievermarch where  branch_code=:branchCode AND
            report_date=:quarterEndDate  GROUP BY report_date ;
             """, nativeQuery = true)
    public MssoBranchProfileTargetDataDto getSuperAchieverBranch(@Param("branchCode") String branchCode,@Param("quarterEndDate") LocalDate quarterEndDate);

    @Query(value = """
            SELECT report_date, ROUND(SUM( sb)::numeric, 2), ROUND(SUM( ca)::numeric, 2), ROUND(SUM( td)::numeric, 2), ROUND(SUM( casa)::numeric, 2), ROUND(SUM( deposit)::numeric, 2), ROUND(SUM( advances)::numeric, 2), ROUND(SUM( total_business)::numeric, 2), ROUND(SUM( total_retail)::numeric, 2), ROUND(SUM(\s
            housing)::numeric, 2), ROUND(SUM( vehicle)::numeric, 2), ROUND(SUM( education)::numeric, 2), ROUND(SUM( agri)::numeric, 2), ROUND(SUM( msme)::numeric, 2), ROUND(SUM( gold)::numeric, 2), ROUND(SUM( shg)::numeric, 2), ROUND(SUM( total_ram)::numeric, 2), ROUND(SUM( npa)::numeric, 2)
            FROM msso_branch_profile.msso_target_superachievermarch where  REGION=:roname AND
            report_date=:quarterEndDate GROUP BY report_date ;  """, nativeQuery = true)
    public MssoBranchProfileTargetDataDto getSuperAchieverRO(@Param("roname") String roname,@Param("quarterEndDate") LocalDate quarterEndDate);
    //*******************************************************gap between actual and CURRENT QUARTER data******************************************************
    @Query(value = """
            with actual_data as
            (SELECT report_date, ROUND(SUM( sb)::numeric, 2) as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2) td,\s
             ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit ,
             ROUND(SUM( advances)::numeric, 2)as advances , ROUND(SUM( total_business)::numeric, 2)as total_business,\s
             ROUND(SUM( total_retail)::numeric, 2)as total_retail, ROUND(SUM(
             housing)::numeric, 2)as housing , ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education,
             ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme, ROUND(SUM( gold)::numeric, 2)as gold,
             ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2)as npa
             FROM msso_branch_profile.msso_branches_actual_position where\s
             report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position ) \s
             GROUP BY report_date),
                        
             last_march_data as
             (SELECT report_date, ROUND(SUM( sb)::numeric, 2) as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2) td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit , ROUND(SUM( advances)::numeric, 2)as advances , ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail, ROUND(SUM(
             housing)::numeric, 2)as housing , ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education, ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme, ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2)as npa
             FROM msso_branch_profile.msso_branches_target where\s
             report_date= :quarterEndDate  \s
             GROUP BY report_date)
             
             select lm.report_date,(ad.sb-lm.sb) as sb,(ad.ca-lm.ca) as ca,(ad.td-lm.td )as td,(ad.casa-lm.casa) as casa,\s
             ad.deposit-lm.deposit as deposit,ad.advances-lm.advances as advances,ad.total_business-lm.total_business as total_business,
             ad.total_retail-lm.total_retail as total_retail,ad.housing-lm.housing as housing,ad.vehicle-lm.vehicle as vehicle,
             ad.education-lm.education as education,ad.agri-lm.agri as agri,ad.msme-lm.msme as msme,ad.gold-lm.gold as gold,ad.shg-lm.shg as shg,
             ad.total_ram-lm.total_ram as total_ram,ad.npa-lm.npa
             from actual_data ad,last_march_data lm  """, nativeQuery = true)
    public MssoBranchProfileTargetDataDto getBranchProfileHoGap(@Param("quarterEndDate") LocalDate quarterEndDate);

    @Query(value = """
                        with actual_data as(SELECT report_date, ROUND(SUM( sb)::numeric, 2)as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2)as td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit, ROUND(SUM( advances)::numeric, 2)as advances, ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail , ROUND(SUM(
                        housing)::numeric, 2)as housing, ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education , ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme , ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2) as npa
                        FROM msso_branch_profile.msso_branches_actual_position where  branch_code=:branchCode AND
                        report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position )  GROUP BY report_date\s
                       ),

            last_march_data as(SELECT report_date, ROUND(SUM( sb)::numeric, 2)as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2)as td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit, ROUND(SUM( advances)::numeric, 2)as advances, ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail , ROUND(SUM(
                        housing)::numeric, 2)as housing, ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education , ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme , ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2) as npa  FROM msso_branch_profile.msso_branches_target where  branch_code=:branchCode AND
            report_date= :quarterEndDate \s
            GROUP BY report_date)

            select lm.report_date,(ad.sb-lm.sb) as sb,(ad.ca-lm.ca) as ca,(ad.td-lm.td )as td,(ad.casa-lm.casa) as casa,\s
            ad.deposit-lm.deposit as deposit,ad.advances-lm.advances as advances,ad.total_business-lm.total_business as total_business,
            ad.total_retail-lm.total_retail as total_retail,ad.housing-lm.housing as housing,ad.vehicle-lm.vehicle as vehicle,
            ad.education-lm.education as education,ad.agri-lm.agri as agri,ad.msme-lm.msme as msme,ad.gold-lm.gold as gold,ad.shg-lm.shg as shg,
            ad.total_ram-lm.total_ram as total_ram,ad.npa-lm.npa
            from actual_data ad,last_march_data lm  """, nativeQuery = true)
    public MssoBranchProfileTargetDataDto getBranchProfileBranchGap(@Param("branchCode") String branchCode,@Param("quarterEndDate")LocalDate quarterEndDate);
    @Query(value = """
                        with actual_data as(SELECT report_date, ROUND(SUM( sb)::numeric, 2)as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2)as td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit, ROUND(SUM( advances)::numeric, 2)as advances, ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail , ROUND(SUM(
                        housing)::numeric, 2)as housing, ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education , ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme , ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2) as npa
                        FROM msso_branch_profile.msso_branches_actual_position where  region=:roname AND
                        report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position )  GROUP BY report_date\s
                       ),

            last_march_data as(SELECT report_date, ROUND(SUM( sb)::numeric, 2)as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2)as td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit, ROUND(SUM( advances)::numeric, 2)as advances, ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail , ROUND(SUM(
                        housing)::numeric, 2)as housing, ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education , ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme , ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2) as npa  FROM msso_branch_profile.msso_branches_target where  region=:roname AND
            report_date= :quarterEndDate \s
            GROUP BY report_date)

            select lm.report_date,(ad.sb-lm.sb) as sb,(ad.ca-lm.ca) as ca,(ad.td-lm.td )as td,(ad.casa-lm.casa) as casa,\s
            ad.deposit-lm.deposit as deposit,ad.advances-lm.advances as advances,ad.total_business-lm.total_business as total_business,
            ad.total_retail-lm.total_retail as total_retail,ad.housing-lm.housing as housing,ad.vehicle-lm.vehicle as vehicle,
            ad.education-lm.education as education,ad.agri-lm.agri as agri,ad.msme-lm.msme as msme,ad.gold-lm.gold as gold,ad.shg-lm.shg as shg,
            ad.total_ram-lm.total_ram as total_ram,ad.npa-lm.npa
            from actual_data ad,last_march_data lm  """, nativeQuery = true)
    public MssoBranchProfileTargetDataDto getBranchProfileRoGap(@Param("roname") String roname,@Param("quarterEndDate")LocalDate quarterEndDate);


}
