package com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.ExecutiveVisitingData;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileReviewRenewalDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.MssoBranchProfileSmaDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.MssoProfileNpaClassificationDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBrachProfileSma.RepoMssoBranchProfileSma;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile.RepoMssoBranchProfileActualData;
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
    public ExecutiveVisitingData getVisitDataByBranch(String branchCode, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, visit_date);
        return executiveVisitingData;
    }

    @Transactional
    public ExecutiveVisitingData updateVisitReport(String branchCode) {

        System.out.println(" visit report data");

        // Retrieve the RefNoVarification data by referenceId
        MssoBranchProfileActualDataDto mssoBranchProfileDto = null;

        mssoBranchProfileDto = this.repoMssoBranchProfile.getBranchProfileBranch(branchCode);

        ExecutiveVisitingData executiveVisitingData = modelMapper.map(mssoBranchProfileDto, ExecutiveVisitingData.class);
        executiveVisitingData.setVisit_date(LocalDate.now());
        executiveVisitingData.setBranch_code(branchCode);
        executiveVisitingData.setRegion("");
        executiveVisitingData.setBranch_name("");

        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public ExecutiveVisitingData updateVisitReportActual(String branchCode, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, LocalDate.parse("2025-07-16"));

        System.out.println(" visit report data");


        MssoBranchProfileSmaDto mssoBranchProfileSmaDto = null;


        mssoBranchProfileSmaDto = this.repoMssoBranchProfileSma.getDailySmaBranch(branchCode);
        modelMapper.map(mssoBranchProfileSmaDto, executiveVisitingData);


        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public ExecutiveVisitingData updateVisitReportNpa(String branchCode, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, LocalDate.parse("2025-07-16"));

        System.out.println(" visit report data");


        MssoProfileNpaClassificationDto mssoProfileNpaClassificationDto = null;


        mssoProfileNpaClassificationDto = this.repoMssoBranchProfileSma.getNpaClassificationBranch(branchCode);
        modelMapper.map(mssoProfileNpaClassificationDto, executiveVisitingData);
        //executiveVisitingData.setReport

        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }

    public ExecutiveVisitingData updateVisitReportReviewRenewal(String branchCode, LocalDate visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, LocalDate.parse("2025-07-16"));

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
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode, LocalDate.parse("2025-07-16"));

        System.out.println(" visit report data");


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


        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }
}
