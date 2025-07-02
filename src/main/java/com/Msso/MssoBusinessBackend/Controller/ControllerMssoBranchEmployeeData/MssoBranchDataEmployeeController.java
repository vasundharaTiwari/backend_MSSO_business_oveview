package com.Msso.MssoBusinessBackend.Controller.ControllerMssoBranchEmployeeData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.BranchCategoryDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.ForRoBranchDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.MssoBranchEmployeeDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.MssoEmployeeSummaryDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileComplianceDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchEmployeeData.RepoMssoBranchEmployeData;
import com.Msso.MssoBusinessBackend.Service.ServiceMssoBranchData.MssoBranchDataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("api/v1/msso-branch-profile")
public class MssoBranchDataEmployeeController {
    @Autowired
    private MssoBranchDataService mssoBranchDataService;
    @Autowired
    RepoMssoBranchEmployeData repoEmployeData;


    @GetMapping("employee-data")
    public ResponseEntity<MssoBranchEmployeeDataDto> getBranchSummary(@RequestParam String uLoc,
                                                                      @RequestParam String uId,
                                                                      @RequestParam String branchCode, @RequestParam String roname) {

        System.out.println("employee data...");

        MssoBranchEmployeeDataDto branchDataList = mssoBranchDataService.getMssoBranchData(branchCode, uLoc, uId, roname);
        System.out.println("Location:- " + uLoc + " UID: " + uId);
        return ResponseEntity.ok(branchDataList);


    }

    @GetMapping("ro-data")
    public List<ForRoBranchDto> getDistinctRo() {

        System.out.println("ro-data...");

        List<ForRoBranchDto> forRoBranchDto = mssoBranchDataService.getDistinctRo();


        return forRoBranchDto;
    }

    @GetMapping("branch-data")
    public List<ForRoBranchDto> getDistinctBranch(@RequestParam String roname) {

        System.out.println("branch-data...");

        List<ForRoBranchDto> forRoBranchDto = mssoBranchDataService.getDistinctbranch(roname);


        return forRoBranchDto;
    }

    @GetMapping("employee-count")
    public MssoProfileComplianceDto getStaffCount( @RequestParam String branchCode,

                                                   @RequestParam String roname,
                                                   @RequestParam String u_loc)  {

        MssoProfileComplianceDto mssoProfileComplianceDto = null;
        System.out.println("ro-data...");
        if (u_loc.equals("RO")) {
             mssoProfileComplianceDto = repoEmployeData.getROStaffCount(roname);

        } else if (u_loc.equals("HO")) {
             mssoProfileComplianceDto = repoEmployeData.getHoStaffCount(branchCode);


        }


        return mssoProfileComplianceDto;
    }

        @GetMapping("branch-category")
    public String getBranchCategory(@RequestParam String uLoc, @RequestParam String branchCode, @RequestParam String roname){

        System.out.println("this.branch_code, this.region, this.u_loc..."+uLoc+" "+branchCode+" "+roname);

        String branchCategory= mssoBranchDataService.getBranchCategory(branchCode,uLoc, roname);
//        List<MssoBranchEmployeeDataDto> branchDataList= mssoBranchDataService.getMssoBranchData(branchCode,uLoc, uId,roname);


        System.out.println("Location:- "+uLoc);
        return branchCategory;


    }


    @GetMapping("employee-data-summary")
    public MssoEmployeeSummaryDto getEmployeeSummary(@RequestParam String uLoc, @RequestParam String branchCode, @RequestParam String roname){

        System.out.println("this.branch_code, this.region, this.u_loc..."+uLoc+" "+branchCode+" "+roname);

        MssoEmployeeSummaryDto mssoEmployeeSummaryDto = mssoBranchDataService.getMssoRegionEmployeeSummary(branchCode,uLoc, roname);
//        List<MssoBranchEmployeeDataDto> branchDataList= mssoBranchDataService.getMssoBranchData(branchCode,uLoc, uId,roname);


        System.out.println("Location:- "+uLoc);
        return mssoEmployeeSummaryDto;


    }
    @GetMapping("branch-category-count")
    public BranchCategoryDto getBranchCategoryCount(@RequestParam String uLoc, @RequestParam String branchCode, @RequestParam String roname){

        System.out.println("this.branch_code, this.region, this.u_loc..."+uLoc+" "+branchCode+" "+roname);

        BranchCategoryDto branchCategoryDto = mssoBranchDataService.getBranchCategoryCount(branchCode,uLoc, roname);
//        List<MssoBranchEmployeeDataDto> branchDataList= mssoBranchDataService.getMssoBranchData(branchCode,uLoc, uId,roname);


        System.out.println("branch-category-count:- "+branchCategoryDto);
        return branchCategoryDto;


    }

}
