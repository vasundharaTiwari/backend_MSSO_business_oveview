package com.Msso.MssoBusinessBackend.Repository.RepoVisitReport;

import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.ExecutiveVisitingData;
import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.VisitingDataStaffDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileDisbursement.MssoProfileDailyDisburseDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileTargetDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoAccountStatusDigitalTargetDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileAccountStatusDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileDigitalProductDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoFiSchemeDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileComplianceDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileReviewRenewalDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface RepoVisitReport extends JpaRepository<ExecutiveVisitingData, Long> {


    @Query(value = """
            SELECT  * FROM msso_branch_profile.msso_profile_visit_report WHERE branch_code=:branchCode AND visit_date=:visit_date ;
            """, nativeQuery = true)
    public ExecutiveVisitingData getVisitData(@Param("branchCode") String branchCode, @Param("visit_date") LocalDate visit_date);



    //*******************************************************Visit summery******************************************************

    @Query(value = """
       select distinct region,count(*) from msso_branch_profile.msso_profile_visit_report group by region
            """, nativeQuery = true)
    public List<VisitingDataStaffDto> getVisitSummeryHo();


    @Query(value = """   
            select visit_date,branch_code,branch_name,region,visitor_name,visitor_region,visitor_branch_code,
            visitor_designation from msso_branch_profile.msso_profile_visit_report where branch_code=:branchCode ORDER BY visit_date DESC
             """, nativeQuery = true)
    public List<VisitingDataStaffDto> getVisitSummeryBranch(@Param("branchCode") String branchCode);

    @Query(value = """
            select visit_date,branch_code,branch_name,region,visitor_name,visitor_region,visitor_branch_code,
            visitor_designation from msso_branch_profile.msso_profile_visit_report where region=:roname ORDER BY BRANCH_CODE
            """, nativeQuery = true)
    public List<VisitingDataStaffDto> getVisitSummeryRO(@Param("roname") String roname);

    //**********************************************visit report sma *****************************************
    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric)*100, 2) as total_amount ,sum(sma0_count)as sma0_count,round(sum( sma0_amount::numeric)*100, 2) as sma0_amount ,
             sum(sma1_count)as sma1_count,round(sum( sma1_amount::numeric)*100, 2) as sma1_amount ,sum(sma2_count)as sma2_count ,round(sum( sma2_amount::numeric)*100, 2) as sma2_amount  
             FROM msso_branch_profile.msso_profile_sma_data
             where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_sma_data  where report_date <:visitDate) and branch_code=:branchCode group by report_date;
             """, nativeQuery = true)
    public MssoBranchProfileSmaDto getVisitReportSmaBranch(@Param("branchCode") String branchCode, @Param("visitDate") Date visitDate);

    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric), 2) as total_amount ,sum(sma0_count)as sma0_count,round(sum( sma0_amount::numeric), 2) as sma0_amount ,
            sum(sma1_count)as sma1_count,round(sum( sma1_amount::numeric), 2) as sma1_amount ,sum(sma2_count)as sma2_count ,round(sum( sma2_amount::numeric), 2) as sma2_amount  
            FROM msso_branch_profile.msso_profile_sma_data
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_sma_data  where report_date<:visitDate )  and region=:roname group by report_date;
                                	
                                 ; 
             """, nativeQuery = true)
    public MssoBranchProfileSmaDto getVisitReportSmaRO(@Param("roname") String roname, @Param("visitDate") Date visitDate);
    //*******************************************************NpaClassification

    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric)*100, 2) as total_amount ,sum(substandard_count)as substandard_count ,round(sum( substandard_amount::numeric)*100, 2) as substandard_amount ,sum(d0_count)as d0_count,round(sum( d0_amount::numeric)*100, 2) as d0_amount ,
               sum(d1_count)as d1_count,round(sum( d1_amount::numeric)*100, 2) as d1_amount ,sum(d2_count)as d2_count ,round(sum( d2_amount::numeric)*100, 2) as d2_amount ,sum(lost_count)as lost_count ,round(sum( lost_amount::numeric)*100, 2) as lost_amount  
               FROM msso_branch_profile.msso_profile_npa_classification
                     
               where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_npa_classification  where report_date<:visitDate) and branch_code=:branchCode group by report_date;
               """, nativeQuery = true)
    public MssoProfileNpaClassificationDto getVisitReportNpaClassificationBranch(@Param("branchCode") String branchCode, @Param("visitDate") Date visitDate);

    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric), 2) as total_amount ,sum(substandard_count)as substandard_count ,round(sum( substandard_amount::numeric), 2) as substandard_amount ,sum(d0_count)as d0_count,round(sum( d0_amount::numeric), 2) as d0_amount ,
             sum(d1_count)as d1_count,round(sum( d1_amount::numeric), 2) as d1_amount ,sum(d2_count)as d2_count ,round(sum( d2_amount::numeric), 2) as d2_amount ,sum(lost_count)as lost_count ,round(sum( lost_amount::numeric), 2) as lost_amount  
             FROM msso_branch_profile.msso_profile_npa_classification
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_npa_classification  where report_date<:visitDate )  and region=:roname group by report_date;
                                	
                                 ; 
             """, nativeQuery = true)
    public MssoProfileNpaClassificationDto getVisitReportNpaClassificationRO(@Param("roname") String roname, @Param("visitDate") Date visitDate);

    //*******************************************************RevieRenewal

    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric)*100, 2) as total_amount ,
             sum( total_count_nacc)as total_count_nacc ,round(sum( total_amount_nacc::numeric)*100, 2) as total_amount_nacc FROM msso_branch_profile.msso_profile_pending_review_renewal
             where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_pending_review_renewal where report_date<:visitDate ) and branch_code=:branchCode group by report_date;
             """, nativeQuery = true)
    public MssoProfileReviewRenewalDto getVisitReportRevieRenewalBranch(@Param("branchCode") String branchCode, @Param("visitDate") Date visitDate);

    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric), 2) as total_amount ,
            sum( total_count_nacc)as total_count_nacc ,round(sum( total_amount_nacc::numeric), 2) as total_amount_nacc  FROM msso_branch_profile.msso_profile_pending_review_renewal
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_pending_review_renewal where report_date<:visitDate )  and region=:roname group by report_date;
                                	
                                 ; 
             """, nativeQuery = true)
    public MssoProfileReviewRenewalDto getVisitReportRevieRenewalRO(@Param("roname") String roname, @Param("visitDate") Date visitDate);

    //*******************************************************NpaSector

    @Query(value = """
            SELECT report_date,round(sum( total_os_amt::numeric)*100, 2) as total_os_amt,sum( total_housing)as total_housing ,round(sum( housing_amt::numeric)*100, 2) as housing_amt ,
            sum(total_natl)as total_natl ,round(sum( natl_amt::numeric)*100, 2) as natl_amt ,sum(total_shg)as total_shg,
            round(sum( shg_amt::numeric)*100, 2) as shg_amt ,
            sum(kcc_atl)as kcc_atl,round(sum( kcc_atl_amt::numeric)*100, 2) as kcc_atl_amt ,sum(other)as other ,round(sum( other_amt::numeric)*100, 2) as other_amt ,
            sum(nacc)as nacc ,round(sum( nacc_amt::numeric)*100, 2) as nacc_amt 
            FROM msso_branch_profile.sectorwise_npa
             where  report_date=(select max(report_date) from msso_branch_profile.sectorwise_npa where report_date<:visitDate ) and branch_code=:branchCode group by report_date;
             """, nativeQuery = true)
    public SectorwiseNpaDto getNpaSectorVisitReportBranch(@Param("branchCode") String branchCode, @Param("visitDate") Date visitDate);

    @Query(value = """
             SELECT report_date,round(sum( total_os_amt::numeric), 2) as total_os_amt,sum( total_housing)as total_housing ,round(sum( housing_amt::numeric), 2) as housing_amt ,
            sum(total_natl)as total_natl ,round(sum( natl_amt::numeric), 2) as natl_amt ,sum(total_shg)as total_shg,
            round(sum( shg_amt::numeric), 2) as shg_amt ,
                sum(kcc_atl)as kcc_atl,round(sum( kcc_atl_amt::numeric), 2) as kcc_atl_amt ,sum(other)as other ,round(sum( other_amt::numeric), 2) as other_amt ,
                sum(nacc)as nacc ,round(sum( nacc_amt::numeric), 2) as nacc_amt 
                FROM msso_branch_profile.sectorwise_npa
                 where  report_date=(select max(report_date) from msso_branch_profile.sectorwise_npa where report_date<:visitDate) and region=:roname group by report_date;
                                	
                                 ; 
             """, nativeQuery = true)
    public SectorwiseNpaDto getNpaSectorVisitReportRO(@Param("roname") String roname, @Param("visitDate") Date visitDate);


    //*******************************************************NpaAmount

    @Query(value = """
            SELECT report_date,sum( total_count)as total_count,(sum( total_os_amt::numeric)*100) as total_os_amt,
                        sum( count_below_1lakh)as count_below_1lakh ,(sum( below_1lakh_amt::numeric)*100) as below_1lakh_amt ,
                        sum(count_below_3lakh)as count_below_3lakh ,(sum( below_3lakh_amt::numeric)*100) as below_3lakh_amt ,
                        sum(count_below_24lakh)as count_below_24lakh,(sum( below_24lakh_amt::numeric)*100) as below_24lakh_amt ,
                         sum(count_above_25lakh)as count_above_25lakh,(sum( above_25lakh_amt::numeric)*100) as above_25lakh_amt
                         FROM msso_branch_profile.amountwise_npa
                          where  report_date=(select max(report_date) from msso_branch_profile.amountwise_npa where report_date<:visitDate ) and branch_code=:branchCode group by report_date;
             """, nativeQuery = true)
    public AmountwiseNpaDto getNpaAmountVisitReportBranch(@Param("branchCode") String branchCode, @Param("visitDate") Date visitDate);

    @Query(value = """
            SELECT report_date,sum( total_count)as total_count,(sum( total_os_amt::numeric)) as total_os_amt,
             sum( count_below_1lakh)as count_below_1lakh ,(sum( below_1lakh_amt::numeric)) as below_1lakh_amt ,
             sum(count_below_3lakh)as count_below_3lakh ,(sum( below_3lakh_amt::numeric)) as below_3lakh_amt ,
             sum(count_below_24lakh)as count_below_24lakh,(sum( below_24lakh_amt::numeric)) as below_24lakh_amt ,
             sum(count_above_25lakh)as count_above_25lakh,(sum( above_25lakh_amt::numeric)) as above_25lakh_amt
             FROM msso_branch_profile.amountwise_npa
             where  report_date=(select max(report_date) from msso_branch_profile.amountwise_npa where report_date<:visitDate)and region=:roname group by report_date;
                               	
                                ; 
            """, nativeQuery = true)
    public AmountwiseNpaDto getNpaAmountVisitReportRO(@Param("roname") String roname, @Param("visitDate") Date visitDate);

    //*******************************************************NpaProgress regular

    @Query(value = """
             SELECT report_date,sum( addition_count)as addition_count,(sum( addition_os_amt::numeric)*100) as addition_os_amt,
            sum( upgrade_count)as upgrade_count ,(sum( upgrade_os_amt::numeric)*100) as upgrade_os_amt ,
               sum(recovered_count)as recovered_count ,(sum( recovered_os_amt::numeric)*100) as recovered_os_amt\s
               FROM msso_branch_profile.branch_npa_summary
               where  report_date=(select max(report_date) from msso_branch_profile.branch_npa_summary where report_date<:visitDate) and branch_code=:branchCode group by report_date;
              """, nativeQuery = true)
    public NpaRecoveryProgressDto getNpaProgressVisitReportBranch(@Param("branchCode") String branchCode, @Param("visitDate") Date visitDate);

    @Query(value = """
             SELECT report_date,sum( addition_count)as addition_count,(sum( addition_os_amt::numeric)) as addition_os_amt,
             sum( upgrade_count)as upgrade_count ,(sum( upgrade_os_amt::numeric)) as upgrade_os_amt ,
                sum(recovered_count)as recovered_count ,(sum( recovered_os_amt::numeric)) as recovered_os_amt\s
                FROM msso_branch_profile.branch_npa_summary
                where  report_date=(select max(report_date) from msso_branch_profile.branch_npa_summary where report_date<:visitDate) and region=:roname group by report_date;
                               	
                                ; 
            """, nativeQuery = true)
    public NpaRecoveryProgressDto getNpaProgressVisitReportRO(@Param("roname") String roname, @Param("visitDate") Date visitDate);

    //*******************************************************NpaProgressMarch ******************************************************



    @Query(value = """
             SELECT report_date,sum( addition_count)as addition_count,(sum( addition_os_amt::numeric)*100) as addition_os_amt,
            sum( upgrade_count)as upgrade_count ,(sum( upgrade_os_amt::numeric)*100) as upgrade_os_amt ,
               sum(recovered_count)as recovered_count ,(sum( recovered_os_amt::numeric)*100) as recovered_os_amt\s
               FROM msso_branch_profile.branch_npa_summary_march
               where  report_date=(select max(report_date) from msso_branch_profile.branch_npa_summary_march where report_date<:visitDate) and branch_code=:branchCode group by report_date;
              """, nativeQuery = true)
    public NpaRecoveryProgressDto getNpaProgressMarchVisitReportBranch(@Param("branchCode") String branchCode, @Param("visitDate") Date visitDate);

    @Query(value = """
             SELECT report_date,sum( addition_count)as addition_count,(sum( addition_os_amt::numeric)) as addition_os_amt,
             sum( upgrade_count)as upgrade_count ,(sum( upgrade_os_amt::numeric)) as upgrade_os_amt ,
                sum(recovered_count)as recovered_count ,(sum( recovered_os_amt::numeric)) as recovered_os_amt\s
                FROM msso_branch_profile.branch_npa_summary_march
                where  report_date=(select max(report_date) from msso_branch_profile.branch_npa_summary_march where report_date<:visitDate) and region=:roname group by report_date;
                               	
                                ; 
            """, nativeQuery = true)
    public NpaRecoveryProgressDto getNpaProgressMarchVisitReportRO(@Param("roname") String roname, @Param("visitDate") Date visitDate);

    //*******************************************************timebarred ******************************************************
    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric), 2) as total_amount  FROM msso_branch_profile.msso_profile_timebarred
             where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_timebarred where report_date<:visitDate) and branch_code=:branchCode group by report_date;
             """, nativeQuery = true)
    public MssoProfileComplianceDto getgetTimebarredVisitReportBranch(@Param("branchCode") String branchCode, @Param("visitDate") Date visitDate);

    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric), 2) as total_amount  FROM msso_branch_profile.msso_profile_timebarred
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_timebarred where report_date<:visitDate )  and region=:roname group by report_date;
                                	
                                 ; 
             """, nativeQuery = true)
    public MssoProfileComplianceDto getgetTimebarredVisitReportRO(@Param("roname") String roname, @Param("visitDate") Date visitDate);
