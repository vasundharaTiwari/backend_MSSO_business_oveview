package com.Msso.MssoBusinessBackend.Controller.ControllerMssoBranchEmployeeData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.ForRoBranchDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.MssoBranchEmployeeDataDto;
import com.Msso.MssoBusinessBackend.Service.ServiceMssoBranchData.MssoBranchDataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class MssoBranchDataEmployeeController {
    @Autowired
    private MssoBranchDataService mssoBranchDataService;


    @GetMapping("employee-data")
    public ResponseEntity<MssoBranchEmployeeDataDto> getBranchSummary(@RequestParam String uLoc,
                                                                            @RequestParam String uId ,
                                                                            @RequestParam String branchCode, @RequestParam String roname){

            System.out.println("employee data...");

            MssoBranchEmployeeDataDto branchDataList= mssoBranchDataService.getMssoBranchData(branchCode,uLoc, uId,roname);
            System.out.println("Location:- "+uLoc+" UID: "+uId);
            return ResponseEntity.ok(branchDataList);


    }
    @GetMapping("ro-data")
    public List<ForRoBranchDto> getDistinctRo(){

        System.out.println("ro-data...");

        List<ForRoBranchDto> forRoBranchDto=mssoBranchDataService.getDistinctRo();


        return forRoBranchDto;
    }
    @GetMapping("branch-data")
    public List<ForRoBranchDto> getDistinctBranch(@RequestParam String roname){

        System.out.println("branch-data...");

        List<ForRoBranchDto> forRoBranchDto=mssoBranchDataService.getDistinctbranch(roname);


        return forRoBranchDto;
    }
}
