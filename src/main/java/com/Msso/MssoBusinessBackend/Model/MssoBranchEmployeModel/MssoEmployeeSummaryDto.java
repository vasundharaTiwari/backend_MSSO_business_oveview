package com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel;

import java.math.BigDecimal;

public class MssoEmployeeSummaryDto {

    private int desg_agm;
    private int desg_cm;
    private int desg_srmanager;
    private int desg_manager;
    private int desg_dymanager;
    private int desg_clerk;
    private int substaff;

    public MssoEmployeeSummaryDto(BigDecimal desg_agm,
                                  BigDecimal desg_cm,
                                  BigDecimal desg_srmanager,
                                  BigDecimal desg_manager,
                                  BigDecimal desg_dymanager,
                                  BigDecimal desg_clerk,
                                  BigDecimal substaff) {

        this.desg_agm = desg_agm != null ? desg_agm.intValue() : 0;
        this.desg_cm = desg_cm != null ? desg_cm.intValue() : 0;
        this.desg_srmanager = desg_srmanager != null ? desg_srmanager.intValue() : 0;
        this.desg_manager = desg_manager != null ? desg_manager.intValue() : 0;
        this.desg_dymanager = desg_dymanager != null ? desg_dymanager.intValue() : 0;
        this.desg_clerk = desg_clerk != null ? desg_clerk.intValue() : 0;
        this.substaff = substaff != null ? substaff.intValue() : 0;
    }

    // Getters and Setters

    public int getDesg_agm() { return desg_agm; }
    public void setDesg_agm(int desg_agm) { this.desg_agm = desg_agm; }

    public int getDesg_cm() { return desg_cm; }
    public void setDesg_cm(int desg_cm) { this.desg_cm = desg_cm; }

    public int getDesg_srmanager() { return desg_srmanager; }
    public void setDesg_srmanager(int desg_srmanager) { this.desg_srmanager = desg_srmanager; }

    public int getDesg_manager() { return desg_manager; }
    public void setDesg_manager(int desg_manager) { this.desg_manager = desg_manager; }

    public int getDesg_dymanager() { return desg_dymanager; }
    public void setDesg_dymanager(int desg_dymanager) { this.desg_dymanager = desg_dymanager; }

    public int getDesg_clerk() { return desg_clerk; }
    public void setDesg_clerk(int desg_clerk) { this.desg_clerk = desg_clerk; }

    public int getSubstaff() { return substaff; }

    @Override
    public String toString() {
        return "MssoEmployeeSummaryDto{" +
                "desg_agm=" + desg_agm +
                ", desg_cm=" + desg_cm +
                ", desg_srmanager=" + desg_srmanager +
                ", desg_manager=" + desg_manager +
                ", desg_dymanager=" + desg_dymanager +
                ", desg_clerk=" + desg_clerk +
                ", substaff=" + substaff +
                '}';
    }

    public void setSubstaff(int substaff) { this.substaff = substaff; }

    public MssoEmployeeSummaryDto() {
    }
}
