//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.Msso.MssoBusinessBackend.Repository.RepoMssoAdvances;

import com.Msso.MssoBusinessBackend.Model.MssoAdvancesModel.DtoMssoAdvancesBranchwise;
import com.Msso.MssoBusinessBackend.Model.MssoAdvancesModel.DtoMssoAdvancesRegionwise;
import com.Msso.MssoBusinessBackend.Model.MssoAdvancesModel.MssoAdvances;
import com.Msso.MssoBusinessBackend.Model.MssoAdvancesModel.MssoAdvancesDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepoMssoAdvances extends JpaRepository<MssoAdvances, Long> {
    @Query(
            value = " Select round(sum(advances)::numeric,2)AS ADVANCES,round(sum(advances - total_npa)::numeric,2) as Reg_Adv,round(sum(total_npa)::numeric,2)as TOTAL_NPA, \n round(sum(freez_npa)::numeric,2)as FREEZ_NPA ,report_date from advances.MSSO_ADVANCES where report_date = (select max(report_date) from  advances.MSSO_ADVANCES)   GROUP BY report_date\n",
            nativeQuery = true
    )
    MssoAdvancesDto getAdvancesHo();

    @Query(
            value = " Select round((advances)::numeric,2) AS ADVANCES,round((advances - total_npa)::numeric,2) as Reg_Adv,round((total_npa)::numeric,2) as TOTAL_NPA, \n round((freez_npa)::numeric,2)as FREEZ_NPA,report_date from advances.MSSO_ADVANCES where report_date =(select max(report_date) from  advances.MSSO_ADVANCES)  and branch_code=:branchCode\n",
            nativeQuery = true
    )
    MssoAdvancesDto getAdvancesBranch(@Param("branchCode") String branchCode);

    @Query(
            value = "Select round(sum(advances)::numeric,2),round(sum(advances - total_npa)::numeric,2) as Reg_Adv,round(sum(total_npa)::numeric,2), \n        round(sum(freez_npa)::numeric,2),report_date from advances.MSSO_ADVANCES where report_date =(select max(report_date) from  advances.MSSO_ADVANCES) and REGION like :roname GROUP BY report_date\n",
            nativeQuery = true
    )
    MssoAdvancesDto getAdvancesRO(@Param("roname") String roname);

    @Query(
            value = "Select branch_code,branch_name,report_date,round((advances)::numeric,2) AS ADVANCES,round((advances - total_npa)::numeric,2) as Reg_Adv,round((total_npa)::numeric,2) as TOTAL_NPA,\n             round((freez_npa)::numeric,2)as FREEZ_NPA from advances.MSSO_ADVANCES where report_date =(select max(report_date) from  advances.MSSO_ADVANCES)  and region=:roname order by branch_code\n",
            nativeQuery = true
    )
    List<DtoMssoAdvancesBranchwise> getAdvancesHOBranchwise(@Param("roname") String roname);

    @Query(
            value = " Select region, report_date,round(sum(advances)::numeric,2)as advances,round(sum(advances - total_npa)::numeric,2) as Reg_Adv,round(sum(total_npa)::numeric,2)as total_npa,\n round(sum(freez_npa)::numeric,2)as freez_npa from advances.MSSO_ADVANCES where report_date =(select max(report_date) from  advances.MSSO_ADVANCES) and region <>'HEAD OFFICE' GROUP BY region, report_date order by region\n",
            nativeQuery = true
    )
    List<DtoMssoAdvancesRegionwise> getAdvancesHORegionwise();
}
