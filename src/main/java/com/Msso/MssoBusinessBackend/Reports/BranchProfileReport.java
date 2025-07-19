package com.Msso.MssoBusinessBackend.Reports;

import com.Msso.MssoBusinessBackend.Model.ModelExecutiveVisit.ExecutiveVisitingData;
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
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.MssoBranchProfileSmaDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.MssoProfileNpaClassificationDto;
import com.Msso.MssoBusinessBackend.Model.ParameterDetails;
import com.Msso.MssoBusinessBackend.Model.ParameterDetailsVisit;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBrachProfileSma.RepoMssoBranchProfileSma;
import com.Msso.MssoBusinessBackend.Repository.RepoMssoBranchEmployeeData.RepoMssoBranchEmployeData;
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
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class BranchProfileReport {

//    @Autowired
//    private ServiceMssoBranchProfileSma serviceMssoBranchProfileSma;
//    @Autowired
//    private ServiceMssoDailyDisbursement serviceMssoDailyDisbursement;
//    @Autowired
//    private MssoBranchDataService mssoBranchDataService;
//    @Autowired
//    private ServiceBranchProfileLast3Year serviceBranchProfileLast3Year;
//    @Autowired
//    ServiceMssoBranchProfileTargetData serviceMssoBranchProfileTargetData;
//    @Autowired
//    ServiceAccountStatusDigitalProduct serviceaccountStatusDigitalProduct;
//    @Autowired
//    RepoMssoBranchProfileActualData repoMssoBranchProfile;
//    @Autowired
//    RepoMssoBranchEmployeData repoEmployeData;
//    @Autowired
//    ServiceVisitReportGetData serviceVisitReport;
//
//    public ResponseEntity<ByteArrayResource> exportBranchProfileReport(String branch_code,  String region, String u_loc) throws JRException {
//
//        try {
//            //********************************************** Load main JRXML file ************************************************************************************
//
//            //***************************************************************************************************************************************************************
//
//            InputStream templateStream;
////            templateStream = getClass().getResourceAsStream("/REPORTS/ReportDownload.jrxml");
//            templateStream = getClass().getResourceAsStream("/REPORTS/ReportDownloadInprocess.jrxml");
//
//            JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);
//
//
//            //*********************************************** Main JRXML parameter mapping ***************************************************************************
//            MssoBranchProfileSmaDto mssoBranchProfileSmaDto = serviceMssoBranchProfileSma.getMssoDailySma(branch_code, region, u_loc);
//            System.out.println("mssoBranchProfileSmaDto :" + mssoBranchProfileSmaDto);
//            List<MssoBranchProfileSmaDto> mssoBranchProfileSmaDtoList = Collections.singletonList(mssoBranchProfileSmaDto);
//
//            MssoProfileReviewRenewalDto pendingReviewRenewal = serviceMssoBranchProfileSma.getPendingReview(branch_code, region, u_loc);
//
//            System.out.println("pendingReviewRenewal :" + pendingReviewRenewal.getTotal_amount() + pendingReviewRenewal.getTotal_count());
//
//            MssoProfileDailyDisburseDto mssoProfileDailyDisburseDto = serviceMssoDailyDisbursement.getMssoDailyDisbursement(branch_code, region, u_loc);
//            System.out.println("mssoProfileDailyDisburseDto DATA :" + mssoProfileDailyDisburseDto);
//            List<MssoProfileDailyDisburseDto> mssoProfileDailyDisburseDtoList = Collections.singletonList(mssoProfileDailyDisburseDto);
//
//
//            MssoProfileDailyDisburseDto mssoProfileDailyDisburseTargetDto = serviceMssoDailyDisbursement.getMssoDisbursementTarget(branch_code, region, u_loc);
////            MssoProfileDailyDisburseDto mssoProfileDailyDisburseTargetDto = serviceMssoDailyDisbursement.getMssoDisbursementTarget(branchCode, roname, u_loc);
//
//            System.out.println("mssoProfileDailyDisburseTargetDto DATA :" + mssoProfileDailyDisburseTargetDto);
//            List<MssoProfileDailyDisburseDto> mssoProfileDailyDisburseTargetList = Collections.singletonList(mssoProfileDailyDisburseTargetDto);
//
//            Boolean isHeadName;
//            if (u_loc.equalsIgnoreCase("HO")) {
//                isHeadName = false;
//            } else {
//                isHeadName = true;
//            }
//            Boolean isHoRoEmployeeSummary;
//            if (u_loc.equalsIgnoreCase("BR")) {
//                isHoRoEmployeeSummary = false;
//            } else {
//                isHoRoEmployeeSummary = true;
//            }
//
//            // 3 years
//            List<MssoBranchProfileActualDataDto> mssoBranchProfileActualDataDto = serviceBranchProfileLast3Year.getMssoBranchProfileMarchData(branch_code, region, u_loc);
//            System.out.println("mssoBranchProfileActualDataDto DATA :" + mssoBranchProfileActualDataDto.get(0));
//
//            //march
//            MssoBranchProfileActualDataDto mssoBranchProfileActualDataDtoMarchGap = serviceBranchProfileLast3Year.getMssoBranchProfileGapMarch(branch_code, region, u_loc);
//            System.out.println("mssoBranchProfileActualDataDtoMarchGap DATA :" + mssoProfileDailyDisburseDto);
//
//            MssoBranchProfileTargetDataDto mssoBranchProfileQuarterTargetData = serviceMssoBranchProfileTargetData.getMssoBranchProfileTargetData(branch_code, region, u_loc);
//            System.out.println("mssoBranchProfileQuarterTargetData DATA :" + mssoBranchProfileQuarterTargetData);
//
//
//            MssoBranchProfileTargetDataDto mssoBranchProfileQuarterTargetGap = serviceMssoBranchProfileTargetData.getMssoBranchProfileGapQuarter(branch_code, region, u_loc);
//
//
//            String branchCategory = mssoBranchDataService.getBranchCategory(branch_code, u_loc, region);
////    if(u_loc.equalsIgnoreCase("HO")||u_loc.equalsIgnoreCase("RO")){
//            BranchCategoryDto branchCategoryDto = mssoBranchDataService.getBranchCategoryCount(branch_code, u_loc, region);
//
//            // }
//
//
//            MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataSuperAchieverMarch = serviceMssoBranchProfileTargetData.getSuperAchieverMarch(branch_code, region, u_loc);
//
//            MssoBranchProfileTargetDataDto mssoBranchProfileMarchTargetData = serviceMssoBranchProfileTargetData.getMssoTargetMarch(branch_code, region, u_loc);
//            MssoBranchProfileActualDataDto mssoBranchProfileActualDataDtoMarchGapPer = serviceBranchProfileLast3Year.getMssoBranchProfileGapMarchPercentage(branch_code, region, u_loc);
//            MssoBranchProfileActualDataDto mssoBranchProfileCurrentData = null;
//            String category = "";
//            String designation = "";
//            String desig = "";
//            if (u_loc.equalsIgnoreCase("HO")) {
//                mssoBranchProfileCurrentData = this.repoMssoBranchProfile.getBranchProfileHo();
//                category = "HO Staff";
//
//            } else if (u_loc.equalsIgnoreCase("BR")) {
//                mssoBranchProfileCurrentData = this.repoMssoBranchProfile.getBranchProfileBranch(branch_code);
//                category = "Branch Staff";
//                designation="Branch";
//                desig="BM";
//
//
//            } else {
//                mssoBranchProfileCurrentData = this.repoMssoBranchProfile.getBranchProfileRO(region);
//                category = "RO Staff";
//                designation="Regional";
//                desig="RM";
//
//            }
//            System.out.println("inside dep-adv-npa");
//            BranchCategoryDto branchCategoryDto1 = null;
//
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
//
//            Boolean isBcCount;
//            Boolean isPerEmployeeBusiness;
//            String amountIn;
//
//            if (u_loc.equalsIgnoreCase("HO")||u_loc.equalsIgnoreCase("RO")) {
//                isBcCount = false;
//                isPerEmployeeBusiness=false;
//                amountIn="Crore";
//            } else {
//                isBcCount = true;
//                isPerEmployeeBusiness=true;
//                amountIn="Lakh";
//
//            }
//
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
//
//
//            List<ParameterDetails> parameterDetailsList = new ArrayList<>();
////    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
////    String year0 = sdf.format(mssoBranchProfileActualDataDto.get(0).getReport_date()); // "20250701"
////    BigDecimal marchYear0= new BigDecimal(year0);
////
////    String year1 = sdf.format(mssoBranchProfileActualDataDto.get(1).getReport_date()); // "20250701"
////    BigDecimal marchYear1 = new BigDecimal(year1);
////
////    String year2 = sdf.format(mssoBranchProfileActualDataDto.get(2).getReport_date()); // "20250701"
////    BigDecimal marchYear2 = new BigDecimal(year2);
////
////    String current = sdf.format(mssoBranchProfileCurrentData.getReport_date()); // "20250701"
////    BigDecimal currentDate = new BigDecimal(current);
////
////    String nextQua = sdf.format(mssoBranchProfileQuarterTargetData.getReport_date()); // "20250701"
////    BigDecimal nextQuater = new BigDecimal(nextQua);
////
////    String nextMar = sdf.format(mssoBranchProfileQuarterTargetData.getReport_date()); // "20250701"
////    BigDecimal nextMarch = new BigDecimal(nextMar);
////    BigDecimal nextMarchsuper = new BigDecimal(nextMar);
//
//
//
//
//            SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//            BigDecimal marchYear0 = convertDateToBigDecimalMonthYear(mssoBranchProfileActualDataDto.get(0).getReport_date());
//            BigDecimal marchYear1 = convertDateToBigDecimalMonthYear(mssoBranchProfileActualDataDto.get(1).getReport_date());
//            BigDecimal marchYear2 = convertDateToBigDecimalMonthYear(mssoBranchProfileActualDataDto.get(2).getReport_date());
//            BigDecimal currentDate = convertDateToBigDecimalMonthYear(mssoBranchProfileCurrentData.getReport_date());
//            BigDecimal nextQuarter = convertDateToBigDecimalMonthYear(mssoBranchProfileQuarterTargetData.getReport_date());
//            BigDecimal nextMarch = convertDateToBigDecimalMonthYear(mssoBranchProfileQuarterTargetData.getReport_date());
//            BigDecimal nextMarchSuper = convertDateToBigDecimalMonthYear(mssoBranchProfileQuarterTargetData.getReport_date());
//
////    BigDecimal marchYear0 = convertDateToBigDecimalMonthYear(mssoBranchProfileActualDataDto.get(0).getReport_date());
////    BigDecimal currentDate = convertDateToBigDecimalMonthYear(mssoBranchProfileCurrentData.getReport_date());
////    BigDecimal nextQuarter = convertDateToBigDecimalMonthYear(mssoBranchProfileQuarterTargetData.getReport_date());
//
//
//
//
////    String Gap = "GapTarget"; // "20250701"
////    BigDecimal GapTarget = new BigDecimal(Gap);
////    String ytd = "Y-T-D Growth"; // "20250701"
////    BigDecimal ytd = new BigDecimal(Gap);
//            System.out.println("marchYear1marchYear1"+marchYear1);
//
////    parameterDetailsList.add(new ParameterDetails(
////            "Parameter",
////            marchYear0,
////            marchYear1,
////            marchYear2 ,
////            currentDate,
////            nextQuarter,
////            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
////            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),  // gapTarget
////            mssoBranchProfileActualDataDtoMarchGapPer.getTotal_business(),
////            nextMarch,
////            nextMarchSuper
////    ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Total Business",
//                    mssoBranchProfileActualDataDto.get(0).getTotal_business(),
//                    mssoBranchProfileActualDataDto.get(1).getTotal_business(),
//                    mssoBranchProfileActualDataDto.get(2).getTotal_business(),
//                    mssoBranchProfileCurrentData.getTotal_business(),
//                    mssoBranchProfileQuarterTargetData.getTotal_business(),
//                    mssoBranchProfileQuarterTargetGap.getTotal_business(),
//                    mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),  // gapTarget
//                    mssoBranchProfileActualDataDtoMarchGapPer.getTotal_business(),
//                    mssoBranchProfileMarchTargetData.getTotal_business(), // targetYear
//                    mssoBranchProfileTargetDataSuperAchieverMarch.getTotal_business()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Total Deposit",
//                    mssoBranchProfileActualDataDto.get(0).getDeposit(),
//                    mssoBranchProfileActualDataDto.get(1).getDeposit(),
//                    mssoBranchProfileActualDataDto.get(2).getDeposit(),
//                    mssoBranchProfileCurrentData.getDeposit(),
//                    mssoBranchProfileQuarterTargetData.getDeposit(),
//                    mssoBranchProfileQuarterTargetGap.getDeposit(),
//                    mssoBranchProfileActualDataDtoMarchGap.getDeposit(),  // gapTarget
//                    mssoBranchProfileActualDataDtoMarchGapPer.getDeposit(),
//                    mssoBranchProfileMarchTargetData.getDeposit(), // targetYear
//                    mssoBranchProfileTargetDataSuperAchieverMarch.getDeposit()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "CA",
//                    mssoBranchProfileActualDataDto.get(0).getCa(),
//                    mssoBranchProfileActualDataDto.get(1).getCa(),
//                    mssoBranchProfileActualDataDto.get(2).getCa(),
//                    mssoBranchProfileCurrentData.getCa(),
//                    mssoBranchProfileQuarterTargetData.getCa(),
//                    mssoBranchProfileQuarterTargetGap.getCa(),
//                    mssoBranchProfileActualDataDtoMarchGap.getCa(),  // gapTarget
//                    mssoBranchProfileActualDataDtoMarchGapPer.getCa(),
//                    mssoBranchProfileMarchTargetData.getCa(), // targetYear
//                    mssoBranchProfileTargetDataSuperAchieverMarch.getCa()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "SB",
//                    mssoBranchProfileActualDataDto.get(0).getSb(),
//                    mssoBranchProfileActualDataDto.get(1).getSb(),
//                    mssoBranchProfileActualDataDto.get(2).getSb(),
//                    mssoBranchProfileCurrentData.getSb(),
//                    mssoBranchProfileQuarterTargetData.getSb(),
//                    mssoBranchProfileQuarterTargetGap.getSb(),
//                    mssoBranchProfileActualDataDtoMarchGap.getSb(),  // gapTarget
//                    mssoBranchProfileActualDataDtoMarchGapPer.getSb(),
//                    mssoBranchProfileMarchTargetData.getSb(), // targetYear
//                    mssoBranchProfileTargetDataSuperAchieverMarch.getSb()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "CASA Deposit",
//                    mssoBranchProfileActualDataDto.get(0).getCasa(),
//                    mssoBranchProfileActualDataDto.get(1).getCasa(),
//                    mssoBranchProfileActualDataDto.get(2).getCasa(),
//                    mssoBranchProfileCurrentData.getCasa(),
//                    mssoBranchProfileQuarterTargetData.getCasa(),
//                    mssoBranchProfileQuarterTargetGap.getCasa(),
//                    mssoBranchProfileActualDataDtoMarchGap.getCasa(),  // gapTarget
//                    mssoBranchProfileActualDataDtoMarchGapPer.getCasa(),
//                    mssoBranchProfileMarchTargetData.getCasa(), // targetYear
//                    mssoBranchProfileTargetDataSuperAchieverMarch.getCasa()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Term Deposit",
//                    mssoBranchProfileActualDataDto.get(0).getTd(),
//                    mssoBranchProfileActualDataDto.get(1).getTd(),
//                    mssoBranchProfileActualDataDto.get(2).getTd(),
//                    mssoBranchProfileCurrentData.getTd(),
//                    mssoBranchProfileQuarterTargetData.getTd(),
//                    mssoBranchProfileQuarterTargetGap.getTd(),
//                    mssoBranchProfileActualDataDtoMarchGap.getTd(),  // gapTarget
//                    mssoBranchProfileActualDataDtoMarchGapPer.getTd(),
//                    mssoBranchProfileMarchTargetData.getTd(), // targetYear
//                    mssoBranchProfileTargetDataSuperAchieverMarch.getTd()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Gross Advances",
//                    mssoBranchProfileActualDataDto.get(0).getAdvances(),
//                    mssoBranchProfileActualDataDto.get(1).getAdvances(),
//                    mssoBranchProfileActualDataDto.get(2).getAdvances(),
//                    mssoBranchProfileCurrentData.getAdvances(),
//                    mssoBranchProfileQuarterTargetData.getAdvances(),
//                    mssoBranchProfileQuarterTargetGap.getAdvances(),
//                    mssoBranchProfileActualDataDtoMarchGap.getAdvances(),  // gapTarget
//                    mssoBranchProfileActualDataDtoMarchGapPer.getAdvances(),
//                    mssoBranchProfileMarchTargetData.getAdvances(), // targetYear
//                    mssoBranchProfileTargetDataSuperAchieverMarch.getAdvances()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Retail",
//                    mssoBranchProfileActualDataDto.get(0).getTotal_retail(),
//                    mssoBranchProfileActualDataDto.get(1).getTotal_retail(),
//                    mssoBranchProfileActualDataDto.get(2).getTotal_retail(),
//                    mssoBranchProfileCurrentData.getTotal_retail(),
//                    mssoBranchProfileQuarterTargetData.getTotal_retail(),
//                    mssoBranchProfileQuarterTargetGap.getTotal_retail(),
//                    mssoBranchProfileActualDataDtoMarchGap.getTotal_retail(),  // gapTarget
//                    mssoBranchProfileActualDataDtoMarchGapPer.getTotal_retail(),
//                    mssoBranchProfileMarchTargetData.getTotal_retail(), // targetYear
//                    mssoBranchProfileTargetDataSuperAchieverMarch.getTotal_retail()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Housing",
//                    mssoBranchProfileActualDataDto.get(0).getHousing(),
//                    mssoBranchProfileActualDataDto.get(1).getHousing(),
//                    mssoBranchProfileActualDataDto.get(2).getHousing(),
//                    mssoBranchProfileCurrentData.getHousing(),
//                    mssoBranchProfileQuarterTargetData.getHousing(),
//                    mssoBranchProfileQuarterTargetGap.getHousing(),
//                    mssoBranchProfileActualDataDtoMarchGap.getHousing(),  // gapTarget
//                    mssoBranchProfileActualDataDtoMarchGapPer.getHousing(),
//                    mssoBranchProfileMarchTargetData.getHousing(), // targetYear
//                    mssoBranchProfileTargetDataSuperAchieverMarch.getHousing()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Vehicle",
//                    mssoBranchProfileActualDataDto.get(0).getVehicle(),
//                    mssoBranchProfileActualDataDto.get(1).getVehicle(),
//                    mssoBranchProfileActualDataDto.get(2).getVehicle(),
//                    mssoBranchProfileCurrentData.getVehicle(),
//                    mssoBranchProfileQuarterTargetData.getVehicle(),
//                    mssoBranchProfileQuarterTargetGap.getVehicle(),
//                    mssoBranchProfileActualDataDtoMarchGap.getVehicle(),  // gapTarget
//                    mssoBranchProfileActualDataDtoMarchGapPer.getVehicle(),
//                    mssoBranchProfileMarchTargetData.getVehicle(), // targetYear
//                    mssoBranchProfileTargetDataSuperAchieverMarch.getVehicle()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Education",
//                    mssoBranchProfileActualDataDto.get(0).getEducation(),
//                    mssoBranchProfileActualDataDto.get(1).getEducation(),
//                    mssoBranchProfileActualDataDto.get(2).getEducation(),
//                    mssoBranchProfileCurrentData.getEducation(),
//                    mssoBranchProfileQuarterTargetData.getEducation(),
//                    mssoBranchProfileQuarterTargetGap.getEducation(),
//                    mssoBranchProfileActualDataDtoMarchGap.getEducation(),  // gapTarget
//                    mssoBranchProfileActualDataDtoMarchGapPer.getEducation(),
//                    mssoBranchProfileMarchTargetData.getEducation(), // targetYear
//                    mssoBranchProfileTargetDataSuperAchieverMarch.getEducation()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Agriculture",
//                    mssoBranchProfileActualDataDto.get(0).getAgri(),
//                    mssoBranchProfileActualDataDto.get(1).getAgri(),
//                    mssoBranchProfileActualDataDto.get(2).getAgri(),
//                    mssoBranchProfileCurrentData.getAgri(),
//                    mssoBranchProfileQuarterTargetData.getAgri(),
//                    mssoBranchProfileQuarterTargetGap.getAgri(),
//                    mssoBranchProfileActualDataDtoMarchGap.getAgri(),  // gapTarget
//                    mssoBranchProfileActualDataDtoMarchGapPer.getAgri(),
//                    mssoBranchProfileMarchTargetData.getAgri(), // targetYear
//                    mssoBranchProfileTargetDataSuperAchieverMarch.getAgri()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "MSME",
//                    mssoBranchProfileActualDataDto.get(0).getMsme(),
//                    mssoBranchProfileActualDataDto.get(1).getMsme(),
//                    mssoBranchProfileActualDataDto.get(2).getMsme(),
//                    mssoBranchProfileCurrentData.getMsme(),
//                    mssoBranchProfileQuarterTargetData.getMsme(),
//                    mssoBranchProfileQuarterTargetGap.getMsme(),
//                    mssoBranchProfileActualDataDtoMarchGap.getMsme(),  // gapTarget
//                    mssoBranchProfileActualDataDtoMarchGapPer.getMsme(),
//                    mssoBranchProfileMarchTargetData.getMsme(), // targetYear
//                    mssoBranchProfileTargetDataSuperAchieverMarch.getMsme()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Gold",
//                    mssoBranchProfileActualDataDto.get(0).getGold(),
//                    mssoBranchProfileActualDataDto.get(1).getGold(),
//                    mssoBranchProfileActualDataDto.get(2).getGold(),
//                    mssoBranchProfileCurrentData.getGold(),
//                    mssoBranchProfileQuarterTargetData.getGold(),
//                    mssoBranchProfileQuarterTargetGap.getGold(),
//                    mssoBranchProfileActualDataDtoMarchGap.getGold(),  // gapTarget
//                    mssoBranchProfileActualDataDtoMarchGapPer.getGold(),
//                    mssoBranchProfileMarchTargetData.getGold(), // targetYear
//                    mssoBranchProfileTargetDataSuperAchieverMarch.getGold()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "SHG",
//                    mssoBranchProfileActualDataDto.get(0).getShg(),
//                    mssoBranchProfileActualDataDto.get(1).getShg(),
//                    mssoBranchProfileActualDataDto.get(2).getShg(),
//                    mssoBranchProfileCurrentData.getShg(),
//                    mssoBranchProfileQuarterTargetData.getShg(),
//                    mssoBranchProfileQuarterTargetGap.getShg(),
//                    mssoBranchProfileActualDataDtoMarchGap.getShg(),  // gapTarget
//                    mssoBranchProfileActualDataDtoMarchGapPer.getShg(),
//                    mssoBranchProfileMarchTargetData.getShg(), // targetYear
//                    mssoBranchProfileTargetDataSuperAchieverMarch.getShg()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Total RAM",
//                    mssoBranchProfileActualDataDto.get(0).getTotal_ram(),
//                    mssoBranchProfileActualDataDto.get(1).getTotal_ram(),
//                    mssoBranchProfileActualDataDto.get(2).getTotal_ram(),
//                    mssoBranchProfileCurrentData.getTotal_ram(),
//                    mssoBranchProfileQuarterTargetData.getTotal_ram(),
//                    mssoBranchProfileQuarterTargetGap.getTotal_ram(),
//                    mssoBranchProfileActualDataDtoMarchGap.getTotal_ram(),  // gapTarget
//                    mssoBranchProfileActualDataDtoMarchGapPer.getTotal_ram(),
//                    mssoBranchProfileMarchTargetData.getTotal_ram(), // targetYear
//                    mssoBranchProfileTargetDataSuperAchieverMarch.getTotal_ram()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "NPA",
//                    mssoBranchProfileActualDataDto.get(0).getNpa(),
//                    mssoBranchProfileActualDataDto.get(1).getNpa(),
//                    mssoBranchProfileActualDataDto.get(2).getNpa(),
//                    mssoBranchProfileCurrentData.getNpa(),
//                    mssoBranchProfileQuarterTargetData.getNpa(),
//                    mssoBranchProfileQuarterTargetGap.getNpa(),
//                    mssoBranchProfileActualDataDtoMarchGap.getNpa(),  // gapTarget
//                    mssoBranchProfileActualDataDtoMarchGapPer.getNpa(),
//                    mssoBranchProfileMarchTargetData.getNpa(), // targetYear
//                    mssoBranchProfileTargetDataSuperAchieverMarch.getNpa()  // targetYearSuperAchiever
//            ));
//            for (ParameterDetails pd : parameterDetailsList) {
//                System.out.println("Checking parameter: " + pd.getParameter());
//            }
//
//            System.out.println("DATA :"+parameterDetailsList.get(0).toString());
//
//
//
//
//            String u_id="";
//            MssoBranchEmployeeDataDto mssoBranchEmployeeDataDto=mssoBranchDataService.getMssoBranchData(branch_code,u_loc,u_id,region);
//            System.out.println("SMA DATA :"+mssoBranchEmployeeDataDto);
//            List<MssoBranchEmployeeDataDto> mssoBranchEmployeeDataDtoList = Collections.singletonList(mssoBranchEmployeeDataDto);
//
//
////            MssoProfileDailyDisburseDto mssoProfileDailyDisburseTarget = serviceMssoDailyDisbursement.getMssoDisbursementTarget(branch_code, region, u_loc);
////
////            System.out.println("SMA DATA :"+mssoBranchEmployeeDataDto);
////            List<MssoProfileDailyDisburseDto> mssoProfileDailyDisburseTargetList = Collections.singletonList(mssoProfileDailyDisburseTarget);
//
//
//            int total_staff=mssoBranchEmployeeDataDto.getDesg_agm()+
//                    mssoBranchEmployeeDataDto.getDesg_cm()+
//                    mssoBranchEmployeeDataDto.getDesg_srmanager()+
//                    mssoBranchEmployeeDataDto.getDesg_manager()+mssoBranchEmployeeDataDto.getDesg_dymanager()+mssoBranchEmployeeDataDto.getDesg_clerk()+mssoBranchEmployeeDataDto.getSubstaff();
//
//
//
//
//
//            System.out.println("TOTAL STAFF "+total_staff);
//
//
//            MssoEmployeeSummaryDto mssoEmployeeSummaryDto = (mssoBranchDataService.getMssoRegionEmployeeSummary(branch_code,u_loc, region));
//            List<MssoEmployeeSummaryDto> mssoEmployeeSummaryDtoList = Collections.singletonList(mssoEmployeeSummaryDto);
//            int branch_total_staff = 0;
//
//            if (u_loc.equalsIgnoreCase("HO") || u_loc.equalsIgnoreCase("RO")) {
//                branch_total_staff = mssoEmployeeSummaryDto.getDesg_agm()
//                        + mssoEmployeeSummaryDto.getDesg_cm()
//                        + mssoEmployeeSummaryDto.getDesg_srmanager()
//                        + mssoEmployeeSummaryDto.getDesg_manager()
//                        + mssoEmployeeSummaryDto.getDesg_dymanager()
//                        + mssoEmployeeSummaryDto.getDesg_clerk()
//                        + mssoEmployeeSummaryDto.getSubstaff();
//            }
//
//            long safeBranchTotal = branch_total_staff != 0 ? branch_total_staff : 0L;
//
//            BigDecimal total_bank_staff = BigDecimal.valueOf(total_staff)
//                    .add(BigDecimal.valueOf(safeBranchTotal));
//
//
//
//            MssoBranchProfileDigitalProductDto mssoBranchProfileDigitalProductDto = serviceaccountStatusDigitalProduct.getMssoDigitalProduct(branch_code,region,u_loc);
//            MssoBranchProfileAccountStatusDto mssoBranchProfileAccountStatusDto = serviceaccountStatusDigitalProduct.getMssoAccountStatus(branch_code,region,u_loc);
//            MssoAccountStatusDigitalTargetDto mssoAccountStatusDigitalTargetDto = serviceaccountStatusDigitalProduct.getMssoAccountDigitalProductTarget(branch_code,region,u_loc);
////            MssoProfileComplianceDto mssoProfileReviewRenewalPending = serviceMssoBranchProfileSma.getPendingReview(branch_code,region,u_loc);
//            MssoProfileComplianceDto mssoProfileTimebarred = serviceMssoBranchProfileSma.getTimebarredData(branch_code,region,u_loc);
//
//            BigDecimal perEmployeeBusiness=mssoBranchProfileCurrentData.getTotal_business().divide(total_bank_staff, 2, RoundingMode.HALF_UP);
//            MssoBranchProfileAccountStatusDto mssoBranchProfileAccountStatusMarch = serviceaccountStatusDigitalProduct.getMssoAccountStatusMarch(branch_code,region,u_loc);
//            MssoProfileNpaClassificationDto mssoNpaClassification = serviceMssoBranchProfileSma.getMssoNpaClassification(branch_code,region,u_loc);
//            List<MssoProfileNpaClassificationDto> mssoNpaClassificationList = Collections.singletonList(mssoNpaClassification);
//            BranchOpeningDateDto branchOpeningDateDto = mssoBranchDataService.getBranchOpenDate(branch_code,region,u_loc);
//
//            BmBranchJoinDateDto bmBranchJoinDateDto = mssoBranchDataService.getBmBranchJoinDate(branch_code,mssoBranchEmployeeDataDto.getU_id());
//
//            MssoFiSchemeDto mssoFiSchemeDto = serviceaccountStatusDigitalProduct.getFiSchemeData(branch_code,region,u_loc);
//            MssoFiSchemeDto mssoFiSchemeDtoTarget = serviceaccountStatusDigitalProduct.getMssoFiSchemeTarget(branch_code,region,u_loc);
//
//
//            Map<String, Object> parameters = new HashMap<>();
//            parameters.put("stressData", new JRBeanCollectionDataSource(mssoBranchProfileSmaDtoList));
//            parameters.put("newLoanSanctioned", new JRBeanCollectionDataSource(mssoProfileDailyDisburseDtoList));
//            parameters.put("newLoanSanctionedTarget", new JRBeanCollectionDataSource(mssoProfileDailyDisburseTargetList));
////            parameters.put("newLoanSanctionedTarget", new JRBeanCollectionDataSource(mssoProfileDailyDisburseTargetList));
//
//            parameters.put("newLoanSanctionedProductWise", new JRBeanCollectionDataSource(mssoProfileDailyDisburseDtoList));
//
//            parameters.put("newLoanSanctionedProductWiseTarget", new JRBeanCollectionDataSource(mssoProfileDailyDisburseTargetList));
//
//            parameters.put("employeeData", new JRBeanCollectionDataSource(mssoBranchEmployeeDataDtoList));
//            parameters.put("employeeDataSummary", new JRBeanCollectionDataSource(mssoEmployeeSummaryDtoList));
//            parameters.put("npaClassification", new JRBeanCollectionDataSource( mssoNpaClassificationList));
//
//            parameters.put("perEmployeeBusiness",perEmployeeBusiness);
//            if(mssoBranchEmployeeDataDto.getBranch_code().equalsIgnoreCase("4000")) {
//                parameters.put("region", "Head Office");
//                parameters.put("branchName","-");
//
//            }else{
//
//                if(mssoBranchEmployeeDataDto.getRegion().equalsIgnoreCase("AURANGABAD")){
//                    parameters.put("region", "Chht. Sambhaji Nagar");
//                }else {
//                    parameters.put("region", mssoBranchEmployeeDataDto.getRegion());
//                }
//                parameters.put("branchName",mssoBranchEmployeeDataDto.getBranch_name());
//
//            }
//
//            parameters.put("branchCode",mssoBranchEmployeeDataDto.getBranch_code());
////            Date branchOpenDate = branchOpeningDateDto.getBranchopendate();
//
//
//
////            String formattedDate = branchOpenDate.toInstant()
////                    .atZone(ZoneId.systemDefault())
////                    .toLocalDate()
////                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//
////            if(u_loc.equalsIgnoreCase("HO") ||u_loc.equalsIgnoreCase("RO")) {
////                String dateStr = "01/05/2025"; // 1st May 2025
////                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
////                Date utilDate = sdf.parse(dateStr);
////                parameters.put("sinceDate",utilDate );
////
////            }else{
////                parameters.put("sinceDate", branchOpeningDateDto.getBranchopendate());
////
////            }
//
//            String branchOpenDate=dateConverter(branchOpeningDateDto.getBranchopendate());
//            String bmBranchJoinDate= String.valueOf(bmBranchJoinDateDto.getBmBranchJoinDate());
//
//            if(bmBranchJoinDateDto!=null) {
//                bmBranchJoinDate = dateConverter(bmBranchJoinDateDto.getBmBranchJoinDate());
//            }
//            parameters.put("sinceDate", branchOpenDate!=null?branchOpenDate:"");
//            parameters.put("bmBranchJoinDate", bmBranchJoinDate!=null?bmBranchJoinDate:"");
//            parameters.put("designation", designation!=null?designation:"");
//            parameters.put("design", desig!=null?desig:"");
//
//
////            parameters.put("sinceDate",mssoBranchEmployeeDataDto.getBranch_name());
//            parameters.put("bcCount",branchCategoryDto1.getTotalCount());
//
//            parameters.put("branchOrRegionHead",mssoBranchEmployeeDataDto.getEmployee_name());
//            parameters.put("grade",mssoBranchEmployeeDataDto.getGrade_code());
//            parameters.put("isHeadName",isHeadName);
//            parameters.put("isBcCount",isBcCount);
//            parameters.put("isPerEmployeeBusiness",isPerEmployeeBusiness);
//            parameters.put("isHoRoEmployeeSummary",isHoRoEmployeeSummary);
//            parameters.put("branchCategory",branchCategory);
//            parameters.put("amountIn",amountIn);
//
//            if(u_loc.equalsIgnoreCase("HO")||u_loc.equalsIgnoreCase("RO")) {
//
//                parameters.put("totalBranch", branchCategoryDto.getTotalCount()!=null?branchCategoryDto.getTotalCount():0);
//                parameters.put("urban", branchCategoryDto.getUrban()!=null?branchCategoryDto.getUrban():0);
//                parameters.put("semiUrban", branchCategoryDto.getSemiUrban()!=null?branchCategoryDto.getSemiUrban():0);
//                parameters.put("metro", branchCategoryDto.getMetropolitan()!=null?branchCategoryDto.getMetropolitan():0);
//                parameters.put("rural", branchCategoryDto.getRural()!=null?branchCategoryDto.getRural():0);
//            }
//            String current_report_date=dateConverter(mssoBranchProfileCurrentData.getReport_date());
//
//            parameters.put("current_report_date",current_report_date);
//
//            String npa_report_date=dateConverter(mssoNpaClassification.getReport_date());
//
//            parameters.put("npa_report_date",npa_report_date);
//
//            System.out.println("current_report_date"+mssoBranchProfileSmaDto.getReport_date());
//
//
//            String sma_report_date=dateConverter(mssoBranchProfileSmaDto.getReport_date());
//
//            parameters.put("sma_report_date",sma_report_date);
//
//
//            parameters.put("total_staff",total_staff);
//            parameters.put("total_staff_bank",branch_total_staff);
//
//            parameters.put("category",category);
////    parameters.put("timebarredCount",total_staff);
////            parameters.put("reviewRenewalCount",pendingReviewRenewal.getTotal_count());
////            parameters.put("reviewRenewalAmount",pendingReviewRenewal.getTotal_amount());
////            parameters.put("reviewRenewalAmount",pendingReviewRenewal.getTotal_amount());
//            parameters.put("paramterDetails", new JRBeanCollectionDataSource(parameterDetailsList));
//
//
//            parameters.put("naccReviewRenewalCount",pendingReviewRenewal.getNacc_count());
//            parameters.put("naccReviewRenewalAmount",pendingReviewRenewal.getNacc_amount());
//            parameters.put("timebarredCount",mssoProfileTimebarred.getTotal_count());
//            parameters.put("timebarredAmount",mssoProfileTimebarred.getTotal_amount());
//            parameters.put("kccReviewRenewalCount",pendingReviewRenewal.getTotal_count());
//            parameters.put("kccReviewRenewalAmount",pendingReviewRenewal.getTotal_amount());
//            if(u_loc.equalsIgnoreCase("HO")) {
//                parameters.put("pendingMultipleCif", 22916L);
//            }else{
//                parameters.put("pendingMultipleCif", mssoBranchProfileDigitalProductDto.getMultiple_cif());
//
//            }
//            parameters.put("pendingCkyc",mssoBranchProfileDigitalProductDto.getCkyc());
//            parameters.put("inoperativeCasaCount",mssoBranchProfileAccountStatusDto.getCasa_count());
//            parameters.put("inoperativeCasaAmount",mssoBranchProfileAccountStatusDto.getCasa_amount());
//
//
//            parameters.put("quarterTargetSB",mssoAccountStatusDigitalTargetDto.getSb_ac_count());
//            parameters.put("asOnDateSB",mssoBranchProfileAccountStatusDto.getSb_ac_count());
//            parameters.put("AsOnMarchSB",mssoBranchProfileAccountStatusMarch.getSb_ac_count());
//            parameters.put("quarterTargetCa",mssoAccountStatusDigitalTargetDto.getCa_ac_count());
//            parameters.put("asonDateCa",mssoBranchProfileAccountStatusDto.getCa_ac_count());
//            parameters.put("asOnMarchCa",mssoBranchProfileAccountStatusMarch.getCa_ac_count());
//            parameters.put("asonDateDebitCard",mssoBranchProfileDigitalProductDto.getAtm_card());
//            parameters.put("asonDateMobileBanking",mssoBranchProfileDigitalProductDto.getMobile_banking());
//            parameters.put("asonDateInternetBanking",mssoBranchProfileDigitalProductDto.getinternet_banking());
//            parameters.put("quarterTargetDebitCard",mssoAccountStatusDigitalTargetDto.getAtm_card());
//            parameters.put("quarterTargetMobileBanking",mssoAccountStatusDigitalTargetDto.getMobile_banking());
//            parameters.put("quarterTargetInternetBanking",mssoAccountStatusDigitalTargetDto.getinternet_banking());
//
//
//            parameters.put("quarterTargetPmjdy",mssoFiSchemeDtoTarget.getPmjdy());
//            parameters.put("quarterTargetPmjjby",mssoFiSchemeDtoTarget.getPmjjby());
//            parameters.put("quarterTargetPmsby",mssoFiSchemeDtoTarget.getPmsby());
//            parameters.put("quarterTargetApy",mssoFiSchemeDtoTarget.getApy());
//            parameters.put("asOnDatePmjdy",mssoBranchProfileAccountStatusDto.getPmjdy());
//            parameters.put("asOnDatePmjjby",mssoFiSchemeDto.getPmjjby());
//            parameters.put("asOnDatePmsby",mssoFiSchemeDto.getPmsby());
//            parameters.put("asOnDateApy",mssoFiSchemeDto.getApy());
//            LocalDate quarterEnd = serviceMssoBranchProfileTargetData.getCurrentquarterEndDateDate();
//            System.out.println("Current Quarter End Date: " + dateConverterQuarter(quarterEnd));
//            parameters.put("quarter",dateConverterQuarter(quarterEnd));
//
//            LocalDate financialYearEndDate = serviceMssoBranchProfileTargetData.getFinancialYearEndDate();
//            System.out.println("financialYearEndDate : " + dateConverterQuarter(financialYearEndDate));
//            parameters.put("financialYrEnd",dateConverterQuarter(financialYearEndDate));
//
//            List<LocalDate> marchEndDates = serviceBranchProfileLast3Year.getLastThreeMarchEndDates();
//            marchEndDates.forEach(System.out::println);
//
//            parameters.put("year1",dateConverterYear(marchEndDates.get(2)));
//            parameters.put("year2",dateConverterYear(marchEndDates.get(1)));
//            parameters.put("year3",dateConverterYear(marchEndDates.get(0)));
//
////
////            String quarter=dateConverterMonth(quarterEnd);
////
//////            parameters.put("current_report_date",current_report_date);
////
////            System.out.println(" quarter quarter"+quarter);
////            parameters.put("quarter",quarter);
//            parameters.put("todayDate",total_staff);
//            parameters.put("financialYear",total_staff);
//
////            parameters.put("bcCount",branchCategoryDto1.getTotalCount());
//
//
//
//            //******************************** FILL THE MAIN REPORT ***********************************************************8
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
//
//            //******************************** Export to PDF ********************************************************************
//            byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_PDF);
//            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=AppraisalNote" + branch_code + ".pdf");
//
//            return ResponseEntity
//                    .ok()
//                    .headers(headers)
//                    .contentType(MediaType.APPLICATION_PDF)
//                    .body(new ByteArrayResource(pdfBytes));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(500).body(null);
//        }
//    }
//
//
//    //********************************************************************************************************************************************************
//
//    public ResponseEntity<ByteArrayResource> exportVisitReport(String branch_code,  LocalDate visit_date) throws JRException {
//
//        try {
//            //********************************************** Load main JRXML file ************************************************************************************
//
//            //***************************************************************************************************************************************************************
//
//            InputStream templateStream;
////            templateStream = getClass().getResourceAsStream("/REPORTS/ReportDownload.jrxml");
//            templateStream = getClass().getResourceAsStream("/REPORTS/visitReport.jrxml");
//
//            JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);
//
//
//            //*********************************************** Main JRXML parameter mapping ***************************************************************************
//
//            ExecutiveVisitingData report = serviceVisitReport.getVisitDataByBranch(branch_code,visit_date);
//            System.out.println("ExecutiveVisitingData :"+report);
//
////************************** YEAR 1 ****************************************************************************
//            ParameterDetailsVisit year1 = new ParameterDetailsVisit();
//            year1.setReportDate(report.getReport_dateMarch1());
//            year1.setSb(report.getSbMarch1());
//            year1.setCa(report.getCaMarch1());
//            year1.setTd(report.getTdMarch1());
//            year1.setCasa(report.getCasaMarch1());
//            year1.setDeposit(report.getDepositMarch1());
//            year1.setAdvances(report.getAdvancesMarch1());
//            year1.setTotalBusiness(report.getTotal_businessMarch1());
//            year1.setTotalRetail(report.getTotal_retailMarch1());
//            year1.setHousing(report.getHousingMarch1());
//            year1.setVehicle(report.getVehicleMarch1());
//            year1.setEducation(report.getEducationMarch1());
//            year1.setAgri(report.getAgriMarch1());
//            year1.setMsme(report.getMsmeMarch1());
//            year1.setGold(report.getGoldMarch1());
//            year1.setShg(report.getShgMarch1());
//            year1.setTotalRam(report.getTotal_ramMarch1());
//            year1.setNpa(report.getNpaMarch1());
//
////************************** YEAR 2 ****************************************************************************
//
//            ParameterDetailsVisit year2 = new ParameterDetailsVisit();
//            year2.setReportDate(report.getReport_dateMarch2());
//            year2.setSb(report.getSbMarch2());
//            year2.setCa(report.getCaMarch2());
//            year2.setTd(report.getTdMarch2());
//            year2.setCasa(report.getCasaMarch2());
//            year2.setDeposit(report.getDepositMarch2());
//            year2.setAdvances(report.getAdvancesMarch2());
//            year2.setTotalBusiness(report.getTotal_businessMarch2());
//            year2.setTotalRetail(report.getTotal_retailMarch2());
//            year2.setHousing(report.getHousingMarch2());
//            year2.setVehicle(report.getVehicleMarch2());
//            year2.setEducation(report.getEducationMarch2());
//            year2.setAgri(report.getAgriMarch2());
//            year2.setMsme(report.getMsmeMarch2());
//            year2.setGold(report.getGoldMarch2());
//            year2.setShg(report.getShgMarch2());
//            year2.setTotalRam(report.getTotal_ramMarch2());
//            year2.setNpa(report.getNpaMarch2());
//  //*********************************** YEAR 3**********************************************************************
//            ParameterDetailsVisit year3 = new ParameterDetailsVisit();
//            year3.setReportDate(report.getReport_dateMarch3());
//            year3.setSb(report.getSbMarch3());
//            year3.setCa(report.getCaMarch3());
//            year3.setTd(report.getTdMarch3());
//            year3.setCasa(report.getCasaMarch3());
//            year3.setDeposit(report.getDepositMarch3());
//            year3.setAdvances(report.getAdvancesMarch3());
//            year3.setTotalBusiness(report.getTotal_businessMarch3());
//            year3.setTotalRetail(report.getTotal_retailMarch3());
//            year3.setHousing(report.getHousingMarch3());
//            year3.setVehicle(report.getVehicleMarch3());
//            year3.setEducation(report.getEducationMarch3());
//            year3.setAgri(report.getAgriMarch3());
//            year3.setMsme(report.getMsmeMarch3());
//            year3.setGold(report.getGoldMarch3());
//            year3.setShg(report.getShgMarch3());
//            year3.setTotalRam(report.getTotal_ramMarch3());
//            year3.setNpa(report.getNpaMarch3());
////***********************************************************************************************
//
//
//            ParameterDetailsVisit currentDate = new ParameterDetailsVisit();
//            currentDate.setReportDate(report.getReport_date_actual());
//            currentDate.setSb(report.getSb());
//            currentDate.setCa(report.getCa());
//            currentDate.setTd(report.getTd());
//            currentDate.setCasa(report.getCasa());
//            currentDate.setDeposit(report.getDeposit());
//            currentDate.setAdvances(report.getAdvances());
//            currentDate.setTotalBusiness(report.getTotal_business());
//            currentDate.setTotalRetail(report.getTotal_retail());
//            currentDate.setHousing(report.getHousing());
//            currentDate.setVehicle(report.getVehicle());
//            currentDate.setEducation(report.getEducation());
//            currentDate.setAgri(report.getAgri());
//            currentDate.setMsme(report.getMsme());
//            currentDate.setGold(report.getGold());
//            currentDate.setShg(report.getShg());
//            currentDate.setTotalRam(report.getTotal_ram());
//            currentDate.setNpa(report.getNpa());
//
//
//            ParameterDetailsVisit target = new ParameterDetailsVisit();
//            target.setReportDate(report.getReport_dateTarget());
//            target.setSb(report.getSbTarget());
//            target.setCa(report.getCaTarget());
//            target.setTd(report.getTdTarget());
//            target.setCasa(report.getCasaTarget());
//            target.setDeposit(report.getDepositTarget());
//            target.setAdvances(report.getAdvancesTarget());
//            target.setTotalBusiness(report.getTotal_businessTarget());
//            target.setTotalRetail(report.getTotal_retailTarget());
//            target.setHousing(report.getHousingTarget());
//            target.setVehicle(report.getVehicleTarget());
//            target.setEducation(report.getEducationTarget());
//            target.setAgri(report.getAgriTarget());
//            target.setMsme(report.getMsmeTarget());
//            target.setGold(report.getGoldTarget());
//            target.setShg(report.getShgTarget());
//            target.setTotalRam(report.getTotal_ramTarget());
//            target.setNpa(report.getNpaTarget());
//
//
//
//            ParameterDetailsVisit targetGap = new ParameterDetailsVisit();
//            targetGap.setReportDate(report.getReport_dateTargetgap());
//            targetGap.setSb(report.getSbTargetgap());
//            targetGap.setCa(report.getCaTargetgap());
//            targetGap.setTd(report.getTdTargetgap());
//            targetGap.setCasa(report.getCasaTargetgap());
//            targetGap.setDeposit(report.getDepositTargetgap());
//            targetGap.setAdvances(report.getAdvancesTargetgap());
//            targetGap.setTotalBusiness(report.getTotal_businessTargetgap());
//            targetGap.setTotalRetail(report.getTotal_retailTargetgap());
//            targetGap.setHousing(report.getHousingTargetgap());
//            targetGap.setVehicle(report.getVehicleTargetgap());
//            targetGap.setEducation(report.getEducationTargetgap());
//            targetGap.setAgri(report.getAgriTargetgap());
//            targetGap.setMsme(report.getMsmeTargetgap());
//            targetGap.setGold(report.getGoldTargetgap());
//            targetGap.setShg(report.getShgTargetgap());
//            targetGap.setTotalRam(report.getTotal_ramTargetgap());
//            targetGap.setNpa(report.getNpaTargetgap());
//
//
//            ParameterDetailsVisit marchGap = new ParameterDetailsVisit();
//            marchGap.setReportDate(report.getReport_dateMarchGap());
//            marchGap.setSb(report.getSbMarchGap());
//            marchGap.setCa(report.getCaMarchGap());
//            marchGap.setTd(report.getTdMarchGap());
//            marchGap.setCasa(report.getCasaMarchGap());
//            marchGap.setDeposit(report.getDepositMarchGap());
//            marchGap.setAdvances(report.getAdvancesMarchGap());
//            marchGap.setTotalBusiness(report.getTotal_businessMarchGap());
//            marchGap.setTotalRetail(report.getTotal_retailMarchGap());
//            marchGap.setHousing(report.getHousingMarchGap());
//            marchGap.setVehicle(report.getVehicleMarchGap());
//            marchGap.setEducation(report.getEducationMarchGap());
//            marchGap.setAgri(report.getAgriMarchGap());
//            marchGap.setMsme(report.getMsmeMarchGap());
//            marchGap.setGold(report.getGoldMarchGap());
//            marchGap.setShg(report.getShgMarchGap());
//            marchGap.setTotalRam(report.getTotal_ramMarchGap());
//            marchGap.setNpa(report.getNpaMarchGap());
//
//            ParameterDetailsVisit marchPercent = new ParameterDetailsVisit();
//            marchPercent.setReportDate(report.getReport_dateMarchPercent());
//            marchPercent.setSb(report.getSbMarchPercent());
//            marchPercent.setCa(report.getCaMarchPercent());
//            marchPercent.setTd(report.getTdMarchPercent());
//            marchPercent.setCasa(report.getCasaMarchPercent());
//            marchPercent.setDeposit(report.getDepositMarchPercent());
//            marchPercent.setAdvances(report.getAdvancesMarchPercent());
//            marchPercent.setTotalBusiness(report.getTotal_businessMarchPercent());
//            marchPercent.setTotalRetail(report.getTotal_retailMarchPercent());
//            marchPercent.setHousing(report.getHousingMarchPercent());
//            marchPercent.setVehicle(report.getVehicleMarchPercent());
//            marchPercent.setEducation(report.getEducationMarchPercent());
//            marchPercent.setAgri(report.getAgriMarchPercent());
//            marchPercent.setMsme(report.getMsmeMarchPercent());
//            marchPercent.setGold(report.getGoldMarchPercent());
//            marchPercent.setShg(report.getShgMarchPercent());
//            marchPercent.setTotalRam(report.getTotal_ramMarchPercent());
//            marchPercent.setNpa(report.getNpaMarchPercent());
//
//            ParameterDetailsVisit comingMarch = new ParameterDetailsVisit();
//            comingMarch.setReportDate(report.getReport_dateComingMarch());
//            comingMarch.setSb(report.getSbComingMarch());
//            comingMarch.setCa(report.getCaComingMarch());
//            comingMarch.setTd(report.getTdComingMarch());
//            comingMarch.setCasa(report.getCasaComingMarch());
//            comingMarch.setDeposit(report.getDepositComingMarch());
//            comingMarch.setAdvances(report.getAdvancesComingMarch());
//            comingMarch.setTotalBusiness(report.getTotal_businessComingMarch());
//            comingMarch.setTotalRetail(report.getTotal_retailComingMarch());
//            comingMarch.setHousing(report.getHousingComingMarch());
//            comingMarch.setVehicle(report.getVehicleComingMarch());
//            comingMarch.setEducation(report.getEducationComingMarch());
//            comingMarch.setAgri(report.getAgriComingMarch());
//            comingMarch.setMsme(report.getMsmeComingMarch());
//            comingMarch.setGold(report.getGoldComingMarch());
//            comingMarch.setShg(report.getShgComingMarch());
//            comingMarch.setTotalRam(report.getTotal_ramComingMarch());
//            comingMarch.setNpa(report.getNpaComingMarch());
//
//            ParameterDetailsVisit superAchiever = new ParameterDetailsVisit();
////            superAchiever.setReportDate(report.getTotal_businessSuperMarch());
////            superAchiever.setSb(report.getSbComingMarch());
////            superAchiever.setCa(report.getCaComingMarch());
////            superAchiever.setTd(report.getTdComingMarch());
////            superAchiever.setCasa(report.getCasaComingMarch());
////            superAchiever.setDeposit(report.getDepositComingMarch());
////            superAchiever.setAdvances(report.getAdvancesComingMarch());
//            superAchiever.setTotalBusiness(report.getTotal_businessSuperMarch());
////            superAchiever.setTotalRetail(report.getTotal_retailComingMarch());
////            superAchiever.setHousing(report.getHousingComingMarch());
////            superAchiever.setVehicle(report.getVehicleComingMarch());
////            superAchiever.setEducation(report.getEducationComingMarch());
////            superAchiever.setAgri(report.getAgriComingMarch());
////            superAchiever.setMsme(report.getMsmeComingMarch());
////            superAchiever.setGold(report.getGoldComingMarch());
////            superAchiever.setShg(report.getShgComingMarch());
////            superAchiever.setTotalRam(report.getTotal_ramComingMarch());
//            superAchiever.setNpa(report.getNpaSuperMarch());
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
//
//
//            List<ParameterDetails> parameterDetailsList = new ArrayList<>();
//
//
//            SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM-dd");
//
////            BigDecimal marchYear1 = convertDateToBigDecimalMonthYear(year2.getReport_date());
//
//
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Total Business",
//                    year1.getTotalBusiness(),
//                    year2.getTotalBusiness(),
//                    year3.getTotalBusiness(),
//                    currentDate.getTotalBusiness(),
//                    target.getTotalBusiness(),
//                    targetGap.getTotalBusiness(),
//                    marchGap.getTotalBusiness(),  // gapTarget
//                    marchPercent.getTotalBusiness(),
//                    comingMarch.getTotalBusiness(), // targetYear
//                    superAchiever.getTotalBusiness()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Total Deposit",
//                    year1.getDeposit(),
//                    year2.getDeposit(),
//                    year3.getDeposit(),
//                    currentDate.getDeposit(),
//                    target.getDeposit(),
//                    targetGap.getDeposit(),
//                    marchGap.getDeposit(),  // gapTarget
//                    marchPercent.getDeposit(),
//                    comingMarch.getDeposit(), // targetYear
//                    superAchiever.getDeposit()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "CA",
//                    year1.getCa(),
//                    year2.getCa(),
//                    year3.getCa(),
//                    currentDate.getCa(),
//                    target.getCa(),
//                    targetGap.getCa(),
//                    marchGap.getCa(),  // gapTarget
//                    marchPercent.getCa(),
//                    comingMarch.getCa(), // targetYear
//                    superAchiever.getCa()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "SB",
//                    year1.getSb(),
//                    year2.getSb(),
//                    year3.getSb(),
//                    currentDate.getSb(),
//                    target.getSb(),
//                    targetGap.getSb(),
//                    marchGap.getSb(),  // gapTarget
//                    marchPercent.getSb(),
//                    comingMarch.getSb(), // targetYear
//                    superAchiever.getSb()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "CASA Deposit",
//                    year1.getCasa(),
//                    year2.getCasa(),
//                    year3.getCasa(),
//                    currentDate.getCasa(),
//                    target.getCasa(),
//                    targetGap.getCasa(),
//                    marchGap.getCasa(),  // gapTarget
//                    marchPercent.getCasa(),
//                    comingMarch.getCasa(), // targetYear
//                    superAchiever.getCasa()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Term Deposit",
//                    year1.getTd(),
//                    year2.getTd(),
//                    year3.getTd(),
//                    currentDate.getTd(),
//                    target.getTd(),
//                    targetGap.getTd(),
//                    marchGap.getTd(),  // gapTarget
//                    marchPercent.getTd(),
//                    comingMarch.getTd(), // targetYear
//                    superAchiever.getTd()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Gross Advances",
//                    year1.getAdvances(),
//                    year2.getAdvances(),
//                    year3.getAdvances(),
//                    currentDate.getAdvances(),
//                    target.getAdvances(),
//                    targetGap.getAdvances(),
//                    marchGap.getAdvances(),  // gapTarget
//                    marchPercent.getAdvances(),
//                    comingMarch.getAdvances(), // targetYear
//                    superAchiever.getAdvances()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Retail",
//                    year1.getTotalRetail(),
//                    year2.getTotalRetail(),
//                    year3.getTotalRetail(),
//                    currentDate.getTotalRetail(),
//                    targetGap.getTotalRetail(),
//                    targetGap.getTotalRetail(),
//                    marchGap.getTotalRetail(),  // gapTarget
//                    marchPercent.getTotalRetail(),
//                    comingMarch.getTotalRetail(), // targetYear
//                    superAchiever.getTotalRetail()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Housing",
//                    year1.getHousing(),
//                    year2.getHousing(),
//                    year3.getHousing(),
//                    currentDate.getHousing(),
//                    targetGap.getHousing(),
//                    targetGap.getHousing(),
//                    marchGap.getHousing(),  // gapTarget
//                    marchPercent.getHousing(),
//                    comingMarch.getHousing(), // targetYear
//                    superAchiever.getHousing()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Vehicle",
//                    year1.getVehicle(),
//                    year2.getVehicle(),
//                    year3.getVehicle(),
//                    currentDate.getVehicle(),
//                    targetGap.getVehicle(),
//                    targetGap.getVehicle(),
//                    marchGap.getVehicle(),  // gapTarget
//                    marchPercent.getVehicle(),
//                    comingMarch.getVehicle(), // targetYear
//                    superAchiever.getVehicle()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Education",
//                    year1.getEducation(),
//                    year2.getEducation(),
//                    year3.getEducation(),
//                    currentDate.getEducation(),
//                    targetGap.getEducation(),
//                    targetGap.getEducation(),
//                    marchGap.getEducation(),  // gapTarget
//                    marchPercent.getEducation(),
//                    comingMarch.getEducation(), // targetYear
//                    superAchiever.getEducation()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Agriculture",
//                    year1.getAgri(),
//                    year2.getAgri(),
//                    year3.getAgri(),
//                    currentDate.getAgri(),
//                    targetGap.getAgri(),
//                    targetGap.getAgri(),
//                    marchGap.getAgri(),  // gapTarget
//                    marchPercent.getAgri(),
//                    comingMarch.getAgri(), // targetYear
//                    superAchiever.getAgri()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "MSME",
//                    year1.getMsme(),
//                    year2.getMsme(),
//                    year3.getMsme(),
//                    currentDate.getMsme(),
//                    targetGap.getMsme(),
//                    targetGap.getMsme(),
//                    marchGap.getMsme(),  // gapTarget
//                    marchPercent.getMsme(),
//                    comingMarch.getMsme(), // targetYear
//                    superAchiever.getMsme()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Gold",
//                    year1.getGold(),
//                    year2.getGold(),
//                    year3.getGold(),
//                    currentDate.getGold(),
//                    targetGap.getGold(),
//                    targetGap.getGold(),
//                    marchGap.getGold(),  // gapTarget
//                    marchPercent.getGold(),
//                    comingMarch.getGold(), // targetYear
//                    superAchiever.getGold()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "SHG",
//                    year1.getShg(),
//                    year2.getShg(),
//                    year3.getShg(),
//                    currentDate.getShg(),
//                    targetGap.getShg(),
//                    targetGap.getShg(),
//                    marchGap.getShg(),  // gapTarget
//                    marchPercent.getShg(),
//                    comingMarch.getShg(), // targetYear
//                    superAchiever.getShg()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "Total RAM",
//                    year1.getTotalRam(),
//                    year2.getTotalRam(),
//                    year3.getTotalRam(),
//                    currentDate.getTotalRam(),
//                    targetGap.getTotalRam(),
//                    targetGap.getTotalRam(),
//                    marchGap.getTotalRam(),  // gapTarget
//                    marchPercent.getTotalRam(),
//                    comingMarch.getTotalRam(), // targetYear
//                    superAchiever.getTotalRam()  // targetYearSuperAchiever
//            ));
//
//            parameterDetailsList.add(new ParameterDetails(
//                    "NPA",
//                    year1.getNpa(),
//                    year2.getNpa(),
//                    year3.getNpa(),
//                    currentDate.getNpa(),
//                    targetGap.getNpa(),
//                    targetGap.getNpa(),
//                    marchGap.getNpa(),  // gapTarget
//                    marchPercent.getNpa(),
//                    comingMarch.getNpa(), // targetYear
//                    superAchiever.getNpa()  // targetYearSuperAchiever
//            ));
//            for (ParameterDetails pd : parameterDetailsList) {
//                System.out.println("Checking parameter: " + pd.getParameter());
//            }
//
//            System.out.println("DATA :"+parameterDetailsList.get(0).toString());
//
//
//            MssoBranchProfileSmaDto mssoBranchProfileSmaDto  = new MssoBranchProfileSmaDto();
//            mssoBranchProfileSmaDto.setReport_date(report.getReport_dateSma());
//            mssoBranchProfileSmaDto.setTotal_count((long) report.getTotal_count());
//            mssoBranchProfileSmaDto.setTotal_amount(report.getTotal_amount());
//            mssoBranchProfileSmaDto.setSma0_count((long) report.getSma0_count());
//            mssoBranchProfileSmaDto.setSma0_amount(report.getSma0_amount());
//            mssoBranchProfileSmaDto.setSma1_count((long)report.getSma1_count());
//            mssoBranchProfileSmaDto.setSma1_amount(report.getSma1_amount());
//            mssoBranchProfileSmaDto.setSma2_count((long)report.getSma2_count());
//            mssoBranchProfileSmaDto.setSma2_amount(report.getSma2_amount());
//
//            System.out.println("mssoBranchProfileSmaDto :" + mssoBranchProfileSmaDto);
//            List<MssoBranchProfileSmaDto> mssoBranchProfileSmaDtoList = Collections.singletonList(mssoBranchProfileSmaDto);
//
//            MssoProfileDailyDisburseDto  mssoProfileDailyDisburseTargetDto  = new MssoProfileDailyDisburseDto();
//
//            mssoProfileDailyDisburseTargetDto.setReport_date(report.getReport_dateDisbTarget());
//            mssoProfileDailyDisburseTargetDto.setTotal_advances(report.getTotal_advancesDisbTarget());
//            mssoProfileDailyDisburseTargetDto.setTotal_os(report.getTotal_osDisbTarget());
//            mssoProfileDailyDisburseTargetDto.setTotal_count((long)report.getTotal_countDisbTarget());
//            mssoProfileDailyDisburseTargetDto.setRetail(report.getRetailDisbTarget());
//            mssoProfileDailyDisburseTargetDto.setRetail_count((long)report.getRetail_countDisbTarget());
//            mssoProfileDailyDisburseTargetDto.setHousing(report.getHousingDisbTarget());
//            mssoProfileDailyDisburseTargetDto.setHousing_count((long)report.getHousing_countDisbTarget());
//            mssoProfileDailyDisburseTargetDto.setVehicle(report.getVehicleDisbTarget());
//            mssoProfileDailyDisburseTargetDto.setVehicle_count((long)report.getVehicle_countDisbTarget());
//            mssoProfileDailyDisburseTargetDto.setEducation(report.getEducationDisbTarget());
//            mssoProfileDailyDisburseTargetDto.setEducation_count((long)report.getEducation_countDisbTarget());
//            mssoProfileDailyDisburseTargetDto.setAgriculture(report.getAgricultureDisbTarget());
//            mssoProfileDailyDisburseTargetDto.setAgriculture_count((long)report.getAgriculture_countDisbTarget());
//            mssoProfileDailyDisburseTargetDto.setMsme(report.getMsmeDisbTarget());
//            mssoProfileDailyDisburseTargetDto.setMsme_count((long)report.getMsme_countDisbTarget());
//            mssoProfileDailyDisburseTargetDto.setGold(report.getGoldDisbTarget());
//            mssoProfileDailyDisburseTargetDto.setGold_count((long)report.getGold_countDisbTarget());
//            mssoProfileDailyDisburseTargetDto.setShg(report.getShgDisbTarget());
//            mssoProfileDailyDisburseTargetDto.setShg_count((long)report.getShg_countDisbTarget());
//
//
//            System.out.println("mssoProfileDailyDisburseTargetDto :" + mssoProfileDailyDisburseTargetDto);
//            List<MssoProfileDailyDisburseDto> mssoProfileDailyDisburseDtoTargetList = Collections.singletonList(mssoProfileDailyDisburseTargetDto);
//
//
//            MssoProfileDailyDisburseDto  mssoProfileDailyDisburseDto  = new MssoProfileDailyDisburseDto ();
//
//            mssoProfileDailyDisburseDto.setReport_date(report.getReport_dateDisb());
//            mssoProfileDailyDisburseDto.setTotal_advances(report.getTotal_advancesDisb());
//            mssoProfileDailyDisburseDto.setTotal_os(report.getTotal_osDisb());
//            mssoProfileDailyDisburseDto.setTotal_count((long)report.getTotal_countDisb());
//            mssoProfileDailyDisburseDto.setRetail(report.getRetailDisb());
//            mssoProfileDailyDisburseDto.setRetail_count((long)report.getRetail_countDisb());
//            mssoProfileDailyDisburseDto.setHousing(report.getHousingDisb());
//            mssoProfileDailyDisburseDto.setHousing_count((long)report.getHousing_countDisb());
//            mssoProfileDailyDisburseDto.setVehicle(report.getVehicleDisb());
//            mssoProfileDailyDisburseDto.setVehicle_count((long)report.getVehicle_countDisb());
//            mssoProfileDailyDisburseDto.setEducation(report.getEducationDisb());
//            mssoProfileDailyDisburseDto.setEducation_count((long)report.getEducation_countDisb());
//            mssoProfileDailyDisburseDto.setAgriculture(report.getAgricultureDisb());
//            mssoProfileDailyDisburseDto.setAgriculture_count((long)report.getAgriculture_countDisb());
//            mssoProfileDailyDisburseDto.setMsme(report.getMsmeDisb());
//            mssoProfileDailyDisburseDto.setMsme_count((long)report.getMsme_countDisb());
//            mssoProfileDailyDisburseDto.setGold(report.getGoldDisb());
//            mssoProfileDailyDisburseDto.setGold_count((long)report.getGold_countDisb());
//            mssoProfileDailyDisburseDto.setShg(report.getShgDisb());
//            mssoProfileDailyDisburseDto.setShg_count((long)report.getShg_countDisb());
//
//            System.out.println("mssoProfileDailyDisburseDto :" + mssoProfileDailyDisburseDto);
//            List<MssoProfileDailyDisburseDto> mssoProfileDailyDisburseDtoList = Collections.singletonList(mssoProfileDailyDisburseDto);
//
//            MssoProfileNpaClassificationDto  mssoNpaClassification  = new MssoProfileNpaClassificationDto();
//
//            mssoNpaClassification.setTotal_amount(report.getTotal_amountNpa());
//            mssoNpaClassification.setTotal_count(report.getTotal_countNpa());
//            mssoNpaClassification.setD0_amount(report.getD0_amountNpa());
//            mssoNpaClassification.setD0_count(report.getD0_countNpa());
//            mssoNpaClassification.setD0_count(report.getD0_countNpa());
//            mssoNpaClassification.setD1_amount(report.getD1_amountNpa());
//            mssoNpaClassification.setD1_count(report.getD1_countNpa());
//            mssoNpaClassification.setD2_amount(report.getD2_amountNpa());
//            mssoNpaClassification.setD2_count(report.getD2_countNpa());
//            mssoNpaClassification.setloss_amount(report.getLoss_amountNpa());
//            mssoNpaClassification.setloss_count(report.getLoss_countNpa());
//            mssoNpaClassification.setSubStandard_amount(report.getSubStandard_amountNpa());
//            mssoNpaClassification.setSubStandard_count(report.getSubStandard_countNpa());
//
//            List<MssoProfileNpaClassificationDto> mssoNpaClassificationList = Collections.singletonList(mssoNpaClassification);
//
//            MssoBranchEmployeeDataDto mssoBranchEmployeeDataDto=new MssoBranchEmployeeDataDto();
//            mssoBranchEmployeeDataDto.setDesg_agm(report.getDesg_agm());
//            mssoBranchEmployeeDataDto.setDesg_cm(report.getDesg_cm());
//            mssoBranchEmployeeDataDto.setDesg_srmanager(report.getDesg_srmanager());
//            mssoBranchEmployeeDataDto.setDesg_manager(report.getDesg_manager());
//            mssoBranchEmployeeDataDto.setDesg_dymanager(report.getDesg_dymanager());
//            mssoBranchEmployeeDataDto.setDesg_clerk(report.getDesg_clerk());
//            mssoBranchEmployeeDataDto.setSubstaff(report.getSubstaff());
//
//            System.out.println("SMA DATA :"+mssoBranchEmployeeDataDto);
//            List<MssoBranchEmployeeDataDto> mssoBranchEmployeeDataDtoList = Collections.singletonList(mssoBranchEmployeeDataDto);
//
//
//            MssoEmployeeSummaryDto mssoEmployeeSummaryDto = new MssoEmployeeSummaryDto();
//
//            mssoEmployeeSummaryDto.setDesg_agm(report.getDesg_agmTotalStaff());
//            mssoEmployeeSummaryDto.setDesg_cm(report.getDesg_cmTotalStaff());
//            mssoEmployeeSummaryDto.setDesg_srmanager(report.getDesg_srmanagerTotalStaff());
//            mssoEmployeeSummaryDto.setDesg_manager(report.getDesg_managerTotalStaff());
//            mssoEmployeeSummaryDto.setDesg_dymanager(report.getDesg_dymanagerTotalStaff());
//            mssoEmployeeSummaryDto.setDesg_clerk(report.getDesg_clerkTotalStaff());
//            mssoEmployeeSummaryDto.setSubstaff(report.getSubstaffTotalStaff());
//
//
//            List<MssoEmployeeSummaryDto> mssoEmployeeSummaryDtoList = Collections.singletonList(mssoEmployeeSummaryDto);
//
//
//            Map<String, Object> parameters = new HashMap<>();
//
//            parameters.put("paramterDetails", new JRBeanCollectionDataSource(parameterDetailsList));
//            parameters.put("stressData", new JRBeanCollectionDataSource(mssoBranchProfileSmaDtoList));
//            parameters.put("newLoanSanctioned", new JRBeanCollectionDataSource(mssoProfileDailyDisburseDtoList));
//            parameters.put("newLoanSanctionedTarget", new JRBeanCollectionDataSource(mssoProfileDailyDisburseDtoTargetList));
//            parameters.put("newLoanSanctionedProductWise", new JRBeanCollectionDataSource(mssoProfileDailyDisburseDtoList));
//            parameters.put("newLoanSanctionedProductWiseTarget", new JRBeanCollectionDataSource(mssoProfileDailyDisburseDtoTargetList));
//            parameters.put("employeeData", new JRBeanCollectionDataSource(mssoBranchEmployeeDataDtoList));
//            parameters.put("employeeDataSummary", new JRBeanCollectionDataSource(mssoEmployeeSummaryDtoList));
//            parameters.put("npaClassification", new JRBeanCollectionDataSource( mssoNpaClassificationList));
//
//  //***********************************************************************************************************************************
//
////            parameters.put("perEmployeeBusiness",report.per);
////            if(mssoBranchEmployeeDataDto.getBranch_code().equalsIgnoreCase("4000")) {
////                parameters.put("region", "Head Office");
////                parameters.put("branchName","-");
////
////            }else{
////
////                if(mssoBranchEmployeeDataDto.getRegion().equalsIgnoreCase("AURANGABAD")){
////                    parameters.put("region", "Chht. Sambhaji Nagar");
////                }else {
////                    parameters.put("region", mssoBranchEmployeeDataDto.getRegion());
////                }
////                parameters.put("branchName",mssoBranchEmployeeDataDto.getBranch_name());
////
////            }
//
//            parameters.put("branchCode",report.getBranch_code()!=null?report.getBranch_code():"");
////            String branchOpenDate=dateConverter(report.getBranchopendate());
//            String bmBranchJoinDate="";
////            if(report.bmBranchJoinDateDto!=null) {
////                bmBranchJoinDate = dateConverter(bmBranchJoinDateDto.getBmBranchJoinDate());
////            }
////            parameters.put("sinceDate", branchOpenDate!=null?branchOpenDate:"");
////            parameters.put("bmBranchJoinDate", bmBranchJoinDate!=null?bmBranchJoinDate:"");
////            parameters.put("designation", designation!=null?designation:"");
////            parameters.put("design", desig!=null?desig:"");
////
////            parameters.put("bcCount",report.getBC());
//
//            parameters.put("branchOrRegionHead",report.getEmployee_name());
//            parameters.put("grade",report.getGrade_code());
////            parameters.put("isHeadName",isHeadName);
////            parameters.put("isBcCount",isBcCount);
////            parameters.put("isPerEmployeeBusiness",isPerEmployeeBusiness);
////            parameters.put("isHoRoEmployeeSummary",isHoRoEmployeeSummary);
////            parameters.put("branchCategory",report.getB);
////            parameters.put("amountIn",amountIn);
//
//          //  if(u_loc.equalsIgnoreCase("HO")||u_loc.equalsIgnoreCase("RO")) {
//
//                parameters.put("totalBranch", report.getTotalBranchCount()!=null?report.getTotalBranchCount():0);
//                parameters.put("urban", report.getUrban()!=null?report.getUrban():0);
//                parameters.put("semiUrban", report.getSemiUrban()!=null?report.getSemiUrban():0);
//                parameters.put("metro", report.getMetropolitan()!=null?report.getMetropolitan():0);
//                parameters.put("rural", report.getRural()!=null?report.getRural():0);
//           // }
//            String current_report_date=dateConverter(report.getReport_date_actual());
//
//            parameters.put("current_report_date",current_report_date);
//
//            String npa_report_date=dateConverter(report.getReport_dateNpa());
//
//            parameters.put("npa_report_date",npa_report_date);
//
//            System.out.println("current_report_date"+report.getReport_date_actual());
//
//
//            String sma_report_date=dateConverter(report.getReport_dateSma());
//
//            parameters.put("sma_report_date",sma_report_date);
//
//
////            parameters.put("total_staff",total_staff);
////            parameters.put("total_staff_bank",branch_total_staff);
////
////            parameters.put("category",category);
////    parameters.put("timebarredCount",total_staff);
////            parameters.put("reviewRenewalCount",pendingReviewRenewal.getTotal_count());
////            parameters.put("reviewRenewalAmount",pendingReviewRenewal.getTotal_amount());
////            parameters.put("reviewRenewalAmount",pendingReviewRenewal.getTotal_amount());
//            parameters.put("paramterDetails", new JRBeanCollectionDataSource(parameterDetailsList));
//
//
//            parameters.put("naccReviewRenewalCount",report.getNacc_count());
//            parameters.put("naccReviewRenewalAmount",report.getNacc_amount());
//            parameters.put("timebarredCount",report.getTotal_countTimeBarred());
//            parameters.put("timebarredAmount",report.getTotal_amountTimeBarred());
//            parameters.put("kccReviewRenewalCount",report.getKcc_count());
//            parameters.put("kccReviewRenewalAmount",report.getKcc_amount());
//
//                parameters.put("pendingMultipleCif", report.getMultiple_cif());
//
//
//            parameters.put("pendingCkyc",report.getCkyc());
//            parameters.put("inoperativeCasaCount",report.getCasa_count());
//            parameters.put("inoperativeCasaAmount",report.getCasa_amount());
//
//
//            parameters.put("quarterTargetSB",report.getSb_ac_countTarget());
//            parameters.put("asOnDateSB",report.getSb_ac_count());
//            parameters.put("AsOnMarchSB",report.getSb_ac_countMarch());
//            parameters.put("quarterTargetCa",report.getCa_ac_countTarget());
//            parameters.put("asonDateCa",report.getCa_ac_count());
//            parameters.put("asOnMarchCa",report.getCa_ac_countMarch());
//            parameters.put("asonDateDebitCard",report.getAtm_card());
//            parameters.put("asonDateMobileBanking",report.getMobile_banking());
//            parameters.put("asonDateInternetBanking",report.getInternet_banking());
//            parameters.put("quarterTargetDebitCard",report.getAtm_cardTarget());
//            parameters.put("quarterTargetMobileBanking",report.getMobile_bankingTarget());
//            parameters.put("quarterTargetInternetBanking",report.getInternet_bankingTarget());
//
//
//            parameters.put("quarterTargetPmjdy",report.getPmjdyTarget());
//            parameters.put("quarterTargetPmjjby",report.getPmjjbyTarget());
//            parameters.put("quarterTargetPmsby",report.getPmsbyTarget());
//            parameters.put("quarterTargetApy",report.getApyTarget());
//            parameters.put("asOnDatePmjdy",report.getPmjdy());
//            parameters.put("asOnDatePmjjby",report.getPmjjby());
//            parameters.put("asOnDatePmsby",report.getPmsby());
//            parameters.put("asOnDateApy",report.getApy());
//
//            LocalDate quarterEnd = serviceMssoBranchProfileTargetData.getCurrentquarterEndDateDate();
//            System.out.println("Current Quarter End Date: " + dateConverterQuarter(quarterEnd));
//            parameters.put("quarter",dateConverterQuarter(quarterEnd));
//
//            LocalDate financialYearEndDate = serviceMssoBranchProfileTargetData.getFinancialYearEndDate();
//            System.out.println("financialYearEndDate : " + dateConverterQuarter(financialYearEndDate));
//            parameters.put("financialYrEnd",dateConverterQuarter(financialYearEndDate));
//
//            parameters.put("year1",dateConverterUtil(year1.getReportDate()));
//            parameters.put("year2",dateConverterUtil(year2.getReportDate()));
//            parameters.put("year3",dateConverterUtil(year3.getReportDate()));
//
//            parameters.put("parameterDetailRemark",report.getParameterDetailRemark());
//            parameters.put("sanctionDisbursedRemark",report.getSanctionDisbursedRemark());
//            parameters.put("smaRemark",report.getSmaRemark());
//            parameters.put("npaClassificationRemark",report.getNpaClassificationRemark());
//            parameters.put("complianceRemark",report.getComplianceRemark());
//            parameters.put("accountAndDigitalStatusRemark",report.getAccountAndDigitalStatusRemark());
//            parameters.put("socialSecurityRemark",report.getSocialSecurityRemark());
//            parameters.put("otherRemark",report.getOtherRemark());
//
//
//            //******************************** FILL THE MAIN REPORT ***********************************************************8
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
//
//            //******************************** Export to PDF ********************************************************************
//            byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_PDF);
//            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=AppraisalNote" + branch_code + ".pdf");
//
//            return ResponseEntity
//                    .ok()
//                    .headers(headers)
//                    .contentType(MediaType.APPLICATION_PDF)
//                    .body(new ByteArrayResource(pdfBytes));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(500).body(null);
//        }
//    }
//
//
//    //**********************************************************************************************************************************************************
//
//    public static BigDecimal convertDateToBigDecimalMonthYear(Date date) {
//        if (date == null) return null;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
//        String formatted = sdf.format(date); // e.g. "202507"
//        return new BigDecimal(formatted);    // returns BigDecimal(202507)
//    }
//
//    public String dateConverter(Date date) {
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        String formattedDate = formatter.format(date);
//        System.out.println(formattedDate); // e.g., 05/07/2025
//        return  formattedDate;
//    }
//
//    public String dateConverterUtil(Date date) {
//        SimpleDateFormat formatter = new SimpleDateFormat("MMM-yyyy");
//        String formattedDate = formatter.format(date);
//        System.out.println(formattedDate); // e.g., 05/07/2025
//        return  formattedDate;
//    }
//    public String dateConverterQuarter(LocalDate date) {
//
//        // Format to Sep-2025
//        String formatted1 = date.format(DateTimeFormatter.ofPattern("MMM-yy"));
//        System.out.println(formatted1); // Sep-2025
//
//
//        return  formatted1;
//    }
//
//    public String dateConverterYear(LocalDate date) {
//
//        // Format to Sep-2025
//        String formatted1 = date.format(DateTimeFormatter.ofPattern("MMM-yyyy"));
//        System.out.println(formatted1); // Sep-2025
//
//
//        return  formatted1;
//    }
}
