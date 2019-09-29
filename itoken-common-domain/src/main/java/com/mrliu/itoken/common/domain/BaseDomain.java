package com.mrliu.itoken.common.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.common.domain
 * @Description: 领域模型的基类
 * @Author: LLT
 * @Date: 2019/6/3 13:20
 * @UpdateRemark: 更新说明
 */
@Getter
@Setter
public class BaseDomain implements Serializable {

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 扩展 String 1
     */
    @Column(name = "extend_s1")
    private String extendS1;

    /**
     * 扩展 String 2
     */
    @Column(name = "extend_s2")
    private String extendS2;

    /**
     * 扩展 String 3
     */
    @Column(name = "extend_s3")
    private String extendS3;

    /**
     * 扩展 String 4
     */
    @Column(name = "extend_s4")
    private String extendS4;

    /**
     * 扩展 String 5
     */
    @Column(name = "extend_s5")
    private String extendS5;

    /**
     * 扩展 String 6
     */
    @Column(name = "extend_s6")
    private String extendS6;

    /**
     * 扩展 String 7
     */
    @Column(name = "extend_s7")
    private String extendS7;

    /**
     * 扩展 String 8
     */
    @Column(name = "extend_s8")
    private String extendS8;

    /**
     * 扩展 Integer 1
     */
    @Column(name = "extend_i1")
    private BigDecimal extendI1;

    /**
     * 扩展 Integer 2
     */
    @Column(name = "extend_i2")
    private BigDecimal extendI2;

    /**
     * 扩展 Integer 3
     */
    @Column(name = "extend_i3")
    private BigDecimal extendI3;

    /**
     * 扩展 Integer 4
     */
    @Column(name = "extend_i4")
    private BigDecimal extendI4;

    /**
     * 扩展 Float 1
     */
    @Column(name = "extend_f1")
    private BigDecimal extendF1;

    /**
     * 扩展 Float 2
     */
    @Column(name = "extend_f2")
    private BigDecimal extendF2;

    /**
     * 扩展 Float 3
     */
    @Column(name = "extend_f3")
    private BigDecimal extendF3;

    /**
     * 扩展 Float 4
     */
    @Column(name = "extend_f4")
    private BigDecimal extendF4;

    /**
     * 扩展 Date 1
     */
    @Column(name = "extend_d1")
    private Date extendD1;

    /**
     * 扩展 Date 2
     */
    @Column(name = "extend_d2")
    private Date extendD2;

    /**
     * 扩展 Date 3
     */
    @Column(name = "extend_d3")
    private Date extendD3;

    /**
     * 扩展 Date 4
     */
    @Column(name = "extend_d4")
    private Date extendD4;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getExtendS1() {
        return extendS1;
    }

    public void setExtendS1(String extendS1) {
        this.extendS1 = extendS1;
    }

    public String getExtendS2() {
        return extendS2;
    }

    public void setExtendS2(String extendS2) {
        this.extendS2 = extendS2;
    }

    public String getExtendS3() {
        return extendS3;
    }

    public void setExtendS3(String extendS3) {
        this.extendS3 = extendS3;
    }

    public String getExtendS4() {
        return extendS4;
    }

    public void setExtendS4(String extendS4) {
        this.extendS4 = extendS4;
    }

    public String getExtendS5() {
        return extendS5;
    }

    public void setExtendS5(String extendS5) {
        this.extendS5 = extendS5;
    }

    public String getExtendS6() {
        return extendS6;
    }

    public void setExtendS6(String extendS6) {
        this.extendS6 = extendS6;
    }

    public String getExtendS7() {
        return extendS7;
    }

    public void setExtendS7(String extendS7) {
        this.extendS7 = extendS7;
    }

    public String getExtendS8() {
        return extendS8;
    }

    public void setExtendS8(String extendS8) {
        this.extendS8 = extendS8;
    }

    public BigDecimal getExtendI1() {
        return extendI1;
    }

    public void setExtendI1(BigDecimal extendI1) {
        this.extendI1 = extendI1;
    }

    public BigDecimal getExtendI2() {
        return extendI2;
    }

    public void setExtendI2(BigDecimal extendI2) {
        this.extendI2 = extendI2;
    }

    public BigDecimal getExtendI3() {
        return extendI3;
    }

    public void setExtendI3(BigDecimal extendI3) {
        this.extendI3 = extendI3;
    }

    public BigDecimal getExtendI4() {
        return extendI4;
    }

    public void setExtendI4(BigDecimal extendI4) {
        this.extendI4 = extendI4;
    }

    public BigDecimal getExtendF1() {
        return extendF1;
    }

    public void setExtendF1(BigDecimal extendF1) {
        this.extendF1 = extendF1;
    }

    public BigDecimal getExtendF2() {
        return extendF2;
    }

    public void setExtendF2(BigDecimal extendF2) {
        this.extendF2 = extendF2;
    }

    public BigDecimal getExtendF3() {
        return extendF3;
    }

    public void setExtendF3(BigDecimal extendF3) {
        this.extendF3 = extendF3;
    }

    public BigDecimal getExtendF4() {
        return extendF4;
    }

    public void setExtendF4(BigDecimal extendF4) {
        this.extendF4 = extendF4;
    }

    public Date getExtendD1() {
        return extendD1;
    }

    public void setExtendD1(Date extendD1) {
        this.extendD1 = extendD1;
    }

    public Date getExtendD2() {
        return extendD2;
    }

    public void setExtendD2(Date extendD2) {
        this.extendD2 = extendD2;
    }

    public Date getExtendD3() {
        return extendD3;
    }

    public void setExtendD3(Date extendD3) {
        this.extendD3 = extendD3;
    }

    public Date getExtendD4() {
        return extendD4;
    }

    public void setExtendD4(Date extendD4) {
        this.extendD4 = extendD4;
    }
}
