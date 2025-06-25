package com.Msso.MssoBusinessBackend.Service.ServiceMssoBranchData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.ForRoBranchDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.MssoBranchEmployeeDataDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface MssoBranchDataService {

    @Transactional
    public MssoBranchEmployeeDataDto getMssoBranchData(String branchCode,String uLoc, String uId ,String roname);
    @Transactional
    public List<ForRoBranchDto> getDistinctRo();


    List<ForRoBranchDto> getDistinctbranch(String ro_name);
}
