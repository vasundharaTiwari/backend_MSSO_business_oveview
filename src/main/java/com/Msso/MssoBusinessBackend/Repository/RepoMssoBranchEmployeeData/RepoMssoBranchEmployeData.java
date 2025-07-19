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
            WHERE h.u_loc='RO' and b.branch_code=h.branch_code ORDER BY b.BRANCH_CODE """, nativeQuery = true)
    List<ForRoBranchDto> getRegion();

    @Query(value = """
            SELECT REGION,BRANCH_CODE,branch_name FROM MASTER_DATA.BRANCH_MASTER WHERE REGION=:roname ORDER BY BRANCH_CODE""", nativeQuery = true)
    List<ForRoBranchDto> getBranch(@Param("roname") String roname,@Param("branch_code") String branch_code);


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

    @Query(value = """
        WITH abc AS (
            SELECT 
                employee_details.branch_code,
                COUNT(CASE WHEN employee_details.designation_code = 'AGM' THEN employee_details.emp_number END) AS desg_agm,
                COUNT(CASE WHEN (employee_details.designation_code = 'CM') 
                            OR (employee_details.designation_code = 'BM' AND grade_code = 'SM-IV') THEN employee_details.emp_number END) AS desg_cm,
                COUNT(CASE WHEN (employee_details.designation_code = 'SM') 
                            OR (employee_details.designation_code = 'BM' AND grade_code = 'MM-III') THEN employee_details.emp_number END) AS desg_srmanager,
                COUNT(CASE WHEN (employee_details.designation_code = 'MN') 
                            OR (employee_details.designation_code = 'BM' AND grade_code = 'MM-II') THEN employee_details.emp_number END) AS desg_manager,
                COUNT(CASE WHEN (employee_details.designation_code = 'AM') 
                            OR (employee_details.designation_code = 'BM' AND grade_code = 'JM') THEN employee_details.emp_number END) AS desg_dymanager,
                COUNT(CASE WHEN employee_details.designation_code = 'CL' THEN employee_details.emp_number END) AS desg_clerk,
                COUNT(CASE WHEN employee_details.designation_code = 'SS' THEN employee_details.emp_number END) AS substaff
            FROM hrms.employee_details
            GROUP BY employee_details.branch_code
        )
        SELECT 
            SUM(desg_agm) AS desg_agm,
            SUM(desg_cm) AS desg_cm,
            SUM(desg_srmanager) AS desg_srmanager,
            SUM(desg_manager) AS desg_manager,
            SUM(desg_dymanager) AS desg_dymanager,
            SUM(desg_clerk) AS desg_clerk,
            SUM(substaff) AS substaff
        FROM abc
       
        """, nativeQuery = true)
    MssoEmployeeSummaryDto getRegionEmployeeSummary(@Param("branchCode") String branchCode);



    @Query(value = """

            WITH abc AS (
                                         SELECT\s
                                             employee_details.branch_code,
                                             employee_details.region,
                                             COUNT(CASE WHEN employee_details.designation_code = 'AGM' THEN employee_details.emp_number END) AS desg_agm,
                                             COUNT(CASE WHEN (employee_details.designation_code = 'CM')\s
                                                         OR (employee_details.designation_code = 'BM' AND grade_code = 'SM-IV') THEN employee_details.emp_number END) AS desg_cm,
                                             COUNT(CASE WHEN (employee_details.designation_code = 'SM')\s
                                                         OR (employee_details.designation_code = 'BM' AND grade_code = 'MM-III') THEN employee_details.emp_number END) AS desg_srmanager,
                                             COUNT(CASE WHEN (employee_details.designation_code = 'MN')\s
                                                         OR (employee_details.designation_code = 'BM' AND grade_code = 'MM-II') THEN employee_details.emp_number END) AS desg_manager,
                                             COUNT(CASE WHEN (employee_details.designation_code = 'AM')\s
                                                         OR (employee_details.designation_code = 'BM' AND grade_code = 'JM') THEN employee_details.emp_number END) AS desg_dymanager,
                                             COUNT(CASE WHEN employee_details.designation_code = 'CL' THEN employee_details.emp_number END) AS desg_clerk,
                                             COUNT(CASE WHEN employee_details.designation_code = 'SS' THEN employee_details.emp_number END) AS substaff
                                         FROM hrms.employee_details
                                         GROUP BY employee_details.branch_code, employee_details.region
                                     )
                                     SELECT\s
                                         SUM(desg_agm) AS desg_agm,
                                         SUM(desg_cm) AS desg_cm,
                                         SUM(desg_srmanager) AS desg_srmanager,
                                         SUM(desg_manager) AS desg_manager,
                                         SUM(desg_dymanager) AS desg_dymanager,
                                         SUM(desg_clerk) AS desg_clerk,
                                         SUM(substaff) AS substaff
                                     FROM abc
                                     WHERE abc.region = :roname AND abc.branch_code <> '4000' 
                                     
        """, nativeQuery = true)
    MssoEmployeeSummaryDto getBranchEmployeeSummary(@Param("roname") String roname,@Param("branchCode") String branchCode);

//************************************************BRANCH CATAGORY COUNT********************************************************
@Query(value= """
              SELECT count(*),
        count(CASE when population_group_name='URBAN' then branch_code  ELSE null  END  ) as URBAN,
        count(CASE when population_group_name='RURAL' then branch_code  ELSE null  END  ) as RURAL,
        count(CASE when population_group_name='METROPOLITAN' then branch_code  ELSE null  END  ) as METROPOLITAN,
        count(CASE when population_group_name='SEMI-URBAN' then branch_code  ELSE null  END  ) as SEMI_URBAN
        FROM master_data.branch_master_catagory   """, nativeQuery=true)
BranchCategoryDto getCategoryCountHO();



    @Query(value= """
             SELECT count(*),
            count(CASE when population_group_name='URBAN' then branch_code  ELSE null  END  ) as URBAN,
            count(CASE when population_group_name='RURAL' then branch_code  ELSE null  END  ) as RURAL,
            count(CASE when population_group_name='METROPOLITAN' then branch_code  ELSE null  END  ) as METROPOLITAN,
            count(CASE when population_group_name='SEMI-URBAN' then branch_code  ELSE null  END  ) as SEMI_URBAN
            FROM master_data.branch_master where region=:roname and branch_code<>:branchCode    """, nativeQuery=true)
    BranchCategoryDto getCategoryCountRo(@Param("roname") String roname,@Param("branchCode") String branchCode);

    //********************************************branch opening date*****************************************************************
    @Query(value= """
              SELECT branch_code, branch_name, region, branchopendate
              FROM master_data.branch_opening_date where branch_code=:branchCode ;
            """, nativeQuery=true)
    BranchOpeningDateDto getBranchopendate(@Param("branchCode") String branchCode);


    //******************************************** BM branch join date*****************************************************************

    @Query(value= """
             	 SELECT branch_code,  region, bm_since_date
               FROM master_data.bm_joining_data where pfno=:userId  ;
            """, nativeQuery=true)
    BmBranchJoinDateDto getBmBranchJoindate(@Param("branchCode") String branchCode,@Param("userId") String userId);

    //**************************************bc data

    @Query(value= """
             SELECT sum(number_of_bc)::bigint FROM master_data.bc_count_branchwise """, nativeQuery=true)
    BranchCategoryDto getBCCountHO();



    @Query(value= """
             SELECT sum(number_of_bc)::bigint FROM master_data.bc_count_branchwise where region=:roname     """, nativeQuery=true)
    BranchCategoryDto getBCCountRo(@Param("roname") String roname);

    @Query(value= """
            SELECT sum(number_of_bc)::bigint FROM master_data.bc_count_branchwise where  branch_code=:branchCode     """, nativeQuery=true)
    BranchCategoryDto getBCCountBranch(@Param("branchCode") String branchCode);
}