//*******************************************************Actual data ******************************************************




    @Query(value = """
            SELECT report_date, ROUND(SUM( sb*100)::numeric, 2), ROUND(SUM( ca*100)::numeric, 2), ROUND(SUM( td*100)::numeric, 2), ROUND(SUM( casa*100)::numeric, 2), ROUND(SUM( deposit*100)::numeric, 2), ROUND(SUM( advances*100)::numeric, 2), ROUND(SUM( total_business*100)::numeric, 2), ROUND(SUM( total_retail*100)::numeric, 2), ROUND(SUM(
                   housing*100)::numeric, 2), ROUND(SUM( vehicle*100)::numeric, 2), ROUND(SUM( education*100)::numeric, 2), ROUND(SUM( agri*100)::numeric, 2), ROUND(SUM( msme*100)::numeric, 2), ROUND(SUM( gold*100)::numeric, 2), ROUND(SUM( shg*100)::numeric, 2), ROUND(SUM( total_ram*100)::numeric, 2), ROUND(SUM( npa*100)::numeric, 2)
                   FROM msso_branch_profile.msso_branches_actual_position where  branch_code=:branchCode AND
                   report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position where report_date<:visitDate )  GROUP BY report_date ;
                   """, nativeQuery = true)
    public MssoBranchProfileActualDataDto getBranchProfileVisitReportBranch(@Param("branchCode") String branchCode, @Param("visitDate") Date visitDate);

    @Query(value = """
            SELECT report_date, ROUND(SUM( sb)::numeric, 2), ROUND(SUM( ca)::numeric, 2), ROUND(SUM( td)::numeric, 2), ROUND(SUM( casa)::numeric, 2), ROUND(SUM( deposit)::numeric, 2), ROUND(SUM( advances)::numeric, 2), ROUND(SUM( total_business)::numeric, 2), ROUND(SUM( total_retail)::numeric, 2), ROUND(SUM(
            housing)::numeric, 2), ROUND(SUM( vehicle)::numeric, 2), ROUND(SUM( education)::numeric, 2), ROUND(SUM( agri)::numeric, 2), ROUND(SUM( msme)::numeric, 2), ROUND(SUM( gold)::numeric, 2), ROUND(SUM( shg)::numeric, 2), ROUND(SUM( total_ram)::numeric, 2), ROUND(SUM( npa)::numeric, 2)
            FROM msso_branch_profile.msso_branches_actual_position where  REGION=:roname AND
            report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position where report_date<:visitDate)  
            GROUP BY report_date ; 
             """, nativeQuery = true)
    public MssoBranchProfileActualDataDto getBranchProfileVisitReportRO(@Param("roname") String roname, @Param("visitDate") Date visitDate);


    //*******************************************************gap between actual and last years march data******************************************************

    @Query(value = """
            with actual_data as(SELECT report_date, ROUND(SUM( sb*100)::numeric, 2)as sb, ROUND(SUM( ca*100)::numeric, 2)as ca, ROUND(SUM( td*100)::numeric, 2)as td, ROUND(SUM( casa*100)::numeric, 2)as casa, ROUND(SUM( deposit*100)::numeric, 2)as deposit, ROUND(SUM( advances*100)::numeric, 2)as advances, ROUND(SUM( total_business*100)::numeric, 2)as total_business, ROUND(SUM( total_retail*100)::numeric, 2)as total_retail , ROUND(SUM(
                        housing*100)::numeric, 2)as housing, ROUND(SUM( vehicle*100)::numeric, 2) as vehicle, ROUND(SUM( education*100)::numeric, 2)as education , ROUND(SUM( agri*100)::numeric, 2)as agri, ROUND(SUM( msme*100)::numeric, 2)as msme , ROUND(SUM( gold*100)::numeric, 2)as gold, ROUND(SUM( shg*100)::numeric, 2)as shg, ROUND(SUM( total_ram*100)::numeric, 2)as total_ram , ROUND(SUM( npa*100)::numeric, 2) as npa
                        FROM msso_branch_profile.msso_branches_actual_position where  branch_code=:branchCode AND
                        report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position where report_date<:visitDate)  GROUP BY report_date
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
    public MssoBranchProfileActualDataDto getVisitReportMarchBranchGap(@Param("branchCode") String branchCode,@Param("marchEndDates")LocalDate marchEndDates, @Param("visitDate") Date visitDate);

    @Query(value = """
                        with actual_data as(SELECT report_date, ROUND(SUM( sb)::numeric, 2)as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2)as td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit, ROUND(SUM( advances)::numeric, 2)as advances, ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail , ROUND(SUM(
                        housing)::numeric, 2)as housing, ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education , ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme , ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2) as npa
                        FROM msso_branch_profile.msso_branches_actual_position where  region=:roname AND
                        report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position where report_date<:visitDate )  GROUP BY report_date
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
    public MssoBranchProfileActualDataDto getVisitReportMarchRoGap(@Param("roname") String roname,@Param("marchEndDates")LocalDate marchEndDates, @Param("visitDate") Date visitDate);
    //*******************************************************percentage gap between actual and last years march data******************************************************

    @Query(value = """
                        with actual_data as(SELECT report_date, ROUND(SUM( sb)::numeric, 2)as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2)as td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit, ROUND(SUM( advances)::numeric, 2)as advances, ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail , ROUND(SUM(
                        housing)::numeric, 2)as housing, ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education , ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme , ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2) as npa
                        FROM msso_branch_profile.msso_branches_actual_position where  branch_code=:branchCode AND
                        report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position where report_date<:visitDate)  GROUP BY report_date
                       ),

            last_march_data as(SELECT report_date, ROUND(SUM( sb)::numeric, 2)as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2)as td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit, ROUND(SUM( advances)::numeric, 2)as advances, ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail , ROUND(SUM(
                        housing)::numeric, 2)as housing, ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education , ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme , ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2) as npa  FROM msso_branch_profile.msso_branches_actual_position where  branch_code=:branchCode AND
            report_date= :marchEndDates 
            GROUP BY report_date)

             SELECT
                lm.report_date,
                ROUND(CASE WHEN lm.sb = 0 OR ad.sb IS NULL THEN NULL ELSE ((ad.sb - lm.sb) / lm.sb::numeric) * 100 END, 2) AS sb,
                ROUND(CASE WHEN lm.ca = 0 OR ad.ca IS NULL THEN NULL ELSE ((ad.ca - lm.ca) / lm.ca::numeric) * 100 END, 2) AS ca,
                ROUND(CASE WHEN lm .td = 0 OR ad.td IS NULL THEN NULL ELSE ((ad.td - lm.td) / lm.td::numeric) * 100 END, 2) AS td,
                ROUND(CASE WHEN lm.casa = 0 OR ad.casa IS NULL THEN NULL ELSE ((ad.casa - lm.casa) / lm.casa::numeric) * 100 END, 2) AS casa,
                ROUND(CASE WHEN lm.deposit = 0 OR ad.deposit IS NULL THEN NULL ELSE ((ad.deposit - lm.deposit) / lm.deposit::numeric) * 100 END, 2) AS deposit,
                ROUND(CASE WHEN lm.advances = 0 OR ad.advances IS NULL THEN NULL ELSE ((ad.advances - lm.advances) / lm.advances::numeric) * 100 END, 2) AS advances,
                ROUND(CASE WHEN lm.total_business = 0 OR ad.total_business IS NULL THEN NULL ELSE ((ad.total_business - lm.total_business) / lm.total_business::numeric) * 100 END, 2) AS total_business,
                ROUND(CASE WHEN lm.total_retail = 0 OR ad.total_retail IS NULL THEN NULL ELSE ((ad.total_retail - lm.total_retail) / lm.total_retail::numeric) * 100 END, 2) AS total_retail,
                ROUND(CASE WHEN lm.housing = 0 OR ad.housing IS NULL THEN NULL ELSE ((ad.housing - lm.housing) / lm.housing::numeric) * 100 END, 2) AS housing,
                ROUND(CASE WHEN lm.vehicle = 0 OR ad.vehicle IS NULL THEN NULL ELSE ((ad.vehicle - lm.vehicle) / lm.vehicle::numeric) * 100 END, 2) AS vehicle,
                ROUND(CASE WHEN lm.education = 0 OR ad.education IS NULL THEN NULL ELSE ((ad.education - lm.education) / lm.education::numeric) * 100 END, 2) AS education,
                ROUND(CASE WHEN lm.agri = 0 OR ad.agri IS NULL THEN NULL ELSE ((ad.agri - lm.agri) / lm.agri::numeric) * 100 END, 2) AS agri,
                ROUND(CASE WHEN lm.msme = 0 OR ad.msme IS NULL THEN NULL ELSE ((ad.msme - lm.msme) / lm.msme::numeric) * 100 END, 2) AS msme,
                ROUND(CASE WHEN lm.gold = 0 OR ad.gold IS NULL THEN NULL ELSE ((ad.gold - lm.gold) / lm.gold::numeric) * 100 END, 2) AS gold,
                ROUND(CASE WHEN lm.shg = 0 OR ad.shg IS NULL THEN NULL ELSE ((ad.shg - lm.shg) / lm.shg::numeric) * 100 END, 2) AS shg,
                ROUND(CASE WHEN lm.total_ram = 0 OR ad.total_ram IS NULL THEN NULL ELSE ((ad.total_ram - lm.total_ram) / lm.total_ram::numeric) * 100 END, 2) AS total_ram,
                ROUND( CASE  WHEN lm.npa = 0 OR ad.npa IS NULL THEN NULL ELSE ((ad.npa - lm.npa) / lm.npa::numeric) * 100 END,  2) AS npa
            FROM actual_data ad, last_march_data lm """, nativeQuery = true)
    public MssoBranchProfileActualDataDto getVisitReportMarchBranchGapPercentage(@Param("branchCode") String branchCode,@Param("marchEndDates")LocalDate marchEndDates, @Param("visitDate") Date visitDate);
    @Query(value = """
                        with actual_data as(SELECT report_date, ROUND(SUM( sb)::numeric, 2)as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2)as td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit, ROUND(SUM( advances)::numeric, 2)as advances, ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail , ROUND(SUM(
                        housing)::numeric, 2)as housing, ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education , ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme , ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2) as npa
                        FROM msso_branch_profile.msso_branches_actual_position where  region=:roname AND
                        report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position where report_date<:visitDate)  GROUP BY report_date
                       ),

            last_march_data as(SELECT report_date, ROUND(SUM( sb)::numeric, 2)as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2)as td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit, ROUND(SUM( advances)::numeric, 2)as advances, ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail , ROUND(SUM(
                        housing)::numeric, 2)as housing, ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education , ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme , ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2) as npa  FROM msso_branch_profile.msso_branches_actual_position where  region=:roname AND
            report_date= :marchEndDates 
            GROUP BY report_date)

             SELECT
                lm.report_date,
                ROUND(CASE WHEN lm.sb = 0 OR ad.sb IS NULL THEN NULL ELSE ((ad.sb - lm.sb) / lm.sb::numeric) * 100 END, 2) AS sb,
                ROUND(CASE WHEN lm.ca = 0 OR ad.ca IS NULL THEN NULL ELSE ((ad.ca - lm.ca) / lm.ca::numeric) * 100 END, 2) AS ca,
                ROUND(CASE WHEN lm .td = 0 OR ad.td IS NULL THEN NULL ELSE ((ad.td - lm.td) / lm.td::numeric) * 100 END, 2) AS td,
                ROUND(CASE WHEN lm.casa = 0 OR ad.casa IS NULL THEN NULL ELSE ((ad.casa - lm.casa) / lm.casa::numeric) * 100 END, 2) AS casa,
                ROUND(CASE WHEN lm.deposit = 0 OR ad.deposit IS NULL THEN NULL ELSE ((ad.deposit - lm.deposit) / lm.deposit::numeric) * 100 END, 2) AS deposit,
                ROUND(CASE WHEN lm.advances = 0 OR ad.advances IS NULL THEN NULL ELSE ((ad.advances - lm.advances) / lm.advances::numeric) * 100 END, 2) AS advances,
                ROUND(CASE WHEN lm.total_business = 0 OR ad.total_business IS NULL THEN NULL ELSE ((ad.total_business - lm.total_business) / lm.total_business::numeric) * 100 END, 2) AS total_business,
                ROUND(CASE WHEN lm.total_retail = 0 OR ad.total_retail IS NULL THEN NULL ELSE ((ad.total_retail - lm.total_retail) / lm.total_retail::numeric) * 100 END, 2) AS total_retail,
                ROUND(CASE WHEN lm.housing = 0 OR ad.housing IS NULL THEN NULL ELSE ((ad.housing - lm.housing) / lm.housing::numeric) * 100 END, 2) AS housing,
                ROUND(CASE WHEN lm.vehicle = 0 OR ad.vehicle IS NULL THEN NULL ELSE ((ad.vehicle - lm.vehicle) / lm.vehicle::numeric) * 100 END, 2) AS vehicle,
                ROUND(CASE WHEN lm.education = 0 OR ad.education IS NULL THEN NULL ELSE ((ad.education - lm.education) / lm.education::numeric) * 100 END, 2) AS education,
                ROUND(CASE WHEN lm.agri = 0 OR ad.agri IS NULL THEN NULL ELSE ((ad.agri - lm.agri) / lm.agri::numeric) * 100 END, 2) AS agri,
                ROUND(CASE WHEN lm.msme = 0 OR ad.msme IS NULL THEN NULL ELSE ((ad.msme - lm.msme) / lm.msme::numeric) * 100 END, 2) AS msme,
                ROUND(CASE WHEN lm.gold = 0 OR ad.gold IS NULL THEN NULL ELSE ((ad.gold - lm.gold) / lm.gold::numeric) * 100 END, 2) AS gold,
                ROUND(CASE WHEN lm.shg = 0 OR ad.shg IS NULL THEN NULL ELSE ((ad.shg - lm.shg) / lm.shg::numeric) * 100 END, 2) AS shg,
                ROUND(CASE WHEN lm.total_ram = 0 OR ad.total_ram IS NULL THEN NULL ELSE ((ad.total_ram - lm.total_ram) / lm.total_ram::numeric) * 100 END, 2) AS total_ram,
                ROUND( CASE  WHEN lm.npa = 0 OR ad.npa IS NULL THEN NULL ELSE ((ad.npa - lm.npa) / lm.npa::numeric) * 100 END,  2) AS npa
            FROM actual_data ad, last_march_data lm  """, nativeQuery = true)
    public MssoBranchProfileActualDataDto getVisitReportMarchRoGapPercentage(@Param("roname") String roname,@Param("marchEndDates")LocalDate marchEndDates, @Param("visitDate") Date visitDate);

    //*******************************************************gap between actual and CURRENT QUARTER data******************************************************

    @Query(value = """
            with actual_data as(SELECT report_date, ROUND(SUM( sb*100)::numeric, 2)as sb, ROUND(SUM( ca*100)::numeric, 2)as ca, ROUND(SUM( td*100)::numeric, 2)as td, ROUND(SUM( casa*100)::numeric, 2)as casa, ROUND(SUM( deposit*100)::numeric, 2)as deposit, ROUND(SUM( advances*100)::numeric, 2)as advances, ROUND(SUM( total_business*100)::numeric, 2)as total_business, ROUND(SUM( total_retail*100)::numeric, 2)as total_retail , ROUND(SUM(
   housing*100)::numeric, 2)as housing, ROUND(SUM( vehicle*100)::numeric, 2) as vehicle, ROUND(SUM( education*100)::numeric, 2)as education , ROUND(SUM( agri*100)::numeric, 2)as agri, ROUND(SUM( msme*100)::numeric, 2)as msme , ROUND(SUM( gold*100)::numeric, 2)as gold, ROUND(SUM( shg*100)::numeric, 2)as shg, ROUND(SUM( total_ram*100)::numeric, 2)as total_ram , ROUND(SUM( npa*100)::numeric, 2) as npa
   FROM msso_branch_profile.msso_branches_actual_position where  branch_code=:branchCode AND
   report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position where report_date<:visitDate )  GROUP BY report_date
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
    public MssoBranchProfileTargetDataDto getVisitReportQuarterBranchGap(@Param("branchCode") String branchCode, @Param("quarterEndDate") LocalDate quarterEndDate, @Param("visitDate") Date visitDate);

    @Query(value = """
                        with actual_data as(SELECT report_date, ROUND(SUM( sb)::numeric, 2)as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2)as td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit, ROUND(SUM( advances)::numeric, 2)as advances, ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail , ROUND(SUM(
                        housing)::numeric, 2)as housing, ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education , ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme , ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2) as npa
                        FROM msso_branch_profile.msso_branches_actual_position where  region=:roname AND
                        report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position where report_date<:visitDate)  GROUP BY report_date 
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
    public MssoBranchProfileTargetDataDto getVisitReportQuarterRoGap(@Param("roname") String roname, @Param("quarterEndDate") LocalDate quarterEndDate, @Param("visitDate") Date visitDate);
    //*******************************************************Daily Disbursement data ******************************************************



    @Query(value = """
            SELECT report_date, round(sum(total_advances::numeric)*100, 2) as total_advances, round(sum( total_os::numeric)*100, 2) as total_os ,sum( total_count)as total_count ,round(sum( retail::numeric)*100, 2) as retail ,sum( retail_count)as retail_count,round(sum( housing::numeric)*100, 2) as housing ,sum(
            housing_count)as housing_count, round(sum( vehicle::numeric)*100, 2) as vehicle,sum( vehicle_count)as vehicle_count,round(sum(  education::numeric)*100, 2) as education,sum( education_count)as education_count,round(sum(  agriculture::numeric)*100, 2) as agriculture, sum( agriculture_count)as agriculture_count,round(sum( msme::numeric)*100, 2) as msme,sum( msme_count)as msme_count,round(sum(  gold::numeric)*100, 2) as gold,sum( gold_count)as gold_count,round(sum(  shg::numeric)*100, 2) as shg,sum( shg_count)as shg_count
            ,round(sum(  pm_suryaghar::numeric)*100, 2) as pm_suryaghar,sum( pm_suryaghar_count)as pm_suryaghar_count,round(sum(  pmvishvakarma::numeric)*100, 2) as pmvishvakarma,sum( pmvishvakarma_count)as pmvishvakarma_count FROM msso_branch_profile.msso_profile_daily_disbursement
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_daily_disbursement  where report_date<:visitDate) and branch_code=:branchCode group by report_date;
             """, nativeQuery = true)
    public MssoProfileDailyDisburseDto getVisitReportDailyDisbursementBranch(@Param("branchCode") String branchCode, @Param("visitDate") Date visitDate);

    @Query(value = """
            SELECT report_date, round(sum(total_advances::numeric), 2) as total_advances, round(sum( total_os::numeric), 2) as total_os ,sum( total_count)as total_count ,round(sum( retail::numeric), 2) as retail ,sum( retail_count)as retail_count,round(sum( housing::numeric), 2) as housing ,sum(
            housing_count)as housing_count, round(sum( vehicle::numeric), 2) as vehicle,sum( vehicle_count)as vehicle_count,round(sum(  education::numeric), 2) as education,sum( education_count)as education_count,round(sum(  agriculture::numeric), 2) as agriculture, sum( agriculture_count)as agriculture_count,round(sum( msme::numeric), 2) as msme,sum( msme_count)as msme_count,round(sum(  gold::numeric), 2) as gold,sum( gold_count)as gold_count,round(sum(  shg::numeric), 2) as shg,sum( shg_count)as shg_count
            ,round(sum(  pm_suryaghar::numeric), 2) as pm_suryaghar,sum( pm_suryaghar_count)as pm_suryaghar_count,round(sum(  pmvishvakarma::numeric), 2) as pmvishvakarma,sum( pmvishvakarma_count)as pmvishvakarma_count FROM msso_branch_profile.msso_profile_daily_disbursement
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_daily_disbursement  where report_date<:visitDate) and region=:roname group by report_date;
                                	
                                 ; 
             """, nativeQuery = true)
    public MssoProfileDailyDisburseDto getVisitReportDailyDisbursementRO(@Param("roname") String roname, @Param("visitDate") Date visitDate);
    //*********************************************************DISBURSEMENT TARGET*****************************************


    @Query(value = """
            SELECT report_date, round(sum(total_advances::numeric)*100, 2) as total_advances, round(sum( total_os::numeric)*100, 2) as total_os ,sum( total_count)as total_count ,round(sum( retail::numeric)*100, 2) as retail ,sum( retail_count)as retail_count,round(sum( housing::numeric)*100, 2) as housing ,sum(
            housing_count)as housing_count, round(sum( vehicle::numeric)*100, 2) as vehicle,sum( vehicle_count)as vehicle_count,round(sum(  education::numeric)*100, 2) as education,sum( education_count)as education_count,round(sum(  agriculture::numeric)*100, 2) as agriculture, sum( agriculture_count)as agriculture_count,round(sum( msme::numeric)*100, 2) as msme,sum( msme_count)as msme_count,round(sum(  gold::numeric)*100, 2) as gold,sum( gold_count)as gold_count,round(sum(  shg::numeric)*100, 2) as shg,sum( shg_count)as shg_count
            ,round(sum(  pm_suryaghar::numeric)*100, 2) as pm_suryaghar,sum( pm_suryaghar_count)as pm_suryaghar_count,round(sum(  pmvishvakarma::numeric)*100, 2) as pmvishvakarma,sum( pmvishvakarma_count)as pmvishvakarma_count FROM msso_branch_profile.msso_profile_disbursement_target
            where  report_date=:quarterEnd  and branch_code=:branchCode group by report_date;
             """, nativeQuery = true)
    public MssoProfileDailyDisburseDto getVisitReportDailyDisbursementTargetBranch(@Param("branchCode") String branchCode,@Param("quarterEnd") Date quarterEnd);

    @Query(value = """
            SELECT report_date, round(sum(total_advances::numeric), 2) as total_advances, round(sum( total_os::numeric), 2) as total_os ,sum( total_count)as total_count ,round(sum( retail::numeric), 2) as retail ,sum( retail_count)as retail_count,round(sum( housing::numeric), 2) as housing ,sum(
            housing_count)as housing_count, round(sum( vehicle::numeric), 2) as vehicle,sum( vehicle_count)as vehicle_count,round(sum(  education::numeric), 2) as education,sum( education_count)as education_count,round(sum(  agriculture::numeric), 2) as agriculture, sum( agriculture_count)as agriculture_count,round(sum( msme::numeric), 2) as msme,sum( msme_count)as msme_count,round(sum(  gold::numeric), 2) as gold,sum( gold_count)as gold_count,round(sum(  shg::numeric), 2) as shg,sum( shg_count)as shg_count
            ,round(sum(  pm_suryaghar::numeric), 2) as pm_suryaghar,sum( pm_suryaghar_count)as pm_suryaghar_count,round(sum(  pmvishvakarma::numeric), 2) as pmvishvakarma,sum( pmvishvakarma_count)as pmvishvakarma_count FROM msso_branch_profile.msso_profile_disbursement_target
            where  report_date=:visitDate) and region=:roname group by report_date;
                                	
                                 ; 
             """, nativeQuery = true)
    public MssoProfileDailyDisburseDto getVisitReportDailyDisbursementTargetRO(@Param("roname") String roname,@Param("quarterEnd") Date quarterEnd);
