package com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel;

public class MssoEmployeeSummaryDto {
    private Long desg_agm;
    private Long desg_cm;
    private Long desg_srmanager;
    private Long desg_manager;
    private Long desg_dymanager;
    private Long desg_clerk;
    private Long substaff;

    public Long getDesg_agm() {
        return desg_agm;
    }

    public void setDesg_agm(Long desg_agm) {
        this.desg_agm = desg_agm;
    }

    public Long getDesg_cm() {
        return desg_cm;
    }

    public void setDesg_cm(Long desg_cm) {
        this.desg_cm = desg_cm;
    }

    public Long getDesg_srmanager() {
        return desg_srmanager;
    }

    public void setDesg_srmanager(Long desg_srmanager) {
        this.desg_srmanager = desg_srmanager;
    }

    public Long getDesg_manager() {
        return desg_manager;
    }

    public void setDesg_manager(Long desg_manager) {
        this.desg_manager = desg_manager;
    }

    public Long getDesg_dymanager() {
        return desg_dymanager;
    }

    public void setDesg_dymanager(Long desg_dymanager) {
        this.desg_dymanager = desg_dymanager;
    }

    public Long getDesg_clerk() {
        return desg_clerk;
    }

    public void setDesg_clerk(Long desg_clerk) {
        this.desg_clerk = desg_clerk;
    }

    public Long getSubstaff() {
        return substaff;
    }

    public void setSubstaff(Long substaff) {
        this.substaff = substaff;
    }

    public MssoEmployeeSummaryDto(Long desg_agm, Long desg_cm, Long desg_srmanager, Long desg_manager, Long desg_dymanager, Long desg_clerk, Long substaff) {
        this.desg_agm = desg_agm;
        this.desg_cm = desg_cm;
        this.desg_srmanager = desg_srmanager;
        this.desg_manager = desg_manager;
        this.desg_dymanager = desg_dymanager;
        this.desg_clerk = desg_clerk;
        this.substaff = substaff;
    }




}
