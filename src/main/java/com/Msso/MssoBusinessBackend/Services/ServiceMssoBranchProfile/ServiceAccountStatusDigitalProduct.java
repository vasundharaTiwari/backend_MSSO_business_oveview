package com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoAccountStatusDigitalTargetDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileAccountStatusDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileDigitalProductDto;
import com.Msso.MssoBusinessBackend.Repository.RepoBranchProfileAccountStatusDigitalProduct.RepoAccountDigitalTarget;
import com.Msso.MssoBusinessBackend.Repository.RepoBranchProfileAccountStatusDigitalProduct.RepoBranchProfileDigitalProduct;
import com.Msso.MssoBusinessBackend.Repository.RepoBranchProfileAccountStatusDigitalProduct.RepoBranchprofileAccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAccountStatusDigitalProduct {
    @Autowired
    RepoBranchProfileDigitalProduct repoBranchProfileDigitalProduct;
    @Autowired
    RepoBranchprofileAccountStatus repoBranchprofileAccountStatus;
@Autowired
    RepoAccountDigitalTarget repoAccountDigitalTarget;
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

    public MssoBranchProfileAccountStatusDto getMssoAccountStatusMarch(String branchCode,

                                                                  String roname,
                                                                  String u_loc) {


        MssoBranchProfileAccountStatusDto mssoBranchProfileAccountStatusDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoBranchProfileAccountStatusDto = this.repoBranchprofileAccountStatus.getAccountStatusMarchHo();
            return mssoBranchProfileAccountStatusDto;
        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileAccountStatusDto = this.repoBranchprofileAccountStatus.getAccountStatusMarchBranch(branchCode);
            return mssoBranchProfileAccountStatusDto;
        } else {
            mssoBranchProfileAccountStatusDto = this.repoBranchprofileAccountStatus.getAccountStatusMarchRO(roname);
            return mssoBranchProfileAccountStatusDto;
        }
    }
        public MssoBranchProfileDigitalProductDto getMssoDigitalProduct (String branchCode,

                String roname,
                String u_loc){


            MssoBranchProfileDigitalProductDto mssoBranchProfileDigitalProductDto = null;
            if (u_loc.equalsIgnoreCase("HO")) {
                mssoBranchProfileDigitalProductDto = this.repoBranchProfileDigitalProduct.getDigitalproductHo();
                return mssoBranchProfileDigitalProductDto;
            } else if (u_loc.equalsIgnoreCase("BR")) {
                mssoBranchProfileDigitalProductDto = this.repoBranchProfileDigitalProduct.getDigitalproductBranch(branchCode);
                return mssoBranchProfileDigitalProductDto;
            } else {
                mssoBranchProfileDigitalProductDto = this.repoBranchProfileDigitalProduct.getDigitalproductRO(roname);
                return mssoBranchProfileDigitalProductDto;
            }


        }

    public MssoAccountStatusDigitalTargetDto getMssoAccountDigitalProductTarget (String branchCode,

                                                                                 String roname,
                                                                                 String u_loc){


        MssoAccountStatusDigitalTargetDto mssoAccountStatusDigitalTargetDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoAccountStatusDigitalTargetDto = this.repoAccountDigitalTarget.getAccountDigitalTargetHo();
            return mssoAccountStatusDigitalTargetDto;
        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoAccountStatusDigitalTargetDto = this.repoAccountDigitalTarget.getAccountDigitalTargetBranch(branchCode);
            return mssoAccountStatusDigitalTargetDto;
        } else {
            mssoAccountStatusDigitalTargetDto = this.repoAccountDigitalTarget.getAccountDigitalTargetRO(roname);
            return mssoAccountStatusDigitalTargetDto;
        }


    }
    }

