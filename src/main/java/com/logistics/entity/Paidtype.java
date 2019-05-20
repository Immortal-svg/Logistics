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
public class Paidtype extends Model<Paidtype> {

    private static final long serialVersionUID = 1L;

    /**
     * 付款方式编号
     */
    @TableId(value = "paidID", type = IdType.AUTO)
    private Integer paidID;
    /**
     * 付款方式名称
     */
    @TableField("paidName")
    private String paidName;


    public Integer getPaidID() {
        return paidID;
    }

    public void setPaidID(Integer paidID) {
        this.paidID = paidID;
    }

    public String getPaidName() {
        return paidName;
    }

    public void setPaidName(String paidName) {
        this.paidName = paidName;
    }

    @Override
    protected Serializable pkVal() {
        return this.paidID;
    }

    @Override
    public String toString() {
        return "Paidtype{" +
        ", paidID=" + paidID +
        ", paidName=" + paidName +
        "}";
    }
}
