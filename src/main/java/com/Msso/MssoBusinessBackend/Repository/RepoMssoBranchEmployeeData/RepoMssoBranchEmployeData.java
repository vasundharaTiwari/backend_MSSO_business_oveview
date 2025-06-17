package com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchEmployeeData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchDataModel.MssoBranchEmployeeData;
import com.Msso.MssoBusinessBackend.Model.MssoBranchDataModel.MssoBranchEmployeeDataDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepoMssoBranchEmployeData extends JpaRepository<MssoBranchEmployeeData, Long> {

    @Query(value= """
            SELECT  region, main_region, branch_code, branch_name, population_group_name, u_loc, grade_code, employee_name, emp_number, u_id, designation_code, u_type, desg_gm, desg_dgm, desg_agm, desg_cm, desg_srmanager, desg_manager, desg_dymanager, desg_clerk, substaff
            FROM msso_branch_profile.msso_employee_data WHERE branch_code=:branchCode AND region=:roname and u_type=:u_type;
            """, nativeQuery=true)
    MssoBranchEmployeeDataDto getBranchSummary(@Param("u_type")String u_type, @Param("branchCode")String branchCode,@Param("roname") String roname);


}