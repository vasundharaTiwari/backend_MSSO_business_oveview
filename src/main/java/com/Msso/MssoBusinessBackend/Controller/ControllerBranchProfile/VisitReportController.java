package com.Msso.MssoBusinessBackend.Controller.ControllerBranchProfile;

import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.ExecutiveVisitingData;
import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.VisitRemarkParameter;
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
    public ExecutiveVisitingData getVisitReport(@RequestParam String branchCode, @RequestParam LocalDate visit_date) {

        ExecutiveVisitingData executiveVisitingData = serviceVisitReport.getVisitDataByBranch(branchCode, visit_date);


        System.out.println("visit-report");
        return executiveVisitingData;
    }

    @PostMapping("/visit-report-save")
    public ExecutiveVisitingData savevisitData(@RequestBody VisitRemarkParameter visitRemarkParameter) {
        LocalDate visit_date = LocalDate.parse("2025-07-17");
        System.out.println(visitRemarkParameter.getBranch_code());
         serviceVisitReport.updateVisitReport(visitRemarkParameter);
        serviceVisitReport.updateVisitReportSma(visitRemarkParameter.getBranch_code(), visit_date);
        serviceVisitReport.updateVisitReportNpa(visitRemarkParameter.getBranch_code(), visit_date);
        serviceVisitReport.updateVisitReportReviewRenewal(visitRemarkParameter.getBranch_code(), visit_date);
        serviceVisitReport.updateVisitReportMarchPast(visitRemarkParameter.getBranch_code(), visit_date);
        serviceVisitReport.updateVisitReportMarchPast(visitRemarkParameter.getBranch_code(), visit_date);

        serviceVisitReport.updateVisitReportMarchGap(visitRemarkParameter.getBranch_code(), visit_date);
        serviceVisitReport.updateVisitReportGapPercent(visitRemarkParameter.getBranch_code(), visit_date);
        serviceVisitReport.updateVisitReportTargetData(visitRemarkParameter.getBranch_code(), visit_date);
        serviceVisitReport.updateVisitReportTargetGap(visitRemarkParameter.getBranch_code(), visit_date);
        serviceVisitReport.updateVisitReportComingMarchTarget(visitRemarkParameter.getBranch_code(), visit_date);
        serviceVisitReport.updateVisitReportComingMarchSuper(visitRemarkParameter.getBranch_code(), visit_date);
        serviceVisitReport.updateVisitReportSSS(visitRemarkParameter.getBranch_code(), visit_date);
        serviceVisitReport.updateVisitReportSSSTarget(visitRemarkParameter.getBranch_code(), visit_date);
        serviceVisitReport.updateVisitReportAccout(visitRemarkParameter.getBranch_code(), visit_date);
        serviceVisitReport.updateVisitReportAccoutMarch(visitRemarkParameter.getBranch_code(), visit_date);
        serviceVisitReport.updateVisitReportAccoutTarget(visitRemarkParameter.getBranch_code(), visit_date);
        serviceVisitReport.updateVisitReportDigital(visitRemarkParameter.getBranch_code(), visit_date);
        serviceVisitReport.updateVisitReportDisbursement(visitRemarkParameter.getBranch_code(), visit_date);
        serviceVisitReport.updateVisitReportDisbursementTarget(visitRemarkParameter.getBranch_code(), visit_date);
         serviceVisitReport.updateVisitReportTimeBarred(visitRemarkParameter.getBranch_code(), visit_date);

        return serviceVisitReport.updateVisitReportStaffSummery(visitRemarkParameter.getBranch_code(),visitRemarkParameter.getU_loc(),visitRemarkParameter.getRegion() ,visit_date);
    }
}
