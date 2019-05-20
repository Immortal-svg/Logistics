package com.logistics.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
public class Accmodule extends Model<Accmodule> {

    private static final long serialVersionUID = 1L;

    /**
     * 访问模块编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    @TableField("userID")
    private Integer userID;
    /**
     * 模块编号
     */
    @TableField("moduleID")
    private Integer moduleID;

    @TableField(exist = false)
    private Module module;
    @TableField(exist = false)
    private Users users;


    public void setModule(Module module) {
        this.module = module;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Module getModule() {
        return module;
    }

    public Users getUsers() {
        return users;
    }

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

    public Integer getModuleID() {
        return moduleID;
    }

    public void setModuleID(Integer moduleID) {
        this.moduleID = moduleID;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Accmodule{" +
        ", id=" + id +
        ", userID=" + userID +
        ", moduleID=" + moduleID +
        "}";
    }
}
