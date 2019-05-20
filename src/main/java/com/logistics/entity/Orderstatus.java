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
public class Orderstatus extends Model<Orderstatus> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单状态编号
     */
    @TableId(value = "orderID", type = IdType.AUTO)
    private Integer orderID;
    /**
     * 订单状态名称
     */
    @TableField("orderName")
    private String orderName;


    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    protected Serializable pkVal() {
        return this.orderID;
    }

    @Override
    public String toString() {
        return "Orderstatus{" +
        ", orderID=" + orderID +
        ", orderName=" + orderName +
        "}";
    }
}
