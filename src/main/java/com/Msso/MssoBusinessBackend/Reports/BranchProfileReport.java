package com.Msso.MssoBusinessBackend.Reports;

import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.MssoBranchEmployeeDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileDisbursement.MssoProfileDailyDisburseDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileTargetDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileSma.MssoBranchProfileSmaDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoAccountStatusDigitalTargetDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileAccountStatusDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileDigitalProductDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileComplianceDto;
import com.Msso.MssoBusinessBackend.Model.ParameterDetails;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBrachProfileSma.RepoMssoBranchProfileSma;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile.RepoMssoBranchProfileActualData;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfileDailyDisbursement.RepoMssoBranchProfileDailyDisbursement;
import com.Msso.MssoBusinessBackend.Service.ServiceMssoBranchData.MssoBranchDataService;
import com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class BranchProfileReport {

    @Autowired
    private ServiceMssoBranchProfileSma serviceMssoBranchProfileSma;
    @Autowired
    private ServiceMssoDailyDisbursement serviceMssoDailyDisbursement;
    @Autowired
    private MssoBranchDataService mssoBranchDataService;
    @Autowired
    private ServiceBranchProfileLast3Year serviceBranchProfileLast3Year;
    @Autowired
    ServiceMssoBranchProfileTargetData serviceMssoBranchProfileTargetData;
    @Autowired
    ServiceAccountStatusDigitalProduct serviceaccountStatusDigitalProduct;
    @Autowired
    RepoMssoBranchProfileActualData repoMssoBranchProfile;
    public ResponseEntity<ByteArrayResource> exportBranchProfileReport(String branch_code,  String region, String u_loc) throws JRException {

try{
            //********************************************** Load main JRXML file ************************************************************************************

            //***************************************************************************************************************************************************************

                InputStream templateStream;
                templateStream = getClass().getResourceAsStream("/REPORTS/ReportDownload.jrxml");



            JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);


            //*********************************************** Main JRXML parameter mapping ***************************************************************************
    MssoBranchProfileSmaDto mssoBranchProfileSmaDto=serviceMssoBranchProfileSma.getMssoDailySma(branch_code,region,u_loc);
    System.out.println("SMA DATA :"+mssoBranchProfileSmaDto);
    List<MssoBranchProfileSmaDto> mssoBranchProfileSmaDtoList = Collections.singletonList(mssoBranchProfileSmaDto);

    MssoProfileComplianceDto pendingReviewRenewal=serviceMssoBranchProfileSma.getPendingReview(branch_code,region,u_loc);
    System.out.println("SMA DATA :"+pendingReviewRenewal.getTotal_amount()+pendingReviewRenewal.getTotal_count());

    MssoProfileDailyDisburseDto mssoProfileDailyDisburseDto=serviceMssoDailyDisbursement.getMssoDailyDisbursement(branch_code,region,u_loc);
    System.out.println("SMA DATA :"+mssoProfileDailyDisburseDto);
    List<MssoProfileDailyDisburseDto> mssoProfileDailyDisburseDtoList = Collections.singletonList(mssoProfileDailyDisburseDto);





    // 3 years
    List<MssoBranchProfileActualDataDto> mssoBranchProfileActualDataDto=serviceBranchProfileLast3Year.getMssoBranchProfileMarchData(branch_code,region,u_loc);
    System.out.println("mssoBranchProfileActualDataDto DATA :"+mssoBranchProfileActualDataDto.get(0));

    //march
   MssoBranchProfileActualDataDto mssoBranchProfileActualDataDtoMarchGap=serviceBranchProfileLast3Year.getMssoBranchProfileGapMarch(branch_code,region,u_loc);
    System.out.println("SMA DATA :"+mssoProfileDailyDisburseDto);

    MssoBranchProfileTargetDataDto mssoBranchProfileQuarterTargetData = serviceMssoBranchProfileTargetData.getMssoBranchProfileTargetData(branch_code,region,u_loc);
    System.out.println("mssoBranchProfileQuarterTargetData DATA :"+mssoBranchProfileQuarterTargetData);

    MssoBranchProfileTargetDataDto mssoBranchProfileMarchTargetData = serviceMssoBranchProfileTargetData.getMssoTargetMarch(branch_code,region,u_loc);
    MssoBranchProfileActualDataDto mssoBranchProfileActualDataDtoMarchGapPer = serviceBranchProfileLast3Year.getMssoBranchProfileGapMarchPercentage(branch_code,region,u_loc);
    MssoBranchProfileActualDataDto mssoBranchProfileCurrentData = null;
    if (u_loc.equalsIgnoreCase("HO")) {
        mssoBranchProfileCurrentData = this.repoMssoBranchProfile.getBranchProfileHo();

    } else if (u_loc.equalsIgnoreCase("BR")) {
        mssoBranchProfileCurrentData = this.repoMssoBranchProfile.getBranchProfileBranch(branch_code);

    } else {
        mssoBranchProfileCurrentData = this.repoMssoBranchProfile.getBranchProfileRO(region);
    }
    System.out.println("inside dep-adv-npa");


    List<String> branchProfileParameter = Arrays.asList(
            "Total Business",
            "Total Deposit",
            "Current Deposit",
            "Saving Deposit",
            "CASA Deposit",
            "Term Deposit",
            "Gross Advances",
            "Housing",
            "Vehicle",
            "Education",
            "Agriculture",
            "MSME",
            "Gold",
            "SHG",
            "Total RAM"
    );


    List<ParameterDetails> parameterDetailsList = new ArrayList<>();

    parameterDetailsList.add(new ParameterDetails(
            "Total Business",
            mssoBranchProfileActualDataDto.get(0).getTotal_business(),
            mssoBranchProfileActualDataDto.get(1).getTotal_business(),
            mssoBranchProfileActualDataDto.get(2).getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),  // gapTarget
            mssoBranchProfileActualDataDtoMarchGapPer.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(), // targetYear
            mssoBranchProfileQuarterTargetData.getTotal_business()  // targetYearSuperAchiever
    ));

    parameterDetailsList.add(new ParameterDetails(
            "Total Deposit",
            mssoBranchProfileActualDataDto.get(0).getTotal_business(),
            mssoBranchProfileActualDataDto.get(1).getTotal_business(),
            mssoBranchProfileActualDataDto.get(2).getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),  // gapTarget
            mssoBranchProfileActualDataDtoMarchGapPer.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(), // targetYear
            mssoBranchProfileQuarterTargetData.getTotal_business()  // targetYearSuperAchiever
    ));

    parameterDetailsList.add(new ParameterDetails(
            "CA",
            mssoBranchProfileActualDataDto.get(0).getTotal_business(),
            mssoBranchProfileActualDataDto.get(1).getTotal_business(),
            mssoBranchProfileActualDataDto.get(2).getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),  // gapTarget
            mssoBranchProfileActualDataDtoMarchGapPer.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(), // targetYear
            mssoBranchProfileQuarterTargetData.getTotal_business()  // targetYearSuperAchiever
    ));

    parameterDetailsList.add(new ParameterDetails(
            "SB",
            mssoBranchProfileActualDataDto.get(0).getTotal_business(),
            mssoBranchProfileActualDataDto.get(1).getTotal_business(),
            mssoBranchProfileActualDataDto.get(2).getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),  // gapTarget
            mssoBranchProfileActualDataDtoMarchGapPer.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(), // targetYear
            mssoBranchProfileQuarterTargetData.getTotal_business()  // targetYearSuperAchiever
    ));

    parameterDetailsList.add(new ParameterDetails(
            "CASA Deposit",
            mssoBranchProfileActualDataDto.get(0).getTotal_business(),
            mssoBranchProfileActualDataDto.get(1).getTotal_business(),
            mssoBranchProfileActualDataDto.get(2).getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),  // gapTarget
            mssoBranchProfileActualDataDtoMarchGapPer.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(), // targetYear
            mssoBranchProfileQuarterTargetData.getTotal_business()  // targetYearSuperAchiever
    ));

    parameterDetailsList.add(new ParameterDetails(
            "Term Deposit",
            mssoBranchProfileActualDataDto.get(0).getTotal_business(),
            mssoBranchProfileActualDataDto.get(1).getTotal_business(),
            mssoBranchProfileActualDataDto.get(2).getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),  // gapTarget
            mssoBranchProfileActualDataDtoMarchGapPer.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(), // targetYear
            mssoBranchProfileQuarterTargetData.getTotal_business()  // targetYearSuperAchiever
    ));

    parameterDetailsList.add(new ParameterDetails(
            "Gross Advances",
            mssoBranchProfileActualDataDto.get(0).getTotal_business(),
            mssoBranchProfileActualDataDto.get(1).getTotal_business(),
            mssoBranchProfileActualDataDto.get(2).getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),  // gapTarget
            mssoBranchProfileActualDataDtoMarchGapPer.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(), // targetYear
            mssoBranchProfileQuarterTargetData.getTotal_business()  // targetYearSuperAchiever
    ));

    parameterDetailsList.add(new ParameterDetails(
            "Housing",
            mssoBranchProfileActualDataDto.get(0).getTotal_business(),
            mssoBranchProfileActualDataDto.get(1).getTotal_business(),
            mssoBranchProfileActualDataDto.get(2).getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),  // gapTarget
            mssoBranchProfileActualDataDtoMarchGapPer.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(), // targetYear
            mssoBranchProfileQuarterTargetData.getTotal_business()  // targetYearSuperAchiever
    ));

    parameterDetailsList.add(new ParameterDetails(
            "Vehicle",
            mssoBranchProfileActualDataDto.get(0).getTotal_business(),
            mssoBranchProfileActualDataDto.get(1).getTotal_business(),
            mssoBranchProfileActualDataDto.get(2).getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),  // gapTarget
            mssoBranchProfileActualDataDtoMarchGapPer.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(), // targetYear
            mssoBranchProfileQuarterTargetData.getTotal_business()  // targetYearSuperAchiever
    ));

    parameterDetailsList.add(new ParameterDetails(
            "Education",
            mssoBranchProfileActualDataDto.get(0).getTotal_business(),
            mssoBranchProfileActualDataDto.get(1).getTotal_business(),
            mssoBranchProfileActualDataDto.get(2).getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),  // gapTarget
            mssoBranchProfileActualDataDtoMarchGapPer.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(), // targetYear
            mssoBranchProfileQuarterTargetData.getTotal_business()  // targetYearSuperAchiever
    ));

    parameterDetailsList.add(new ParameterDetails(
            "Agriculture",
            mssoBranchProfileActualDataDto.get(0).getTotal_business(),
            mssoBranchProfileActualDataDto.get(1).getTotal_business(),
            mssoBranchProfileActualDataDto.get(2).getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),  // gapTarget
            mssoBranchProfileActualDataDtoMarchGapPer.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(), // targetYear
            mssoBranchProfileQuarterTargetData.getTotal_business()  // targetYearSuperAchiever
    ));

    parameterDetailsList.add(new ParameterDetails(
            "MSME",
            mssoBranchProfileActualDataDto.get(0).getTotal_business(),
            mssoBranchProfileActualDataDto.get(1).getTotal_business(),
            mssoBranchProfileActualDataDto.get(2).getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),  // gapTarget
            mssoBranchProfileActualDataDtoMarchGapPer.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(), // targetYear
            mssoBranchProfileQuarterTargetData.getTotal_business()  // targetYearSuperAchiever
    ));

    parameterDetailsList.add(new ParameterDetails(
            "Gold",
            mssoBranchProfileActualDataDto.get(0).getTotal_business(),
            mssoBranchProfileActualDataDto.get(1).getTotal_business(),
            mssoBranchProfileActualDataDto.get(2).getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),  // gapTarget
            mssoBranchProfileActualDataDtoMarchGapPer.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(), // targetYear
            mssoBranchProfileQuarterTargetData.getTotal_business()  // targetYearSuperAchiever
    ));

    parameterDetailsList.add(new ParameterDetails(
            "SHG",
            mssoBranchProfileActualDataDto.get(0).getTotal_business(),
            mssoBranchProfileActualDataDto.get(1).getTotal_business(),
            mssoBranchProfileActualDataDto.get(2).getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),  // gapTarget
            mssoBranchProfileActualDataDtoMarchGapPer.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(), // targetYear
            mssoBranchProfileQuarterTargetData.getTotal_business()  // targetYearSuperAchiever
    ));

    parameterDetailsList.add(new ParameterDetails(
            "Total RAM",
            mssoBranchProfileActualDataDto.get(0).getTotal_business(),
            mssoBranchProfileActualDataDto.get(1).getTotal_business(),
            mssoBranchProfileActualDataDto.get(2).getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),  // gapTarget
            mssoBranchProfileActualDataDtoMarchGapPer.getTotal_business(),
            mssoBranchProfileQuarterTargetData.getTotal_business(), // targetYear
            mssoBranchProfileQuarterTargetData.getTotal_business()  // targetYearSuperAchiever
    ));

    for (ParameterDetails pd : parameterDetailsList) {
        System.out.println("Checking parameter: " + pd.getParameter());
    }

    System.out.println("DATA :"+parameterDetailsList.get(0).toString());




    String u_id="";
    MssoBranchEmployeeDataDto mssoBranchEmployeeDataDto=mssoBranchDataService.getMssoBranchData(branch_code,u_loc,u_id,region);
    System.out.println("SMA DATA :"+mssoBranchEmployeeDataDto);
    List<MssoBranchEmployeeDataDto> mssoBranchEmployeeDataDtoList = Collections.singletonList(mssoBranchEmployeeDataDto);

    int total_staff=mssoBranchEmployeeDataDto.getDesg_agm()+
            mssoBranchEmployeeDataDto.getDesg_cm()+
            mssoBranchEmployeeDataDto.getDesg_srmanager()+
            mssoBranchEmployeeDataDto.getDesg_manager()+mssoBranchEmployeeDataDto.getDesg_dymanager()+mssoBranchEmployeeDataDto.getDesg_clerk()+mssoBranchEmployeeDataDto.getSubstaff();

    System.out.println("TOTAL STAFF "+total_staff);


    MssoBranchProfileDigitalProductDto mssoBranchProfileDigitalProductDto = serviceaccountStatusDigitalProduct.getMssoDigitalProduct(branch_code,region,u_loc);
    MssoBranchProfileAccountStatusDto mssoBranchProfileAccountStatusDto = serviceaccountStatusDigitalProduct.getMssoAccountStatus(branch_code,region,u_loc);
    MssoAccountStatusDigitalTargetDto mssoAccountStatusDigitalTargetDto = serviceaccountStatusDigitalProduct.getMssoAccountDigitalProductTarget(branch_code,region,u_loc);
    MssoProfileComplianceDto mssoProfileReviewRenewalPending = serviceMssoBranchProfileSma.getPendingReview(branch_code,region,u_loc);
    MssoProfileComplianceDto mssoProfileTimebarred = serviceMssoBranchProfileSma.getTimebarredData(branch_code,region,u_loc);

    Map<String, Object> parameters = new HashMap<>();
            parameters.put("stressData", new JRBeanCollectionDataSource(mssoBranchProfileSmaDtoList));
    parameters.put("newLoanSanctioned", new JRBeanCollectionDataSource(mssoProfileDailyDisburseDtoList));
    parameters.put("newLoanSanctionedProductWise", new JRBeanCollectionDataSource(mssoProfileDailyDisburseDtoList));
    parameters.put("employeeData", new JRBeanCollectionDataSource(mssoBranchEmployeeDataDtoList));

    parameters.put("region",mssoBranchEmployeeDataDto.getRegion());
    parameters.put("branchName",mssoBranchEmployeeDataDto.getBranch_name());
    parameters.put("branchCode",mssoBranchEmployeeDataDto.getBranch_code());
    parameters.put("branchOrRegionHead",mssoBranchEmployeeDataDto.getEmployee_name());
    parameters.put("grade",mssoBranchEmployeeDataDto.getGrade_code());
