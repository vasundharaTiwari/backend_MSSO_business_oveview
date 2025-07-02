package com.Msso.MssoBusinessBackend.Model.MasterDataModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(schema="hrms",  name = "hrmsuser")
public class hrmsuser {
    @Id
    private String u_id;
    private String u_identity;
    private String u_type;
    private String branch_code;
    private String region;
    private String epass;
    private String ekey;
    private String u_status;
    private String u_loc;
    private String para_pass;
    private String epass1;
    private String ekey1;
    private String msgread;
}
