package com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileReviewRenewalDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.*;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileComplianceDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBrachProfileSma.RepoMssoBranchProfileSma;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile.RepoMssoBranchProfileActualData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static net.sf.jasperreports.engine.util.BigDecimalUtils.divide;

@Service
public class ServiceMssoBranchProfileSma {
    @Autowired
    RepoMssoBranchProfileSma repoMssoBranchProfileSma;
    @Autowired
    RepoMssoBranchProfileActualData repoMssoBranchProfile;
    public MssoBranchProfileSmaDto getMssoDailySma(String branchCode,

                                                   String roname,
                                                   String u_loc) {


        MssoBranchProfileSmaDto mssoBranchProfileSmaDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoBranchProfileSmaDto = this.repoMssoBranchProfileSma.getDailySmaHo();

        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileSmaDto = this.repoMssoBranchProfileSma.getDailySmaBranch(branchCode);

        } else {
            mssoBranchProfileSmaDto = this.repoMssoBranchProfileSma.getDailySmaRO(roname);

        }
        MssoBranchProfileActualDataDto mssoBranchProfileDto=getMssoActualBusinessPosition(branchCode, roname, u_loc);
        BigDecimal sma0Percent = mssoBranchProfileSmaDto.getSma0_amount()
                .multiply(BigDecimal.valueOf(100))
                .divide(mssoBranchProfileDto.getAdvances(), 2, RoundingMode.HALF_UP);
        BigDecimal sma1Percent =  mssoBranchProfileSmaDto.getSma1_amount()
                .multiply(BigDecimal.valueOf(100))
                .divide(mssoBranchProfileDto.getAdvances(), 2, RoundingMode.HALF_UP);
        BigDecimal sma2Percent =  mssoBranchProfileSmaDto.getSma2_amount()
                .multiply(BigDecimal.valueOf(100))
                .divide(mssoBranchProfileDto.getAdvances(), 2, RoundingMode.HALF_UP);
        BigDecimal smaTotalPercent =  mssoBranchProfileSmaDto.getTotal_amount()
                .multiply(BigDecimal.valueOf(100))
                .divide(mssoBranchProfileDto.getAdvances(), 2, RoundingMode.HALF_UP);
        mssoBranchProfileSmaDto.setSma0Percentage(sma0Percent);
        mssoBranchProfileSmaDto.setSma1Percentage(sma1Percent);
        mssoBranchProfileSmaDto.setSma2Percentage(sma2Percent);
        mssoBranchProfileSmaDto.setSmaTotalPercentage(smaTotalPercent);
        return mssoBranchProfileSmaDto;
    }

    public MssoBranchProfileActualDataDto getMssoActualBusinessPosition(String branchCode,

                                                   String roname,
                                                   String u_loc) {
        MssoBranchProfileActualDataDto mssoBranchProfileDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoBranchProfileDto = this.repoMssoBranchProfile.getBranchProfileHo();

        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileDto = this.repoMssoBranchProfile.getBranchProfileBranch(branchCode);

        } else {
            mssoBranchProfileDto = this.repoMssoBranchProfile.getBranchProfileRO(roname);
        }
        System.out.println("inside dep-adv-npa");

        return mssoBranchProfileDto;
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

    public SectorwiseNpaDto getNpaSectorwise(String branchCode,

                                             String roname,
                                             String u_loc) {


        SectorwiseNpaDto sectorwiseNpaDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            sectorwiseNpaDto = this.repoMssoBranchProfileSma.getNpaSectorWiseHo();

        } else if (u_loc.equalsIgnoreCase("BR")) {
            sectorwiseNpaDto = this.repoMssoBranchProfileSma.getNpaSectorWiseBranch(branchCode);

        } else {
            sectorwiseNpaDto = this.repoMssoBranchProfileSma.getNpaSectorWiseRO(roname);

        }
        return sectorwiseNpaDto;

    }

    public AmountwiseNpaDto getNpaAmountwise(String branchCode,

                                             String roname,
                                             String u_loc) {


        AmountwiseNpaDto amountwiseNpaDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            amountwiseNpaDto = this.repoMssoBranchProfileSma.getNpaAmountWiseHo();

        } else if (u_loc.equalsIgnoreCase("BR")) {
            amountwiseNpaDto = this.repoMssoBranchProfileSma.getNpaSAmountWiseBranch(branchCode);

        } else {
            amountwiseNpaDto = this.repoMssoBranchProfileSma.getAmountWiseRO(roname);

        }
        return amountwiseNpaDto;

    }

    public NpaRecoveryProgressDto getNpaRegularProgress(String branchCode,

                                                        String roname,
                                                        String u_loc) {


        NpaRecoveryProgressDto npaRecoveryProgressDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            npaRecoveryProgressDto = this.repoMssoBranchProfileSma.getNpaProgressHo();

        } else if (u_loc.equalsIgnoreCase("BR")) {
            npaRecoveryProgressDto = this.repoMssoBranchProfileSma.getNpaProgressBranch(branchCode);

        } else {
            npaRecoveryProgressDto = this.repoMssoBranchProfileSma.getNpaProgressRO(roname);

        }
        return npaRecoveryProgressDto;

    }

    public NpaRecoveryProgressDto getNpaMarchProgress(String branchCode,

                                                      String roname,
                                                      String u_loc) {


        NpaRecoveryProgressDto npaRecoveryProgressDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            npaRecoveryProgressDto = this.repoMssoBranchProfileSma.getNpaProgressMarchHo();

        } else if (u_loc.equalsIgnoreCase("BR")) {
            npaRecoveryProgressDto = this.repoMssoBranchProfileSma.getNpaProgressMarchBranch(branchCode);

        } else {
            npaRecoveryProgressDto = this.repoMssoBranchProfileSma.getNpaProgressMarchRO(roname);

        }
        return npaRecoveryProgressDto;

    }

    public MssoProfileReviewRenewalDto getPendingReview(String branchCode,

                                                        String roname,
                                                        String u_loc) {


        MssoProfileReviewRenewalDto mssoProfileReviewRenewalPending = null;
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
