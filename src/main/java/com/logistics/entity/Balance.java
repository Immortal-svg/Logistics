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
public class Balance extends Model<Balance> {

    private static final long serialVersionUID = 1L;

    /**
     * 账目编号
     */
    @TableId(value = "balanceID", type = IdType.AUTO)
    private Integer balanceID;
    /**
     * 客户名称
     */
    @TableField("customerID")
    private Integer customerID;
    /**
     * 收付款金额
     */
    @TableField("faceFee")
    private BigDecimal faceFee;
    /**
     * 收付款类别
     */
    @TableField("paidType")
    private String paidType;
    /**
     * 付款起始时间
     */
    @TableField("paidTime")
    private Date paidTime;
    /**
     * 付款结算时间
     */
    @TableField("oprTime")
    private Date oprTime;
    /**
     * 操作用户
     */
    @TableField("userID")
    private Integer userID;
    /**
     * 是否有效
     */
    @TableField("isvalID")
    private String isvalID;
    /**
     * 其他说明
     */
    private String demo;

    @TableField(exist = false)
    private  Customer customer;

    @TableField(exist = false)
    private Users users;




    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Users getUsers() {
        return users;
    }

    public Integer getBalanceID() {
        return balanceID;
    }

    public void setBalanceID(Integer balanceID) {
        this.balanceID = balanceID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public BigDecimal getFaceFee() {
        return faceFee;
    }

    public void setFaceFee(BigDecimal faceFee) {
        this.faceFee = faceFee;
    }

    public String getPaidType() {
        return paidType;
    }

    public void setPaidType(String paidType) {
        this.paidType = paidType;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
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

    public String getIsvalID() {
        return isvalID;
    }

    public void setIsvalID(String isvalID) {
        this.isvalID = isvalID;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    @Override
    protected Serializable pkVal() {
        return this.balanceID;
    }

    @Override
    public String toString() {
        return "Balance{" +
        ", balanceID=" + balanceID +
        ", customerID=" + customerID +
        ", faceFee=" + faceFee +
        ", paidType=" + paidType +
        ", paidTime=" + paidTime +
        ", oprTime=" + oprTime +
        ", userID=" + userID +
        ", isvalID=" + isvalID +
        ", demo=" + demo +
        "}";
    }
}
