package com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.ExecutiveVisitingData;
import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.VisitDataStaffCompliance;
import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.VisitingDataStaffDto;
import com.Msso.MssoBusinessBackend.Repository.RepoVisitReport.RepoVisitReport;
import com.Msso.MssoBusinessBackend.Repository.RepoVisitReport.RepoVisitReportStaffCompliance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceVisitReportGetData {
    @Autowired
    RepoVisitReport repoVisitReport;
    @Autowired
    RepoVisitReportStaffCompliance reportStaffCompliance;
    public ExecutiveVisitingData getVisitDataByBranch(String branchCode, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);
        return executiveVisitingData;
    }
    public VisitDataStaffCompliance getVisitStaffComplianceData(String branchCode, LocalDate visit_date) {
        VisitDataStaffCompliance executiveVisitingData = reportStaffCompliance.getVisitStaffComplianceData(branchCode, visit_date);
        return executiveVisitingData;
    }
    public List<VisitingDataStaffDto> getVisitSummery(String branchCode,

                                                               String roname,
                                                               String u_loc) {


        List<VisitingDataStaffDto> visitReportSummryDtos = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            visitReportSummryDtos = this.reportStaffCompliance.getVisitSummeryHo();

        } else if (u_loc.equalsIgnoreCase("BR")) {
            visitReportSummryDtos = this.reportStaffCompliance.getVisitSummeryBranch(branchCode);

        } else {
            visitReportSummryDtos = this.reportStaffCompliance.getVisitSummeryRO(roname);

        }
        return visitReportSummryDtos;

    }
}
