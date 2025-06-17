package com.Msso.MssoBusinessBackend.Service.ServiceMssoBranchData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchDataModel.MssoBranchEmployeeDataDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface MssoBranchDataService {

    @Transactional
    public MssoBranchEmployeeDataDto getMssoBranchData(String branchCode,String uLoc, String uId ,String roname);

}
