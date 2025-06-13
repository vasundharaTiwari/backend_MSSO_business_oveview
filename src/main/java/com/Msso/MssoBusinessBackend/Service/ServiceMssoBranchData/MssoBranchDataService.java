package com.Msso.MssoBusinessBackend.Service.ServiceMssoBranchData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchDataModel.MssoBranchData;
import com.Msso.MssoBusinessBackend.Model.MssoBranchDataModel.MssoBranchDataDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface MssoBranchDataService {

    @Transactional
    public List<MssoBranchDataDto> getMssoBranchData(String uLoc, String uId);

}
