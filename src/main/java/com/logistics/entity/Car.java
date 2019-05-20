package com.logistics.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
public class Car extends Model<Car> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "carID", type = IdType.AUTO)
    private Integer carID;
    /**
     * 车牌号
     */
    @TableField("cardNo")
    private String cardNo;
    /**
     * 车主姓名
     */
    @TableField("carName")
    private String carName;
    /**
     * 型号
     */
    private String model;
    /**
     * 公司名称（客户名称）
     */
    @TableField("customerID")
    private Integer customerID;
    /**
     * 联系电话
     */
    private String mobile;
    /**
     * 联系人
     */
    private String contact;
    /**
     * QQ号码
     */
    private String qq;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 所在地区
     */
    @TableField("areaID")
    private Integer areaID;
    /**
     * 车辆状态
     */
    private String status;
    /**
     * 备注
     */
    private String demo;

    //公司名称
    @TableField(exist = false)
    private Customer customer;
    //所属城市
    @TableField(exist = false)
    private Area area;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Area getArea() {
        return area;
    }

    public Integer getCarID() {
        return carID;
    }

    public void setCarID(Integer carID) {
        this.carID = carID;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAreaID() {
        return areaID;
    }

    public void setAreaID(Integer areaID) {
        this.areaID = areaID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    @Override
    protected Serializable pkVal() {
        return this.carID;
    }

    @Override
    public String toString() {
        return "Car{" +
        ", carID=" + carID +
        ", cardNo=" + cardNo +
        ", carName=" + carName +
        ", model=" + model +
        ", customerID=" + customerID +
        ", mobile=" + mobile +
        ", contact=" + contact +
        ", qq=" + qq +
        ", email=" + email +
        ", areaID=" + areaID +
        ", status=" + status +
        ", demo=" + demo +
        "}";
    }
}
