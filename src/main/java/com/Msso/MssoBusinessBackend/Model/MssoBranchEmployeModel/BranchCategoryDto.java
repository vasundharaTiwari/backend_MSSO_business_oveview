package com.Msso.MssoBusinessBackend.Model.MssoBranchEmployeModel;

public class BranchCategoryDto {

    private Long totalCount;

    private Long urban;
    private Long rural;
    private Long metropolitan;
    private Long semiUrban;

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getUrban() {
        return urban;
    }

    public void setUrban(Long urban) {
        this.urban = urban;
    }

    public Long getRural() {
        return rural;
    }

    public void setRural(Long rural) {
        this.rural = rural;
    }

    public Long getMetropolitan() {
        return metropolitan;
    }

    public void setMetropolitan(Long metropolitan) {
        this.metropolitan = metropolitan;
    }

    public Long getSemiUrban() {
        return semiUrban;
    }

    public void setSemiUrban(Long semiUrban) {
        this.semiUrban = semiUrban;
    }

    @Override
    public String toString() {
        return "BranchCategoryDto{" +
                "totalCount=" + totalCount +
                ", urban=" + urban +
                ", rural=" + rural +
                ", metropolitan=" + metropolitan +
                ", semiUrban=" + semiUrban +
                '}';
    }

    public BranchCategoryDto(Long totalCount, Long urban, Long rural, Long metropolitan, Long semiUrban) {
        this.totalCount = totalCount;
        this.urban = urban;
        this.rural = rural;
        this.metropolitan = metropolitan;
        this.semiUrban = semiUrban;
    }

    public BranchCategoryDto(Long totalCount) {
        this.totalCount = totalCount;
    }
}
