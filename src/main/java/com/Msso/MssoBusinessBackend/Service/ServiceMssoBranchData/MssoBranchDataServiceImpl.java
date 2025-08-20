package com.Msso.MssoBusinessBackend.Service.ServiceMssoBranchData;

import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.*;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchEmployeeData.RepoMssoBranchEmployeData;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class MssoBranchDataServiceImpl implements MssoBranchDataService {

    @Autowired
    private RepoMssoBranchEmployeData repoMssoBranchData;

    @Override
    public MssoBranchEmployeeDataDto getMssoBranchData(String branchCode, String uLoc, String uId, String roname) {
        System.out.println(" Get for branch summary service..User id: " + uId + " userLocation: " + uLoc);
        String uType = "";
        if (uLoc.equals("BR")) {
            System.out.println("location for BM: " + uLoc);
            uType = "BM";
        } else if (uLoc.equals("RO")) {
            System.out.println("location for RM: " + uLoc);
            uType = "RM";
        } else if (uLoc.equals("HO")) {
            System.out.println("location for CM: " + uLoc);

            uType = "CM";
        } else {
            throw new IllegalArgumentException("Invalid Location: " + uLoc);
        }
        System.out.println("location, UID AND  UTYPE: " + uLoc + "----" + uType);

        MssoBranchEmployeeDataDto BranchSummary = repoMssoBranchData.getBranchSummary(uType, branchCode, roname);
        if (BranchSummary == null) {
            throw new RuntimeException("No data found");
        }

        return BranchSummary;
    }
    //*************************************************************************************************************


    @Override
    public List<ForRoBranchDto> getDistinctRo() {
        return repoMssoBranchData.getRegion();
    }

    //*************************************************************************************************************


    @Override
    public List<ForRoBranchDto> getDistinctbranch(String branchCode, String roname, String uLoc) {
        System.out.println("GET BRNACHES :RONAME" + roname + " " + branchCode);

        return repoMssoBranchData.getBranch(roname, branchCode);
    }
    //*************************************************************************************************************


    @Override
    public MssoEmployeeSummaryDto getMssoRegionEmployeeSummary(String branchCode, String uLoc, String roname) {
        String headOffice = "4000";
        MssoEmployeeSummaryDto mssoRegionEmployeeSummary;
        System.out.println("branchCode : ******" + branchCode);
        if (roname.equalsIgnoreCase("AURANGABAD") && uLoc.equalsIgnoreCase("HO")) {
            branchCode = headOffice;
            roname = "CHH SAMBHAJINAGAR";
        }


        if (uLoc.equalsIgnoreCase("HO")) {
            mssoRegionEmployeeSummary = repoMssoBranchData.getRegionEmployeeSummary(branchCode);
            System.out.println("mssoRegionEmployeeSummary " + mssoRegionEmployeeSummary);
        } else {
            System.out.println("branchCode : ******" + branchCode);
            System.out.println("branchCode : ******" + roname);
            System.out.println("branchCode : ******" + uLoc);


            mssoRegionEmployeeSummary = repoMssoBranchData.getBranchEmployeeSummary(roname, branchCode);
            System.out.println("mssoRegionEmployeeSummary  RO " + mssoRegionEmployeeSummary);

        }
//        if (mssoRegionEmployeeSummary==null) {
//            throw new RuntimeException("No data found");
//        }

        return mssoRegionEmployeeSummary;
    }

    //*************************************************************************************************************


    @Override
    public String getBranchCategory(String branchCode, String uLoc, String roname) {


        String branchCategory = repoMssoBranchData.getBranchCategory(branchCode);


        return branchCategory;
    }
    //*************************************************************************************************************


    @Override
    public Date getBranchAgreementDate(String branchCode, String uLoc, String roname) {


        Date agreementDate = repoMssoBranchData.getBranchAgreementEnddate(branchCode);


        return agreementDate;
    }
    //*************************************************************************************************************


    @Override
    public BranchCategoryDto getBranchCategoryCount(String branchCode, String uLoc, String roname) {
        BranchCategoryDto branchCategoryDto = null;
        if (uLoc.equalsIgnoreCase("HO")) {
            branchCategoryDto = this.repoMssoBranchData.getCategoryCountHO();
            System.out.println("branchCategoryDto" + branchCategoryDto);

        } else if (uLoc.equalsIgnoreCase("RO")) {
            branchCategoryDto = this.repoMssoBranchData.getCategoryCountRo(roname, branchCode);
            System.out.println("branchCategoryDto" + branchCategoryDto);

        }

        return branchCategoryDto;
    }
    //*************************************************************************************************************


    @Override
    public BranchOpeningDateDto getBranchOpenDate(String branchCode, String uLoc, String roname) {
        BranchOpeningDateDto branchOpeningDateDto = null;

        branchOpeningDateDto = this.repoMssoBranchData.getBranchopendate(branchCode);


        return branchOpeningDateDto;
    }
    //*************************************************************************************************************


    @Override
    public BmBranchJoinDateDto getBmBranchJoinDate(String branchCode, String u_id) {
        BmBranchJoinDateDto bmBranchJoiningDateDto = null;

        bmBranchJoiningDateDto = this.repoMssoBranchData.getBmBranchJoindate(branchCode, u_id);


        return bmBranchJoiningDateDto;
    }


}
