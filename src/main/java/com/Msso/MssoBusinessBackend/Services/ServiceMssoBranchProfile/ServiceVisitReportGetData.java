package com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.ExecutiveVisitingData;
import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.VisitDataStaffCompliance;
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
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile.RepoMssoBranchProfileActualData;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile.RepoMssoBranchProfileTargetData;
import com.Msso.MssoBusinessBackend.Repository.RepoVisitReport.RepoVisitReport;
import com.Msso.MssoBusinessBackend.Repository.RepoVisitReport.RepoVisitReportStaffCompliance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceVisitReportGetData {
    @Autowired
    RepoVisitReport repoVisitReport;
    @Autowired
    RepoVisitReportStaffCompliance reportStaffCompliance;
    @Autowired
    ServiceVisitReportSaveData serviceVisitReportSaveData;
    @Autowired
    RepoMssoBranchProfileActualData repoMssoBranchProfilePreviousData;
    @Autowired
    RepoMssoBranchProfileTargetData repoMssoBranchProfileTargetData;


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

    public MssoBranchProfileActualDataDto getVisitReportBranchProfile(String branchCode,

                                                                      String roname,
                                                                      String u_loc, Date visit_date) {
        MssoBranchProfileActualDataDto mssoBranchProfileDto = new MssoBranchProfileActualDataDto();

        if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileDto = this.repoVisitReport.getBranchProfileVisitReportBranch(branchCode, visit_date);

        } else {
            System.out.println("inside");
            mssoBranchProfileDto = this.repoVisitReport.getBranchProfileVisitReportRO(roname, visit_date);
            System.out.println(mssoBranchProfileDto);
        }

        return mssoBranchProfileDto;
    }

    public MssoBranchProfileSmaDto getVisitReportSma(String branchCode,

                                                     String roname,
                                                     String u_loc, Date visit_date) {

        MssoBranchProfileSmaDto mssoBranchProfileSmaDto = null;
        if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileSmaDto = this.repoVisitReport.getVisitReportSmaBranch(branchCode, (visit_date));

        } else {
            mssoBranchProfileSmaDto = this.repoVisitReport.getVisitReportSmaRO(roname, (visit_date));

        }
        return mssoBranchProfileSmaDto;
    }

    public MssoProfileNpaClassificationDto getVisitReportNpaClassification(String branchCode,

                                                                           String roname,
                                                                           String u_loc, Date visit_date) {
        MssoProfileNpaClassificationDto mssoProfileNpaClassificationDto = null;

        if (u_loc.equalsIgnoreCase("BR")) {
            mssoProfileNpaClassificationDto = this.repoVisitReport.getVisitReportNpaClassificationBranch(branchCode, (visit_date));
        } else {
            mssoProfileNpaClassificationDto = this.repoVisitReport.getVisitReportNpaClassificationRO(roname, (visit_date));
        }

        return mssoProfileNpaClassificationDto;
    }

    public MssoProfileReviewRenewalDto getVisitReportReviewRenewal(String branchCode,

                                                                   String roname,
                                                                   String u_loc, Date visit_date) {

        MssoProfileReviewRenewalDto mssoProfileReviewRenewalPending = null;
        if (u_loc.equalsIgnoreCase("BR")) {
            mssoProfileReviewRenewalPending = this.repoVisitReport.getVisitReportRevieRenewalBranch(branchCode, (visit_date));

        } else {
            mssoProfileReviewRenewalPending = this.repoVisitReport.getVisitReportRevieRenewalRO(roname, (visit_date));
        }
        return mssoProfileReviewRenewalPending;
    }

    public List<MssoBranchProfileActualDataDto> getVisitReportLastMarchData(String branchCode,

                                                                            String roname,
                                                                            String u_loc, Date visit_date) {


        List<LocalDate> marchEndDates = serviceVisitReportSaveData.getLastThreeMarchEndDates(visit_date.toLocalDate());
        marchEndDates.forEach(System.out::println);
        List<MssoBranchProfileActualDataDto> mssoBranchProfileActualDataDto;
        if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileActualDataDto = this.repoMssoBranchProfilePreviousData.getBranchProfileBranchMarchData(branchCode, marchEndDates);
        } else {
            mssoBranchProfileActualDataDto = this.repoMssoBranchProfilePreviousData.getBranchProfileROMarchData(roname, marchEndDates);
        }
        return mssoBranchProfileActualDataDto;
    }

    public MssoBranchProfileActualDataDto getVisitReportMarchGap(String branchCode,

                                                                 String roname,
                                                                 String u_loc, Date visit_date) {

        LocalDate marchEndDates = serviceVisitReportSaveData.getLastMarchEndDates(visit_date.toLocalDate());
        MssoBranchProfileActualDataDto mssoMarchGapDto = null;
        if (u_loc.equalsIgnoreCase("BR")) {
            mssoMarchGapDto = this.repoVisitReport.getVisitReportMarchBranchGap(branchCode, marchEndDates, (visit_date));
        } else {
            mssoMarchGapDto = this.repoVisitReport.getVisitReportMarchRoGap(roname, marchEndDates, (visit_date));
        }

        return mssoMarchGapDto;
    }

    public MssoBranchProfileActualDataDto getVisitReportMarchGapPercentage(String branchCode,

                                                                           String roname,
                                                                           String u_loc, Date visit_date) {


        LocalDate marchEndDates = serviceVisitReportSaveData.getLastMarchEndDates(visit_date.toLocalDate());
        MssoBranchProfileActualDataDto mssoBranchProfileActualDataDto = null;
        if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileActualDataDto = this.repoVisitReport.getVisitReportMarchBranchGapPercentage(branchCode, marchEndDates, (visit_date));
        } else {
            mssoBranchProfileActualDataDto = this.repoVisitReport.getVisitReportMarchRoGapPercentage(roname, marchEndDates, (visit_date));


        }
        return mssoBranchProfileActualDataDto;
    }

    public MssoBranchProfileTargetDataDto getVisitReportquarterData(String branchCode,

                                                                    String roname,
                                                                    String u_loc, Date visit_date) {


        LocalDate quarterEndDate = serviceVisitReportSaveData.getCurrentquarterEndDateDate(visit_date.toLocalDate());
        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = null;
        if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchTargetBranch(branchCode, quarterEndDate);
        } else {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchTargetRO(roname, quarterEndDate);
        }
        return mssoBranchProfileTargetDataDto;
    }

    public MssoBranchProfileTargetDataDto getVisitReportquarterGapData(String branchCode,

                                                                       String roname,
                                                                       String u_loc, Date visit_date) {


        LocalDate quarterEndDate = serviceVisitReportSaveData.getCurrentquarterEndDateDate(visit_date.toLocalDate());
        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = null;
        if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileTargetDataDto = this.repoVisitReport.getVisitReportQuarterBranchGap(branchCode, quarterEndDate, (visit_date));
        } else {
            mssoBranchProfileTargetDataDto = this.repoVisitReport.getVisitReportQuarterRoGap(roname, quarterEndDate, (visit_date));
        }
        return mssoBranchProfileTargetDataDto;
    }


    public MssoBranchProfileTargetDataDto getVisitReportMarchTargetData(String branchCode,

                                                                        String roname,
                                                                        String u_loc, Date visit_date) {


        LocalDate endDate = serviceVisitReportSaveData.getFinancialYearEndDate(visit_date.toLocalDate());
        System.out.println("getFinancialYearEndDate  " + endDate);
        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = null;
        if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchTargetBranch(branchCode, endDate);
        } else {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchTargetRO(roname, endDate);
        }
        return mssoBranchProfileTargetDataDto;
    }

    public MssoBranchProfileTargetDataDto getVisitReportSuperAchieverData(String branchCode,

                                                                          String roname,
                                                                          String u_loc, Date visit_date) {


        LocalDate endDate = serviceVisitReportSaveData.getFinancialYearEndDate(visit_date.toLocalDate());
        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = null;

        if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getSuperAchieverBranch(branchCode, endDate);
        } else {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getSuperAchieverRO(roname, endDate);
        }
        return mssoBranchProfileTargetDataDto;

    }

    public MssoFiSchemeDto getVisitReportFiScheme(String branchCode,

                                                  String roname,
                                                  String u_loc, Date visit_date) {


        MssoFiSchemeDto mssoFiSchemeDto = null;
        if (u_loc.equalsIgnoreCase("BR")) {

            mssoFiSchemeDto = this.repoVisitReport.getVisitReportFiSchemeBranch(branchCode, (visit_date));
        } else {
            mssoFiSchemeDto = this.repoVisitReport.getVisitReportFiSchemeRO(roname, (visit_date));
        }
        return mssoFiSchemeDto;
    }

    public MssoFiSchemeDto getVisitReportFiSchemeTarget(String branchCode,

                                                        String roname,
                                                        String u_loc, Date visit_date) {


        MssoFiSchemeDto mssoFiSchemeDto = null;
        LocalDate endDate = serviceVisitReportSaveData.getFinancialYearEndDate(visit_date.toLocalDate());
        System.out.println("updateVisitReportSSSTarget  " + endDate);
        if (u_loc.equalsIgnoreCase("BR")) {
            mssoFiSchemeDto = this.repoVisitReport.getVisitReportFiSchemeTargetBranch(branchCode, Date.valueOf((endDate)));
        } else {
            mssoFiSchemeDto = this.repoVisitReport.getVisitReportFiSchemeTargetRO(roname, Date.valueOf((endDate)));
        }
        return mssoFiSchemeDto;
    }

    public AmountwiseNpaDto getVisitReportAmountwiseNpa(String branchCode,

                                                        String roname,
                                                        String u_loc, Date visit_date) {


        AmountwiseNpaDto amountwiseNpaDto = null;

        if (u_loc.equalsIgnoreCase("BR")) {
            amountwiseNpaDto = this.repoVisitReport.getNpaAmountVisitReportBranch(branchCode, (visit_date));

        } else {
            amountwiseNpaDto = this.repoVisitReport.getNpaAmountVisitReportRO(roname, (visit_date));

        }
        return amountwiseNpaDto;
    }


    public SectorwiseNpaDto getVisitReportSectorwiseNpa(String branchCode,

                                                        String roname,
                                                        String u_loc, Date visit_date) {


        SectorwiseNpaDto sectorwiseNpaDto = null;

        if (u_loc.equalsIgnoreCase("BR")) {
            sectorwiseNpaDto = this.repoVisitReport.getNpaSectorVisitReportBranch(branchCode, (visit_date));

        } else {
            sectorwiseNpaDto = this.repoVisitReport.getNpaSectorVisitReportRO(roname, (visit_date));

        }
        return sectorwiseNpaDto;
    }

    public NpaRecoveryProgressDto getVisitReportNpaRecoveryProgress(String branchCode,

                                                              String roname,
                                                              String u_loc, Date visit_date) {




        NpaRecoveryProgressDto npaRecoveryProgressDto = null;

        if (u_loc.equalsIgnoreCase("BR")) {
            npaRecoveryProgressDto = this.repoVisitReport.getNpaProgressVisitReportBranch(branchCode, Date.valueOf(visit_date.toLocalDate()));
        } else {
            npaRecoveryProgressDto = this.repoVisitReport.getNpaProgressVisitReportRO(roname, Date.valueOf(visit_date.toLocalDate()));
        }
        return npaRecoveryProgressDto;
    }

    public NpaRecoveryProgressDto getVisitReportNpaProgressMarch(String branchCode,

                                                                 String roname,
                                                                 String u_loc, Date visit_date) {


        NpaRecoveryProgressDto npaRecoveryProgressDtoMarch = null;
        if (u_loc.equalsIgnoreCase("BR")) {
            npaRecoveryProgressDtoMarch = this.repoVisitReport.getNpaProgressMarchVisitReportBranch(branchCode, Date.valueOf(visit_date.toLocalDate()));
        } else {
            npaRecoveryProgressDtoMarch = this.repoVisitReport.getNpaProgressMarchVisitReportRO(roname, Date.valueOf(visit_date.toLocalDate()));
        }
        return npaRecoveryProgressDtoMarch;
    }

    public MssoBranchProfileAccountStatusDto getVisitReportAccountStatus(String branchCode,

                                                                         String roname,
                                                                         String u_loc, Date visit_date) {

        MssoBranchProfileAccountStatusDto mssoBranchProfileAccountStatusDto = null;
        if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileAccountStatusDto = this.repoVisitReport.getVisitReportAccountStatusBranch(branchCode, Date.valueOf(visit_date.toLocalDate()));
        } else {
            mssoBranchProfileAccountStatusDto = this.repoVisitReport.getVisitReportAccountStatusRO(roname, Date.valueOf(visit_date.toLocalDate()));
        }

        return mssoBranchProfileAccountStatusDto;
    }


    public MssoAccountStatusDigitalTargetDto getVisitReportDigitalTarget(String branchCode,

                                                                         String roname,
                                                                         String u_loc, Date visit_date) {

        MssoAccountStatusDigitalTargetDto mssoAccountStatusDigitalTargetDto = null;
        LocalDate quarterDate = serviceVisitReportSaveData.getCurrentquarterEndDateDate(visit_date.toLocalDate());
        if (u_loc.equalsIgnoreCase("BR")) {
            mssoAccountStatusDigitalTargetDto = this.repoVisitReport.getVisitReportAccountDigitalTargetBranch(branchCode, Date.valueOf(quarterDate));
        } else {
            mssoAccountStatusDigitalTargetDto = this.repoVisitReport.getVisitReportAccountDigitalTargetRO(roname, Date.valueOf(quarterDate));
        }

        return mssoAccountStatusDigitalTargetDto;
    }


    public MssoBranchProfileDigitalProductDto getVisitReportDigitalProduct(String branchCode,

                                                                           String roname,
                                                                           String u_loc, Date visit_date) {


        MssoBranchProfileDigitalProductDto mssoBranchProfileDigitalProductDto = null;
        if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileDigitalProductDto = this.repoVisitReport.getVisitReportDigitalproductBranch(branchCode, Date.valueOf(visit_date.toLocalDate()));
        } else {
            mssoBranchProfileDigitalProductDto = this.repoVisitReport.getVisitReportDigitalproductRO(roname, Date.valueOf(visit_date.toLocalDate()));
        }

        return mssoBranchProfileDigitalProductDto;
    }

    public MssoProfileDailyDisburseDto getVisitReportDailyDisburse(String branchCode,

                                                                   String roname,
                                                                   String u_loc, Date visit_date) {


        MssoProfileDailyDisburseDto mssoProfileDailyDisburseDto = null;
        if (u_loc.equalsIgnoreCase("BR")) {
            mssoProfileDailyDisburseDto = this.repoVisitReport.getVisitReportDailyDisbursementBranch(branchCode, Date.valueOf(visit_date.toLocalDate()));
        } else {
            mssoProfileDailyDisburseDto = this.repoVisitReport.getVisitReportDailyDisbursementRO(roname, Date.valueOf(visit_date.toLocalDate()));
        }
        return mssoProfileDailyDisburseDto;
    }

    public MssoProfileDailyDisburseDto getVisitReportDisburseTarget(String branchCode,

                                                                    String roname,
                                                                    String u_loc, Date visit_date) {


        LocalDate quarterDate = serviceVisitReportSaveData.getCurrentquarterEndDateDate(visit_date.toLocalDate());
        MssoProfileDailyDisburseDto mssoProfileDailyDisburseDto = null;
        if (u_loc.equalsIgnoreCase("BR")) {
            mssoProfileDailyDisburseDto = this.repoVisitReport.getVisitReportDailyDisbursementTargetBranch(branchCode, Date.valueOf(quarterDate));
        } else {
            mssoProfileDailyDisburseDto = this.repoVisitReport.getVisitReportDailyDisbursementTargetRO(roname, Date.valueOf(quarterDate));
        }
        return mssoProfileDailyDisburseDto;
    }

    public MssoProfileComplianceDto getVisitReportTimebarred(String branchCode,

                                                             String roname,
                                                             String u_loc, Date visit_date) {


        MssoProfileComplianceDto mssoProfileTimebarred = null;
        if (u_loc.equalsIgnoreCase("BR")) {
            mssoProfileTimebarred = this.repoVisitReport.getgetTimebarredVisitReportBranch(branchCode, Date.valueOf(visit_date.toLocalDate()));
        } else {
            mssoProfileTimebarred = this.repoVisitReport.getgetTimebarredVisitReportRO(roname, Date.valueOf(visit_date.toLocalDate()));
        }

        return mssoProfileTimebarred;
    }
}
