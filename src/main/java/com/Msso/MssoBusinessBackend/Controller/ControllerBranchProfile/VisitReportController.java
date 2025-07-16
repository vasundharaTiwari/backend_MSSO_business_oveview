package com.Msso.MssoBusinessBackend.Controller.ControllerBranchProfile;

import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.ExecutiveVisitingData;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileDisbursement.MssoProfileDailyDisburseDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileTargetDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoAccountStatusDigitalTargetDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileAccountStatusDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileDigitalProductDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoFiSchemeDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileComplianceDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileReviewRenewalDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.MssoBranchProfileSmaDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.MssoProfileNpaClassificationDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile.RepoMssoBranchProfileActualData;
import com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/msso-branch-profile")
public class VisitReportController {

    @Autowired
    ServiceVisitReport serviceVisitReport;




    @GetMapping("/visit-report")
    public ExecutiveVisitingData getVisitReport( @RequestParam String branchCode, @RequestParam LocalDate  visit_date)
          {

              ExecutiveVisitingData executiveVisitingData = serviceVisitReport.getVisitDataByBranch(branchCode,visit_date);


        System.out.println("visit-report");
        return executiveVisitingData;
    }

    @PostMapping("/visit-report-save")
    public ExecutiveVisitingData savevisitData( @RequestParam String branchCode, @RequestParam LocalDate  visit_date)
    {

       //  serviceVisitReport.updateVisitReport(branchCode);
         serviceVisitReport.updateVisitReportActual(branchCode,visit_date);
        return serviceVisitReport.updateVisitReportNpa(branchCode,visit_date);



    }
}
