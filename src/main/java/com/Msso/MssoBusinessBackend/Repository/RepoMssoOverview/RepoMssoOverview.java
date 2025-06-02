package com.Msso.MssoBusinessBackend.Repository.RepoMssoOverview;

import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.MssoBusinessDto;
import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.MssoOverview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepoMssoOverview extends JpaRepository<MssoOverview, Long> {

    @Query(value = """
 WITH mno AS (
                                              SELECT
                                                  ROUND(SUM(o.deposit)::numeric, 2) AS dep,
                                                  ROUND(SUM(o.advances)::numeric, 2) AS adv,
                                                  ROUND(SUM((o.ca + o.sb))::numeric, 2) AS casa,
                                                   o.report_date 
                                              FROM advances.msso_overview o
                                              WHERE o.report_date = TO_DATE(:report_date, 'DD-MON-YYYY') GROUP BY o.report_date
                                          )
                                          SELECT\s
                                              mno.dep AS deposit,
                                              mno.adv AS advances,
                                              (mno.dep + mno.adv) AS totalBusiness,
                                              ROUND((mno.casa / NULLIF(mno.dep, 0)) * 100::numeric, 2) AS casaPercent,
                                              mno.report_date
                                          FROM mno
""", nativeQuery = true)
    public MssoBusinessDto getBusinesssHo(@Param("report_date") String report_date);


    @Query(value = """
 WITH mno AS (
                 SELECT\s
                     ROUND( o.deposit ::numeric, 2) AS dep,\s
                     ROUND( o.advances ::numeric, 2) AS adv,
                     ROUND(   (o.ca + o.sb)::numeric, 2) AS casa,
             		o.report_date \s
                 FROM advances.msso_overview o WHERE o.report_date = TO_DATE(:report_date, 'DD-MON-YYYY') AND BRANCH_code=:branchCode)
                 SELECT\s
                     mno.dep AS deposit,
                     mno.adv AS advances,
                     (mno.dep + mno.adv) AS totalBusiness,
                     ROUND((mno.casa / NULLIF(mno.dep, 0)) * 100::numeric, 2) AS casaPercent,
                     mno.report_date
                 FROM mno
""", nativeQuery = true)
    public MssoBusinessDto getBusinesssBranch(@Param("branchCode") String branchCode,@Param("report_date") String report_date);

    @Query(value = """
 WITH mno AS (
                            SELECT\s
                                ROUND(SUM( o.deposit)::numeric, 2) AS dep,\s
                                ROUND(SUM( o.advances)::numeric, 2) AS adv,
                                ROUND(SUM((o.ca + o.sb))::numeric, 2) AS casa,
                        		o.report_date \s
                            FROM advances.msso_overview o where o.report_date = TO_DATE(:report_date, 'DD-MON-YYYY') and region=:roname GROUP BY o.report_date)
                            SELECT\s
                                mno.dep AS deposit,
                                mno.adv AS advances,
                                (mno.dep + mno.adv) AS totalBusiness,
                                ROUND((mno.casa / NULLIF(mno.dep, 0)) * 100::numeric, 2) AS casaPercent,
                                mno.report_date
                            FROM mno
""", nativeQuery = true)
    public MssoBusinessDto getBusinesssRO(@Param("roname") String roname,@Param("report_date") String report_date);

}

