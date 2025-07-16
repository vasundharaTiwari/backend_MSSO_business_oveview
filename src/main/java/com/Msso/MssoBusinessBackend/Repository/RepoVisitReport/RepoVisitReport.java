package com.Msso.MssoBusinessBackend.Repository.RepoVisitReport;

import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.ExecutiveVisitingData;
import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.MssoBranchEmployeeDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.MssoOverview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;

public interface RepoVisitReport extends JpaRepository<ExecutiveVisitingData, Long> {


    @Query(value = """
            SELECT  * FROM msso_branch_profile.msso_profile_visit_report WHERE branch_code=:branchCode AND visit_date='2025-07-14' ;
            """, nativeQuery = true)
    ExecutiveVisitingData getVisitData( @Param("branchCode") String branchCode, @Param("visit_date") LocalDate  visit_date);

}
