package com.Msso.MssoBusinessBackend.Model.MasterDataModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(schema="master_data",  name = "branch_master")
public class BranchMasterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long srno;
    private String state;
    private String branchCode;
    private String district;
    private String subdistrict;
    private String villageCity;
    private String branchName;
    private String region;
    private String populationGroupName;
    private int districtCode;
    private int populationCode;
    private int tier;
    private String bankCode;
    private String bankName;
    private String bankingChannel;
    private String cbsCode;
    private String ucnPart1Code;
    private String ucnPart2Code;
    private String ifscCode;
    private String micrCode;
    private double latitude;
    private double longitude;
    private String licenseNumber;
    private String licenseStartDate;
    private String address_1;
    private String  address_2;
    private Long pincode;
    private String postOffice;
    private String branchEmailAddress;
    private String bnkchlOpenDate;
    private String bnkchlActualOpenDate;
    private String alphaCode;
    private String bankingChannelType;
    private String bnkchlWorkingTypeName;
    private String brStd;
    private String brPhone;
    private String locality;
    private String loca;
    private String ipAddress;
}
