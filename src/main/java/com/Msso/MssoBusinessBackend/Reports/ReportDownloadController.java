package com.Msso.MssoBusinessBackend.Reports;


import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchEmployeeData.RepoMssoBranchEmployeData;
import com.Msso.MssoBusinessBackend.Service.ServiceMssoBranchData.MssoBranchDataService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;
import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@Data
@RequestMapping("/api/v1/report")
public class ReportDownloadController {

    @Autowired
    private BranchProfileReport branchProfileReport;

    //********************************* APPRAISAL NOTE BELOW HOD ************************************
    @GetMapping("/branch-profile")
    public ResponseEntity<ByteArrayResource> exportAppraisalNoteReport(@RequestParam String branch_code,
                                                                       @RequestParam String region,
                                                                       @RequestParam String u_loc,
                                                                       @RequestParam String file_type ) throws JRException, FileNotFoundException, NoSuchFileException {


        System.out.println("Data for BranchProfileReport"+branch_code+region+u_loc);

        return branchProfileReport.exportBranchProfileReport(branch_code,region,u_loc,file_type);

    }
    @GetMapping("/visit-report")
    public ResponseEntity<ByteArrayResource> exportVisitReport(@RequestParam String branch_code,
                                                                       @RequestParam String visit_date
                                                                      ) throws JRException, FileNotFoundException, NoSuchFileException {


        System.out.println("Data for BranchProfileReport"+branch_code+visit_date);



        return branchProfileReport.exportVisitReport(branch_code, LocalDate.parse(visit_date));

    }


}
