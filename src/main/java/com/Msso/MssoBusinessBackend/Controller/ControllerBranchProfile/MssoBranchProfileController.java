package com.Msso.MssoBusinessBackend.Controller.ControllerBranchProfile;

import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileTargetDataDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile.RepoMssoBranchProfileActualData;
import com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile.ServiceBranchProfileLast3Year;
import com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile.ServiceMssoBranchProfileTargetData;
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
}
