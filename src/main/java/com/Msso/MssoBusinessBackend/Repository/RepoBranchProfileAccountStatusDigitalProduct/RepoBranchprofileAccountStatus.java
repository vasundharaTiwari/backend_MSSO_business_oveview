package com.Msso.MssoBusinessBackend.Repository.RepoBranchProfileAccountStatusDigitalProduct;

import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileAccountStatus;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileAccountStatusDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepoBranchprofileAccountStatus extends JpaRepository<MssoBranchProfileAccountStatus, Long> {
    //*******************************************************ACCOUNT STATUS data ******************************************************

    @Query(value = """
            SELECT report_date,sum( sb_ac_count)as sb_ac_count ,sum(ca_ac_count)as ca_ac_count,
                  sum(casa_count)as casa_count, sum(pmjdy)as pmjdy,round(sum( casa_amount::numeric), 2) as casa_amount
                  FROM msso_branch_profile.msso_profile_account_status
                  where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_account_status ) group by report_date;
                   """, nativeQuery = true)
    public MssoBranchProfileAccountStatusDto getAccountStatusHo();


    @Query(value = """
            SELECT report_date,sum( sb_ac_count)as sb_ac_count ,sum(ca_ac_count)as ca_ac_count,
            sum(casa_count)as casa_count, sum(pmjdy)as pmjdy,round(sum( casa_amount::numeric), 2) as casa_amount
		     
            FROM msso_branch_profile.msso_profile_account_status
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_account_status ) and branch_code=:branchCode  group by report_date;
                """, nativeQuery = true)
    public MssoBranchProfileAccountStatusDto getAccountStatusBranch(@Param("branchCode") String branchCode);

    @Query(value = """
            SELECT report_date,sum( sb_ac_count)as sb_ac_count ,sum(ca_ac_count)as ca_ac_count,
            sum(casa_count)as casa_count, sum(pmjdy)as pmjdy,round(sum( casa_amount::numeric), 2) as casa_amount
            FROM msso_branch_profile.msso_profile_account_status
            where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_account_status ) and REGION=:roname  group by report_date;
                """, nativeQuery = true)


    public MssoBranchProfileAccountStatusDto getAccountStatusRO(@Param("roname") String roname);

    //******************************************************* msso_profile_account_status_march ******************************************************

    @Query(value = """
            SELECT report_date,sum( sb_ac_count)as sb_ac_count ,sum(ca_ac_count)as ca_ac_count,
                  sum(casa_count)as casa_count,round(sum( casa_amount::numeric), 2) as casa_amount\s
                  FROM msso_branch_profile.msso_profile_account_status_march
               group by report_date;\s
                   """, nativeQuery = true)
    public MssoBranchProfileAccountStatusDto getAccountStatusMarchHo();


    @Query(value = """
            SELECT report_date,sum( sb_ac_count)as sb_ac_count ,sum(ca_ac_count)as ca_ac_count,
            sum(casa_count)as casa_count,round(sum( casa_amount::numeric), 2) as casa_amount\s
            FROM msso_branch_profile.msso_profile_account_status_march
            where  branch_code=:branchCode  group by report_date;\s
                """, nativeQuery = true)
    public MssoBranchProfileAccountStatusDto getAccountStatusMarchBranch(@Param("branchCode") String branchCode);

    @Query(value = """
            SELECT report_date,sum( sb_ac_count)as sb_ac_count ,sum(ca_ac_count)as ca_ac_count,
            sum(casa_count)as casa_count,round(sum( casa_amount::numeric), 2) as casa_amount\s
            FROM msso_branch_profile.msso_profile_account_status_march
            where   REGION=:roname  group by report_date;\s
                """, nativeQuery = true)


    public MssoBranchProfileAccountStatusDto getAccountStatusMarchRO(@Param("roname") String roname);
}
