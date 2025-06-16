package com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileTargetDataDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile.RepoMssoBranchProfileTargetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;

@Service
public class ServiceMssoBranchProfileTargetData {
    @Autowired
    RepoMssoBranchProfileTargetData repoMssoBranchProfileTargetData;
    public MssoBranchProfileTargetDataDto  getMssoBranchProfileTargetData( String branchCode,

                                                                         String roname,
                                                                          String u_loc)
    {
        LocalDate quarterEndDate = getCurrentquarterEndDateDate();
        System.out.println("Current Quarter End Date: " + quarterEndDate);
        System.out.println("Current Quarter End Date: " + quarterEndDate);
        MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchTargetHo(quarterEndDate);

        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchTargetBranch(branchCode,quarterEndDate);

        } else {
            mssoBranchProfileTargetDataDto = this.repoMssoBranchProfileTargetData.getBranchTargetRO(roname,quarterEndDate);
        }


        return mssoBranchProfileTargetDataDto;

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


}
