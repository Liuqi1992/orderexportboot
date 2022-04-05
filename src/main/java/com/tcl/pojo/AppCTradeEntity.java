package com.tcl.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by wang on 2017-06-12.
 */
@Entity
@Table(name = "app_c_trade", schema = "", catalog = "tclapp")
public class AppCTradeEntity {
    private long id;
    private Long userId;
    private Long applicantId;
    private String tradeNum;//
    private String status; //0已下单，1已付款，2已开医嘱，3检验中，4已报告
    private Date createTime;
    private Date payTime;
    private Date modifyTime;
    private Long price;
    private Integer num;
    private String name;
    private Long doctorId;
    private String doctorName;
    private Long hospitalId;
    private String hospitalName;
    private Integer payType;
    private Date orderedTime;//预约时间
    private String yzDoctorId;//yz_doctor_id;
    private String yzDoctorNum;//yz_doctor_num;
    private String yzDoctorName;//yz_doctor_name;
    private String yzDepartmentNum;//yz_department_num;
    private String yzDepartmentName;//yz_department_name;
    private Date yzTime;//yz_time
    private String createType;
    private Long relationId;
    private String doctorMsg;
    private Integer needRead;
    private String payCode;//pay_code
    private String refuseReason;
    private String logStatus;
    private String isFromShulan;

    @Basic
    @GeneratedValue
    @Column(name = "yz_doctor_id")
    public String getYzDoctorId() {
        return yzDoctorId;
    }

    public void setYzDoctorId(String yzDoctorId) {
        this.yzDoctorId = yzDoctorId;
    }

    @Basic
    @Column(name = "yz_doctor_num")
    public String getYzDoctorNum() {
        return yzDoctorNum;
    }

    public void setYzDoctorNum(String yzDoctorNum) {
        this.yzDoctorNum = yzDoctorNum;
    }

    @Basic
    @Column(name = "yz_doctor_name")
    public String getYzDoctorName() {
        return yzDoctorName;
    }

    public void setYzDoctorName(String yzDoctorName) {
        this.yzDoctorName = yzDoctorName;
    }

    @Basic
    @Column(name = "yz_department_num")
    public String getYzDepartmentNum() {
        return yzDepartmentNum;
    }

    public void setYzDepartmentNum(String yzDepartmentNum) {
        this.yzDepartmentNum = yzDepartmentNum;
    }

    @Basic
    @Column(name = "yz_department_name")
    public String getYzDepartmentName() {
        return yzDepartmentName;
    }

    public void setYzDepartmentName(String yzDepartmentName) {
        this.yzDepartmentName = yzDepartmentName;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "applicant_id")
    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    @Basic
    @Column(name = "trade_num")
    public String getTradeNum() {
        return tradeNum;
    }

    public void setTradeNum(String tradeNum) {
        this.tradeNum = tradeNum;
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
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "pay_time")
    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    @Basic
    @Column(name = "modify_time")
    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Basic
    @Column(name = "price")
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Basic
    @Column(name = "num")
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "doctor_id")
    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "doctor_name")
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @Basic
    @Column(name = "hospital_id")
    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Basic
    @Column(name = "hospital_name")
    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    @Basic
    @Column(name = "pay_type")
    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    @Basic
    @Column(name = "ordered_time")
    public Date getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(Date orderedTime) {
        this.orderedTime = orderedTime;
    }

    @Basic
    @Column(name = "yz_time")
    public Date getYzTime() {
        return yzTime;
    }

    public void setYzTime(Date yzTime) {
        this.yzTime = yzTime;
    }

    @Basic
    @Column(name = "create_type")
    public String getCreateType() {
        return createType;
    }

    public void setCreateType(String createType) {
        this.createType = createType;
    }

    @Basic
    @Column(name = "relation_id")
    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    @Basic
    @Column(name = "doctor_msg")
    public String getDoctorMsg() {
        return doctorMsg;
    }

    public void setDoctorMsg(String doctorMsg) {
        this.doctorMsg = doctorMsg;
    }

    @Basic
    @Column(name = "need_read")
    public Integer getNeedRead() {
        return needRead;
    }

    public void setNeedRead(Integer needRead) {
        this.needRead = needRead;
    }

    @Basic
    @Column(name = "pay_code")
    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    @Basic
    @Column(name = "refuse_reason")
    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppCTradeEntity that = (AppCTradeEntity) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (tradeNum != null ? !tradeNum.equals(that.tradeNum) : that.tradeNum != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (payTime != null ? !payTime.equals(that.payTime) : that.payTime != null) return false;
        if (modifyTime != null ? !modifyTime.equals(that.modifyTime) : that.modifyTime != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (doctorId != null ? !doctorId.equals(that.doctorId) : that.doctorId != null) return false;
        if (doctorName != null ? !doctorName.equals(that.doctorName) : that.doctorName != null) return false;
        if (hospitalId != null ? !hospitalId.equals(that.hospitalId) : that.hospitalId != null) return false;
        if (hospitalName != null ? !hospitalName.equals(that.hospitalName) : that.hospitalName != null) return false;
        if (payType != null ? !payType.equals(that.payType) : that.payType != null) return false;
        if (refuseReason != null ? !refuseReason.equals(that.refuseReason) : that.refuseReason != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (tradeNum != null ? tradeNum.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (payTime != null ? payTime.hashCode() : 0);
        result = 31 * result + (modifyTime != null ? modifyTime.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (doctorId != null ? doctorId.hashCode() : 0);
        result = 31 * result + (doctorName != null ? doctorName.hashCode() : 0);
        result = 31 * result + (hospitalId != null ? hospitalId.hashCode() : 0);
        result = 31 * result + (hospitalName != null ? hospitalName.hashCode() : 0);
        result = 31 * result + (payType != null ? payType.hashCode() : 0);
        result = 31 * result + (refuseReason != null ? refuseReason.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "log_status")
    public String getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(String logStatus) {
        this.logStatus = logStatus;
    }

    @Basic
    @Column(name = "is_from_shulan")
    public String getIsFromShulan() {
        return isFromShulan;
    }

    public void setIsFromShulan(String isFromShulan) {
        this.isFromShulan = isFromShulan;
    }
}
