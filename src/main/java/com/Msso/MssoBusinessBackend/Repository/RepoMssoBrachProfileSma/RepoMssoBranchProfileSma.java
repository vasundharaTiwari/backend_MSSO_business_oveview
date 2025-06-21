package com.Msso.MssoBusinessBackend.Repository.RepoMssoBrachProfileSma;

import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileSma.MssoBranchProfileSma;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileSma.MssoBranchProfileSmaDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileComplianceDto;
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
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric), 2) as total_amount ,sum(sma0_count)as sma0_count,round(sum( sma0_amount::numeric), 2) as sma0_amount ,
             sum(sma1_count)as sma1_count,round(sum( sma1_amount::numeric), 2) as sma1_amount ,sum(sma2_count)as sma2_count ,round(sum( sma2_amount::numeric), 2) as sma2_amount  \s
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
    //*******************************************************Review renewal ******************************************************

    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric), 2) as total_amount  FROM msso_branch_profile.msso_profile_pending_review_renewal
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_pending_review_renewal )  group by report_date; 
            """, nativeQuery = true)
    public MssoProfileComplianceDto getPendingRevieRenewalHo();


    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric), 2) as total_amount  FROM msso_branch_profile.msso_profile_pending_review_renewal
             where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_pending_review_renewal ) and branch_code=:branchCode group by report_date;
             """, nativeQuery = true)
    public MssoProfileComplianceDto getPendingRevieRenewalBranch(@Param("branchCode") String branchCode);

    @Query(value = """
            SELECT report_date,sum( total_count)as total_count ,round(sum( total_amount::numeric), 2) as total_amount  FROM msso_branch_profile.msso_profile_pending_review_renewal
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_pending_review_renewal )  and region=:roname group by report_date;
                                	
                                 ; 
             """, nativeQuery = true)
    public MssoProfileComplianceDto getPendingRevieRenewalRO(@Param("roname") String roname);

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
