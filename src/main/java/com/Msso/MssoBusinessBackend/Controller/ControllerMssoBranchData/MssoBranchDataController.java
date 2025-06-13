package com.Msso.MssoBusinessBackend.Controller.ControllerMssoBranchData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchDataModel.MssoBranchData;
import com.Msso.MssoBusinessBackend.Model.MssoBranchDataModel.MssoBranchDataDto;
import com.Msso.MssoBusinessBackend.Service.ServiceMssoBranchData.MssoBranchDataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("v1/msso")
public class MssoBranchDataController {
    @Autowired
    private MssoBranchDataService mssoBranchDataService;


    @GetMapping("branchSummary")
    public ResponseEntity<List<MssoBranchDataDto>> getBranchSummary(@RequestParam String uLoc,
                                                 @RequestParam String uId){
   //     try{
            System.out.println("Controller...");

            List<MssoBranchDataDto> branchDataList= mssoBranchDataService.getMssoBranchData(uLoc, uId);
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
