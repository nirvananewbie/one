package com.xs.one.business.domain.entity;

import com.xs.one.core.utils.StringAndEqualsObject;

import java.io.Serializable;

/**
 * @ClassName: TUser
* @Description: t_user表对应的java bean类
* @author: peiyu
 */
public class TUser extends StringAndEqualsObject implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields t_user.id :
     */
    private String id;

    /**
     * @Fields t_user.name :
     */
    private String name;

    /**
     * @return t_user.id : 返回 
     */
    public String getId() {
        return id;
    }

    /**
     * @param id of t_user : 设置 
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return t_user.name : 返回 
     */
    public String getName() {
        return name;
    }

    /**
     * @param name of t_user : 设置 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}