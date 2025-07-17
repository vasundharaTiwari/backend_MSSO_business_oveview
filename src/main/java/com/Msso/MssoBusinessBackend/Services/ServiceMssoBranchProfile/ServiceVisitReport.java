package com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.ExecutiveVisitingData;
import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.VisitRemarkParameter;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileTargetDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileReviewRenewalDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.MssoBranchProfileSmaDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.MssoProfileNpaClassificationDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBrachProfileSma.RepoMssoBranchProfileSma;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile.RepoMssoBranchProfileActualData;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile.RepoMssoBranchProfileTargetData;
import com.Msso.MssoBusinessBackend.Repository.RepoVisitReport.RepoVisitReport;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ServiceVisitReport {
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

    public ExecutiveVisitingData getVisitDataByBranch(String branchCode, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);
        return executiveVisitingData;
    }

    @Transactional
    public ExecutiveVisitingData updateVisitReport( VisitRemarkParameter visitRemarkParameter) {

        System.out.println(" visit report data");

        // Retrieve the RefNoVarification data by referenceId
        MssoBranchProfileActualDataDto mssoBranchProfileDto = null;

        mssoBranchProfileDto = this.repoMssoBranchProfile.getBranchProfileBranch(visitRemarkParameter.getBranch_code());

        ExecutiveVisitingData executiveVisitingData = modelMapper.map(mssoBranchProfileDto, ExecutiveVisitingData.class);
        executiveVisitingData.setVisit_date(LocalDate.now());
        executiveVisitingData.setBranch_code(visitRemarkParameter.getBranch_code());
        executiveVisitingData.setRegion(visitRemarkParameter.getRegion());
        executiveVisitingData.setVisitor_userid(visitRemarkParameter.getVisitor_userid());
        executiveVisitingData.setVisitor_name(visitRemarkParameter.getVisitor_name());
        executiveVisitingData.setVisitor_region(visitRemarkParameter.getVisitor_region());
        executiveVisitingData.setVisitor_designation(visitRemarkParameter.getVisitor_designation());
        executiveVisitingData.setVisitor_branch_code(visitRemarkParameter.getVisitor_branch_code());
        //////////////////////////******************remark****************************

        executiveVisitingData.setParameterDetailRemark(visitRemarkParameter.getParameterDetailRemark());
        executiveVisitingData.setComplianceRemark(visitRemarkParameter.getComplianceRemark());
        executiveVisitingData.setOtherRemark(visitRemarkParameter.getOtherRemark());
        executiveVisitingData.setSmaRemark(visitRemarkParameter.getSmaRemark());
        executiveVisitingData.setSocialSecurityRemark(visitRemarkParameter.getSocialSecurityRemark());
        executiveVisitingData.setSanctionDisbursedRemark(visitRemarkParameter.getSanctionDisbursedRemark());
        executiveVisitingData.setNpaClassificationRemark(visitRemarkParameter.getNpaClassificationRemark());
        executiveVisitingData.setAccountAndDigitalStatusRemark(visitRemarkParameter.getAccountAndDigitalStatusRemark());
        executiveVisitingData.setPerEmployeeBusiness(visitRemarkParameter.getPerEmployeeBusiness());
        executiveVisitingData.setTotal_staff(visitRemarkParameter.getTotal_staff());


        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public ExecutiveVisitingData updateVisitReportActual(String branchCode, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);

        System.out.println(" visit report data");


        MssoBranchProfileSmaDto mssoBranchProfileSmaDto = null;


        mssoBranchProfileSmaDto = this.repoMssoBranchProfileSma.getDailySmaBranch(branchCode);
        modelMapper.map(mssoBranchProfileSmaDto, executiveVisitingData);


        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public ExecutiveVisitingData updateVisitReportNpa(String branchCode, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);

        System.out.println(" visit report data");


        MssoProfileNpaClassificationDto mssoProfileNpaClassificationDto = null;


        mssoProfileNpaClassificationDto = this.repoMssoBranchProfileSma.getNpaClassificationBranch(branchCode);
        modelMapper.map(mssoProfileNpaClassificationDto, executiveVisitingData);
        //executiveVisitingData.setReport

        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public ExecutiveVisitingData updateVisitReportReviewRenewal(String branchCode, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);

        System.out.println(" visit report data");


        MssoProfileReviewRenewalDto mssoProfileReviewRenewalPending = null;

        mssoProfileReviewRenewalPending = this.repoMssoBranchProfileSma.getPendingRevieRenewalBranch(branchCode);
        modelMapper.map(mssoProfileReviewRenewalPending, executiveVisitingData);
        executiveVisitingData.setKcc_amount(mssoProfileReviewRenewalPending.getTotal_amount());
        executiveVisitingData.setKcc_count(mssoProfileReviewRenewalPending.getTotal_count());

        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }
    public ExecutiveVisitingData updateVisitReportMarchPast(String branchCode, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode,visit_date);

        System.out.println(executiveVisitingData.getVisit_date());


        List<LocalDate> marchEndDates = serviceBranchProfileLast3Year.getLastThreeMarchEndDates();
        marchEndDates.forEach(System.out::println);
        List<MssoBranchProfileActualDataDto> mssoBranchProfileActualDataDto = null;

        mssoBranchProfileActualDataDto = this.repoMssoBranchProfilePreviousData.getBranchProfileBranchMarchData(branchCode,marchEndDates);
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

    public ExecutiveVisitingData updateVisitReportMarchGap(String branchCode, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode,visit_date);

        System.out.println(executiveVisitingData.getVisit_date());


        LocalDate marchEndDates = serviceBranchProfileLast3Year.getLastMarchEndDates();
        MssoBranchProfileActualDataDto mssoBranchProfileActualDataDto = null;

        mssoBranchProfileActualDataDto = this.repoMssoBranchProfilePreviousData.getBranchProfileBranchGap(branchCode,marchEndDates);
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
    public ExecutiveVisitingData updateVisitReportGapPercent(String branchCode, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode,visit_date);

        System.out.println(executiveVisitingData.getVisit_date());


        LocalDate marchEndDates = serviceBranchProfileLast3Year.getLastMarchEndDates();
        MssoBranchProfileActualDataDto mssoBranchProfileActualDataDto = null;

        mssoBranchProfileActualDataDto = this.repoMssoBranchProfilePreviousData.getBranchProfileBranchGapPercentage(branchCode,marchEndDates);
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

    public ExecutiveVisitingData updateVisitReportTargetData(String branchCode, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode,visit_date);

        System.out.println(executiveVisitingData.getVisit_date());


        LocalDate quarterEndDate = serviceMssoBranchProfileTargetData.getCurrentquarterEndDateDate();
        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = null;

        mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchTargetBranch(branchCode, quarterEndDate);
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
    public ExecutiveVisitingData updateVisitReportTargetGap(String branchCode, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode,visit_date);

        System.out.println(executiveVisitingData.getVisit_date());


        LocalDate quarterEndDate = serviceMssoBranchProfileTargetData.getCurrentquarterEndDateDate();
        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = null;

        mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchProfileBranchGap(branchCode, quarterEndDate);
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

    public ExecutiveVisitingData updateVisitReportComingMarchTarget(String branchCode, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode,visit_date);

        System.out.println(executiveVisitingData.getVisit_date());


        LocalDate endDate = serviceMssoBranchProfileTargetData.getFinancialYearEndDate();
        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = null;

        mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchTargetBranch(branchCode, endDate);
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
    public ExecutiveVisitingData updateVisitReportComingMarchSuper(String branchCode, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode,visit_date);

        System.out.println(executiveVisitingData.getVisit_date());


        LocalDate endDate = serviceMssoBranchProfileTargetData.getFinancialYearEndDate();
        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = null;

        mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getSuperAchieverBranch(branchCode, endDate);


        executiveVisitingData.setTotal_businessSuperMarch(mssoBranchProfileTargetDataDto.getTotal_business());

        executiveVisitingData.setNpaSuperMarch(mssoBranchProfileTargetDataDto.getNpa());  repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }
}
