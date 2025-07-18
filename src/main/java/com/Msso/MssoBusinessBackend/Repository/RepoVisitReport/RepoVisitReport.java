package com.Msso.MssoBusinessBackend.Repository.RepoVisitReport;

import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.ExecutiveVisitingData;
import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.VisitReportSummryDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.MssoBranchEmployeeDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.MssoOverview;
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.MssoBranchProfileSmaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
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
    public List<VisitReportSummryDto> getVisitSummeryHo();


    @Query(value = """   
            select visit_date,branch_code,branch_name,region,visitor_name,visitor_region,visitor_branch_code,
            visitor_designation from msso_branch_profile.msso_profile_visit_report where branch_code=:branchCode ORDER BY visit_date DESC
             """, nativeQuery = true)
    public List<VisitReportSummryDto> getVisitSummeryBranch(@Param("branchCode") String branchCode);

    @Query(value = """
            select visit_date,branch_code,branch_name,region,visitor_name,visitor_region,visitor_branch_code,
            visitor_designation from msso_branch_profile.msso_profile_visit_report where region=:roname ORDER BY BRANCH_CODE
            """, nativeQuery = true)
    public List<VisitReportSummryDto> getVisitSummeryRO(@Param("roname") String roname);
}
