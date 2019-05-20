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
public class Customertype extends Model<Customertype> {

    private static final long serialVersionUID = 1L;

    /**
     * 客户类型编号
     */
    @TableId(value = "customerTypeID", type = IdType.AUTO)
    private Integer customerTypeID;
    /**
     * 客户类型名称
     */
    @TableField("customerTypeName")
    private String customerTypeName;


    public Integer getCustomerTypeID() {
        return customerTypeID;
    }

    public void setCustomerTypeID(Integer customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    @Override
    protected Serializable pkVal() {
        return this.customerTypeID;
    }

    @Override
    public String toString() {
        return "Customertype{" +
        ", customerTypeID=" + customerTypeID +
        ", customerTypeName=" + customerTypeName +
        "}";
    }
}
