package com.Msso.MssoBusinessBackend.Repository.RepoMssoOverview;

import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.DtoMssoBusinessBranchwise;
import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.DtoMssoBusinessRegionwise;
import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.MssoBusinessDto;
import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.MssoOverview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepoMssoOverview extends JpaRepository<MssoOverview, Long> {

    @Query(value = """
             WITH mno AS (
                                                          SELECT
                                                              ROUND(SUM(o.deposit)::numeric, 2) AS dep,
                                                              ROUND(SUM(o.advances)::numeric, 2) AS adv,
                                                              ROUND(SUM((o.ca + o.sb))::numeric, 2) AS casa,
                                                               o.report_date 
                                                          FROM advances.msso_overview o
                                                          WHERE o.report_date = (select max(report_date) from advances.msso_overview) GROUP BY o.report_date
                                                      )
                                                      SELECT\s
                                                          mno.dep AS deposit,
                                                          mno.adv AS advances,
                                                          (mno.dep + mno.adv) AS totalBusiness,
                                                          ROUND((mno.casa / NULLIF(mno.dep, 0)) * 100::numeric, 2) AS casaPercent,
                                                          mno.report_date
                                                      FROM mno
            """, nativeQuery = true)
    public MssoBusinessDto getBusinesssHo();


    @Query(value = """
             WITH mno AS (
                             SELECT\s
                                 ROUND( o.deposit ::numeric, 2) AS dep,\s
                                 ROUND( o.advances ::numeric, 2) AS adv,
                                 ROUND(   (o.ca + o.sb)::numeric, 2) AS casa,
                         		o.report_date \s
                             FROM advances.msso_overview o WHERE o.report_date = (select max(report_date) from advances.msso_overview) AND BRANCH_code=:branchCode)
                             SELECT\s
                                 mno.dep AS deposit,
                                 mno.adv AS advances,
                                 (mno.dep + mno.adv) AS totalBusiness,
                                 ROUND((mno.casa / NULLIF(mno.dep, 0)) * 100::numeric, 2) AS casaPercent,
                                 mno.report_date
                             FROM mno
            """, nativeQuery = true)
    public MssoBusinessDto getBusinesssBranch(@Param("branchCode") String branchCode);

    @Query(value = """
             WITH mno AS (
                                        SELECT\s
                                            ROUND(SUM( o.deposit)::numeric, 2) AS dep,\s
                                            ROUND(SUM( o.advances)::numeric, 2) AS adv,
                                            ROUND(SUM((o.ca + o.sb))::numeric, 2) AS casa,
                                    		o.report_date \s
                                        FROM advances.msso_overview o where o.report_date = (select max(report_date) from advances.msso_overview) and region=:roname GROUP BY o.report_date)
                                        SELECT\s
                                            mno.dep AS deposit,
                                            mno.adv AS advances,
                                            (mno.dep + mno.adv) AS totalBusiness,
                                            ROUND((mno.casa / NULLIF(mno.dep, 0)) * 100::numeric, 2) AS casaPercent,
                                            mno.report_date
                                        FROM mno
            """, nativeQuery = true)
    public MssoBusinessDto getBusinesssRO(@Param("roname") String roname);

    @Query(value = """
             WITH mno AS (SELECT region,o.report_date ,ROUND(SUM( o.deposit)::numeric, 2) AS dep, ROUND(SUM( o.advances)::numeric, 2) AS adv,
                                                            ROUND(SUM((o.ca + o.sb))::numeric, 2) AS casa FROM advances.msso_overview o where o.report_date = (select max(report_date) from advances.msso_overview)  GROUP BY o.report_date,region)
                                                            SELECT report_date,region,  mno.dep AS deposit,mno.adv AS advances, (mno.dep + mno.adv) AS totalBusiness,
                                                            ROUND((mno.casa / NULLIF(mno.dep, 0)) * 100::numeric, 2) AS casaPercent FROM mno where region <>'HEAD OFFICE' order by region
            """, nativeQuery = true)
    public List<DtoMssoBusinessRegionwise> getBusinesssHORegionwise();

    @Query(value = """
             WITH mno AS (SELECT BRANCH_CODE,BRANCH_NAME,o.report_date ,ROUND(( o.deposit)::numeric, 2) AS dep, ROUND(( o.advances)::numeric, 2) AS adv,
             ROUND(((o.ca + o.sb))::numeric, 2) AS casa FROM advances.msso_overview o where o.report_date = (select max(report_date) from advances.msso_overview)\s
             and region=:roname  )
             SELECT report_date, BRANCH_CODE,BRANCH_NAME,  mno.dep AS deposit,mno.adv AS advances, (mno.dep + mno.adv) AS totalBusiness,
             ROUND((mno.casa / NULLIF(mno.dep, 0)) * 100::numeric, 2) AS casaPercent FROM mno order by BRANCH_CODE
            """, nativeQuery = true)
    public List<DtoMssoBusinessBranchwise> getBusinesssHOBranchwise(@Param("roname") String roname);
}

