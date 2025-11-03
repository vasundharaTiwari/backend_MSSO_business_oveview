package com.Msso.MssoBusinessBackend.Controller.ControllerBranchProfile;

import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.ExecutiveVisitingData;
import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.VisitDataStaffCompliance;
import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.VisitRemarkParameter;
import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.VisitingDataStaffDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileDisbursement.MssoProfileDailyDisburseDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileTargetDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoAccountStatusDigitalTargetDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileAccountStatusDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileDigitalProductDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoFiSchemeDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileComplianceDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileReviewRenewalDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.*;
import com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/visit-report")
public class VisitReportController {

    @Autowired
    ServiceVisitReportSaveData serviceVisitReport;
    @Autowired
    ServiceVisitReportGetData serviceVisitReportGetData;



    @GetMapping("/visit-report")
    public ExecutiveVisitingData getVisitReport(@RequestParam String branchCode, @RequestParam LocalDate visit_date) {

        ExecutiveVisitingData executiveVisitingData;
        executiveVisitingData = serviceVisitReportGetData.getVisitDataByBranch(branchCode,visit_date);


        System.out.println("visit-report   "+executiveVisitingData.getVisit_date());
        return executiveVisitingData;
    }
    //*********************************************************************************
    @GetMapping("/visit-report_compliance")
    public VisitDataStaffCompliance getVisitStaffCompliance(@RequestParam String branchCode, @RequestParam LocalDate visit_date) {

        VisitDataStaffCompliance executiveVisitingData;
        executiveVisitingData = serviceVisitReportGetData.getVisitStaffComplianceData(branchCode,visit_date);


        System.out.println("visit-report_compliance");
        return executiveVisitingData;
    }
    //*********************************************************************************
    @PostMapping("/visit-report-save")
    public ExecutiveVisitingData savevisitData(@RequestBody VisitRemarkParameter visitRemarkParameter) {
       // LocalDate visit_date = LocalDate.parse("2025-07-17");

        return serviceVisitReport.updateVisitReport(visitRemarkParameter);
    }
    //*********************************************************************************
    @GetMapping("/visit-summery")
    public List<VisitingDataStaffDto> getVisitSummery(
            @RequestParam String branchCode,

            @RequestParam String roname,
             @RequestParam String u_loc) {

        List<VisitingDataStaffDto> visitReportSummryDto = serviceVisitReportGetData.getVisitSummery(branchCode, roname, u_loc);

        System.out.println("/visit-summery");
        return visitReportSummryDto;
    }

//    ****************************************************************************************************************
    @GetMapping("/dep-adv-npa")
    public MssoBranchProfileActualDataDto getBranchProfileActual(
            @RequestParam String branchCode,

            @RequestParam String roname,
            @RequestParam String u_loc, @RequestParam Date visit_date) {
        MssoBranchProfileActualDataDto mssoBranchProfileDto = null;
   
            mssoBranchProfileDto = this.serviceVisitReportGetData.getVisitReportBranchProfile(branchCode, roname, u_loc, visit_date);
            return mssoBranchProfileDto;
        
    }
    //*********************************************************************************

    @GetMapping("/dep-adv-npa-march")
        public List<MssoBranchProfileActualDataDto> getBranchProfileLastMarch (
                @RequestParam String branchCode,

                @RequestParam String roname,
                @RequestParam String u_loc, @RequestParam Date visit_date) {

        List<MssoBranchProfileActualDataDto> mssoBranchProfileMarchData = serviceVisitReportGetData.getVisitReportLastMarchData(branchCode, roname, u_loc,visit_date);

        System.out.println("inside dep-adv-npa-march");
        return mssoBranchProfileMarchData;
    }
    //*********************************************************************************


