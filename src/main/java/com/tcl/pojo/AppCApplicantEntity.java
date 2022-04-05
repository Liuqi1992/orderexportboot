package com.tcl.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wang on 2017-06-14.
 */
@Entity
@Table(name = "app_c_applicant", schema = "", catalog = "tclapp")
public class AppCApplicantEntity {
    private long id;
    private long userId;
    private String applyName;
    private String phone;
    private String address;
    private String sex;
    private Integer age;
    private Integer isDefalt;
    private String status;
    private Date createTime;
    private Date modifyTime;
    private String sfzNum;

    @Basic
    @Column(name = "sfz_num")
    public String getSfzNum() {
        return sfzNum;
    }

    public void setSfzNum(String sfzNum) {
        this.sfzNum = sfzNum;
    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "apply_name")
    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }
    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @Basic
    @Column(name = "is_defalt")
    public Integer getIsDefalt() {
        return isDefalt;
    }

    public void setIsDefalt(Integer isDefalt) {
        this.isDefalt = isDefalt;
    }

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "modify_time")
    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppCApplicantEntity that = (AppCApplicantEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (applyName != null ? !applyName.equals(that.applyName) : that.applyName != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (modifyTime != null ? !modifyTime.equals(that.modifyTime) : that.modifyTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (applyName != null ? applyName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (modifyTime != null ? modifyTime.hashCode() : 0);
        return result;
    }
}
