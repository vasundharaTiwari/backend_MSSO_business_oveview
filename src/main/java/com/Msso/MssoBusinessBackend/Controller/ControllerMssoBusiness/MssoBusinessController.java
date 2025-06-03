package com.Msso.MssoBusinessBackend.Controller.ControllerMssoBusiness;

import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.DtoMssoBusinessBranchwise;
import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.DtoMssoBusinessRegionwise;
import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.MssoBusinessDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoOverview.RepoMssoOverview;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/msso-business")
public class MssoBusinessController {
    @Autowired
    RepoMssoOverview repoMssoOverview;


    @GetMapping("/bank")
    public MssoBusinessDto getBusiness(@RequestParam String branchCode, @RequestParam String roname,
                                       @RequestParam String u_loc, @RequestParam String report_date) {
        MssoBusinessDto mssoBusinessDto;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoBusinessDto = this.repoMssoOverview.getBusinesssHo(report_date);

        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoBusinessDto = this.repoMssoOverview.getBusinesssBranch(branchCode, report_date);

        } else {
            mssoBusinessDto = this.repoMssoOverview.getBusinesssRO(roname, report_date);
        }


        return mssoBusinessDto;
    }

    @GetMapping("/regionwise")
    public List<DtoMssoBusinessRegionwise> getBusinessRegionwise( @RequestParam String report_date) {

        return repoMssoOverview.getBusinesssHORegionwise(report_date);
    }

    @GetMapping("/branchwise")
    public List<DtoMssoBusinessBranchwise> getBusinessBranchwise( @RequestParam String roname , @RequestParam String report_date) {

        return repoMssoOverview.getBusinesssHOBranchwise(roname, report_date);
    }
}
