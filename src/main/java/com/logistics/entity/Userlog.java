package com.logistics.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
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
public class Userlog extends Model<Userlog> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    @TableField("userID")
    private Integer userID;
    /**
     * IP地址
     */
    @TableField("ipAddr")
    private String ipAddr;
    /**
     * 操作时间
     */
    @TableField("oprTime")
    private Date oprTime;
    /**
     * 信息
     */
    private String msg;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Date getOprTime() {
        return oprTime;
    }

    public void setOprTime(Date oprTime) {
        this.oprTime = oprTime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Userlog{" +
        ", id=" + id +
        ", userID=" + userID +
        ", ipAddr=" + ipAddr +
        ", oprTime=" + oprTime +
        ", msg=" + msg +
        "}";
    }
}
