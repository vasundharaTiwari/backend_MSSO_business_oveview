package com.Msso.MssoBusinessBackend.Service.ServiceMssoBranchData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchDataModel.MssoBranchData;
import jakarta.transaction.Transactional;

import java.util.List;

public interface MssoBranchDataService {

    @Transactional
    public List<MssoBranchData> getMssoBranchData(String uLoc, String uId);

}
