package com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualData;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RepoMssoBranchProfileActualData extends JpaRepository<MssoBranchProfileActualData, Long> {


    //*******************************************************Actual data ******************************************************

    @Query(value = """
             SELECT report_date, ROUND(SUM( sb)::numeric, 2) as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2) td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit , ROUND(SUM( advances)::numeric, 2)as advances , ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail, ROUND(SUM(
            housing)::numeric, 2)as housing , ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education, ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme, ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2)as npa
            FROM msso_branch_profile.msso_branches_actual_position where 
            report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position )  
            GROUP BY report_date ; """, nativeQuery = true)
    public MssoBranchProfileActualDataDto getBranchProfileHo();


    @Query(value = """
            SELECT report_date, ROUND(SUM( sb*100)::numeric, 2), ROUND(SUM( ca*100)::numeric, 2), ROUND(SUM( td*100)::numeric, 2), ROUND(SUM( casa*100)::numeric, 2), ROUND(SUM( deposit*100)::numeric, 2), ROUND(SUM( advances*100)::numeric, 2), ROUND(SUM( total_business*100)::numeric, 2), ROUND(SUM( total_retail*100)::numeric, 2), ROUND(SUM(
                   housing*100)::numeric, 2), ROUND(SUM( vehicle*100)::numeric, 2), ROUND(SUM( education*100)::numeric, 2), ROUND(SUM( agri*100)::numeric, 2), ROUND(SUM( msme*100)::numeric, 2), ROUND(SUM( gold*100)::numeric, 2), ROUND(SUM( shg*100)::numeric, 2), ROUND(SUM( total_ram*100)::numeric, 2), ROUND(SUM( npa*100)::numeric, 2)
                   FROM msso_branch_profile.msso_branches_actual_position where  branch_code=:branchCode AND
                   report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position )  GROUP BY report_date ;
                   """, nativeQuery = true)
    public MssoBranchProfileActualDataDto getBranchProfileBranch(@Param("branchCode") String branchCode);

    @Query(value = """
            SELECT report_date, ROUND(SUM( sb)::numeric, 2), ROUND(SUM( ca)::numeric, 2), ROUND(SUM( td)::numeric, 2), ROUND(SUM( casa)::numeric, 2), ROUND(SUM( deposit)::numeric, 2), ROUND(SUM( advances)::numeric, 2), ROUND(SUM( total_business)::numeric, 2), ROUND(SUM( total_retail)::numeric, 2), ROUND(SUM(
            housing)::numeric, 2), ROUND(SUM( vehicle)::numeric, 2), ROUND(SUM( education)::numeric, 2), ROUND(SUM( agri)::numeric, 2), ROUND(SUM( msme)::numeric, 2), ROUND(SUM( gold)::numeric, 2), ROUND(SUM( shg)::numeric, 2), ROUND(SUM( total_ram)::numeric, 2), ROUND(SUM( npa)::numeric, 2)
            FROM msso_branch_profile.msso_branches_actual_position where  REGION=:roname AND
            report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position )  
            GROUP BY report_date ; 
             """, nativeQuery = true)
    public MssoBranchProfileActualDataDto getBranchProfileRO(@Param("roname") String roname);

    //*******************************************************last three years data******************************************************

    @Query(value = """
             SELECT report_date, ROUND(SUM( sb)::numeric, 2) as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2) td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit , ROUND(SUM( advances)::numeric, 2)as advances , ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail, ROUND(SUM(
            housing)::numeric, 2)as housing , ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education, ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme, ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2)as npa
            FROM msso_branch_profile.msso_branches_actual_position where 
            report_date IN (:marchEndDates)  GROUP BY report_date order by report_date ; """, nativeQuery = true)
    public List<MssoBranchProfileActualDataDto> getBranchProfileHoMarchData(@Param("marchEndDates") List<LocalDate> marchEndDates);

    @Query(value = """
            SELECT report_date, ROUND(SUM( sb*100)::numeric, 2), ROUND(SUM( ca*100)::numeric, 2), ROUND(SUM( td*100)::numeric, 2), ROUND(SUM( casa*100)::numeric, 2), ROUND(SUM( deposit*100)::numeric, 2), ROUND(SUM( advances*100)::numeric, 2), ROUND(SUM( total_business*100)::numeric, 2), ROUND(SUM( total_retail*100)::numeric, 2), ROUND(SUM(
                   housing*100)::numeric, 2), ROUND(SUM( vehicle*100)::numeric, 2), ROUND(SUM( education*100)::numeric, 2), ROUND(SUM( agri*100)::numeric, 2), ROUND(SUM( msme*100)::numeric, 2), ROUND(SUM( gold*100)::numeric, 2), ROUND(SUM( shg*100)::numeric, 2), ROUND(SUM( total_ram*100)::numeric, 2), ROUND(SUM( npa*100)::numeric, 2)
                   FROM msso_branch_profile.msso_branches_actual_position where  branch_code=:branchCode AND
                   report_date IN (:marchEndDates)   GROUP BY report_date order by report_date  ;
                   """, nativeQuery = true)
    public List<MssoBranchProfileActualDataDto> getBranchProfileBranchMarchData(@Param("branchCode") String branchCode, @Param("marchEndDates") List<LocalDate> marchEndDates);

    @Query(value = """
            SELECT report_date, ROUND(SUM( sb)::numeric, 2), ROUND(SUM( ca)::numeric, 2), ROUND(SUM( td)::numeric, 2), ROUND(SUM( casa)::numeric, 2), ROUND(SUM( deposit)::numeric, 2), ROUND(SUM( advances)::numeric, 2), ROUND(SUM( total_business)::numeric, 2), ROUND(SUM( total_retail)::numeric, 2), ROUND(SUM(
            housing)::numeric, 2), ROUND(SUM( vehicle)::numeric, 2), ROUND(SUM( education)::numeric, 2), ROUND(SUM( agri)::numeric, 2), ROUND(SUM( msme)::numeric, 2), ROUND(SUM( gold)::numeric, 2), ROUND(SUM( shg)::numeric, 2), ROUND(SUM( total_ram)::numeric, 2), ROUND(SUM( npa)::numeric, 2)
            FROM msso_branch_profile.msso_branches_actual_position where  REGION=:roname AND
            report_date IN (:marchEndDates)   GROUP BY report_date order by report_date  ;  """, nativeQuery = true)
    public List<MssoBranchProfileActualDataDto> getBranchProfileROMarchData(@Param("roname") String roname, @Param("marchEndDates") List<LocalDate> marchEndDates);

    //*******************************************************gap between actual and last years march data******************************************************
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
             FROM msso_branch_profile.msso_branches_actual_position where
             report_date= :marchEndDates  
             GROUP BY report_date)
             
             select lm.report_date,(ad.sb-lm.sb) as sb,(ad.ca-lm.ca) as ca,(ad.td-lm.td )as td,(ad.casa-lm.casa) as casa,
             ad.deposit-lm.deposit as deposit,ad.advances-lm.advances as advances,ad.total_business-lm.total_business as total_business,
             ad.total_retail-lm.total_retail as total_retail,ad.housing-lm.housing as housing,ad.vehicle-lm.vehicle as vehicle,
             ad.education-lm.education as education,ad.agri-lm.agri as agri,ad.msme-lm.msme as msme,ad.gold-lm.gold as gold,ad.shg-lm.shg as shg,
             ad.total_ram-lm.total_ram as total_ram,ad.npa-lm.npa
             from actual_data ad,last_march_data lm  """, nativeQuery = true)
    public MssoBranchProfileActualDataDto getBranchProfileHoGap(@Param("marchEndDates") LocalDate marchEndDates);

    @Query(value = """
            with actual_data as(SELECT report_date, ROUND(SUM( sb*100)::numeric, 2)as sb, ROUND(SUM( ca*100)::numeric, 2)as ca, ROUND(SUM( td*100)::numeric, 2)as td, ROUND(SUM( casa*100)::numeric, 2)as casa, ROUND(SUM( deposit*100)::numeric, 2)as deposit, ROUND(SUM( advances*100)::numeric, 2)as advances, ROUND(SUM( total_business*100)::numeric, 2)as total_business, ROUND(SUM( total_retail*100)::numeric, 2)as total_retail , ROUND(SUM(
                        housing*100)::numeric, 2)as housing, ROUND(SUM( vehicle*100)::numeric, 2) as vehicle, ROUND(SUM( education*100)::numeric, 2)as education , ROUND(SUM( agri*100)::numeric, 2)as agri, ROUND(SUM( msme*100)::numeric, 2)as msme , ROUND(SUM( gold*100)::numeric, 2)as gold, ROUND(SUM( shg*100)::numeric, 2)as shg, ROUND(SUM( total_ram*100)::numeric, 2)as total_ram , ROUND(SUM( npa*100)::numeric, 2) as npa
                        FROM msso_branch_profile.msso_branches_actual_position where  branch_code=:branchCode AND
                        report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position )  GROUP BY report_date
                       ),                     
            last_march_data as(SELECT report_date, ROUND(SUM( sb*100)::numeric, 2)as sb, ROUND(SUM( ca*100)::numeric, 2)as ca, ROUND(SUM( td*100)::numeric, 2)as td, ROUND(SUM( casa*100)::numeric, 2)as casa, ROUND(SUM( deposit*100)::numeric, 2)as deposit, ROUND(SUM( advances*100)::numeric, 2)as advances, ROUND(SUM( total_business*100)::numeric, 2)as total_business, ROUND(SUM( total_retail*100)::numeric, 2)as total_retail , ROUND(SUM(
                        housing*100)::numeric, 2)as housing, ROUND(SUM( vehicle*100)::numeric, 2) as vehicle, ROUND(SUM( education*100)::numeric, 2)as education , ROUND(SUM( agri*100)::numeric, 2)as agri, ROUND(SUM( msme*100)::numeric, 2)as msme , ROUND(SUM( gold*100)::numeric, 2)as gold, ROUND(SUM( shg*100)::numeric, 2)as shg, ROUND(SUM( total_ram*100)::numeric, 2)as total_ram , ROUND(SUM( npa*100)::numeric, 2) as npa  FROM msso_branch_profile.msso_branches_actual_position where  branch_code=:branchCode AND
            report_date= :marchEndDates 
            GROUP BY report_date)
                                                
            select lm.report_date,(ad.sb-lm.sb) as sb,(ad.ca-lm.ca) as ca,(ad.td-lm.td )as td,(ad.casa-lm.casa) as casa,
            ad.deposit-lm.deposit as deposit,ad.advances-lm.advances as advances,ad.total_business-lm.total_business as total_business,
            ad.total_retail-lm.total_retail as total_retail,ad.housing-lm.housing as housing,ad.vehicle-lm.vehicle as vehicle,
            ad.education-lm.education as education,ad.agri-lm.agri as agri,ad.msme-lm.msme as msme,ad.gold-lm.gold as gold,ad.shg-lm.shg as shg,
            ad.total_ram-lm.total_ram as total_ram,ad.npa-lm.npa
            from actual_data ad,last_march_data lm """, nativeQuery = true)
    public MssoBranchProfileActualDataDto getBranchProfileBranchGap(@Param("branchCode") String branchCode,@Param("marchEndDates")LocalDate marchEndDates);
    @Query(value = """
                        with actual_data as(SELECT report_date, ROUND(SUM( sb)::numeric, 2)as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2)as td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit, ROUND(SUM( advances)::numeric, 2)as advances, ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail , ROUND(SUM(
                        housing)::numeric, 2)as housing, ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education , ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme , ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2) as npa
                        FROM msso_branch_profile.msso_branches_actual_position where  region=:roname AND
                        report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position )  GROUP BY report_date
                       ),

            last_march_data as(SELECT report_date, ROUND(SUM( sb)::numeric, 2)as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2)as td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit, ROUND(SUM( advances)::numeric, 2)as advances, ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail , ROUND(SUM(
                        housing)::numeric, 2)as housing, ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education , ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme , ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2) as npa  FROM msso_branch_profile.msso_branches_actual_position where  region=:roname AND
            report_date= :marchEndDates 
            GROUP BY report_date)

            select lm.report_date,(ad.sb-lm.sb) as sb,(ad.ca-lm.ca) as ca,(ad.td-lm.td )as td,(ad.casa-lm.casa) as casa,
            ad.deposit-lm.deposit as deposit,ad.advances-lm.advances as advances,ad.total_business-lm.total_business as total_business,
            ad.total_retail-lm.total_retail as total_retail,ad.housing-lm.housing as housing,ad.vehicle-lm.vehicle as vehicle,
            ad.education-lm.education as education,ad.agri-lm.agri as agri,ad.msme-lm.msme as msme,ad.gold-lm.gold as gold,ad.shg-lm.shg as shg,
            ad.total_ram-lm.total_ram as total_ram,ad.npa-lm.npa
            from actual_data ad,last_march_data lm  """, nativeQuery = true)
    public MssoBranchProfileActualDataDto getBranchProfileRoGap(@Param("roname") String roname,@Param("marchEndDates")LocalDate marchEndDates);
    //*******************************************************percentage gap between actual and last years march data******************************************************
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
             FROM msso_branch_profile.msso_branches_actual_position where
             report_date= :marchEndDates  
             GROUP BY report_date)
             
             SELECT
                lm.report_date,
                ROUND(CASE WHEN ad.sb = 0 OR ad.sb IS NULL THEN NULL ELSE ((ad.sb - lm.sb) / lm.sb::numeric) * 100 END, 2) AS sb,
                ROUND(CASE WHEN ad.ca = 0 OR ad.ca IS NULL THEN NULL ELSE ((ad.ca - lm.ca) / lm.ca::numeric) * 100 END, 2) AS ca,
                ROUND(CASE WHEN ad.td = 0 OR ad.td IS NULL THEN NULL ELSE ((ad.td - lm.td) / lm.td::numeric) * 100 END, 2) AS td,
                ROUND(CASE WHEN ad.casa = 0 OR ad.casa IS NULL THEN NULL ELSE ((ad.casa - lm.casa) / lm.casa::numeric) * 100 END, 2) AS casa,
                ROUND(CASE WHEN ad.deposit = 0 OR ad.deposit IS NULL THEN NULL ELSE ((ad.deposit - lm.deposit) / lm.deposit::numeric) * 100 END, 2) AS deposit,
                ROUND(CASE WHEN ad.advances = 0 OR ad.advances IS NULL THEN NULL ELSE ((ad.advances - lm.advances) / lm.advances::numeric) * 100 END, 2) AS advances,
                ROUND(CASE WHEN ad.total_business = 0 OR ad.total_business IS NULL THEN NULL ELSE ((ad.total_business - lm.total_business) / lm.total_business::numeric) * 100 END, 2) AS total_business,
                ROUND(CASE WHEN ad.total_retail = 0 OR ad.total_retail IS NULL THEN NULL ELSE ((ad.total_retail - lm.total_retail) / lm.total_retail::numeric) * 100 END, 2) AS total_retail,
                ROUND(CASE WHEN ad.housing = 0 OR ad.housing IS NULL THEN NULL ELSE ((ad.housing - lm.housing) / lm.housing::numeric) * 100 END, 2) AS housing,
                ROUND(CASE WHEN ad.vehicle = 0 OR ad.vehicle IS NULL THEN NULL ELSE ((ad.vehicle - lm.vehicle) / lm.vehicle::numeric) * 100 END, 2) AS vehicle,
                ROUND(CASE WHEN ad.education = 0 OR ad.education IS NULL THEN NULL ELSE ((ad.education - lm.education) / lm.education::numeric) * 100 END, 2) AS education,
                ROUND(CASE WHEN ad.agri = 0 OR ad.agri IS NULL THEN NULL ELSE ((ad.agri - lm.agri) / lm.agri::numeric) * 100 END, 2) AS agri,
                ROUND(CASE WHEN ad.msme = 0 OR ad.msme IS NULL THEN NULL ELSE ((ad.msme - lm.msme) / lm.msme::numeric) * 100 END, 2) AS msme,
                ROUND(CASE WHEN ad.gold = 0 OR ad.gold IS NULL THEN NULL ELSE ((ad.gold - lm.gold) / lm.gold::numeric) * 100 END, 2) AS gold,
                ROUND(CASE WHEN ad.shg = 0 OR ad.shg IS NULL THEN NULL ELSE ((ad.shg - lm.shg) / lm.shg::numeric) * 100 END, 2) AS shg,
                ROUND(CASE WHEN ad.total_ram = 0 OR ad.total_ram IS NULL THEN NULL ELSE ((ad.total_ram - lm.total_ram) / lm.total_ram::numeric) * 100 END, 2) AS total_ram,
                ROUND( CASE  WHEN ad.npa = 0 OR ad.npa IS NULL THEN NULL ELSE ((ad.npa - lm.npa) / lm.npa::numeric) * 100 END,  2) AS npa
            FROM actual_data ad, last_march_data lm """, nativeQuery = true)
    public MssoBranchProfileActualDataDto getBranchProfileHoGapPercentage(@Param("marchEndDates") LocalDate marchEndDates);

    @Query(value = """
                        with actual_data as(SELECT report_date, ROUND(SUM( sb)::numeric, 2)as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2)as td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit, ROUND(SUM( advances)::numeric, 2)as advances, ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail , ROUND(SUM(
                        housing)::numeric, 2)as housing, ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education , ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme , ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2) as npa
                        FROM msso_branch_profile.msso_branches_actual_position where  branch_code=:branchCode AND
                        report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position )  GROUP BY report_date
                       ),

            last_march_data as(SELECT report_date, ROUND(SUM( sb)::numeric, 2)as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2)as td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit, ROUND(SUM( advances)::numeric, 2)as advances, ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail , ROUND(SUM(
                        housing)::numeric, 2)as housing, ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education , ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme , ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2) as npa  FROM msso_branch_profile.msso_branches_actual_position where  branch_code=:branchCode AND
            report_date= :marchEndDates 
            GROUP BY report_date)

             SELECT
                lm.report_date,
                ROUND(CASE WHEN ad.sb = 0 OR ad.sb IS NULL THEN NULL ELSE ((ad.sb - lm.sb) / lm.sb::numeric) * 100 END, 2) AS sb,
                ROUND(CASE WHEN ad.ca = 0 OR ad.ca IS NULL THEN NULL ELSE ((ad.ca - lm.ca) / lm.ca::numeric) * 100 END, 2) AS ca,
                ROUND(CASE WHEN ad.td = 0 OR ad.td IS NULL THEN NULL ELSE ((ad.td - lm.td) / lm.td::numeric) * 100 END, 2) AS td,
                ROUND(CASE WHEN ad.casa = 0 OR ad.casa IS NULL THEN NULL ELSE ((ad.casa - lm.casa) / lm.casa::numeric) * 100 END, 2) AS casa,
                ROUND(CASE WHEN ad.deposit = 0 OR ad.deposit IS NULL THEN NULL ELSE ((ad.deposit - lm.deposit) / lm.deposit::numeric) * 100 END, 2) AS deposit,
                ROUND(CASE WHEN ad.advances = 0 OR ad.advances IS NULL THEN NULL ELSE ((ad.advances - lm.advances) / lm.advances::numeric) * 100 END, 2) AS advances,
                ROUND(CASE WHEN ad.total_business = 0 OR ad.total_business IS NULL THEN NULL ELSE ((ad.total_business - lm.total_business) / lm.total_business::numeric) * 100 END, 2) AS total_business,
                ROUND(CASE WHEN ad.total_retail = 0 OR ad.total_retail IS NULL THEN NULL ELSE ((ad.total_retail - lm.total_retail) / lm.total_retail::numeric) * 100 END, 2) AS total_retail,
                ROUND(CASE WHEN ad.housing = 0 OR ad.housing IS NULL THEN NULL ELSE ((ad.housing - lm.housing) / lm.housing::numeric) * 100 END, 2) AS housing,
                ROUND(CASE WHEN ad.vehicle = 0 OR ad.vehicle IS NULL THEN NULL ELSE ((ad.vehicle - lm.vehicle) / lm.vehicle::numeric) * 100 END, 2) AS vehicle,
                ROUND(CASE WHEN ad.education = 0 OR ad.education IS NULL THEN NULL ELSE ((ad.education - lm.education) / lm.education::numeric) * 100 END, 2) AS education,
                ROUND(CASE WHEN ad.agri = 0 OR ad.agri IS NULL THEN NULL ELSE ((ad.agri - lm.agri) / lm.agri::numeric) * 100 END, 2) AS agri,
                ROUND(CASE WHEN ad.msme = 0 OR ad.msme IS NULL THEN NULL ELSE ((ad.msme - lm.msme) / lm.msme::numeric) * 100 END, 2) AS msme,
                ROUND(CASE WHEN ad.gold = 0 OR ad.gold IS NULL THEN NULL ELSE ((ad.gold - lm.gold) / lm.gold::numeric) * 100 END, 2) AS gold,
                ROUND(CASE WHEN ad.shg = 0 OR ad.shg IS NULL THEN NULL ELSE ((ad.shg - lm.shg) / lm.shg::numeric) * 100 END, 2) AS shg,
                ROUND(CASE WHEN ad.total_ram = 0 OR ad.total_ram IS NULL THEN NULL ELSE ((ad.total_ram - lm.total_ram) / lm.total_ram::numeric) * 100 END, 2) AS total_ram,
                ROUND( CASE  WHEN ad.npa = 0 OR ad.npa IS NULL THEN NULL ELSE ((ad.npa - lm.npa) / lm.npa::numeric) * 100 END,  2) AS npa
            FROM actual_data ad, last_march_data lm """, nativeQuery = true)
    public MssoBranchProfileActualDataDto getBranchProfileBranchGapPercentage(@Param("branchCode") String branchCode,@Param("marchEndDates")LocalDate marchEndDates);
    @Query(value = """
                        with actual_data as(SELECT report_date, ROUND(SUM( sb)::numeric, 2)as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2)as td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit, ROUND(SUM( advances)::numeric, 2)as advances, ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail , ROUND(SUM(
                        housing)::numeric, 2)as housing, ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education , ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme , ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2) as npa
                        FROM msso_branch_profile.msso_branches_actual_position where  region=:roname AND
                        report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position )  GROUP BY report_date
                       ),

            last_march_data as(SELECT report_date, ROUND(SUM( sb)::numeric, 2)as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2)as td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit, ROUND(SUM( advances)::numeric, 2)as advances, ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail , ROUND(SUM(
                        housing)::numeric, 2)as housing, ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education , ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme , ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2) as npa  FROM msso_branch_profile.msso_branches_actual_position where  region=:roname AND
            report_date= :marchEndDates 
            GROUP BY report_date)

             SELECT
                lm.report_date,
                ROUND(CASE WHEN ad.sb = 0 OR ad.sb IS NULL THEN NULL ELSE ((ad.sb - lm.sb) / lm.sb::numeric) * 100 END, 2) AS sb,
                ROUND(CASE WHEN ad.ca = 0 OR ad.ca IS NULL THEN NULL ELSE ((ad.ca - lm.ca) / lm.ca::numeric) * 100 END, 2) AS ca,
                ROUND(CASE WHEN ad.td = 0 OR ad.td IS NULL THEN NULL ELSE ((ad.td - lm.td) / lm.td::numeric) * 100 END, 2) AS td,
                ROUND(CASE WHEN ad.casa = 0 OR ad.casa IS NULL THEN NULL ELSE ((ad.casa - lm.casa) / lm.casa::numeric) * 100 END, 2) AS casa,
                ROUND(CASE WHEN ad.deposit = 0 OR ad.deposit IS NULL THEN NULL ELSE ((ad.deposit - lm.deposit) / lm.deposit::numeric) * 100 END, 2) AS deposit,
                ROUND(CASE WHEN ad.advances = 0 OR ad.advances IS NULL THEN NULL ELSE ((ad.advances - lm.advances) / lm.advances::numeric) * 100 END, 2) AS advances,
                ROUND(CASE WHEN ad.total_business = 0 OR ad.total_business IS NULL THEN NULL ELSE ((ad.total_business - lm.total_business) / lm.total_business::numeric) * 100 END, 2) AS total_business,
                ROUND(CASE WHEN ad.total_retail = 0 OR ad.total_retail IS NULL THEN NULL ELSE ((ad.total_retail - lm.total_retail) / lm.total_retail::numeric) * 100 END, 2) AS total_retail,
                ROUND(CASE WHEN ad.housing = 0 OR ad.housing IS NULL THEN NULL ELSE ((ad.housing - lm.housing) / lm.housing::numeric) * 100 END, 2) AS housing,
                ROUND(CASE WHEN ad.vehicle = 0 OR ad.vehicle IS NULL THEN NULL ELSE ((ad.vehicle - lm.vehicle) / lm.vehicle::numeric) * 100 END, 2) AS vehicle,
                ROUND(CASE WHEN ad.education = 0 OR ad.education IS NULL THEN NULL ELSE ((ad.education - lm.education) / lm.education::numeric) * 100 END, 2) AS education,
                ROUND(CASE WHEN ad.agri = 0 OR ad.agri IS NULL THEN NULL ELSE ((ad.agri - lm.agri) / lm.agri::numeric) * 100 END, 2) AS agri,
                ROUND(CASE WHEN ad.msme = 0 OR ad.msme IS NULL THEN NULL ELSE ((ad.msme - lm.msme) / lm.msme::numeric) * 100 END, 2) AS msme,
                ROUND(CASE WHEN ad.gold = 0 OR ad.gold IS NULL THEN NULL ELSE ((ad.gold - lm.gold) / lm.gold::numeric) * 100 END, 2) AS gold,
                ROUND(CASE WHEN ad.shg = 0 OR ad.shg IS NULL THEN NULL ELSE ((ad.shg - lm.shg) / lm.shg::numeric) * 100 END, 2) AS shg,
                ROUND(CASE WHEN ad.total_ram = 0 OR ad.total_ram IS NULL THEN NULL ELSE ((ad.total_ram - lm.total_ram) / lm.total_ram::numeric) * 100 END, 2) AS total_ram,
                ROUND( CASE  WHEN ad.npa = 0 OR ad.npa IS NULL THEN NULL ELSE ((ad.npa - lm.npa) / lm.npa::numeric) * 100 END,  2) AS npa
            FROM actual_data ad, last_march_data lm  """, nativeQuery = true)
    public MssoBranchProfileActualDataDto getBranchProfileRoGapPercentage(@Param("roname") String roname,@Param("marchEndDates")LocalDate marchEndDates);

}
