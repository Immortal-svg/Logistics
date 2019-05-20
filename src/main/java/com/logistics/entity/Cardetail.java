package com.logistics.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
public class Cardetail extends Model<Cardetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单号
     */
    @TableId(value = "detailID", type = IdType.INPUT)
    private String detailID;
    /**
     * 运输车辆编号
     */
    @TableField("transID")
    private Integer transID;
    /**
     * 件数
     */
    private BigDecimal gcount;
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
     * 发货地址
     */
    @TableField("startAddr")
    private String startAddr;
    /**
     * 收货地址
     */
    @TableField("endAddr")
    private String endAddr;
    /**
     * 发货单位
     */
    @TableField("sendCustID")
    private Integer sendCustID;
    /**
     * 收货单位
     */
    @TableField("receCustID")
    private Integer receCustID;
    /**
     * 收货人
     */
    @TableField("recePerson")
    private String recePerson;
    /**
     * 电话
     */
    private String phone;
    /**
     * 货物名称
     */
    @TableField("goodsName")
    private String goodsName;
    /**
     * 包装
     */
    @TableField("unitName")
    private String unitName;
    /**
     * 保险
     */
    @TableField("insuranceFee")
    private BigDecimal insuranceFee;
    /**
     * 其他费用
     */
    @TableField("otherFee")
    private BigDecimal otherFee;
    /**
     * 随货通行
     */
    @TableField("sendGoods")
    private String sendGoods;
    /**
     * 结算方式
     */
    @TableField("paidID")
    private Integer paidID;
    /**
     * 是否发货
     */
    @TableField("orderID")
    private String orderID;
    /**
     * 是否结算
     */
    @TableField("paidStuats")
    private String paidStuats;
    /**
     * 运输费
     */
    @TableField("sendFee")
    private BigDecimal sendFee;
    /**
     * 费用
     */
    @TableField("faceFee")
    private BigDecimal faceFee;
    /**
     * 托运日期
     */
    @TableField("sendTime")
    private Date sendTime;
    /**
     * 操作日期
     */
    @TableField("oprTime")
    private Date oprTime;
    /**
     * 用户名
     */
    @TableField("userID")
    private Integer userID;
    /**
     * 补充说明
     */
    private String demo;

    //汽车
    @TableField(exist = false)
    private  Car car;
    //发货单位
    @TableField(exist = false)
    private Customer sendCustname;
    //receCustID收货单位
    @TableField(exist = false)
    private  Customer receCustname;
   //出发地
    @TableField(exist = false)
    private Area areasendCityName;
    //收货地
    @TableField(exist = false)
    private Area areareceCityname;


    public void setAreasendCityName(Area areasendCityName) {
        this.areasendCityName = areasendCityName;
    }

    public void setAreareceCityname(Area areareceCityname) {
        this.areareceCityname = areareceCityname;
    }

    public Area getAreasendCityName() {
        return areasendCityName;
    }

    public Area getAreareceCityname() {
        return areareceCityname;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setSendCustname(Customer sendCustname) {
        this.sendCustname = sendCustname;
    }

    public void setReceCustname(Customer receCustname) {
        this.receCustname = receCustname;
    }

    public Car getCar() {
        return car;
    }

    public Customer getSendCustname() {
        return sendCustname;
    }

    public Customer getReceCustname() {
        return receCustname;
    }

    public String getDetailID() {
        return detailID;
    }

    public void setDetailID(String detailID) {
        this.detailID = detailID;
    }

    public Integer getTransID() {
        return transID;
    }

    public void setTransID(Integer transID) {
        this.transID = transID;
    }

    public BigDecimal getGcount() {
        return gcount;
    }

    public void setGcount(BigDecimal gcount) {
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

    public String getStartAddr() {
        return startAddr;
    }

    public void setStartAddr(String startAddr) {
        this.startAddr = startAddr;
    }

    public String getEndAddr() {
        return endAddr;
    }

    public void setEndAddr(String endAddr) {
        this.endAddr = endAddr;
    }

    public Integer getSendCustID() {
        return sendCustID;
    }

    public void setSendCustID(Integer sendCustID) {
        this.sendCustID = sendCustID;
    }

    public Integer getReceCustID() {
        return receCustID;
    }

    public void setReceCustID(Integer receCustID) {
        this.receCustID = receCustID;
    }

    public String getRecePerson() {
        return recePerson;
    }

    public void setRecePerson(String recePerson) {
        this.recePerson = recePerson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public BigDecimal getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(BigDecimal insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public BigDecimal getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(BigDecimal otherFee) {
        this.otherFee = otherFee;
    }

    public String getSendGoods() {
        return sendGoods;
    }

    public void setSendGoods(String sendGoods) {
        this.sendGoods = sendGoods;
    }

    public Integer getPaidID() {
        return paidID;
    }

    public void setPaidID(Integer paidID) {
        this.paidID = paidID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getPaidStuats() {
        return paidStuats;
    }

    public void setPaidStuats(String paidStuats) {
        this.paidStuats = paidStuats;
    }

    public BigDecimal getSendFee() {
        return sendFee;
    }

    public void setSendFee(BigDecimal sendFee) {
        this.sendFee = sendFee;
    }

    public BigDecimal getFaceFee() {
        return faceFee;
    }

    public void setFaceFee(BigDecimal faceFee) {
        this.faceFee = faceFee;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getOprTime() {
        return oprTime;
    }

    public void setOprTime(Date oprTime) {
        this.oprTime = oprTime;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    @Override
    protected Serializable pkVal() {
        return this.detailID;
    }

    @Override
    public String toString() {
        return "Cardetail{" +
        ", detailID=" + detailID +
        ", transID=" + transID +
        ", gcount=" + gcount +
        ", sendCity=" + sendCity +
        ", receCity=" + receCity +
        ", startAddr=" + startAddr +
        ", endAddr=" + endAddr +
        ", sendCustID=" + sendCustID +
        ", receCustID=" + receCustID +
        ", recePerson=" + recePerson +
        ", phone=" + phone +
        ", goodsName=" + goodsName +
        ", unitName=" + unitName +
        ", insuranceFee=" + insuranceFee +
        ", otherFee=" + otherFee +
        ", sendGoods=" + sendGoods +
        ", paidID=" + paidID +
        ", orderID=" + orderID +
        ", paidStuats=" + paidStuats +
        ", sendFee=" + sendFee +
        ", faceFee=" + faceFee +
        ", sendTime=" + sendTime +
        ", oprTime=" + oprTime +
        ", userID=" + userID +
        ", demo=" + demo +
        "}";
    }
}
