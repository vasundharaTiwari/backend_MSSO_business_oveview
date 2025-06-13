//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.Msso.MssoBusinessBackend.Controller.ControllerMssoDeposit;

import com.Msso.MssoBusinessBackend.Model.MssoDepositModel.DtoMssoDepositBranchwise;
import com.Msso.MssoBusinessBackend.Model.MssoDepositModel.DtoMssoDepositRegionwise;
import com.Msso.MssoBusinessBackend.Model.MssoDepositModel.MssoDepositDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoDeposit.RepoMssoDeposit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping({"/api/v1/msso-deposit"})
public class MssoDepositController {
    @Autowired
    RepoMssoDeposit repoMssoDeposit;

    public MssoDepositController() {
    }

    @GetMapping({"/msso-deposit"})
    public MssoDepositDto getDeposit(@RequestParam String branchCode, @RequestParam String roname, @RequestParam String u_loc) {
        MssoDepositDto mssoDepositDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoDepositDto = this.repoMssoDeposit.getDepositHo();
        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoDepositDto = this.repoMssoDeposit.getDepositBranch(branchCode);
        } else {
            mssoDepositDto = this.repoMssoDeposit.getDepositRO(roname);
        }

        return mssoDepositDto;
    }

    @GetMapping({"/regionwise"})
    public List<DtoMssoDepositRegionwise> getDepositRegionwise() {
        return this.repoMssoDeposit.getDepositHORegionwise();
    }

    @GetMapping({"/branchwise"})
    public List<DtoMssoDepositBranchwise> getDepositBranchwise(@RequestParam String roname) {
        return this.repoMssoDeposit.getDepositHOBranchwise(roname);
    }
}