    @GetMapping("/dep-adv-npa-target")
    public MssoBranchProfileTargetDataDto getBranchProfileQuaterTarget(
            @RequestParam String branchCode,

            @RequestParam String roname,
            @RequestParam String u_loc , @RequestParam Date visit_date) {

        MssoBranchProfileTargetDataDto mssoBranchProfileTargetData = serviceVisitReportGetData.getVisitReportquarterData(branchCode, roname, u_loc,visit_date);

        System.out.println("inside dep-adv-npa-target");
        return mssoBranchProfileTargetData;
    }
    //*********************************************************************************


    @GetMapping("/dep-adv-npa-target-march")
    public MssoBranchProfileTargetDataDto getBranchProfilemarchTarget(
            @RequestParam String branchCode,

            @RequestParam String roname,
            @RequestParam String u_loc, @RequestParam Date visit_date) {

        MssoBranchProfileTargetDataDto mssoBranchProfileTargetData = serviceVisitReportGetData.getVisitReportMarchTargetData(branchCode, roname, u_loc,visit_date);

        System.out.println("inside dep-adv-npa-target");
        return mssoBranchProfileTargetData;
    }
    //*********************************************************************************


    @GetMapping("/super-achiever-march")
    public MssoBranchProfileTargetDataDto getSuperAchieverMarch(
            @RequestParam String branchCode,

            @RequestParam String roname,
            @RequestParam String u_loc, @RequestParam Date visit_date) {

        MssoBranchProfileTargetDataDto mssoBranchProfileTargetData = serviceVisitReportGetData.getVisitReportSuperAchieverData(branchCode, roname, u_loc,visit_date);

        System.out.println("inside dep-adv-npa-target");
        return mssoBranchProfileTargetData;
    }
    //*********************************************************************************


    @GetMapping("/dep-adv-npa-mar-gap")
    public MssoBranchProfileActualDataDto getBranchProfilemarchGap(
            @RequestParam String branchCode,

            @RequestParam String roname,
             @RequestParam String u_loc, @RequestParam Date visit_date) {

        MssoBranchProfileActualDataDto mssoBranchProfileActualDataDto = serviceVisitReportGetData.getVisitReportMarchGap(branchCode, roname, u_loc,visit_date);

        System.out.println("inside dep-adv-npa-mar-gap");
        return mssoBranchProfileActualDataDto;
    }
    //*********************************************************************************


    @GetMapping("/mar-gap-percentage")
    public MssoBranchProfileActualDataDto getBranchProfilemarchGapPercentage(
            @RequestParam String branchCode,

            @RequestParam String roname,
             @RequestParam String u_loc, @RequestParam Date visit_date) {

        MssoBranchProfileActualDataDto mssoBranchProfileActualDataDto = serviceVisitReportGetData.getVisitReportMarchGapPercentage(branchCode, roname, u_loc,visit_date);

        System.out.println("inside mar-gap-percentage");
        return mssoBranchProfileActualDataDto;
    }
    //*********************************************************************************


    @GetMapping("/dep-adv-npa-quarter-gap")
    public MssoBranchProfileTargetDataDto getBranchProfileQuarterGap(
            @RequestParam String branchCode,

            @RequestParam String roname,
             @RequestParam String u_loc, @RequestParam Date visit_date) {

        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = serviceVisitReportGetData.getVisitReportquarterGapData(branchCode, roname, u_loc,visit_date);

        System.out.println("inside dep-adv-npa-quarter-gap");
        return mssoBranchProfileTargetDataDto;
    }
    //*********************************************************************************


    @GetMapping("/daily-disbursement")
    public MssoProfileDailyDisburseDto getDailyDisbursement(


            @RequestParam String roname,
            @RequestParam String branchCode,
             @RequestParam String u_loc, @RequestParam Date visit_date) {

        MssoProfileDailyDisburseDto mssoProfileDailyDisburseDto = serviceVisitReportGetData.getVisitReportDailyDisburse(branchCode, roname, u_loc,visit_date);


        System.out.println("inside daily-disbursement");
        return mssoProfileDailyDisburseDto;
    }

