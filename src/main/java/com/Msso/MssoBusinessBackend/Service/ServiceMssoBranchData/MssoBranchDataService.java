package com.Msso.MssoBusinessBackend.Service.ServiceMssoBranchData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Transactional
public interface MssoBranchDataService {

    @Transactional
    public MssoBranchEmployeeDataDto getMssoBranchData(String branchCode,String uLoc, String uId ,String roname);
    @Transactional
    public List<ForRoBranchDto> getDistinctRo();


    List<ForRoBranchDto> getDistinctbranch(String branchCode, String roname,String uLoc);



    @Transactional
    public MssoEmployeeSummaryDto getMssoRegionEmployeeSummary(String branchCode, String uLoc,  String roname);

    @Transactional
    public String getBranchCategory(String branchCode, String uLoc, String roname);

    BranchCategoryDto getBranchCategoryCount(String branchCode, String uLoc, String roname);
     BranchOpeningDateDto getBranchOpenDate(String branchCode , String uLoc, String roname);

    BmBranchJoinDateDto getBmBranchJoinDate(String branchCode , String u_id);
    public Date getBranchAgreementDate(String branchCode , String uLoc, String roname);
}
