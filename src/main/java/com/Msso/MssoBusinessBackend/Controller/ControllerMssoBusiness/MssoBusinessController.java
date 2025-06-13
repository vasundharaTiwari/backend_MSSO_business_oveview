//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.Msso.MssoBusinessBackend.Controller.ControllerMssoBusiness;

import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.DtoMssoBusinessBranchwise;
import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.DtoMssoBusinessRegionwise;
import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.MssoBusinessDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoOverview.RepoMssoOverview;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping({"/api/v1/msso-business"})
public class MssoBusinessController {
    @Autowired
    RepoMssoOverview repoMssoOverview;

    public MssoBusinessController() {
    }

    @GetMapping({"/bank"})
    public MssoBusinessDto getBusiness(@RequestParam String branchCode, @RequestParam String roname, @RequestParam String u_loc) {
        MssoBusinessDto mssoBusinessDto;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoBusinessDto = this.repoMssoOverview.getBusinesssHo();
        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoBusinessDto = this.repoMssoOverview.getBusinesssBranch(branchCode);
        } else {
            mssoBusinessDto = this.repoMssoOverview.getBusinesssRO(roname);
        }

        return mssoBusinessDto;
    }

    @GetMapping({"/regionwise"})
    public List<DtoMssoBusinessRegionwise> getBusinessRegionwise() {
        return this.repoMssoOverview.getBusinesssHORegionwise();
    }

    @GetMapping({"/branchwise"})
    public List<DtoMssoBusinessBranchwise> getBusinessBranchwise(@RequestParam String roname) {
        return this.repoMssoOverview.getBusinesssHOBranchwise(roname);
    }
}
