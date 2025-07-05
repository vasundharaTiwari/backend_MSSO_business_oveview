package com.Msso.MssoBusinessBackend.Service.ServiceMssoBranchData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.*;
import jakarta.transaction.Transactional;

import java.util.List;

public interface MssoBranchDataService {

    @Transactional
    public MssoBranchEmployeeDataDto getMssoBranchData(String branchCode,String uLoc, String uId ,String roname);
    @Transactional
    public List<ForRoBranchDto> getDistinctRo();


    List<ForRoBranchDto> getDistinctbranch(String ro_name);



    @Transactional
    public MssoEmployeeSummaryDto getMssoRegionEmployeeSummary(String branchCode, String uLoc,  String roname);

    @Transactional
    public String getBranchCategory(String branchCode, String uLoc, String roname);

    BranchCategoryDto getBranchCategoryCount(String branchCode, String uLoc, String roname);
     BranchOpeningDateDto getBranchOpenDate(String branchCode , String uLoc, String roname);
}
