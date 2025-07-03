package com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.MssoBranchProfileSmaDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileComplianceDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.MssoProfileNpaClassificationDto;
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

    public MssoProfileNpaClassificationDto getMssoNpaClassification(String branchCode,

                                                                    String roname,
                                                                    String u_loc) {


        MssoProfileNpaClassificationDto mssoProfileNpaClassificationDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoProfileNpaClassificationDto = this.repoMssoBranchProfileSma.getNpaClassificationHo();

        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoProfileNpaClassificationDto = this.repoMssoBranchProfileSma.getNpaClassificationBranch(branchCode);

        } else {
            mssoProfileNpaClassificationDto = this.repoMssoBranchProfileSma.getNpaClassificationRO(roname);

        }
        return mssoProfileNpaClassificationDto;

    }
    public MssoProfileComplianceDto getPendingReview(String branchCode,

                                                     String roname,
                                                     String u_loc) {


        MssoProfileComplianceDto mssoProfileReviewRenewalPending = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoProfileReviewRenewalPending = this.repoMssoBranchProfileSma.getPendingRevieRenewalHo();
            return mssoProfileReviewRenewalPending;
        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoProfileReviewRenewalPending = this.repoMssoBranchProfileSma.getPendingRevieRenewalBranch(branchCode);
            return mssoProfileReviewRenewalPending;
        } else {
            mssoProfileReviewRenewalPending = this.repoMssoBranchProfileSma.getPendingRevieRenewalRO(roname);
            return mssoProfileReviewRenewalPending;
        }


    }

    public MssoProfileComplianceDto getTimebarredData(String branchCode,

                                                     String roname,
                                                     String u_loc) {


        MssoProfileComplianceDto mssoProfileTimebarred = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoProfileTimebarred = this.repoMssoBranchProfileSma.getTimebarredHo();
            return mssoProfileTimebarred;
        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoProfileTimebarred = this.repoMssoBranchProfileSma.getgetTimebarredBranch(branchCode);
            return mssoProfileTimebarred;
        } else {
            mssoProfileTimebarred = this.repoMssoBranchProfileSma.getgetTimebarredRO(roname);
            return mssoProfileTimebarred;
        }


    }
}
