package com.Msso.MssoBusinessBackend.Controller.ControllerBranchProfile;

import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileAccountStatusDigitalProduct.MssoBranchProfileAccountStatusDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileDisbursement.MssoProfileDailyDisburseDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileTargetDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileSma.MssoBranchProfileSmaDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile.RepoMssoBranchProfileActualData;
import com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/msso-branch-profile")
public class MssoBranchProfileController {
    @Autowired
    RepoMssoBranchProfileActualData repoMssoBranchProfile;
@Autowired
    ServiceMssoBranchProfileTargetData serviceMssoBranchProfileTargetData;
@Autowired
    ServiceBranchProfileLast3Year serviceBranchProfileLast3Year;

@Autowired
    ServiceMssoDailyDisbursement serviceMssoDailyDisbursement;
@Autowired
    ServiceMssoBranchProfileSma serviceMssoBranchProfileSma;
@Autowired
    ServiceBranchProfileAccountStatusDigitalProduct serviceaccountStatusDigitalProduct;

@GetMapping("/dep-adv-npa")
    public MssoBranchProfileActualDataDto getBranchProfileActual(
            @RequestParam String branchCode,

            @RequestParam String roname,
            @RequestParam String u_loc) {
        MssoBranchProfileActualDataDto mssoBranchProfileDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoBranchProfileDto = this.repoMssoBranchProfile.getBranchProfileHo();

        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileDto = this.repoMssoBranchProfile.getBranchProfileBranch(branchCode);

        } else {
            mssoBranchProfileDto = this.repoMssoBranchProfile.getBranchProfileRO(roname);
        }


        return mssoBranchProfileDto;
    }
    @GetMapping("/dep-adv-npa-march")

    public List<MssoBranchProfileActualDataDto> getBranchProfileTarget(
            @RequestParam String branchCode,

            @RequestParam String roname,
            @RequestParam String u_loc) {

        List<MssoBranchProfileActualDataDto> mssoBranchProfileMarchData = serviceBranchProfileLast3Year.getMssoBranchProfileMarchData(branchCode, roname, u_loc);


        return mssoBranchProfileMarchData;
    }

    @GetMapping("/dep-adv-npa-target")
    public MssoBranchProfileTargetDataDto getBranchProfilemarch(
            @RequestParam String branchCode,

            @RequestParam String roname,
            @RequestParam String u_loc) {

        MssoBranchProfileTargetDataDto mssoBranchProfileTargetData = serviceMssoBranchProfileTargetData.getMssoBranchProfileTargetData(branchCode, roname, u_loc);


        return mssoBranchProfileTargetData;
    }

    @GetMapping("/dep-adv-npa-mar-gap")
    public MssoBranchProfileActualDataDto getBranchProfilemarchGap(
            @RequestParam String branchCode,

            @RequestParam String roname,
            @RequestParam String u_loc) {

        MssoBranchProfileActualDataDto mssoBranchProfileActualDataDto = serviceBranchProfileLast3Year.getMssoBranchProfileGapMarch(branchCode, roname, u_loc);


        return mssoBranchProfileActualDataDto;
    }

    @GetMapping("/mar-gap-percentage")
    public MssoBranchProfileActualDataDto getBranchProfilemarchGapPercentage(
            @RequestParam String branchCode,

            @RequestParam String roname,
            @RequestParam String u_loc) {

        MssoBranchProfileActualDataDto mssoBranchProfileActualDataDto = serviceBranchProfileLast3Year.getMssoBranchProfileGapMarchPercentage(branchCode, roname, u_loc);


        return mssoBranchProfileActualDataDto;
    }

    @GetMapping("/dep-adv-npa-quarter-gap")
    public MssoBranchProfileTargetDataDto getBranchProfileQuarterGap(
            @RequestParam String branchCode,

            @RequestParam String roname,
            @RequestParam String u_loc) {

        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = serviceMssoBranchProfileTargetData.getMssoBranchProfileGapQuarter(branchCode, roname, u_loc);


        return mssoBranchProfileTargetDataDto;
    }
    @GetMapping("/daily-disbursement")
    public MssoProfileDailyDisburseDto getDailyDisbursement(


            @RequestParam String roname,
            @RequestParam String branchCode,
            @RequestParam String u_loc) {

        MssoProfileDailyDisburseDto mssoProfileDailyDisburseDto =serviceMssoDailyDisbursement.getMssoDailyDisbursement(branchCode, roname, u_loc);


        System.out.println("mssoProfileDailyDisburseDto "+mssoProfileDailyDisburseDto);
        return mssoProfileDailyDisburseDto;
    }
    @GetMapping("/daily-sma")
    public MssoBranchProfileSmaDto getMssoDailySma(


            @RequestParam String roname,
            @RequestParam String branchCode,
            @RequestParam String u_loc) {

        MssoBranchProfileSmaDto mssoBranchProfileSmaDto =serviceMssoBranchProfileSma.getMssoDailySma(branchCode, roname, u_loc);


        System.out.println("mssoBranchProfileSmaDto "+mssoBranchProfileSmaDto);
        return mssoBranchProfileSmaDto;
    }
    @GetMapping("/account-status")
    public MssoBranchProfileAccountStatusDto getMssoAccountStatus(


            @RequestParam String roname,
            @RequestParam String branchCode,
            @RequestParam String u_loc) {

        MssoBranchProfileAccountStatusDto mssoBranchProfileAccountStatusDto =serviceaccountStatusDigitalProduct.getMssoAccountStatus(branchCode, roname, u_loc);


        System.out.println("mssoBranchProfileAccountStatusDto "+mssoBranchProfileAccountStatusDto);
        return mssoBranchProfileAccountStatusDto;
    }

}