//*******************************************************ACCOUNT digital data *********************************************************




    @Query(value = """
           SELECT report_date,sum( internet_banking)as internet_banking ,sum(mobile_banking)as mobile_banking,
                  sum(atm_card)as atm_card, sum(ckyc)as ckyc, sum(multiple_cif)as multiple_cif
                  FROM msso_branch_profile.msso_profile_digital_product
                  where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_digital_product where report_date<:visitDate) and branch_code=:branchCode  group by report_date;
                """, nativeQuery = true)
    public MssoBranchProfileDigitalProductDto getVisitReportDigitalproductBranch(@Param("branchCode") String branchCode, @Param("visitDate") Date visitDate);

    @Query(value = """
           SELECT report_date,sum( internet_banking)as internet_banking ,sum(mobile_banking)as mobile_banking,
                  sum(atm_card)as atm_card, sum(ckyc)as ckyc, sum(multiple_cif)as multiple_cif
                  FROM msso_branch_profile.msso_profile_digital_product
                  where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_digital_product where report_date<:visitDate) and REGION=:roname  group by report_date;
                """, nativeQuery = true)


    public MssoBranchProfileDigitalProductDto getVisitReportDigitalproductRO(@Param("roname") String roname, @Param("visitDate") Date visitDate);
    //************************************************************fi scheme **********************************



    @Query(value = """
             SELECT report_date,sum( pmjjby)as pmjjby ,sum(pmsby)as pmsby,sum( apy)as apy ,sum(pmjdy)as pmjdy
                                   FROM msso_branch_profile.msso_profile_fi_scheme
                                   where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_fi_scheme where report_date<:visitDate ) and branch_code=:branchCode  group by report_date;
                """, nativeQuery = true)
    public MssoFiSchemeDto getVisitReportFiSchemeBranch(@Param("branchCode") String branchCode, @Param("visitDate") Date visitDate);

    @Query(value = """
              SELECT report_date,sum( pmjjby)as pmjjby ,sum(pmsby)as pmsby,sum( apy)as apy ,sum(pmjdy)as pmjdy
                                   FROM msso_branch_profile.msso_profile_fi_scheme
                                   where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_fi_scheme where report_date<:visitDate)and REGION=:roname  group by report_date;
                """, nativeQuery = true)


    public MssoFiSchemeDto getVisitReportFiSchemeRO(@Param("roname") String roname, @Param("visitDate") Date visitDate);
    //************************************************************digital target**********************************



    @Query(value = """
            SELECT report_date,sum( sb_ac_count)as sb_ac_count ,sum(ca_ac_count)as ca_ac_count,sum( internet_banking)as internet_banking ,sum(mobile_banking)as mobile_banking,
                                   sum(atm_card)as atm_card
                                   FROM msso_branch_profile.msso_profile_account_digital_target
                                   where  report_date=:quarterDate and branch_code=:branchCode  group by report_date;\s
                """, nativeQuery = true)
    public MssoAccountStatusDigitalTargetDto getVisitReportAccountDigitalTargetBranch(@Param("branchCode") String branchCode, @Param("quarterDate") Date quarterDate);

    @Query(value = """
             SELECT report_date,sum( sb_ac_count)as sb_ac_count ,sum(ca_ac_count)as ca_ac_count,sum( internet_banking)as internet_banking ,sum(mobile_banking)as mobile_banking,
                                   sum(atm_card)as atm_card
                                   FROM msso_branch_profile.msso_profile_account_digital_target
                                   where  report_date=:quarterDate and REGION=:roname  group by report_date;\s
                """, nativeQuery = true)


    public MssoAccountStatusDigitalTargetDto getVisitReportAccountDigitalTargetRO(@Param("roname") String roname, @Param("quarterDate") Date quarterDate);
    //************************************************************fi scheme target**********************************


    @Query(value = """
             SELECT report_date,sum( pmjjby)as pmjjby ,sum(pmsby)as pmsby,sum( apy)as apy ,sum(pmjdy)as pmjdy
                                   FROM msso_branch_profile.msso_profile_fi_scheme_target
                                   where  report_date=:marchEnd and branch_code=:branchCode  group by report_date;\s
                """, nativeQuery = true)
    public MssoFiSchemeDto getVisitReportFiSchemeTargetBranch(@Param("branchCode") String branchCode, @Param("marchEnd") Date marchEnd);

    @Query(value = """
              SELECT report_date,sum( pmjjby)as pmjjby ,sum(pmsby)as pmsby,sum( apy)as apy ,sum(pmjdy)as pmjdy
                                   FROM msso_branch_profile.msso_profile_fi_scheme_target
                                   where  report_date=:marchEnd and REGION=:roname  group by report_date;\s
                """, nativeQuery = true)


    public MssoFiSchemeDto getVisitReportFiSchemeTargetRO(@Param("roname") String roname, @Param("marchEnd") Date marchEnd);
    //*******************************************************ACCOUNT STATUS data ******************************************************




    @Query(value = """
            SELECT report_date,sum( sb_ac_count)as sb_ac_count ,sum(ca_ac_count)as ca_ac_count,
            sum(casa_count)as casa_count, sum(pmjdy)as pmjdy,round(sum( casa_amount::numeric), 2) as casa_amount
		     
            FROM msso_branch_profile.msso_profile_account_status
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_account_status  where report_date<:visitDate) and branch_code=:branchCode  group by report_date;
                """, nativeQuery = true)
    public MssoBranchProfileAccountStatusDto getVisitReportAccountStatusBranch(@Param("branchCode") String branchCode, @Param("visitDate") Date visitDate);

    @Query(value = """
            SELECT report_date,sum( sb_ac_count)as sb_ac_count ,sum(ca_ac_count)as ca_ac_count,
            sum(casa_count)as casa_count, sum(pmjdy)as pmjdy,round(sum( casa_amount::numeric), 2) as casa_amount
            FROM msso_branch_profile.msso_profile_account_status
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_account_status  where report_date<:visitDate) and REGION=:roname  group by report_date;
                """, nativeQuery = true)


    public MssoBranchProfileAccountStatusDto getVisitReportAccountStatusRO(@Param("roname") String roname, @Param("visitDate") Date visitDate);
}