//    parameters.put("region",mssoBranchEmployeeDataDto.getRegion());


    parameters.put("quarter",total_staff);
    parameters.put("quarter",total_staff);

    parameters.put("total_staff",total_staff);
//    parameters.put("timebarredAmount",total_staff);
//    parameters.put("timebarredCount",total_staff);
    parameters.put("reviewRenewalCount",pendingReviewRenewal.getTotal_count());
    parameters.put("reviewRenewalAmount",pendingReviewRenewal.getTotal_amount());
    parameters.put("reviewRenewalAmount",pendingReviewRenewal.getTotal_amount());
    parameters.put("paramterDetails", new JRBeanCollectionDataSource(parameterDetailsList));


    parameters.put("naccReviewRenewalCount",pendingReviewRenewal.getTotal_count());
    parameters.put("naccReviewRenewalAmount",pendingReviewRenewal.getTotal_amount());
    parameters.put("timebarredCount",mssoProfileTimebarred.getTotal_count());
    parameters.put("timebarredAmount",mssoProfileTimebarred.getTotal_amount());
    parameters.put("kccReviewRenewalCount",pendingReviewRenewal.getTotal_count());
    parameters.put("kccReviewRenewalAmount",pendingReviewRenewal.getTotal_amount());
    parameters.put("pendingMultipleCif",mssoBranchProfileDigitalProductDto.getMultiple_cif());
    parameters.put("pendingCkyc",mssoBranchProfileDigitalProductDto.getCkyc());
    parameters.put("inoperativeCasaCount",mssoBranchProfileAccountStatusDto.getCasa_count());
    parameters.put("inoperativeCasaAmount",mssoBranchProfileAccountStatusDto.getCasa_amount());


    parameters.put("quarterTargetSB",mssoAccountStatusDigitalTargetDto.getSb_ac_count());
    parameters.put("asOnDateSB",mssoBranchProfileAccountStatusDto.getSb_ac_count());
    parameters.put("AsOnMarchSB",mssoBranchProfileAccountStatusDto.getSb_ac_count());
    parameters.put("quarterTargetCa",mssoAccountStatusDigitalTargetDto.getCa_ac_count());
    parameters.put("asonDateCa",mssoBranchProfileAccountStatusDto.getCa_ac_count());
    parameters.put("asOnMarchCa",mssoBranchProfileAccountStatusDto.getSb_ac_count());
    parameters.put("asonDateDebitCard",mssoBranchProfileDigitalProductDto.getAtm_card());
    parameters.put("asonDateMobileBanking",mssoBranchProfileDigitalProductDto.getMobile_banking());
    parameters.put("asonDateInternetBanking",mssoBranchProfileDigitalProductDto.getinternet_banking());
    parameters.put("quarterTargetDebitCard",mssoAccountStatusDigitalTargetDto.getAtm_card());
    parameters.put("quarterTargetMobileBanking",mssoAccountStatusDigitalTargetDto.getMobile_banking());
    parameters.put("quarterTargetInternetBanking",mssoAccountStatusDigitalTargetDto.getinternet_banking());


    parameters.put("quarter",total_staff);
    parameters.put("todayDate",total_staff);
    parameters.put("financialYear",total_staff);




    //******************************** FILL THE MAIN REPORT ***********************************************************8
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            //******************************** Export to PDF ********************************************************************
            byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=AppraisalNote" + branch_code + ".pdf");

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
