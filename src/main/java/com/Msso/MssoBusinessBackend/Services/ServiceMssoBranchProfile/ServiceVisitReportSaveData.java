package com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.ExecutiveVisitingData;
import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.VisitDataStaffCompliance;
import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.VisitRemarkParameter;


import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.BranchCategoryDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.BranchOpeningDateDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.MssoBranchEmployeeDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.MssoEmployeeSummaryDto;
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
import com.Msso.MssoBusinessBackend.Repository.RepoBranchProfileAccountStatusDigitalProduct.RepoAccountDigitalFiSchemeTarget;
import com.Msso.MssoBusinessBackend.Repository.RepoBranchProfileAccountStatusDigitalProduct.RepoBranchprofileAccountStatus;
import com.Msso.MssoBusinessBackend.Repository.RepoBranchProfileAccountStatusDigitalProduct.RepoProfileDigitalProductFiScheme;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBrachProfileSma.RepoMssoBranchProfileSma;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchEmployeeData.RepoMssoBranchEmployeData;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile.RepoMssoBranchProfileActualData;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile.RepoMssoBranchProfileTargetData;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfileDailyDisbursement.RepoMssoBranchProfileDailyDisbursement;
import com.Msso.MssoBusinessBackend.Repository.RepoVisitReport.RepoVisitReport;
import com.Msso.MssoBusinessBackend.Repository.RepoVisitReport.RepoVisitReportStaffCompliance;
import com.Msso.MssoBusinessBackend.Service.ServiceMssoBranchData.MssoBranchDataService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceVisitReportSaveData {
    @Autowired
    private RepoMssoBranchEmployeData repoMssoBranchData;
    @Autowired
    RepoVisitReport repoVisitReport;
    @Autowired
    RepoMssoBranchProfileActualData repoMssoBranchProfile;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    RepoMssoBranchProfileSma repoMssoBranchProfileSma;
    @Autowired
    ServiceBranchProfileLast3Year serviceBranchProfileLast3Year;
    @Autowired
    RepoMssoBranchProfileActualData repoMssoBranchProfilePreviousData;
    @Autowired
    RepoMssoBranchProfileTargetData repoMssoBranchProfileTargetData;
    @Autowired
    ServiceMssoBranchProfileTargetData serviceMssoBranchProfileTargetData;
    @Autowired
    RepoProfileDigitalProductFiScheme repoBranchProfileDigitalProduct;
    @Autowired
    RepoBranchprofileAccountStatus repoBranchprofileAccountStatus;
    @Autowired
    RepoAccountDigitalFiSchemeTarget repoAccountDigitalTarget;
    @Autowired
    RepoMssoBranchProfileDailyDisbursement repoMssoDailyDisbursement;

    @Autowired
    RepoMssoBranchEmployeData repoEmployeData;
    @Autowired
    MssoBranchDataService mssoBranchDataService;
    @Autowired
    RepoVisitReportStaffCompliance reportStaffCompliance;


    @Transactional
    public VisitDataStaffCompliance updateVisitReport(VisitRemarkParameter visitRemarkParameter) {


        // Retrieve the RefNoVarification data by referenceId
        MssoBranchProfileActualDataDto mssoBranchProfileDto = new MssoBranchProfileActualDataDto();

        if (visitRemarkParameter.getU_loc().equalsIgnoreCase("BR")) {
            mssoBranchProfileDto = this.repoMssoBranchProfile.getBranchProfileBranch(visitRemarkParameter.getBranch_code());

        } else {
            System.out.println("inside");
            mssoBranchProfileDto = this.repoMssoBranchProfile.getBranchProfileRO(visitRemarkParameter.getRegion());
            System.out.println(mssoBranchProfileDto);
        }
        ExecutiveVisitingData executiveVisitingData = modelMapper.map(mssoBranchProfileDto, ExecutiveVisitingData.class);
        VisitDataStaffCompliance visitDataStaffCompliance = new VisitDataStaffCompliance();
        executiveVisitingData.setReport_date_actual(mssoBranchProfileDto.getReport_date());
        executiveVisitingData.setVisit_date(LocalDate.now());
        executiveVisitingData.setBranch_code(visitRemarkParameter.getBranch_code());
        executiveVisitingData.setRegion(visitRemarkParameter.getRegion());
        executiveVisitingData.setBmBranchJoinDate(visitRemarkParameter.getBmBranchJoinDate());

        visitDataStaffCompliance.setBranch_code(visitRemarkParameter.getBranch_code());
        visitDataStaffCompliance.setVisit_date(LocalDate.now());
        visitDataStaffCompliance.setVisitor_userid(visitRemarkParameter.getVisitor_userid());
        visitDataStaffCompliance.setVisitor_name(visitRemarkParameter.getVisitor_name());
        visitDataStaffCompliance.setVisitor_region(visitRemarkParameter.getVisitor_region());
        visitDataStaffCompliance.setVisitor_designation(visitRemarkParameter.getVisitor_designation());
        visitDataStaffCompliance.setVisitor_branch_code(visitRemarkParameter.getVisitor_branch_code());
        visitDataStaffCompliance.setU_loc(visitRemarkParameter.getU_loc());
        visitDataStaffCompliance.setSma0Percentage(visitRemarkParameter.getSma0Percentage());
        visitDataStaffCompliance.setSma1Percentage(visitRemarkParameter.getSma1Percentage());
        visitDataStaffCompliance.setSma2Percentage(visitRemarkParameter.getSma2Percentage());
        visitDataStaffCompliance.setSmaTotalPercentage(visitRemarkParameter.getSmaTotalPercentage());
        visitDataStaffCompliance.setBranchOpenDate(visitRemarkParameter.getBranchOpeningDate());
        //////////////////////////******************remark****************************
        visitDataStaffCompliance.setRegion(visitRemarkParameter.getRegion());
        visitDataStaffCompliance.setEmployeeDataRemark(visitRemarkParameter.getEmployeeDataRemark());

        visitDataStaffCompliance.setParameterDetailRemark(visitRemarkParameter.getParameterDetailRemark());
        visitDataStaffCompliance.setComplianceRemark(visitRemarkParameter.getComplianceRemark());
        visitDataStaffCompliance.setOtherRemark(visitRemarkParameter.getOtherRemark());
        visitDataStaffCompliance.setSmaRemark(visitRemarkParameter.getSmaRemark());
        visitDataStaffCompliance.setSocialSecurityRemark(visitRemarkParameter.getSocialSecurityRemark());
        visitDataStaffCompliance.setSanctionDisbursedRemark(visitRemarkParameter.getSanctionDisbursedRemark());
        visitDataStaffCompliance.setNpaClassificationRemark(visitRemarkParameter.getNpaClassificationRemark());
        visitDataStaffCompliance.setAccountAndDigitalStatusRemark(visitRemarkParameter.getAccountAndDigitalStatusRemark());
        visitDataStaffCompliance.setPerEmployeeBusiness(visitRemarkParameter.getPerEmployeeBusiness());
        visitDataStaffCompliance.setTotal_staff_branch(visitRemarkParameter.getTotal_staff_branch());
        visitDataStaffCompliance.setTotal_staff_region(visitRemarkParameter.getTotal_staff_region());
        reportStaffCompliance.save(visitDataStaffCompliance);
        repoVisitReport.save(executiveVisitingData);
        updateVisitReportSma(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportNpa(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportReviewRenewal(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportMarchPast(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportMarchPast(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());

        updateVisitReportMarchGap(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportGapPercent(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportTargetData(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportTargetGap(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportComingMarchTarget(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportComingMarchSuper(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportSSS(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportSSSTarget(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportAccout(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportAccoutMarch(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportAccoutTarget(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportDigital(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportDisbursement(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportDisbursementTarget(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportTimeBarred(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportStaffSummery(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportNpaAmountWise(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportNpaSectorWise(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());
        updateVisitReportNpaprogress(visitRemarkParameter.getBranch_code(), visitRemarkParameter.getU_loc(), visitRemarkParameter.getRegion(), executiveVisitingData.getVisit_date());


        return visitDataStaffCompliance;
    }

    public ExecutiveVisitingData updateVisitReportSma(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);

        System.out.println(" visit report data");


        MssoBranchProfileSmaDto mssoBranchProfileSmaDto = null;


        if (uLoc.equalsIgnoreCase("BR")) {
            mssoBranchProfileSmaDto = this.repoMssoBranchProfileSma.getDailySmaBranch(branchCode);

        } else {
            mssoBranchProfileSmaDto = this.repoMssoBranchProfileSma.getDailySmaRO(roname);

        }

        modelMapper.map(mssoBranchProfileSmaDto, executiveVisitingData);
        executiveVisitingData.setReport_dateSma(mssoBranchProfileSmaDto.getReport_date());

        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public ExecutiveVisitingData updateVisitReportNpa(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);

        System.out.println(" visit report data");


        MssoProfileNpaClassificationDto mssoProfileNpaClassificationDto = null;

        if (uLoc.equalsIgnoreCase("BR")) {
            mssoProfileNpaClassificationDto = this.repoMssoBranchProfileSma.getNpaClassificationBranch(branchCode);
        } else {
            mssoProfileNpaClassificationDto = this.repoMssoBranchProfileSma.getNpaClassificationRO(roname);
        }

        modelMapper.map(mssoProfileNpaClassificationDto, executiveVisitingData);
        executiveVisitingData.setReport_dateNpa(mssoProfileNpaClassificationDto.getReport_date());

        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public ExecutiveVisitingData updateVisitReportReviewRenewal(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);

        System.out.println(" visit report data");


        MssoProfileReviewRenewalDto mssoProfileReviewRenewalPending = null;
        if (uLoc.equalsIgnoreCase("BR")) {
            mssoProfileReviewRenewalPending = this.repoMssoBranchProfileSma.getPendingRevieRenewalBranch(branchCode);

        } else {
            mssoProfileReviewRenewalPending = this.repoMssoBranchProfileSma.getPendingRevieRenewalRO(roname);
        }
        modelMapper.map(mssoProfileReviewRenewalPending, executiveVisitingData);
        executiveVisitingData.setKcc_amount(mssoProfileReviewRenewalPending.getTotal_amount());
        executiveVisitingData.setKcc_count(mssoProfileReviewRenewalPending.getTotal_count());

        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public ExecutiveVisitingData updateVisitReportMarchPast(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);

        System.out.println(executiveVisitingData.getVisit_date());


        List<LocalDate> marchEndDates = serviceBranchProfileLast3Year.getLastThreeMarchEndDates();
        marchEndDates.forEach(System.out::println);
        List<MssoBranchProfileActualDataDto> mssoBranchProfileActualDataDto = null;
        if (uLoc.equalsIgnoreCase("BR")) {
            mssoBranchProfileActualDataDto = this.repoMssoBranchProfilePreviousData.getBranchProfileBranchMarchData(branchCode, marchEndDates);
        } else {
            mssoBranchProfileActualDataDto = this.repoMssoBranchProfilePreviousData.getBranchProfileROMarchData(roname, marchEndDates);
        }

        executiveVisitingData.setReport_dateMarch1(mssoBranchProfileActualDataDto.get(0).getReport_date());
        executiveVisitingData.setSbMarch1(mssoBranchProfileActualDataDto.get(0).getSb());
        executiveVisitingData.setCaMarch1(mssoBranchProfileActualDataDto.get(0).getCa());
        executiveVisitingData.setTdMarch1(mssoBranchProfileActualDataDto.get(0).getTd());
        executiveVisitingData.setTotal_businessMarch1(mssoBranchProfileActualDataDto.get(0).getTotal_business());
        executiveVisitingData.setAdvancesMarch1(mssoBranchProfileActualDataDto.get(0).getAdvances());
        executiveVisitingData.setDepositMarch1(mssoBranchProfileActualDataDto.get(0).getDeposit());
        executiveVisitingData.setCasaMarch1(mssoBranchProfileActualDataDto.get(0).getCasa());
        executiveVisitingData.setTotal_ramMarch1(mssoBranchProfileActualDataDto.get(0).getTotal_ram());
        executiveVisitingData.setTotal_retailMarch1(mssoBranchProfileActualDataDto.get(0).getTotal_retail());
        executiveVisitingData.setHousingMarch1(mssoBranchProfileActualDataDto.get(0).getHousing());
        executiveVisitingData.setVehicleMarch1(mssoBranchProfileActualDataDto.get(0).getVehicle());
        executiveVisitingData.setShgMarch1(mssoBranchProfileActualDataDto.get(0).getShg());
        executiveVisitingData.setGoldMarch1(mssoBranchProfileActualDataDto.get(0).getGold());
        executiveVisitingData.setEducationMarch1(mssoBranchProfileActualDataDto.get(0).getEducation());
        executiveVisitingData.setAgriMarch1(mssoBranchProfileActualDataDto.get(0).getAgri());
        executiveVisitingData.setMsmeMarch1(mssoBranchProfileActualDataDto.get(0).getMsme());
        executiveVisitingData.setNpaMarch1(mssoBranchProfileActualDataDto.get(0).getNpa());
//***********************************************************************************march 2************************************************

        executiveVisitingData.setReport_dateMarch2(mssoBranchProfileActualDataDto.get(1).getReport_date());
        executiveVisitingData.setSbMarch2(mssoBranchProfileActualDataDto.get(1).getSb());
        executiveVisitingData.setCaMarch2(mssoBranchProfileActualDataDto.get(1).getCa());
        executiveVisitingData.setTdMarch2(mssoBranchProfileActualDataDto.get(1).getTd());
        executiveVisitingData.setTotal_businessMarch2(mssoBranchProfileActualDataDto.get(1).getTotal_business());
        executiveVisitingData.setAdvancesMarch2(mssoBranchProfileActualDataDto.get(1).getAdvances());
        executiveVisitingData.setDepositMarch2(mssoBranchProfileActualDataDto.get(1).getDeposit());
        executiveVisitingData.setCasaMarch2(mssoBranchProfileActualDataDto.get(1).getCasa());
        executiveVisitingData.setTotal_ramMarch2(mssoBranchProfileActualDataDto.get(1).getTotal_ram());
        executiveVisitingData.setTotal_retailMarch2(mssoBranchProfileActualDataDto.get(1).getTotal_retail());
        executiveVisitingData.setHousingMarch2(mssoBranchProfileActualDataDto.get(1).getHousing());
        executiveVisitingData.setVehicleMarch2(mssoBranchProfileActualDataDto.get(1).getVehicle());
        executiveVisitingData.setShgMarch2(mssoBranchProfileActualDataDto.get(1).getShg());
        executiveVisitingData.setGoldMarch2(mssoBranchProfileActualDataDto.get(1).getGold());
        executiveVisitingData.setEducationMarch2(mssoBranchProfileActualDataDto.get(1).getEducation());
        executiveVisitingData.setAgriMarch2(mssoBranchProfileActualDataDto.get(1).getAgri());
        executiveVisitingData.setMsmeMarch2(mssoBranchProfileActualDataDto.get(1).getMsme());
        executiveVisitingData.setNpaMarch2(mssoBranchProfileActualDataDto.get(1).getNpa());

        //************************************************************************************************

        executiveVisitingData.setReport_dateMarch3(mssoBranchProfileActualDataDto.get(2).getReport_date());
        executiveVisitingData.setSbMarch3(mssoBranchProfileActualDataDto.get(2).getSb());
        executiveVisitingData.setCaMarch3(mssoBranchProfileActualDataDto.get(2).getCa());
        executiveVisitingData.setTdMarch3(mssoBranchProfileActualDataDto.get(2).getTd());
        executiveVisitingData.setTotal_businessMarch3(mssoBranchProfileActualDataDto.get(2).getTotal_business());
        executiveVisitingData.setAdvancesMarch3(mssoBranchProfileActualDataDto.get(2).getAdvances());
        executiveVisitingData.setDepositMarch3(mssoBranchProfileActualDataDto.get(2).getDeposit());
        executiveVisitingData.setCasaMarch3(mssoBranchProfileActualDataDto.get(2).getCasa());
        executiveVisitingData.setTotal_ramMarch3(mssoBranchProfileActualDataDto.get(2).getTotal_ram());
        executiveVisitingData.setTotal_retailMarch3(mssoBranchProfileActualDataDto.get(2).getTotal_retail());
        executiveVisitingData.setHousingMarch3(mssoBranchProfileActualDataDto.get(2).getHousing());
        executiveVisitingData.setVehicleMarch3(mssoBranchProfileActualDataDto.get(2).getVehicle());
        executiveVisitingData.setShgMarch3(mssoBranchProfileActualDataDto.get(2).getShg());
        executiveVisitingData.setGoldMarch3(mssoBranchProfileActualDataDto.get(2).getGold());
        executiveVisitingData.setEducationMarch3(mssoBranchProfileActualDataDto.get(2).getEducation());
        executiveVisitingData.setAgriMarch3(mssoBranchProfileActualDataDto.get(2).getAgri());
        executiveVisitingData.setMsmeMarch3(mssoBranchProfileActualDataDto.get(2).getMsme());
        executiveVisitingData.setNpaMarch3(mssoBranchProfileActualDataDto.get(2).getNpa());


        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public ExecutiveVisitingData updateVisitReportMarchGap(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);

        System.out.println(executiveVisitingData.getVisit_date());


        LocalDate marchEndDates = serviceBranchProfileLast3Year.getLastMarchEndDates();
        MssoBranchProfileActualDataDto mssoBranchProfileActualDataDto = null;
        if (uLoc.equalsIgnoreCase("BR")) {
            mssoBranchProfileActualDataDto = this.repoMssoBranchProfilePreviousData.getBranchProfileBranchGap(branchCode, marchEndDates);
        } else {
            mssoBranchProfileActualDataDto = this.repoMssoBranchProfilePreviousData.getBranchProfileRoGap(roname, marchEndDates);
        }

        executiveVisitingData.setReport_dateMarchGap(mssoBranchProfileActualDataDto.getReport_date());
        executiveVisitingData.setSbMarchGap(mssoBranchProfileActualDataDto.getSb());
        executiveVisitingData.setCaMarchGap(mssoBranchProfileActualDataDto.getCa());
        executiveVisitingData.setTdMarchGap(mssoBranchProfileActualDataDto.getTd());
        executiveVisitingData.setTotal_businessMarchGap(mssoBranchProfileActualDataDto.getTotal_business());
        executiveVisitingData.setAdvancesMarchGap(mssoBranchProfileActualDataDto.getAdvances());
        executiveVisitingData.setDepositMarchGap(mssoBranchProfileActualDataDto.getDeposit());
        executiveVisitingData.setCasaMarchGap(mssoBranchProfileActualDataDto.getCasa());
        executiveVisitingData.setTotal_ramMarchGap(mssoBranchProfileActualDataDto.getTotal_ram());
        executiveVisitingData.setTotal_retailMarchGap(mssoBranchProfileActualDataDto.getTotal_retail());
        executiveVisitingData.setHousingMarchGap(mssoBranchProfileActualDataDto.getHousing());
        executiveVisitingData.setVehicleMarchGap(mssoBranchProfileActualDataDto.getVehicle());
        executiveVisitingData.setShgMarchGap(mssoBranchProfileActualDataDto.getShg());
        executiveVisitingData.setGoldMarchGap(mssoBranchProfileActualDataDto.getGold());
        executiveVisitingData.setEducationMarchGap(mssoBranchProfileActualDataDto.getEducation());
        executiveVisitingData.setAgriMarchGap(mssoBranchProfileActualDataDto.getAgri());
        executiveVisitingData.setMsmeMarchGap(mssoBranchProfileActualDataDto.getMsme());
        executiveVisitingData.setNpaMarchGap(mssoBranchProfileActualDataDto.getNpa());

        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public ExecutiveVisitingData updateVisitReportGapPercent(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);

        System.out.println(executiveVisitingData.getVisit_date());


        LocalDate marchEndDates = serviceBranchProfileLast3Year.getLastMarchEndDates();
        MssoBranchProfileActualDataDto mssoBranchProfileActualDataDto = null;
        if (uLoc.equalsIgnoreCase("BR")) {
            mssoBranchProfileActualDataDto = this.repoMssoBranchProfilePreviousData.getBranchProfileBranchGapPercentage(branchCode, marchEndDates);
        } else {
            mssoBranchProfileActualDataDto = this.repoMssoBranchProfilePreviousData.getBranchProfileRoGapPercentage(roname, marchEndDates);


        }
        executiveVisitingData.setReport_dateMarchPercent(mssoBranchProfileActualDataDto.getReport_date());
        executiveVisitingData.setSbMarchPercent(mssoBranchProfileActualDataDto.getSb());
        executiveVisitingData.setCaMarchPercent(mssoBranchProfileActualDataDto.getCa());
        executiveVisitingData.setTdMarchPercent(mssoBranchProfileActualDataDto.getTd());
        executiveVisitingData.setTotal_businessMarchPercent(mssoBranchProfileActualDataDto.getTotal_business());
        executiveVisitingData.setAdvancesMarchPercent(mssoBranchProfileActualDataDto.getAdvances());
        executiveVisitingData.setDepositMarchPercent(mssoBranchProfileActualDataDto.getDeposit());
        executiveVisitingData.setCasaMarchPercent(mssoBranchProfileActualDataDto.getCasa());
        executiveVisitingData.setTotal_ramMarchPercent(mssoBranchProfileActualDataDto.getTotal_ram());
        executiveVisitingData.setTotal_retailMarchPercent(mssoBranchProfileActualDataDto.getTotal_retail());
        executiveVisitingData.setHousingMarchPercent(mssoBranchProfileActualDataDto.getHousing());
        executiveVisitingData.setVehicleMarchPercent(mssoBranchProfileActualDataDto.getVehicle());
        executiveVisitingData.setShgMarchPercent(mssoBranchProfileActualDataDto.getShg());
        executiveVisitingData.setGoldMarchPercent(mssoBranchProfileActualDataDto.getGold());
        executiveVisitingData.setEducationMarchPercent(mssoBranchProfileActualDataDto.getEducation());
        executiveVisitingData.setAgriMarchPercent(mssoBranchProfileActualDataDto.getAgri());
        executiveVisitingData.setMsmeMarchPercent(mssoBranchProfileActualDataDto.getMsme());
        executiveVisitingData.setNpaMarchPercent(mssoBranchProfileActualDataDto.getNpa());

        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public ExecutiveVisitingData updateVisitReportTargetData(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);

        System.out.println(executiveVisitingData.getVisit_date());


        LocalDate quarterEndDate = serviceMssoBranchProfileTargetData.getCurrentquarterEndDateDate();
        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = null;
        if (uLoc.equalsIgnoreCase("BR")) {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchTargetBranch(branchCode, quarterEndDate);
        } else {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchTargetRO(roname, quarterEndDate);
        }

        executiveVisitingData.setReport_dateTarget(mssoBranchProfileTargetDataDto.getReport_date());
        executiveVisitingData.setSbTarget(mssoBranchProfileTargetDataDto.getSb());
        executiveVisitingData.setCaTarget(mssoBranchProfileTargetDataDto.getCa());
        executiveVisitingData.setTdTarget(mssoBranchProfileTargetDataDto.getTd());
        executiveVisitingData.setTotal_businessTarget(mssoBranchProfileTargetDataDto.getTotal_business());
        executiveVisitingData.setAdvancesTarget(mssoBranchProfileTargetDataDto.getAdvances());
        executiveVisitingData.setDepositTarget(mssoBranchProfileTargetDataDto.getDeposit());
        executiveVisitingData.setCasaTarget(mssoBranchProfileTargetDataDto.getCasa());
        executiveVisitingData.setTotal_ramTarget(mssoBranchProfileTargetDataDto.getTotal_ram());
        executiveVisitingData.setTotal_retailTarget(mssoBranchProfileTargetDataDto.getTotal_retail());
        executiveVisitingData.setHousingTarget(mssoBranchProfileTargetDataDto.getHousing());
        executiveVisitingData.setVehicleTarget(mssoBranchProfileTargetDataDto.getVehicle());
        executiveVisitingData.setShgTarget(mssoBranchProfileTargetDataDto.getShg());
        executiveVisitingData.setGoldTarget(mssoBranchProfileTargetDataDto.getGold());
        executiveVisitingData.setEducationTarget(mssoBranchProfileTargetDataDto.getEducation());
        executiveVisitingData.setAgriTarget(mssoBranchProfileTargetDataDto.getAgri());
        executiveVisitingData.setMsmeTarget(mssoBranchProfileTargetDataDto.getMsme());
        executiveVisitingData.setNpaTarget(mssoBranchProfileTargetDataDto.getNpa());

        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public ExecutiveVisitingData updateVisitReportTargetGap(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);

        System.out.println(executiveVisitingData.getVisit_date());


        LocalDate quarterEndDate = serviceMssoBranchProfileTargetData.getCurrentquarterEndDateDate();
        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = null;
        if (uLoc.equalsIgnoreCase("BR")) {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchProfileBranchGap(branchCode, quarterEndDate);
        } else {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchProfileRoGap(roname, quarterEndDate);
        }
        executiveVisitingData.setReport_dateTargetgap(mssoBranchProfileTargetDataDto.getReport_date());
        executiveVisitingData.setSbTargetgap(mssoBranchProfileTargetDataDto.getSb());
        executiveVisitingData.setCaTargetgap(mssoBranchProfileTargetDataDto.getCa());
        executiveVisitingData.setTdTargetgap(mssoBranchProfileTargetDataDto.getTd());
        executiveVisitingData.setTotal_businessTargetgap(mssoBranchProfileTargetDataDto.getTotal_business());
        executiveVisitingData.setAdvancesTargetgap(mssoBranchProfileTargetDataDto.getAdvances());
        executiveVisitingData.setDepositTargetgap(mssoBranchProfileTargetDataDto.getDeposit());
        executiveVisitingData.setCasaTargetgap(mssoBranchProfileTargetDataDto.getCasa());
        executiveVisitingData.setTotal_ramTargetgap(mssoBranchProfileTargetDataDto.getTotal_ram());
        executiveVisitingData.setTotal_retailTargetgap(mssoBranchProfileTargetDataDto.getTotal_retail());
        executiveVisitingData.setHousingTargetgap(mssoBranchProfileTargetDataDto.getHousing());
        executiveVisitingData.setVehicleTargetgap(mssoBranchProfileTargetDataDto.getVehicle());
        executiveVisitingData.setShgTargetgap(mssoBranchProfileTargetDataDto.getShg());
        executiveVisitingData.setGoldTargetgap(mssoBranchProfileTargetDataDto.getGold());
        executiveVisitingData.setEducationTargetgap(mssoBranchProfileTargetDataDto.getEducation());
        executiveVisitingData.setAgriTargetgap(mssoBranchProfileTargetDataDto.getAgri());
        executiveVisitingData.setMsmeTargetgap(mssoBranchProfileTargetDataDto.getMsme());
        executiveVisitingData.setNpaTargetgap(mssoBranchProfileTargetDataDto.getNpa());


        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public ExecutiveVisitingData updateVisitReportComingMarchTarget(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);

        System.out.println(executiveVisitingData.getVisit_date());


        LocalDate endDate = serviceMssoBranchProfileTargetData.getFinancialYearEndDate();
        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = null;
        if (uLoc.equalsIgnoreCase("BR")) {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchTargetBranch(branchCode, endDate);
        } else {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchTargetRO(roname, endDate);
        }
        executiveVisitingData.setReport_dateComingMarch(mssoBranchProfileTargetDataDto.getReport_date());
        executiveVisitingData.setSbComingMarch(mssoBranchProfileTargetDataDto.getSb());
        executiveVisitingData.setCaComingMarch(mssoBranchProfileTargetDataDto.getCa());
        executiveVisitingData.setTdComingMarch(mssoBranchProfileTargetDataDto.getTd());
        executiveVisitingData.setTotal_businessComingMarch(mssoBranchProfileTargetDataDto.getTotal_business());
        executiveVisitingData.setAdvancesComingMarch(mssoBranchProfileTargetDataDto.getAdvances());
        executiveVisitingData.setDepositComingMarch(mssoBranchProfileTargetDataDto.getDeposit());
        executiveVisitingData.setCasaComingMarch(mssoBranchProfileTargetDataDto.getCasa());
        executiveVisitingData.setTotal_ramComingMarch(mssoBranchProfileTargetDataDto.getTotal_ram());
        executiveVisitingData.setTotal_retailComingMarch(mssoBranchProfileTargetDataDto.getTotal_retail());
        executiveVisitingData.setHousingComingMarch(mssoBranchProfileTargetDataDto.getHousing());
        executiveVisitingData.setVehicleComingMarch(mssoBranchProfileTargetDataDto.getVehicle());
        executiveVisitingData.setShgComingMarch(mssoBranchProfileTargetDataDto.getShg());
        executiveVisitingData.setGoldComingMarch(mssoBranchProfileTargetDataDto.getGold());
        executiveVisitingData.setEducationComingMarch(mssoBranchProfileTargetDataDto.getEducation());
        executiveVisitingData.setAgriComingMarch(mssoBranchProfileTargetDataDto.getAgri());
        executiveVisitingData.setMsmeComingMarch(mssoBranchProfileTargetDataDto.getMsme());
        executiveVisitingData.setNpaComingMarch(mssoBranchProfileTargetDataDto.getNpa());

        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public ExecutiveVisitingData updateVisitReportComingMarchSuper(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);

        System.out.println(executiveVisitingData.getVisit_date());


        LocalDate endDate = serviceMssoBranchProfileTargetData.getFinancialYearEndDate();
        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = null;

        if (uLoc.equalsIgnoreCase("BR")) {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getSuperAchieverBranch(branchCode, endDate);
        } else {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getSuperAchieverRO(roname, endDate);
        }


        executiveVisitingData.setSbSuperMarch(mssoBranchProfileTargetDataDto.getSb());
        executiveVisitingData.setCaSuperMarch(mssoBranchProfileTargetDataDto.getCa());
        executiveVisitingData.setTdSuperMarch(mssoBranchProfileTargetDataDto.getTd());
        executiveVisitingData.setTotal_businessSuperMarch(mssoBranchProfileTargetDataDto.getTotal_business());
        executiveVisitingData.setAdvancesSuperMarch(mssoBranchProfileTargetDataDto.getAdvances());
        executiveVisitingData.setDepositSuperMarch(mssoBranchProfileTargetDataDto.getDeposit());
        executiveVisitingData.setCasaSuperMarch(mssoBranchProfileTargetDataDto.getCasa());
        executiveVisitingData.setTotal_ramSuperMarch(mssoBranchProfileTargetDataDto.getTotal_ram());
        executiveVisitingData.setTotal_retailSuperMarch(mssoBranchProfileTargetDataDto.getTotal_retail());
        executiveVisitingData.setHousingSuperMarch(mssoBranchProfileTargetDataDto.getHousing());
        executiveVisitingData.setVehicleSuperMarch(mssoBranchProfileTargetDataDto.getVehicle());
        executiveVisitingData.setShgSuperMarch(mssoBranchProfileTargetDataDto.getShg());
        executiveVisitingData.setGoldSuperMarch(mssoBranchProfileTargetDataDto.getGold());
        executiveVisitingData.setEducationSuperMarch(mssoBranchProfileTargetDataDto.getEducation());
        executiveVisitingData.setAgriSuperMarch(mssoBranchProfileTargetDataDto.getAgri());
        executiveVisitingData.setMsmeSuperMarch(mssoBranchProfileTargetDataDto.getMsme());
        executiveVisitingData.setNpaSuperMarch(mssoBranchProfileTargetDataDto.getNpa());
        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public VisitDataStaffCompliance updateVisitReportSSS(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        VisitDataStaffCompliance executiveVisitingData = reportStaffCompliance.getVisitStaffComplianceData(branchCode, visit_date);


        MssoFiSchemeDto mssoFiSchemeDto = null;
        if (uLoc.equalsIgnoreCase("BR")) {
            mssoFiSchemeDto = this.repoBranchProfileDigitalProduct.getFiSchemeBranch(branchCode);
        } else {
            mssoFiSchemeDto = this.repoBranchProfileDigitalProduct.getFiSchemeRO(roname);
        }
        executiveVisitingData.setSocialSecurityReportDate(mssoFiSchemeDto.getReport_date());
        executiveVisitingData.setPmjjby(mssoFiSchemeDto.getPmjjby());
        executiveVisitingData.setPmsby(mssoFiSchemeDto.getPmsby());
        executiveVisitingData.setApy(mssoFiSchemeDto.getApy());
        reportStaffCompliance.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public VisitDataStaffCompliance updateVisitReportSSSTarget(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        VisitDataStaffCompliance executiveVisitingData = reportStaffCompliance.getVisitStaffComplianceData(branchCode, visit_date);

        MssoFiSchemeDto mssoFiSchemeDto = null;

        if (uLoc.equalsIgnoreCase("BR")) {
            mssoFiSchemeDto = this.repoAccountDigitalTarget.getFiSchemeTargetBranch(branchCode);
        } else {
            mssoFiSchemeDto = this.repoAccountDigitalTarget.getFiSchemeTargetRO(roname);
        }
        executiveVisitingData.setPmjjbyTarget(mssoFiSchemeDto.getPmjjby());
        executiveVisitingData.setPmsbyTarget(mssoFiSchemeDto.getPmsby());
        executiveVisitingData.setApyTarget(mssoFiSchemeDto.getApy());
        executiveVisitingData.setPmjdyTarget(mssoFiSchemeDto.getPmjdy());
        reportStaffCompliance.save(executiveVisitingData);


        return executiveVisitingData;
    }

    public VisitDataStaffCompliance updateVisitReportNpaAmountWise(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        VisitDataStaffCompliance executiveVisitingData = reportStaffCompliance.getVisitStaffComplianceData(branchCode, visit_date);

        AmountwiseNpaDto amountwiseNpaDto = null;

        if (uLoc.equalsIgnoreCase("BR")) {
            amountwiseNpaDto = this.repoMssoBranchProfileSma.getNpaSAmountWiseBranch(branchCode);

        } else {
            amountwiseNpaDto = this.repoMssoBranchProfileSma.getAmountWiseRO(roname);

        }
        executiveVisitingData.setBelow_1lakh_amt(amountwiseNpaDto.getBelow_1lakh_amt());
        executiveVisitingData.setBelow_3lakh_amt(amountwiseNpaDto.getBelow_3lakh_amt());
        executiveVisitingData.setBelow_24lakh_amt(amountwiseNpaDto.getBelow_24lakh_amt());
        executiveVisitingData.setAbove_25lakh_amt(amountwiseNpaDto.getAbove_25lakh_amt());
        executiveVisitingData.setCount_below_1lakh(amountwiseNpaDto.getCount_below_1lakh());
        executiveVisitingData.setCount_below_3lakh(amountwiseNpaDto.getCount_below_3lakh());
        executiveVisitingData.setCount_below_24lakh(amountwiseNpaDto.getCount_below_24lakh());
        executiveVisitingData.setCount_above_25lakh(amountwiseNpaDto.getCount_above_25lakh());
        reportStaffCompliance.save(executiveVisitingData);


        return executiveVisitingData;
    }

    public VisitDataStaffCompliance updateVisitReportNpaSectorWise(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        VisitDataStaffCompliance executiveVisitingData = reportStaffCompliance.getVisitStaffComplianceData(branchCode, visit_date);

        SectorwiseNpaDto sectorwiseNpaDto = null;

        if (uLoc.equalsIgnoreCase("BR")) {
            sectorwiseNpaDto = this.repoMssoBranchProfileSma.getNpaSectorWiseBranch(branchCode);

        } else {
            sectorwiseNpaDto = this.repoMssoBranchProfileSma.getNpaSectorWiseRO(roname);

        }
        executiveVisitingData.setHousing_amt(sectorwiseNpaDto.getHousing_amt());
        executiveVisitingData.setTotal_housing(sectorwiseNpaDto.getTotal_housing());
        executiveVisitingData.setNacc_amt(sectorwiseNpaDto.getNacc_amt());
        executiveVisitingData.setNacc(sectorwiseNpaDto.getNacc());
        executiveVisitingData.setNatl_amt(sectorwiseNpaDto.getNatl_amt());
        executiveVisitingData.setTotal_natl(sectorwiseNpaDto.getTotal_natl());
        executiveVisitingData.setTotal_housing(sectorwiseNpaDto.getTotal_natl());
        executiveVisitingData.setOther_amt(sectorwiseNpaDto.getOther_amt());
        executiveVisitingData.setOther(sectorwiseNpaDto.getOther());
        executiveVisitingData.setShg_amt(sectorwiseNpaDto.getShg_amt());
        executiveVisitingData.setTotal_shg(sectorwiseNpaDto.getTotal_shg());
        executiveVisitingData.setKcc_atl_amt(sectorwiseNpaDto.getKcc_atl_amt());
        executiveVisitingData.setKcc_atl(sectorwiseNpaDto.getKcc_atl());
        executiveVisitingData.setTotal_os_amt(sectorwiseNpaDto.getTotal_os_amt());

        reportStaffCompliance.save(executiveVisitingData);


        return executiveVisitingData;
    }

    public VisitDataStaffCompliance updateVisitReportNpaprogress(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        VisitDataStaffCompliance executiveVisitingData = reportStaffCompliance.getVisitStaffComplianceData(branchCode, visit_date);
        NpaRecoveryProgressDto npaRecoveryProgressDto = null;
        NpaRecoveryProgressDto npaRecoveryProgressDtoMarch = null;
        if (uLoc.equalsIgnoreCase("BR")) {
            npaRecoveryProgressDto = this.repoMssoBranchProfileSma.getNpaProgressBranch(branchCode);
            npaRecoveryProgressDtoMarch = this.repoMssoBranchProfileSma.getNpaProgressMarchBranch(branchCode);
        } else {
            npaRecoveryProgressDto = this.repoMssoBranchProfileSma.getNpaProgressRO(roname);
            npaRecoveryProgressDtoMarch = this.repoMssoBranchProfileSma.getNpaProgressMarchRO(roname);
        }
        executiveVisitingData.setAddition_os_amt(npaRecoveryProgressDto.getAddition_os_amt());
        executiveVisitingData.setRecovered_os_amt(npaRecoveryProgressDto.getRecovered_os_amt());
        executiveVisitingData.setUpgrade_os_amt(npaRecoveryProgressDto.getUpgrade_os_amt());
        executiveVisitingData.setAddition_os_amtMarch(npaRecoveryProgressDtoMarch.getAddition_os_amt());
        executiveVisitingData.setRecovered_os_amtMarch(npaRecoveryProgressDtoMarch.getRecovered_os_amt());
        executiveVisitingData.setUpgrade_os_amtMarch(npaRecoveryProgressDtoMarch.getUpgrade_os_amt());

        reportStaffCompliance.save(executiveVisitingData);


        return executiveVisitingData;
    }


    public VisitDataStaffCompliance updateVisitReportAccout(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        VisitDataStaffCompliance executiveVisitingData = reportStaffCompliance.getVisitStaffComplianceData(branchCode, visit_date);


        MssoBranchProfileAccountStatusDto mssoBranchProfileAccountStatusDto = null;
        if (uLoc.equalsIgnoreCase("BR")) {
            mssoBranchProfileAccountStatusDto = this.repoBranchprofileAccountStatus.getAccountStatusBranch(branchCode);
        } else {
            mssoBranchProfileAccountStatusDto = this.repoBranchprofileAccountStatus.getAccountStatusRO(roname);
        }

        executiveVisitingData.setSb_ac_count(mssoBranchProfileAccountStatusDto.getSb_ac_count());
        executiveVisitingData.setCa_ac_count(mssoBranchProfileAccountStatusDto.getCa_ac_count());
        executiveVisitingData.setPmjdy(mssoBranchProfileAccountStatusDto.getPmjdy());
        executiveVisitingData.setCasa_count(mssoBranchProfileAccountStatusDto.getCasa_count());
        executiveVisitingData.setCasa_amount(mssoBranchProfileAccountStatusDto.getCasa_amount());

        reportStaffCompliance.save(executiveVisitingData);


        return executiveVisitingData;
    }

    public VisitDataStaffCompliance updateVisitReportAccoutMarch(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        VisitDataStaffCompliance executiveVisitingData = reportStaffCompliance.getVisitStaffComplianceData(branchCode, visit_date);


        MssoBranchProfileAccountStatusDto mssoBranchProfileAccountStatusDto = null;
        if (uLoc.equalsIgnoreCase("BR")) {
            mssoBranchProfileAccountStatusDto = this.repoBranchprofileAccountStatus.getAccountStatusMarchBranch(branchCode);
        } else {
            mssoBranchProfileAccountStatusDto = this.repoBranchprofileAccountStatus.getAccountStatusMarchRO(roname);
        }

        executiveVisitingData.setSb_ac_countMarch(mssoBranchProfileAccountStatusDto.getSb_ac_count());
        executiveVisitingData.setCa_ac_countMarch(mssoBranchProfileAccountStatusDto.getCa_ac_count());

        reportStaffCompliance.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public VisitDataStaffCompliance updateVisitReportAccoutTarget(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        VisitDataStaffCompliance executiveVisitingData = reportStaffCompliance.getVisitStaffComplianceData(branchCode, visit_date);

        MssoAccountStatusDigitalTargetDto mssoAccountStatusDigitalTargetDto = null;
        if (uLoc.equalsIgnoreCase("BR")) {
            mssoAccountStatusDigitalTargetDto = this.repoAccountDigitalTarget.getAccountDigitalTargetBranch(branchCode);
        } else {
            mssoAccountStatusDigitalTargetDto = this.repoAccountDigitalTarget.getAccountDigitalTargetRO(roname);
        }

        executiveVisitingData.setSb_ac_countTarget(mssoAccountStatusDigitalTargetDto.getSb_ac_count());
        executiveVisitingData.setCa_ac_countTarget(mssoAccountStatusDigitalTargetDto.getCa_ac_count());
        executiveVisitingData.setInternet_bankingTarget(mssoAccountStatusDigitalTargetDto.getinternet_banking());
        executiveVisitingData.setMobile_bankingTarget(mssoAccountStatusDigitalTargetDto.getMobile_banking());
        executiveVisitingData.setAtm_cardTarget(mssoAccountStatusDigitalTargetDto.getAtm_card());

        reportStaffCompliance.save(executiveVisitingData);


        return executiveVisitingData;
    }

    public VisitDataStaffCompliance updateVisitReportDigital(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        VisitDataStaffCompliance executiveVisitingData = reportStaffCompliance.getVisitStaffComplianceData(branchCode, visit_date);

        MssoBranchProfileDigitalProductDto mssoBranchProfileDigitalProductDto = null;
        if (uLoc.equalsIgnoreCase("BR")) {
            mssoBranchProfileDigitalProductDto = this.repoBranchProfileDigitalProduct.getDigitalproductBranch(branchCode);
        } else {
            mssoBranchProfileDigitalProductDto = this.repoBranchProfileDigitalProduct.getDigitalproductRO(roname);
        }


        executiveVisitingData.setAtm_card(mssoBranchProfileDigitalProductDto.getAtm_card());
        executiveVisitingData.setMobile_banking(mssoBranchProfileDigitalProductDto.getMobile_banking());
        executiveVisitingData.setMultiple_cif(mssoBranchProfileDigitalProductDto.getMultiple_cif());
        executiveVisitingData.setCkyc(mssoBranchProfileDigitalProductDto.getCkyc());
        executiveVisitingData.setInternet_banking(mssoBranchProfileDigitalProductDto.getinternet_banking());

        reportStaffCompliance.save(executiveVisitingData);


        return executiveVisitingData;
    }

    public ExecutiveVisitingData updateVisitReportDisbursement(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);


        MssoProfileDailyDisburseDto mssoProfileDailyDisburseDto = null;
        if (uLoc.equalsIgnoreCase("BR")) {
            mssoProfileDailyDisburseDto = this.repoMssoDailyDisbursement.getDailyDisbursementBranch(branchCode);
        } else {
            mssoProfileDailyDisburseDto = this.repoMssoDailyDisbursement.getDailyDisbursementRO(roname);
        }

        executiveVisitingData.setReport_dateDisb(mssoProfileDailyDisburseDto.getReport_date());
        executiveVisitingData.setRetailDisb(mssoProfileDailyDisburseDto.getRetail());
        executiveVisitingData.setRetail_countDisb(Math.toIntExact(mssoProfileDailyDisburseDto.getRetail_count()));

        executiveVisitingData.setAgricultureDisb(mssoProfileDailyDisburseDto.getAgriculture());
        executiveVisitingData.setAgriculture_countDisb(Math.toIntExact(mssoProfileDailyDisburseDto.getAgriculture_count()));

        executiveVisitingData.setMsmeDisb(mssoProfileDailyDisburseDto.getMsme());
        executiveVisitingData.setMsme_countDisb(Math.toIntExact(mssoProfileDailyDisburseDto.getMsme_count()));

        executiveVisitingData.setTotal_advancesDisb(mssoProfileDailyDisburseDto.getTotal_advances());
        executiveVisitingData.setTotal_osDisb(mssoProfileDailyDisburseDto.getTotal_os());
        executiveVisitingData.setTotal_countDisb(Math.toIntExact(mssoProfileDailyDisburseDto.getTotal_count()));
        executiveVisitingData.setHousing_countDisb(Math.toIntExact(mssoProfileDailyDisburseDto.getHousing_count()));
        executiveVisitingData.setHousingDisb(mssoProfileDailyDisburseDto.getHousing());

        executiveVisitingData.setVehicleDisb(mssoProfileDailyDisburseDto.getVehicle());
        executiveVisitingData.setVehicle_countDisb(Math.toIntExact(mssoProfileDailyDisburseDto.getVehicle_count()));

        executiveVisitingData.setEducationDisb(mssoProfileDailyDisburseDto.getEducation());
        executiveVisitingData.setEducation_countDisb(Math.toIntExact(mssoProfileDailyDisburseDto.getEducation_count()));

        executiveVisitingData.setGold_countDisb(Math.toIntExact(mssoProfileDailyDisburseDto.getGold_count()));
        executiveVisitingData.setGoldDisb(mssoProfileDailyDisburseDto.getGold());

        executiveVisitingData.setShg_countDisb(Math.toIntExact(mssoProfileDailyDisburseDto.getShg_count()));
        executiveVisitingData.setShgDisb(mssoProfileDailyDisburseDto.getShg());

        executiveVisitingData.setPm_suryaghar_count(Math.toIntExact(mssoProfileDailyDisburseDto.getPm_suryaghar_count()));
        executiveVisitingData.setPm_suryaghar(mssoProfileDailyDisburseDto.getPm_suryaghar());
        executiveVisitingData.setPmvishvakarma_count(Math.toIntExact(mssoProfileDailyDisburseDto.getPmvishvakarma_count()));
        executiveVisitingData.setPmvishvakarma(mssoProfileDailyDisburseDto.getPmvishvakarma());


        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public ExecutiveVisitingData updateVisitReportDisbursementTarget(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);


        MssoProfileDailyDisburseDto mssoProfileDailyDisburseDto = null;
        if (uLoc.equalsIgnoreCase("BR")) {
            mssoProfileDailyDisburseDto = this.repoMssoDailyDisbursement.getDailyDisbursementTargetBranch(branchCode);
        } else {
            mssoProfileDailyDisburseDto = this.repoMssoDailyDisbursement.getDailyDisbursementTargetRO(roname);
        }


        executiveVisitingData.setReport_dateDisbTarget(mssoProfileDailyDisburseDto.getReport_date());
        executiveVisitingData.setRetailDisbTarget(mssoProfileDailyDisburseDto.getRetail());
        executiveVisitingData.setRetail_countDisbTarget(Math.toIntExact(mssoProfileDailyDisburseDto.getRetail_count()));

        executiveVisitingData.setAgricultureDisbTarget(mssoProfileDailyDisburseDto.getAgriculture());
        executiveVisitingData.setAgriculture_countDisbTarget(Math.toIntExact(mssoProfileDailyDisburseDto.getAgriculture_count()));

        executiveVisitingData.setMsmeDisbTarget(mssoProfileDailyDisburseDto.getMsme());
        executiveVisitingData.setMsme_countDisbTarget(Math.toIntExact(mssoProfileDailyDisburseDto.getMsme_count()));

        executiveVisitingData.setTotal_advancesDisbTarget(mssoProfileDailyDisburseDto.getTotal_advances());
        executiveVisitingData.setTotal_osDisbTarget(mssoProfileDailyDisburseDto.getTotal_os());

        executiveVisitingData.setHousing_countDisbTarget(Math.toIntExact(mssoProfileDailyDisburseDto.getHousing_count()));
        executiveVisitingData.setHousingDisbTarget(mssoProfileDailyDisburseDto.getHousing());

        executiveVisitingData.setVehicleDisbTarget(mssoProfileDailyDisburseDto.getVehicle());
        executiveVisitingData.setVehicle_countDisbTarget(Math.toIntExact(mssoProfileDailyDisburseDto.getVehicle_count()));

        executiveVisitingData.setEducationDisbTarget(mssoProfileDailyDisburseDto.getEducation());
        executiveVisitingData.setEducation_countDisbTarget(Math.toIntExact(mssoProfileDailyDisburseDto.getEducation_count()));

        executiveVisitingData.setGold_countDisbTarget(Math.toIntExact(mssoProfileDailyDisburseDto.getGold_count()));
        executiveVisitingData.setGoldDisbTarget(mssoProfileDailyDisburseDto.getGold());

        executiveVisitingData.setShg_countDisbTarget(Math.toIntExact(mssoProfileDailyDisburseDto.getShg_count()));
        executiveVisitingData.setShgDisbTarget(mssoProfileDailyDisburseDto.getShg());

        executiveVisitingData.setPm_suryaghar_countTarget(Math.toIntExact(mssoProfileDailyDisburseDto.getPm_suryaghar_count()));
        executiveVisitingData.setPm_suryagharTarget(mssoProfileDailyDisburseDto.getPm_suryaghar());
        executiveVisitingData.setPmvishvakarma_countTarget(Math.toIntExact(mssoProfileDailyDisburseDto.getPmvishvakarma_count()));
        executiveVisitingData.setPmvishvakarmaTarget(mssoProfileDailyDisburseDto.getPmvishvakarma());


        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public ExecutiveVisitingData updateVisitReportTimeBarred(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);


        MssoProfileComplianceDto mssoProfileTimebarred = null;
        if (uLoc.equalsIgnoreCase("BR")) {
            mssoProfileTimebarred = this.repoMssoBranchProfileSma.getgetTimebarredBranch(branchCode);
        } else {
            mssoProfileTimebarred = this.repoMssoBranchProfileSma.getgetTimebarredRO(roname);
        }


        if (mssoProfileTimebarred != null) {
            executiveVisitingData.setTotal_countTimeBarred(mssoProfileTimebarred.getTotal_count());
            executiveVisitingData.setTotal_amountTimeBarred(mssoProfileTimebarred.getTotal_amount());

        } else {
            executiveVisitingData.setTotal_countTimeBarred(0L);
            executiveVisitingData.setTotal_amountTimeBarred(BigDecimal.valueOf(0));

        }

        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public VisitDataStaffCompliance updateVisitReportStaffSummery(String branchCode, String uLoc, String roname, LocalDate visit_date) {
        String uType = null;
        VisitDataStaffCompliance executiveVisitingData = reportStaffCompliance.getVisitStaffComplianceData(branchCode, visit_date);

        MssoProfileComplianceDto mssoProfileTimebarred = null;

        System.out.println("location for BM: " + uLoc);
        if (uLoc.equals("BR")) {
            System.out.println("location for BM: " + uLoc);
            uType = "BM";
        } else if (uLoc.equals("RO")) {
            System.out.println("location for RM: " + uLoc);
            uType = "RM";
        } else if (uLoc.equals("HO")) {
            System.out.println("location for CM: " + uLoc);

            uType = "CM";
        }

        MssoBranchEmployeeDataDto BranchSummary = repoMssoBranchData.getBranchSummary(uType, branchCode, roname);
        String branchCategory = null;

        branchCategory = repoMssoBranchData.getBranchCategory(branchCode);


        BranchCategoryDto branchCategoryDto = null;
        branchCategoryDto = this.repoMssoBranchData.getCategoryCountRo(roname, branchCode);

        MssoEmployeeSummaryDto mssoEmployeeSummaryDto = mssoBranchDataService.getMssoRegionEmployeeSummary(branchCode, uLoc, roname);


        executiveVisitingData.setDesg_agm(BranchSummary.getDesg_agm());
        executiveVisitingData.setDesg_clerk(BranchSummary.getDesg_clerk());
        executiveVisitingData.setDesg_cm(BranchSummary.getDesg_cm());
        executiveVisitingData.setDesg_gm(BranchSummary.getDesg_gm());
        executiveVisitingData.setDesg_dgm(BranchSummary.getDesg_dgm());
        executiveVisitingData.setDesg_dymanager(BranchSummary.getDesg_dymanager());
        executiveVisitingData.setDesg_manager(BranchSummary.getDesg_manager());
        executiveVisitingData.setDesg_srmanager(BranchSummary.getDesg_srmanager());
        executiveVisitingData.setDesg_agm(BranchSummary.getSubstaff());
        executiveVisitingData.setPopulation_group_name(BranchSummary.getPopulation_group_name());

        executiveVisitingData.setBranch_name(BranchSummary.getBranch_name());
        executiveVisitingData.setGrade_code(BranchSummary.getGrade_code());
        executiveVisitingData.setDesignation_code(BranchSummary.getDesignation_code());
        executiveVisitingData.setMain_region(BranchSummary.getMain_region());
        executiveVisitingData.setEmployee_name(BranchSummary.getEmployee_name());
        //*****************************branch category****************
        executiveVisitingData.setBranch_category(branchCategory);
        //*******************************category count************************
        if (uLoc.equals("RO") || uLoc.equals("HO")) {
            executiveVisitingData.setMetropolitan(branchCategoryDto.getMetropolitan());
            executiveVisitingData.setRural(branchCategoryDto.getRural());
            executiveVisitingData.setSemiUrban(branchCategoryDto.getSemiUrban());
            executiveVisitingData.setUrban(branchCategoryDto.getUrban());
            executiveVisitingData.setTotalBranchCount(branchCategoryDto.getTotalCount());
            executiveVisitingData.setDesg_agmTotalStaff(mssoEmployeeSummaryDto.getDesg_agm());
            executiveVisitingData.setDesg_clerkTotalStaff(mssoEmployeeSummaryDto.getDesg_clerk());
            executiveVisitingData.setDesg_cmTotalStaff(mssoEmployeeSummaryDto.getDesg_cm());
            executiveVisitingData.setSubstaffTotalStaff(mssoEmployeeSummaryDto.getSubstaff());
            executiveVisitingData.setDesg_managerTotalStaff(mssoEmployeeSummaryDto.getDesg_manager());
            executiveVisitingData.setDesg_dymanagerTotalStaff(mssoEmployeeSummaryDto.getDesg_dymanager());
            executiveVisitingData.setDesg_srmanagerTotalStaff(mssoEmployeeSummaryDto.getDesg_srmanager());


        }


        BranchCategoryDto bcCount = null;
        if (uLoc.equalsIgnoreCase("HO")) {
            bcCount = this.repoEmployeData.getBCCountHO();
            System.out.println("getBCCountHO");

        } else if (uLoc.equalsIgnoreCase("RO")) {
            bcCount = this.repoEmployeData.getBCCountRo(roname);
            System.out.println("branchCategoryDto" + branchCategoryDto);

        } else if (uLoc.equalsIgnoreCase("BR")) {
            bcCount = this.repoEmployeData.getBCCountBranch(branchCode);
        }
        executiveVisitingData.setBcCount(bcCount.getTotalCount());


        reportStaffCompliance.save(executiveVisitingData);

        return executiveVisitingData;
    }


}
