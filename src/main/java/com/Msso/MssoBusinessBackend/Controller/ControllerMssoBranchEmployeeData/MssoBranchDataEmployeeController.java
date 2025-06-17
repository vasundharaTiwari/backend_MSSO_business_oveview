package com.Msso.MssoBusinessBackend.Controller.ControllerMssoBranchEmployeeData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchDataModel.MssoBranchEmployeeDataDto;
import com.Msso.MssoBusinessBackend.Service.ServiceMssoBranchData.MssoBranchDataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class MssoBranchDataEmployeeController {
    @Autowired
    private MssoBranchDataService mssoBranchDataService;


    @GetMapping("branchSummary")
    public ResponseEntity<MssoBranchEmployeeDataDto> getBranchSummary(@RequestParam String uLoc,
                                                                            @RequestParam String uId ,
                                                                            @RequestParam String branchCode, @RequestParam String roname){
   //     try{
            System.out.println("Controller...");

            MssoBranchEmployeeDataDto branchDataList= mssoBranchDataService.getMssoBranchData(branchCode,uLoc, uId,roname);
            System.out.println("Location:- "+uLoc+" UID: "+uId);
//            if(branchDataList.isEmpty()){
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO DATA FOUND FOR THE GIVEN UID AND LOCATION");
//            }
            return ResponseEntity.ok(branchDataList);
//        }
//        catch(IllegalArgumentException e){
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//        catch (Exception e){
//            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected Error Occurred.");
//        }


    }

}
