package com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.ExecutiveVisitingData;
import com.Msso.MssoBusinessBackend.Repository.RepoVisitReport.RepoVisitReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class ServiceVisitReport {
    @Autowired
    RepoVisitReport repoVisitReport;

    public ExecutiveVisitingData getVisitDataByBranch(String branchCode, LocalDate  visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode,visit_date);
        return executiveVisitingData;
    }


}
