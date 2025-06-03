package com.Msso.MssoBusinessBackend.Controller.ControllerMssoAdvances;

import com.Msso.MssoBusinessBackend.Model.MssoAdvancesModel.MssoAdvancesDto;
import com.Msso.MssoBusinessBackend.Model.MssoDepositModel.MssoDepositDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoAdvances.RepoMssoAdvances;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            @RequestParam String u_loc, @RequestParam String report_date) {
        MssoAdvancesDto mssoAdvancesDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoAdvancesDto = this.repoMssoAdvances.getAdvancesHo(report_date);

        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoAdvancesDto = this.repoMssoAdvances.getAdvancesBranch(branchCode, report_date);

        } else {
            mssoAdvancesDto = this.repoMssoAdvances.getAdvancesRO(roname, report_date);
        }


        return mssoAdvancesDto;
    }
}
