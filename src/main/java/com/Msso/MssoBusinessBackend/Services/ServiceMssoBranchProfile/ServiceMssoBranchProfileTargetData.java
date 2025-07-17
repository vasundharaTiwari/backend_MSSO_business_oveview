package com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileTargetDataDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile.RepoMssoBranchProfileActualData;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile.RepoMssoBranchProfileTargetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;

@Service
public class ServiceMssoBranchProfileTargetData {
    @Autowired
    RepoMssoBranchProfileTargetData repoMssoBranchProfileTargetData;


    public MssoBranchProfileTargetDataDto getMssoBranchProfileTargetData(String branchCode,

                                                                         String roname,
                                                                         String u_loc) {
        LocalDate quarterEndDate = getCurrentquarterEndDateDate();
        System.out.println("Current Quarter End Date: " + quarterEndDate);
        System.out.println("Current Quarter End Date: " + quarterEndDate);
        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchTargetHo(quarterEndDate);

        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchTargetBranch(branchCode, quarterEndDate);

        } else {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchTargetRO(roname, quarterEndDate);
        }


        return mssoBranchProfileTargetDataDto;

    }

    public MssoBranchProfileTargetDataDto getSuperAchieverMarch(String branchCode,

                                                             String roname,
                                                             String u_loc) {
        LocalDate EndDate = getFinancialYearEndDate();
        System.out.println("Current Quarter End Date: " + EndDate);
        System.out.println("Current Quarter End Date: " + EndDate);
        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getSuperAchieverHo(EndDate);

        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getSuperAchieverBranch(branchCode, EndDate);

        } else {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getSuperAchieverRO(roname, EndDate);
        }


        return mssoBranchProfileTargetDataDto;

    }
    public MssoBranchProfileTargetDataDto getMssoTargetMarch(String branchCode,

                                                                         String roname,
                                                                         String u_loc) {
        LocalDate quarterEndDate = getFinancialYearEndDate();
        System.out.println("Current Quarter End Date: " + quarterEndDate);
        System.out.println("Current Quarter End Date: " + quarterEndDate);
        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchTargetHo(quarterEndDate);

        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchTargetBranch(branchCode, quarterEndDate);

        } else {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchTargetRO(roname, quarterEndDate);
        }


        return mssoBranchProfileTargetDataDto;

    }

    public MssoBranchProfileTargetDataDto getMssoBranchProfileGapQuarter(String branchCode,

                                                                         String roname,
                                                                         String u_loc) {
        LocalDate quarterEndDate = getCurrentquarterEndDateDate();

        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchProfileHoGap(quarterEndDate);
            return mssoBranchProfileTargetDataDto;
        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchProfileBranchGap(branchCode, quarterEndDate);
            return mssoBranchProfileTargetDataDto;
        } else {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchProfileRoGap(roname, quarterEndDate);
            return mssoBranchProfileTargetDataDto;
        }


    }

    public static LocalDate getCurrentquarterEndDateDate() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int currentMonth = today.getMonthValue();

        int quarterEndDateMonth;

        if (currentMonth <= 3) {
            quarterEndDateMonth = 3;   // Q1 ends in March
        } else if (currentMonth <= 6) {
            quarterEndDateMonth = 6;   // Q2 ends in June
        } else if (currentMonth <= 9) {
            quarterEndDateMonth = 9;   // Q3 ends in September
        } else {
            quarterEndDateMonth = 12;  // Q4 ends in December
        }

        YearMonth ym = YearMonth.of(year, quarterEndDateMonth);
        return ym.atEndOfMonth();
    }
    public LocalDate getFinancialYearEndDate() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();

        if (today.isBefore(LocalDate.of(year, Month.APRIL, 1))) {
            // Jan 1 - Mar 31 : financial year ends this year on Mar 31
            return LocalDate.of(year, Month.MARCH, 31);
        } else {
            // Apr 1 - Dec 31 : financial year ends next year on Mar 31
            return LocalDate.of(year + 1, Month.MARCH, 31);
        }
    }

}
