package com.Msso.MssoBusinessBackend.Controller.ControllerMssoBranchEmployeeData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.*;
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

        System.out.println("ro-data..."+forRoBranchDto);


        return forRoBranchDto;
    }

    @GetMapping("branch-data")
    public List<ForRoBranchDto> getDistinctBranch(@RequestParam String branchCode,

                                                  @RequestParam String roname,
                                                  @RequestParam String u_loc)  {

        System.out.println("branch-data...");

        List<ForRoBranchDto> forRoBranchDto = mssoBranchDataService.getDistinctbranch(branchCode,roname,u_loc);

        System.out.println("branch-data... "+forRoBranchDto);

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

        System.out.println(" getEmployeeSummary this.branch_code, this.region, this.u_loc..."+uLoc+" "+branchCode+" "+roname);

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
    @GetMapping("branch-open-date")
    public BranchOpeningDateDto getBranchOpeningDate(@RequestParam String uLoc, @RequestParam String branchCode, @RequestParam String roname){

        System.out.println("this.branch_code, this.region, this.u_loc..."+uLoc+" "+branchCode+" "+roname);

        BranchOpeningDateDto branchOpeningDateDto = mssoBranchDataService.getBranchOpenDate(branchCode,uLoc, roname);
//        List<MssoBranchEmployeeDataDto> branchDataList= mssoBranchDataService.getMssoBranchData(branchCode,uLoc, uId,roname);


        System.out.println("branch-open-date:- "+branchOpeningDateDto);
        return branchOpeningDateDto;


    }



    @GetMapping("bm-branch-join-date")
    public BmBranchJoinDateDto getBmBranchJoinDate( @RequestParam String branchCode, @RequestParam String u_id){

        System.out.println("this.branch_code, ..." +branchCode+" "+u_id);

        BmBranchJoinDateDto bmBranchJoinDate = mssoBranchDataService.getBmBranchJoinDate(branchCode,u_id);
//        List<MssoBranchEmployeeDataDto> branchDataList= mssoBranchDataService.getMssoBranchData(branchCode,uLoc, uId,roname);


        System.out.println("bm-branch-join-date:- "+bmBranchJoinDate);
        return bmBranchJoinDate;


    }

    @GetMapping("bc-data")
    public BranchCategoryDto getBCData(@RequestParam String uLoc, @RequestParam String branchCode, @RequestParam String roname){

        BranchCategoryDto branchCategoryDto = null;
        if (uLoc.equalsIgnoreCase("HO")) {
            branchCategoryDto = this.repoEmployeData.getBCCountHO();
            System.out.println("getBCCountHO"+branchCategoryDto);

        } else if (uLoc.equalsIgnoreCase("RO")) {
            branchCategoryDto = this.repoEmployeData.getBCCountRo(roname);
            System.out.println("branchCategoryDto"+branchCategoryDto);

        }
else if (uLoc.equalsIgnoreCase("BR")){ branchCategoryDto = this.repoEmployeData.getBCCountBranch(branchCode);}
        return branchCategoryDto;


    }
}
