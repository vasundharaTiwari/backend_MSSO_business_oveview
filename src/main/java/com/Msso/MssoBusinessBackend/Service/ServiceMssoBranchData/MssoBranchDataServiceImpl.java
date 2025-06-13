package com.Msso.MssoBusinessBackend.Service.ServiceMssoBranchData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchDataModel.MssoBranchData;
import com.Msso.MssoBusinessBackend.Model.MssoBranchDataModel.MssoBranchDataDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchData.RepoMssoBranchData;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MssoBranchDataServiceImpl implements MssoBranchDataService{

    @Autowired
    private RepoMssoBranchData repoMssoBranchData;
    @Override
    public List<MssoBranchDataDto> getMssoBranchData(String uLoc, String uId) {
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
        System.out.println("location, UID AND  UTYPE: "+uLoc+"--"+uId+"--"+uType);

        List<MssoBranchDataDto> BranchSummary= repoMssoBranchData.getBranchSummary(uLoc, uId, uType);
        if (BranchSummary.isEmpty()) {
            throw new RuntimeException("No data found");
        }

        return BranchSummary;
    }
}