    //*********************************************************************************


    @GetMapping("/disbursement-target")
    public MssoProfileDailyDisburseDto getDisbursementTarget(


            @RequestParam String roname,
            @RequestParam String branchCode,
             @RequestParam String u_loc, @RequestParam Date visit_date) {

        MssoProfileDailyDisburseDto mssoProfileDailyDisburseDto = serviceVisitReportGetData.getVisitReportDisburseTarget(branchCode, roname, u_loc,visit_date);


        System.out.println("disbursement-target");
        return mssoProfileDailyDisburseDto;
    }
    //*********************************************************************************


    @GetMapping("/daily-sma")
    public MssoBranchProfileSmaDto getMssoDailySma(


            @RequestParam String roname,
            @RequestParam String branchCode,
             @RequestParam String u_loc, @RequestParam Date visit_date) {

        MssoBranchProfileSmaDto mssoBranchProfileSmaDto = serviceVisitReportGetData.getVisitReportSma(branchCode, roname, u_loc,visit_date);


        System.out.println("inside daily-sma");
        return mssoBranchProfileSmaDto;
    }

    //*********************************************************************************


    @GetMapping("/npa_classification")
    public MssoProfileNpaClassificationDto getMssoNpaClassification(


            @RequestParam String roname,
            @RequestParam String branchCode,
             @RequestParam String u_loc, @RequestParam Date visit_date) {

        MssoProfileNpaClassificationDto mssoNpaClassification = serviceVisitReportGetData.getVisitReportNpaClassification(branchCode, roname, u_loc,visit_date);


        System.out.println("npa_classification");
        return mssoNpaClassification;
    }

    //*********************************************************************************


    @GetMapping("/npa_sectorwise")
    public SectorwiseNpaDto getNpaSectorwise(


            @RequestParam String roname,
            @RequestParam String branchCode,
             @RequestParam String u_loc, @RequestParam Date visit_date) {

        SectorwiseNpaDto sectorwiseNpaDto = serviceVisitReportGetData.getVisitReportSectorwiseNpa(branchCode, roname, u_loc,visit_date);


        System.out.println("npa_sectorwise");
        return sectorwiseNpaDto;
    }
    //*********************************************************************************
    @GetMapping("/npa_amountwise")
    public AmountwiseNpaDto getNpaAmountwise(


            @RequestParam String roname,
            @RequestParam String branchCode,
             @RequestParam String u_loc, @RequestParam Date visit_date) {

        AmountwiseNpaDto amountwiseNpaDto = serviceVisitReportGetData.getVisitReportAmountwiseNpa(branchCode, roname, u_loc,visit_date);


        System.out.println("npa_amountwise");
        return amountwiseNpaDto;
    }
    //*********************************************************************************
    @GetMapping("/npa-progress")
    public NpaRecoveryProgressDto getNpaProgress(


            @RequestParam String roname,
            @RequestParam String branchCode,
             @RequestParam String u_loc, @RequestParam Date visit_date) {

        NpaRecoveryProgressDto npaRecoveryProgressDto = serviceVisitReportGetData.getVisitReportNpaRecoveryProgress(branchCode, roname, u_loc,visit_date);


        System.out.println("npa-progress");
        return npaRecoveryProgressDto;
    }
    //*********************************************************************************

    @GetMapping("/npa-progress-march")
    public NpaRecoveryProgressDto getNpaProgressMarch(


            @RequestParam String roname,
            @RequestParam String branchCode,
             @RequestParam String u_loc, @RequestParam Date visit_date) {

        NpaRecoveryProgressDto npaRecoveryProgressDto = serviceVisitReportGetData.getVisitReportNpaProgressMarch(branchCode, roname, u_loc,visit_date);


        System.out.println("npa-progress");
        return npaRecoveryProgressDto;
    }

