package com.Msso.MssoBusinessBackend.Controller.ControllerMssoBusiness;

import com.Msso.MssoBusinessBackend.Model.MssoBusinessModel.MssoBusinessDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoOverview.RepoMssoOverview;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/msso-business")
public class MssoBusinessController {
    @Autowired
    RepoMssoOverview repoMssoOverview;


    @GetMapping  ("/msso-business")
    public MssoBusinessDto getBusiness(
            @RequestParam String branchCode,

            @RequestParam String roname,
            @RequestParam String u_loc,@RequestParam String report_date) {
        MssoBusinessDto mssoBusinessDto;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoBusinessDto=this.repoMssoOverview.getBusinesssHo(report_date);

        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoBusinessDto=this.repoMssoOverview.getBusinesssBranch(branchCode, report_date);

        } else {
            mssoBusinessDto=this.repoMssoOverview.getBusinesssRO(roname, report_date);
        }


        return mssoBusinessDto;
    }
    }
