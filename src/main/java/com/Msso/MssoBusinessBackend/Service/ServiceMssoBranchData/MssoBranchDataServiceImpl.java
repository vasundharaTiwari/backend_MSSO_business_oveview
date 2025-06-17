package com.Msso.MssoBusinessBackend.Service.ServiceMssoBranchData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchDataModel.MssoBranchEmployeeDataDto;
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
}
