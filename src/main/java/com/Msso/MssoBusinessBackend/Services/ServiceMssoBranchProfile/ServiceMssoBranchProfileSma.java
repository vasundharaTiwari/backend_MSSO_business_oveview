package com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileDisbursement.MssoProfileDailyDisburseDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileSma.MssoBranchProfileSmaDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBrachProfileSma.RepoMssoBranchProfileSma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceMssoBranchProfileSma {
    @Autowired
    RepoMssoBranchProfileSma repoMssoBranchProfileSma;
    public MssoBranchProfileSmaDto getMssoDailySma(String branchCode,

                                                            String roname,
                                                            String u_loc) {


        MssoBranchProfileSmaDto mssoBranchProfileSmaDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoBranchProfileSmaDto = this.repoMssoBranchProfileSma.getDailySmaHo();
            return mssoBranchProfileSmaDto;
        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileSmaDto = this.repoMssoBranchProfileSma.getDailySmaBranch(branchCode);
            return mssoBranchProfileSmaDto;
        } else {
            mssoBranchProfileSmaDto = this.repoMssoBranchProfileSma.getDailySmaRO(roname);
            return mssoBranchProfileSmaDto;
        }


    }
}
