package com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualData;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepoMssoBranchProfile extends JpaRepository<MssoBranchProfileActualData, Long> {

    @Query(value = """
             SELECT report_date, ROUND(SUM( sb)::numeric, 2) as sb, ROUND(SUM( ca)::numeric, 2)as ca, ROUND(SUM( td)::numeric, 2) td, ROUND(SUM( casa)::numeric, 2)as casa, ROUND(SUM( deposit)::numeric, 2)as deposit , ROUND(SUM( advances)::numeric, 2)as advances , ROUND(SUM( total_business)::numeric, 2)as total_business, ROUND(SUM( total_retail)::numeric, 2)as total_retail, ROUND(SUM(\s
            housing)::numeric, 2)as housing , ROUND(SUM( vehicle)::numeric, 2) as vehicle, ROUND(SUM( education)::numeric, 2)as education, ROUND(SUM( agri)::numeric, 2)as agri, ROUND(SUM( msme)::numeric, 2)as msme, ROUND(SUM( gold)::numeric, 2)as gold, ROUND(SUM( shg)::numeric, 2)as shg, ROUND(SUM( total_ram)::numeric, 2)as total_ram , ROUND(SUM( npa)::numeric, 2)as npa
            FROM msso_branch_profile.msso_branches_actual_position where \s
            report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position )  GROUP BY report_date ; """, nativeQuery = true)
    public MssoBranchProfileActualDataDto getBranchProfileHo();


    @Query(value = """
            SELECT report_date, ROUND(SUM( sb)::numeric, 2), ROUND(SUM( ca)::numeric, 2), ROUND(SUM( td)::numeric, 2), ROUND(SUM( casa)::numeric, 2), ROUND(SUM( deposit)::numeric, 2), ROUND(SUM( advances)::numeric, 2), ROUND(SUM( total_business)::numeric, 2), ROUND(SUM( total_retail)::numeric, 2), ROUND(SUM(\s
            housing)::numeric, 2), ROUND(SUM( vehicle)::numeric, 2), ROUND(SUM( education)::numeric, 2), ROUND(SUM( agri)::numeric, 2), ROUND(SUM( msme)::numeric, 2), ROUND(SUM( gold)::numeric, 2), ROUND(SUM( shg)::numeric, 2), ROUND(SUM( total_ram)::numeric, 2), ROUND(SUM( npa)::numeric, 2)
            FROM msso_branch_profile.msso_branches_actual_position where  branch_code=:branchCode AND
            report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position )  GROUP BY report_date ;
             """, nativeQuery = true)
    public MssoBranchProfileActualDataDto getBranchProfileBranch(@Param("branchCode") String branchCode);

    @Query(value = """
            SELECT report_date, ROUND(SUM( sb)::numeric, 2), ROUND(SUM( ca)::numeric, 2), ROUND(SUM( td)::numeric, 2), ROUND(SUM( casa)::numeric, 2), ROUND(SUM( deposit)::numeric, 2), ROUND(SUM( advances)::numeric, 2), ROUND(SUM( total_business)::numeric, 2), ROUND(SUM( total_retail)::numeric, 2), ROUND(SUM(\s
            housing)::numeric, 2), ROUND(SUM( vehicle)::numeric, 2), ROUND(SUM( education)::numeric, 2), ROUND(SUM( agri)::numeric, 2), ROUND(SUM( msme)::numeric, 2), ROUND(SUM( gold)::numeric, 2), ROUND(SUM( shg)::numeric, 2), ROUND(SUM( total_ram)::numeric, 2), ROUND(SUM( npa)::numeric, 2)
            FROM msso_branch_profile.msso_branches_actual_position where  REGION=:roname AND
            report_date=(select max(report_date)from msso_branch_profile.msso_branches_actual_position )  GROUP BY report_date ;  """, nativeQuery = true)
    public MssoBranchProfileActualDataDto getBranchProfileRO(@Param("roname") String roname);
}
