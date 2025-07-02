package com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchEmployeeData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.*;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileComplianceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepoMssoBranchEmployeData extends JpaRepository<MssoBranchEmployeeData, Long> {

    @Query(value = """
            SELECT  region, main_region, branch_code, branch_name, population_group_name, u_loc, grade_code, employee_name, emp_number, u_id, designation_code, u_type, desg_gm, desg_dgm, desg_agm, desg_cm, desg_srmanager, desg_manager, desg_dymanager, desg_clerk, substaff
            FROM msso_branch_profile.msso_employee_data WHERE branch_code=:branchCode AND region=:roname and u_type=:u_type;
            """, nativeQuery = true)
    MssoBranchEmployeeDataDto getBranchSummary(@Param("u_type") String u_type, @Param("branchCode") String branchCode, @Param("roname") String roname);

    @Query(value = """
            SELECT DISTINCT b.REGION,b.BRANCH_CODE,branch_name FROM MASTER_DATA.BRANCH_MASTER b ,HRMS.hrmsuser h\s
            WHERE h.u_loc='RO' and b.branch_code=h.branch_code """, nativeQuery = true)
    List<ForRoBranchDto> getRegion();

    @Query(value = """
            SELECT REGION,BRANCH_CODE,branch_name FROM MASTER_DATA.BRANCH_MASTER WHERE REGION=:roname """, nativeQuery = true)
    List<ForRoBranchDto> getBranch(@Param("roname") String roname);


    @Query(value = """
            SELECT sum(desg_gm+ desg_dgm+ desg_agm+ desg_cm+ desg_srmanager+ desg_manager+ desg_dymanager+ desg_clerk+ substaff)
            FROM msso_branch_profile.msso_employee_data  where  Branch_code<>:branchCode """, nativeQuery = true)
    MssoProfileComplianceDto getHoStaffCount(@Param("branchCode") String branchCode);

    @Query(value = """
            SELECT  sum(desg_gm+ desg_dgm+ desg_agm+ desg_cm+ desg_srmanager+ desg_manager+ desg_dymanager+ desg_clerk+ substaff)
             FROM msso_branch_profile.msso_employee_data WHERE REGION=:roname
              group by region """, nativeQuery = true)
    MssoProfileComplianceDto getROStaffCount(@Param("roname") String roname);


    @Query(value= """
              SELECT population_group_name FROM master_data.branch_master WHERE branch_code=:branchCode ;
            """, nativeQuery=true)
    String getBranchCategory(@Param("branchCode") String branchCode);

    @Query(value= """
              SELECT SUM(desg_agm) AS desg_agm ,SUM(desg_cm) AS desg_cm,sum(desg_srmanager) AS desg_srmanager,
                      sum(desg_manager) AS desg_manager ,sum(desg_dymanager) AS desg_dymanager,
                     sum(desg_clerk) AS desg_clerk,sum(substaff)AS substaff FROM msso_branch_profile.msso_employee_data where branch_code <> :branchCode  ;
            """, nativeQuery=true)
    MssoEmployeeSummaryDto getRegionEmployeeSummary(@Param("branchCode") String branchCode);



    @Query(value= """
              SELECT SUM(desg_agm) AS desg_agm ,SUM(desg_cm) AS desg_cm,sum(desg_srmanager) AS desg_srmanager,
                      sum(desg_manager) AS desg_manager ,sum(desg_dymanager) AS desg_dymanager,
                     sum(desg_clerk) AS desg_clerk,sum(substaff)AS substaff FROM msso_branch_profile.msso_employee_data where region=:roname and branch_code <> :branchCode ;
            """, nativeQuery=true)
    MssoEmployeeSummaryDto getBranchEmployeeSummary(@Param("roname") String roname,@Param("branchCode") String branchCode);

//************************************************BRANCH CATAGORY COUNT********************************************************
@Query(value= """
              SELECT count(*),
        count(CASE when population_group_name='URBAN' then branch_code  ELSE null  END  ) as URBAN,
        count(CASE when population_group_name='RURAL' then branch_code  ELSE null  END  ) as RURAL,
        count(CASE when population_group_name='METROPOLITAN' then branch_code  ELSE null  END  ) as METROPOLITAN,
        count(CASE when population_group_name='SEMI-URBAN' then branch_code  ELSE null  END  ) as SEMI_URBAN
        FROM master_data.branch_master   """, nativeQuery=true)
BranchCategoryDto getCategoryCountHO();



    @Query(value= """
             SELECT count(*),
            count(CASE when population_group_name='URBAN' then branch_code  ELSE null  END  ) as URBAN,
            count(CASE when population_group_name='RURAL' then branch_code  ELSE null  END  ) as RURAL,
            count(CASE when population_group_name='METROPOLITAN' then branch_code  ELSE null  END  ) as METROPOLITAN,
            count(CASE when population_group_name='SEMI-URBAN' then branch_code  ELSE null  END  ) as SEMI_URBAN
            FROM master_data.branch_master where region=:roname     """, nativeQuery=true)
    BranchCategoryDto getCategoryCountRo(@Param("roname") String roname);

}