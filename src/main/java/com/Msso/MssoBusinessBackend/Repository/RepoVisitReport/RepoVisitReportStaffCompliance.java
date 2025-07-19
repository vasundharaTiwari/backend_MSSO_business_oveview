package com.Msso.MssoBusinessBackend.Repository.RepoVisitReport;

import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.ExecutiveVisitingData;
import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.VisitDataStaffCompliance;
import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.VisitingDataStaffDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RepoVisitReportStaffCompliance extends JpaRepository<VisitDataStaffCompliance, Long> {
    @Query(value = """
            SELECT  * FROM msso_branch_profile.visit_data_staff_compliance WHERE branch_code=:branchCode AND visit_date=:visit_date ;
            """, nativeQuery = true)
    public VisitDataStaffCompliance getVisitStaffComplianceData(@Param("branchCode") String branchCode, @Param("visit_date") LocalDate visit_date);
//*******************************************************Visit summery******************************************************

    @Query(value = """
       select distinct region,count(*) from msso_branch_profile.visit_data_staff_compliance group by region
            """, nativeQuery = true)
    public List<VisitingDataStaffDto> getVisitSummeryHo();


    @Query(value = """   
            select visit_date,branch_code,branch_name,region,visitor_name,visitor_region,visitor_branch_code,
            visitor_designation from msso_branch_profile.visit_data_staff_compliance where branch_code=:branchCode ORDER BY visit_date DESC
             """, nativeQuery = true)
    public List<VisitingDataStaffDto> getVisitSummeryBranch(@Param("branchCode") String branchCode);

    @Query(value = """
            select visit_date,branch_code,branch_name,region,visitor_name,visitor_region,visitor_branch_code,
            visitor_designation from msso_branch_profile.visit_data_staff_compliance where region=:roname ORDER BY BRANCH_CODE
            """, nativeQuery = true)
    public List<VisitingDataStaffDto> getVisitSummeryRO(@Param("roname") String roname);
}


