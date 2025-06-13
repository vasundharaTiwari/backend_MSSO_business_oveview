package com.Msso.MssoBusinessBackend.Controller.ControllerMssoAdvances;

import com.Msso.MssoBusinessBackend.Model.MssoAdvancesModel.DtoMssoAdvancesBranchwise;
import com.Msso.MssoBusinessBackend.Model.MssoAdvancesModel.DtoMssoAdvancesRegionwise;
import com.Msso.MssoBusinessBackend.Model.MssoAdvancesModel.MssoAdvancesDto;
import com.Msso.MssoBusinessBackend.Model.MssoDepositModel.DtoMssoDepositBranchwise;
import com.Msso.MssoBusinessBackend.Model.MssoDepositModel.DtoMssoDepositRegionwise;
import com.Msso.MssoBusinessBackend.Model.MssoDepositModel.MssoDepositDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoAdvances.RepoMssoAdvances;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/msso-advances")
public class MssoAdvancesController {
    @Autowired
    RepoMssoAdvances repoMssoAdvances;

    @GetMapping("/msso-advances")
    public MssoAdvancesDto getAdvances(
            @RequestParam String branchCode,

            @RequestParam String roname,
            @RequestParam String u_loc) {
        MssoAdvancesDto mssoAdvancesDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoAdvancesDto = this.repoMssoAdvances.getAdvancesHo();

        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoAdvancesDto = this.repoMssoAdvances.getAdvancesBranch(branchCode);

        } else {
            mssoAdvancesDto = this.repoMssoAdvances.getAdvancesRO(roname );
        }


        return mssoAdvancesDto;
    }
    @GetMapping("/regionwise")
    public List<DtoMssoAdvancesRegionwise> getAdvancesRegionwise() {

        return repoMssoAdvances.getAdvancesHORegionwise();
    }

    @GetMapping("/branchwise")
    public List<DtoMssoAdvancesBranchwise> getAdvancesBranchwise(@RequestParam String roname) {

        return repoMssoAdvances.getAdvancesHOBranchwise(roname);
    }
}
