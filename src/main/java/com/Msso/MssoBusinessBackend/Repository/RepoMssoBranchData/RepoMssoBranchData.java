package com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchDataModel.MssoBranchData;
import com.Msso.MssoBusinessBackend.Model.MssoBranchDataModel.MssoBranchDataDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepoMssoBranchData extends JpaRepository<MssoBranchData, Long> {

    @Query(value=" with abc as ( select employee_details.branch_code, "+
            " count (case when employee_details.designation_code='GM' then employee_details.emp_id else null end) as desg_gm, "+
            " count (case when employee_details.designation_code='DGM' then employee_details.emp_id else null end) as desg_dgm, " +
            " count (case when employee_details.designation_code='AGM' then employee_details.emp_id else null end) as desg_agm, " +
            " count (case when (employee_details.designation_code='CM') or (employee_details.designation_code='BM' and grade_code='SM-IV') then employee_details.emp_id else null end) as desg_cm, " +
            " count (case when (employee_details.designation_code='SM') or (employee_details.designation_code='BM' and grade_code='MM-III') then employee_details.emp_id else null end) as desg_srmanager, " +
            " count (case when (employee_details.designation_code='MN') or (employee_details.designation_code='BM' and grade_code='MM-II') then employee_details.emp_id else null end) as desg_manager, " +
            " count (case when (employee_details.designation_code='AM') or (employee_details.designation_code='BM' and grade_code='JM') then employee_details.emp_id else null end) as desg_dymanager, " +
            " count (case when employee_details.designation_code='CL' then employee_details.emp_id else null end) as desg_clerk, " +
            " count (case when employee_details.designation_code='SS' then employee_details.emp_id else null end) as substaff " +
            " from hrms.employee_details group by employee_details.branch_code order by employee_details.branch_code " +
            " ) " +
            " select  e.region, e.branch_code, e.branch_name, bm.population_group_name, h.u_loc, " +
            " e.grade_code, e.employee_name, e.emp_number, h.u_id, e.designation_code, h.u_type,  " +
            " abc.desg_gm, abc.desg_dgm,abc.desg_agm,abc.desg_cm,abc.desg_srmanager,abc.desg_manager,abc.desg_dymanager,abc.desg_clerk,abc.substaff " +
            " from hrms.employee_details e, abc, master_data.branch_master bm , hrms.hrmsuser h " +
            " where h.u_loc= :uLoc and h.u_id= :uId and h.u_type= :uType " +
            " and e.branch_code=abc.branch_code and e.emp_number=substring(h.u_id, 6, length(u_id)) " +
            " and e.branch_code=bm.branch_code order by e.branch_code", nativeQuery=true)
    List<MssoBranchDataDto> getBranchSummary(String uLoc, String uId, String uType);


}