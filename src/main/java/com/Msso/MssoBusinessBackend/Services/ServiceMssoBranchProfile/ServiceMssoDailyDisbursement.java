package com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileDisbursement.MssoProfileDailyDisburseDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileDisbursement.MssoProfileDailyDisbursement;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoDailyDisbursement.RepoMssoDailyDisbursement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ServiceMssoDailyDisbursement {
    @Autowired
    RepoMssoDailyDisbursement repoMssoDailyDisbursement;

    public MssoProfileDailyDisburseDto getMssoDailyDisbursement(String branchCode,

                                                                    String roname,
                                                                    String u_loc) {


        MssoProfileDailyDisburseDto mssoProfileDailyDisburseDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoProfileDailyDisburseDto = this.repoMssoDailyDisbursement.getDailyDisbursementHo();
            return mssoProfileDailyDisburseDto;
        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoProfileDailyDisburseDto = this.repoMssoDailyDisbursement.getDailyDisbursementBranch(branchCode);
            return mssoProfileDailyDisburseDto;
        } else {
            mssoProfileDailyDisburseDto = this.repoMssoDailyDisbursement.getDailyDisbursementRO(roname);
            return mssoProfileDailyDisburseDto;
        }


    }
}
