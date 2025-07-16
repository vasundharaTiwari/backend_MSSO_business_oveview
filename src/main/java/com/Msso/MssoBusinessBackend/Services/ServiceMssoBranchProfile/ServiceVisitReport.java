package com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.ExecutiveVisitingData;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
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


        repoVisitReport.save(executiveVisitingData);

        return executiveVisitingData;
    }
}
