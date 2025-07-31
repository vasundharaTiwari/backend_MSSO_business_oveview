package com.Msso.MssoBusinessBackend.Controller.ControllerBranchProfile;

import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.ExecutiveVisitingData;
import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.VisitDataStaffCompliance;
import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.VisitRemarkParameter;
import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.VisitingDataStaffDto;
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
    ServiceVisitReportSaveData serviceVisitReport;
    @Autowired
    ServiceVisitReportGetData serviceVisitReportGetData;

    @GetMapping("/visit-report")
    public ExecutiveVisitingData getVisitReport(@RequestParam String branchCode, @RequestParam LocalDate visit_date) {

        ExecutiveVisitingData executiveVisitingData;
        executiveVisitingData = serviceVisitReportGetData.getVisitDataByBranch(branchCode,visit_date);


        System.out.println("visit-report");
        return executiveVisitingData;
    }

    @GetMapping("/visit-report_compliance")
    public VisitDataStaffCompliance getVisitStaffCompliance(@RequestParam String branchCode, @RequestParam LocalDate visit_date) {

        VisitDataStaffCompliance executiveVisitingData;
        executiveVisitingData = serviceVisitReportGetData.getVisitStaffComplianceData(branchCode,visit_date);


        System.out.println("visit-report");
        return executiveVisitingData;
    }

    @PostMapping("/visit-report-save")
    public VisitDataStaffCompliance savevisitData(@RequestBody VisitRemarkParameter visitRemarkParameter) {
       // LocalDate visit_date = LocalDate.parse("2025-07-17");

        return serviceVisitReport.updateVisitReport(visitRemarkParameter);
    }
    @GetMapping("/visit-summery")
    public List<VisitingDataStaffDto> getBranchProfileLastMarch(
            @RequestParam String branchCode,

            @RequestParam String roname,
            @RequestParam String u_loc) {

        List<VisitingDataStaffDto> visitReportSummryDto = serviceVisitReportGetData.getVisitSummery(branchCode, roname, u_loc);

        System.out.println("inside dep-adv-npa-march");
        return visitReportSummryDto;
    }
}
