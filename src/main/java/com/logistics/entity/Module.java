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
public class Module extends Model<Module> {

    private static final long serialVersionUID = 1L;

    /**
     * 模块编号
     */
    @TableId(value = "moduleID", type = IdType.AUTO)
    private Integer moduleID;
    /**
     * 模块名称
     */
    @TableField("moduleName")
    private String moduleName;
    /**
     * 模块类型
     */
    @TableField("className")
    private String className;
    /**
     * 操作方法
     */
    private String moethod;


    public Integer getModuleID() {
        return moduleID;
    }

    public void setModuleID(Integer moduleID) {
        this.moduleID = moduleID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMoethod() {
        return moethod;
    }

    public void setMoethod(String moethod) {
        this.moethod = moethod;
    }

    @Override
    protected Serializable pkVal() {
        return this.moduleID;
    }

    @Override
    public String toString() {
        return "Module{" +
        ", moduleID=" + moduleID +
        ", moduleName=" + moduleName +
        ", className=" + className +
        ", moethod=" + moethod +
        "}";
    }
}
