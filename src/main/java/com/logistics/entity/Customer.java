package com.logistics.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
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
public class Customer extends Model<Customer> {

    private static final long serialVersionUID = 1L;

    /**
     * 客户编号
     */
    @TableId(value = "customerID", type = IdType.AUTO)
    private Integer customerID;
    /**
     * 客户名称
     */
    @TableField("customerName")
    private String customerName;
    /**
     * 联系人
     */
    @TableField("contactName")
    private String contactName;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 结算方式
     */
    @TableField("paidID")
    private Integer paidID;
    /**
     * 地址
     */
    private String addr;
    /**
     * 所在区域
     */
    @TableField("areaID")
    private Integer areaID;
    /**
     * 客户类型
     */
    @TableField("customerTypeID")
    private Integer customerTypeID;
    /**
     * 应收金额
     */
    @TableField("factMoney")
    private BigDecimal factMoney;
    /**
     * 应付金额
     */
    @TableField("paidMoney")
    private BigDecimal paidMoney;

    @TableField(exist = false)
    private Paidtype paidtype;

    @TableField(exist = false)
    private Area area;

    @TableField(exist = false)
    private  Customertype customertype;


    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPaidID() {
        return paidID;
    }

    public void setPaidID(Integer paidID) {
        this.paidID = paidID;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getAreaID() {
        return areaID;
    }

    public void setAreaID(Integer areaID) {
        this.areaID = areaID;
    }

    public Integer getCustomerTypeID() {
        return customerTypeID;
    }

    public void setCustomerTypeID(Integer customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

    public BigDecimal getFactMoney() {
        return factMoney;
    }

    public void setFactMoney(BigDecimal factMoney) {
        this.factMoney = factMoney;
    }

    public BigDecimal getPaidMoney() {
        return paidMoney;
    }

    public void setPaidMoney(BigDecimal paidMoney) {
        this.paidMoney = paidMoney;
    }

    @Override
    protected Serializable pkVal() {
        return this.customerID;
    }

    public Paidtype getPaidtype() {
        return paidtype;
    }

    public Area getArea() {
        return area;
    }

    public Customertype getCustomertype() {
        return customertype;
    }

    public void setPaidtype(Paidtype paidtype) {
        this.paidtype = paidtype;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setCustomertype(Customertype customertype) {
        this.customertype = customertype;
    }

    @Override
    public String toString() {
        return "Customer{" +
        ", customerID=" + customerID +
        ", customerName=" + customerName +
        ", contactName=" + contactName +
        ", phone=" + phone +
        ", paidID=" + paidID +
        ", addr=" + addr +
        ", areaID=" + areaID +
        ", customerTypeID=" + customerTypeID +
        ", factMoney=" + factMoney +
        ", paidMoney=" + paidMoney +
        "}";
    }
}
