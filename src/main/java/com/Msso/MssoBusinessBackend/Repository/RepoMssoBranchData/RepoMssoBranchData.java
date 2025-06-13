package com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchDataModel.MssoBranchData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepoMssoBranchData extends JpaRepository<MssoBranchData, Long> {

    @Query(value=" with abc as ( select employee_details.branch_code, "+
            " count (case when employee_details.designation_code='GM' then employee_details.emp_id else null end) as desg_gm, "+
            " count (case when employee_details.designation_code='DGM' then employee_details.emp_id else null end) as desg_Dgm, " +
            " count (case when employee_details.designation_code='AGM' then employee_details.emp_id else null end) as desg_Agm, " +
            " count (case when (employee_details.designation_code='CM') or (employee_details.designation_code='BM' and grade_code='SM-IV') then employee_details.emp_id else null end) as desg_Cm, " +
            " count (case when (employee_details.designation_code='SM') or (employee_details.designation_code='BM' and grade_code='MM-III') then employee_details.emp_id else null end) as desg_srMnger, " +
            " count (case when (employee_details.designation_code='MN') or (employee_details.designation_code='BM' and grade_code='MM-II') then employee_details.emp_id else null end) as desg_manager, " +
            " count (case when (employee_details.designation_code='AM') or (employee_details.designation_code='BM' and grade_code='JM') then employee_details.emp_id else null end) as desg_DyMngr, " +
            " count (case when employee_details.designation_code='CL' then employee_details.emp_id else null end) as desg_clerk, " +
            " count (case when employee_details.designation_code='SS' then employee_details.emp_id else null end) as substaff " +
            " from hrms.employee_details group by employee_details.branch_code order by employee_details.branch_code " +
            " ) " +
            " select e.region, e.branch_code, e.branch_name, bm.population_group_name, h.u_loc, " +
            " e.grade_code, e.employee_name, e.emp_number, h.u_id, e.designation_code, h.u_type,  " +
            " abc.desg_gm, abc.desg_Dgm,abc.desg_Agm,abc.desg_Cm,abc.desg_srMnger,abc.desg_manager,abc.desg_DyMngr,abc.desg_clerk,abc.substaff " +
            " from hrms.employee_details e, abc, master_data.branch_master bm , hrms.hrmsuser h " +
            " where h.u_loc=:uLoc and h.u_id:uId and e.branch_code=abc.branch_code and e.emp_number=substring(h.u_id, 6, length(u_id)) " +
            " and e.branch_code=bm.branch_code order by e.branch_code", nativeQuery=true)
    List<MssoBranchData> getBranchSummary(String uLoc, String uId);


}
