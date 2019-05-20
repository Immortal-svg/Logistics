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
public class Sendtype extends Model<Sendtype> {

    private static final long serialVersionUID = 1L;

    /**
     * 运输工具编号
     */
    @TableId(value = "sendTypeID", type = IdType.AUTO)
    private Integer sendTypeID;
    /**
     * 运输工具名称
     */
    @TableField("sendTypeName")
    private String sendTypeName;


    public Integer getSendTypeID() {
        return sendTypeID;
    }

    public void setSendTypeID(Integer sendTypeID) {
        this.sendTypeID = sendTypeID;
    }

    public String getSendTypeName() {
        return sendTypeName;
    }

    public void setSendTypeName(String sendTypeName) {
        this.sendTypeName = sendTypeName;
    }

    @Override
    protected Serializable pkVal() {
        return this.sendTypeID;
    }

    @Override
    public String toString() {
        return "Sendtype{" +
        ", sendTypeID=" + sendTypeID +
        ", sendTypeName=" + sendTypeName +
        "}";
    }
}
