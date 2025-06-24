package com.Msso.MssoBusinessBackend.Controller.ControllerMssoSession;

import com.Msso.MssoBusinessBackend.Model.MssoDepositModel.MssoDepositDto;
import com.Msso.MssoBusinessBackend.Services.ServiceMssoSession.ServiceSessonMsso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping({"/branch-profile/msso-session"})
public class ControllerMssoSession {
    @Autowired
    ServiceSessonMsso serviceSessonMsso;

    @GetMapping({"/"})

    public boolean getDeposit(@RequestParam String u, @RequestParam Long mran, @RequestParam Long ran) {
        boolean result=serviceSessonMsso.getResult(mran,ran,u);

        return result;
    }
}
