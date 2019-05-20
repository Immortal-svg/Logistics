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
public class Users extends Model<Users> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    @TableField("userName")
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 区域
     */
    @TableField("areaID")
    private Integer areaID;
    /**
     * 部门名称
     */
    @TableField("depName")
    private String depName;
    /**
     * 工作岗位
     */
    @TableField("deGree")
    private String deGree;
    /**
     * 联系电弧
     */
    private String mobile;
    /**
     * 地址
     */
    private String addr;
    /**
     * 状态
     */
    private Integer staus;
    /**
     * 公司名称
     */
    @TableField("companyName")
    private String companyName;
    /**
     * 备注
     */
    private String demo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAreaID() {
        return areaID;
    }

    public void setAreaID(Integer areaID) {
        this.areaID = areaID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDeGree() {
        return deGree;
    }

    public void setDeGree(String deGree) {
        this.deGree = deGree;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getStaus() {
        return staus;
    }

    public void setStaus(Integer staus) {
        this.staus = staus;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Users{" +
        ", id=" + id +
        ", userName=" + userName +
        ", password=" + password +
        ", areaID=" + areaID +
        ", depName=" + depName +
        ", deGree=" + deGree +
        ", mobile=" + mobile +
        ", addr=" + addr +
        ", staus=" + staus +
        ", companyName=" + companyName +
        ", demo=" + demo +
        "}";
    }
}
