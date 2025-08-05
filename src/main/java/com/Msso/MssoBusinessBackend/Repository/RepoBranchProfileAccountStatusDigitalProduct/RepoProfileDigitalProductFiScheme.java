package com.Msso.MssoBusinessBackend.Repository.RepoBranchProfileAccountStatusDigitalProduct;

import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileDigitalProduct;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileDigitalProductDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoFiSchemeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepoProfileDigitalProductFiScheme extends JpaRepository<MssoBranchProfileDigitalProduct, Long> {
    //*******************************************************ACCOUNT digital data ******************************************************

    @Query(value = """
            SELECT report_date,sum( internet_banking)as internet_banking ,sum(mobile_banking)as mobile_banking,
                  sum(atm_card)as atm_card, sum(ckyc)as ckyc, sum(multiple_cif)as multiple_cif
                  FROM msso_branch_profile.msso_profile_digital_product
                  where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_digital_product ) group by report_date;
                   """, nativeQuery = true)
    public MssoBranchProfileDigitalProductDto getDigitalproductHo();


    @Query(value = """
           SELECT report_date,sum( internet_banking)as internet_banking ,sum(mobile_banking)as mobile_banking,
                  sum(atm_card)as atm_card, sum(ckyc)as ckyc, sum(multiple_cif)as multiple_cif
                  FROM msso_branch_profile.msso_profile_digital_product
                  where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_digital_product ) and branch_code=:branchCode  group by report_date;
                """, nativeQuery = true)
    public MssoBranchProfileDigitalProductDto getDigitalproductBranch(@Param("branchCode") String branchCode);

    @Query(value = """
           SELECT report_date,sum( internet_banking)as internet_banking ,sum(mobile_banking)as mobile_banking,
                  sum(atm_card)as atm_card, sum(ckyc)as ckyc, sum(multiple_cif)as multiple_cif
                  FROM msso_branch_profile.msso_profile_digital_product
                  where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_digital_product ) and REGION=:roname  group by report_date;
                """, nativeQuery = true)


    public MssoBranchProfileDigitalProductDto getDigitalproductRO(@Param("roname") String roname);
    //************************************************************fi scheme **********************************
    @Query(value = """
            SELECT report_date,sum( pmjjby)as pmjjby ,sum(pmsby)as pmsby,sum( apy)as apy ,sum(pmjdy)as pmjdy
                                   FROM msso_branch_profile.msso_profile_fi_scheme
                                   where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_fi_scheme )  group by report_date; """, nativeQuery = true)
    public MssoFiSchemeDto getFiSchemeHo();


    @Query(value = """
             SELECT report_date,sum( pmjjby)as pmjjby ,sum(pmsby)as pmsby,sum( apy)as apy ,sum(pmjdy)as pmjdy
                                   FROM msso_branch_profile.msso_profile_fi_scheme
                                   where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_fi_scheme ) and branch_code=:branchCode  group by report_date;
                """, nativeQuery = true)
    public MssoFiSchemeDto getFiSchemeBranch(@Param("branchCode") String branchCode);

    @Query(value = """
              SELECT report_date,sum( pmjjby)as pmjjby ,sum(pmsby)as pmsby,sum( apy)as apy ,sum(pmjdy)as pmjdy
                                   FROM msso_branch_profile.msso_profile_fi_scheme
                                   where  report_date=(select max(report_date)from msso_branch_profile.msso_profile_fi_scheme )and REGION=:roname  group by report_date;
                """, nativeQuery = true)


    public MssoFiSchemeDto getFiSchemeRO(@Param("roname") String roname);
}
