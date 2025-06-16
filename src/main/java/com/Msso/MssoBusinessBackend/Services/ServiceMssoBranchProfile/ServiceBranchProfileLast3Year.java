package com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile;

import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileTargetDataDto;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile.RepoMssoBranchProfileActualData;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile.RepoMssoBranchProfileTargetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceBranchProfileLast3Year {
    @Autowired
    RepoMssoBranchProfileActualData repoMssoBranchProfilePreviousData;


    public List<MssoBranchProfileActualDataDto> getMssoBranchProfileMarchData(String branchCode,

                                                                               String roname,
                                                                               String u_loc) {
        List<LocalDate> marchEndDates = getLastThreeMarchEndDates();
        marchEndDates.forEach(System.out::println);
        List<MssoBranchProfileActualDataDto> mssoBranchProfileActualDataDto = null;
        if (u_loc.equalsIgnoreCase("HO")) {
            mssoBranchProfileActualDataDto = this.repoMssoBranchProfilePreviousData.getBranchProfileHoMarchData(marchEndDates);
            return mssoBranchProfileActualDataDto;
        } else if (u_loc.equalsIgnoreCase("BR")) {
            mssoBranchProfileActualDataDto = this.repoMssoBranchProfilePreviousData.getBranchProfileBranchMarchData(branchCode,marchEndDates);
            return mssoBranchProfileActualDataDto;
        } else {
            mssoBranchProfileActualDataDto = this.repoMssoBranchProfilePreviousData.getBranchProfileROMarchData(roname,marchEndDates);
            return mssoBranchProfileActualDataDto;
        }


        }



    public static List<LocalDate> getLastThreeMarchEndDates() {
        int currentYear = LocalDate.now().getYear();
        List<LocalDate> marchEnds = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            LocalDate marchEnd = LocalDate.of(currentYear - i, Month.MARCH, 31);
            marchEnds.add(marchEnd);
        }
        return marchEnds;
    }
}