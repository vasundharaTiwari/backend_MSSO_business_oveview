package com.Msso.MssoBusinessBackend.Reports;

import com.Msso.MssoBusinessBackend.Repository.RepoMssoBrachProfileSma.RepoMssoBranchProfileSma;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfileDailyDisbursement.RepoMssoBranchProfileDailyDisbursement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@AllArgsConstructor
public class BranchProfileReport {

    private final RepoMssoBranchProfileSma repoMssoBranchProfileSma;
    private final RepoMssoBranchProfileDailyDisbursement repoMssoBranchProfileDailyDisbursement;


    public ResponseEntity<ByteArrayResource> exportAppraisalNoteSalaryReport(String referenceId, String pfNo, String u_type, String roname, String u_loc) throws JRException {

try{
            //********************************************** Load main JRXML file ************************************************************************************

            //***************************************************************************************************************************************************************

    InputStream templateStream;
                templateStream = getClass().getResourceAsStream("/REPORTS/ReportDownload.jrxml");


            JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);


            //*********************************************** Main JRXML parameter mapping ***************************************************************************


    Map<String, Object> parameters = new HashMap<>();


            //******************************** FILL THE MAIN REPORT ***********************************************************8
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            //******************************** Export to PDF ********************************************************************
            byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=AppraisalNote" + referenceId + ".pdf");

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new ByteArrayResource(pdfBytes));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

}
