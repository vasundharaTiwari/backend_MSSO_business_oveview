package com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoAccountStatusDigitalTargetDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileAccountStatusDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileDigitalProductDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoFiSchemeDto;
import com.Msso.MssoBusinessBackend.Repository.RepoBranchProfileAccountStatusDigitalProduct.RepoAccountDigitalFiSchemeTarget;
import com.Msso.MssoBusinessBackend.Repository.RepoBranchProfileAccountStatusDigitalProduct.RepoProfileDigitalProductFiScheme;
import com.Msso.MssoBusinessBackend.Repository.RepoBranchProfileAccountStatusDigitalProduct.RepoBranchprofileAccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAccountStatusDigitalProduct {
    @Autowired
    RepoProfileDigitalProductFiScheme repoBranchProfileDigitalProduct;
    @Autowired
    RepoBranchprofileAccountStatus repoBranchprofileAccountStatus;
@Autowired
RepoAccountDigitalFiSchemeTarget repoAccountDigitalTarget;
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

    public MssoFiSchemeDto getFiSchemeData(String branchCode,

                                                                  String roname,
                                                                  String u_loc) {


        MssoFiSchemeDto mssoFiSchemeDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoFiSchemeDto = this.repoBranchProfileDigitalProduct.getFiSchemeHo();
            return mssoFiSchemeDto;
        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoFiSchemeDto = this.repoBranchProfileDigitalProduct.getFiSchemeBranch(branchCode);
            return mssoFiSchemeDto;
        } else {
            mssoFiSchemeDto = this.repoBranchProfileDigitalProduct.getFiSchemeRO(roname);
            return mssoFiSchemeDto;
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

    public MssoFiSchemeDto getMssoFiSchemeTarget (String branchCode,

                                                                                 String roname,
                                                                                 String u_loc){


        MssoFiSchemeDto mssoFiSchemeDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoFiSchemeDto = this.repoAccountDigitalTarget.getFiSchemeTargetHo();
            return mssoFiSchemeDto;
        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoFiSchemeDto = this.repoAccountDigitalTarget.getFiSchemeTargetBranch(branchCode);
            return mssoFiSchemeDto;
        } else {
            mssoFiSchemeDto = this.repoAccountDigitalTarget.getFiSchemeTargetRO(roname);
            return mssoFiSchemeDto;
        }


    }
    }

