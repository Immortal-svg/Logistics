package com.logistics.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
public class Carroad extends Model<Carroad> {

    private static final long serialVersionUID = 1L;

    /**
     * 线路编号
     */
    @TableId(value = "roadID", type = IdType.AUTO)
    private Integer roadID;
    /**
     * 运输车辆编号
     */
    @TableField("transID")
    private Integer transID;
    /**
     * 出发站
     */
    @TableField("startCity")
    private Integer startCity;
    /**
     * 出发时间
     */
    @TableField("startTime")
    private Date startTime;
    /**
     * 到达站
     */
    @TableField("endCity")
    private Integer endCity;
    /**
     * 到达时间
     */
    @TableField("endTime")
    private Date endTime;

    //车辆
     @TableField(exist =  false)
     private Transcar transcar;
     //
     @TableField(exist =  false)
     private Car car;
    @TableField(exist =  false)
    private Area  strCityName;
    @TableField(exist =  false)
    private Area endCityName;


    public void setTranscar(Transcar transcar) {
        this.transcar = transcar;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setStrCityName(Area strCityName) {
        this.strCityName = strCityName;
    }

    public void setEndCityName(Area endCityName) {
        this.endCityName = endCityName;
    }

    public Transcar getTranscar() {
        return transcar;
    }

    public Car getCar() {
        return car;
    }

    public Area getStrCityName() {
        return strCityName;
    }

    public Area getEndCityName() {
        return endCityName;
    }

    public Integer getRoadID() {
        return roadID;
    }

    public void setRoadID(Integer roadID) {
        this.roadID = roadID;
    }

    public Integer getTransID() {
        return transID;
    }

    public void setTransID(Integer transID) {
        this.transID = transID;
    }

    public Integer getStartCity() {
        return startCity;
    }

    public void setStartCity(Integer startCity) {
        this.startCity = startCity;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getEndCity() {
        return endCity;
    }

    public void setEndCity(Integer endCity) {
        this.endCity = endCity;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.roadID;
    }

    @Override
    public String toString() {
        return "Carroad{" +
        ", roadID=" + roadID +
        ", transID=" + transID +
        ", startCity=" + startCity +
        ", startTime=" + startTime +
        ", endCity=" + endCity +
        ", endTime=" + endTime +
        "}";
    }
}
