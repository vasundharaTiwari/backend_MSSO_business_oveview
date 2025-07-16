package com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.ExecutiveVisitingData;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
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

    public ExecutiveVisitingData getVisitDataByBranch(String branchCode, LocalDate  visit_date) {
        ExecutiveVisitingData executiveVisitingData = repoVisitReport.getVisitData(branchCode,visit_date);
        return executiveVisitingData;
    }

    @Transactional
    public void updateVisitReport(String branchCode) {

        System.out.println(" visit report data");

        // Retrieve the RefNoVarification data by referenceId
        MssoBranchProfileActualDataDto mssoBranchProfileDto = null;
        mssoBranchProfileDto = this.repoMssoBranchProfile.getBranchProfileBranch(branchCode);

        ExecutiveVisitingData executiveVisitingData = modelMapper.map(mssoBranchProfileDto, ExecutiveVisitingData.class);
        executiveVisitingData.setVisit_date(LocalDate.now());
        executiveVisitingData.setBranch_code(branchCode);
        //executiveVisitingData.setTotal_business(mssoBranchProfileDto.getTotal_business());

        // Map RefNoVarification to AppraisalNote


        repoVisitReport.save(executiveVisitingData);


    }
}
