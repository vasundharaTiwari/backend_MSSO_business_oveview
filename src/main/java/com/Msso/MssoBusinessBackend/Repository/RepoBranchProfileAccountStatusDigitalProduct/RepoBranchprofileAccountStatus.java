package com.Msso.MssoBusinessBackend.Repository.RepoBranchProfileAccountStatusDigitalProduct;

import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileAccountStatusDigitalProduct.MssoBranchProfileAccountStatus;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileAccountStatusDigitalProduct.MssoBranchProfileAccountStatusDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileSma.MssoBranchProfileSmaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepoBranchprofileAccountStatus extends JpaRepository<MssoBranchProfileAccountStatus, Long> {
    //*******************************************************ACCOUNT STATUS data ******************************************************

    @Query(value = """
            SELECT report_date,sum( sb_ac_count)as sb_ac_count ,sum(ca_ac_count)as ca_ac_count,
                  sum(casa_count)as casa_count,round(sum( casa_amount::numeric), 2) as casa_amount\s
                  FROM msso_branch_profile.msso_profile_account_status
                  where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_account_status ) group by report_date;\s
                   """, nativeQuery = true)
    public MssoBranchProfileAccountStatusDto getAccountStatusHo();


    @Query(value = """
            SELECT report_date,sum( sb_ac_count)as sb_ac_count ,sum(ca_ac_count)as ca_ac_count,
            sum(casa_count)as casa_count,round(sum( casa_amount::numeric), 2) as casa_amount\s
            FROM msso_branch_profile.msso_profile_account_status
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_account_status ) and branch_code=:branchCode  group by report_date;\s
                """, nativeQuery = true)
    public MssoBranchProfileAccountStatusDto getAccountStatusBranch(@Param("branchCode") String branchCode);

    @Query(value = """
            SELECT report_date,sum( sb_ac_count)as sb_ac_count ,sum(ca_ac_count)as ca_ac_count,
            sum(casa_count)as casa_count,round(sum( casa_amount::numeric), 2) as casa_amount\s
            FROM msso_branch_profile.msso_profile_account_status
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_account_status ) and REGION=:roname  group by report_date;\s
                """, nativeQuery = true)


    public MssoBranchProfileAccountStatusDto getAccountStatusRO(@Param("roname") String roname);
}
