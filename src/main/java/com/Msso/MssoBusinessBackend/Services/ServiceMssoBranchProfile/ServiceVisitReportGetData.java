package com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.ExecutiveVisitingData;
import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.VisitReportSummryDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileDisbursement.MssoProfileDailyDisburseDto;
import com.Msso.MssoBusinessBackend.Repository.RepoVisitReport.RepoVisitReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceVisitReportGetData {
    @Autowired
    RepoVisitReport repoVisitReport;

    public ExecutiveVisitingData getVisitDataByBranch(String branchCode, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);
        return executiveVisitingData;
    }
    public List<VisitReportSummryDto> getVisitSummery(String branchCode,

                                                               String roname,
                                                               String u_loc) {


        List<VisitReportSummryDto> visitReportSummryDtos = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            visitReportSummryDtos = this.repoVisitReport.getVisitSummeryHo();

        } else if (u_loc.equalsIgnoreCase("BR")) {
            visitReportSummryDtos = this.repoVisitReport.getVisitSummeryBranch(branchCode);

        } else {
            visitReportSummryDtos = this.repoVisitReport.getVisitSummeryRO(roname);

        }
        return visitReportSummryDtos;

    }
}
