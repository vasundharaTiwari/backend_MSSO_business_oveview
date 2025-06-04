package com.Msso.MssoBusinessBackend.Repository.RepoMssoDeposit;


import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.DtoMssoBusinessBranchwise;
import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.DtoMssoBusinessRegionwise;
import com.Msso.MssoBusinessBackend.Model.MssoDepositModel.DtoMssoDepositBranchwise;
import com.Msso.MssoBusinessBackend.Model.MssoDepositModel.DtoMssoDepositRegionwise;
import com.Msso.MssoBusinessBackend.Model.MssoDepositModel.MssoDeposit;
import com.Msso.MssoBusinessBackend.Model.MssoDepositModel.MssoDepositDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepoMssoDeposit extends JpaRepository<MssoDeposit, Long> {
    @Query(value = """
             Select round(sum(sb)::numeric,2) as sb,round(sum(Ca)::numeric,2) as Ca,round(sum(td)::numeric,2) as td, round(sum(deposit)::numeric,2) as deposit ,report_date
             from advances.MSSO_DEPOSIT where report_date= TO_DATE(:report_date,'DD-MON-YYYY') GROUP BY report_date
            """, nativeQuery = true)
    public MssoDepositDto getDepositHo(@Param("report_date") String report_date);


    @Query(value = """
             Select round((sb)::numeric,2) as sb,round((Ca)::numeric,2) as Ca,round((td)::numeric,2) as td, round((deposit)::numeric,2) as deposit ,report_date
                                                 from advances.MSSO_DEPOSIT where report_date= TO_DATE(:report_date,'DD-MON-YYYY') and branch_code=:branchCode
            """, nativeQuery = true)
    public MssoDepositDto getDepositBranch(@Param("branchCode") String branchCode, @Param("report_date") String report_date);

    @Query(value = """
             Select round(sum(sb)::numeric,2) as sb,round(sum(Ca)::numeric,2) as Ca,round(sum(td)::numeric,2) as td, round(sum(deposit)::numeric,2) as deposit ,report_date
             from advances.MSSO_DEPOSIT where report_date= TO_DATE(:report_date,'DD-MON-YYYY') and REGION like :roname GROUP BY report_date
            """, nativeQuery = true)
    public MssoDepositDto getDepositRO(@Param("roname") String roname, @Param("report_date") String report_date);
    @Query(value = """
             Select branch_code,report_date, round((sb)::numeric,2) as sb,round((Ca)::numeric,2) as Ca,round((td)::numeric,2) as td, round((deposit)::numeric,2) as deposit\s
             from advances.MSSO_DEPOSIT where report_date= TO_DATE(:report_date,'DD-MON-YYYY') AND REGION=:roname  ORDER BY branch_code
            """, nativeQuery = true)
    public List<DtoMssoDepositBranchwise> getDepositHOBranchwise(@Param("roname") String roname, @Param("report_date") String report_date);

       @Query(value = """
             Select REGION,report_date, round(sum(sb)::numeric,2) as sb,round(sum(Ca)::numeric,2) as Ca,round(sum(td)::numeric,2) as td, round(sum(deposit)::numeric,2) as deposit\s
              from advances.MSSO_DEPOSIT where report_date= TO_DATE(:report_date,'DD-MON-YYYY') GROUP BY report_date,REGION ORDER BY REGION
            """, nativeQuery = true)
       public List<DtoMssoDepositRegionwise> getDepositHORegionwise(@Param("report_date") String report_date);
}
