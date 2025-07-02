package com.Msso.MssoBusinessBackend.Service.ServiceMssoBranchData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.BranchCategoryDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.ForRoBranchDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.MssoBranchEmployeeDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.MssoEmployeeSummaryDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchEmployeeData.RepoMssoBranchEmployeData;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MssoBranchDataServiceImpl implements MssoBranchDataService{

    @Autowired
    private RepoMssoBranchEmployeData repoMssoBranchData;
    @Override
    public MssoBranchEmployeeDataDto getMssoBranchData(String branchCode , String uLoc,String uId,String roname) {
        System.out.println( " Get for branch summary service..User id: "+uId+" userLocation: "+uLoc);
        String uType="";
        if(uLoc.equals("BR")){
            System.out.println("location for BM: "+uLoc);
            uType="BM";
        }
        else if(uLoc.equals("RO")){
            System.out.println("location for RM: "+uLoc);
            uType="RM";
        }
        else if(uLoc.equals("HO")){
            System.out.println("location for CM: "+uLoc);

            uType="CM";
        }
        else{
            throw new IllegalArgumentException("Invalid Location: "+uLoc);
        }
        System.out.println("location, UID AND  UTYPE: "+uLoc+"----"+uType);

        MssoBranchEmployeeDataDto BranchSummary= repoMssoBranchData.getBranchSummary(uType,branchCode,roname);
        if (BranchSummary==null) {
            throw new RuntimeException("No data found");
        }

        return BranchSummary;
    }

    @Override
    public List<ForRoBranchDto> getDistinctRo() {
        return repoMssoBranchData.getRegion() ;
    }



    @Override
    public List<ForRoBranchDto> getDistinctbranch(String ro_name) {
        return  repoMssoBranchData.getBranch(ro_name);
    }

    @Override
    public MssoEmployeeSummaryDto getMssoRegionEmployeeSummary(String branchCode , String uLoc,  String roname) {

        MssoEmployeeSummaryDto mssoRegionEmployeeSummary;
        System.out.println("branchCode : ******"+branchCode);

if(uLoc.equalsIgnoreCase("HO")) {
     mssoRegionEmployeeSummary = repoMssoBranchData.getRegionEmployeeSummary(branchCode);
    System.out.println("mssoRegionEmployeeSummary "+mssoRegionEmployeeSummary);
}else{
    mssoRegionEmployeeSummary=repoMssoBranchData.getBranchEmployeeSummary(branchCode,roname);
    System.out.println("mssoRegionEmployeeSummary "+mssoRegionEmployeeSummary);

}
//        if (mssoRegionEmployeeSummary==null) {
//            throw new RuntimeException("No data found");
//        }

        return mssoRegionEmployeeSummary;
    }


    @Override
    public String  getBranchCategory(String branchCode , String uLoc,  String roname) {


           String branchCategory =repoMssoBranchData.getBranchCategory(branchCode);


        return branchCategory;
    }
    public BranchCategoryDto getBranchCategoryCount(String branchCode , String uLoc, String roname) {
        BranchCategoryDto branchCategoryDto = null;
        if (uLoc.equalsIgnoreCase("HO")) {
            branchCategoryDto = this.repoMssoBranchData.getCategoryCountHO();

        } else if (uLoc.equalsIgnoreCase("RO")) {
            branchCategoryDto = this.repoMssoBranchData.getCategoryCountRo(roname);

        }

        return branchCategoryDto;
    }

        
    
}
