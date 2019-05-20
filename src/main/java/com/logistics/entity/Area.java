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
public class Area extends Model<Area> {

    private static final long serialVersionUID = 1L;

    /**
     * 区域编号
     */
    @TableId(value = "areaID", type = IdType.AUTO)
    private Integer areaID;
    /**
     * 区域名称
     */
    @TableField("areaName")
    private String areaName;


    public Integer getAreaID() {
        return areaID;
    }

    public void setAreaID(Integer areaID) {
        this.areaID = areaID;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    protected Serializable pkVal() {
        return this.areaID;
    }

    @Override
    public String toString() {
        return "Area{" +
        ", areaID=" + areaID +
        ", areaName=" + areaName +
        "}";
    }
}
