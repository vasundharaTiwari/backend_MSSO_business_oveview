package com.Msso.MssoBusinessBackend.Repository.RepoMssoBrachProfileSma;

import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileReviewRenewalDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.MssoBranchProfileSma;
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.MssoBranchProfileSmaDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileComplianceDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.MssoProfileNpaClassificationDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.SectorwiseNpaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepoMssoBranchProfileSma extends JpaRepository<MssoBranchProfileSma, Long> {

    //*******************************************************Daily sma data ******************************************************

    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric), 2) as total_amount ,sum(sma0_count)as sma0_count,round(sum( sma0_amount::numeric), 2) as sma0_amount ,
            sum(sma1_count)as sma1_count,round(sum( sma1_amount::numeric), 2) as sma1_amount ,sum(sma2_count)as sma2_count ,round(sum( sma2_amount::numeric), 2) as sma2_amount  \s
            FROM msso_branch_profile.msso_profile_sma_data
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_sma_data )  group by report_date; """, nativeQuery = true)
    public MssoBranchProfileSmaDto getDailySmaHo();


    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric)*100, 2) as total_amount ,sum(sma0_count)as sma0_count,round(sum( sma0_amount::numeric)*100, 2) as sma0_amount ,
             sum(sma1_count)as sma1_count,round(sum( sma1_amount::numeric)*100, 2) as sma1_amount ,sum(sma2_count)as sma2_count ,round(sum( sma2_amount::numeric)*100, 2) as sma2_amount  \s
             FROM msso_branch_profile.msso_profile_sma_data
             where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_sma_data ) and branch_code=:branchCode group by report_date;
             """, nativeQuery = true)
    public MssoBranchProfileSmaDto getDailySmaBranch(@Param("branchCode") String branchCode);

    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric), 2) as total_amount ,sum(sma0_count)as sma0_count,round(sum( sma0_amount::numeric), 2) as sma0_amount ,
            sum(sma1_count)as sma1_count,round(sum( sma1_amount::numeric), 2) as sma1_amount ,sum(sma2_count)as sma2_count ,round(sum( sma2_amount::numeric), 2) as sma2_amount  \s
            FROM msso_branch_profile.msso_profile_sma_data
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_sma_data )  and region=:roname group by report_date;
                                	
                                 ; 
             """, nativeQuery = true)
    public MssoBranchProfileSmaDto getDailySmaRO(@Param("roname") String roname);
    //*******************************************************Daily npa classification data ******************************************************

    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric), 2) as total_amount ,sum(substandard_count)as substandard_count ,round(sum( substandard_amount::numeric), 2) as substandard_amount ,sum(d0_count)as d0_count,round(sum( d0_amount::numeric), 2) as d0_amount ,
             sum(d1_count)as d1_count,round(sum( d1_amount::numeric), 2) as d1_amount ,sum(d2_count)as d2_count ,round(sum( d2_amount::numeric), 2) as d2_amount ,sum(lost_count)as lost_count ,round(sum( lost_amount::numeric), 2) as lost_amount  
             FROM msso_branch_profile.msso_profile_npa_classification
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_npa_classification )  group by report_date; """, nativeQuery = true)
    public MssoProfileNpaClassificationDto getNpaClassificationHo();


    @Query(value = """
          SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric)*100, 2) as total_amount ,sum(substandard_count)as substandard_count ,round(sum( substandard_amount::numeric)*100, 2) as substandard_amount ,sum(d0_count)as d0_count,round(sum( d0_amount::numeric)*100, 2) as d0_amount ,
             sum(d1_count)as d1_count,round(sum( d1_amount::numeric)*100, 2) as d1_amount ,sum(d2_count)as d2_count ,round(sum( d2_amount::numeric)*100, 2) as d2_amount ,sum(lost_count)as lost_count ,round(sum( lost_amount::numeric)*100, 2) as lost_amount  
             FROM msso_branch_profile.msso_profile_npa_classification
         
             where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_npa_classification ) and branch_code=:branchCode group by report_date;
             """, nativeQuery = true)
    public MssoProfileNpaClassificationDto getNpaClassificationBranch(@Param("branchCode") String branchCode);

    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric), 2) as total_amount ,sum(substandard_count)as substandard_count ,round(sum( substandard_amount::numeric), 2) as substandard_amount ,sum(d0_count)as d0_count,round(sum( d0_amount::numeric), 2) as d0_amount ,
             sum(d1_count)as d1_count,round(sum( d1_amount::numeric), 2) as d1_amount ,sum(d2_count)as d2_count ,round(sum( d2_amount::numeric), 2) as d2_amount ,sum(lost_count)as lost_count ,round(sum( lost_amount::numeric), 2) as lost_amount  
             FROM msso_branch_profile.msso_profile_npa_classification
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_npa_classification )  and region=:roname group by report_date;
                                	
                                 ; 
             """, nativeQuery = true)
    public MssoProfileNpaClassificationDto getNpaClassificationRO(@Param("roname") String roname);
    //*******************************************************Review renewal ******************************************************

    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric), 2) as total_amount,
            sum( total_count_nacc)as total_count_nacc ,round(sum( total_amount_nacc::numeric), 2) as total_amount_nacc\s  FROM msso_branch_profile.msso_profile_pending_review_renewal
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_pending_review_renewal )  group by report_date; 
            """, nativeQuery = true)
    public MssoProfileReviewRenewalDto getPendingRevieRenewalHo();


    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric)*100, 2) as total_amount ,
             sum( total_count_nacc)as total_count_nacc ,round(sum( total_amount_nacc::numeric)*100, 2) as total_amount_nacc\s FROM msso_branch_profile.msso_profile_pending_review_renewal
             where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_pending_review_renewal ) and branch_code=:branchCode group by report_date;
             """, nativeQuery = true)
    public MssoProfileReviewRenewalDto getPendingRevieRenewalBranch(@Param("branchCode") String branchCode);

    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric), 2) as total_amount ,
            sum( total_count_nacc)as total_count_nacc ,round(sum( total_amount_nacc::numeric), 2) as total_amount_nacc  FROM msso_branch_profile.msso_profile_pending_review_renewal
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_pending_review_renewal )  and region=:roname group by report_date;
                                	
                                 ; 
             """, nativeQuery = true)
    public MssoProfileReviewRenewalDto getPendingRevieRenewalRO(@Param("roname") String roname);
    //*******************************************************NPA SECTOR WISE ******************************************************

    @Query(value = """
            SELECT report_date,round(sum( total_os_amt::numeric), 2) as total_os_amt,sum( total_housing)as total_housing ,round(sum( housing_amt::numeric), 2) as housing_amt ,
            sum(total_natl)as total_natl ,round(sum( natl_amt::numeric), 2) as natl_amt ,sum(total_shg)as total_shg,
            round(sum( shg_amt::numeric), 2) as shg_amt ,
                sum(kcc_atl)as kcc_atl,round(sum( kcc_atl_amt::numeric), 2) as kcc_atl_amt ,sum(other)as other ,round(sum( other_amt::numeric), 2) as other_amt ,
                sum(nacc)as nacc ,round(sum( nacc_amt::numeric), 2) as nacc_amt \s
                FROM msso_branch_profile.sectorwise_npa
                 where  report_date=(select max(report_date) from msso_branch_profile.sectorwise_npa )  group by report_date   """, nativeQuery = true)
    public SectorwiseNpaDto getNpaSectorWiseHo();


    @Query(value = """
            SELECT report_date,round(sum( total_os_amt::numeric)*100, 2) as total_os_amt,sum( total_housing)as total_housing ,round(sum( housing_amt::numeric)*100, 2) as housing_amt ,
            sum(total_natl)as total_natl ,round(sum( natl_amt::numeric)*100, 2) as natl_amt ,sum(total_shg)as total_shg,
            round(sum( shg_amt::numeric)*100, 2) as shg_amt ,
            sum(kcc_atl)as kcc_atl,round(sum( kcc_atl_amt::numeric)*100, 2) as kcc_atl_amt ,sum(other)as other ,round(sum( other_amt::numeric)*100, 2) as other_amt ,
            sum(nacc)as nacc ,round(sum( nacc_amt::numeric)*100, 2) as nacc_amt \s
            FROM msso_branch_profile.sectorwise_npa
             where  report_date=(select max(report_date) from msso_branch_profile.sectorwise_npa ) and branch_code=:branchCode group by report_date;
             """, nativeQuery = true)
    public SectorwiseNpaDto getNpaSectorWiseBranch(@Param("branchCode") String branchCode);

    @Query(value = """
             SELECT report_date,round(sum( total_os_amt::numeric), 2) as total_os_amt,sum( total_housing)as total_housing ,round(sum( housing_amt::numeric), 2) as housing_amt ,
            sum(total_natl)as total_natl ,round(sum( natl_amt::numeric), 2) as natl_amt ,sum(total_shg)as total_shg,
            round(sum( shg_amt::numeric), 2) as shg_amt ,
                sum(kcc_atl)as kcc_atl,round(sum( kcc_atl_amt::numeric), 2) as kcc_atl_amt ,sum(other)as other ,round(sum( other_amt::numeric), 2) as other_amt ,
                sum(nacc)as nacc ,round(sum( nacc_amt::numeric), 2) as nacc_amt \s
                FROM msso_branch_profile.sectorwise_npa
                 where  report_date=(select max(report_date) from msso_branch_profile.sectorwise_npa ) and region=:roname group by report_date;
                                	
                                 ; 
             """, nativeQuery = true)
    public SectorwiseNpaDto getNpaSectorWiseRO(@Param("roname") String roname);

    //*******************************************************timebarred ******************************************************

    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric), 2) as total_amount  FROM msso_branch_profile.msso_profile_timebarred
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_timebarred )  group by report_date; 
            """, nativeQuery = true)
    public MssoProfileComplianceDto getTimebarredHo();


    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric), 2) as total_amount  FROM msso_branch_profile.msso_profile_timebarred
             where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_timebarred ) and branch_code=:branchCode group by report_date;
             """, nativeQuery = true)
    public MssoProfileComplianceDto getgetTimebarredBranch(@Param("branchCode") String branchCode);

    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric), 2) as total_amount  FROM msso_branch_profile.msso_profile_timebarred
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_timebarred )  and region=:roname group by report_date;
                                	
                                 ; 
             """, nativeQuery = true)
    public MssoProfileComplianceDto getgetTimebarredRO(@Param("roname") String roname);
}
