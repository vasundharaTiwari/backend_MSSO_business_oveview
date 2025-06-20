package com.Msso.MssoBusinessBackend.Controller.ControllerBranchProfile;

import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoAccountStatusDigitalTargetDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileAccountStatusDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileDigitalProductDto;
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
    ServiceAccountStatusDigitalProduct serviceaccountStatusDigitalProduct;


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
        System.out.println("inside dep-adv-npa");

        return mssoBranchProfileDto;
    }

    @GetMapping("/dep-adv-npa-march")

    public List<MssoBranchProfileActualDataDto> getBranchProfileTarget(
            @RequestParam String branchCode,

            @RequestParam String roname,
            @RequestParam String u_loc) {

        List<MssoBranchProfileActualDataDto> mssoBranchProfileMarchData = serviceBranchProfileLast3Year.getMssoBranchProfileMarchData(branchCode, roname, u_loc);

        System.out.println("inside dep-adv-npa-march");
        return mssoBranchProfileMarchData;
    }

    @GetMapping("/dep-adv-npa-target")
    public MssoBranchProfileTargetDataDto getBranchProfilemarch(
            @RequestParam String branchCode,

            @RequestParam String roname,
            @RequestParam String u_loc) {

        MssoBranchProfileTargetDataDto mssoBranchProfileTargetData = serviceMssoBranchProfileTargetData.getMssoBranchProfileTargetData(branchCode, roname, u_loc);

        System.out.println("inside dep-adv-npa-target");
        return mssoBranchProfileTargetData;
    }

    @GetMapping("/dep-adv-npa-mar-gap")
    public MssoBranchProfileActualDataDto getBranchProfilemarchGap(
            @RequestParam String branchCode,

            @RequestParam String roname,
            @RequestParam String u_loc) {

        MssoBranchProfileActualDataDto mssoBranchProfileActualDataDto = serviceBranchProfileLast3Year.getMssoBranchProfileGapMarch(branchCode, roname, u_loc);

        System.out.println("inside dep-adv-npa-mar-gap");
        return mssoBranchProfileActualDataDto;
    }

    @GetMapping("/mar-gap-percentage")
    public MssoBranchProfileActualDataDto getBranchProfilemarchGapPercentage(
            @RequestParam String branchCode,

            @RequestParam String roname,
            @RequestParam String u_loc) {

        MssoBranchProfileActualDataDto mssoBranchProfileActualDataDto = serviceBranchProfileLast3Year.getMssoBranchProfileGapMarchPercentage(branchCode, roname, u_loc);

        System.out.println("inside mar-gap-percentage");
        return mssoBranchProfileActualDataDto;
    }

    @GetMapping("/dep-adv-npa-quarter-gap")
    public MssoBranchProfileTargetDataDto getBranchProfileQuarterGap(
            @RequestParam String branchCode,

            @RequestParam String roname,
            @RequestParam String u_loc) {

        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = serviceMssoBranchProfileTargetData.getMssoBranchProfileGapQuarter(branchCode, roname, u_loc);

        System.out.println("inside dep-adv-npa-quarter-gap");
        return mssoBranchProfileTargetDataDto;
    }

    @GetMapping("/daily-disbursement")
    public MssoProfileDailyDisburseDto getDailyDisbursement(


            @RequestParam String roname,
            @RequestParam String branchCode,
            @RequestParam String u_loc) {

        MssoProfileDailyDisburseDto mssoProfileDailyDisburseDto = serviceMssoDailyDisbursement.getMssoDailyDisbursement(branchCode, roname, u_loc);


        System.out.println("inside daily-disbursement");
        return mssoProfileDailyDisburseDto;
    }

    @GetMapping("/daily-sma")
    public MssoBranchProfileSmaDto getMssoDailySma(


            @RequestParam String roname,
            @RequestParam String branchCode,
            @RequestParam String u_loc) {

        MssoBranchProfileSmaDto mssoBranchProfileSmaDto = serviceMssoBranchProfileSma.getMssoDailySma(branchCode, roname, u_loc);


        System.out.println("inside daily-sma");
        return mssoBranchProfileSmaDto;
    }

    @GetMapping("/account-status")
    public MssoBranchProfileAccountStatusDto getMssoAccountStatus(


            @RequestParam String roname,
            @RequestParam String branchCode,
            @RequestParam String u_loc) {

        MssoBranchProfileAccountStatusDto mssoBranchProfileAccountStatusDto = serviceaccountStatusDigitalProduct.getMssoAccountStatus(branchCode, roname, u_loc);


        System.out.println("inside account-status");
        return mssoBranchProfileAccountStatusDto;
    }

    @GetMapping("/digital-product")
    public MssoBranchProfileDigitalProductDto getMssoDigitalProduct(


            @RequestParam String roname,
            @RequestParam String branchCode,
            @RequestParam String u_loc) {

        MssoBranchProfileDigitalProductDto mssoBranchProfileDigitalProductDto = serviceaccountStatusDigitalProduct.getMssoDigitalProduct(branchCode, roname, u_loc);


        System.out.println("inside digital-product");
        return mssoBranchProfileDigitalProductDto;
    }

    @GetMapping("/account-digital-target")
    public MssoAccountStatusDigitalTargetDto getMssoAccountDigitalProductTarget(


            @RequestParam String roname,
            @RequestParam String branchCode,
            @RequestParam String u_loc) {

        MssoAccountStatusDigitalTargetDto mssoAccountStatusDigitalTargetDto = serviceaccountStatusDigitalProduct.getMssoAccountDigitalProductTarget(branchCode, roname, u_loc);


        System.out.println("inside digital-product");
        return mssoAccountStatusDigitalTargetDto;
    }
}
