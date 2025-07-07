package com.Msso.MssoBusinessBackend.Reports;

import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.BranchCategoryDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.BranchOpeningDateDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.MssoBranchEmployeeDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel.MssoEmployeeSummaryDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileDisbursement.MssoProfileDailyDisburseDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileActualDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoBranchProfileModel.MssoBranchProfileTargetDataDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoAccountStatusDigitalTargetDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileAccountStatusDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileAccountStatusDigitalProduct.MssoBranchProfileDigitalProductDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileComplianceDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileReviewRenewal.MssoProfileReviewRenewalDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.MssoBranchProfileSmaDto;
import com.Msso.MssoBusinessBackend.Model.MssoProfileSmaNpaClassification.MssoProfileNpaClassificationDto;
import com.Msso.MssoBusinessBackend.Model.ParameterDetails;
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
//    @Autowired
//    ServiceMssoBranchProfileTargetData serviceMssoBranchProfileTargetData;

    public ResponseEntity<ByteArrayResource> exportBranchProfileReport(String branch_code,  String region, String u_loc) throws JRException {

        try {
            //********************************************** Load main JRXML file ************************************************************************************

            //***************************************************************************************************************************************************************

            InputStream templateStream;
            templateStream = getClass().getResourceAsStream("/REPORTS/ReportDownload.jrxml");


            JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);


            //*********************************************** Main JRXML parameter mapping ***************************************************************************
            MssoBranchProfileSmaDto mssoBranchProfileSmaDto = serviceMssoBranchProfileSma.getMssoDailySma(branch_code, region, u_loc);
            System.out.println("SMA DATA :" + mssoBranchProfileSmaDto);
            List<MssoBranchProfileSmaDto> mssoBranchProfileSmaDtoList = Collections.singletonList(mssoBranchProfileSmaDto);

            MssoProfileReviewRenewalDto pendingReviewRenewal = serviceMssoBranchProfileSma.getPendingReview(branch_code, region, u_loc);

            System.out.println("SMA DATA :" + pendingReviewRenewal.getTotal_amount() + pendingReviewRenewal.getTotal_count());

            MssoProfileDailyDisburseDto mssoProfileDailyDisburseDto = serviceMssoDailyDisbursement.getMssoDailyDisbursement(branch_code, region, u_loc);
            System.out.println("SMA DATA :" + mssoProfileDailyDisburseDto);
            List<MssoProfileDailyDisburseDto> mssoProfileDailyDisburseDtoList = Collections.singletonList(mssoProfileDailyDisburseDto);


            MssoProfileDailyDisburseDto mssoProfileDailyDisburseTargetDto = serviceMssoDailyDisbursement.getMssoDisbursementTarget(branch_code, region, u_loc);
//            MssoProfileDailyDisburseDto mssoProfileDailyDisburseTargetDto = serviceMssoDailyDisbursement.getMssoDisbursementTarget(branchCode, roname, u_loc);

            System.out.println("SMA DATA :" + mssoProfileDailyDisburseDto);
            List<MssoProfileDailyDisburseDto> mssoProfileDailyDisburseTargetList = Collections.singletonList(mssoProfileDailyDisburseTargetDto);

            Boolean isHeadName;
            if (u_loc.equalsIgnoreCase("HO")) {
                isHeadName = false;
            } else {
                isHeadName = true;
            }
            Boolean isHoRoEmployeeSummary;
            if (u_loc.equalsIgnoreCase("BR")) {
                isHoRoEmployeeSummary = false;
            } else {
                isHoRoEmployeeSummary = true;
            }

            // 3 years
            List<MssoBranchProfileActualDataDto> mssoBranchProfileActualDataDto = serviceBranchProfileLast3Year.getMssoBranchProfileMarchData(branch_code, region, u_loc);
            System.out.println("mssoBranchProfileActualDataDto DATA :" + mssoBranchProfileActualDataDto.get(0));

            //march
            MssoBranchProfileActualDataDto mssoBranchProfileActualDataDtoMarchGap = serviceBranchProfileLast3Year.getMssoBranchProfileGapMarch(branch_code, region, u_loc);
            System.out.println("SMA DATA :" + mssoProfileDailyDisburseDto);

            MssoBranchProfileTargetDataDto mssoBranchProfileQuarterTargetData = serviceMssoBranchProfileTargetData.getMssoBranchProfileTargetData(branch_code, region, u_loc);
            System.out.println("mssoBranchProfileQuarterTargetData DATA :" + mssoBranchProfileQuarterTargetData);


            MssoBranchProfileTargetDataDto mssoBranchProfileQuarterTargetGap = serviceMssoBranchProfileTargetData.getMssoBranchProfileGapQuarter(branch_code, region, u_loc);


            String branchCategory = mssoBranchDataService.getBranchCategory(branch_code, u_loc, region);
//    if(u_loc.equalsIgnoreCase("HO")||u_loc.equalsIgnoreCase("RO")){
            BranchCategoryDto branchCategoryDto = mssoBranchDataService.getBranchCategoryCount(branch_code, u_loc, region);

            // }


            MssoBranchProfileTargetDataDto mssoBranchProfileTargetDataSuperAchieverMarch = serviceMssoBranchProfileTargetData.getSuperAchieverMarch(branch_code, region, u_loc);

            MssoBranchProfileTargetDataDto mssoBranchProfileMarchTargetData = serviceMssoBranchProfileTargetData.getMssoTargetMarch(branch_code, region, u_loc);
            MssoBranchProfileActualDataDto mssoBranchProfileActualDataDtoMarchGapPer = serviceBranchProfileLast3Year.getMssoBranchProfileGapMarchPercentage(branch_code, region, u_loc);
            MssoBranchProfileActualDataDto mssoBranchProfileCurrentData = null;
            String category = "";
            if (u_loc.equalsIgnoreCase("HO")) {
                mssoBranchProfileCurrentData = this.repoMssoBranchProfile.getBranchProfileHo();
                category = "HO Staff";

            } else if (u_loc.equalsIgnoreCase("BR")) {
                mssoBranchProfileCurrentData = this.repoMssoBranchProfile.getBranchProfileBranch(branch_code);
                category = "Branch Staff";


            } else {
                mssoBranchProfileCurrentData = this.repoMssoBranchProfile.getBranchProfileRO(region);
                category = "RO Staff";

            }
            System.out.println("inside dep-adv-npa");
            BranchCategoryDto branchCategoryDto1 = null;

            if (u_loc.equalsIgnoreCase("HO")) {
                branchCategoryDto1 = this.repoEmployeData.getBCCountHO();
                System.out.println("getBCCountHO");

            } else if (u_loc.equalsIgnoreCase("RO")) {
                branchCategoryDto1 = this.repoEmployeData.getBCCountRo(region);
                System.out.println("branchCategoryDto" + branchCategoryDto);

            } else if (u_loc.equalsIgnoreCase("BR")) {
                branchCategoryDto1 = this.repoEmployeData.getBCCountBranch(branch_code);
            }

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
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//    String year0 = sdf.format(mssoBranchProfileActualDataDto.get(0).getReport_date()); // "20250701"
//    BigDecimal marchYear0= new BigDecimal(year0);
//
//    String year1 = sdf.format(mssoBranchProfileActualDataDto.get(1).getReport_date()); // "20250701"
//    BigDecimal marchYear1 = new BigDecimal(year1);
//
//    String year2 = sdf.format(mssoBranchProfileActualDataDto.get(2).getReport_date()); // "20250701"
//    BigDecimal marchYear2 = new BigDecimal(year2);
//
//    String current = sdf.format(mssoBranchProfileCurrentData.getReport_date()); // "20250701"
//    BigDecimal currentDate = new BigDecimal(current);
//
//    String nextQua = sdf.format(mssoBranchProfileQuarterTargetData.getReport_date()); // "20250701"
//    BigDecimal nextQuater = new BigDecimal(nextQua);
//
//    String nextMar = sdf.format(mssoBranchProfileQuarterTargetData.getReport_date()); // "20250701"
//    BigDecimal nextMarch = new BigDecimal(nextMar);
//    BigDecimal nextMarchsuper = new BigDecimal(nextMar);




            SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM-dd");

            BigDecimal marchYear0 = convertDateToBigDecimalMonthYear(mssoBranchProfileActualDataDto.get(0).getReport_date());
            BigDecimal marchYear1 = convertDateToBigDecimalMonthYear(mssoBranchProfileActualDataDto.get(1).getReport_date());
            BigDecimal marchYear2 = convertDateToBigDecimalMonthYear(mssoBranchProfileActualDataDto.get(2).getReport_date());
            BigDecimal currentDate = convertDateToBigDecimalMonthYear(mssoBranchProfileCurrentData.getReport_date());
            BigDecimal nextQuarter = convertDateToBigDecimalMonthYear(mssoBranchProfileQuarterTargetData.getReport_date());
            BigDecimal nextMarch = convertDateToBigDecimalMonthYear(mssoBranchProfileQuarterTargetData.getReport_date());
            BigDecimal nextMarchSuper = convertDateToBigDecimalMonthYear(mssoBranchProfileQuarterTargetData.getReport_date());

//    BigDecimal marchYear0 = convertDateToBigDecimalMonthYear(mssoBranchProfileActualDataDto.get(0).getReport_date());
//    BigDecimal currentDate = convertDateToBigDecimalMonthYear(mssoBranchProfileCurrentData.getReport_date());
//    BigDecimal nextQuarter = convertDateToBigDecimalMonthYear(mssoBranchProfileQuarterTargetData.getReport_date());




//    String Gap = "GapTarget"; // "20250701"
//    BigDecimal GapTarget = new BigDecimal(Gap);
//    String ytd = "Y-T-D Growth"; // "20250701"
//    BigDecimal ytd = new BigDecimal(Gap);
            System.out.println("marchYear1marchYear1"+marchYear1);

//    parameterDetailsList.add(new ParameterDetails(
//            "Parameter",
//            marchYear0,
//            marchYear1,
//            marchYear2 ,
//            currentDate,
//            nextQuarter,
//            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),
//            mssoBranchProfileActualDataDtoMarchGap.getTotal_business(),  // gapTarget
//            mssoBranchProfileActualDataDtoMarchGapPer.getTotal_business(),
//            nextMarch,
//            nextMarchSuper
//    ));

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

//            MssoProfileDailyDisburseDto mssoProfileDailyDisburseTarget = serviceMssoDailyDisbursement.getMssoDisbursementTarget(branch_code, region, u_loc);
//
//            System.out.println("SMA DATA :"+mssoBranchEmployeeDataDto);
//            List<MssoProfileDailyDisburseDto> mssoProfileDailyDisburseTargetList = Collections.singletonList(mssoProfileDailyDisburseTarget);


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

            BigDecimal total_bank_staff = BigDecimal.valueOf(total_staff)
                    .add(BigDecimal.valueOf(safeBranchTotal));



            MssoBranchProfileDigitalProductDto mssoBranchProfileDigitalProductDto = serviceaccountStatusDigitalProduct.getMssoDigitalProduct(branch_code,region,u_loc);
            MssoBranchProfileAccountStatusDto mssoBranchProfileAccountStatusDto = serviceaccountStatusDigitalProduct.getMssoAccountStatus(branch_code,region,u_loc);
            MssoAccountStatusDigitalTargetDto mssoAccountStatusDigitalTargetDto = serviceaccountStatusDigitalProduct.getMssoAccountDigitalProductTarget(branch_code,region,u_loc);
//            MssoProfileComplianceDto mssoProfileReviewRenewalPending = serviceMssoBranchProfileSma.getPendingReview(branch_code,region,u_loc);
            MssoProfileComplianceDto mssoProfileTimebarred = serviceMssoBranchProfileSma.getTimebarredData(branch_code,region,u_loc);

            BigDecimal perEmployeeBusiness=mssoBranchProfileCurrentData.getTotal_business().divide(total_bank_staff, 2, RoundingMode.HALF_UP);
            MssoBranchProfileAccountStatusDto mssoBranchProfileAccountStatusMarch = serviceaccountStatusDigitalProduct.getMssoAccountStatusMarch(branch_code,region,u_loc);
            MssoProfileNpaClassificationDto mssoNpaClassification = serviceMssoBranchProfileSma.getMssoNpaClassification(branch_code,region,u_loc);
            List<MssoProfileNpaClassificationDto> mssoNpaClassificationList = Collections.singletonList(mssoNpaClassification);
            BranchOpeningDateDto branchOpeningDateDto = mssoBranchDataService.getBranchOpenDate(branch_code,region,u_loc);



            Map<String, Object> parameters = new HashMap<>();
            parameters.put("stressData", new JRBeanCollectionDataSource(mssoBranchProfileSmaDtoList));
            parameters.put("newLoanSanctioned", new JRBeanCollectionDataSource(mssoProfileDailyDisburseDtoList));
            parameters.put("newLoanSanctionedTarget", new JRBeanCollectionDataSource(mssoProfileDailyDisburseTargetList));
//            parameters.put("newLoanSanctionedTarget", new JRBeanCollectionDataSource(mssoProfileDailyDisburseTargetList));

            parameters.put("newLoanSanctionedProductWise", new JRBeanCollectionDataSource(mssoProfileDailyDisburseDtoList));

            parameters.put("newLoanSanctionedProductWiseTarget", new JRBeanCollectionDataSource(mssoProfileDailyDisburseTargetList));

            parameters.put("employeeData", new JRBeanCollectionDataSource(mssoBranchEmployeeDataDtoList));
            parameters.put("employeeDataSummary", new JRBeanCollectionDataSource(mssoEmployeeSummaryDtoList));
            parameters.put("npaClassification", new JRBeanCollectionDataSource( mssoNpaClassificationList));

            parameters.put("perEmployeeBusiness",perEmployeeBusiness);
            if(mssoBranchEmployeeDataDto.getBranch_code().equalsIgnoreCase("4000")) {
                parameters.put("region", "Head Office");
                parameters.put("branchName","-");

            }else{

                if(mssoBranchEmployeeDataDto.getRegion().equalsIgnoreCase("AURANGABAD")){
                    parameters.put("region", "Chht. Sambhaji Nagar");
                }else {
                    parameters.put("region", mssoBranchEmployeeDataDto.getRegion());
                }
                parameters.put("branchName",mssoBranchEmployeeDataDto.getBranch_name());

            }

            parameters.put("branchCode",mssoBranchEmployeeDataDto.getBranch_code());
//            Date branchOpenDate = branchOpeningDateDto.getBranchopendate();



//            String formattedDate = branchOpenDate.toInstant()
//                    .atZone(ZoneId.systemDefault())
//                    .toLocalDate()
//                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

//            if(u_loc.equalsIgnoreCase("HO") ||u_loc.equalsIgnoreCase("RO")) {
//                String dateStr = "01/05/2025"; // 1st May 2025
//                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                Date utilDate = sdf.parse(dateStr);
//                parameters.put("sinceDate",utilDate );
//
//            }else{
//                parameters.put("sinceDate", branchOpeningDateDto.getBranchopendate());
//
//            }

            String branchOpenDate=dateConverter(branchOpeningDateDto.getBranchopendate());

            parameters.put("sinceDate", branchOpenDate);

//            parameters.put("sinceDate",mssoBranchEmployeeDataDto.getBranch_name());
            parameters.put("bcCount",branchCategoryDto1.getTotalCount());

            parameters.put("branchOrRegionHead",mssoBranchEmployeeDataDto.getEmployee_name());
            parameters.put("grade",mssoBranchEmployeeDataDto.getGrade_code());
            parameters.put("isHeadName",isHeadName);
            parameters.put("isBcCount",isBcCount);
            parameters.put("isPerEmployeeBusiness",isPerEmployeeBusiness);
            parameters.put("isHoRoEmployeeSummary",isHoRoEmployeeSummary);
            parameters.put("branchCategory",branchCategory);
            parameters.put("amountIn",amountIn);

            if(u_loc.equalsIgnoreCase("HO")||u_loc.equalsIgnoreCase("RO")) {

                parameters.put("totalBranch", branchCategoryDto.getTotalCount()!=null?branchCategoryDto.getTotalCount():0);
                parameters.put("urban", branchCategoryDto.getUrban()!=null?branchCategoryDto.getUrban():0);
                parameters.put("semiUrban", branchCategoryDto.getSemiUrban()!=null?branchCategoryDto.getSemiUrban():0);
                parameters.put("metro", branchCategoryDto.getMetropolitan()!=null?branchCategoryDto.getMetropolitan():0);
                parameters.put("rural", branchCategoryDto.getRural()!=null?branchCategoryDto.getRural():0);
            }
            String current_report_date=dateConverter(mssoBranchProfileCurrentData.getReport_date());

            parameters.put("current_report_date",current_report_date);
            System.out.println("current_report_date"+mssoBranchProfileCurrentData.getReport_date());
            parameters.put("quarter",total_staff);

            parameters.put("total_staff",total_staff);
            parameters.put("total_staff_bank",branch_total_staff);

            parameters.put("category",category);
//    parameters.put("timebarredCount",total_staff);
//            parameters.put("reviewRenewalCount",pendingReviewRenewal.getTotal_count());
//            parameters.put("reviewRenewalAmount",pendingReviewRenewal.getTotal_amount());
//            parameters.put("reviewRenewalAmount",pendingReviewRenewal.getTotal_amount());
            parameters.put("paramterDetails", new JRBeanCollectionDataSource(parameterDetailsList));


            parameters.put("naccReviewRenewalCount",pendingReviewRenewal.getNacc_count());
            parameters.put("naccReviewRenewalAmount",pendingReviewRenewal.getNacc_amount());
            parameters.put("timebarredCount",mssoProfileTimebarred.getTotal_count());
            parameters.put("timebarredAmount",mssoProfileTimebarred.getTotal_amount());
            parameters.put("kccReviewRenewalCount",pendingReviewRenewal.getTotal_count());
            parameters.put("kccReviewRenewalAmount",pendingReviewRenewal.getTotal_amount());
            if(u_loc.equalsIgnoreCase("HO")) {
                parameters.put("pendingMultipleCif", 22916L);
            }else{
                parameters.put("pendingMultipleCif", mssoBranchProfileDigitalProductDto.getMultiple_cif());

            }
            parameters.put("pendingCkyc",mssoBranchProfileDigitalProductDto.getCkyc());
            parameters.put("inoperativeCasaCount",mssoBranchProfileAccountStatusDto.getCasa_count());
            parameters.put("inoperativeCasaAmount",mssoBranchProfileAccountStatusDto.getCasa_amount());


            parameters.put("quarterTargetSB",mssoAccountStatusDigitalTargetDto.getSb_ac_count());
            parameters.put("asOnDateSB",mssoBranchProfileAccountStatusDto.getSb_ac_count());
            parameters.put("AsOnMarchSB",mssoBranchProfileAccountStatusMarch.getSb_ac_count());
            parameters.put("quarterTargetCa",mssoAccountStatusDigitalTargetDto.getCa_ac_count());
            parameters.put("asonDateCa",mssoBranchProfileAccountStatusDto.getCa_ac_count());
            parameters.put("asOnMarchCa",mssoBranchProfileAccountStatusMarch.getCa_ac_count());
            parameters.put("asonDateDebitCard",mssoBranchProfileDigitalProductDto.getAtm_card());
            parameters.put("asonDateMobileBanking",mssoBranchProfileDigitalProductDto.getMobile_banking());
            parameters.put("asonDateInternetBanking",mssoBranchProfileDigitalProductDto.getinternet_banking());
            parameters.put("quarterTargetDebitCard",mssoAccountStatusDigitalTargetDto.getAtm_card());
            parameters.put("quarterTargetMobileBanking",mssoAccountStatusDigitalTargetDto.getMobile_banking());
            parameters.put("quarterTargetInternetBanking",mssoAccountStatusDigitalTargetDto.getinternet_banking());

            LocalDate quarterEnd = serviceMssoBranchProfileTargetData.getCurrentquarterEndDateDate();
            System.out.println("Current Quarter End Date: " + quarterEnd);
//
//            String quarter=dateConverterMonth(quarterEnd);
//
////            parameters.put("current_report_date",current_report_date);
//
//            System.out.println(" quarter quarter"+quarter);
//            parameters.put("quarter",quarter);
            parameters.put("todayDate",total_staff);
            parameters.put("financialYear",total_staff);

//            parameters.put("bcCount",branchCategoryDto1.getTotalCount());



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
    public String dateConverterMonth(LocalDate date) {

        SimpleDateFormat monthFormat = new SimpleDateFormat("MMM", Locale.ENGLISH);
        String month = monthFormat.format(date);
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
//        String formattedDate = formatter.format(date);
//        System.out.println(formattedDate); // e.g., 05/07/2025
        return  month;
    }
}
