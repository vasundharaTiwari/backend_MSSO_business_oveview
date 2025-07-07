package com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfileDailyDisbursement;

import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileDisbursement.MssoProfileDailyDisburseDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileDisbursement.MssoProfileDailyDisbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepoMssoBranchProfileDailyDisbursement extends JpaRepository<MssoProfileDailyDisbursement, Long> {
    //*******************************************************Daily Disbursement data ******************************************************

    @Query(value = """
            SELECT report_date, round(sum(total_advances::numeric), 2) as total_advances, round(sum( total_os::numeric), 2) as total_os ,sum( total_count)as total_count ,round(sum( retail::numeric), 2) as retail ,sum( retail_count)as retail_count,round(sum( housing::numeric), 2) as housing ,sum(
                                   housing_count)as housing_count, round(sum( vehicle::numeric), 2) as vehicle,sum( vehicle_count)as vehicle_count,round(sum(  education::numeric), 2) as education,sum( education_count)as education_count,round(sum(  agriculture::numeric), 2) as agriculture, sum( agriculture_count)as agriculture_count,round(sum( msme::numeric), 2) as msme,sum( msme_count)as msme_count,round(sum(  gold::numeric), 2) as gold,sum( gold_count)as gold_count,round(sum(  shg::numeric), 2) as shg,sum( shg_count)as shg_count
                               	FROM msso_branch_profile.msso_profile_daily_disbursement where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_daily_disbursement ) group by report_date;
                               	  """, nativeQuery = true)
    public MssoProfileDailyDisburseDto getDailyDisbursementHo();


    @Query(value = """
            SELECT report_date, round(sum(total_advances::numeric)*100, 2) as total_advances, round(sum( total_os::numeric)*100, 2) as total_os ,sum( total_count)as total_count ,round(sum( retail::numeric)*100, 2) as retail ,sum( retail_count)as retail_count,round(sum( housing::numeric)*100, 2) as housing ,sum(
            housing_count)as housing_count, round(sum( vehicle::numeric)*100, 2) as vehicle,sum( vehicle_count)as vehicle_count,round(sum(  education::numeric)*100, 2) as education,sum( education_count)as education_count,round(sum(  agriculture::numeric)*100, 2) as agriculture, sum( agriculture_count)as agriculture_count,round(sum( msme::numeric)*100, 2) as msme,sum( msme_count)as msme_count,round(sum(  gold::numeric)*100, 2) as gold,sum( gold_count)as gold_count,round(sum(  shg::numeric)*100, 2) as shg,sum( shg_count)as shg_count
            FROM msso_branch_profile.msso_profile_daily_disbursement\s
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_daily_disbursement ) and branch_code=:branchCode group by report_date;
             """, nativeQuery = true)
    public MssoProfileDailyDisburseDto getDailyDisbursementBranch(@Param("branchCode") String branchCode);

    @Query(value = """
            SELECT report_date, round(sum(total_advances::numeric), 2) as total_advances, round(sum( total_os::numeric), 2) as total_os ,sum( total_count)as total_count ,round(sum( retail::numeric), 2) as retail ,sum( retail_count)as retail_count,round(sum( housing::numeric), 2) as housing ,sum(
            housing_count)as housing_count, round(sum( vehicle::numeric), 2) as vehicle,sum( vehicle_count)as vehicle_count,round(sum(  education::numeric), 2) as education,sum( education_count)as education_count,round(sum(  agriculture::numeric), 2) as agriculture, sum( agriculture_count)as agriculture_count,round(sum( msme::numeric), 2) as msme,sum( msme_count)as msme_count,round(sum(  gold::numeric), 2) as gold,sum( gold_count)as gold_count,round(sum(  shg::numeric), 2) as shg,sum( shg_count)as shg_count
            FROM msso_branch_profile.msso_profile_daily_disbursement\s
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_daily_disbursement ) and region=:roname group by report_date;
                                	
                                 ; 
             """, nativeQuery = true)
    public MssoProfileDailyDisburseDto getDailyDisbursementRO(@Param("roname") String roname);
    //*********************************************************DISBURSEMENT TARGET

    @Query(value = """
            SELECT report_date, round(sum(total_advances::numeric), 2) as total_advances, round(sum( total_os::numeric), 2) as total_os ,sum( total_count)as total_count ,round(sum( retail::numeric), 2) as retail ,sum( retail_count)as retail_count,round(sum( housing::numeric), 2) as housing ,sum(
                                   housing_count)as housing_count, round(sum( vehicle::numeric), 2) as vehicle,sum( vehicle_count)as vehicle_count,round(sum(  education::numeric), 2) as education,sum( education_count)as education_count,round(sum(  agriculture::numeric), 2) as agriculture, sum( agriculture_count)as agriculture_count,round(sum( msme::numeric), 2) as msme,sum( msme_count)as msme_count,round(sum(  gold::numeric), 2) as gold,sum( gold_count)as gold_count,round(sum(  shg::numeric), 2) as shg,sum( shg_count)as shg_count
                               	FROM msso_branch_profile.msso_profile_disbursement_target where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_disbursement_target ) group by report_date;
                               	  """, nativeQuery = true)
    public MssoProfileDailyDisburseDto getDailyDisbursementTargetHo();

    @Query(value = """
            SELECT report_date, round(sum(total_advances::numeric)*100, 2) as total_advances, round(sum( total_os::numeric)*100, 2) as total_os ,sum( total_count)as total_count ,round(sum( retail::numeric)*100, 2) as retail ,sum( retail_count)as retail_count,round(sum( housing::numeric)*100, 2) as housing ,sum(
            housing_count)as housing_count, round(sum( vehicle::numeric)*100, 2) as vehicle,sum( vehicle_count)as vehicle_count,round(sum(  education::numeric)*100, 2) as education,sum( education_count)as education_count,round(sum(  agriculture::numeric)*100, 2) as agriculture, sum( agriculture_count)as agriculture_count,round(sum( msme::numeric)*100, 2) as msme,sum( msme_count)as msme_count,round(sum(  gold::numeric)*100, 2) as gold,sum( gold_count)as gold_count,round(sum(  shg::numeric)*100, 2) as shg,sum( shg_count)as shg_count
            FROM msso_branch_profile.msso_profile_disbursement_target\s
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_disbursement_target ) and branch_code=:branchCode group by report_date;
             """, nativeQuery = true)
    public MssoProfileDailyDisburseDto getDailyDisbursementTargetBranch(@Param("branchCode") String branchCode);

    @Query(value = """
            SELECT report_date, round(sum(total_advances::numeric), 2) as total_advances, round(sum( total_os::numeric), 2) as total_os ,sum( total_count)as total_count ,round(sum( retail::numeric), 2) as retail ,sum( retail_count)as retail_count,round(sum( housing::numeric), 2) as housing ,sum(
            housing_count)as housing_count, round(sum( vehicle::numeric), 2) as vehicle,sum( vehicle_count)as vehicle_count,round(sum(  education::numeric), 2) as education,sum( education_count)as education_count,round(sum(  agriculture::numeric), 2) as agriculture, sum( agriculture_count)as agriculture_count,round(sum( msme::numeric), 2) as msme,sum( msme_count)as msme_count,round(sum(  gold::numeric), 2) as gold,sum( gold_count)as gold_count,round(sum(  shg::numeric), 2) as shg,sum( shg_count)as shg_count
            FROM msso_branch_profile.msso_profile_disbursement_target\s
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_disbursement_target ) and region=:roname group by report_date;
                                	
                                 ; 
             """, nativeQuery = true)
    public MssoProfileDailyDisburseDto getDailyDisbursementTargetRO(@Param("roname") String roname);
}
