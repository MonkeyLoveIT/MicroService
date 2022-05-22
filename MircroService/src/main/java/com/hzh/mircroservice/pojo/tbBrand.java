package com.hzh.mircroservice.pojo;

public class tbBrand {
    private Integer id;
    private String brandName;
    private String companyName;
    private Integer orderd;
    private String description;
    private Integer status;

    @Override
    public String toString() {
        return "tbBrand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", orderd=" + orderd +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getOrderd() {
        return orderd;
    }

    public void setOrderd(Integer orderd) {
        this.orderd = orderd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
