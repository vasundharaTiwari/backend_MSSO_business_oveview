package com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class MssoEmployeeSummaryDto {
    public MssoEmployeeSummaryDto(int desg_agm, int desg_cm, int desg_srmanager, int desg_manager, int desg_dymanager, int desg_clerk, int substaff) {
        this.desg_agm = desg_agm;
        this.desg_cm = desg_cm;
        this.desg_srmanager = desg_srmanager;
        this.desg_manager = desg_manager;
        this.desg_dymanager = desg_dymanager;
        this.desg_clerk = desg_clerk;
        this.substaff = substaff;
    }

    public int getDesg_agm() {
        return desg_agm;
    }

    public void setDesg_agm(int desg_agm) {
        this.desg_agm = desg_agm;
    }

    public int getDesg_cm() {
        return desg_cm;
    }

    public void setDesg_cm(int desg_cm) {
        this.desg_cm = desg_cm;
    }

    public int getDesg_srmanager() {
        return desg_srmanager;
    }

    public void setDesg_srmanager(int desg_srmanager) {
        this.desg_srmanager = desg_srmanager;
    }

    public int getDesg_manager() {
        return desg_manager;
    }

    public void setDesg_manager(int desg_manager) {
        this.desg_manager = desg_manager;
    }

    public int getDesg_dymanager() {
        return desg_dymanager;
    }

    public void setDesg_dymanager(int desg_dymanager) {
        this.desg_dymanager = desg_dymanager;
    }

    public int getDesg_clerk() {
        return desg_clerk;
    }

    public void setDesg_clerk(int desg_clerk) {
        this.desg_clerk = desg_clerk;
    }

    public int getSubstaff() {
        return substaff;
    }

    public void setSubstaff(int substaff) {
        this.substaff = substaff;
    }

    private int desg_agm;

    private int desg_cm;
    private int desg_srmanager;
    private int desg_manager;
    private int desg_dymanager;
    private int desg_clerk;
    private int substaff;
}

