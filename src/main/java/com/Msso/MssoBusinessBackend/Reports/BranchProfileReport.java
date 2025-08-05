package com.Msso.MssoBusinessBackend.Reports;

import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.ExecutiveVisitingData;
import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.VisitDataStaffCompliance;
import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.*;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileDisbursement.MssoProfileDailyDisburseDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileTargetDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoAccountStatusDigitalTargetDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileAccountStatusDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileDigitalProductDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoFiSchemeDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileComplianceDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileReviewRenewalDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.*;
import com.Msso.MssoBusinessBackend.Model.ParameterDetails;
import com.Msso.MssoBusinessBackend.Model.ParameterDetailsVisit;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchEmployeeData.RepoMssoBranchEmployeData;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchProfile.RepoMssoBranchProfileActualData;
import com.Msso.MssoBusinessBackend.Service.ServiceMssoBranchData.MssoBranchDataService;
import com.Msso.MssoBusinessBackend.Services.ServiceMssoBranchProfile.*;
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
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
    @Autowired
    RepoMssoBranchEmployeData repoEmployeData;
    @Autowired
    ServiceVisitReportGetData serviceVisitReport;

    public ResponseEntity<ByteArrayResource> exportBranchProfileReport(String branch_code,  String region, String u_loc) throws JRException {

        try {
            //********************************************** Load main JRXML file ************************************************************************************

            //***************************************************************************************************************************************************************

            InputStream templateStream;
//            templateStream = getClass().getResourceAsStream("/REPORTS/ReportDownload.jrxml");
//            templateStream = getClass().getResourceAsStream("/REPORTS/ReportDownloadInprocess.jrxml");
            templateStream = getClass().getResourceAsStream("/REPORTS/ReportDownloadInprocess2.jrxml");

            JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);


            //*********************************************** Main JRXML parameter mapping ***************************************************************************
            MssoBranchProfileSmaDto mssoBranchProfileSmaDto = serviceMssoBranchProfileSma.getMssoDailySma(branch_code, region, u_loc);
            System.out.println("mssoBranchProfileSmaDto :" + mssoBranchProfileSmaDto);
            List<MssoBranchProfileSmaDto> mssoBranchProfileSmaDtoList = Collections.singletonList(mssoBranchProfileSmaDto);
            MssoProfileReviewRenewalDto pendingReviewRenewal = serviceMssoBranchProfileSma.getPendingReview(branch_code, region, u_loc);
            System.out.println("pendingReviewRenewal :" + pendingReviewRenewal.getTotal_amount() + pendingReviewRenewal.getTotal_count());
            MssoProfileDailyDisburseDto mssoProfileDailyDisburseDto = serviceMssoDailyDisbursement.getMssoDailyDisbursement(branch_code, region, u_loc);
            System.out.println("mssoProfileDailyDisburseDto DATA :" + mssoProfileDailyDisburseDto);
            List<MssoProfileDailyDisburseDto> mssoProfileDailyDisburseDtoList = Collections.singletonList(mssoProfileDailyDisburseDto);
            MssoProfileDailyDisburseDto mssoProfileDailyDisburseTargetDto = serviceMssoDailyDisbursement.getMssoDisbursementTarget(branch_code, region, u_loc);
            System.out.println("mssoProfileDailyDisburseTargetDto DATA :" + mssoProfileDailyDisburseTargetDto);
            List<MssoProfileDailyDisburseDto> mssoProfileDailyDisburseTargetList = Collections.singletonList(mssoProfileDailyDisburseTargetDto);

            Boolean isHeadName;
            isHeadName = !u_loc.equalsIgnoreCase("HO");
            Boolean isHoRoEmployeeSummary;
            isHoRoEmployeeSummary = !u_loc.equalsIgnoreCase("BR");

            // 3 years
            List<MssoBranchProfileActualDataDto> mssoBranchProfileActualDataDto = serviceBranchProfileLast3Year.getMssoBranchProfileMarchData(branch_code, region, u_loc);
            System.out.println("mssoBranchProfileActualDataDto DATA :" + mssoBranchProfileActualDataDto.get(0));

            //march
            MssoBranchProfileActualDataDto mssoBranchProfileActualDataDtoMarchGap = serviceBranchProfileLast3Year.getMssoBranchProfileGapMarch(branch_code, region, u_loc);
            System.out.println("mssoBranchProfileActualDataDtoMarchGap DATA :" + mssoProfileDailyDisburseDto);
            MssoBranchProfileTargetDataDto mssoBranchProfileQuarterTargetData = serviceMssoBranchProfileTargetData.getMssoBranchProfileTargetData(branch_code, region, u_loc);
            System.out.println("mssoBranchProfileQuarterTargetData DATA :" + mssoBranchProfileQuarterTargetData);
            MssoBranchProfileTargetDataDto mssoBranchProfileQuarterTargetGap = serviceMssoBranchProfileTargetData.getMssoBranchProfileGapQuarter(branch_code, region, u_loc);
            String branchCategory = mssoBranchDataService.getBranchCategory(branch_code, u_loc, region);
            BranchCategoryDto branchCategoryDto = mssoBranchDataService.getBranchCategoryCount(branch_code, u_loc, region);

            MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataSuperAchieverMarch = serviceMssoBranchProfileTargetData.getSuperAchieverMarch(branch_code, region, u_loc);

            MssoBranchProfileTargetDataDto mssoBranchProfileMarchTargetData = serviceMssoBranchProfileTargetData.getMssoTargetMarch(branch_code, region, u_loc);
            MssoBranchProfileActualDataDto mssoBranchProfileActualDataDtoMarchGapPer = serviceBranchProfileLast3Year.getMssoBranchProfileGapMarchPercentage(branch_code, region, u_loc);
            MssoBranchProfileActualDataDto mssoBranchProfileCurrentData = null;
            String category;
            String designation = "";
            String desig = "";
            System.out.println("inside dep-adv-npa");
            BranchCategoryDto branchCategoryDto1;

            if (u_loc.equalsIgnoreCase("HO")) {
                mssoBranchProfileCurrentData = this.repoMssoBranchProfile.getBranchProfileHo();
                branchCategoryDto1 = this.repoEmployeData.getBCCountHO();

                category = "HO Staff";

            } else if (u_loc.equalsIgnoreCase("BR")) {
                mssoBranchProfileCurrentData = this.repoMssoBranchProfile.getBranchProfileBranch(branch_code);
                branchCategoryDto1 = this.repoEmployeData.getBCCountBranch(branch_code);

                category = "Branch Staff";
                designation="Branch";
                desig="BM";


            } else {
                mssoBranchProfileCurrentData = this.repoMssoBranchProfile.getBranchProfileRO(region);
                branchCategoryDto1 = this.repoEmployeData.getBCCountRo(region);

                category = "RO Staff";
                designation="Regional";
                desig="RM";

            }


//            if (u_loc.equalsIgnoreCase("HO")) {
//                branchCategoryDto1 = this.repoEmployeData.getBCCountHO();
//                System.out.println("getBCCountHO");
//
//            } else if (u_loc.equalsIgnoreCase("RO")) {
//                branchCategoryDto1 = this.repoEmployeData.getBCCountRo(region);
//                System.out.println("branchCategoryDto" + branchCategoryDto);
//
//            } else if (u_loc.equalsIgnoreCase("BR")) {
//                branchCategoryDto1 = this.repoEmployeData.getBCCountBranch(branch_code);
//            }

            Boolean isBcCount;
            Boolean isPerEmployeeBusiness;
            String amountIn;

            if (u_loc.equalsIgnoreCase("HO")||u_loc.equalsIgnoreCase("RO")) {
                isBcCount = false;
                isPerEmployeeBusiness=false;
                amountIn="Crore";
            } else {
                isBcCount = true;
                isPerEmployeeBusiness=true;
                amountIn="Lakh";

            }

//
//            List<String> branchProfileParameter = Arrays.asList(
//                    "Total Business",
//                    "Total Deposit",
//                    "Current Deposit",
//                    "Saving Deposit",
//                    "CASA Deposit",
//                    "Term Deposit",
//                    "Gross Advances",
//                    "Housing",
//                    "Vehicle",
//                    "Education",
//                    "Agriculture",
//                    "MSME",
//                    "Gold",
//                    "SHG",
//                    "Total RAM"
//            );


            List<ParameterDetails> parameterDetailsList = new ArrayList<>();

            parameterDetailsList.add(new ParameterDetails(
                    "Total Business",
                    mssoBranchProfileActualDataDto.get(0).getTotal_business(),
                    mssoBranchProfileActualDataDto.get(1).getTotal_business(),
                    mssoBranchProfileActualDataDto.get(2).getTotal_business(),
                    mssoBranchProfileCurrentData.getTotal_business(),
                    mssoBranchProfileQuarterTargetData.getTotal_business(),
                    mssoBranchProfileQuarterTargetGap.getTotal_business(),
                    mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),  // gapTarget
                    mssoBranchProfileActualDataDtoMarchGapPer.getTotal_business(),
                    mssoBranchProfileMarchTargetData.getTotal_business(), // targetYear
                    mssoBranchProfileTargetDataSuperAchieverMarch.getTotal_business()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Total Deposit",
                    mssoBranchProfileActualDataDto.get(0).getDeposit(),
                    mssoBranchProfileActualDataDto.get(1).getDeposit(),
                    mssoBranchProfileActualDataDto.get(2).getDeposit(),
                    mssoBranchProfileCurrentData.getDeposit(),
                    mssoBranchProfileQuarterTargetData.getDeposit(),
                    mssoBranchProfileQuarterTargetGap.getDeposit(),
                    mssoBranchProfileActualDataDtoMarchGap.getDeposit(),  // gapTarget
                    mssoBranchProfileActualDataDtoMarchGapPer.getDeposit(),
                    mssoBranchProfileMarchTargetData.getDeposit(), // targetYear
                    mssoBranchProfileTargetDataSuperAchieverMarch.getDeposit()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "CA",
                    mssoBranchProfileActualDataDto.get(0).getCa(),
                    mssoBranchProfileActualDataDto.get(1).getCa(),
                    mssoBranchProfileActualDataDto.get(2).getCa(),
                    mssoBranchProfileCurrentData.getCa(),
                    mssoBranchProfileQuarterTargetData.getCa(),
                    mssoBranchProfileQuarterTargetGap.getCa(),
                    mssoBranchProfileActualDataDtoMarchGap.getCa(),  // gapTarget
                    mssoBranchProfileActualDataDtoMarchGapPer.getCa(),
                    mssoBranchProfileMarchTargetData.getCa(), // targetYear
                    mssoBranchProfileTargetDataSuperAchieverMarch.getCa()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "SB",
                    mssoBranchProfileActualDataDto.get(0).getSb(),
                    mssoBranchProfileActualDataDto.get(1).getSb(),
                    mssoBranchProfileActualDataDto.get(2).getSb(),
                    mssoBranchProfileCurrentData.getSb(),
                    mssoBranchProfileQuarterTargetData.getSb(),
                    mssoBranchProfileQuarterTargetGap.getSb(),
                    mssoBranchProfileActualDataDtoMarchGap.getSb(),  // gapTarget
                    mssoBranchProfileActualDataDtoMarchGapPer.getSb(),
                    mssoBranchProfileMarchTargetData.getSb(), // targetYear
                    mssoBranchProfileTargetDataSuperAchieverMarch.getSb()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "CASA Deposit",
                    mssoBranchProfileActualDataDto.get(0).getCasa(),
                    mssoBranchProfileActualDataDto.get(1).getCasa(),
                    mssoBranchProfileActualDataDto.get(2).getCasa(),
                    mssoBranchProfileCurrentData.getCasa(),
                    mssoBranchProfileQuarterTargetData.getCasa(),
                    mssoBranchProfileQuarterTargetGap.getCasa(),
                    mssoBranchProfileActualDataDtoMarchGap.getCasa(),  // gapTarget
                    mssoBranchProfileActualDataDtoMarchGapPer.getCasa(),
                    mssoBranchProfileMarchTargetData.getCasa(), // targetYear
                    mssoBranchProfileTargetDataSuperAchieverMarch.getCasa()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Term Deposit",
                    mssoBranchProfileActualDataDto.get(0).getTd(),
                    mssoBranchProfileActualDataDto.get(1).getTd(),
                    mssoBranchProfileActualDataDto.get(2).getTd(),
                    mssoBranchProfileCurrentData.getTd(),
                    mssoBranchProfileQuarterTargetData.getTd(),
                    mssoBranchProfileQuarterTargetGap.getTd(),
                    mssoBranchProfileActualDataDtoMarchGap.getTd(),  // gapTarget
                    mssoBranchProfileActualDataDtoMarchGapPer.getTd(),
                    mssoBranchProfileMarchTargetData.getTd(), // targetYear
                    mssoBranchProfileTargetDataSuperAchieverMarch.getTd()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Gross Advances",
                    mssoBranchProfileActualDataDto.get(0).getAdvances(),
                    mssoBranchProfileActualDataDto.get(1).getAdvances(),
                    mssoBranchProfileActualDataDto.get(2).getAdvances(),
                    mssoBranchProfileCurrentData.getAdvances(),
                    mssoBranchProfileQuarterTargetData.getAdvances(),
                    mssoBranchProfileQuarterTargetGap.getAdvances(),
                    mssoBranchProfileActualDataDtoMarchGap.getAdvances(),  // gapTarget
                    mssoBranchProfileActualDataDtoMarchGapPer.getAdvances(),
                    mssoBranchProfileMarchTargetData.getAdvances(), // targetYear
                    mssoBranchProfileTargetDataSuperAchieverMarch.getAdvances()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Retail",
                    mssoBranchProfileActualDataDto.get(0).getTotal_retail(),
                    mssoBranchProfileActualDataDto.get(1).getTotal_retail(),
                    mssoBranchProfileActualDataDto.get(2).getTotal_retail(),
                    mssoBranchProfileCurrentData.getTotal_retail(),
                    mssoBranchProfileQuarterTargetData.getTotal_retail(),
                    mssoBranchProfileQuarterTargetGap.getTotal_retail(),
                    mssoBranchProfileActualDataDtoMarchGap.getTotal_retail(),  // gapTarget
                    mssoBranchProfileActualDataDtoMarchGapPer.getTotal_retail(),
                    mssoBranchProfileMarchTargetData.getTotal_retail(), // targetYear
                    mssoBranchProfileTargetDataSuperAchieverMarch.getTotal_retail()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Housing",
                    mssoBranchProfileActualDataDto.get(0).getHousing(),
                    mssoBranchProfileActualDataDto.get(1).getHousing(),
                    mssoBranchProfileActualDataDto.get(2).getHousing(),
                    mssoBranchProfileCurrentData.getHousing(),
                    mssoBranchProfileQuarterTargetData.getHousing(),
                    mssoBranchProfileQuarterTargetGap.getHousing(),
                    mssoBranchProfileActualDataDtoMarchGap.getHousing(),  // gapTarget
                    mssoBranchProfileActualDataDtoMarchGapPer.getHousing(),
                    mssoBranchProfileMarchTargetData.getHousing(), // targetYear
                    mssoBranchProfileTargetDataSuperAchieverMarch.getHousing()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Vehicle",
                    mssoBranchProfileActualDataDto.get(0).getVehicle(),
                    mssoBranchProfileActualDataDto.get(1).getVehicle(),
                    mssoBranchProfileActualDataDto.get(2).getVehicle(),
                    mssoBranchProfileCurrentData.getVehicle(),
                    mssoBranchProfileQuarterTargetData.getVehicle(),
                    mssoBranchProfileQuarterTargetGap.getVehicle(),
                    mssoBranchProfileActualDataDtoMarchGap.getVehicle(),  // gapTarget
                    mssoBranchProfileActualDataDtoMarchGapPer.getVehicle(),
                    mssoBranchProfileMarchTargetData.getVehicle(), // targetYear
                    mssoBranchProfileTargetDataSuperAchieverMarch.getVehicle()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Education",
                    mssoBranchProfileActualDataDto.get(0).getEducation(),
                    mssoBranchProfileActualDataDto.get(1).getEducation(),
                    mssoBranchProfileActualDataDto.get(2).getEducation(),
                    mssoBranchProfileCurrentData.getEducation(),
                    mssoBranchProfileQuarterTargetData.getEducation(),
                    mssoBranchProfileQuarterTargetGap.getEducation(),
                    mssoBranchProfileActualDataDtoMarchGap.getEducation(),  // gapTarget
                    mssoBranchProfileActualDataDtoMarchGapPer.getEducation(),
                    mssoBranchProfileMarchTargetData.getEducation(), // targetYear
                    mssoBranchProfileTargetDataSuperAchieverMarch.getEducation()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Agriculture",
                    mssoBranchProfileActualDataDto.get(0).getAgri(),
                    mssoBranchProfileActualDataDto.get(1).getAgri(),
                    mssoBranchProfileActualDataDto.get(2).getAgri(),
                    mssoBranchProfileCurrentData.getAgri(),
                    mssoBranchProfileQuarterTargetData.getAgri(),
                    mssoBranchProfileQuarterTargetGap.getAgri(),
                    mssoBranchProfileActualDataDtoMarchGap.getAgri(),  // gapTarget
                    mssoBranchProfileActualDataDtoMarchGapPer.getAgri(),
                    mssoBranchProfileMarchTargetData.getAgri(), // targetYear
                    mssoBranchProfileTargetDataSuperAchieverMarch.getAgri()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "MSME",
                    mssoBranchProfileActualDataDto.get(0).getMsme(),
                    mssoBranchProfileActualDataDto.get(1).getMsme(),
                    mssoBranchProfileActualDataDto.get(2).getMsme(),
                    mssoBranchProfileCurrentData.getMsme(),
                    mssoBranchProfileQuarterTargetData.getMsme(),
                    mssoBranchProfileQuarterTargetGap.getMsme(),
                    mssoBranchProfileActualDataDtoMarchGap.getMsme(),  // gapTarget
                    mssoBranchProfileActualDataDtoMarchGapPer.getMsme(),
                    mssoBranchProfileMarchTargetData.getMsme(), // targetYear
                    mssoBranchProfileTargetDataSuperAchieverMarch.getMsme()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Gold",
                    mssoBranchProfileActualDataDto.get(0).getGold(),
                    mssoBranchProfileActualDataDto.get(1).getGold(),
                    mssoBranchProfileActualDataDto.get(2).getGold(),
                    mssoBranchProfileCurrentData.getGold(),
                    mssoBranchProfileQuarterTargetData.getGold(),
                    mssoBranchProfileQuarterTargetGap.getGold(),
                    mssoBranchProfileActualDataDtoMarchGap.getGold(),  // gapTarget
                    mssoBranchProfileActualDataDtoMarchGapPer.getGold(),
                    mssoBranchProfileMarchTargetData.getGold(), // targetYear
                    mssoBranchProfileTargetDataSuperAchieverMarch.getGold()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "SHG",
                    mssoBranchProfileActualDataDto.get(0).getShg(),
                    mssoBranchProfileActualDataDto.get(1).getShg(),
                    mssoBranchProfileActualDataDto.get(2).getShg(),
                    mssoBranchProfileCurrentData.getShg(),
                    mssoBranchProfileQuarterTargetData.getShg(),
                    mssoBranchProfileQuarterTargetGap.getShg(),
                    mssoBranchProfileActualDataDtoMarchGap.getShg(),  // gapTarget
                    mssoBranchProfileActualDataDtoMarchGapPer.getShg(),
                    mssoBranchProfileMarchTargetData.getShg(), // targetYear
                    mssoBranchProfileTargetDataSuperAchieverMarch.getShg()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Total RAM",
                    mssoBranchProfileActualDataDto.get(0).getTotal_ram(),
                    mssoBranchProfileActualDataDto.get(1).getTotal_ram(),
                    mssoBranchProfileActualDataDto.get(2).getTotal_ram(),
                    mssoBranchProfileCurrentData.getTotal_ram(),
                    mssoBranchProfileQuarterTargetData.getTotal_ram(),
                    mssoBranchProfileQuarterTargetGap.getTotal_ram(),
                    mssoBranchProfileActualDataDtoMarchGap.getTotal_ram(),  // gapTarget
                    mssoBranchProfileActualDataDtoMarchGapPer.getTotal_ram(),
                    mssoBranchProfileMarchTargetData.getTotal_ram(), // targetYear
                    mssoBranchProfileTargetDataSuperAchieverMarch.getTotal_ram()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "NPA",
                    mssoBranchProfileActualDataDto.get(0).getNpa(),
                    mssoBranchProfileActualDataDto.get(1).getNpa(),
                    mssoBranchProfileActualDataDto.get(2).getNpa(),
                    mssoBranchProfileCurrentData.getNpa(),
                    mssoBranchProfileQuarterTargetData.getNpa(),
                    mssoBranchProfileQuarterTargetGap.getNpa(),
                    mssoBranchProfileActualDataDtoMarchGap.getNpa(),  // gapTarget
                    mssoBranchProfileActualDataDtoMarchGapPer.getNpa(),
                    mssoBranchProfileMarchTargetData.getNpa(), // targetYear
                    mssoBranchProfileTargetDataSuperAchieverMarch.getNpa()  // targetYearSuperAchiever
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


            MssoEmployeeSummaryDto mssoEmployeeSummaryDto = (mssoBranchDataService.getMssoRegionEmployeeSummary(branch_code,u_loc, region));
            List<MssoEmployeeSummaryDto> mssoEmployeeSummaryDtoList = Collections.singletonList(mssoEmployeeSummaryDto);
            int branch_total_staff = 0;

            if (u_loc.equalsIgnoreCase("HO") || u_loc.equalsIgnoreCase("RO")) {
                branch_total_staff = mssoEmployeeSummaryDto.getDesg_agm()
                        + mssoEmployeeSummaryDto.getDesg_cm()
                        + mssoEmployeeSummaryDto.getDesg_srmanager()
                        + mssoEmployeeSummaryDto.getDesg_manager()
                        + mssoEmployeeSummaryDto.getDesg_dymanager()
                        + mssoEmployeeSummaryDto.getDesg_clerk()
                        + mssoEmployeeSummaryDto.getSubstaff();
            }

            long safeBranchTotal = branch_total_staff != 0 ? branch_total_staff : 0L;
            System.out.println("safeBranchTotal "+safeBranchTotal);

            BigDecimal total_bank_staff = BigDecimal.valueOf(safeBranchTotal);



            MssoBranchProfileDigitalProductDto mssoBranchProfileDigitalProductDto = serviceaccountStatusDigitalProduct.getMssoDigitalProduct(branch_code,region,u_loc);
            MssoBranchProfileAccountStatusDto mssoBranchProfileAccountStatusDto = serviceaccountStatusDigitalProduct.getMssoAccountStatus(branch_code,region,u_loc);
            MssoAccountStatusDigitalTargetDto mssoAccountStatusDigitalTargetDto = serviceaccountStatusDigitalProduct.getMssoAccountDigitalProductTarget(branch_code,region,u_loc);
            MssoProfileComplianceDto mssoProfileTimebarred = serviceMssoBranchProfileSma.getTimebarredData(branch_code,region,u_loc);

            System.out.println("mssoBranchProfileCurrentData.getTotal_business() "+mssoBranchProfileCurrentData.getTotal_business());
            System.out.println("total_bank_staff "+total_bank_staff);

            if(u_loc.equalsIgnoreCase("BR")){
                total_bank_staff= BigDecimal.valueOf(total_staff);
            }

            BigDecimal perEmployeeBusiness=mssoBranchProfileCurrentData.getTotal_business().divide(total_bank_staff, 2, RoundingMode.HALF_UP);


            MssoBranchProfileAccountStatusDto mssoBranchProfileAccountStatusMarch = serviceaccountStatusDigitalProduct.getMssoAccountStatusMarch(branch_code,region,u_loc);
            MssoProfileNpaClassificationDto mssoNpaClassification = serviceMssoBranchProfileSma.getMssoNpaClassification(branch_code,region,u_loc);
            List<MssoProfileNpaClassificationDto> mssoNpaClassificationList = Collections.singletonList(mssoNpaClassification);
            BranchOpeningDateDto branchOpeningDateDto = mssoBranchDataService.getBranchOpenDate(branch_code,region,u_loc);

            BmBranchJoinDateDto bmBranchJoinDateDto = mssoBranchDataService.getBmBranchJoinDate(branch_code,mssoBranchEmployeeDataDto.getU_id());

            MssoFiSchemeDto mssoFiSchemeDto = serviceaccountStatusDigitalProduct.getFiSchemeData(branch_code,region,u_loc);
            MssoFiSchemeDto mssoFiSchemeDtoTarget = serviceaccountStatusDigitalProduct.getMssoFiSchemeTarget(branch_code,region,u_loc);
            System.out.println("mssoFiSchemeDtoTarget --- "+mssoFiSchemeDtoTarget);
            SectorwiseNpaDto sectorwiseNpaDto = serviceMssoBranchProfileSma.getNpaSectorwise(branch_code,region,u_loc);
            List<SectorwiseNpaDto> sectorwiseNpaList = Collections.singletonList(sectorwiseNpaDto);
            AmountwiseNpaDto amountwiseNpaDto = serviceMssoBranchProfileSma.getNpaAmountwise(branch_code,region,u_loc);
            List<AmountwiseNpaDto> amountwiseNpaList = Collections.singletonList(amountwiseNpaDto);
            NpaRecoveryProgressDto npaRecoveryProgressDto = serviceMssoBranchProfileSma.getNpaRegularProgress(branch_code,region,u_loc);
            NpaRecoveryProgressDto npaRecoveryProgressMarchDto = serviceMssoBranchProfileSma.getNpaMarchProgress(branch_code,region,u_loc);



            Map<String, Object> parameters = new HashMap<>();

//*********************************************** TABLE MAPPING **********************************************************************************

            parameters.put("employeeData", new JRBeanCollectionDataSource(mssoBranchEmployeeDataDtoList));
            parameters.put("employeeDataSummary", new JRBeanCollectionDataSource(mssoEmployeeSummaryDtoList));
            parameters.put("paramterDetails", new JRBeanCollectionDataSource(parameterDetailsList));
            parameters.put("newLoanSanctioned", new JRBeanCollectionDataSource(mssoProfileDailyDisburseDtoList));
            parameters.put("newLoanSanctionedTarget", new JRBeanCollectionDataSource(mssoProfileDailyDisburseTargetList));
            parameters.put("newLoanSanctionedProductWise", new JRBeanCollectionDataSource(mssoProfileDailyDisburseDtoList));
            parameters.put("newLoanSanctionedProductWiseTarget", new JRBeanCollectionDataSource(mssoProfileDailyDisburseTargetList));
            parameters.put("stressData", new JRBeanCollectionDataSource(mssoBranchProfileSmaDtoList));
            parameters.put("npaClassification", new JRBeanCollectionDataSource( mssoNpaClassificationList));
            parameters.put("sectorwiseNpa", new JRBeanCollectionDataSource( sectorwiseNpaList));
            parameters.put("amountwiseNpa", new JRBeanCollectionDataSource( amountwiseNpaList));

            parameters.put("perEmployeeBusiness",perEmployeeBusiness);
            if(mssoBranchEmployeeDataDto.getBranch_code().equalsIgnoreCase("4000")) {
                parameters.put("region", "Head Office");
                parameters.put("branchName","-");

            }else{

                if(mssoBranchEmployeeDataDto.getRegion().equalsIgnoreCase("AURANGABAD")){
                    parameters.put("region", "Chht. Sambhaji Nagar");
                }else {
                    parameters.put("region", mssoBranchEmployeeDataDto.getRegion()!=null?mssoBranchEmployeeDataDto.getRegion():"-");
                }
                parameters.put("branchName",mssoBranchEmployeeDataDto.getBranch_name()!=null?mssoBranchEmployeeDataDto.getBranch_name():"-");

            }

            parameters.put("branchCode",mssoBranchEmployeeDataDto.getBranch_code());
            String branchOpenDate=dateConverter(branchOpeningDateDto.getBranchopendate());
            String bmBranchJoinDate="";

            if(bmBranchJoinDateDto!=null) {
                bmBranchJoinDate = dateConverter(bmBranchJoinDateDto.getBmBranchJoinDate());
            }
            parameters.put("sinceDate", branchOpenDate!=null?branchOpenDate:"");
            parameters.put("bmBranchJoinDate", bmBranchJoinDate!=null?bmBranchJoinDate:"");
            parameters.put("designation", designation!=null?designation:"");
            parameters.put("design", desig!=null?desig:"");
            parameters.put("bcCount",branchCategoryDto1.getTotalCount());
            parameters.put("branchOrRegionHead",mssoBranchEmployeeDataDto.getEmployee_name());
            parameters.put("grade",mssoBranchEmployeeDataDto.getGrade_code());
            parameters.put("isHeadName",isHeadName);
            parameters.put("isBcCount",isBcCount);
            parameters.put("isPerEmployeeBusiness",isPerEmployeeBusiness);
            parameters.put("isHoRoEmployeeSummary",isHoRoEmployeeSummary);
            parameters.put("branchCategory",branchCategory);
            parameters.put("amountIn",amountIn);
//            System.out.println(" dateConverter(year3.getReportDate()) "+dateConverter(year3.getReportDate()));
//            parameters.put("totalAson",dateConverter(year3.getReportDate()));

            if(u_loc.equalsIgnoreCase("HO")||u_loc.equalsIgnoreCase("RO")) {

                parameters.put("totalBranch", branchCategoryDto.getTotalCount()!=null?branchCategoryDto.getTotalCount():0);
                parameters.put("urban", branchCategoryDto.getUrban()!=null?branchCategoryDto.getUrban():0);
                parameters.put("semiUrban", branchCategoryDto.getSemiUrban()!=null?branchCategoryDto.getSemiUrban():0);
                parameters.put("metro", branchCategoryDto.getMetropolitan()!=null?branchCategoryDto.getMetropolitan():0);
                parameters.put("rural", branchCategoryDto.getRural()!=null?branchCategoryDto.getRural():0);
            }

            String current_report_date=dateConverter(mssoBranchProfileCurrentData.getReport_date());
            parameters.put("current_report_date",current_report_date);

            String npa_report_date=dateConverter(mssoNpaClassification.getReport_date());
            parameters.put("npa_report_date",npa_report_date);

            System.out.println("current_report_date"+mssoBranchProfileSmaDto.getReport_date());
            String sma_report_date=dateConverter(mssoBranchProfileSmaDto.getReport_date());

            parameters.put("sma_report_date",sma_report_date);
            parameters.put("total_staff",total_staff);
            parameters.put("total_staff_bank",branch_total_staff);
            parameters.put("category",category);

//************************************************** NPA PROGRESS **************************************************************
            parameters.put("recovered_os_amt",npaRecoveryProgressDto.getRecovered_os_amt()!=null?npaRecoveryProgressDto.getRecovered_os_amt(): 0L);
            parameters.put("recovered_os_amt_march",npaRecoveryProgressMarchDto.getRecovered_os_amt()!=null?npaRecoveryProgressMarchDto.getRecovered_os_amt(): 0L);
            parameters.put("upgrade_os_amt",npaRecoveryProgressDto.getUpgrade_os_amt()!=null?npaRecoveryProgressDto.getUpgrade_os_amt(): 0L);
            parameters.put("upgrade_os_amt_march",npaRecoveryProgressMarchDto.getUpgrade_os_amt()!=null?npaRecoveryProgressMarchDto.getUpgrade_os_amt(): 0L);
            parameters.put("addition_os_amt",npaRecoveryProgressDto.getAddition_os_amt()!=null?npaRecoveryProgressDto.getAddition_os_amt(): 0L);
            parameters.put("addition_os_amt_march",npaRecoveryProgressMarchDto.getAddition_os_amt()!=null?npaRecoveryProgressMarchDto.getAddition_os_amt(): 0L);


//************************************************** COMPLIANCES **************************************************************

            parameters.put("naccReviewRenewalCount",pendingReviewRenewal.getNacc_count()!=null?pendingReviewRenewal.getNacc_count(): 0L);
            parameters.put("naccReviewRenewalAmount",pendingReviewRenewal.getNacc_amount() !=null?pendingReviewRenewal.getNacc_amount(): BigDecimal.ZERO);
            parameters.put("timebarredCount", mssoProfileTimebarred != null && mssoProfileTimebarred.getTotal_count() != null ? mssoProfileTimebarred.getTotal_count() : 0);
            parameters.put("timebarredAmount",mssoProfileTimebarred != null && mssoProfileTimebarred.getTotal_amount()!=null  ? mssoProfileTimebarred.getTotal_amount() : BigDecimal.ZERO);
            parameters.put("kccReviewRenewalCount",pendingReviewRenewal.getTotal_count()!=null?pendingReviewRenewal.getTotal_count(): 0L);
            parameters.put("kccReviewRenewalAmount",pendingReviewRenewal.getTotal_amount()!=null?pendingReviewRenewal.getTotal_amount(): BigDecimal.ZERO);
            parameters.put("pendingMultipleCif",mssoBranchProfileDigitalProductDto != null && mssoBranchProfileDigitalProductDto.getMultiple_cif()!=null?mssoBranchProfileDigitalProductDto.getMultiple_cif(): 0L);
            parameters.put("pendingCkyc",mssoBranchProfileDigitalProductDto != null && mssoBranchProfileDigitalProductDto.getCkyc()!=null?mssoBranchProfileDigitalProductDto.getCkyc(): 0L);
            parameters.put("inoperativeCasaCount",mssoBranchProfileAccountStatusDto != null &&  mssoBranchProfileAccountStatusDto.getCasa_count()!=null?mssoBranchProfileAccountStatusDto.getCasa_count(): 0L);
            parameters.put("inoperativeCasaAmount",mssoBranchProfileAccountStatusDto != null && mssoBranchProfileAccountStatusDto.getCasa_amount()!=null?mssoBranchProfileAccountStatusDto.getCasa_amount(): BigDecimal.ZERO);
//            if(u_loc.equalsIgnoreCase("HO")) {
//                parameters.put("pendingMultipleCif", mssoBranchProfileDigitalProductDto.getMultiple_cif()!=null?mssoBranchProfileDigitalProductDto.getMultiple_cif(): 0L);
//            }else{
            //parameters.put("pendingMultipleCif",mssoBranchProfileDigitalProductDto.getMultiple_cif()!=null?mssoBranchProfileDigitalProductDto.getMultiple_cif(): 0L);

            // }
//************************************************** Accounts Status and Digital Products details **************************************************************

            parameters.put("quarterTargetSB",mssoAccountStatusDigitalTargetDto!=null && mssoAccountStatusDigitalTargetDto.getSb_ac_count()!=null?mssoAccountStatusDigitalTargetDto.getSb_ac_count():0L);
            parameters.put("asOnDateSB",mssoBranchProfileAccountStatusDto!=null && mssoBranchProfileAccountStatusDto.getSb_ac_count()!=null?mssoBranchProfileAccountStatusDto.getSb_ac_count():0L);
            parameters.put("AsOnMarchSB",mssoBranchProfileAccountStatusMarch!=null && mssoBranchProfileAccountStatusMarch.getSb_ac_count()!=null?mssoBranchProfileAccountStatusMarch.getSb_ac_count():0L);
            parameters.put("quarterTargetCa",mssoAccountStatusDigitalTargetDto!=null && mssoAccountStatusDigitalTargetDto.getCa_ac_count()!=null?mssoAccountStatusDigitalTargetDto.getCa_ac_count():0L);
            parameters.put("asonDateCa",mssoBranchProfileAccountStatusDto!=null && mssoBranchProfileAccountStatusDto.getCa_ac_count()!=null?mssoBranchProfileAccountStatusDto.getCa_ac_count():0L);
            parameters.put("asOnMarchCa",mssoBranchProfileAccountStatusMarch!=null && mssoBranchProfileAccountStatusMarch.getCa_ac_count()!=null?mssoBranchProfileAccountStatusMarch.getCa_ac_count():0L);
            parameters.put("asonDateDebitCard",mssoBranchProfileDigitalProductDto!=null && mssoBranchProfileDigitalProductDto.getAtm_card()!=null?mssoBranchProfileDigitalProductDto.getAtm_card():0L);
            parameters.put("asonDateMobileBanking",mssoBranchProfileDigitalProductDto!=null && mssoBranchProfileDigitalProductDto.getMobile_banking()!=null?mssoBranchProfileDigitalProductDto.getMobile_banking():0L);
            parameters.put("asonDateInternetBanking",mssoBranchProfileDigitalProductDto!=null && mssoBranchProfileDigitalProductDto.getinternet_banking()!=null?mssoBranchProfileDigitalProductDto.getinternet_banking():0L);
            parameters.put("quarterTargetDebitCard",mssoAccountStatusDigitalTargetDto!=null && mssoAccountStatusDigitalTargetDto.getAtm_card()!=null?mssoAccountStatusDigitalTargetDto.getAtm_card():0L);
            parameters.put("quarterTargetMobileBanking",mssoAccountStatusDigitalTargetDto!=null && mssoAccountStatusDigitalTargetDto.getMobile_banking()!=null?mssoAccountStatusDigitalTargetDto.getMobile_banking():0L);
            parameters.put("quarterTargetInternetBanking",mssoAccountStatusDigitalTargetDto!=null && mssoAccountStatusDigitalTargetDto.getinternet_banking()!=null?mssoAccountStatusDigitalTargetDto.getinternet_banking():0L);

//**************************************************** SOCIAL SECURITY SCHEME ******************************************************************************

            parameters.put("quarterTargetPmjdy",mssoFiSchemeDtoTarget!=null && mssoFiSchemeDtoTarget.getPmjdy()!=null?mssoFiSchemeDtoTarget.getPmjdy(): 0L);
            parameters.put("quarterTargetPmjjby",mssoFiSchemeDtoTarget!=null && mssoFiSchemeDtoTarget.getPmjjby()!=null?mssoFiSchemeDtoTarget.getPmjjby(): 0L);
            parameters.put("quarterTargetPmsby",mssoFiSchemeDtoTarget!=null && mssoFiSchemeDtoTarget.getPmsby()!=null?mssoFiSchemeDtoTarget.getPmsby(): 0L);
            parameters.put("quarterTargetApy",mssoFiSchemeDtoTarget!=null && mssoFiSchemeDtoTarget.getApy()!=null?mssoFiSchemeDtoTarget.getApy(): 0L);
            parameters.put("asOnDatePmjdy",mssoBranchProfileAccountStatusDto!=null && mssoBranchProfileAccountStatusDto.getPmjdy()!=null?mssoBranchProfileAccountStatusDto.getPmjdy(): 0L);
            parameters.put("asOnDatePmjjby",mssoFiSchemeDto!=null && mssoFiSchemeDto.getPmjjby()!=null?mssoFiSchemeDto.getPmjjby(): 0L);
            parameters.put("asOnDatePmsby",mssoFiSchemeDto!=null && mssoFiSchemeDto.getPmsby()!=null?mssoFiSchemeDto.getPmsby(): 0L);
            parameters.put("asOnDateApy",mssoFiSchemeDto!=null && mssoFiSchemeDto.getApy()!=null?mssoFiSchemeDto.getApy(): 0L);

            LocalDate quarterEnd = ServiceMssoBranchProfileTargetData.getCurrentquarterEndDateDate();
            System.out.println("Current Quarter End Date: " + dateConverterQuarter(quarterEnd));
            parameters.put("quarter",dateConverterQuarter(quarterEnd));

            LocalDate financialYearEndDate = serviceMssoBranchProfileTargetData.getFinancialYearEndDate();
            System.out.println("financialYearEndDate : " + dateConverterQuarter(financialYearEndDate));
            parameters.put("financialYrEnd",dateConverterQuarter(financialYearEndDate));

            List<LocalDate> marchEndDates = ServiceBranchProfileLast3Year.getLastThreeMarchEndDates();
            marchEndDates.forEach(System.out::println);

            parameters.put("year1",dateConverterYear(marchEndDates.get(2)));
            parameters.put("year2",dateConverterYear(marchEndDates.get(1)));
            parameters.put("year3",dateConverterYear(marchEndDates.get(0)));
            parameters.put("totalAson",dateConverterLocalDate(marchEndDates.get(0)));
            parameters.put("todayDate",total_staff);
            parameters.put("financialYear",total_staff);
            parameters.put("timebarredReportDate",mssoProfileTimebarred.getReport_date());


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


    //********************************************************************************************************************************************************

    public ResponseEntity<ByteArrayResource> exportVisitReport(String branch_code,  LocalDate visit_date) throws JRException {

        try {
            //********************************************** Load main JRXML file ************************************************************************************

            //***************************************************************************************************************************************************************

            InputStream templateStream;
            templateStream = getClass().getResourceAsStream("/REPORTS/VisitReportDownload.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);


            //*********************************************** Main JRXML parameter mapping ***************************************************************************

            ExecutiveVisitingData report = serviceVisitReport.getVisitDataByBranch(branch_code,visit_date);
            VisitDataStaffCompliance reportCompliance = serviceVisitReport.getVisitStaffComplianceData(branch_code,visit_date);

            System.out.println("ExecutiveVisitingData :"+report);

//************************** YEAR 1 ****************************************************************************
            ParameterDetailsVisit year1 = new ParameterDetailsVisit();
            year1.setReportDate(report.getReport_dateMarch1());
            year1.setSb(report.getSbMarch1());
            year1.setCa(report.getCaMarch1());
            year1.setTd(report.getTdMarch1());
            year1.setCasa(report.getCasaMarch1());
            year1.setDeposit(report.getDepositMarch1());
            year1.setAdvances(report.getAdvancesMarch1());
            year1.setTotalBusiness(report.getTotal_businessMarch1());
            year1.setTotalRetail(report.getTotal_retailMarch1());
            year1.setHousing(report.getHousingMarch1());
            year1.setVehicle(report.getVehicleMarch1());
            year1.setEducation(report.getEducationMarch1());
            year1.setAgri(report.getAgriMarch1());
            year1.setMsme(report.getMsmeMarch1());
            year1.setGold(report.getGoldMarch1());
            year1.setShg(report.getShgMarch1());
            year1.setTotalRam(report.getTotal_ramMarch1());
            year1.setNpa(report.getNpaMarch1());

//************************** YEAR 2 ****************************************************************************

            ParameterDetailsVisit year2 = new ParameterDetailsVisit();
            year2.setReportDate(report.getReport_dateMarch2());
            year2.setSb(report.getSbMarch2());
            year2.setCa(report.getCaMarch2());
            year2.setTd(report.getTdMarch2());
            year2.setCasa(report.getCasaMarch2());
            year2.setDeposit(report.getDepositMarch2());
            year2.setAdvances(report.getAdvancesMarch2());
            year2.setTotalBusiness(report.getTotal_businessMarch2());
            year2.setTotalRetail(report.getTotal_retailMarch2());
            year2.setHousing(report.getHousingMarch2());
            year2.setVehicle(report.getVehicleMarch2());
            year2.setEducation(report.getEducationMarch2());
            year2.setAgri(report.getAgriMarch2());
            year2.setMsme(report.getMsmeMarch2());
            year2.setGold(report.getGoldMarch2());
            year2.setShg(report.getShgMarch2());
            year2.setTotalRam(report.getTotal_ramMarch2());
            year2.setNpa(report.getNpaMarch2());
  //*********************************** YEAR 3**********************************************************************
            ParameterDetailsVisit year3 = new ParameterDetailsVisit();
            year3.setReportDate(report.getReport_dateMarch3());
            year3.setSb(report.getSbMarch3());
            year3.setCa(report.getCaMarch3());
            year3.setTd(report.getTdMarch3());
            year3.setCasa(report.getCasaMarch3());
            year3.setDeposit(report.getDepositMarch3());
            year3.setAdvances(report.getAdvancesMarch3());
            year3.setTotalBusiness(report.getTotal_businessMarch3());
            year3.setTotalRetail(report.getTotal_retailMarch3());
            year3.setHousing(report.getHousingMarch3());
            year3.setVehicle(report.getVehicleMarch3());
            year3.setEducation(report.getEducationMarch3());
            year3.setAgri(report.getAgriMarch3());
            year3.setMsme(report.getMsmeMarch3());
            year3.setGold(report.getGoldMarch3());
            year3.setShg(report.getShgMarch3());
            year3.setTotalRam(report.getTotal_ramMarch3());
            year3.setNpa(report.getNpaMarch3());
//***********************************************************************************************


            ParameterDetailsVisit currentDate = new ParameterDetailsVisit();
            currentDate.setReportDate(report.getReport_date_actual());
            currentDate.setSb(report.getSb());
            currentDate.setCa(report.getCa());
            currentDate.setTd(report.getTd());
            currentDate.setCasa(report.getCasa());
            currentDate.setDeposit(report.getDeposit());
            currentDate.setAdvances(report.getAdvances());
            currentDate.setTotalBusiness(report.getTotal_business());
            currentDate.setTotalRetail(report.getTotal_retail());
            currentDate.setHousing(report.getHousing());
            currentDate.setVehicle(report.getVehicle());
            currentDate.setEducation(report.getEducation());
            currentDate.setAgri(report.getAgri());
            currentDate.setMsme(report.getMsme());
            currentDate.setGold(report.getGold());
            currentDate.setShg(report.getShg());
            currentDate.setTotalRam(report.getTotal_ram());
            currentDate.setNpa(report.getNpa());


            ParameterDetailsVisit target = new ParameterDetailsVisit();
            target.setReportDate(report.getReport_dateTarget());
            target.setSb(report.getSbTarget());
            target.setCa(report.getCaTarget());
            target.setTd(report.getTdTarget());
            target.setCasa(report.getCasaTarget());
            target.setDeposit(report.getDepositTarget());
            target.setAdvances(report.getAdvancesTarget());
            target.setTotalBusiness(report.getTotal_businessTarget());
            target.setTotalRetail(report.getTotal_retailTarget());
            target.setHousing(report.getHousingTarget());
            target.setVehicle(report.getVehicleTarget());
            target.setEducation(report.getEducationTarget());
            target.setAgri(report.getAgriTarget());
            target.setMsme(report.getMsmeTarget());
            target.setGold(report.getGoldTarget());
            target.setShg(report.getShgTarget());
            target.setTotalRam(report.getTotal_ramTarget());
            target.setNpa(report.getNpaTarget());



            ParameterDetailsVisit targetGap = new ParameterDetailsVisit();
            targetGap.setReportDate(report.getReport_dateTargetgap());
            targetGap.setSb(report.getSbTargetgap());
            targetGap.setCa(report.getCaTargetgap());
            targetGap.setTd(report.getTdTargetgap());
            targetGap.setCasa(report.getCasaTargetgap());
            targetGap.setDeposit(report.getDepositTargetgap());
            targetGap.setAdvances(report.getAdvancesTargetgap());
            targetGap.setTotalBusiness(report.getTotal_businessTargetgap());
            targetGap.setTotalRetail(report.getTotal_retailTargetgap());
            targetGap.setHousing(report.getHousingTargetgap());
            targetGap.setVehicle(report.getVehicleTargetgap());
            targetGap.setEducation(report.getEducationTargetgap());
            targetGap.setAgri(report.getAgriTargetgap());
            targetGap.setMsme(report.getMsmeTargetgap());
            targetGap.setGold(report.getGoldTargetgap());
            targetGap.setShg(report.getShgTargetgap());
            targetGap.setTotalRam(report.getTotal_ramTargetgap());
            targetGap.setNpa(report.getNpaTargetgap());


            ParameterDetailsVisit marchGap = new ParameterDetailsVisit();
            marchGap.setReportDate(report.getReport_dateMarchGap());
            marchGap.setSb(report.getSbMarchGap());
            marchGap.setCa(report.getCaMarchGap());
            marchGap.setTd(report.getTdMarchGap());
            marchGap.setCasa(report.getCasaMarchGap());
            marchGap.setDeposit(report.getDepositMarchGap());
            marchGap.setAdvances(report.getAdvancesMarchGap());
            marchGap.setTotalBusiness(report.getTotal_businessMarchGap());
            marchGap.setTotalRetail(report.getTotal_retailMarchGap());
            marchGap.setHousing(report.getHousingMarchGap());
            marchGap.setVehicle(report.getVehicleMarchGap());
            marchGap.setEducation(report.getEducationMarchGap());
            marchGap.setAgri(report.getAgriMarchGap());
            marchGap.setMsme(report.getMsmeMarchGap());
            marchGap.setGold(report.getGoldMarchGap());
            marchGap.setShg(report.getShgMarchGap());
            marchGap.setTotalRam(report.getTotal_ramMarchGap());
            marchGap.setNpa(report.getNpaMarchGap());

            ParameterDetailsVisit marchPercent = new ParameterDetailsVisit();
            marchPercent.setReportDate(report.getReport_dateMarchPercent());
            marchPercent.setSb(report.getSbMarchPercent());
            marchPercent.setCa(report.getCaMarchPercent());
            marchPercent.setTd(report.getTdMarchPercent());
            marchPercent.setCasa(report.getCasaMarchPercent());
            marchPercent.setDeposit(report.getDepositMarchPercent());
            marchPercent.setAdvances(report.getAdvancesMarchPercent());
            marchPercent.setTotalBusiness(report.getTotal_businessMarchPercent());
            marchPercent.setTotalRetail(report.getTotal_retailMarchPercent());
            marchPercent.setHousing(report.getHousingMarchPercent());
            marchPercent.setVehicle(report.getVehicleMarchPercent());
            marchPercent.setEducation(report.getEducationMarchPercent());
            marchPercent.setAgri(report.getAgriMarchPercent());
            marchPercent.setMsme(report.getMsmeMarchPercent());
            marchPercent.setGold(report.getGoldMarchPercent());
            marchPercent.setShg(report.getShgMarchPercent());
            marchPercent.setTotalRam(report.getTotal_ramMarchPercent());
            marchPercent.setNpa(report.getNpaMarchPercent());

            ParameterDetailsVisit comingMarch = new ParameterDetailsVisit();
            comingMarch.setReportDate(report.getReport_dateComingMarch());
            comingMarch.setSb(report.getSbComingMarch());
            comingMarch.setCa(report.getCaComingMarch());
            comingMarch.setTd(report.getTdComingMarch());
            comingMarch.setCasa(report.getCasaComingMarch());
            comingMarch.setDeposit(report.getDepositComingMarch());
            comingMarch.setAdvances(report.getAdvancesComingMarch());
            comingMarch.setTotalBusiness(report.getTotal_businessComingMarch());
            comingMarch.setTotalRetail(report.getTotal_retailComingMarch());
            comingMarch.setHousing(report.getHousingComingMarch());
            comingMarch.setVehicle(report.getVehicleComingMarch());
            comingMarch.setEducation(report.getEducationComingMarch());
            comingMarch.setAgri(report.getAgriComingMarch());
            comingMarch.setMsme(report.getMsmeComingMarch());
            comingMarch.setGold(report.getGoldComingMarch());
            comingMarch.setShg(report.getShgComingMarch());
            comingMarch.setTotalRam(report.getTotal_ramComingMarch());
            comingMarch.setNpa(report.getNpaComingMarch());

            ParameterDetailsVisit superAchiever = new ParameterDetailsVisit();

            superAchiever.setTotalBusiness(report.getTotal_businessSuperMarch());

            superAchiever.setNpa(report.getNpaSuperMarch());

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
            SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM-dd");
            parameterDetailsList.add(new ParameterDetails(
                    "Total Business",
                    year1.getTotalBusiness(),
                    year2.getTotalBusiness(),
                    year3.getTotalBusiness(),
                    currentDate.getTotalBusiness(),
                    target.getTotalBusiness(),
                    targetGap.getTotalBusiness(),
                    marchGap.getTotalBusiness(),  // gapTarget
                    marchPercent.getTotalBusiness(),
                    comingMarch.getTotalBusiness(), // targetYear
                    superAchiever.getTotalBusiness()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Total Deposit",
                    year1.getDeposit(),
                    year2.getDeposit(),
                    year3.getDeposit(),
                    currentDate.getDeposit(),
                    target.getDeposit(),
                    targetGap.getDeposit(),
                    marchGap.getDeposit(),  // gapTarget
                    marchPercent.getDeposit(),
                    comingMarch.getDeposit(), // targetYear
                    superAchiever.getDeposit()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "CA",
                    year1.getCa(),
                    year2.getCa(),
                    year3.getCa(),
                    currentDate.getCa(),
                    target.getCa(),
                    targetGap.getCa(),
                    marchGap.getCa(),  // gapTarget
                    marchPercent.getCa(),
                    comingMarch.getCa(), // targetYear
                    superAchiever.getCa()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "SB",
                    year1.getSb(),
                    year2.getSb(),
                    year3.getSb(),
                    currentDate.getSb(),
                    target.getSb(),
                    targetGap.getSb(),
                    marchGap.getSb(),  // gapTarget
                    marchPercent.getSb(),
                    comingMarch.getSb(), // targetYear
                    superAchiever.getSb()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "CASA Deposit",
                    year1.getCasa(),
                    year2.getCasa(),
                    year3.getCasa(),
                    currentDate.getCasa(),
                    target.getCasa(),
                    targetGap.getCasa(),
                    marchGap.getCasa(),  // gapTarget
                    marchPercent.getCasa(),
                    comingMarch.getCasa(), // targetYear
                    superAchiever.getCasa()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Term Deposit",
                    year1.getTd(),
                    year2.getTd(),
                    year3.getTd(),
                    currentDate.getTd(),
                    target.getTd(),
                    targetGap.getTd(),
                    marchGap.getTd(),  // gapTarget
                    marchPercent.getTd(),
                    comingMarch.getTd(), // targetYear
                    superAchiever.getTd()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Gross Advances",
                    year1.getAdvances(),
                    year2.getAdvances(),
                    year3.getAdvances(),
                    currentDate.getAdvances(),
                    target.getAdvances(),
                    targetGap.getAdvances(),
                    marchGap.getAdvances(),  // gapTarget
                    marchPercent.getAdvances(),
                    comingMarch.getAdvances(), // targetYear
                    superAchiever.getAdvances()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Retail",
                    year1.getTotalRetail(),
                    year2.getTotalRetail(),
                    year3.getTotalRetail(),
                    currentDate.getTotalRetail(),
                    target.getTotalRetail(),
                    targetGap.getTotalRetail(),
                    marchGap.getTotalRetail(),  // gapTarget
                    marchPercent.getTotalRetail(),
                    comingMarch.getTotalRetail(), // targetYear
                    superAchiever.getTotalRetail()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Housing",
                    year1.getHousing(),
                    year2.getHousing(),
                    year3.getHousing(),
                    currentDate.getHousing(),
                    target.getHousing(),
                    targetGap.getHousing(),
                    marchGap.getHousing(),  // gapTarget
                    marchPercent.getHousing(),
                    comingMarch.getHousing(), // targetYear
                    superAchiever.getHousing()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Vehicle",
                    year1.getVehicle(),
                    year2.getVehicle(),
                    year3.getVehicle(),
                    currentDate.getVehicle(),
                    target.getVehicle(),
                    targetGap.getVehicle(),
                    marchGap.getVehicle(),  // gapTarget
                    marchPercent.getVehicle(),
                    comingMarch.getVehicle(), // targetYear
                    superAchiever.getVehicle()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Education",
                    year1.getEducation(),
                    year2.getEducation(),
                    year3.getEducation(),
                    currentDate.getEducation(),
                    target.getEducation(),
                    targetGap.getEducation(),
                    marchGap.getEducation(),  // gapTarget
                    marchPercent.getEducation(),
                    comingMarch.getEducation(), // targetYear
                    superAchiever.getEducation()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Agriculture",
                    year1.getAgri(),
                    year2.getAgri(),
                    year3.getAgri(),
                    currentDate.getAgri(),
                    target.getAgri(),
                    targetGap.getAgri(),
                    marchGap.getAgri(),  // gapTarget
                    marchPercent.getAgri(),
                    comingMarch.getAgri(), // targetYear
                    superAchiever.getAgri()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "MSME",
                    year1.getMsme(),
                    year2.getMsme(),
                    year3.getMsme(),
                    currentDate.getMsme(),
                    target.getMsme(),
                    targetGap.getMsme(),
                    marchGap.getMsme(),  // gapTarget
                    marchPercent.getMsme(),
                    comingMarch.getMsme(), // targetYear
                    superAchiever.getMsme()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Gold",
                    year1.getGold(),
                    year2.getGold(),
                    year3.getGold(),
                    currentDate.getGold(),
                    target.getGold(),
                    targetGap.getGold(),
                    marchGap.getGold(),  // gapTarget
                    marchPercent.getGold(),
                    comingMarch.getGold(), // targetYear
                    superAchiever.getGold()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "SHG",
                    year1.getShg(),
                    year2.getShg(),
                    year3.getShg(),
                    currentDate.getShg(),
                    target.getShg(),
                    targetGap.getShg(),
                    marchGap.getShg(),  // gapTarget
                    marchPercent.getShg(),
                    comingMarch.getShg(), // targetYear
                    superAchiever.getShg()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "Total RAM",
                    year1.getTotalRam(),
                    year2.getTotalRam(),
                    year3.getTotalRam(),
                    currentDate.getTotalRam(),
                    target.getTotalRam(),
                    targetGap.getTotalRam(),
                    marchGap.getTotalRam(),  // gapTarget
                    marchPercent.getTotalRam(),
                    comingMarch.getTotalRam(), // targetYear
                    superAchiever.getTotalRam()  // targetYearSuperAchiever
            ));

            parameterDetailsList.add(new ParameterDetails(
                    "NPA",
                    year1.getNpa(),
                    year2.getNpa(),
                    year3.getNpa(),
                    currentDate.getNpa(),
                    target.getNpa(),
                    targetGap.getNpa(),
                    marchGap.getNpa(),  // gapTarget
                    marchPercent.getNpa(),
                    comingMarch.getNpa(), // targetYear
                    superAchiever.getNpa()  // targetYearSuperAchiever
            ));
            for (ParameterDetails pd : parameterDetailsList) {
                System.out.println("Checking parameter: " + pd.getParameter());
            }

            System.out.println("DATA :"+parameterDetailsList.get(0).toString());


            MssoBranchProfileSmaDto mssoBranchProfileSmaDto  = new MssoBranchProfileSmaDto();
            mssoBranchProfileSmaDto.setReport_date(report.getReport_dateSma());
            mssoBranchProfileSmaDto.setTotal_count((long) report.getTotal_count());
            mssoBranchProfileSmaDto.setTotal_amount(report.getTotal_amount());
            mssoBranchProfileSmaDto.setSma0_count((long) report.getSma0_count());
            mssoBranchProfileSmaDto.setSma0_amount(report.getSma0_amount());
            mssoBranchProfileSmaDto.setSma1_count((long)report.getSma1_count());
            mssoBranchProfileSmaDto.setSma1_amount(report.getSma1_amount());
            mssoBranchProfileSmaDto.setSma2_count((long)report.getSma2_count());
            mssoBranchProfileSmaDto.setSma2_amount(report.getSma2_amount());
            mssoBranchProfileSmaDto.setSma0Percentage(reportCompliance.getSma0Percentage());
            mssoBranchProfileSmaDto.setSma1Percentage(reportCompliance.getSma1Percentage());
            mssoBranchProfileSmaDto.setSma2Percentage(reportCompliance.getSma2Percentage());
            mssoBranchProfileSmaDto.setSmaTotalPercentage(reportCompliance.getSmaTotalPercentage());

            System.out.println("mssoBranchProfileSmaDto :" + mssoBranchProfileSmaDto);
            List<MssoBranchProfileSmaDto> mssoBranchProfileSmaDtoList = Collections.singletonList(mssoBranchProfileSmaDto);

            MssoProfileDailyDisburseDto  mssoProfileDailyDisburseTargetDto  = new MssoProfileDailyDisburseDto();

            mssoProfileDailyDisburseTargetDto.setReport_date(reportCompliance.getReport_dateDisbTarget());
            mssoProfileDailyDisburseTargetDto.setTotal_advances(reportCompliance.getTotal_advancesDisbTarget());
            mssoProfileDailyDisburseTargetDto.setTotal_os(reportCompliance.getTotal_osDisbTarget());
            mssoProfileDailyDisburseTargetDto.setTotal_count((long)reportCompliance.getTotal_countDisbTarget());
            mssoProfileDailyDisburseTargetDto.setRetail(reportCompliance.getRetailDisbTarget());
            mssoProfileDailyDisburseTargetDto.setRetail_count((long)reportCompliance.getRetail_countDisbTarget());
            mssoProfileDailyDisburseTargetDto.setHousing(reportCompliance.getHousingDisbTarget());
            mssoProfileDailyDisburseTargetDto.setHousing_count((long)reportCompliance.getHousing_countDisbTarget());
            mssoProfileDailyDisburseTargetDto.setVehicle(reportCompliance.getVehicleDisbTarget());
            mssoProfileDailyDisburseTargetDto.setVehicle_count((long)reportCompliance.getVehicle_countDisbTarget());
            mssoProfileDailyDisburseTargetDto.setEducation(reportCompliance.getEducationDisbTarget());
            mssoProfileDailyDisburseTargetDto.setEducation_count((long)reportCompliance.getEducation_countDisbTarget());
            mssoProfileDailyDisburseTargetDto.setAgriculture(reportCompliance.getAgricultureDisbTarget());
            mssoProfileDailyDisburseTargetDto.setAgriculture_count((long)reportCompliance.getAgriculture_countDisbTarget());
            mssoProfileDailyDisburseTargetDto.setMsme(reportCompliance.getMsmeDisbTarget());
            mssoProfileDailyDisburseTargetDto.setMsme_count((long)reportCompliance.getMsme_countDisbTarget());
            mssoProfileDailyDisburseTargetDto.setGold(reportCompliance.getGoldDisbTarget());
            mssoProfileDailyDisburseTargetDto.setGold_count((long)reportCompliance.getGold_countDisbTarget());
            mssoProfileDailyDisburseTargetDto.setShg(reportCompliance.getShgDisbTarget());
            mssoProfileDailyDisburseTargetDto.setShg_count((long)reportCompliance.getShg_countDisbTarget());

            mssoProfileDailyDisburseTargetDto.setPmvishvakarma(reportCompliance.getPmvishvakarmaTarget());
            mssoProfileDailyDisburseTargetDto.setPmvishvakarma_count((long)reportCompliance.getPmvishvakarma_countTarget());
            mssoProfileDailyDisburseTargetDto.setPm_suryaghar(reportCompliance.getPm_suryagharTarget());
            mssoProfileDailyDisburseTargetDto.setPm_suryaghar_count((long)reportCompliance.getPm_suryaghar_countTarget());


            System.out.println("mssoProfileDailyDisburseTargetDto :" + mssoProfileDailyDisburseTargetDto);
            List<MssoProfileDailyDisburseDto> mssoProfileDailyDisburseDtoTargetList = Collections.singletonList(mssoProfileDailyDisburseTargetDto);


            MssoProfileDailyDisburseDto  mssoProfileDailyDisburseDto  = new MssoProfileDailyDisburseDto ();

            mssoProfileDailyDisburseDto.setReport_date(reportCompliance.getReport_dateDisb());
            mssoProfileDailyDisburseDto.setTotal_advances(reportCompliance.getTotal_advancesDisb());
            mssoProfileDailyDisburseDto.setTotal_os(reportCompliance.getTotal_osDisb());
            mssoProfileDailyDisburseDto.setTotal_count((long)reportCompliance.getTotal_countDisb());

            mssoProfileDailyDisburseDto.setRetail(reportCompliance.getRetailDisb());
            mssoProfileDailyDisburseDto.setRetail_count((long)reportCompliance.getRetail_countDisb());
            mssoProfileDailyDisburseDto.setHousing(reportCompliance.getHousingDisb());
            mssoProfileDailyDisburseDto.setHousing_count((long)reportCompliance.getHousing_countDisb());
            mssoProfileDailyDisburseDto.setVehicle(reportCompliance.getVehicleDisb());
            mssoProfileDailyDisburseDto.setVehicle_count((long)reportCompliance.getVehicle_countDisb());
            mssoProfileDailyDisburseDto.setEducation(reportCompliance.getEducationDisb());
            mssoProfileDailyDisburseDto.setEducation_count((long)reportCompliance.getEducation_countDisb());
            mssoProfileDailyDisburseDto.setAgriculture(reportCompliance.getAgricultureDisb());
            mssoProfileDailyDisburseDto.setAgriculture_count((long)reportCompliance.getAgriculture_countDisb());
            mssoProfileDailyDisburseDto.setMsme(reportCompliance.getMsmeDisb());
            mssoProfileDailyDisburseDto.setMsme_count((long)reportCompliance.getMsme_countDisb());
            mssoProfileDailyDisburseDto.setGold(reportCompliance.getGoldDisb());
            mssoProfileDailyDisburseDto.setGold_count((long)reportCompliance.getGold_countDisb());
            mssoProfileDailyDisburseDto.setShg(reportCompliance.getShgDisb());
            mssoProfileDailyDisburseDto.setShg_count((long)reportCompliance.getShg_countDisb());

            mssoProfileDailyDisburseDto.setPmvishvakarma(reportCompliance.getPmvishvakarma());
            mssoProfileDailyDisburseDto.setPmvishvakarma_count((long)reportCompliance.getPmvishvakarma_count());
            mssoProfileDailyDisburseDto.setPm_suryaghar(reportCompliance.getPm_suryaghar());
            mssoProfileDailyDisburseDto.setPm_suryaghar_count((long)reportCompliance.getPm_suryaghar_count());
            System.out.println("mssoProfileDailyDisburseDto :" + mssoProfileDailyDisburseDto);

            List<MssoProfileDailyDisburseDto> mssoProfileDailyDisburseDtoList = Collections.singletonList(mssoProfileDailyDisburseDto);

            MssoProfileNpaClassificationDto  mssoNpaClassification  = new MssoProfileNpaClassificationDto();

            mssoNpaClassification.setTotal_amount(report.getTotal_amountNpa());
            mssoNpaClassification.setTotal_count(report.getTotal_countNpa());
            mssoNpaClassification.setD0_amount(report.getD0_amountNpa());
            mssoNpaClassification.setD0_count(report.getD0_countNpa());
            mssoNpaClassification.setD0_count(report.getD0_countNpa());
            mssoNpaClassification.setD1_amount(report.getD1_amountNpa());
            mssoNpaClassification.setD1_count(report.getD1_countNpa());
            mssoNpaClassification.setD2_amount(report.getD2_amountNpa());
            mssoNpaClassification.setD2_count(report.getD2_countNpa());
            mssoNpaClassification.setloss_amount(report.getLoss_amountNpa());
            mssoNpaClassification.setloss_count(report.getLoss_countNpa());
            mssoNpaClassification.setSubStandard_amount(report.getSubStandard_amountNpa());
            mssoNpaClassification.setSubStandard_count(report.getSubStandard_countNpa());

            List<MssoProfileNpaClassificationDto> mssoNpaClassificationList = Collections.singletonList(mssoNpaClassification);


            SectorwiseNpaDto sectorwiseNpaDto = new SectorwiseNpaDto();

            sectorwiseNpaDto.setHousing_amt(reportCompliance.getHousing_amt());
            sectorwiseNpaDto.setTotal_housing(reportCompliance.getTotal_housing());
            sectorwiseNpaDto.setKcc_atl_amt(reportCompliance.getKcc_atl_amt());
            sectorwiseNpaDto.setKcc_atl(reportCompliance.getKcc_atl());
            sectorwiseNpaDto.setNacc_amt(reportCompliance.getNacc_amt());
            sectorwiseNpaDto.setNacc(reportCompliance.getNacc());
            sectorwiseNpaDto.setNatl_amt(reportCompliance.getNatl_amt());
            sectorwiseNpaDto.setTotal_natl(reportCompliance.getTotal_natl());
            sectorwiseNpaDto.setShg_amt(reportCompliance.getShg_amt());
            sectorwiseNpaDto.setTotal_shg(reportCompliance.getTotal_shg());
            sectorwiseNpaDto.setOther_amt(reportCompliance.getOther_amt());
            sectorwiseNpaDto.setOther(reportCompliance.getOther());
            List<SectorwiseNpaDto> sectorwiseNpaList = Collections.singletonList(sectorwiseNpaDto);

            AmountwiseNpaDto amountwiseNpaDto = new AmountwiseNpaDto();

            amountwiseNpaDto.setBelow_1lakh_amt(reportCompliance.getBelow_1lakh_amt());
            amountwiseNpaDto.setBelow_3lakh_amt(reportCompliance.getBelow_3lakh_amt());
            amountwiseNpaDto.setBelow_24lakh_amt(reportCompliance.getBelow_24lakh_amt());
            amountwiseNpaDto.setAbove_25lakh_amt(reportCompliance.getAbove_25lakh_amt());
            amountwiseNpaDto.setCount_below_1lakh(reportCompliance.getCount_below_1lakh());
            amountwiseNpaDto.setCount_below_3lakh(reportCompliance.getCount_below_3lakh());
            amountwiseNpaDto.setCount_below_24lakh(reportCompliance.getCount_below_24lakh());
            amountwiseNpaDto.setCount_above_25lakh(reportCompliance.getCount_above_25lakh());

            List<AmountwiseNpaDto> amountwiseNpaList = Collections.singletonList(amountwiseNpaDto);



            MssoBranchEmployeeDataDto mssoBranchEmployeeDataDto=new MssoBranchEmployeeDataDto();
            mssoBranchEmployeeDataDto.setDesg_agm(reportCompliance.getDesg_agm());
            mssoBranchEmployeeDataDto.setDesg_cm(reportCompliance.getDesg_cm());
            mssoBranchEmployeeDataDto.setDesg_srmanager(reportCompliance.getDesg_srmanager());
            mssoBranchEmployeeDataDto.setDesg_manager(reportCompliance.getDesg_manager());
            mssoBranchEmployeeDataDto.setDesg_dymanager(reportCompliance.getDesg_dymanager());
            mssoBranchEmployeeDataDto.setDesg_clerk(reportCompliance.getDesg_clerk());
            mssoBranchEmployeeDataDto.setSubstaff(reportCompliance.getSubstaff());

            System.out.println("SMA DATA :"+mssoBranchEmployeeDataDto);
            List<MssoBranchEmployeeDataDto> mssoBranchEmployeeDataDtoList = Collections.singletonList(mssoBranchEmployeeDataDto);


            MssoEmployeeSummaryDto mssoEmployeeSummaryDto = new MssoEmployeeSummaryDto();

            mssoEmployeeSummaryDto.setDesg_agm(reportCompliance.getDesg_agmTotalStaff());
            mssoEmployeeSummaryDto.setDesg_cm(reportCompliance.getDesg_cmTotalStaff());
            mssoEmployeeSummaryDto.setDesg_srmanager(reportCompliance.getDesg_srmanagerTotalStaff());
            mssoEmployeeSummaryDto.setDesg_manager(reportCompliance.getDesg_managerTotalStaff());
            mssoEmployeeSummaryDto.setDesg_dymanager(reportCompliance.getDesg_dymanagerTotalStaff());
            mssoEmployeeSummaryDto.setDesg_clerk(reportCompliance.getDesg_clerkTotalStaff());
            mssoEmployeeSummaryDto.setSubstaff(reportCompliance.getSubstaffTotalStaff());
           List<MssoEmployeeSummaryDto> mssoEmployeeSummaryDtoList = Collections.singletonList(mssoEmployeeSummaryDto);


            Map<String, Object> parameters = new HashMap<>();

            parameters.put("paramterDetails", new JRBeanCollectionDataSource(parameterDetailsList));
            parameters.put("stressData", new JRBeanCollectionDataSource(mssoBranchProfileSmaDtoList));
            parameters.put("newLoanSanctioned", new JRBeanCollectionDataSource(mssoProfileDailyDisburseDtoList));
            parameters.put("newLoanSanctionedTarget", new JRBeanCollectionDataSource(mssoProfileDailyDisburseDtoTargetList));
            parameters.put("newLoanSanctionedProductWise", new JRBeanCollectionDataSource(mssoProfileDailyDisburseDtoList));
            parameters.put("newLoanSanctionedProductWiseTarget", new JRBeanCollectionDataSource(mssoProfileDailyDisburseDtoTargetList));
            parameters.put("employeeData", new JRBeanCollectionDataSource(mssoBranchEmployeeDataDtoList));
            parameters.put("employeeDataSummary", new JRBeanCollectionDataSource(mssoEmployeeSummaryDtoList));
            parameters.put("npaClassification", new JRBeanCollectionDataSource( mssoNpaClassificationList));
            parameters.put("perEmployeeBusiness",reportCompliance.getPerEmployeeBusiness());
            parameters.put("sectorwiseNpa", new JRBeanCollectionDataSource(sectorwiseNpaList));
            parameters.put("amountwiseNpa", new JRBeanCollectionDataSource( amountwiseNpaList));
            if(reportCompliance.getBranch_code().equalsIgnoreCase("4000")) {
                parameters.put("region", "Head Office");
                parameters.put("branchName","-");

            }else{

                if(reportCompliance.getRegion().equalsIgnoreCase("AURANGABAD")){
                    parameters.put("region", "Chht. Sambhaji Nagar");
                }else {
                    parameters.put("region", reportCompliance.getRegion());
                }
                parameters.put("branchName",reportCompliance.getBranch_name());

            }

            String branchOpenDate=dateConverter(reportCompliance.getBranchOpenDate());
            String bmBranchJoinDate=dateConverter(report.getBmBranchJoinDate());
            String visitorDate=dateConverterLocalDate(reportCompliance.getVisit_date());

            parameters.put("sinceDate", branchOpenDate!=null?branchOpenDate:"");
            parameters.put("bmBranchJoinDate", bmBranchJoinDate!=null?bmBranchJoinDate:"");
            parameters.put("visitorName", reportCompliance.getVisitor_name()!=null?reportCompliance.getVisitor_name():"");
            parameters.put("visitorDesignation", reportCompliance.getVisitor_designation()!=null?reportCompliance.getVisitor_designation():"");
            parameters.put("visitorDate", visitorDate!=null?visitorDate:"");

            parameters.put("branchCode",report.getBranch_code()!=null?report.getBranch_code():"");
            String designation="";
            String desig="";
            if(reportCompliance.getU_loc().equalsIgnoreCase("RO")) {

                desig="RM";
                designation="Regional";
            }else if(reportCompliance.getU_loc().equalsIgnoreCase("BR")) {

                desig="BM";
                designation="Branch";
            }else{
                desig="";
                designation="";
            }

            parameters.put("designation", designation!=null?designation:"");
            parameters.put("design", desig!=null?desig:"");
            parameters.put("bcCount",reportCompliance.getBcCount());
                parameters.put("totalBranch", reportCompliance.getTotalBranchCount()!=null?reportCompliance.getTotalBranchCount():0);
                parameters.put("urban", reportCompliance.getUrban()!=null?reportCompliance.getUrban():0);
                parameters.put("semiUrban", reportCompliance.getSemiUrban()!=null?reportCompliance.getSemiUrban():0);
                parameters.put("metro", reportCompliance.getMetropolitan()!=null?reportCompliance.getMetropolitan():0);
                parameters.put("rural", reportCompliance.getRural()!=null?reportCompliance.getRural():0);

                String current_report_date=dateConverter(report.getReport_date_actual());
                parameters.put("current_report_date",current_report_date);

            String npa_report_date=dateConverter(report.getReport_dateNpa());
            parameters.put("npa_report_date",npa_report_date);

            System.out.println("current_report_date"+report.getReport_date_actual());


            String sma_report_date=dateConverter(report.getReport_dateSma());
            parameters.put("sma_report_date",sma_report_date);

            System.out.println("reportCompliance.getPerEmployeeBusiness() ---------"+reportCompliance.getPerEmployeeBusiness());

            Boolean isPerEmployeeBusiness;
            Boolean isBcCount;
            Boolean isHoRoEmployeeSummary = true;

            String  amountIn="";
            String category = "";
            parameters.put("paramterDetails", new JRBeanCollectionDataSource(parameterDetailsList));
            if(reportCompliance.getU_loc().equalsIgnoreCase("HO")||reportCompliance.getU_loc().equalsIgnoreCase("RO")) {

                parameters.put("total_staff_bank", reportCompliance.getTotal_staff_region().intValue());
                parameters.put("total_staff", reportCompliance.getTotal_staff_branch().intValue());

                amountIn="Crore";
                isPerEmployeeBusiness=false;
                isBcCount = false;
                isHoRoEmployeeSummary = true;
                category = "RO Staff";

            }else {
                parameters.put("total_staff", reportCompliance.getTotal_staff_branch().intValue());
                isPerEmployeeBusiness=true;
                amountIn="Lakh";
                isBcCount = true;
                isHoRoEmployeeSummary = false;
                category = "Branch Staff";
            }

            Boolean isHeadName;
            isHeadName = !reportCompliance.getU_loc().equalsIgnoreCase("HO");
            parameters.put("branchOrRegionHead",reportCompliance.getEmployee_name());
            parameters.put("grade",reportCompliance.getGrade_code());
            parameters.put("isHeadName",isHeadName);
            parameters.put("isBcCount",isBcCount);
            parameters.put("isPerEmployeeBusiness",isPerEmployeeBusiness);
            parameters.put("isHoRoEmployeeSummary",isHoRoEmployeeSummary);
            parameters.put("branchCategory",reportCompliance.getBranch_category());
            parameters.put("amountIn",amountIn);
            parameters.put("category",category);

            parameters.put("recovered_os_amt",reportCompliance.getRecovered_os_amt()!=null?reportCompliance.getRecovered_os_amt():BigDecimal.ZERO);
            parameters.put("recovered_os_amt_march",reportCompliance.getRecovered_os_amtMarch()!=null?reportCompliance.getRecovered_os_amtMarch():BigDecimal.ZERO);
            parameters.put("upgrade_os_amt_march",reportCompliance.getUpgrade_os_amtMarch()!=null?reportCompliance.getUpgrade_os_amtMarch():BigDecimal.ZERO);
            parameters.put("addition_os_amt_march",reportCompliance.getAddition_os_amtMarch()!=null?reportCompliance.getAddition_os_amtMarch():BigDecimal.ZERO);
            parameters.put("upgrade_os_amt",reportCompliance.getUpgrade_os_amt()!=null?reportCompliance.getUpgrade_os_amt():BigDecimal.ZERO);
            parameters.put("addition_os_amt",reportCompliance.getAddition_os_amt()!=null?reportCompliance.getAddition_os_amt():BigDecimal.ZERO);



            System.out.println(isPerEmployeeBusiness+"isPerEmployeeBusinessisPerEmployeeBusinessisPerEmployeeBusiness");
            parameters.put("naccReviewRenewalCount",report.getNacc_count()!=null?report.getNacc_count():0L);
            parameters.put("naccReviewRenewalAmount",report.getNacc_amount()!=null?report.getNacc_amount():BigDecimal.ZERO);
            parameters.put("timebarredCount",report.getTotal_countTimeBarred()!=null?report.getTotal_countTimeBarred():0L);
            parameters.put("timebarredAmount",report.getTotal_amountTimeBarred()!=null?report.getTotal_amountTimeBarred():BigDecimal.ZERO);
            parameters.put("kccReviewRenewalCount",report.getKcc_count());
            parameters.put("kccReviewRenewalAmount",report.getKcc_amount());
            parameters.put("pendingMultipleCif", reportCompliance.getMultiple_cif());
            parameters.put("pendingCkyc",reportCompliance.getCkyc());
            parameters.put("inoperativeCasaCount",reportCompliance.getCasa_count());
            parameters.put("inoperativeCasaAmount",reportCompliance.getCasa_amount());
            parameters.put("quarterTargetSB",reportCompliance.getSb_ac_countTarget());
            parameters.put("asOnDateSB",reportCompliance.getSb_ac_count());
            parameters.put("AsOnMarchSB",reportCompliance.getSb_ac_countMarch());
            parameters.put("quarterTargetCa",reportCompliance.getCa_ac_countTarget());
            parameters.put("asonDateCa",reportCompliance.getCa_ac_count());
            parameters.put("asOnMarchCa",reportCompliance.getCa_ac_countMarch());
            parameters.put("asonDateDebitCard",reportCompliance.getAtm_card());
            parameters.put("asonDateMobileBanking",reportCompliance.getMobile_banking());
            parameters.put("asonDateInternetBanking",reportCompliance.getInternet_banking());
            parameters.put("quarterTargetDebitCard",reportCompliance.getAtm_cardTarget());
            parameters.put("quarterTargetMobileBanking",reportCompliance.getMobile_bankingTarget());
            parameters.put("quarterTargetInternetBanking",reportCompliance.getInternet_bankingTarget());
            parameters.put("quarterTargetPmjdy",reportCompliance.getPmjdyTarget());
            parameters.put("quarterTargetPmjjby",reportCompliance.getPmjjbyTarget());
            parameters.put("quarterTargetPmsby",reportCompliance.getPmsbyTarget());
            parameters.put("quarterTargetApy",reportCompliance.getApyTarget());
            parameters.put("asOnDatePmjdy",reportCompliance.getPmjdy());
            parameters.put("asOnDatePmjjby",reportCompliance.getPmjjby());
            parameters.put("asOnDatePmsby",reportCompliance.getPmsby());
            parameters.put("asOnDateApy",reportCompliance.getApy());

            LocalDate quarterEnd = ServiceMssoBranchProfileTargetData.getCurrentquarterEndDateDate();
            System.out.println("Current Quarter End Date: " + dateConverterQuarter(quarterEnd));
            parameters.put("quarter",dateConverterQuarter(quarterEnd));

            LocalDate financialYearEndDate = serviceMssoBranchProfileTargetData.getFinancialYearEndDate();
            System.out.println("financialYearEndDate : " + dateConverterQuarter(financialYearEndDate));
            parameters.put("financialYrEnd",dateConverterQuarter(financialYearEndDate));

            parameters.put("year1",dateConverterUtil(year1.getReportDate()));
            parameters.put("year2",dateConverterUtil(year2.getReportDate()));
            parameters.put("year3",dateConverterUtil(year3.getReportDate()));
            System.out.println(" dateConverter(year3.getReportDate()) "+dateConverter(year3.getReportDate()));
            parameters.put("totalAson",dateConverter(year3.getReportDate()));


            parameters.put("parameterDetailRemark",reportCompliance.getParameterDetailRemark());
            parameters.put("sanctionDisbursedRemark",reportCompliance.getSanctionDisbursedRemark());
            parameters.put("smaRemark",reportCompliance.getSmaRemark());
            parameters.put("npaClassificationRemark",reportCompliance.getNpaClassificationRemark());
            parameters.put("complianceRemark",reportCompliance.getComplianceRemark());
            parameters.put("accountAndDigitalStatusRemark",reportCompliance.getAccountAndDigitalStatusRemark());
            parameters.put("socialSecurityRemark",reportCompliance.getSocialSecurityRemark());
            parameters.put("otherRemark",reportCompliance.getOtherRemark());
            parameters.put("employeeDataRemark",reportCompliance.getEmployeeDataRemark());
            parameters.put("socialSecurityTargetMonth","");

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


    //**********************************************************************************************************************************************************

    public static BigDecimal convertDateToBigDecimalMonthYear(Date date) {
        if (date == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String formatted = sdf.format(date); // e.g. "202507"
        return new BigDecimal(formatted);    // returns BigDecimal(202507)
    }

    public String dateConverter(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(date);
        System.out.println(formattedDate); // e.g., 05/07/2025
        return  formattedDate;
    }

    public String dateConverterUtil(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM-yyyy");
        String formattedDate = formatter.format(date);
        System.out.println(formattedDate); // e.g., 05/07/2025
        return  formattedDate;
    }
    public String dateConverterQuarter(LocalDate date) {

        // Format to Sep-2025
        String formatted1 = date.format(DateTimeFormatter.ofPattern("MMM-yy"));
        System.out.println(formatted1); // Sep-2025
        return  formatted1;
    }

    public String dateConverterLocalDate(LocalDate date) {

        // Format to Sep-2025
        String formatted1 = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(formatted1); // Sep-2025
        return  formatted1;
    }

    public String dateConverterYear(LocalDate date) {

        // Format to Sep-2025
        String formatted1 = date.format(DateTimeFormatter.ofPattern("MMM-yyyy"));
        System.out.println(formatted1); // Sep-2025
        return  formatted1;
    }
}
