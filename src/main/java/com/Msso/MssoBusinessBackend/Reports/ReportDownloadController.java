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

@RestController
@RequiredArgsConstructor
@CrossOrigin
@Data
@RequestMapping("/api/v1/report")
public class ReportDownloadController {

@Autowired
private BranchProfileReport branchProfileReport;

    //********************************* APPRAISAL NOTE BELOW HOD ************************************
    @GetMapping("/download-upto-rm")
    public ResponseEntity<ByteArrayResource> exportAppraisalNoteReport(@RequestParam String branch_code,
                                                                       @RequestParam String region,
                                                                       @RequestParam String u_loc) throws JRException, FileNotFoundException, NoSuchFileException {


        System.out.println("Data for BranchProfileReport"+branch_code+region+u_loc);

        return branchProfileReport.exportBranchProfileReport(branch_code,region,u_loc);

    }



}
