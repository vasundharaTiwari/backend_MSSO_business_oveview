package com.Msso.MssoBusinessBackend.Controller.ControllerBranchProfile;

import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile.RepoMssoBranchProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/msso-branch-profile")
public class MssoBranchProfileController {
    @Autowired
    RepoMssoBranchProfile repoMssoBranchProfile;

    @GetMapping("/dep-adv-npa")
    public MssoBranchProfileActualDataDto getAdvances(
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
}
