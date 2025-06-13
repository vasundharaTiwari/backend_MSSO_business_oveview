package com.Msso.MssoBusinessBackend.Service.ServiceMssoBranchData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchDataModel.MssoBranchData;
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
    public List<MssoBranchData> getMssoBranchData(String uLoc, String uId) {
        System.out.println( " USER ID FOR THE SEARCH IS :"+uId);

        List<MssoBranchData> BranchSummary= repoMssoBranchData.getBranchSummary(uLoc, uId);
        if (BranchSummary.isEmpty()) {
            throw new RuntimeException("No data found");
        }

        return BranchSummary;
    }
}
