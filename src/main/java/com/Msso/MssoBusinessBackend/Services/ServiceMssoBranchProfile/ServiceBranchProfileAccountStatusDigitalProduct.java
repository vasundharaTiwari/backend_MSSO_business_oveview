package com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileAccountStatusDigitalProduct.MssoBranchProfileAccountStatusDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileDisbursement.MssoProfileDailyDisburseDto;
import com.Msso.MssoBusinessBackend.Repository.RepoBranchProfileAccountStatusDigitalProduct.RepoBranchProfileDigitalProduct;
import com.Msso.MssoBusinessBackend.Repository.RepoBranchProfileAccountStatusDigitalProduct.RepoBranchprofileAccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBranchProfileAccountStatusDigitalProduct {
    @Autowired
    RepoBranchProfileDigitalProduct repoBranchProfileDigitalProduct;
    @Autowired
    RepoBranchprofileAccountStatus repoBranchprofileAccountStatus;
    public MssoBranchProfileAccountStatusDto getMssoAccountStatus(String branchCode,

                                                                String roname,
                                                                String u_loc) {


        MssoBranchProfileAccountStatusDto mssoBranchProfileAccountStatusDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoBranchProfileAccountStatusDto = this.repoBranchprofileAccountStatus.getAccountStatusHo();
            return mssoBranchProfileAccountStatusDto;
        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileAccountStatusDto = this.repoBranchprofileAccountStatus.getAccountStatusBranch(branchCode);
            return mssoBranchProfileAccountStatusDto;
        } else {
            mssoBranchProfileAccountStatusDto = this.repoBranchprofileAccountStatus.getAccountStatusRO(roname);
            return mssoBranchProfileAccountStatusDto;
        }


    }
}
