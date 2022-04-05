package com.order.vo;

import java.util.Date;

/**
 * Created by wang on 2017-06-20.
 */
public class ApplicantVo {

    private long id;
    private long userId;
    private String applyName;
    private String phone;
    private String address;
    private String sex;
    private Integer age;
    private Integer isDefalt;
    private Date createTime;
    private Date modifyTime;
    private String sfzNum;

    private String name;
    private Integer num;

    public String getSfzNum() {
        return sfzNum;
    }

    public void setSfzNum(String sfzNum) {
        this.sfzNum = sfzNum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getIsDefalt() {
        return isDefalt;
    }

    public void setIsDefalt(Integer isDefalt) {
        this.isDefalt = isDefalt;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
