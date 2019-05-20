package com.logistics.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;
import  java.lang.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
public class Transcar extends Model<Transcar> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "transID", type = IdType.AUTO)
    private Integer transID;
    /**
     * 车票号
     */
    @TableField("carID")
    private Integer carID;
    /**
     * 装车数量
     */
    private Integer gcount;
    /**
     * 出发地
     */
    @TableField("sendCity")
    private Integer sendCity;
    /**
     * 目的地
     */
    @TableField("receCity")
    private Integer receCity;
    /**
     * 司机姓名
     */
    private String driver;
    /**
     * 司机电话
     */
    @TableField("driverTel")
    private String driverTel;
    /**
     * 负责人
     */
    private String master;
    /**
     * 负责人电话
     */
    @TableField("masterTel")
    private String masterTel;
    /**
     * 运输工具
     */
    @TableField("sendTypeID")
    private Integer sendTypeID;
    /**
     * 发车时间
     */
    @TableField("sendTime")
    private Date sendTime;
    /**
     * 运输收入
     */
    @TableField("sendFee")
    private Integer sendFee;
    /**
     * 运输成本
     */
    @TableField("carFee")
    private Integer carFee;
    /**
     * 车辆状态
     */
    @TableField("carStatus")
    private String carStatus;
    /**
     * 备注
     */
    private String demo;

    /**
     * 车辆编号
     */
    @TableField(exist = false)
    private  Car car;
    //出发地
    @TableField(exist = false)
    private Area  areasendName;
    //目的地
     @TableField(exist = false)
     private  Area arereceCity;
     //运输工具
    @TableField(exist = false)
    private  Sendtype sendtype;

    public void setSendtype(Sendtype sendtype) {
        this.sendtype = sendtype;
    }

    public Sendtype getSendtype() {
        return sendtype;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setAreasendName(Area areasendName) {
        this.areasendName = areasendName;
    }

    public void setArereceCity(Area arereceCity) {
        this.arereceCity = arereceCity;
    }

    public Car getCar() {
        return car;
    }

    public Area getAreasendName() {
        return areasendName;
    }

    public Area getArereceCity() {
        return arereceCity;
    }

    public Integer getTransID() {
        return transID;
    }

    public void setTransID(Integer transID) {
        this.transID = transID;
    }

    public Integer getCarID() {
        return carID;
    }

    public void setCarID(Integer carID) {
        this.carID = carID;
    }

    public Integer getGcount() {
        return gcount;
    }

    public void setGcount(Integer gcount) {
        this.gcount = gcount;
    }

    public Integer getSendCity() {
        return sendCity;
    }

    public void setSendCity(Integer sendCity) {
        this.sendCity = sendCity;
    }

    public Integer getReceCity() {
        return receCity;
    }

    public void setReceCity(Integer receCity) {
        this.receCity = receCity;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDriverTel() {
        return driverTel;
    }

    public void setDriverTel(String driverTel) {
        this.driverTel = driverTel;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getMasterTel() {
        return masterTel;
    }

    public void setMasterTel(String masterTel) {
        this.masterTel = masterTel;
    }

    public Integer getSendTypeID() {
        return sendTypeID;
    }

    public void setSendTypeID(Integer sendTypeID) {
        this.sendTypeID = sendTypeID;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getSendFee() {
        return sendFee;
    }

    public void setSendFee(Integer sendFee) {
        this.sendFee = sendFee;
    }

    public Integer getCarFee() {
        return carFee;
    }

    public void setCarFee(Integer carFee) {
        this.carFee = carFee;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    @Override
    protected Serializable pkVal() {
        return this.transID;
    }

    @Override
    public String toString() {
        return "Transcar{" +
        ", transID=" + transID +
        ", carID=" + carID +
        ", gcount=" + gcount +
        ", sendCity=" + sendCity +
        ", receCity=" + receCity +
        ", driver=" + driver +
        ", driverTel=" + driverTel +
        ", master=" + master +
        ", masterTel=" + masterTel +
        ", sendTypeID=" + sendTypeID +
        ", sendTime=" + sendTime +
        ", sendFee=" + sendFee +
        ", carFee=" + carFee +
        ", carStatus=" + carStatus +
        ", demo=" + demo +
        "}";
    }
}