    //*********************************************************************************
    @GetMapping("/account-status")
    public MssoBranchProfileAccountStatusDto getMssoAccountStatus(


            @RequestParam String roname,
            @RequestParam String branchCode,
             @RequestParam String u_loc, @RequestParam Date visit_date) {

        MssoBranchProfileAccountStatusDto mssoBranchProfileAccountStatusDto = serviceVisitReportGetData.getVisitReportAccountStatus(branchCode, roname, u_loc,visit_date);


        System.out.println("inside account-status");
        return mssoBranchProfileAccountStatusDto;
    }
    //*********************************************************************************
        @GetMapping("/digital-product")
    public MssoBranchProfileDigitalProductDto getMssoDigitalProduct(


            @RequestParam String roname,
            @RequestParam String branchCode,
             @RequestParam String u_loc, @RequestParam Date visit_date) {

        MssoBranchProfileDigitalProductDto mssoBranchProfileDigitalProductDto = serviceVisitReportGetData.getVisitReportDigitalProduct(branchCode, roname, u_loc,visit_date);


        System.out.println("inside digital-product");
        return mssoBranchProfileDigitalProductDto;
    }
    //*********************************************************************************
    @GetMapping("/account-digital-target")
    public MssoAccountStatusDigitalTargetDto getMssoAccountDigitalProductTarget(


            @RequestParam String roname,
            @RequestParam String branchCode,
             @RequestParam String u_loc, @RequestParam Date visit_date) {

        MssoAccountStatusDigitalTargetDto mssoAccountStatusDigitalTargetDto = serviceVisitReportGetData.getVisitReportDigitalTarget(branchCode, roname, u_loc,visit_date);


        System.out.println("inside digital-product");
        return mssoAccountStatusDigitalTargetDto;
    }

    //*********************************************************************************
    @GetMapping("/fi-scheme-target")
    public MssoFiSchemeDto getMssoFiSchemeTarget(


            @RequestParam String roname,
            @RequestParam String branchCode,
             @RequestParam String u_loc, @RequestParam Date visit_date) {

        MssoFiSchemeDto mssoFiSchemeDto = serviceVisitReportGetData.getVisitReportFiSchemeTarget(branchCode, roname, u_loc,visit_date);


        System.out.println("fi-scheme-target");
        return mssoFiSchemeDto;
    }
    //*********************************************************************************
    @GetMapping("/fi-scheme")
    public MssoFiSchemeDto getFiSchemeData(


            @RequestParam String roname,
            @RequestParam String branchCode,
             @RequestParam String u_loc, @RequestParam Date visit_date) {

        MssoFiSchemeDto mssoFiSchemeDto = serviceVisitReportGetData.getVisitReportFiScheme(branchCode, roname, u_loc,visit_date);


        System.out.println("fi-scheme");
        return mssoFiSchemeDto;
    }
    //*********************************************************************************
    @GetMapping("/review-renewal-pending")
    public MssoProfileReviewRenewalDto getPendingReview(


            @RequestParam String roname,
            @RequestParam String branchCode,
             @RequestParam String u_loc, @RequestParam Date visit_date) {

        MssoProfileReviewRenewalDto mssoProfileReviewRenewalPending = serviceVisitReportGetData.getVisitReportReviewRenewal(branchCode, roname, u_loc,visit_date);


        System.out.println("inside review renewal pending");
        return mssoProfileReviewRenewalPending;
    }
    //*********************************************************************************
    @GetMapping("/timebarred")
    public MssoProfileComplianceDto getTimebarred(


            @RequestParam String roname,
            @RequestParam String branchCode,
             @RequestParam String u_loc, @RequestParam Date visit_date) {

        MssoProfileComplianceDto mssoProfileTimebarred = serviceVisitReportGetData.getVisitReportTimebarred(branchCode, roname, u_loc,visit_date);


        System.out.println("inside timebarred");
        return mssoProfileTimebarred;
    }

}
