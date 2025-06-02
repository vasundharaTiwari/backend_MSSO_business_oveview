package com.Msso.MssoBusinessBackend.Repository.RepoMssoAdvances;

import com.Msso.MssoBusinessBackend.Model.MssoAdvancesModel.MssoAdvances;
import com.Msso.MssoBusinessBackend.Model.MssoAdvancesModel.MssoAdvancesDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepoMssoAdvances extends JpaRepository<MssoAdvances, Long> {
    @Query(value = """
             Select round(sum(advances)::numeric,2)AS ADVANCES,round(sum(advances - total_npa)::numeric,2) as Reg_Adv,round(sum(total_npa)::numeric,2)as TOTAL_NPA,\s
             round(sum(freez_npa)::numeric,2)as FREEZ_NPA ,report_date from advances.MSSO_ADVANCES where report_date =TO_DATE(:report_date,'DD-MON-YYYY')   GROUP BY report_date
            """, nativeQuery = true)
    public MssoAdvancesDto getAdvancesHo(@Param("report_date") String report_date);


    @Query(value = """
             Select round((advances)::numeric,2) AS ADVANCES,round((advances - total_npa)::numeric,2) as Reg_Adv,round((total_npa)::numeric,2) as TOTAL_NPA,\s
             round((freez_npa)::numeric,2)as FREEZ_NPA,report_date from advances.MSSO_ADVANCES where report_date =TO_DATE(:report_date,'DD-MON-YYYY')  and branch_code=:branchCode
            """, nativeQuery = true)
    public MssoAdvancesDto getAdvancesBranch(@Param("branchCode") String branchCode, @Param("report_date") String report_date);

    @Query(value = """
            Select round(sum(advances)::numeric,2),round(sum(advances - total_npa)::numeric,2) as Reg_Adv,round(sum(total_npa)::numeric,2),\s
                    round(sum(freez_npa)::numeric,2),report_date from advances.MSSO_ADVANCES where report_date =TO_DATE(:report_date,'DD-MON-YYYY') and REGION like :roname GROUP BY report_date
            """, nativeQuery = true)
    public MssoAdvancesDto getAdvancesRO(@Param("roname") String roname, @Param("report_date") String report_date);
}
