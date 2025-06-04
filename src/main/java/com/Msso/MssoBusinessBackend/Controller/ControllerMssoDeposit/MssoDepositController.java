package com.Msso.MssoBusinessBackend.Controller.ControllerMssoDeposit;

import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.DtoMssoBusinessBranchwise;
import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.DtoMssoBusinessRegionwise;
import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.MssoBusinessDto;
import com.Msso.MssoBusinessBackend.Model.MssoDepositModel.DtoMssoDepositBranchwise;
import com.Msso.MssoBusinessBackend.Model.MssoDepositModel.DtoMssoDepositRegionwise;
import com.Msso.MssoBusinessBackend.Model.MssoDepositModel.MssoDepositDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoDeposit.RepoMssoDeposit;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoOverview.RepoMssoOverview;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/msso-deposit")
public class MssoDepositController {
    @Autowired
    RepoMssoDeposit repoMssoDeposit;


    @GetMapping("/msso-deposit")
    public MssoDepositDto getDeposit(
            @RequestParam String branchCode,

            @RequestParam String roname,
            @RequestParam String u_loc, @RequestParam String report_date) {
        MssoDepositDto mssoDepositDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoDepositDto = this.repoMssoDeposit.getDepositHo(report_date);

        }
        else if (u_loc.equalsIgnoreCase("BR")) {
            mssoDepositDto=this.repoMssoDeposit.getDepositBranch(branchCode, report_date);

        } else {
            mssoDepositDto=this.repoMssoDeposit.getDepositRO(roname, report_date);
        }


        return mssoDepositDto;
    }

    @GetMapping("/regionwise")
    public List<DtoMssoDepositRegionwise> getDepositRegionwise(@RequestParam String report_date) {

        return repoMssoDeposit.getDepositHORegionwise(report_date);
    }

    @GetMapping("/branchwise")
    public List<DtoMssoDepositBranchwise> getDepositBranchwise(@RequestParam String roname , @RequestParam String report_date) {

        return repoMssoDeposit.getDepositHOBranchwise(roname, report_date);
    }
}

